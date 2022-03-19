import database.EmpleadoMapper;
import database.EmpleadoQueryBuilder;
import database.SQLConnection;
import io.EmpleadoScanner;
import models.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Statement statement;
    //Se crea el encargado de crear las queries de MySql.
    private static final EmpleadoQueryBuilder empleadoQueryBuilder = new EmpleadoQueryBuilder();

    public static void main(String[] args) {
        SQLConnection sqlConnection = new SQLConnection();
        try{
            //Se crea la conexion con la base de datos.
           statement = sqlConnection.open();

            dropEmpleadoTableIfNeeded();
            createTableEmpleado();
            insertEmpleados();
            readEmpleados();

            //Se cierra la conexion con la base de datos
            sqlConnection.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    //Se realiza un DROP de la tabla Empleados si existe.
    private static void dropEmpleadoTableIfNeeded() throws Exception{
        String dropTableQuery = empleadoQueryBuilder.buildDropTableQuery();
        statement.executeUpdate(dropTableQuery);
    }

    //Se crea la tabla EMPLEADO.
    private static void createTableEmpleado() throws Exception{
        String createTableQuery = empleadoQueryBuilder.buildCreateTableQuery();
        statement.executeUpdate(createTableQuery);
    }

    //Se insertan datos ingresados por pantalla a la tabla EMPLEADO
    private static void insertEmpleados() throws Exception{
        EmpleadoScanner empleadoScanner = new EmpleadoScanner();
        ArrayList<Empleado> empleadosTomadosPorPantalla = empleadoScanner.scan();
        statement.executeUpdate(empleadoQueryBuilder.buildInsertQuery(empleadosTomadosPorPantalla));
    }

    //Se leen los datos existentes en la tabla EMPLEADO con el filtro requerido.
    private static void readEmpleados() throws Exception{
        ResultSet result = statement.executeQuery(empleadoQueryBuilder.buildSelectQuery());
        EmpleadoMapper empleadoMapper = new EmpleadoMapper();
        ArrayList<Empleado> empleados = empleadoMapper.map(result);
        System.out.println("------Los empleados que cumplen con los requisitos son: \n");
        empleados.stream().forEach(e -> System.out.println("\n" + e.toString()));
    }

}