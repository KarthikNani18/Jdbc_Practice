package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String url = "jdbc:mysql://localhost:3306/karthik";
    static String userName = "root";
    static String password = "root";

    public static void main(String[] args) throws SQLException {
//        createTable();
//        insertData();
//        readData();
//        updateData();
//        deleteData();
//        deleteAll();
          insertDataUsingPrepared();

    }

    private static void insertDataUsingPrepared() throws SQLException {

        String query="INSERT INTO Employees (id, name, age) VALUES (?,?,?)";
        int id=101;
        String name="karthik";
        int age=87;
        Connection connection=DriverManager.getConnection(url, userName,password);
        PreparedStatement statement=connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.setString(2,name);
        statement.setInt(3,age);
        int res=statement.executeUpdate();
        System.out.println(res+" updated");
    }

    private static void deleteAll() throws SQLException {

        String query="DROP TABLE Employees;";
        Connection connection=DriverManager.getConnection(url, userName,password);
        Statement statement=connection.createStatement();
        int res= statement.executeUpdate(query);
        System.out.println("successfully removed "+  res);

    }

    private static void deleteData() throws SQLException {

        int id=1;
        String query="DELETE FROM Employees WHERE id = "+id;
        Connection connection=DriverManager.getConnection(url, userName,password);
        Statement statement=connection.createStatement();
    int res=statement.executeUpdate(query);

        System.out.println("sucessfully removed : "+res);
    }

    private static void updateData() throws SQLException {
        int id=3;
        String query="UPDATE Employees SET name = 'David Green' WHERE id = "+id;
        Connection connection=DriverManager.getConnection(url,userName,password);
        Statement statement=connection.createStatement();
        int res=statement.executeUpdate(query);
        System.out.println("success "+ res);


    }

    private static void readData() throws SQLException {
        String query="SELECT * FROM Employees";
        Connection connection=DriverManager.getConnection(url,userName,password);
        Statement statement=connection.createStatement();
       ResultSet set= statement.executeQuery(query);
        while(set.next())
        {
            System.out.println("Id : "+set.getInt(1));
            System.out.println("Name : "+set.getString(2));
            System.out.println("Age : "+set.getInt(3));
            System.out.println();
        }


    }

    private static void insertData() throws SQLException {

        String query="INSERT INTO Employees (id, name, age) VALUES (1, 'Alice Smith', 30) ,(2, 'Bob Johnson', 25), (3, 'Charlie Brown', 35)";
        Connection connection=DriverManager.getConnection(url,userName,password);
        Statement statement=connection.createStatement();
        int res= statement.executeUpdate(query);
        System.out.println(res+"  rows created");
    }

    private static void createTable() throws SQLException {

        String query = "CREATE TABLE Employees ( id INT PRIMARY KEY, name VARCHAR(100) ,age INT)";
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        int res = statement.executeUpdate(query);
        System.out.println(res + " rows created");


    }
    


}