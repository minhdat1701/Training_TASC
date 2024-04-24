package javacore_6;

import java.io.*;

public class DemoChecked {
//    public static void main(String[] args) {
//        BufferedReader fileInput = null;
//        try {
//            FileReader file = new FileReader("a.txt");
//            fileInput = new BufferedReader(file);
//            // Print first 3 lines of file "a.txt"
//            for (int counter = 0; counter < 3; counter++)
//                System.out.println(fileInput.readLine());
//            fileInput.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("FileNotFoundException!!!");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("IOException!!!");
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) throws IOException{
        BufferedReader fileInput = null;
        try {
            FileReader file = new FileReader("a.txt");
            fileInput = new BufferedReader(file);
            // In ra 3 dòng đầu tiên của file "a.txt"
            for (int counter = 0; counter < 3; counter++)
                System.out.println(fileInput.readLine());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileInput != null) {
                fileInput.close();
            }
        }
    }
}
