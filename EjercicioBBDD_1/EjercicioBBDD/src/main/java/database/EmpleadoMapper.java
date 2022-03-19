package database;

import models.Empleado;

import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpleadoMapper {
    public ArrayList<Empleado> map(ResultSet result) throws Exception{
        ArrayList<Empleado> empleados = new ArrayList<>();
        while(result.next()){
            Empleado emp1 = new Empleado();
            emp1.setId(result.getInt("id"));
            emp1.setNombre(result.getString("nombre"));
            emp1.setApellido(result.getString("apellido"));
            emp1.setTelefono(result.getString("telefono"));
            emp1.setEmail(result.getString("email"));
            emp1.setAntiguedad(result.getInt("antiguedad"));
            emp1.setSalario(result.getDouble("salario"));
            emp1.setNombrePuesto(result.getString("puesto"));
            emp1.setMunicipalidad(result.getString("municipalidad"));
            empleados.add(emp1);
        }
        return empleados;
    }
}
