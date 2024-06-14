package com.example.test;

import org.apache.commons.io.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class MainApp {

    private static void samDate(Date tt) {
        System.out.println(tt.toString());

    }

    public static void main(String[] args) throws IOException {
        File s = new File("D:\\folder1");
        System.out.println(s.getAbsolutePath());
        System.out.println(s.getPath());
        System.out.println(s.getCanonicalPath());
        System.out.println(s.getParent());
        System.out.println(s.getAbsoluteFile());

        System.out.println(s.exists());
        //System.out.println(s.getd);
        String test = StringUtils.abbreviate("Exception in thread \"main\" java.lang.NumberFormatException: For input string: \"p\" at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65) at java.lang.Integer.parseInt(Integer.java:580) at java.lang.Integer.parseInt(Integer.java:615) at TableMultiplication.main(TableMultiplication.java:18) asdasd asd Exception in thread \"main\" java.lang.NumberFormatException: For input string: \"p\" at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65) at java.lang.Integer.parseInt(Integer.java:580) at java.lang.Integer.parseInt(Integer.java:615) at TableMultiplication.main(TableMultiplication.java:18)",230);
        System.out.println(test);
        File dir = new File(s.getPath());

        Date tesd = new Date();
       // MainApp.samDate(null);
        System.out.println("tt".toString());

        int hour = 3;
        int startTime = 17;
        int endTime = 18;

        if(startTime < endTime) {
            System.out.println("In C2");
            if(endTime > hour && startTime < hour )  {
                    System.out.println("In C3");
                } else {
                    System.out.println("send off");
                }
            }
        else if(startTime > endTime) {
            System.out.println("In C4");
            if(endTime > hour || startTime <= hour )  {
                System.out.println("In C5");
            } else {
                System.out.println("send off");
            }
        }

       Collection<File> files = FileUtils.listFiles(dir,null,false);
        if(!files.isEmpty()) {
            files.stream().forEach(file -> {
                String fromLoc = s.getAbsolutePath();
                String toLoc = s.getAbsolutePath()+"\\"+"processed";

                try {
                    FileUtils.moveFile(new File(s,file.getName()),new File(toLoc,file.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

       // FileUtils.moveFile(new File(s.getPath(),"New Text Document.txt"),new File("D:\\folder1\\folder2","New Text Document.txt"));
    }


}
