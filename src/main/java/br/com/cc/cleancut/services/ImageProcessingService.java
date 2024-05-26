package br.com.cc.cleancut.services;

import br.com.cc.cleancut.model.Image;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.core.CvType.CV_8UC3;

@Service
public class ImageProcessingService {

    static {
        nu.pattern.OpenCV.loadLocally();
    }

    public Image removeBackground(Image image){
        Mat src = byteToMat(image.getData());

        Mat finalImage = removeBackground(src);

        image.setData(matToByte(finalImage));
        return image;
    }

    private Mat byteToMat(byte[] bytes){
        Mat mat = new Mat();
        MatOfByte matOfByte = new MatOfByte(bytes);
        mat = Imgcodecs.imdecode(matOfByte, Imgcodecs.IMREAD_COLOR);
        return mat;
    }

    private byte[] matToByte(Mat mat){
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", mat, matOfByte);
        return matOfByte.toArray();
    }

    private Mat removeBackground(Mat myImage) {

        Mat myImageGrey = new Mat();
        Imgproc.cvtColor(myImage, myImageGrey, Imgproc.COLOR_BGR2GRAY);

        Mat baseline = new Mat();
        Imgproc.threshold(myImageGrey, baseline, 127, 255, Imgproc.THRESH_TRUNC);

        Mat background = new Mat();
        Imgproc.threshold(baseline, background, 126, 255, Imgproc.THRESH_BINARY);

        Mat foreground = new Mat();
        Imgproc.threshold(baseline, foreground, 126, 255, Imgproc.THRESH_BINARY_INV);


        Mat foregroundImage = new Mat();
        Core.bitwise_and(myImage, myImage, foregroundImage, foreground);


        Mat backgroundBGR = new Mat();
        Imgproc.cvtColor(background, backgroundBGR, Imgproc.COLOR_GRAY2BGR);

        Mat finalImage = new Mat();
        Core.add(backgroundBGR, foregroundImage, finalImage);

        return finalImage;
    }

}
