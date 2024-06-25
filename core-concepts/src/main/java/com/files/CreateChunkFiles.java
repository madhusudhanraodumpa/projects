package com.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreateChunkFiles {
    public static void main(String[] args) {
       // https://www.java-success.com/processing-large-files-efficiently-java-part-1/
        int chunkSize = 1024;
        String fileName = "iam-registration-service-v1.3";
        try {

            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[chunkSize];
            int bytesRead = fileInputStream.read(buffer);
            int chunkNumber = 0;

            FileOutputStream fileOutputStream = new FileOutputStream("small_file_" + chunkNumber + ".txt");
            fileOutputStream.write(buffer, 0, bytesRead);


            // read the next chunk of data from the large file

            bytesRead = fileInputStream.read(buffer);


            while (bytesRead != -1) {


                fileOutputStream.close();


                chunkNumber++;


                fileOutputStream = new FileOutputStream("small_file_" + chunkNumber + ".txt");


                fileOutputStream.write(buffer, 0, bytesRead);


                bytesRead = fileInputStream.read(buffer);

            }


            fileOutputStream.close();


            fileInputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
