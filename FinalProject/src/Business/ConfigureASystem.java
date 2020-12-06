package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.AdopterRole;
import Business.Role.AdoptionEnterpriseAdminRole;
import Business.Role.CoordinatorAdminRole;
import Business.Role.CoordinatorRole;
import Business.Role.HospitalAdminRole;
import Business.Role.IncidentEnterpriseAdminRole;
import Business.Role.OperationEnterpriseAdminRole;
import Business.Role.PetOwnerRole;
import Business.Role.RescueEnterpriseAdminRole;
import Business.Role.ShelterAdminRole;
import Business.Role.ShelterStaffRole;
import Business.Role.SystemAdminRole;
import Business.Role.VetRole;
import Business.Role.VolunteerRole;
import Business.Role.WitnessRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdopterRegistrationRequest;
import Business.WorkQueue.PetOwnerRegistrationRequest;
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
            
            //initialize incidentreporting organization and a witness
            Organization incidentReportingOrg =  incidentEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.IncidentReporting);
            incidentReportingOrg.setName("MA_IncidentReportingOrg");
            
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
            ua2.getWorkQueue().getWorkRequestList().add(witness);
            
            
        //create a Operation Enterprise and a admin
        Enterprise operationEnterprise = state.getEnterpriseDirectory().createAndAddEnterprise("MA_operation", Enterprise.EnterpriseType.Operation);
            Employee employee12 = operationEnterprise.getEmployeeDirectory().createEmployee("OperationEnterpriseAdmin");
            UserAccount ua12 = operationEnterprise.getUserAccountDirectory().createUserAccount("operationadmin", "a", employee12, new OperationEnterpriseAdminRole());
            ua12.setState(state);
            
             //initialize a incident management organization, a admin and 2 coordinators
            Organization incidentManagementOrg =  operationEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.IncidentManagement);
            incidentManagementOrg.setName("MA_IncidentManagementOrg");
            
            Employee employee13 = incidentManagementOrg.getEmployeeDirectory().createEmployee("Jane");
            UserAccount ua13 = incidentManagementOrg.getUserAccountDirectory().createUserAccount("coadmin", "a", employee13, new CoordinatorAdminRole());
            ua13.setState(state);
            
            Employee employee14 = incidentManagementOrg.getEmployeeDirectory().createEmployee("Kim");
            UserAccount ua14 = incidentManagementOrg.getUserAccountDirectory().createUserAccount("co1", "a", employee14, new CoordinatorRole());
            ua14.setState(state);
            
            Employee employee15 = incidentManagementOrg.getEmployeeDirectory().createEmployee("Linda");
            UserAccount ua15 = incidentManagementOrg.getUserAccountDirectory().createUserAccount("co2", "a", employee15, new CoordinatorRole());
            ua15.setState(state);
            
        //create a Rescue Enterprise and a admin
        Enterprise rescueEnterprise = state.getEnterpriseDirectory().createAndAddEnterprise("MA_rescue", Enterprise.EnterpriseType.Rescue);
            Employee employee3 = rescueEnterprise.getEmployeeDirectory().createEmployee("RescueEnterpriseAdmin");
            UserAccount ua3 = rescueEnterprise.getUserAccountDirectory().createUserAccount("rescueadmin", "a", employee3, new RescueEnterpriseAdminRole());
            ua3.setState(state);
            
            //initialize a volunteer organization and 2 volunteers
            Organization volunteerOrg =  rescueEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.Volunteer);
            volunteerOrg.setName("MA_VolunteerOrg");
           
            Employee employee4 = volunteerOrg.getEmployeeDirectory().createEmployee("Bob");
            UserAccount ua4 = volunteerOrg.getUserAccountDirectory().createUserAccount("volunteer1", "a", employee4, new VolunteerRole());
            ua4.setState(state);
            
            Employee employee5 = volunteerOrg.getEmployeeDirectory().createEmployee("Celia");
            UserAccount ua5 = volunteerOrg.getUserAccountDirectory().createUserAccount("volunteer2", "a", employee5, new VolunteerRole());
            ua5.setState(state);
            
            //initialize a hospital organization, 1 hospital admin and 2 vets
            //hospitalorg1
            Organization hospitalOrg1 =  rescueEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.AnimalHospital);
            hospitalOrg1.setName("MA_HospitalOrg");
            
            Employee employee6 = hospitalOrg1.getEmployeeDirectory().createEmployee("David");
            UserAccount ua6 = hospitalOrg1.getUserAccountDirectory().createUserAccount("hospitaladmin", "a", employee6, new HospitalAdminRole());
            ua6.setState(state);
            
            Employee employee7 = hospitalOrg1.getEmployeeDirectory().createEmployee("Ella");
            UserAccount ua7 = hospitalOrg1.getUserAccountDirectory().createUserAccount("vet1", "a", employee7, new VetRole());
            ua7.setState(state);
         
            Employee employee8= hospitalOrg1.getEmployeeDirectory().createEmployee("Frank");
            UserAccount ua8 = hospitalOrg1.getUserAccountDirectory().createUserAccount("vet2", "a", employee8, new VetRole());
            ua8.setState(state);
            
            //hospitalorg2
            Organization hospitalOrg2 =  rescueEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.AnimalHospital);
            hospitalOrg2.setName("MA_HospitalOrg2");
            
            Employee employee16 = hospitalOrg2.getEmployeeDirectory().createEmployee("Jack");
            UserAccount ua16 = hospitalOrg2.getUserAccountDirectory().createUserAccount("hospitaladmin2", "a", employee16, new HospitalAdminRole());
            ua16.setState(state);
            
            Employee employee17 = hospitalOrg2.getEmployeeDirectory().createEmployee("Kevin");
            UserAccount ua17 = hospitalOrg2.getUserAccountDirectory().createUserAccount("vet3", "a", employee17, new VetRole());
            ua17.setState(state);
            
            Employee employee18= hospitalOrg2.getEmployeeDirectory().createEmployee("Lauran");
            UserAccount ua18 = hospitalOrg2.getUserAccountDirectory().createUserAccount("vet4", "a", employee18, new VetRole());
            ua18.setState(state);
            
            //initialize a shelter organization, 1 shelter admin and 2 staff
            //shelterorg1
            Organization shelterOrg1 =  rescueEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.AnimalShelter);
            shelterOrg1.setName("MA_ShelterOrg");
            
            Employee employee9 = shelterOrg1.getEmployeeDirectory().createEmployee("Gigi");
            UserAccount ua9 = shelterOrg1.getUserAccountDirectory().createUserAccount("shelteradmin", "a", employee9, new ShelterAdminRole());
            ua9.setState(state);
          
            Employee employee10 = shelterOrg1.getEmployeeDirectory().createEmployee("Helen");
            UserAccount ua10 = shelterOrg1.getUserAccountDirectory().createUserAccount("staff1", "a", employee10, new ShelterStaffRole());
            ua10.setState(state);
            
            Employee employee11 = shelterOrg1.getEmployeeDirectory().createEmployee("Isabella");
            UserAccount ua11 = shelterOrg1.getUserAccountDirectory().createUserAccount("staff2", "a", employee11, new ShelterStaffRole());
            ua11.setState(state);
            
            //shelterorg2
            Organization shelterOrg2 =  rescueEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.AnimalShelter);
            shelterOrg2.setName("MA_ShelterOrg2");
            
            Employee employee19 = shelterOrg2.getEmployeeDirectory().createEmployee("Mike");
            UserAccount ua19 = shelterOrg2.getUserAccountDirectory().createUserAccount("shelteradmin2", "a", employee19, new ShelterAdminRole());
            ua19.setState(state);
            
            Employee employee20 = shelterOrg2.getEmployeeDirectory().createEmployee("Nicole");
            UserAccount ua20 = shelterOrg2.getUserAccountDirectory().createUserAccount("staff3", "a", employee20, new ShelterStaffRole());
            ua20.setState(state);
            
            Employee employee21 = shelterOrg2.getEmployeeDirectory().createEmployee("Oscar");
            UserAccount ua21 = shelterOrg2.getUserAccountDirectory().createUserAccount("staff4", "a", employee21, new ShelterStaffRole());
            ua21.setState(state);
            
        //create a Adoption Enterprise and a admin
        Enterprise adoptionEnterprise = state.getEnterpriseDirectory().createAndAddEnterprise("MA_adoption", Enterprise.EnterpriseType.Adoption);
            Employee employee22 = adoptionEnterprise.getEmployeeDirectory().createEmployee("AdoptionEnterpriseAdmin");
            UserAccount ua22 = adoptionEnterprise.getUserAccountDirectory().createUserAccount("adoptionadmin", "a", employee22, new AdoptionEnterpriseAdminRole());
            ua22.setState(state);
            //initialize 1 adopter organization, 2 adopters
            Organization adopterOrg =  adoptionEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.Adopter);
            adopterOrg.setName("MA_AdopterOrg");
            
            Employee employee23 = adopterOrg.getEmployeeDirectory().createEmployee("Peter Pearson");
            UserAccount ua23 = adopterOrg.getUserAccountDirectory().createUserAccount("adopter1", "a", employee23, new AdopterRole());
            ua23.setState(state);
            AdopterRegistrationRequest adopter1 = new AdopterRegistrationRequest();
                adopter1.setAdopterAccount(ua23);
                adopter1.setFirstName("Peter");
                adopter1.setLastName("Pearson");
                adopter1.setDoB("10-13-1989");
                adopter1.setNumber("6173732000");
                adopter1.setEmail("ppeter@northeasten.edu");
                adopter1.setState(state);
                adopter1.setCity("Boston");
                adopter1.setStreet("97 Weastern Ave");
                adopter1.setApt("43");
                adopter1.setZipCode("04923");
            adopterOrg.getWorkQueue().getWorkRequestList().add(adopter1);
            ua23.getWorkQueue().getWorkRequestList().add(adopter1);
            
            Employee employee24 = adopterOrg.getEmployeeDirectory().createEmployee("James C.Bean");
            UserAccount ua24 = adopterOrg.getUserAccountDirectory().createUserAccount("adopter2", "a", employee24, new AdopterRole());
            ua24.setState(state);
            AdopterRegistrationRequest adopter2 = new AdopterRegistrationRequest();
                adopter2.setAdopterAccount(ua24);
                adopter2.setFirstName("James");
                adopter2.setLastName("C.Bean");
                adopter2.setDoB("7-02-1972");
                adopter2.setNumber("6173234252");
                adopter2.setEmail("jbean@northeasten.edu");
                adopter2.setState(state);
                adopter2.setCity("Quincy");
                adopter2.setStreet("48 Jakeson Street");
                adopter2.setApt("5");
                adopter2.setZipCode("04238");
            adopterOrg.getWorkQueue().getWorkRequestList().add(adopter2);
            ua24.getWorkQueue().getWorkRequestList().add(adopter2);
            
            //initialize 1 petOwner2 organization, 2 petOwners
            Organization perOwnerOrg =  adoptionEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.PetOwner);
            perOwnerOrg.setName("MA_PetOwnerOrg");
            Employee employee25 = perOwnerOrg.getEmployeeDirectory().createEmployee("Gail Serra");
            UserAccount ua25 = perOwnerOrg.getUserAccountDirectory().createUserAccount("petowner1", "a", employee25, new PetOwnerRole());
            ua25.setState(state);
            PetOwnerRegistrationRequest petOwner1 = new PetOwnerRegistrationRequest();
                petOwner1.setPetOwnerAccount(ua25);
                petOwner1.setFirstName("Gail");
                petOwner1.setLastName("Serra");
                petOwner1.setDoB("8-4-1998");
                petOwner1.setNumber("682049824");
                petOwner1.setEmail("g.serra@northeastern.edu");
                petOwner1.setState(state);
                petOwner1.setCity("Newton");
                petOwner1.setStreet("716 Columbus Avenue");
                petOwner1.setApt("3");
                petOwner1.setZipCode("02823");

                petOwner1.setAnimalType("Dog");
                petOwner1.setBreed("Golden Retrevier");
                petOwner1.setAge("5 Month");
                petOwner1.setPetName("Jeffery");
                petOwner1.setImagePath("./Golden_Jeffery");
                perOwnerOrg.getWorkQueue().getWorkRequestList().add(petOwner1);
                ua25.getWorkQueue().getWorkRequestList().add(petOwner1);
                
            Employee employee26 = perOwnerOrg.getEmployeeDirectory().createEmployee("Ayush Jain");
            UserAccount ua26 = perOwnerOrg.getUserAccountDirectory().createUserAccount("petowner2", "a", employee26, new PetOwnerRole());
            ua26.setState(state);
            PetOwnerRegistrationRequest petOwner2 = new PetOwnerRegistrationRequest();
                petOwner2.setPetOwnerAccount(ua26);
                petOwner2.setFirstName("Ayush");
                petOwner2.setLastName("Jain");
                petOwner2.setDoB("11-23-1990");
                petOwner2.setNumber("9376283425");
                petOwner2.setEmail("a.jain@northeastern.edu");
                petOwner2.setState(state);
                petOwner2.setCity("Wrochester");
                petOwner2.setStreet("876 Strait Avenue");
                petOwner2.setApt("52");
                petOwner2.setZipCode("83749");

                petOwner2.setAnimalType("Dog");
                petOwner2.setBreed("Labrado");
                petOwner2.setAge("12 Month");
                petOwner2.setPetName("Rocco");
                petOwner2.setImagePath("./Lab_Rocco");
                perOwnerOrg.getWorkQueue().getWorkRequestList().add(petOwner2);
                ua26.getWorkQueue().getWorkRequestList().add(petOwner2);
            
        return system;
    }
    
}
