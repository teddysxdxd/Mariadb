/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mariadb;

/**
 *
 * @author USUARIO
 */
  import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Conection {
    
    private static final String URL = "jdbc:mariadb://localhost:3307/prueba";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        
    
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Generar la consulta
            String query = "SELECT * FROM cliente";
            
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery(query);

            // Procesar los resultados
            while (resultSet.next()) {
                String nit = resultSet.getString("nit");
                String direccion = resultSet.getString("direccion");
                String nombre = resultSet.getString("nombre");
                
                System.out.println("NIT: " + nit + ", Dirección: " + direccion + ", Nombre: " + nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();

}
    } 
} 