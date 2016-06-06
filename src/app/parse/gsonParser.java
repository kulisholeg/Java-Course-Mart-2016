package app.parse;

import app.model.Contact;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import parse.gson.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;

/**
 * Created by PackardBell on 06.06.2016.
 */
public class GsonParser {
    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {

        String path = "files/in/contacts.json";

        List<Contact> contacts = readJsonStream(new FileInputStream(path));

        for (Contact contact: contacts) {
            System.out.println("firstName = " + contact.getFirstName());
            System.out.println("lastName = " + contact.getLastName());

            contact.setId(contact.getId());
        }

        writeJsonStream(new FileOutputStream(path), contacts);
    }

    public static List<Contact> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));

        List<Contact> contacts = new ArrayList<Contact>();
        reader.beginArray();
        while (reader.hasNext()) {
            Contact contact = gson.fromJson(reader, Contact.class);
            contacts.add(contact);
        }
        reader.endArray();
        reader.close();

        return contacts;
    }

    public static void writeJsonStream(OutputStream out, List<Contact> contacts) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writer.beginArray();
        for (Contact contact : contacts) {
            gson.toJson(contact, Contact.class, writer);
        }
        writer.endArray();
        writer.close();
        }


    }
