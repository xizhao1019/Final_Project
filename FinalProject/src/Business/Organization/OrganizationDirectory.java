/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.IncidentReporting.getValue())){
            organization = new IncidentReportingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Volunteer.getValue())){
            organization = new VolunteerOrganization();
            organizationList.add(organization);
        } 
        else if (type.getValue().equals(Type.AnimalHospital.getValue())){
            organization = new AnimalHospitalOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.AnimalShelter.getValue())){
            organization = new AnimalShelterOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Adopter.getValue())){
            organization = new AdopterOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PetOwner.getValue())){
            organization = new PetOwnerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.IncidentManagement.getValue())) {
            organization = new IncidentManagementOrganization();
            organizationList.add(organization);          
        }
        return organization;
    }
}