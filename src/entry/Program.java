package entry;

import companies.MyCompany;
import managers.ObjectManage;

/**
 * Associate objects are stored in the company object.
 * Using the object manage to reach all manage options.
 */
public class Program {
    // TODO Skapa factory ist�llet (interface)

    ObjectManage objectManage = new ObjectManage();

    public void runProgram(MyCompany myCompany) {

        UserInterface userInterface = new UserInterface();
        userInterface.menuChoice(myCompany);

    }

}