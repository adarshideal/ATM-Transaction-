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
import java.sql.Statement;

public class Update {

    public static void main(String[] argv) throws Exception {
        String driver = "com.mysql.jdbc.Driver";

        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        System.out.println(con.toString());
        

        String name = "\"Anuj\"";
        String roll = "\"2\"";
        String query = "UPDATE student set name =  "+name +" where rollno = "+ roll;

        System.out.println("Query :" + query);
        Statement st = con.createStatement();
        int val = st.executeUpdate(query);// returns zero when the result is empty else no. of rows

        System.out.println("1 row affected");
        con.close();
    }
}
