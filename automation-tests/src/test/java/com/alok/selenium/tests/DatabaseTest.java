package com.alok.selenium.tests;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DatabaseTest {

    // ✅ Database connection details (replace with your actual DB info)
    String dbUrl = "jdbc:mysql://db4free.net:3306/yourDatabaseName";
    String username = "alokswain";
    String password = "alokswain";

    @Test
    public void insertAndValidateRecord() throws Exception {

        // ✅ Step 1: Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // ✅ Step 2: Establish connection to the database
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        // ✅ Step 3: Create a statement object to run SQL queries
        Statement stm = con.createStatement();

        // ✅ Step 4: Insert a record into the 'users' table
        String insertQuery = "INSERT INTO users(name, email) VALUES ('Alok', 'alok@gmail.com')";
        stm.executeUpdate(insertQuery);

        // ✅ Step 5: Select the inserted record to validate
        String selectQuery = "SELECT email FROM users WHERE name='Alok'";
        ResultSet rs = stm.executeQuery(selectQuery);

        // ✅ Step 6: Validate the result using assertions
        boolean recordFound = false;
        while (rs.next()) {
            String email = rs.getString("email");
            Assert.assertEquals(email, "alok@gmail.com", "Email does not match!");
            recordFound = true;
        }

        // ✅ Step 7: Final assertion to ensure record was found
        Assert.assertTrue(recordFound, "Record not found in database");

        // ✅ Step 8: Close all DB resources
        rs.close();
        stm.close();
        con.close();
    }

    /*
     🔍 Where Selenium Fits In (Real-Time Use Case):

     // Step A: Perform UI actions using Selenium
     driver.findElement(By.id("name")).sendKeys("Alok");
     driver.findElement(By.id("email")).sendKeys("alok@gmail.com");
     driver.findElement(By.id("submit")).click();

     // Step B: Then use JDBC (as above) to validate that the data
     // was correctly inserted into the database.

     ✅ This is how you combine Selenium (UI) + JDBC (DB) for full end-to-end testing.
    */
}
