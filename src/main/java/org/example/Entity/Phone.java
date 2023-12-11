package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class Phone {
    private Long id;
    private String name;
    private String brand;
    private List<Contact>contacts;

    public Phone(Long id, String name, String brand, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.contacts = contacts;
    }

    public Phone(Long id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "\nPhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}

