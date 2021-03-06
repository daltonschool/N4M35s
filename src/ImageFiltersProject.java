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
        File Hannah = new File("hannah.jpg");
        File grace = new File("GraceImage.jpg");
        File isabel = new File("Isabel.jpg");
        File m = new File("maddie.jpg");


        //original:
        frame.drawText("original", 15, 30, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(f.getName(), 15, 30, 100, 150, 0);

        //invert:
        frame.drawText("invert", 15, 180, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(invertColors(f).getName(), 15, 180, 150, 150, 0);

        // Grace
        frame.drawText("grayscale", 240, 200, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(blackAndWhite(grace).getName(), 240, 200, 150, 150, 0);


        // Nicole

        // Paul

        // Phoebe
        File phoebe = new File("Phoebe.jpg");
        frame.drawText("black and white", 15, 400, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(blackandwhite(phoebe).getName(), 15, 400, 150, 150, 0);

        // Nick

        // Teddy

        // Mehrab

        // Claire

        // Liza
        frame.drawText("brighter colors", 15, 350, 20, 0, ColorLatte.BlueViolet);
        frame.drawImage(Brighter(f).getName(), 15, 350, 150, 150, 0);

        // Hannah

        frame.drawText("Darker Version", 15, 400, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(darkVersion(Hannah,200).getName(), 15, 400, 150, 150, 0);

        // Marshall

        frame.drawText("resize", 15, 400, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(resize(f, 1000, 1000).getName(), 15, 400, 150, 150, 0);

        // Maddie
        frame.drawText("popart", 15, 200, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(popArt(m).getName(), 15, 300, 400, 400, 0);

        // Julia
        frame.drawText("upside down", 15, 400, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(upsideDown(f).getName(), 15, 400, 150, 150, 0);


        // Isabel
        frame.drawText("tile", 15, 400, 20, 0, ColorLatte.Chocolate);
        frame.drawImage(tile(isabel).getName(), 15, 400, 150, 150, 0);

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

    public static File blackandwhite (File phoebe) throws IOException {
        BufferedImage image = ImageIO.read(phoebe);
        int[][] pixels = new int[image.getWidth()][image.getHeight()];

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                // Get a pixel and separate into red, green, blue
                Color originalColor = new Color(image.getRGB(i, j)); // column, row
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();

                pixels[i][j] = (red+green+blue)/3;

            }
        }
        //Trying to find the average pixel number
        int x =0;
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
               x = x+ pixels[i][j];
            }
        }
        x = x/(pixels.length*pixels[0].length);

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                // Get a pixel and separate into red, green, blue
                Color originalColor = new Color(image.getRGB(i, j)); // column, row
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();

                Color blackandwhiteColor;
                if ((red+green+blue)<x) {
                    blackandwhiteColor =new Color(0,0,0);
                } else {
                    blackandwhiteColor =new Color(255,255,255);
                }
                image.setRGB(i, j,blackandwhiteColor.getRGB());
            }
        }

        // Create a new file so we don't mess up the original
        File output = new File(phoebe.getName().replace(".jpg", "") + "_blackandwhite.png");
        ImageIO.write(image, "PNG", output);
        return output;
    }

    public static File blackAndWhite(File f) throws IOException {
        // Open a file and save as a BufferedImage (a 2D int array)
        BufferedImage image = ImageIO.read(f);

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                // Get a pixel and separate into red, green, blue
                Color originalColor = new Color(image.getRGB(i, j)); // column, row
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();

                int avg = (red + green + blue)/3;


                // Invert the color (i.e., get the photo-negative).
                Color bwColor = new Color(avg, avg, avg);

                // Update image with the inverted color.
                image.setRGB(i, j, bwColor.getRGB()); // column, row, pixel


            }
        }

        File output = new File(f.getName().replace(".jpg", "") + "_invert.png");
        ImageIO.write(image, "PNG", output);
        return output;

    }
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
    public static File darkVersion(File Hannah, int darker) throws IOException {

        BufferedImage image = ImageIO.read(Hannah);

        //find size of image
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {

                //get pixel and separate into red, green, and blue
                Color originalColor = new Color(image.getRGB(i, j)); // column, row
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();


                // Make the color darker
                Color darkVersion = new Color(Math.max(red - darker,0), Math.max(green -darker,0), Math.max(blue -darker,0));

                // Update image with the darker color.
                image.setRGB(i, j, darkVersion.getRGB()); // column, row, pixel

            }
        }

        // Create a new file so we don't mess up the original
        File output = new File(Hannah.getName().replace(".jpg", "") + "_darkened.png");
        ImageIO.write(image, "PNG", output);
        return output;

    }

    // Marshall: scale the image to a given x and y size
    public static File resize(File f, int width, int height) throws IOException {
        // Open a file and save as a BufferedImage (a 2D int array)
        BufferedImage image = ImageIO.read(f);
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        double  widthRatio = image.getWidth()/width;
        double heightRatio = image.getHeight()/height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newImage.setRGB(i, j, image.getRGB((int)(i*widthRatio), (int)(j*heightRatio)));
            }
        }
        File output = new File(f.getName().replace(".jpg", "") + "_resized.png");
        ImageIO.write(newImage, "PNG", output);
        return output;
    }

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

    public static File upsideDown (File f) throws IOException {
        // Open a file and save as a BufferedImage (a 2D int array)
        BufferedImage image = ImageIO.read(f);
        BufferedImage flipped = ImageIO.read(f);

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {

                Color originalPixel = new Color(image.getRGB(i, j)); // column, row

                int p = image.getHeight() - j-1;

                flipped.setRGB(i, p, originalPixel.getRGB()); // column, row, pixel


            }
        }

        File output = new File(f.getName().replace(".jpg", "") + "_upsidedown.png");
        ImageIO.write(flipped, "PNG", output);
        return output;

    }

    // Isabel: make a 10 x 10 tiled version of the image

    static File tile(File f) throws IOException {
        // Open a file and save as a BufferedImage (a 2D int array)
        BufferedImage image = ImageIO.read(f);
        // Make an array that is a tenth of the width
        int[][] tile = new int[image.getWidth()/10][image.getHeight()/10];
        for (int i = 0; i <tile.length ; i++){
            for (int j = 0; j < tile[0].length; j++) {
                tile[i][j] = image.getRGB(i*10, j*10);

            }
            System.out.println();
        }
           for (int x = 0; x < 10; x++ ) {
            for (int y = 0; y < 10; y++) {
                for (int i = 0; i < tile.length; i++) {
                    for (int j = 0; j < tile[0].length; j++) {
                        image.setRGB(i+((tile.length)*x), j+((tile[0].length)*y), tile[i][j]); // column, row, pixel
                    }
                }
            }
        }


        // Create a new file so we don't mess up the original
        File output = new File(f.getName().replace(".jpg", "") + "_tile.png");
        ImageIO.write(image, "PNG", output);
        return output;

    }

}
