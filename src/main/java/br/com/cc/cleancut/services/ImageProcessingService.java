package br.com.cc.cleancut.services;

import br.com.cc.cleancut.model.Image;
import com.aspose.imaging.Color;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.masking.ImageMasking;
import com.aspose.imaging.masking.options.AutoMaskingGraphCutOptions;
import com.aspose.imaging.masking.options.SegmentationMethod;
import com.aspose.imaging.masking.result.MaskingResult;
import com.aspose.imaging.sources.FileCreateSource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Service
public class ImageProcessingService {

    public Image removeBackground(Image inputImage) {
        MaskingResult results;
        try {

            RasterImage asposeImage = convertToAsposeImage(inputImage.getData());


            AutoMaskingGraphCutOptions options = new AutoMaskingGraphCutOptions();

            options.setCalculateDefaultStrokes(true);

            options.setFeatheringRadius((Math.max(asposeImage.getWidth(), asposeImage.getHeight()) / 500) + 1);
            options.setMethod(SegmentationMethod.GraphCut);
            options.setDecompose(false);
            options.setBackgroundReplacementColor(Color.getTransparent());


            PngOptions exportOptions = new PngOptions();
            exportOptions.setColorType(PngColorType.TruecolorWithAlpha);
            exportOptions.setSource(new FileCreateSource("tempFile"));
            options.setExportOptions(exportOptions);

            results = new ImageMasking(asposeImage).decompose(options);


            try (RasterImage resultImage = results.get_Item(1).getImage()) {
                exportOptions = new PngOptions();
                exportOptions.setColorType(PngColorType.TruecolorWithAlpha);
                return convertToImage(resultImage, inputImage);
            }


        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
    }

    private RasterImage convertToAsposeImage(byte[] bytes) {
        try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
            return (RasterImage) com.aspose.imaging.Image.load(inputStream, new com.aspose.imaging.imageloadoptions.PngLoadOptions());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    private Image convertToImage(RasterImage rasterImage, Image image) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        rasterImage.save(outputStream);
        byte[] resultBytes = outputStream.toByteArray();
        image.setData(resultBytes);
        return image;
    }
}
