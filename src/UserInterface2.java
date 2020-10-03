import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserInterface2 {

	public static HashMap<String, List<Address>> myDevice;

	public static void main(String[] args) {

		myDevice = new HashMap<>();

		Scanner input = new Scanner(System.in);

		int choice = 0;
		do {
			System.out.println("Select option:");
			System.out.println("1. Add Address Book");
			System.out.println("2. Add contact");
			System.out.println("3. Edit contact");
			System.out.println("4. Delete contact");
			System.out.println("5. Exit");

			choice = input.nextInt();
			switch (choice) {
			case 1:
				addAddressBook(input);
				printAddressBooks();
				break;
			case 2:
				insertIntoAddressBook(input);
				break;
			case 3:
				editAddress(input);
				printAddressBooks();
				break;
			case 4:
				deleteContact(input);
				printAddressBooks();
				break;
			default:
				break;
			}
		} while (choice != 5);

	}

	private static void addAddressBook(Scanner input) {
		System.out.println("Enter the name of Address Book");
		String addBookName = input.next();
		List<Address> addressBook = new ArrayList<Address>();
		myDevice.put(addBookName, addressBook);
	}

	public static void insertIntoAddressBook(Scanner input) {
		System.out.println("Enter the address book");
		String addressbookname = input.next();
		List<Address> addressBook = myDevice.get(addressbookname);
		if (addressBook == null) {
			System.out.println(addressbookname + " Not found ");
			return;
		}

		System.out.println("Enter user details to insert");
		System.out.println("Enter first name:");
		String first_name = input.next();
		System.out.println("Enter last name:");
		String last_name = input.next();
		System.out.println("Enter address");
		String address = input.next();
		System.out.println("Enter city:");
		String city = input.next();
		System.out.println("Enter state:");
		String state = input.next();
		System.out.println("Enter zip:");
		String zip = input.next();
		System.out.println("Enter phone no:");
		String phone_no = input.next();
		System.out.println("Enter email:");
		String email = input.next();

		Address newAddress = new Address(first_name, last_name, address, city, state, zip, phone_no, email);
		addressBook.add(newAddress);
		System.out.println("Address added successfully");
		printAddressBooks();
	}

	public static void editAddress(Scanner input) {

		System.out.println("Enter the address book");
		String addressbookname = input.next();
		List<Address> addressBook = myDevice.get(addressbookname);
		if (addressBook == null) {
			System.out.println(addressbookname + " Not found ");
			return;
		}

		System.out.println("Enter user details");
		System.out.println("Enter first name:");
		String first_name = input.next();
		System.out.println("Enter last name:");
		String last_name = input.next();

		System.out.println("Enter new address");
		String newAddress = input.next();
		System.out.println("Enter new city:");
		String newCity = input.next();
		System.out.println("Enter new state:");
		String newState = input.next();
		System.out.println("Enter new zip:");
		String newZip = input.next();

		boolean userFound = false;
		for (int i = 0; i < addressBook.size(); i++) {
			Address currentAddress = addressBook.get(i);
			if (currentAddress.getFirst_name().equals(first_name) && currentAddress.getLast_name().equals(last_name)) {
				currentAddress.setAddress(newAddress);
				currentAddress.setCity(newCity);
				currentAddress.setState(newState);
				currentAddress.setZip(newZip);
				userFound = true;
				break;
			}
		}
		if (userFound == false)
			System.out.println("User Not Found");
		else
			System.out.println("Address updated for " + first_name + " " + last_name);
		printAddressBooks();
	}

	public static void deleteContact(Scanner input) {
		System.out.println("Enter the address book");
		String addressbookname = input.next();
		List<Address> addressBook = myDevice.get(addressbookname);
		if (addressBook == null) {
			System.out.println(addressbookname + " Not found ");
			return;
		}

		System.out.println("Enter user details to delete");
		System.out.println("Enter first name:");
		String first_name = input.next();
		System.out.println("Enter last name:");
		String last_name = input.next();

		boolean userFound = false;
		for (int i = 0; i < addressBook.size(); i++) {
			Address currentAddress = addressBook.get(i);
			if (currentAddress.getFirst_name().equals(first_name) && currentAddress.getLast_name().equals(last_name)) {
				addressBook.remove(i);
				userFound = true;
				break;
			}
		}
		if (userFound == false)
			System.out.println("User Not Found");
		else
			System.out.println("Address deleted for " + first_name + " " + last_name);

	}

	public static void printAddressBooks() {
		Set<String> namesOfAddBooks = myDevice.keySet();
		for (String nameofaddbook : namesOfAddBooks) {
			System.out.println(nameofaddbook + " " + myDevice.get(nameofaddbook).toString());
		}

	}

}
