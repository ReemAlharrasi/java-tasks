package task347;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class FileTypeClassifier {
    //initialize variables
    List<String> files = List.of("Reem.png", "robots.mp4", "voice1.mp3", "Matilda.pdf", "tasks.txt", "program.java", "contract.docx", "names");
    int count, docCount, imgCount, codeCount, otherCount;
    String name, ext, classification;

    //initialize sets for extension types
    HashSet<String> document = new HashSet<>();
    HashSet<String> image = new HashSet<>();
    HashSet<String> code = new HashSet<>();

    void main() {
        //add ext to sets
        document.add("txt");
        document.add("pdf");
        document.add("docx");

        image.add("jpg");
        image.add("png");

        code.add("java");
        code.add("py");
        code.add("js");

        //print header
        System.out.printf("%-15s %-15s %-15s\n", "Name", "base", "ext", "Type", "classification");
        count = 0;
        for (String file : files) {
            if (file.contains(".")) {
                name = file.substring(0, file.lastIndexOf("."));
                ext = file.substring(file.lastIndexOf(".") + 1);
                //classify extension
                if (document.contains(ext)) {
                    classification = "Document";
                    docCount++;
                }
                else if (image.contains(ext)) {
                    classification = "Image";
                    imgCount++;
                }
                else if (code.contains(ext)) {
                    classification = "Code";
                    codeCount++;
                }
                else {
                    classification = "Other";
                    otherCount++;
                }
            } else {
                classification = "other";
                otherCount++;
            }

            //display results
            System.out.printf("%-15s %-15s %-15s %-15s\n", file, name, ext, classification);
        }

        //display counts
        System.out.println("\nTotal number of files: " + files.size());
        System.out.println("Document count: " + docCount);
        System.out.println("Image count: " + imgCount);
        System.out.println("Code count: " + codeCount);
        System.out.println("Other count: " + otherCount);

    }

}
