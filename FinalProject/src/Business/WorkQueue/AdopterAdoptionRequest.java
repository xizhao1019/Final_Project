/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Random;

/**
 *
 * @author zhaoxi
 */
public class AdopterAdoptionRequest extends WorkRequest{
    
    private AdopterRegistrationRequest adopter;
    private AnimalRecord animal;
    private String ID;
    private Random random;
    private String id;
    private boolean approved;

    public AdopterAdoptionRequest() {
        id = String.format("%04d", random.nextInt(10000));
        ID = "R" + id ;
        this.approved = false;
    }

    public String getID() {
        return ID;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved() {
        this.approved = true;
    } 

    public AdopterRegistrationRequest getAdopter() {
        return adopter;
    }

    public void setAdopter(AdopterRegistrationRequest adopter) {
        this.adopter = adopter;
    }

    public AnimalRecord getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalRecord animal) {
        this.animal = animal;
    }
    
    @Override
    public String toString(){
        return id;
    }
    
}
