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

        Mat finalImage = removeBackground2(src);

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

    public Mat removeBackground1(Mat myImage) {
        // Suavize a imagem para reduzir o ruído
        Imgproc.GaussianBlur(myImage, myImage, new Size(5, 5), 0);

        // Crie uma escala de cinza de um único canal para thresholding
        Mat myImageGrey = new Mat();
        Imgproc.cvtColor(myImage, myImageGrey, Imgproc.COLOR_BGR2GRAY);

        // Realize o thresholding de Otsu e extraia o plano de fundo
        // Usamos o Threshold Binário, pois queremos criar um fundo totalmente branco
        Mat background = new Mat();
        Imgproc.threshold(myImageGrey, background, 0, 255, Imgproc.THRESH_BINARY + Imgproc.THRESH_OTSU);

        // Converta preto e branco de volta para 3 canais de escala de cinza
        Mat backgroundBGR = new Mat();
        Imgproc.cvtColor(background, backgroundBGR, Imgproc.COLOR_GRAY2BGR);

        // Realize o thresholding de Otsu e extraia o primeiro plano
        // Usamos TOZERO_INV, pois queremos manter alguns detalhes do primeiro plano
        Mat foreground = new Mat();
        Imgproc.threshold(myImageGrey, foreground, 0, 255, Imgproc.THRESH_TOZERO_INV + Imgproc.THRESH_OTSU);

        // Atualize o primeiro plano com bitwise_and para extrair o primeiro plano real
        Core.bitwise_and(myImage, myImage, foreground);

        // Combine o plano de fundo e o primeiro plano para obter a imagem final
        Mat finalImage = new Mat();
        Core.add(backgroundBGR, foreground, finalImage);


        return finalImage;
    }

    public Mat removeBackground2(Mat myImage) {
        // Suavize a imagem para reduzir o ruído
        Imgproc.GaussianBlur(myImage, myImage, new Size(5, 5), 0);

        // Converta para escala de cinza
        Mat myImageGrey = new Mat();
        Imgproc.cvtColor(myImage, myImageGrey, Imgproc.COLOR_BGR2GRAY);

        // Aplique o threshold adaptativo para extrair o plano de fundo
        Mat background = new Mat();
        Imgproc.adaptiveThreshold(myImageGrey, background, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 11, 2);

        // Converta preto e branco de volta para 3 canais de escala de cinza
        Mat backgroundBGR = new Mat();
        Imgproc.cvtColor(background, backgroundBGR, Imgproc.COLOR_GRAY2BGR);

        // Extraia o primeiro plano
        Mat foreground = new Mat();
        Core.bitwise_not(background, foreground); // Inverta o plano de fundo para obter o primeiro plano

        // Atualize o primeiro plano com bitwise_and para extrair o primeiro plano real
        Core.bitwise_and(myImage, myImage, foreground);

        // Combine o plano de fundo e o primeiro plano para obter a imagem final
        Mat finalImage = new Mat();
        Core.add(backgroundBGR, foreground, finalImage);

        return finalImage;
    }

}
