package tech.codingclub.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class fileutility {
    // create a file
    public static boolean createFile(String fileNameWithPath)
    {
        File file = new File(fileNameWithPath);
        boolean fileCreated = false;
        try {
            fileCreated=file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return fileCreated;
    }
    // read a file
    public static ArrayList<String> readFileAsList(String filename) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Scanner sc=null;
        try {
            File file = new File(filename);
            sc  = new Scanner(file);
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                arrayList.add(line);
//                System.out.println(line);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(sc!=null)
            {
                sc.close();
            }
        }
        return arrayList;
    }
    // writing the file
    public static boolean writeToFile(String fileNameWithpath,String content)
    {
        try {

            FileWriter fileWriter = new FileWriter(fileNameWithpath);
            fileWriter.append(content);
            fileWriter.close();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    // appending extra content to file
    public static boolean appendToFile(String fileName , String content)
    {
        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            fileWriter.append("\n");
            fileWriter.append(content);
            fileWriter.close();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("This is Mohit.kota");
        System.out.println("Running FileUtility at "+new Date().toString());
        String nameofNewFile = "C:\\Users\\User\\IdeaProjects\\Tech.CodingClub\\data\\practice\\file"+"create-file.txt";
        boolean created = createFile(nameofNewFile);
        System.out.println("File Created : "+created);

        ArrayList<String> x=readFileAsList(nameofNewFile);
        for(String i:x)
        {
            System.out.println("Line "+i);
        }
        System.out.println("No of lines in file : "+x.size());
        String nameofWriteFile = "C:\\Users\\User\\IdeaProjects\\Tech.CodingClub\\data\\practice\\file"+"write-file.txt";
        boolean wroteToFile = writeToFile(nameofWriteFile,"This file is generate on mohit system automatically ");
        System.out.println(wroteToFile);
        for(int i=1;i<=100;i++)
        {
            String s = i+"";
            appendToFile(nameofWriteFile,s);
        }
        System.out.println("Appended file length "+readFileAsList(nameofWriteFile).size());
    }

}
