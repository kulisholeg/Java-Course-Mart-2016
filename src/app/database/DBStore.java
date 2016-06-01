package app.database;

import app.model.Contact;

import java.sql.SQLException;
import java.util.Set;

/**
 * Created by mda on 5/13/16.
 */
public interface DBStore {
    Long add(Contact contact) throws SQLException;
    Contact get(Long id) throws SQLException;
    Set<Contact> getContacts() throws SQLException;
    int remove(Long id);
    int remove(Contact contact);
    Set<Contact> search(Contact contact);
}
