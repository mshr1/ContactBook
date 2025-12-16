public class Contact {
	private String name;
	private String number;
	private String email;

	String getName() {
		return name;
	}

	String getNumber() {
		return number;
	}

	String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "name: " + " " + name + "number: " + " " + number + "email: " + " " + email;
	}

	Contact(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
	}

}
