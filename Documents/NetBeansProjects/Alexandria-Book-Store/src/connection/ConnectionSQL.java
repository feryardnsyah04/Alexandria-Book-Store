/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package connection;

/**
 *
 * @author Fery
 */
import java.sql.*;
import javax.swing.*;

public class ConnectionSQL {
    private Connection con;
    private Statement stm;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    private static final String URL = "jdbc:mysql://localhost:3306/alexandriadb";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public void databaseConnection() {
        try {
            setCon(DriverManager.getConnection(URL, USER, PASSWORD));
            setStm(getCon().createStatement());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
        }
    }
    
    public Connection getConnection() {
        return getCon();
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the stm
     */
    public Statement getStm() {
        return stm;
    }

    /**
     * @param stm the stm to set
     */
    public void setStm(Statement stm) {
        this.stm = stm;
    }
}