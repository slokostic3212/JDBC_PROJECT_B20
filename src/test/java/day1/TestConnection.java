package day1;

import java.sql.*;
public class TestConnection {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.152.177.142:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);

        Statement stmnt = conn.createStatement();

        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        rs.next(); // currently we are at the very first row

        System.out.println("first column value using index: --> " + rs.getString(1));
    }
}