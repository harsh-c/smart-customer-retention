package db;
import  db.dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class user {
    // for adding a new user into table - user
    public void add_user(String user, String referred_user){
        dbConnection dbconn = new dbConnection();
        Connection connection = dbconn.connection();
        Statement statement = dbconn.statement();
        try
        {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY, user_name TEXT NOT NULL, referred_user TEXT NOT NULL)" );
            statement.executeUpdate("insert into user(user_name, referred_user) values('"+user+ "','" +referred_user+"')");
        }
        catch (SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

    //retrieving referred users from user table by user_name
    public List get_users(String user_name){
        List<String> ref_users = new ArrayList<String>();
        dbConnection dbconn = new dbConnection();
        Connection connection = dbconn.connection();
        Statement statement = dbconn.statement();
        try
        {
            ResultSet rs = statement.executeQuery("select referred_user from user where user_name = '"+user_name+"'");
            while(rs.next())
            {
                ref_users.add(rs.getString("referred_user"));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
        return  ref_users;
    }

}
