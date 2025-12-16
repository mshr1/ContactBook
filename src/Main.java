import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		ContactBook book = new ContactBook();
		book.loadFromFile("contacts.txt");
		System.out.println("Контакты загружены!");

		book.addContact(new Contact("Иван", "+79001234567", "ivan@mail.ru"));
		book.addContact(new Contact("мария", "+79007654321", "maria@mail.ru"));
		book.listAll();

		// Поиск
		Contact found = book.findContact("Иван");
		if (found != null) {
			System.out.println("Найден: " + found);
		}

		// Удаление
		// book.removeContact("Мария");
		book.listAll(); // Должен остаться только Иван

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n=== Библиотека контактов ===");
			System.out.println("1. Добавить контакт");
			System.out.println("2. Удалить контакт");
			System.out.println("3. Найти контакт");
			System.out.println("4. Показать все контакты");
			System.out.println("5. Выход");
			System.out.print("Выберите действие: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Очистка буфера после nextInt()

			switch (choice) {
				case 1:
					System.out.println("Name: ");
					String name = scanner.nextLine();
					System.out.println("Phone: ");
					String phone = scanner.nextLine();
					System.out.println("Email: ");
					String email = scanner.nextLine();

					Contact c = new Contact(name, phone, email);
					book.addContact(c);
					break;

				case 2:
					System.out.println("Name: ");
					name = scanner.nextLine();
					book.removeContact(name);
					break;
				case 3:
					System.out.println("Name: ");
					name = scanner.nextLine();
					if (name != null) {
						book.findContact(name);
					}
					break;
				case 4:
					book.listAll();
					break;
				case 5:
					book.saveToFile("contacts.txt");
					System.out.println("Контакты сохранены!");
					break;
				default:
					break;
			}
		}
	}
}
