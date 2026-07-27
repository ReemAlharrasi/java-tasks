package task351;

import java.util.HashSet;

public class FileInventoryReport {
    //initialize variables
    String[] csvRows, input;
    int docCount, imgCount, audioCount, codeCount, otherCount,totalSize,size,largestSize;
    String name, ext, classification,largestFile;

    //initialize sets for extension types
    HashSet<String> document = new HashSet<>();
    HashSet<String> image = new HashSet<>();
    HashSet<String> audio = new HashSet<>();
    HashSet<String> code = new HashSet<>();

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
        code.add("java");
        code.add("py");
        code.add("js");

        //initialize rows and totalsize
        csvRows = new String[]{"photo.png,340", "app.java,8", "document.pdf,1250",
                "index.html,15", "audiobook.mp3,24", "script.js,42", "database.db,8900", "readme,3"
        };
        totalSize=0;
        largestFile="";
        largestSize=-1;

        //print header
        System.out.println(String.format("%-10s %-10s %-10s %-10s", "name", "extension", "type","size"));
        System.out.println("-".repeat(40));

        //loop through rows
        for (int i = 0; i < csvRows.length; i++) {
            //get row
            input = csvRows[i].strip().split(",");

            //validate input
            if (input.length > 2) {
                System.out.println("Skipping malformed row: Invalid record.");
            } else {
                if (input[0].contains(".")) {
                    name=input[0].substring(0,input[0].lastIndexOf("."));
                    ext = input[0].substring(input[0].lastIndexOf(".") + 1);
                    //classify extension
                    if (document.contains(ext)) {
                        classification = "Document";
                        docCount++;
                    } else if (image.contains(ext)) {
                        classification = "Image";
                        imgCount++;
                    } else if (code.contains(ext)) {
                        classification = "Code";
                        codeCount++;
                    } else if (audio.contains(ext)) {
                        classification = "Audio";
                        audioCount++;
                    } else {
                        classification = "Other";
                        otherCount++;
                    }
                } else {
                    name=input[0];
                    ext="None";
                    classification = "Other";
                    otherCount++;
                }

                //total size and find largest
                size= Integer.parseInt(input[1].trim());
                totalSize+=size;
                if (size>largestSize) {
                    largestFile=input[0].trim();
                    largestSize=size;
                }

            }
            //print row
            System.out.println(String.format("%-10s %-10s %-10s %-10d", name, ext,classification, size));
        }
        //print results
        //display counts
        System.out.println("\nResults -----\nTotal number of files: " + csvRows.length);
        System.out.println("Total size: " + totalSize);
        System.out.println("Largest file: " + largestFile+" - size: "+largestSize);
        System.out.println("\nCounts -----\nDocument count: " + docCount);
        System.out.println("Image count: " + imgCount);
        System.out.println("Audio count: " + audioCount);
        System.out.println("Code count: " + codeCount);
        System.out.println("Other count: " + otherCount);
    }
}
