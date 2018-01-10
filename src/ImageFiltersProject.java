import lattelib.ColorLatte;
import lattelib.WebLatte;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ImageFiltersProject {
    public static void main(String[] args) throws Exception {
        WebLatte frame = new WebLatte();
        File f = new File("slinky.jpg");
        File m = new File("maddie.jpg");


        //original:
        frame.drawText("original", 15, 30, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(f.getName(), 15, 30, 150, 150, 0);

        //invert:
        frame.drawText("invert", 15, 200, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(invertColors(f).getName(), 15, 200, 150, 150, 0);

        // Grace

        // Nicole

        // Paul

        // Phoebe

        // Nick

        // Teddy

        // Mehrab

        // Claire

        // Liza

        // Hannah

        // Marshall

        // Maddie
        frame.drawText("popart", 15, 200, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(popArt(m).getName(), 15, 300, 400, 400, 0);

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

    // Hannah: Make a darker version of the image

    // Marshall: scale the image to a given x and y size

    // Maddie: pop art try to mimic the popart filter
    public static File popArt(File m) throws IOException {
        BufferedImage image = ImageIO.read(m);

        int cols = 0;

//        for (int i = 0; i < image.getWidth(); i++) {
//            for (int j = 0; j < image.getHeight(); j++) {
//                // Get a pixel and separate into red, green, blue
//                Color originalColor = new Color(image.getRGB(i, j)); // column, row
//
//                int red = 20 * (originalColor.getRed()/20);
//                int green = 20 * (originalColor.getGreen()/20);
//                int blue = 20 * (originalColor.getBlue()/20);
//
//                Color popArt = new Color(red, green, blue);
//
//            }
//        }

//        Arrays.sort(mycolors, new Comparator<Color>() {
//            @Override
//            public int compare(Color o1, Color o2) {
//                return o1.getBlue()-o2.getBlue();
//            }
//        });

//        System.err.println(Arrays.toString(mycolors));

        // popArt the color (i.e., get the photo-negative).
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                // Get a pixel and separate into red, green, blue
                Color originalColor = new Color(image.getRGB(i, j)); // column, row
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();

                if (red + green + blue < 250) {
                    // Update image with the popArt color.
                    Color popArt = new Color(0, 0, 0);
                    image.setRGB(i, j, popArt.getRGB()); // column, row, pixel
                }
                else if(red>green && red >blue){
                    Color popArt = new Color(255, 0, 0);
                    image.setRGB(i, j, popArt.getRGB()); // column, row, pixel
                }
                else if(green>red && green >blue){
                    Color popArt = new Color(0, 0, 255);
                    image.setRGB(i, j, popArt.getRGB()); // column, row, pixel
                }
                else {
                    Color popArt = new Color(0, 255, 0);
                    image.setRGB(i, j, popArt.getRGB()); // column, row, pixel
                }

            }
        }
        // Create a new file so we don't mess up the original
        File output = new File(m.getName().replace(".jpg", "") + "_popArt.png");
        ImageIO.write(image, "PNG", output);
        return output;
    }
    // Julia: flip the image upside down

    // Isabel: make a 10 x 10 tiled version of the image

}