package org.example.ServiceImpl;

import org.example.Entity.Contact;
import org.example.Entity.Phone;
import org.example.Service.ContactService;
import org.example.db.DataBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactServiceImpl implements ContactService {
    private DataBase dataBase;

    public ContactServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
  dataBase.getPhoneList().stream()
          .filter(phone -> phone.getId().equals(phoneId))
          .forEach(phone-> phone.getContacts().add(contact));
        return "The contact was successfully saved in Contact";
    }
    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
  List<Phone> list = dataBase.getPhoneList().stream()
          .filter(phone -> phone.getId().equals(phoneId)).toList();
   List<Contact> list1 = list.get(0).getContacts().stream()
           .filter(contact -> contact.getName().equals(contactName)).toList();
        return list1.get(0);
    }

      @Override
     public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
    List<Phone> list = dataBase.getPhoneList().stream()
            .filter(phone -> phone.getId().equals(phoneId)).toList();
      List<Contact> list1 = list.get(0).getContacts().stream()
              .filter(contact -> contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)).toList();
        return list1.get(0);
    }
    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
      List<Phone> list = dataBase.getPhoneList().stream()
              .filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> contacts = new ArrayList<>(list.get(0).getContacts());
     contacts.sort(Comparator.comparing(Contact::getName));
  for (Contact contact: contacts){
      System.out.println(contact.getName());
  }
        return contacts;
    }

    @Override
    public void deleteContactByNameFromPhone(Long phoneId, String contactName) {
   List<Phone> list = dataBase.getPhoneList().stream()
           .filter(phone -> phone.getId().equals(phoneId)).toList();
   list.get(0).getContacts().removeIf(contact-> contact.getName().equalsIgnoreCase(contactName));
        System.out.println("Contact deleted successfully");
    }
}
