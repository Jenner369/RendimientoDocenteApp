package com.jenner369.rendimientodocenteapp.dao;

import com.jenner369.rendimientodocenteapp.bean.Docente;
import com.jenner369.rendimientodocenteapp.config.cnx;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAO {
    cnx cn;
    Connection con;
    Docente b;
    CallableStatement cs;
    private ResultSet rs;

    public DocenteDAO() throws SQLException, IOException {
        this.cn = new cnx();
    }

    //procediminetos almacenados
    public void RegistrarCliente(String nombre1, String apellido_p1, String apellido_m1, String usuario1, String password1, String imagen1) throws SQLException {
        try {
            String sql = "call veterinaria.Agregar_Cliente(?, ?, ?, ?, ?, ?);";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            cs.setString(1, nombre1);
            cs.setString(2, apellido_p1);
            cs.setString(3, apellido_m1);
            cs.setString(4, usuario1);
            cs.setString(5, password1);
            cs.setString(6, imagen1);
            cs.execute();
            cs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    public void EliminarCliente(int ID1) throws SQLException {
        try {
            String sql = "call veterinaria.Eliminar_Cliente(?);";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            cs.setInt(1, ID1);
            cs.execute();
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    // 
    public void ActualizarCliente(int ID1, String nombre1, String apellido_p1, String apellido_p2, String usuario1, String password1, String imagen1) throws SQLException {
        try {
            String sql = "call veterinaria.Actualizar_Cliente(?, ?, ?, ?, ?, ?, ?);";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            cs.setInt(1, ID1);
            cs.setString(2, nombre1);
            cs.setString(3, apellido_p1);
            cs.setString(4, apellido_p2);
            cs.setString(5, usuario1);
            cs.setString(6, password1);
            cs.setString(7, imagen1);
            cs.execute();
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
