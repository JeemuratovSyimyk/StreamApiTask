package org.example;


import org.example.Entity.Contact;
import org.example.Entity.Phone;
import org.example.ServiceImpl.ContactServiceImpl;
import org.example.ServiceImpl.PhoneServiceImpl;
import org.example.db.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num;

        DataBase dataBase = new DataBase();
        PhoneServiceImpl phoneService = new PhoneServiceImpl(dataBase);
        ContactServiceImpl contactService = new ContactServiceImpl(dataBase);


        while (true) {

            System.out.println("""
                    1-add phone                     7-add contact to phone
                    2-get phone by id               8-find contact by name
                    3-update phone name by id       9-find contact by phone number
                    4-get all phones                10-sort contacts by name
                    5-get all phones by brand       11-delete contact by name from phone
                    6-delete phone by id            12-add one more contact
                                                    13-add one more contact
                              """);

            switch (num = scanner.nextInt()) {
                case 1:
                   List<Phone> phone1 = new ArrayList<>(
                           List.of(new Phone(1L, "iPhone ", "Apple",new ArrayList<>()),
                                   new Phone(2L, "Pixel 6", "Google",new ArrayList<>()),
                                   new Phone(3L, "Pixel 7", "Google",new ArrayList<>()),
                                   new Phone(4L, "Poco", "Xiaomi",new ArrayList<>())));
                 for (Phone phone: phone1)
                   System.out.println(phoneService.addPhone(phone));

                case 2:
                    System.out.println(phoneService.getPhoneById(4L));
                     break;
                case 3:
                    System.out.println(phoneService.updatePhoneNameById(4L, "Samsung"));
                case 4:
                    System.out.println(phoneService.getAllPhones());
                case 5:
                    System.out.println("Enter the brand:");
                    String brand = scanner.next();
                  List<Phone> getBrand = phoneService.getAllPhonesByBrand(brand);
                    System.out.println(getBrand.isEmpty()
                            ? "Phones of the specified brand were not found."
                            : "Phones by brand " + brand + ":\n" + getBrand
                            .stream().map(Object::toString).collect(Collectors.joining("\n")));
                case 6:
                    phoneService.deletePhoneById(3L);

                case 7:
                  contactService.addContactToPhone(1L,
                          new Contact("Nursultan","+996501479356"));
                case 8:
                    System.out.println(contactService.addContactToPhone(1L,
                            new Contact("Samat", "+996778597181")));
                case 9:
                    System.out.println(contactService.addContactToPhone(1L,
                            new Contact("Rasul", "+996708917871")));
                case 10:
                    System.out.println(contactService.findContactByName(2L, "Samat"));
                case 11:
                    System.out.println(contactService.findContactByPhoneNumber(1L, "+996778597181"));
                case 12:
                    System.out.println(contactService.sortContactsByName(2L));
                case 13:
                    contactService.deleteContactByNameFromPhone(1L,"Rasul");
            }
        }
        }
    }


