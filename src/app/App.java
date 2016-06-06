package app;

import app.database.DBStoreImpl;
import app.database.connection.DBUtils;
import app.model.Contact;
import app.parse.GsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.parse.GsonParser.readJsonStream;
import static app.parse.GsonParser.writeJsonStream;

/**
 * Created by mda on 5/13/16.
 */
public class App {
    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("Start");

//        Connection dbConnection = DBUtils.getDBConnection();
//        DBUtils.createAddressTable(dbConnection);

//        Connection dbConnection = DBUtils.getDBConnection();
//        DatabaseMetaData metaData = dbConnection.getMetaData();
//        metaData.getCatalogs();

//        DBUtils.createContactTable();
//        DBUtils.createAddressTable();
//        DBUtils.createTelNumberTable();
//        DBUtils.createEmailTable();



            Contact contact1 = new Contact();
//        contact1.setFirstName("somename");
//        contact1.setLastName("somelastname");
//        DBUtils.addContact(contact1);
//
//        DBStoreImpl store = new DBStoreImpl();
//        System.out.println(contact1.getId());





        String path = "files/in/contacts.json";
        List<Contact> contacts = readJsonStream(new FileInputStream(path));

//        for (Contact contact: contacts) {
//            System.out.println("ID = " + contact.getId());
//            System.out.println("firstName = " + contact.getFirstName());
//            System.out.println(" ");
//
//            contact.setId(contact.getId());
//        }
        writeJsonStream(new FileOutputStream(path), contacts);
        DBStoreImpl a = new DBStoreImpl();
        a.addTelNumbers(contact1);
        a.add(contact1);








    }
}
