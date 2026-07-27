package task346;

import java.util.HashSet;
import java.util.Scanner;

public class FileNameAnalyzer {

    //initialize scanner
    Scanner in = new Scanner(System.in);

    //initialize required variables
    String input, name, ext, classification;
    int dotIndex;

    //initialize sets for extension types
    HashSet<String> document = new HashSet<>();
    HashSet<String> image = new HashSet<>();
    HashSet<String> audio = new HashSet<>();

    void main() {
        //add ext to sets
        document.add("txt");
        document.add("pdf");
        document.add("docx");

        image.add("jpg");
        image.add("png");
        image.add("gif");

        audio.add("mp3");
        audio.add("wav");

        //get input
        System.out.print("Enter file Name: ");
        input = in.next().strip().toLowerCase();

        //check validity
        if (input.isBlank() || !input.contains(".") ||
                input.charAt(0) == '.' || input.charAt(input.length() - 1) == '.') {
            //print error msg
            System.out.println("Invalid file name.");
        } else {
            //extract do location, file name, and extension
            dotIndex = input.lastIndexOf('.');
            name = input.substring(0, dotIndex);
            ext = input.substring(dotIndex + 1);

            //classify extension
            if (document.contains(ext)) classification = "Document";
            else if (image.contains(ext)) classification = "Image";
            else if (audio.contains(ext)) classification = "Audio";
            else classification = "Other";

            //display results
            System.out.println("\nFile name: " + input);
            System.out.println("Base name: " + name);
            System.out.println("Extension: " + ext);
            System.out.println("Classification: " + classification);
        }

        //close scanner
        in.close();
    }
}
