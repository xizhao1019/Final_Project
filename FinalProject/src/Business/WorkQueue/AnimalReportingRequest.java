/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Location.LocationPoint;
import Business.Network.Network;
import Business.UserAccount.UserAccount;

/**
 *
 * @author zhaoxi
 */
public class AnimalReportingRequest extends WorkRequest{
    
    private Network state;
    private String city;
    private LocationPoint animalLocationPoint;
    private String animalType;
    private String imagePath;
    private UserAccount AssignedCoordinator;
    private UserAccount witness;

    public UserAccount getAssignedCoordinator() {
        return AssignedCoordinator;
    }

    public void setAssignedCoordinator(UserAccount AssignedCoordinator) {
        this.AssignedCoordinator = AssignedCoordinator;
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

    public LocationPoint getAnimalLocationPoint() {
        return animalLocationPoint;
    }

    public void setAnimalLocationPoint(LocationPoint animalLocationPoint) {
        this.animalLocationPoint = animalLocationPoint;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public UserAccount getWitness() {
        return witness;
    }

    public void setWitness(UserAccount witness) {
        this.witness = witness;
    }
    
}
