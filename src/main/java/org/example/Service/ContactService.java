package org.example.Service;

import org.example.Entity.Contact;

import java.util.List;

public interface ContactService {
    String addContactToPhone(Long phoneId, Contact contact);
    Contact findContactByName(Long phoneId, String contactName);
    Contact findContactByPhoneNumber(Long phoneId, String phoneNumber);
     List<Contact> sortContactsByName(Long phoneId);
     void deleteContactByNameFromPhone(Long phoneId, String contactName);
}
