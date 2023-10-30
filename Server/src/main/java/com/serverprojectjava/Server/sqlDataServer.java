package com.serverprojectjava.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.serverprojectjava.Server.Module.Employee;
import com.serverprojectjava.Server.Module.Products;
import com.serverprojectjava.Throw.ExceptionServer;

public class sqlDataServer {

    private Connection connection = null;

    public void init() throws ExceptionServer{
        this.loadDataBase();
    }

    private void loadDataBase() throws ExceptionServer{
        try {
            String url = "jdbc:sqlite:src/main/resources/DataBase/dataServer.sqlite";
            this.connection = DriverManager.getConnection(url);
            System.out.println("Connect database success");
        } catch (Exception e) {
            throw new ExceptionServer("Lỗi kết nối đến cơ sở dữ liệu SQLite: " + e.getMessage());
        }
    }

    /*
     * get all data in database of Employee table
     */
    public List<Employee> getAllDataEmployee(){
        List<Employee> dataEmployees = new ArrayList<>();

        try (Statement statement = this.connection.createStatement()) {
            // Thực hiện truy vấn SELECT
            String sql = "SELECT * FROM Employee";
            ResultSet resultSet = statement.executeQuery(sql);

            // Xử lý kết quả truy vấn
            try {
                while (resultSet.next()) {
                    
                    dataEmployees.add(
                        new Employee(   
                            resultSet.getString("ID"), 
                            resultSet.getString("name"), 
                            resultSet.getInt("CCCD"), 
                            resultSet.getString("DateJoint"), 
                            resultSet.getInt("Salary")
                        )
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataEmployees;
    }

    /*
     * get all data in database of Products table
     */
    public List<Products> getAllDataProducts(){
        List<Products> dataProducts = new ArrayList<>();

        try (Statement statement = this.connection.createStatement()) {
            // Thực hiện truy vấn SELECT
            String sql = "SELECT * FROM Products";
            ResultSet resultSet = statement.executeQuery(sql);

            // Xử lý kết quả truy vấn
            try {
                while (resultSet.next()) {
                    
                    dataProducts.add(
                        new Products(
                            resultSet.getInt("ID"), 
                            resultSet.getString("Name"), 
                            resultSet.getInt("Price"), 
                            resultSet.getBytes("Image"))
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataProducts;
    }
}
