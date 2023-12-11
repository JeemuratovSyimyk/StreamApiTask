package org.example.ServiceImpl;

import org.example.Entity.Phone;
import org.example.Service.PhoneService;
import org.example.db.DataBase;

import java.util.List;
import java.util.Scanner;

public class PhoneServiceImpl implements PhoneService {
    Scanner scanner = new Scanner(System.in);
    int num;
    private DataBase dataBase;

    public PhoneServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPhone(Phone phone) {
        System.out.println("add phone");
        if (dataBase.getPhoneList().add(phone)){
            return "Phone added successfully!";
    }else {
            return "Failed to add phone. Check your input";
        }
    }
    @Override
    public Phone getPhoneById(Long phoneId) {
        System.out.println("get phone by id");
     List<Phone> phones = dataBase.getPhoneList().stream()
             .filter(phone -> phone.getId()==phoneId)
             .toList();
        return phones.get(0);
    }

    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        System.out.println("update phone name by id");
       dataBase.getPhoneList().stream()
               .filter(phone -> phone.getId()==phoneId)
               .forEach(phone -> phone.setName(newName));
        return getPhoneById(phoneId);
    }

    @Override
    public List<Phone> getAllPhones() {
        System.out.println("get all phones");
        return dataBase.getPhoneList();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
       List<Phone> phones = dataBase.getPhoneList().stream()
               .filter(phone -> phone.getBrand().equals(brand))
               .toList();
        return phones;
    }
    @Override
    public void deletePhoneById(Long phoneId) {
   dataBase.getPhoneList().removeIf(phone -> phone.getId().equals(phoneId));
        System.out.println("successfully deleted");
    }
}


