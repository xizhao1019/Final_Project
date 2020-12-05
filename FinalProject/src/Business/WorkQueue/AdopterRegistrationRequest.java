/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.util.Random;

/**
 *
 * @author zhaoxi
 */
public class AdopterRegistrationRequest extends WorkRequest{
    
    private UserAccount adopterAccount;
    private String ID;
    private Random random = new Random();
    private String firstName;
    private String lastName;
    private String doB;
    private String number;
    private String email;
    
    private Network state;
    private String city;
    private String street;
    private String apt;
    private String zipCode;

    public AdopterRegistrationRequest() {
        String s = String.format("%04d", random.nextInt(10000));
        ID = "D"+ s;
    }
    
    public UserAccount getAdopterAccount() {
        return adopterAccount;
    }

    public void setAdopterAccount(UserAccount adopterAccount) {
        this.adopterAccount = adopterAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Network getState() {
        return state;
    }

    public void setState(Network state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
}
