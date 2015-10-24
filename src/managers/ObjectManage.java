package managers;

/**
 * A placeholder for all object management classes.
 */
public class ObjectManage {

    CompanyManage companyManage = new CompanyManage();
    MeetingManage meetingManage = new MeetingManage();
    PersonManage personManage = new PersonManage();
    ContactInfoManage contactInfoManage = new ContactInfoManage();
    NullManage nullManage = new NullManage();

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

	public NullManage getNullManage() {
		return nullManage;
	}

}