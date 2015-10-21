package managers;

import java.time.LocalDate;

import companies.MyCompany;
import persons.Associate;
import persons.ContactInfo;

public class PersonManage {
	
	public Associate createAssociate(int id, String name, LocalDate birthday,
		MyCompany company, String position, ContactInfo contactInfo){		
		return new Associate(id, name, birthday, company, position, contactInfo);
	}

}
