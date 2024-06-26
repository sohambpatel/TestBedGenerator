package org.testbedgenerator;

import java.io.*;
import java.util.Scanner;

public class SingletonFileHandler {
    FileWriter fw1;
    PrintWriter pw1;
    File f1;

    String filedata="";
    private static SingletonFileHandler inst= new SingletonFileHandler();

    private SingletonFileHandler() {
        super();
    }

    public void reset() {
        inst = new SingletonFileHandler();
    }

    //Writing into file in a synchronized manner
    public synchronized void writeToFile(String filenamealongwithpath,String contenttowrite) throws IOException {
        f1=new File(filenamealongwithpath);
        if(!(f1.exists())){
            f1.createNewFile();
            fw1=new FileWriter(f1,true);
            if(f1.exists()){
                fw1.write(contenttowrite+"\n");
                fw1.flush();
                fw1.close();
                System.out.print("File has been created since it wasnt present and content had been appended");
            }else{
                System.out.println("Please provide a valid path to destination file");
            }
        }else{
            fw1=new FileWriter(f1,true);
            if(f1.exists()){
                fw1.write(contenttowrite+"\n");
                fw1.flush();
                fw1.close();
                System.out.print("File was present and content had been appended");
            }else{
                System.out.println("Please provide a valid path to destination file");
            }
        }
    }

    public static SingletonFileHandler getInstance() {
        return inst;
    }

    //Reading file in a synchronized manner
    public synchronized String readFile(String filenamealongwithpath) {
        try {

            f1 = new File(filenamealongwithpath);
            Scanner myReader = new Scanner(f1);
            StringBuffer content=new StringBuffer(filedata);
            while (myReader.hasNextLine()) {
                filedata = myReader.nextLine();
                content.append(filedata+"\n");
            }
            myReader.close();
            return content.toString();
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("File not found, error occured");
            fileNotFoundException.printStackTrace();
            return null;
        }
    }
}
