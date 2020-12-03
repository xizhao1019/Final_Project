/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Location.LocationPoint;
import Business.UserAccount.UserAccount;

/**
 *
 * @author zhaoxi
 */
public class VolunteerRequest extends WorkRequest {
    
    private LocationPoint volunteerLocationPoint;
    private LocationPoint hospitalLocationPoint;
    
    private UserAccount volunteer;
    
    public VolunteerRequest() {
        
    }
    
    public LocationPoint getVolunteerLocationPoint() {
        return volunteerLocationPoint;
    }

    public void setVolunteerLocationPoint(LocationPoint volunteerLocationPoint) {
        this.volunteerLocationPoint = volunteerLocationPoint;
    }

    public LocationPoint getHospitalLocationPoint() {
        return hospitalLocationPoint;
    }

    public void setHospitalLocationPoint(LocationPoint hospitalLocationPoint) {
        this.hospitalLocationPoint = hospitalLocationPoint;
    }

    public UserAccount getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(UserAccount volunteer) {
        this.volunteer = volunteer;
    }
    
    
    
}
