package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.CoordinatorAdminRole;
import Business.Role.CoordinatorRole;
import Business.Role.HospitalAdminRole;
import Business.Role.IncidentEnterpriseAdminRole;
import Business.Role.OperationEnterpriseAdminRole;
import Business.Role.RescueEnterpriseAdminRole;
import Business.Role.ShelterAdminRole;
import Business.Role.ShelterStaffRole;
import Business.Role.SystemAdminRole;
import Business.Role.VetRole;
import Business.Role.VolunteerRole;
import Business.Role.WitnessRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WitnessRegistrationRequest;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a system admin
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("s", "ss", employee, new SystemAdminRole());
        
        //Create a network
        Network state = system.createAndAddNetwork();
        state.setName("Massachusetts");
        
        //create an Incident Enterprise and a admin
        Enterprise incidentEnterprise = state.getEnterpriseDirectory().createAndAddEnterprise("MA_incident", Enterprise.EnterpriseType.Incident);
            Employee employee1 = incidentEnterprise.getEmployeeDirectory().createEmployee("IncidnetEnterpriseAdmin");
            UserAccount ua1 = incidentEnterprise.getUserAccountDirectory().createUserAccount("incidentadmin", "a", employee1, new IncidentEnterpriseAdminRole());
            ua1.setState(state);
//            ua1.setEnterprise(incidentEnterprise);
            
            
            //initialize incidentreporting organization and a witness
            Organization incidentReportingOrg =  incidentEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.IncidentReporting);
            incidentReportingOrg.setName("MA_IncidentReportingOrg");
//            ua1.setOrg(incidentReportingOrg);
            
            Employee employee2 = incidentReportingOrg.getEmployeeDirectory().createEmployee("Aaron");
            UserAccount ua2 = incidentReportingOrg.getUserAccountDirectory().createUserAccount("witness", "a", employee2, new WitnessRole());
            ua2.setState(state);
            WitnessRegistrationRequest witness = new WitnessRegistrationRequest();
            witness.setWitnessAccount(ua2);
            witness.setCity("Boston");
            witness.setStreetLine("360 Huntington Ave");
            witness.setApt("51");
            witness.setZipCode("02115");

            incidentReportingOrg.getWorkQueue().getWorkRequestList().add(witness);
//            ua2.setEnterprise(incidentEnterprise);
//            ua2.setOrg(incidentReportingOrg);
            
        //create a Operation Enterprise and a admin
        Enterprise operationEnterprise = state.getEnterpriseDirectory().createAndAddEnterprise("MA_operation", Enterprise.EnterpriseType.Operation);
            Employee employee12 = operationEnterprise.getEmployeeDirectory().createEmployee("OperationEnterpriseAdmin");
            UserAccount ua12 = operationEnterprise.getUserAccountDirectory().createUserAccount("operationadmin", "a", employee12, new OperationEnterpriseAdminRole());
            ua12.setState(state);
//            ua12.setEnterprise(operationEnterprise);
//            ua12.setOrg(null);
            
             //initialize a incident management organization, a admin and 2 coordinators
            Organization incidentManagementOrg =  operationEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.IncidentManagement);
            incidentManagementOrg.setName("MA_IncidentManagementOrg");
            
            Employee employee13 = incidentManagementOrg.getEmployeeDirectory().createEmployee("Jane");
            UserAccount ua13 = incidentManagementOrg.getUserAccountDirectory().createUserAccount("coadmin", "a", employee13, new CoordinatorAdminRole());
            ua13.setState(state);
//            ua13.setEnterprise(operationEnterprise);
//            ua13.setOrg(incidentManagementOrg);
            
            
            Employee employee14 = incidentManagementOrg.getEmployeeDirectory().createEmployee("Kim");
            UserAccount ua14 = incidentManagementOrg.getUserAccountDirectory().createUserAccount("co1", "a", employee14, new CoordinatorRole());
            ua14.setState(state);
//            ua14.setEnterprise(operationEnterprise);
//            ua14.setOrg(incidentManagementOrg);
            
            Employee employee15 = incidentManagementOrg.getEmployeeDirectory().createEmployee("Linda");
            UserAccount ua15 = incidentManagementOrg.getUserAccountDirectory().createUserAccount("co2", "a", employee15, new CoordinatorRole());
            ua15.setState(state);
//            ua15.setEnterprise(operationEnterprise);
//            ua15.setOrg(incidentManagementOrg);
            
            
        //create a Rescue Enterprise and a admin
        Enterprise rescueEnterprise = state.getEnterpriseDirectory().createAndAddEnterprise("MA_rescue", Enterprise.EnterpriseType.Rescue);
            Employee employee3 = rescueEnterprise.getEmployeeDirectory().createEmployee("RescueEnterpriseAdmin");
            UserAccount ua3 = rescueEnterprise.getUserAccountDirectory().createUserAccount("rescueadmin", "a", employee3, new RescueEnterpriseAdminRole());
            ua3.setState(state);
//            ua3.setEnterprise(rescueEnterprise);
//            ua3.setOrg(null);
            
            //initialize a volunteer organization and 2 volunteers
            Organization volunteerOrg =  rescueEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.Volunteer);
            volunteerOrg.setName("MA_VolunteerOrg");
           
            Employee employee4 = volunteerOrg.getEmployeeDirectory().createEmployee("Bob");
            UserAccount ua4 = volunteerOrg.getUserAccountDirectory().createUserAccount("volunteer1", "a", employee4, new VolunteerRole());
            ua4.setState(state);
//            ua4.setEnterprise(rescueEnterprise);
//            ua4.setOrg(volunteerOrg);
            
            Employee employee5 = volunteerOrg.getEmployeeDirectory().createEmployee("Celia");
            UserAccount ua5 = volunteerOrg.getUserAccountDirectory().createUserAccount("volunteer2", "a", employee5, new VolunteerRole());
            ua5.setState(state);
//            ua5.setEnterprise(rescueEnterprise);
//            ua5.setOrg(volunteerOrg);    
            
            
            //initialize a hospital organization, 1 hospital admin and 2 vets
            Organization hospitalOrg =  rescueEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.AnimalHospital);
            hospitalOrg.setName("MA_HospitalOrg");
            
            Employee employee6 = hospitalOrg.getEmployeeDirectory().createEmployee("David");
            UserAccount ua6 = hospitalOrg.getUserAccountDirectory().createUserAccount("hospitaladmin", "a", employee6, new HospitalAdminRole());
            ua6.setState(state);
//            ua6.setEnterprise(rescueEnterprise);
//            ua6.setOrg(hospitalOrg);  
            
            
            Employee employee7 = hospitalOrg.getEmployeeDirectory().createEmployee("Ella");
            UserAccount ua7 = hospitalOrg.getUserAccountDirectory().createUserAccount("vet1", "a", employee7, new VetRole());
            ua7.setState(state);
//            ua7.setEnterprise(rescueEnterprise);
//            ua7.setOrg(hospitalOrg);
            
            Employee employee8= hospitalOrg.getEmployeeDirectory().createEmployee("Frank");
            UserAccount ua8 = hospitalOrg.getUserAccountDirectory().createUserAccount("vet2", "a", employee8, new VetRole());
            ua8.setState(state);
//            ua8.setEnterprise(rescueEnterprise);
//            ua8.setOrg(hospitalOrg);
            
            //initialize a shelter organization, 1 shelter admin and 2 staff
            Organization shelterOrg =  rescueEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.AnimalShelter);
            shelterOrg.setName("MA_ShelterOrg");
            
            Employee employee9 = shelterOrg.getEmployeeDirectory().createEmployee("Gigi");
            UserAccount ua9 = shelterOrg.getUserAccountDirectory().createUserAccount("shelteradmin", "a", employee9, new ShelterAdminRole());
            ua9.setState(state);
//            ua9.setEnterprise(rescueEnterprise);
//            ua9.setOrg(shelterOrg);
            
            Employee employee10 = shelterOrg.getEmployeeDirectory().createEmployee("Helen");
            UserAccount ua10 = shelterOrg.getUserAccountDirectory().createUserAccount("staff1", "a", employee10, new ShelterStaffRole());
            ua10.setState(state);
//            ua10.setEnterprise(rescueEnterprise);
//            ua10.setOrg(shelterOrg);
            
            Employee employee11 = shelterOrg.getEmployeeDirectory().createEmployee("Isabella");
            UserAccount ua11 = shelterOrg.getUserAccountDirectory().createUserAccount("staff2", "a", employee11, new ShelterStaffRole());
            ua11.setState(state);
//            ua11.setEnterprise(rescueEnterprise);
//            ua11.setOrg(shelterOrg);
        
        return system;
    }
    
}
