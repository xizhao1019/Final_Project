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
public class HospitalRequest extends WorkRequest{
    
    private Organization hospitalOrg;

    public Organization getHospitalOrg() {
        return hospitalOrg;
    }

    public void setHospitalOrg(Organization hospitalOrg) {
        this.hospitalOrg = hospitalOrg;
    }
    
}