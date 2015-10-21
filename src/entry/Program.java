package entry;

import companies.MyCompany;
import managers.CompanyManage;
import managers.MeetingManage;
import managers.PersonManage;

public class Program {
	//All created associate objects are stored in the company object.
	
	// Skapa factory istället (interface)
	PersonManage personManage = new PersonManage();
	CompanyManage companyManage = new CompanyManage();
	MeetingManage meetingManage = new MeetingManage();

	public void runProgram() {

		MyCompany saab = new MyCompany("Saab", null);

		saab.addEmployee(personManage.createAssociate(0, null, null, saab, null, null));
		saab.addBusinessAssociate(personManage.createAssociate(0, null, null, null, null, null));
	}
}
