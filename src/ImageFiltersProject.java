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

        // Julia

        // Isabel

        //paint:
        frame.paint();
    }


    //  Makes a copy that is a photo-negative of the file.
    public static File invertColors(File f) throws IOException {
        // Open a file and save as a BufferedImage (a 2D int array)
        BufferedImage image = ImageIO.read(f);


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

    // Julia: flip the image upside down

    // Isabel: make a 10 x 10 tiled version of the image

}
