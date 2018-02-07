import lattelib.ColorLatte;
import lattelib.WebLatte;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFiltersProject {
    public static void main(String[] args) throws Exception {
        WebLatte frame = new WebLatte();
        File f = new File("slinky.jpg");

        //original:
        frame.drawText("original", 15, 30, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(f.getName(), 15, 30, 100, 150, 0);

        //invert:
        frame.drawText("invert", 15, 180, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(invertColors(f).getName(), 15, 180, 150, 150, 0);

        // Grace

        // Nicole

        // Paul

        // Phoebe

        // Nick

        // Teddy

        // Mehrab

        // Claire

        // Liza
        frame.drawText("brighter colors", 15, 350, 20, 0, ColorLatte.BlueViolet);
        frame.drawImage(Brighter(f).getName(), 15, 350, 150, 150, 0);

        // Hannah

        // Marshall

        // Maddie

        // Julia

        // Isabel

        //paint:
        frame.paint();
    }


    //  Makes a copy that is a photo-negative of the file.
    public static File invertColors(File f) throws IOException {
        // Open a file and save as a BufferedImage (a 2D int array)
        BufferedImage image = ImageIO.read(f);

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                // Get a pixel and separate into red, green, blue
                Color originalColor = new Color(image.getRGB(i, j)); // column, row
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();

                // Invert the color (i.e., get the photo-negative).
                Color invertedColor = new Color(255 - red, 255 - green, 255 - blue);

                // Update image with the inverted color.
                image.setRGB(i, j, invertedColor.getRGB()); // column, row, pixel

            }
        }

        // Create a new file so we don't mess up the original
        File output = new File(f.getName().replace(".jpg", "") + "_inverted.png");
        ImageIO.write(image, "PNG", output);
        return output;
    }

    // Grace: Make a copy that is a grayscale version of the file.

    // Nicole: Make a version where the left half of the image is mirrored.

    // Paul: Make a version where the right half of the image is mirrored.

    // Phoebe: Make a version the is purely black and white (not gray).

    // Nick: Make a version that is half the height and half the width.

    // Teddy: Make a version where r, g, b is stored as b, r, g.

    // Mehrab: Take two image files and create a single file that contains the two images next to each other.

    // Claire: Make a sepia-colored version.

    // Liza: Make a brighter version of the image.
    public static File Brighter(File h) throws IOException {
        // Open a file and save as a BufferedImage (a 2D int array)
        BufferedImage image = ImageIO.read(h);

        //find image height/width and declare colors separately
        for (int k = 0; k < image.getWidth(); k++) {
            for (int l = 0; l < image.getHeight(); l++) {
                // Get a pixel and separate into red, green, blue
                Color originalColor = new Color(image.getRGB(k, l)); // column, row
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();



                // brighten the color/make white if over 255
                red +=60;
                green +=60;
                blue +=60;

                if (red>255){
                    red = 255;
                }
                if (blue>255){
                    blue = 255;
                }

                if (green>255){
                    green = 255;
                }

                Color brighterColor = new Color(red, green, blue);

                // Update image with the brighter color.
                image.setRGB(k, l, brighterColor.getRGB()); // column, row, pixel

            }
        }

        // Create a new file so we don't mess up the original
        File output2 = new File(h.getName().replace(".jpg", "") + "brightercolor.png");
        ImageIO.write(image, "PNG", output2);
        return output2;
    }



    // Hannah: Make a darker version of the image

    // Marshall: scale the image to a given x and y size

    // Maddie: pop art try to mimic the popart filter

    // Julia: flip the image upside down

    // Isabel: make a 10 x 10 tiled version of the image

}
