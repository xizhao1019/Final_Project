/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author zhaoxi
 */
public class PetOwnerAdoptionRequest extends WorkRequest{
    
    private PetOwnerRegistrationRequest petOwner;
    private AnimalRecord animal;

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
