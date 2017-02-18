

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.IOException;

public class CSVParser {

    public static void main(String[] args){

        String csvFile = "file.csv";
        
        BufferedReader br = null;
        
        String line = "";
        String cvsSplitBy = ",";
        int flag=0;
        String[] heading=null; 
        int lineCount=1;
        try {
        	PrintStream ps = new PrintStream(new File("output.txt"));
            System.setOut(ps);
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	if(flag==0){ 			//save the heading.
            		heading = line.split(cvsSplitBy); 
            		flag=1;
            		continue;
            	}
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                
                //Print Data to Output Stream
                ps.print("Line:" +lineCount+" [ ");
                for(int j=0;j<data.length;j++){
                	if(j==0)
                		ps.print(heading[j] +"="+ data[j]);
                	if(j!=0)
                		ps.print(" , "+heading[j] +"="+ data[j]); 	
                }
                ps.print(" ]");
                ps.println();
                lineCount++;
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (br != null) {
                try {
                    br.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
