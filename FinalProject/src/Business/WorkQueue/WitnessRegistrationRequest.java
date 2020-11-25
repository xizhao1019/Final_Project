/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Network.Network;
import Business.UserAccount.UserAccount;

/**
 *
 * @author zhaoxi
 */
public class WitnessRegistrationRequest extends WorkRequest{
    
    private UserAccount witnessAccount;
    private Network state;
    private String city;
    private String streetLine;
    private String apt;
    private String zipCode;

    public UserAccount getWitnessAccount() {
        return witnessAccount;
    }

    public void setWitnessAccount(UserAccount witnessAccount) {
        this.witnessAccount = witnessAccount;
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

    public String getStreetLine() {
        return streetLine;
    }

    public void setStreetLine(String streetLine) {
        this.streetLine = streetLine;
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
