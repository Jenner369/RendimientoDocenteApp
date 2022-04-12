package com.test;

import com.config.cnx;
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
        PreparedStatement vc = a.getConexion().prepareStatement("select ROUND((sum(puntaje)/count(*))) \"puntajes\", ROUND(sum(silabo)/count(*)) \"silabo\", ROUND(sum(asistencia)/count(*)) \"asistencia\", ROUND(sum(respo_social)/count(*)) \"respo_social\",    ROUND(sum(tutoria)/count(*))  \"social\",    ROUND(sum(encuesta)/count(*))\"encuesta\"   from    detalle_cuestionario where cuestionario_id_cuestionario = (select resultado.cuestionario_id_cuestionario from resultado where resultado.id_resultado = 1)");
        ResultSet xd =  vc.executeQuery();
        while (xd.next()) {
            System.out.println(xd.getString(2)+" - "+xd.getString(3));
        }
    }
}
