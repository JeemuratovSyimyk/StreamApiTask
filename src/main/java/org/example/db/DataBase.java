package org.example.db;

import lombok.Getter;
import lombok.Setter;
import org.example.Entity.Contact;
import org.example.Entity.Phone;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class DataBase {
    private List<Phone> phoneList = new ArrayList<>();
    private List<Contact> contacts = new ArrayList<>();
}
