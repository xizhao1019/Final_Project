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
public class ShelterRequest extends WorkRequest{
    
    private Organization shelterOrg;

    public Organization getShelterOrg() {
        return shelterOrg;
    }

    public void setShelterOrg(Organization shelterOrg) {
        this.shelterOrg = shelterOrg;
    }
    
}
