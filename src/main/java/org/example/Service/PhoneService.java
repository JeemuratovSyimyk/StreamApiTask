package org.example.Service;

import org.example.Entity.Phone;

import java.util.List;

public interface PhoneService {
      String addPhone(Phone phone);
      Phone getPhoneById(Long phoneId);
      Phone updatePhoneNameById(Long phoneId, String newName);
      List<Phone> getAllPhones();
      List<Phone> getAllPhonesByBrand(String brand);
      void deletePhoneById(Long phoneId);


}
