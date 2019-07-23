package com.semantyca.sql;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertExtractor {

    InsertExtractor() {

        String fileName = "inserts.sql";
        Pattern pattern = Pattern.compile("(\\x28{1}\\d{2,3},(('([^']|'')+')),(('([^']|'')+')))");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }


            List<String> matches = new ArrayList<String>();
            Matcher m = pattern.matcher(sb.toString());
            while (m.find()) {
                matches.add(m.group(1));
            }

            //\d{2,3}

            for (String v : matches) {
                //System.out.println(v);
                StringTokenizer value = new StringTokenizer(v.replace("(",""),",");
                String v1 = v.replace("(","");
                int id =   Integer.parseInt(v1.substring(0, v.indexOf(",") - 1));
                StringTokenizer stringTokenizer = new StringTokenizer(v1,",");
                String val2 = stringTokenizer.nextToken();
                String val3 = stringTokenizer.nextToken();
                int position = v1.indexOf(val3) + val3.length() + 1;
                String key1Val =  v1.substring(position);
                String sql = "UPDATE configuration_cfg cc SET cc.key1=" + key1Val + " WHERE cc.id=" + id + ";";
                System.out.println(sql);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        new InsertExtractor();
    }
}
