package day4;

import org.junit.jupiter.api.*;
import utility.DB_Utility;

public class DB_Test {

    // create connection once and destroy it once

    @BeforeAll
    public static void init(){
        DB_Utility.createConnection();
    }

    @Test
    public void testEmployeeCount(){

        // run a query SELECT * FROM EMPLOYEES
        // assert that the employees count is 107


    }




    @AfterAll
    public static void tearDown(){
        DB_Utility.destroy();
    }


}