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
public class AdopterAdoptionRequest extends WorkRequest{
    
    private AdopterRegistrationRequest adopter;
    private AnimalRecord animal;

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
