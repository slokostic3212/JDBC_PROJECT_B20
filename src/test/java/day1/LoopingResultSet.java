package day1;

import java.sql.*;

public class LoopingResultSet {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.152.177.142:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt = conn.createStatement();
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;

        //rs.nest() method will return boolean value
        // if there is a next row -->> return true and move pointer to next row
        // if there is no next row --> false

        while (rs.next()){

            System.out.println("Region_ID " + rs.getString("REGION_ID") );
            System.out.println("Region_Name " + rs.getString("REGION_NAME") );
        }

        // iterator over all countries
        rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");

        while ((rs.next())){

            System.out.println(rs.getString(1) + "\t");

            System.out.println(rs.getString(2) + "\t");

            System.out.println(rs.getString(3));
        }
        rs.previous();
    }
}
