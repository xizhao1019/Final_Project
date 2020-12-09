/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

/**
 *
 * @author zhaoxi
 */
public class HospitalRequest extends WorkRequest{
    
    private Organization hospitalOrg;
    private UserAccount orgAdmin;
    private UserAccount assignedVet;

    public Organization getHospitalOrg() {
        return hospitalOrg;
    }

    public void setHospitalOrg(Organization hospitalOrg) {
        this.hospitalOrg = hospitalOrg;
    }

    public UserAccount getOrgAdmin() {
        return orgAdmin;
    }

    public void setOrgAdmin(UserAccount orgAdmin) {
        this.orgAdmin = orgAdmin;
    }

    public UserAccount getAssignedVet() {
        return assignedVet;
    }

    public void setAssignedVet(UserAccount assignedVet) {
        this.assignedVet = assignedVet;
    }
    
}
