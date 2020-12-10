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
public class PetOwnerAdoptionRequest extends WorkRequest{
    
    private PetOwnerRegistrationRequest petOwner;
    private AnimalRecord animal;
    private String ID;
    //private Random random;
    private int id;
    private boolean approved;

    public PetOwnerAdoptionRequest() {
        //id = String.format("%04d", random.nextInt(10000));
        Random rand = new Random();
        id = rand.nextInt(10000);
        ID = "R" + id;
        this.approved = false;
    }

    public String getID() {
        return ID;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean isApproved) {
        this.approved = isApproved;
    }

    public PetOwnerRegistrationRequest getAdopter() {
        return petOwner;
    }

    public void setAdopter(PetOwnerRegistrationRequest petOwner) {
        this.petOwner = petOwner;
    }

    public AnimalRecord getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalRecord animal) {
        this.animal = animal;
    }
    
    @Override
    public String toString(){
        return ID;
    }
    
}
