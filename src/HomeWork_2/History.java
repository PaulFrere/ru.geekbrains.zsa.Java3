package HomeWork_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class History {
    private static final File file = new File("E:/History.txt");
    private static FileReader fileReader;
    private static BufferedReader reader;
    private static BufferedWriter bfr;
    private static FileWriter fileWriter;

    public static void main(String[] args) {
        showRecords();
        addRecords();
        closeStream();
    }

    public static void showRecords() {
        try {
            List<String> readList = new ArrayList<>();
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String s;
            while ((s = reader.readLine()) != null) {
                readList.add(s);
            }

            if(readList.size() != 0) {
                if(readList.size() < 100) {
                    for (String value : readList) {
                        System.out.println(value);
                    }
                } else {
                    for(int i = 100; i>0; i--) {
                        System.out.println(readList.get(readList.size()-i));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addRecords() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileWriter = new FileWriter(file, true);
            bfr = new BufferedWriter(fileWriter);

            while(true) {
                String str = reader.readLine();
                bfr.write(str + "\n");
                if(str.equals("/end")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeStream() {
        try {
            bfr.close();
            reader.close();
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
