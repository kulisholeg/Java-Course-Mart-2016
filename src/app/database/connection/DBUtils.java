package app.database.connection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mda on 5/23/16.
 */
public class DBUtils {

    public static Connection getDBConnection(){

        String urlMySQL = "jdbc:mysql://localhost:3306/mysql_database";
        String login = "root";
        String password = "mysql";

        //  return getDBConnection("org.postgresql.Driver", urlPostgress, login, password);


        return getDBConnection("com.mysql.jdbc.Driver", urlMySQL,login, password);
//        return getDBConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:mkyong","username","password");
    }

    private static Connection getDBConnection(String dbDriver,
                                              String dbConnection,
                                              String dbUser,
                                              String dbPassword) {
        Connection connection = null;
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void createContactTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE contact("
                + "user_id INTEGER NOT NULL, "
                + "user_name VARCHAR(20) NOT NULL, "
                + "user_lastname VARCHAR(20) NOT NULL, "
                + "email_id VARCHAR(50) NOT NULL, "
                + "tel_id INTEGER NOT NULL, "
                + "birthday DATE NOT NULL, "
                + "address_id INTEGER NOT NULL, "
                + "PRIMARY KEY (user_id) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"contact\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void createAddressTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = " CREATE TABLE address("
                + "address_id INTEGER NOT NULL, "
                + "country  VARCHAR (30) NOT NULL, "
                + "city VARCHAR (20) NULL, "
                + "street VARCHAR(250) NOT NULL, "
                + "house_number INTEGER NOT NULL, "
                + "house_suffix VARCHAR (20) NOT NULL, "
                + "appartment INTEGER NOT NULL, "
                + "post_code INTEGER NOT NULL, "
                + "PRIMARY KEY (address_id) "
                + "FOREIGN KEY (user_id) REFERENCES contact(user_id)  " +
                "ON DELETE CASCADE " +
                "ON UPDATE CASCADE "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"address\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void createTelNumberTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE tel_number("
                + "tel_id INTEGER NOT NULL, "
                + "tel_number VARCHAR (20) NOT NULL, "
                + "PRIMARY KEY (tel_id) "
                + "FOREIGN KEY (user_id) REFERENCES contact(user_id)  " +
                "ON DELETE CASCADE " +
                "ON UPDATE CASCADE "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"tel_number\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void createEmailTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE email("
                + "email_id INTEGER NOT NULL, "
                + "email VARCHAR (255) NOT NULL, "
                + "PRIMARY KEY (email_id) "
                + "FOREIGN KEY (user_id) REFERENCES contact(user_id)  " +
                "ON DELETE CASCADE " +
                "ON UPDATE CASCADE "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"email\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }



}
