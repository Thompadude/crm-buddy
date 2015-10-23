package managers;

/**
 * A placeholder for all object management classes.
 */
public class ObjectManage {

    CompanyManage companyManage = new CompanyManage();
    MeetingManage meetingManage = new MeetingManage();
    PersonManage personManage = new PersonManage();
    ContactInfoManage contactInfoManage = new ContactInfoManage();

    public CompanyManage getCompanyManage() {
        return companyManage;
    }

    public MeetingManage getMeetingManage() {
        return meetingManage;
    }

    public PersonManage getPersonManage() {
        return personManage;
    }
    
    public ContactInfoManage getContactInfoManage() {
    	return contactInfoManage;
    }

}