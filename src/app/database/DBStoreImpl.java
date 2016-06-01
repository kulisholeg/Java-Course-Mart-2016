package app.database;

import app.model.Contact;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import static app.database.connection.DBUtils.getDBConnection;

/**
 * Created by PackardBell on 31.05.2016.
 */
public class DBStoreImpl implements DBStore {
    ResultSet res;


    @Override
    public Long add(Contact contact) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;


        String insertTableSQL = "INSERT INTO contact "
                + "(user_name, user_lastname, birthday, email_id, tel_id, address_id)"
                + " VALUES (" + contact.getFirstName() + contact.getLastName() + ",1984-08-01,8, 8 ,8"
                + ")";

        String returnUserID = "SELECT user_id WHERE user_name =" + contact.getFirstName();

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос delete SQL
            statement.execute(insertTableSQL);
            System.out.println("Add this user");
            res = statement.executeQuery(returnUserID);
            statement.execute(returnUserID);
            System.out.println("Return me him/his ID");


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


        return res.getLong(1);
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
            res = statement.executeQuery(getContactSQL);
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
        return (Contact) res;
    }

    @Override
    public Set<Contact> getContacts() {
        return null;
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
