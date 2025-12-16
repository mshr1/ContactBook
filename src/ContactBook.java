import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContactBook {
	private ArrayList<Contact> contacts = new ArrayList<>();

	void addContact(Contact contact) {
		if (contact.getName() == null && contact.getNumber() == null && contact.getEmail() == null) {
			System.out.println("Пустой контакт");
		} else {
			contacts.add(contact);
			System.out.println("Контакт добавлен");
		}

	}

	void listAll() {
		for (Contact contact : contacts) {
			if (contacts.isEmpty()) {
				System.out.println("Список контактов пуст");
			} else {
				System.out.println(contact);
			}
		}
	}

	public Contact findContact(String name) {
		name = name.trim().toLowerCase();
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				return contact;
			}
		}
		return null;
	}

	public void removeContact(String name) {

		var found = findContact(name);

		if (found == null) {
			System.out.println("Контакт не найден!");
			return;
		} else {
			contacts.remove(found);
			System.out.println("Контакт удален!");
		}

		// for (int i = 0; i < contacts.size(); i++) {
		// if (contacts.get(i).name.equals(name)) {
		// contacts.remove(i);
		// System.out.println("Контакт удален");
		// }
		// }
		// System.out.println("контакт не найден");
	}

	public void saveToFile(String filename) {
		try {
			FileWriter writer = new FileWriter(filename);
			for (Contact contact : contacts) {
				writer.write(contact.getName() + "|" + contact.getNumber() + "|" + contact.getEmail() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void loadFromFile(String filename) {
		try {
			File file = new File(filename);
			if (!file.exists()) {
				return;
			}
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\\|");
				if (parts.length == 3) {
					Contact c = new Contact(parts[0], parts[1], parts[2]);
					contacts.add(c);

				}
				reader.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

	}

}
