/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Location.LocationPoint;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.util.Random;

/**
 *
 * @author zhaoxi
 */
public class AnimalReportingRequest extends WorkRequest{
    
    private String CaseID;
    private Random random = new Random();
    
    private Network state;
    private String city;
    private LocationPoint animalLocationPoint;
    private String animalType;
    private String imagePath;
    private UserAccount AssignedCoordinator;
    private boolean isNewReported;
    private UserAccount witness;
    
    private UserAccount volunteer;

    public AnimalReportingRequest() {
        CaseID = String.format("%04d", random.nextInt(10000));
        isNewReported = true;
    }

    public boolean isIsNewReported() {
        return isNewReported;
    }

    public void setIsNewReported(boolean isNewReported) {
        this.isNewReported = isNewReported;
    }

    public UserAccount getAssignedCoordinator() {
        return AssignedCoordinator;
    }

    public void setAssignedCoordinator(UserAccount AssignedCoordinator) {
        this.AssignedCoordinator = AssignedCoordinator;
    }

    public UserAccount getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(UserAccount volunteer) {
        this.volunteer = volunteer;
    }
    
    
    

    public String getCaseID() {
        return CaseID;
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
    
        @Override
    public String toString() {
       return CaseID;   
    }
    
}
