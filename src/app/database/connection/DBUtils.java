package app.database.connection;

import app.model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by mda on 5/23/16.
 */
public class DBUtils {

    public static Connection getDBConnection() {

        String urlMySQL = "jdbc:mysql://localhost:3306/mysql_database";
        String login = "root";
        String password = "mysql";

        //  return getDBConnection("org.postgresql.Driver", urlPostgress, login, password);


        return getDBConnection("com.mysql.jdbc.Driver", urlMySQL, login, password);
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
        } finally {
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
        } finally {
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
        } finally {
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
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void addContact(Contact contact) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;


        String insertContactSQL = "INSERT INTO contact "
                + "(user_name, user_lastname, birthday, email_id, tel_id, address_id) "
                + " VALUES ('" +contact.getFirstName()+"','"+contact.getLastName()+"',"+"'1986-05-16'"+", 16, 16 ,16"+ ");";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(insertContactSQL);
            System.out.println("Contact is added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }


//    static void insert() {
//
//        Connection dbConnection = null;
//        Statement statement = null;
//
//
//
//        String insertTableSQL = "INSERT INTO DBUSER"
//                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
//                + "(1,'mkyong','system', " + "to_date('"
//                + getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))";
//
//
//        try {
//            dbConnection = getDBConnection();
//            statement = dbConnection.createStatement();
//
//            // выполняем запрос delete SQL
//            statement.execute(insertTableSQL);
//            System.out.println("Record is inserted into DBUSER table!");
//
//
//            ResultSet rs = statement.executeQuery("SELECT last_insert_id()");
//            if (rs.next()){
//                int key = rs.getInt(1);
//                System.out.println(key);
//            } else{
//                System.out.println("Error getting key");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    static void delete(){
//        Connection dbConnection = null;
//        Statement statement = null;
//
//        String deleteTableSQL = "DELETE DBUSER WHERE USER_ID = 1";
//
//        try {
//            dbConnection = getDBConnection();
//            statement = dbConnection.createStatement();
//
//            // выполняем запрос delete SQL
//            statement.execute(deleteTableSQL);
//            System.out.println("Record is deleted from DBUSER table!");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    static void update(){
//
//        Connection dbConnection = null;
//        Statement statement = null;
//
//        String updateTableSQL = "UPDATE DBUSER SET USERNAME = 'mkyong_new' WHERE USER_ID = 1";
//
//        try {
//            dbConnection = getDBConnection();
//            statement = dbConnection.createStatement();
//
//            // выполняем запрос update SQL
//            statement.execute(updateTableSQL);
//
//            System.out.println("Record is updated to DBUSER table!");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//    }

//    private static String getCurrentTimeStamp() {
//        Date today = new Date();
//        return dateFormat.format(today);
//    }

//    public void updateCoffeeSales(HashMap<String, Integer> salesForWeek)
//            throws SQLException {
//
//        PreparedStatement updateSales = null;
//        PreparedStatement updateTotal = null;
//
//        String dbName = "tempName";
//        String updateString = "update " + dbName + ".COFFEES " +
//                "set SALES = ? where COF_NAME = ?";
//
//        String updateStatement =
//                "update " + dbName + ".COFFEES " +
//                        "set TOTAL = TOTAL + ? " +
//                        "where COF_NAME = ?";
//
//        Connection con = getDBConnection();
//        try {
//            con.setAutoCommit(false);
//            updateSales = con.prepareStatement(updateString);
//
//            updateTotal = con.prepareStatement(updateStatement);
//
//            for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
//
//                updateSales.setInt(1, e.getValue().intValue());
//                updateSales.setString(2, e.getKey());
//                updateSales.executeUpdate();
//
//
//                updateTotal.setInt(1, e.getValue().intValue());
//                updateTotal.setString(2, e.getKey());
//                updateTotal.executeUpdate();
//
//                con.commit();
//            }
//        } catch (SQLException e ) {
//            e.printStackTrace();
//            if (con != null) {
//                try {
//                    System.err.print("Transaction is being rolled back");
//                    con.rollback();
//                } catch(SQLException excep) {
//                    excep.printStackTrace();
//                }
//            }
//        } finally {
//            if (updateSales != null) {
//                updateSales.close();
//            }
//            if (updateTotal != null) {
//                updateTotal.close();
//            }
//            con.setAutoCommit(true);
//        }
//    }
}




