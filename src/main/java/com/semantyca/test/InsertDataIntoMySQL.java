package com.semantyca.test;

import com.semantyca.util.NumberUtil;
import com.semantyca.util.StringUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDataIntoMySQL {

    public static void main(String[] args) {
        String encodings[] = {"UTF-8", "Cp1252"};
        int max = 3;
        String query = " insert into test (id, text1, enc)"
                + " values (?, ?, ?)";
        for (int i = 0; i < max; i++) {
            int num = NumberUtil.getRandomNumber(1, 100);
            String text = StringUtil.genRndText("äåéö", 10);
            for (String encoding : encodings) {

                try {
                    String myUrl = "jdbc:mysql://localhost:3307/test_db?characterEncoding=" + encoding + "&user=test_user&password=3287";
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                    Connection conn = DriverManager.getConnection(myUrl);
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setInt(1, num);
                    preparedStmt.setString(2, text);
                    preparedStmt.setString(3, encoding);
                    System.out.println(num + " " + text);
                    preparedStmt.execute();

                    conn.close();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                } finally {

                }
            }
        }
    }
}