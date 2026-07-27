package task348;

import java.util.HashSet;

import java.util.Scanner;

public class FilePathSplitter {

    //initialize scanner
    Scanner in = new Scanner(System.in);

    //initialize variables
    String path,folder,file,ext,style;
    int slashIndex;
    void main(){
        //read path from user
        System.out.print("Enter full path: ");
        path =in.next().strip();

        //validate path
        if (path.isBlank()){
            System.out.println("Invalid path.");
        }else{
            //determine style and replace all backslashes with forward slashes
            if (path.contains("\\")) {
                style = "Unix";
                path=path.replaceAll("\\\\","/");
            }
            else style="Windows";

            //get index of last /
            slashIndex=path.lastIndexOf("/");

            //get folder and file names using the slash index
            folder=path.substring(0,slashIndex);
            file=path.substring(slashIndex+1);

            //determine extension
            if (!file.contains(".")) ext="None";
            else ext=file.substring(file.indexOf(".")+1);
            System.out.println(ext);

            //print results
            System.out.println("Path: "+path);
            System.out.println("Folder: "+folder);
            System.out.println("File name: "+file.substring(0,file.indexOf(".")));
            System.out.println("Extension: "+ext);
            System.out.println("Style: "+style);

            //close scanner
            in.close();
        }

    }
    //close Scanner

}
