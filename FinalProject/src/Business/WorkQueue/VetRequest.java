/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Organization.Organization;

/**
 *
 * @author zhaoxi
 */
public class VetRequest extends WorkRequest{
    
    private Organization hospitalOrg;
    private boolean ableForShelter;
    
    public VetRequest() {
        this.ableForShelter = false;
    }

    public boolean isAbleForShelter() {
        return ableForShelter;
    }

    public void setAbleForShelter(boolean ableForShelter) {
        this.ableForShelter = ableForShelter;
    }

    public Organization getHospitalOrg() {
        return hospitalOrg;
    }

    public void setHospitalOrg(Organization hospitalOrg) {
        this.hospitalOrg = hospitalOrg;
    }
    
}
