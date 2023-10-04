package Utils;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.List;
import java.util.Scanner;
import model.Contact;

/**
 *
 * @author Dai Nhan
 */
public class Utils {
    
    public String getInput(String src){
        Scanner sc = new Scanner(System.in);
        System.out.println(src);
        return sc.nextLine();
    }
    
    public Contact searchContactById(int id, List<Contact> phoneBook) {
        for (Contact contact : phoneBook) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }
}   
