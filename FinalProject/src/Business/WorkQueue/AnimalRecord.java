/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Location.LocationPoint;
import java.util.Random;

/**
 *
 * @author zhaoxi
 */
public class AnimalRecord extends WorkRequest{
    
    private AnimalReportingRequest reportingRequest;
    private VolunteerRequest volunteerRequest;
    private HospitalRequest hospitalRequest;
    private VetRequest vetRequest;
    private ShelterRequest shelterRequest;
    private ShelterStaffRequest shelterStaffRequest;
            
    private LocationPoint shelterLocationPoint;
    private String petName;
    private String breed;
    private String age;
    private String healthCondition;
    private String imagePath;
    private String ID;
    private String id;
    private Random random = new Random();
    
    public AnimalRecord() {
        this.reportingRequest = new AnimalReportingRequest();
        this.volunteerRequest = new VolunteerRequest();
        this.hospitalRequest = new HospitalRequest();
        this.vetRequest = new VetRequest();
        this.shelterRequest = new ShelterRequest();
        this.shelterStaffRequest = new ShelterStaffRequest();
        this.shelterLocationPoint = new LocationPoint();
        id = String.format("%04d",random.nextInt(10000));
        ID = "A" + id;
    }
            
    
    public VolunteerRequest getVolunteerRequest() {
        return volunteerRequest;
    }

    public void setVolunteerRequest(VolunteerRequest volunteerRequest) {
        this.volunteerRequest = volunteerRequest;
    }

    public HospitalRequest getHospitalRequest() {
        return hospitalRequest;
    }

    public void setHospitalRequest(HospitalRequest hospitalRequest) {
        this.hospitalRequest = hospitalRequest;
    }

    public VetRequest getVetRequest() {
        return vetRequest;
    }

    public void setVetRequest(VetRequest vetRequest) {
        this.vetRequest = vetRequest;
    }

    public ShelterRequest getShelterRequest() {
        return shelterRequest;
    }

    public void setShelterRequest(ShelterRequest shelterRequest) {
        this.shelterRequest = shelterRequest;
    }

    public ShelterStaffRequest getShelterStaffRequest() {
        return shelterStaffRequest;
    }

    public void setShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) {
        this.shelterStaffRequest = shelterStaffRequest;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthStatus) {
        this.healthCondition = healthStatus;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocationPoint getShelterLocationPoint() {
        return shelterLocationPoint;
    }

    public void setShelterLocationPoint(LocationPoint shelterLocation) {
        this.shelterLocationPoint = shelterLocation;
    }

    public AnimalReportingRequest getReportingRequest() {
        return reportingRequest;
    }

    public void setReportingRequest(AnimalReportingRequest reportingRequest) {
        this.reportingRequest = reportingRequest;
    }

    public String getID() {
        return ID;
    }
    
    @Override
    public String toString() {
       return ID;   
    }
    
}
