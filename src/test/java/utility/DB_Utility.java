package utility;




import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Utility {

    public static void createConnection(){

        String connectionStr = "jdbc:oracle:thin:@ 54.152.177.142:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        try {
            conn = DriverManager.getConnection(connectionStr,username,password) ;
            System.out.println("CONNECTION SUCCESSFUL !! ");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED !!! " +  e.getMessage() );
        }

    }
    // Create a method called runQuery that accept a SQL Query
    // and return ResultSet Object
    public static ResultSet runQuery(String query){

//        ResultSet rs  = null;
        // reusing the connection built from previous method
        try {
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(query) ;

        } catch (SQLException e) {
            System.out.println("Error while getting resultset " + e.getMessage());
        }

        return rs ;

    }
    // create a method to clean up all the connection statemnet and resultset
    public static void destroy(){

        try {

            rs.close();
            stmnt.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }



    public static void main(String[] args) throws SQLException {

        createConnection();

        ResultSet rs =  runQuery("SELECT * FROM REGIONS");

        // print out second column first row
        rs.next();
        System.out.println(" rs.getString(2) = " + rs.getString(2)   );


    }
}
