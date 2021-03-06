package test;

import java.io.*;


class deal32 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader bufr = null;

        String inputPath = "F:\\sparkdata\\大数据课程设计\\任务\\xjobs3.txt";

        FileWriter fw = null;
        BufferedWriter bufw = null;
        String outPath = "F:\\sparkdata\\大数据课程设计\\任务\\xxjobs3(1).csv";
        int dataCount = 0;
        try {

            fw = new FileWriter(outPath);
            bufw = new BufferedWriter(fw);

            fis = new FileInputStream(inputPath);


            isr = new InputStreamReader(fis);

            bufr = new BufferedReader(isr);

            String line = bufr.readLine();
            String str = "";
            while(line != null) {

                if(line.startsWith("[")) {
                    str = "";
                    line = bufr.readLine();
                    continue ;
                }

                if(line.startsWith("company_financing_stage")) {
                    str = "";
                    line = bufr.readLine();
                    continue ;
                }

                String[] strs = line.split("/~/");
                String word = "";
                for(int i=0; i<strs.length; i++) {

                    if(i == 0) {
                        word += strs[i];
                    }else {
                        word += "///"+strs[i];
                    }
                }

                String[] newStrs = word.split("///");
                for(int i=0; i<newStrs.length; i++) {
                    if(i==1 || i==2 || i==7 || i==11) {
                        str += newStrs[i]+"///";
                    }
                }

                str = str.substring(0, str.length()-3);
                str=str.replace(",","，");
                str=str.replace("///",",").replace("公司地址：","");
                bufw.write(str);
                bufw.newLine();
                dataCount++;
                str = "";
                line = bufr.readLine();
            }
            if(bufr!=null){
                try {
                    bufr.close();
                } catch (IOException e) {
                }
            }
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }

            bufw.flush();
            System.out.println("共处理:"+dataCount+"条数据");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(bufw!=null){
                try {
                    bufw.close();
                } catch (IOException e) {
                }
            }
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                }
            }

        }
    }

}

