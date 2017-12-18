import lattelib.WebLatte;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class ImageInvertDemo {
    public static void main(String[] args) throws Exception {
        // Open a file and save as a BufferedImage (a 2D int array)
        File f = new File("slinky.jpg");
        BufferedImage image = ImageIO.read(f);

        // Get some information about the 2D array
        int totalCols = image.getWidth();
        int totalRows = image.getHeight();
        System.out.println("Width is " + totalCols);
        System.out.println("Height is " + totalRows);

        // SAMPLE CODE TO INVERT A PIXEL

        // Get a pixel and separate into red, green, blue
        Color originalColor = new Color(image.getRGB(0, 0)); // column, row
        int red = originalColor.getRed();
        int green = originalColor.getGreen();
        int blue = originalColor.getBlue();

        // Invert the color (i.e., get the photo-negative).
        Color invertedColor = new Color(255-red, 255-green, 255-blue);

        // Update image with the inverted color.
        image.setRGB(0, 0, invertedColor.getRGB()); // column, row, pixel

        // END SAMPLE CODE


        // YOUR CODE STARTS HERE
        // TODO: invert the colors of every pixel in the image.




        // END YOUR CODE


        // Create a new file so we don't mess up the original
        File output = new File(f.getName().replace(".jpg", "") + "_inverted.png");
        ImageIO.write(image, "PNG", output);
        System.out.println("Created file at " + output.getAbsolutePath());

        WebLatte frame = new WebLatte();
        frame.drawImage(f.getName(), 0, 0 , 100, 100, 0);
        frame.drawImage(output.getName(), 0, 200, 100, 100, 0);
        frame.paint();

    }
}