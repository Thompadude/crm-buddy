package entry;

import companies.MyCompany;
import managers.ObjectManage;

/**
 * Associate objects are stored in the company object.
 * Using the object manage to reach all manage options.
 */
public class Program {
    // TODO Skapa factory istället (interface)

    ObjectManage objectManage = new ObjectManage();

    public void runProgram() {
        // For testing purposes.
        MyCompany saab = new MyCompany("Saab", null);
        saab.addEmployee(objectManage.getPersonManage().createAssociate(0, null, null, saab, null, null));
        saab.addBusinessAssociate(objectManage.getPersonManage().createAssociate(0, null, null, null, null, null));
        objectManage.getMeetingManage().addParticipant(null, null);
        // Test stop
    }

}