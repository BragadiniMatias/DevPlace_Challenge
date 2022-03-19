package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLConnection {

    private final String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10479938";
    private final String user = "sql10479938";
    private final String password = "7RQprWwEtF";
    private Connection con;

    public Statement open() throws Exception{
        con = DriverManager.getConnection(
                url, user, password);
        return con.createStatement();
    }

    public void close() throws Exception{
        con.close();
    }
}
