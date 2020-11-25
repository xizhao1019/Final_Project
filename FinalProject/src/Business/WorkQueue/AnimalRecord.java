/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author zhaoxi
 */
public class AnimalRecord extends WorkRequest{
    
    private int CaseID;
    private static int count = 1;
    
    private VolunteerRequest volunteerRequest;
    private HospitalRequest hospitalRequest;
    private ShelterRequest shelterRequest;
            
    private String petName;
    private String breed;
    private String age;
    private String imagePath;
            
    public AnimalRecord() {
        CaseID = count;
        count++;
    }
    
    public int getCaseID() {
        return CaseID;
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

    public ShelterRequest getShelterRequest() {
        return shelterRequest;
    }

    public void setShelterRequest(ShelterRequest shelterRequest) {
        this.shelterRequest = shelterRequest;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
    
}
