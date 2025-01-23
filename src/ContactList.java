import java.util.ArrayList;
import java.util.Scanner;
public class ContactList {
    // Instance variable
    private ArrayList<Person> contacts;
    public ContactList() {
        // Constructor
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        // Asks user for input, then uses the information to create a new contact of the right class
        Scanner input = new Scanner(System.in);
        String type = "";
        while (!type.equals("Worker") && !type.equals("Student") && !type.equals("Person")) {
            System.out.println("Enter Type: ");
            type = input.nextLine();
        }
        System.out.println("Enter Name: ");
        String first = input.nextLine();
        System.out.println("Enter Last Name: ");
        String last =  input.nextLine();
        // Assumes user enters actual numbers
        System.out.println("Enter Phone Number: ");
        String phone = input.nextLine();
        if (type.equals("Worker")) {
            System.out.println("Enter Job");
            String job = input.nextLine();
            // Creates new contact and adds it to the list
            contacts.add(new Worker(first,last,phone,job));
            // returns to save checks
            return;
        }
        if (type.equals("Student")) {
            System.out.println("Enter Grade");
            int grade = input.nextInt();
            contacts.add(new Student(first,last,phone,grade));
            return;
        }
        // Adds contact as person if it wasn't a worker or student
        contacts.add(new Person(first,last,phone));

    }

    public void printContacts() {
        // Prints all the contacts and makes sure to incorporate the correct parts of the toStrings
        for (Person person : contacts) {
            if (person instanceof Student) {
                System.out.println(person);
            }
            else if (person instanceof Worker) {
                System.out.println(person);
            }
            else {
                System.out.println(person);
            }
        }
    }

    public void sort(int sortBy) {
        // Runs helper methods based off of the input
        if (sortBy == 0) {
            sortByFirst();
            printContacts();
            return;
        }
        if (sortBy == 1) {
            sortByLast();
            printContacts();
            return;
        }
        if (sortBy == 2) {
            sortByNum();
            printContacts();
        }
    }
    private void sortByFirst () {
        // Uses bubble sort to swap the contacts to the top by alphabetical order (First Name)
        for (int i = 0; i < contacts.size() - 1; i ++) {
            // Compares less as i gets bigger to avoid redundant checks
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                // Checks the first name between contacts at j and contacts at j+1
                if (contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0) {
                    // Swaps the whole person, not just the names
                    Person swap = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1,swap);

                }
            }
        }
    }

    private void sortByLast() {
        // Same bubble sort but with last name
        for (int i = 0; i < contacts.size() - 1; i ++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                if (contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) > 0) {
                    Person swap = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1,swap);

                }
            }
        }
    }

    private void sortByNum() {
        // Assumes that numbers are ordered lexigraphically
        for (int i = 0; i < contacts.size() - 1; i ++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0) {
                    Person swap = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1,swap);

                }
            }
        }
    }

    public String searchFirst () {
        Scanner input = new Scanner(System.in);
        // Asks for name, then sees if there is a first name which matches the inputted name
        System.out.println("Enter a name: \n");
        String firstName = input.nextLine();
        for (Person person: contacts) {
            // Returns the first person whose name is the exact same as the inputted name
            if (person.getFirstName().equals(firstName)) {
                // Makes sure to print correct toString
                if (person instanceof Student) {
                    return person.toString();
                }
                else if (person instanceof Worker) {
                    return person.toString();                }
                else {
                    return person.toString();                }
            }
        }
        return null;
    }

    public String searchLast() {
        // Same search but with last name
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String lastName = input.nextLine();
        for (Person person: contacts) {
            if (person.getLastName().equals(lastName)) {
                if (person instanceof Student) {
                    return person.toString();
                }
                else if (person instanceof Worker) {
                    return person.toString();                }
                else {
                    return person.toString();                }
            }
        }
        return null;
    }

    public String searchNum() {
        // Can use same code because phone number is a string
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String phoneNum = input.nextLine();
        for (Person person: contacts) {
            if (person.getPhoneNumber().equals(phoneNum)) {
                if (person instanceof Student) {
                    return person.toString();
                }
                else if (person instanceof Worker) {
                    return person.toString();                }
                else {
                    return person.toString();                }
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person person : contacts) {
            // Only prints Students by using instanceof
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    public void run () {
        boolean notDone = true;
        Scanner input = new Scanner(System.in);
        // Goes on forever or until the user hits 0
        while (notDone) {
            System.out.println("Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Name");
            System.out.println("3. List All Contacts By Last Name");
            System.out.println("4. List All Contacts By Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By Last Name");
            System.out.println("8. Search By Phone Number");
            System.out.println("0. Exit");
            // Uses input.nextInt() to find there choice and resets the line through input.nextLine()
            int choice = input.nextInt();
            input.nextLine();
            // Runs the method based off of what the user enters
            if (choice == 0) {
                notDone = false;
                break;
            }
            if (choice == 1) {
                addContact();
            }
            if (choice == 2) {
                sort(0);
            }
            if (choice == 3) {
                sort(1);
            }
            if (choice == 4) {
                sort(2);
            }
            if (choice == 5) {
                listStudents();
            }
            if (choice == 6) {
                searchFirst();
            }
            if (choice == 7) {
                searchLast();
            }
            if (choice == 8) {
                searchNum();
            }
        }
    }


}
