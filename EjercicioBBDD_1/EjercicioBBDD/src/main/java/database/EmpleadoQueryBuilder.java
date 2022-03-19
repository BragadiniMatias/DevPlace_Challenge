package database;

import models.Empleado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmpleadoQueryBuilder {

    public String buildInsertQuery(ArrayList<Empleado> empleados){
       return
                "INSERT INTO EMPLEADO " +
                        " (nombre," +
                        " apellido," +
                        " telefono," +
                        " email," +
                        " antiguedad," +
                        " salario," +
                        " puesto," +
                        " municipalidad) " +
                "VALUES " +
                        empleados.stream().map(e -> buildEmpleadoValues(e)).collect(Collectors.joining(", "));
    }

    public String buildCreateTableQuery(){
        return "CREATE TABLE EMPLEADO ("+
                "id INT(11) NOT NULL AUTO_INCREMENT,"+
                "       nombre VARCHAR(40) NOT NULL,"+
                "       apellido VARCHAR(40) NOT NULL,"+
                "       telefono VARCHAR(25) NOT NULL,"+
                "       email VARCHAR(40) NOT NULL,"+
                "       antiguedad INT(11) NOT NULL,"+
                "       salario DOUBLE NOT NULL,"+
                "       puesto VARCHAR(25) NOT NULL,"+
                "       municipalidad VARCHAR(30) NOT NULL,"+
                "PRIMARY KEY (id)"+
                ")";
    }

    public String buildDropTableQuery(){
        return "DROP TABLE IF EXISTS EMPLEADO";
    }

    public String buildSelectQuery(){
        return "SELECT * FROM EMPLEADO WHERE salario > 70000 AND antiguedad < 15 AND antiguedad > 10";
    }

    private String buildEmpleadoValues(Empleado empleado){
        return
                "(" +
                " '" + empleado.getNombre() + "'," +
                "'" + empleado.getApellido() + "'," +
                "'" + empleado.getTelefono() + "'," +
                "'" + empleado.getEmail() + "'," +
                empleado.getAntiguedad() + "," +
                empleado.getSalario() + "," +
                "'" + empleado.getNombrePuesto()+"'," +
                "'" + empleado.getMunicipalidad() + "'" +
                ")";
    }
}
