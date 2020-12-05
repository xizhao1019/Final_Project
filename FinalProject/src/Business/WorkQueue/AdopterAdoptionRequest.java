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
    private boolean adopted;

    public AdopterAdoptionRequest() {
        this.id = String.format("%04d", random.nextInt(10000));
        this.ID = "R" + id ;
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

    public AdopterRegistrationRequest getArr() {
        return adopter;
    }

    public void setArr(AdopterRegistrationRequest arr) {
        this.adopter = arr;
    }

    public AnimalRecord getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalRecord animal) {
        this.animal = animal;
    }
    
}
