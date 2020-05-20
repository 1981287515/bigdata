package test;

import com.csvreader.CsvReader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class deal31 {
    public static void main(String[] args) throws Exception {
        FileWriter fw = null;
        BufferedWriter bufw = null;
        File file = new File("F:\\sparkdata\\大数据课程设计\\任务\\jobs3.csv");
        File output = new File("F:\\sparkdata\\大数据课程设计\\任务\\xjobs3.txt");
        fw = new FileWriter(output);
        bufw = new BufferedWriter(fw);
        InputStream in = new FileInputStream(file);
        CsvReader cr = new CsvReader(in, Charset.forName("UTF-8"));
        cr.readHeaders();
        bufw.write(Arrays.toString(cr.getHeaders())+"\n");
        //cr.readRecord();
        while(cr.readRecord()){
            int columnCount = cr.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String str = cr.get(i);
                Pattern p = Pattern.compile("\\s+|\t+|\n|\r");
                Matcher m = p.matcher(str);
                String s = m.replaceAll("");
                bufw.write(s+"/~/");
                System.out.println(s);
            }
            bufw.write("\n");
            bufw.flush();
        }
         cr.close();
    }
}
