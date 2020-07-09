package GuestBook;

public class Contact implements Comparable<Contact>{

	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;

	public Contact(String firstName, String lastName, String address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public Contact() {
		this("John","Smith","10 Downing Street, London, UK","18005551111");
	}

	@Override
	public int compareTo(Contact o) {
		int order = firstName.compareTo(o.firstName);
		if (order == 0)
			order = lastName.compareTo(o.lastName);
		if (order == 0)
			order = address.compareTo(o.address);
		if (order == 0)
			order = phoneNumber.compareTo(o.phoneNumber);
		return order;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setPhoneNumber() {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress() {
		this.address = address;
	}

	public void setLastName() {
		this.lastName = lastName;
	}

	public void setFirstName() {
		this.firstName = firstName;
	}
}
