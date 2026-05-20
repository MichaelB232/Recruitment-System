/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author micha
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {

    public static Connection conn;

    private static String url_db = "jdbc:mysql://localhost:3306/recruit_db";
    private static String user = "root";
    private static String pass = "";

    public static Connection connect() {
        try {
            System.out.println("Successfully connect to database");
            conn = DriverManager.getConnection(url_db, user, pass);
            return conn;
        } catch (SQLException e) {
            System.out.println("Failed to connect Databaseaaaa");
        }
        return conn;
    }
}
