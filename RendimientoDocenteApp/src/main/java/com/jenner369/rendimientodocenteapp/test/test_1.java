package com.jenner369.rendimientodocenteapp.test;

import com.jenner369.rendimientodocenteapp.config.cnx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jedur
 */
public class test_1 {
    public static void main(String[] args) throws SQLException {
        cnx a = new cnx();
        PreparedStatement vc = a.getConexion().prepareStatement("select * from employees");
        ResultSet xd =  vc.executeQuery();
        while (xd.next()) {
            System.out.println(xd.getString(2)+" - "+xd.getString(3));
        }
    }
}
