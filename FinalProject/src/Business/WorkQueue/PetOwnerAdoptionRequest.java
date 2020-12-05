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
    private Random random;
    private String id;
    private boolean adopted;

    public PetOwnerAdoptionRequest() {
        id = String.format("%04d", random.nextInt(10000));
        ID = "R" + id ;
        this.adopted = false;
    }

    public String getID() {
        return ID;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public PetOwnerRegistrationRequest getArr() {
        return petOwner;
    }

    public void setArr(PetOwnerRegistrationRequest petOwner) {
        this.petOwner = petOwner;
    }

    public AnimalRecord getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalRecord animal) {
        this.animal = animal;
    }
    
}
