package day2;

import utility.DB_Utility;

import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.152.177.142:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM JOBS") ;

        // I want to read the first row
        rs.next() ;
        System.out.println("First column value in Jobs " + rs.getString(1)  );
        System.out.println("Second column value in Jobs " + rs.getString(2)  );

        // move to row number 7 and get above 2 columns values
        rs.absolute(7) ;
        System.out.println("First column value in Jobs in row 7 " + rs.getString(1)  );
        System.out.println("Second column value in Jobs in row 7 " + rs.getString(2)  );

        rs.last() ;
        System.out.println("First column value in Jobs in last row " + rs.getString(1)  );
        System.out.println("Second column value in Jobs last row " + rs.getString(2)  );

        rs.previous();
        System.out.println("First column value in Jobs in 2nd row from last row " + rs.getString(1)  );
        System.out.println("Second column value in Jobs in 2nd row from last row " + rs.getString(2)  );


        System.out.println("================ loop from top to bottom===================");
        rs.beforeFirst();

        while ( rs.next() ){
            System.out.println("Loop First Column " + rs.getString("JOB_ID"));
        }

        System.out.println("\n-------Loop form last row till first row get MIN_SALARY COLUMN AS A NUMBER-------");
        //WE ARE CURRENTLY AT AFTER LAST LOCATION
        //if u reallywant to make sure and explicitly say so
        rs.afterLast();
        while( rs.previous() ){
            System.out.println("MIN SALARY COLUMN AS NUMBER $" + rs.getDouble("MIN_SALARY") );
        }

        // clean up the connection statement and resultSet object after use
       // rs.close();
        //stmnt.close();
        //conn.close();
        DB_Utility.destroy();
    }
}
