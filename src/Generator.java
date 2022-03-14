/**
 * @author Jon
 * @version 0.1
 * 
 * Notes
 *  -This program will prompt user input via CLI
 *  -Find indicated file
 *  -Then convert the file to HTML
 *  -Followed by generating the contents of the file into the format of an HTML file
*/

import java.io.*;
import java.util.*;

/**
 * This class converts files to HTML
*/
public class Generator {
    public static void main(String[] args) {
        //#1 prompt user for file name
        //#2 check if indicated file exists
        //#3 rename file to html - regardless of file type
        //#4 check if indicated file is null (empty)
        //#5 read each line and painstakingly add html tags
    
        //varibles
        Scanner sc = new Scanner(System.in);
        Scanner fileIn;         //input file connection
        PrintWriter fileOut;    //HTML file connection
        String fileNameIn;      //original file's name
        String fileNameOut;     //new HTML file's name
        int dotPosition;        //position of the . in target file's name
        String line = null;     //first line from the target file (used to determine if the file is empty)

        //#1 prompt user for file to convert
        System.out.println("Enter file name or path to file, please");
        fileNameIn = sc.nextLine();

        //#2 check for indicated file existence (which is done by the try block)
        try{
            //this line will throw an error if the file doesn't exist
            //eliminating the need for an if-statement
            fileIn = new Scanner(new FileReader(fileNameIn));

            //
            dotPosition = fileNameIn.lastIndexOf(".");

            if(dotPosition == -1){

            } else{

            }

        }catch(FileNotFoundException e){
            System.err.println("File not found " + e);
        }
    }
}
