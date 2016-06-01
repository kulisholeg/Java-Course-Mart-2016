package app;

import app.database.DBStoreImpl;
import app.database.connection.DBUtils;
import app.model.Contact;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by mda on 5/13/16.
 */
public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println("Start");

//        Connection dbConnection = DBUtils.getDBConnection();
//        DBUtils.createAddressTable(dbConnection);

        Connection dbConnection = DBUtils.getDBConnection();
        DatabaseMetaData metaData = dbConnection.getMetaData();
        metaData.getCatalogs();

//        DBUtils.createContactTable();
//        DBUtils.createAddressTable();
//        DBUtils.createTelNumberTable();
//        DBUtils.createEmailTable();

        Contact contact1 = new Contact();
        contact1.setFirstName("Umar");
        contact1.setLastName("Zanori");
        DBUtils.addContact(contact1);






    }
}
