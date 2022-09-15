/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marina.hoffmann
 */
public class FabricaConexao {
    private static final String TIMEZONE ="?useTimezone=true&serverTimezone=UTC";
    private static final String DBNAME = "aulacrud";
    private static final String DATABASE = "jdbc:mysql://localhost:3306/" 
            + DBNAME + TIMEZONE;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Senac2021";
    
    public static Connection abrirConexao() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        } catch (ClassNotFoundException classNotFoundException){
            System.out.println("Erro no driver do SQL");
        }
        return null;
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement psmt, 
            ResultSet rs) throws SQLException{
        if (rs != null){
            rs.close();
        }
        conn.close();
        psmt.close();
    }
}
