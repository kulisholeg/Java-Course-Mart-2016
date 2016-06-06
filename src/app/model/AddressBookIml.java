package app.model;

import java.util.*;

/**
 * Created by mda on 5/13/16.
 */
public class AddressBookIml implements AddressBook {
    private Set<Contact> contacts = new HashSet<>();

    @Override
    public boolean add(Contact contact) {
        return contacts.add(contact);
    }

    @Override
    public boolean add(Collection<Contact> contacts) {
        return this.contacts.addAll(contacts);
    }

    @Override
    public boolean remove(Contact contact) {
        return contacts.remove(contact);
    }

    @Override
    public boolean edit(Contact contact) {
        if(contacts.contains(contact)){
            contacts.remove(contact);
            contacts.add(contact);
            return true;
        }

        return false;
    }

    @Override
    public Set<Contact> getContacts() {
        return contacts;
    }

    @Override
    public Contact getContact(Long id) {
//        for (Contact cnt: contacts) {
//            if(cnt.id.equals(id)){
//                return cnt;
//            }
//        }

        return null;
    }

    @Override
    public Set<Contact> search(Contact contact) {
        return null;
    }
}
