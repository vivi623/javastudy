package org.hhw.io.bio;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {

        try {
            FileInputStream inputStream = new FileInputStream("D://simple.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
