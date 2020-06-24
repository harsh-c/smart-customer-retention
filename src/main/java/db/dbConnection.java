package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {
    public Connection connection;
    public Statement statement;
    Connection connection() {
        String classname = "org.sqlite.JDBC3";
        //Class.forName("org.sqlite.jdbc4");
        this.connection = null;
        try {
            // create a database connection
            this.connection = DriverManager.getConnection("jdbc:sqlite:scr.db");
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
//        finally {
//            try {
//                if (connection != null)
//                    connection.close();
//            } catch (SQLException e) {
//                // connection close failed.
//                System.err.println(e);
//            }
//        }
        return this.connection;
    }
    Statement statement()
    {
        try
        {
            this.statement = connection.createStatement();
            this.statement.setQueryTimeout(30);  // set timeout to 30 sec.
        }
        catch (SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        return this.statement;
    }
}