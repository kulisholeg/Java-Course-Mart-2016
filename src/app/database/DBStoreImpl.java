package app.database;

import app.model.Contact;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import static app.database.connection.DBUtils.getDBConnection;

/**
 * Created by PackardBell on 31.05.2016.
 */
public class DBStoreImpl implements DBStore {



    @Override
    public Long add(Contact contact) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;


        String insertTableSQL = "INSERT INTO contact "
                + "(user_name, user_lastname, birthday, email_id, tel_id, address_id)"
                + " VALUES ('" + contact.getFirstName() + "','"+contact.getLastName() + "','birthday',8, 8 ,8"
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос delete SQL
            statement.execute(insertTableSQL);

            ResultSet rs = statement.executeQuery("select last_insert_id() as last_id from contact");
            Long lastid ;

            if(rs.first()) {
                lastid = rs.getLong("last_id");
                return  lastid;
            }


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



        return null;
    }

    public Long addTelNumbers(Contact contact) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;


        String insertTableSQL = "INSERT INTO tel_number "
                + "(tel_number)"
                + " VALUES (" + "phones"
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос telNumber
            statement.execute(insertTableSQL);

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



        return null;
    }

    public Long addEmails(Contact contact) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;


        String insertTableSQL = "INSERT INTO emails "
                + "(email)"
                + " VALUES (" + "emails"
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос delete SQL
            statement.execute(insertTableSQL);

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



        return null;
    }



    @Override
    public Contact get(Long id) throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;


        String getContactSQL = "SELECT  * FROM contact WHERE  id = " + id;



        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос SELECT SQL
            statement.executeQuery(getContactSQL);
            System.out.println("База, дай мне контакт! ");

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
        return null;
    }

    @Override
    public Set<Contact> getContacts() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        Set<Contact> contactSet = new HashSet<>();

        String getAllContactsSQL = "SELECT  * FROM contact";


        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос SELECT SQL
            statement.executeQuery(getAllContactsSQL);

            System.out.println("База, дай мне все контакты! ");

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
        return contactSet;
    }



    @Override
    public int remove(Long id) {
        return 0;
    }

    @Override
    public int remove(Contact contact) {
        return 0;
    }

    @Override
    public Set<Contact> search(Contact contact) {
        return null;
    }
}
