package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cnx {

    private String USERNAME = "hr";
    private String PASSWORD = "hr";
    private String HOST = "localhost";
    private String PORT = "1521";
    private String DATABASE = "veterinaria";
    private String CLASSNAME = "oracle.jdbc.driver.OracleDriver";
    private String URL = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":xe";

    private Connection con;

    public cnx() throws SQLException {

        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Error 1: " + e);
        } catch (SQLException e) {
            System.err.println("Error 2: " + e);
        }
    }

    public Connection getConexion() {
        return con;  //retornar el objeto que contiene la conexión
    }
}
