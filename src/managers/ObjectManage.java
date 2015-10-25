package managers;

/**
 * A placeholder for all object management classes.
 */
public class ObjectManage {

    private CompanyManage companyManage = new CompanyManage();
    private MeetingManage meetingManage = new MeetingManage();
    private PersonManage personManage = new PersonManage();
    private ContactInfoManage contactInfoManage = new ContactInfoManage();
    private ErrorManage errorManage = new ErrorManage();
    private DateManage dateManage = new DateManage();
    private WaitingMechanics waitingMechanics = new WaitingMechanics();

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

    public ErrorManage getErrorManage() {
        return errorManage;
    }

    public DateManage getDateManage() {
        return dateManage;
    }

    public WaitingMechanics getWaitingMechanics() {
        return waitingMechanics;
    }

}