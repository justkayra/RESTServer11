package com.semantyca.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetDataFromMySQL {

    public static void main(String[] args) {
        String encodings[] = {"UTF-8", "Cp1252"};
        for (String encoding : encodings) {
            System.out.println(encoding);
            try {
                String myUrl = "jdbc:mysql://localhost:3307/test_db?characterEncoding=" + encoding + "&user=test_user&password=3287";
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection(myUrl);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM test ORDER BY id");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("enc") + " " + rs.getString("text1"));
                    System.out.println(rs.getString("text1").getBytes());

                }
                conn.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            } finally {

            }
        }

    }
}