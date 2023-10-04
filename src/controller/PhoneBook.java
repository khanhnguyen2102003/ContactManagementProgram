/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Utils.Utils;
import java.util.ArrayList;
import java.util.List;
import model.Contact;
import view.Menu;

/**
 *
 * @author Dai Nhan
 */
public class PhoneBook extends Menu<String> {

    private List<Contact> phoneBook;
    private Utils utils;

    public PhoneBook() {
        super("==============Contact Menu==============", new String[]{
            "Add a contact", "Display all contacts", "Delete a contact", "Exit"
        });
        this.phoneBook = new ArrayList<Contact>();
        utils = new Utils();
    }

    public List<Contact> getList() {
        return phoneBook;
    }

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            dispplay();
            String choice = utils.getInput("Input choice: ");
            switch (choice) {
                case "1":
                    addAContact();
                    break;
                case "2":
                    displayAllContacts();
                    break;
                case "3":
                    deleteAContact();
                    break;
                case "4":
                    System.out.println("Exit...");
                    exit = true;
                    break;
            }
        }
    }

    public void addAContact() {
        System.out.println("1. Add contract automatically");
        System.out.println("2. Add contract manually");
        String choice = utils.getInput("Input choice: ");
        if (choice.equals("1")) {
            Contact contact1 = new Contact(1,
                    "Tên 1",
                    "Họ 1",
                    "Nhóm 1",
                    "Địa chỉ 1",
                    "Số điện thoại 1");

            Contact contact2 = new Contact(2,
                    "Tên 2",
                    "Họ 2",
                    "Nhóm 2",
                    "Địa chỉ 2",
                    "Số điện thoại 2");

            Contact contact3 = new Contact(3,
                    "Tên 3",
                    "Họ 3",
                    "Nhóm 3",
                    "Địa chỉ 3",
                    "Số điện thoại 3");

            phoneBook.add(contact1);
            phoneBook.add(contact2);
            phoneBook.add(contact3);
        } else if (choice.equals("2")) {

            int id;
            String fisrtName, lastName, group, address, phone;
            if (phoneBook.isEmpty()) {
                id = 1;
            } else {
                id = phoneBook.get(phoneBook.size() - 1).getId() + 1;
            }
            fisrtName = utils.getInput("Input First Name: ");
            lastName = utils.getInput("Input Last Name: ");
            group = utils.getInput("Input Group: ");
            phone = utils.getInput("Input Phone: ");
            address = utils.getInput("Input Address: ");

            phoneBook.add(new Contact(id, fisrtName, lastName, group, address, phone));
        }
    }

    public void displayAllContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("Non Contact!");
        } else {
            System.out.printf("%-5s | %-20s | %-10s | %-10s | %-10s | %-20s | %-20s%n",
                    "ID", "Họ và tên", "Tên", "Họ", "Nhóm", "Số điện thoại", "Địa chỉ");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            for (Contact contact : phoneBook) {

                System.out.printf("%-5d | %-20s | %-10s | %-10s | %-10s | %-20s | %-20s%n",
                        contact.getId(), contact.getFullName(), contact.getFirstName(),
                        contact.getLastName(), contact.getGroup(), contact.getPhone(),
                        contact.getAddress());
            }
        }
    }

    public void deleteAContact() {
        int id = Integer.parseInt(utils.getInput("Input Id to search: "));
        for (Contact contact : phoneBook) {
            if (contact.equals(utils.searchContactById(id, phoneBook))) {
                System.out.println("Contact will be deleted");
                System.out.printf("%-5d | %-20s | %-10s | %-10s | %-10s | %-20s | %-20s%n",
                        contact.getId(), contact.getFullName(), contact.getFirstName(),
                        contact.getLastName(), contact.getGroup(), contact.getPhone(),
                        contact.getAddress());
                        phoneBook.remove(contact);
            }

        }
    }
}
