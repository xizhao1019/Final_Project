/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Location.LocationPoint;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

/**
 *
 * @author zhaoxi
 */
public class ShelterRequest extends WorkRequest{
    
    private Organization shelterOrg;
    private LocationPoint hospitalLocationPoint;
    private UserAccount assignedStaff;
    private boolean post;
    
    public ShelterRequest() {
        this.post = false;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    
    public UserAccount getAssignedStaff() {
        return assignedStaff;
    }

    public void setAssignedStaff(UserAccount assignedStaff) {
        this.assignedStaff = assignedStaff;
    }

    public Organization getShelterOrg() {
        return shelterOrg;
    }

    public void setShelterOrg(Organization shelterOrg) {
        this.shelterOrg = shelterOrg;
    }

    public LocationPoint getHospitalLocationPoint() {
        return hospitalLocationPoint;
    }

    public void setHospitalLocationPoint(LocationPoint hospitalLocationPoint) {
        this.hospitalLocationPoint = hospitalLocationPoint;
    }
    
}
