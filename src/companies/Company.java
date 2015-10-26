package companies;

import contactInfo.ContactInfo;

public class Company implements java.io.Serializable {

	private String name;
	private ContactInfo contactInfo;

	public Company(String name, ContactInfo contactInfo) {
		this.name = name;
		this.contactInfo = contactInfo;
	}

	public String getName() {
		return name;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

}
