/**
 * @author Jon
 * @version 0.1
 * 
 * Notes
 *  -This program will prompt user input via CLI
 *  -Find indicated file
 *  -Then convert the file to HTML
 *  -Followed by generating the contents of the file into the format of an HTML file
 * 
 * Use spring boot to prompt user to find a file
 * then show the contents on a webpage??
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

            //#3 rename file

            //search for a period in the file name
            dotPosition = fileNameIn.lastIndexOf(".");

            //if no dot exists (it will return -1)
            if(dotPosition == -1){
                //add .html to the end of the file name
                //if no dot exists
                fileNameOut = fileNameIn + (".html");
            } else {
                //fileNameOut is equal to the starting position of fileNameIn
                //ending at dotPosition and add ".html" to the end
                fileNameOut = fileNameIn.substring(0, dotPosition) + ".html";
            }
            //connect to indicated file
            fileOut = new PrintWriter(fileNameOut);

            //catch any errors
            try {
                //read first line
                line = fileIn.nextLine();
            } catch(NoSuchElementException e) {
                System.err.println("Error " + e.getMessage());
            }

            //#4 check if the indicated file is null
            if(line == null){
                System.out.println("The indicated file is blank");
            } else {
                //#5 insert html tags
                fileOut.println("<html>");
                fileOut.println("<head>");
                fileOut.println("</head>");
                fileOut.println("<body>");

                //dump first line
                //there's already data in the PrintWriter might as well use it 
                fileOut.println(line);

                //self-explanitory
                while(fileIn.hasNextLine()){
                    //insert break to separate lines
                    fileOut.println("<br>");

                    //get next line
                    line = fileIn.nextLine();

                    //
                    if(line.isEmpty()){
                        //print a blank line
                        fileOut.println("<br>");
                    } else {
                        //print the line
                        fileOut.println(line);
                    }
                }
                //close html tags when the while loop
                fileOut.println("</body>");
                fileOut.println("</html>");
            }

            //close writers, and scanners
            sc.close();
            fileIn.close();
            fileOut.close();

        }catch(FileNotFoundException e){
            System.err.println("File not found " + e);
        }
    }
}
