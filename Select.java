/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnectivity;

/**
 *
 * @author smvdu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

    public static Connection getConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/student";
        String username = "root";
        String password = "7298917198";

        Class.forName(driver);//used to load the JDBC driver class
        //causes the JDBC driver from some jdbc vendor to be loaded into the application
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
        } catch (Exception e) {
            System.out.println("Error in connection");
            e.printStackTrace();
        }

        System.out.println("conn=" + conn);

        // prepare query
        //String query = "select name,rollno from student where rollno LIKE " + 2;
        String query = "select name,rollno from student ";

        try {
            // create a statement
            stmt = conn.createStatement();

            // execute query and return result as a ResultSet
            rs = stmt.executeQuery(query);

            // extract data from the ResultSet
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                System.out.println("---------------");
                System.out.println("Name " + id);
                System.out.println("Roll " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // release database resources
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
