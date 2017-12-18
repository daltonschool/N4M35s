import lattelib.WebLatte;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;

class ImageBorderDemo {
    public static void main(String[] args) throws Exception {
        // Open a file and save as a BufferedImage (a 2D int array)
        File input = new File("pic.png");
        BufferedImage image = ImageIO.read(input);

        // Get some information about the 2D array
        System.out.println("Width:" + image.getWidth());
        System.out.println("Height:" + image.getHeight());

        // Create an integer to represent a black pixel
        int blackPixel = new Color(0,0,0).getRGB();
        System.out.println("The value rgb(0,0,0) became the int " + blackPixel);

        // Put the black pixel in top left corner.
        image.setRGB(0, 0, blackPixel);   // column, row, pixel value

        // Create a black square border around the image.
        // top/bottom borders
        for(int i=0; i < image.getWidth(); i++) {
            image.setRGB(i, 0, blackPixel);
            image.setRGB(i, image.getWidth()-1, blackPixel);
        }

        // left/right borders
        for(int i=0; i < image.getHeight(); i++) {
            image.setRGB(0, i, blackPixel);
            image.setRGB(image.getHeight()-1, i, blackPixel);
        }

        // Create a new file so we don't mess up the original
        File output = new File(input.getName().replace(".png", "") + "_border.png");
        ImageIO.write(image, "PNG", output);
        System.out.println("Created file at " + output.getAbsolutePath());

        //draw:
        WebLatte frame = new WebLatte();
        frame.drawImage(input.getName(), 0, 0 , 100, 100, 0);
        frame.drawImage(output.getName(), 0, 200, 100, 100, 0);
        frame.paint();
    }
}