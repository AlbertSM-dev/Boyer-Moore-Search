import java.util.Scanner;

public class Main {
	// The text containing the 50 U.S. state names
    public static final String TEXT = "Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, " +
            "Delaware, Florida, Georgia, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana, " +
            "Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana, Nebraska, " +
            "Nevada, New Hampshire, New Jersey, New Mexico, New York, North Carolina, North Dakota, Ohio, " +
            "Oklahoma, Oregon, Pennsylvania, Rhode Island, South Carolina, South Dakota, Tennessee, Texas, " +
            "Utah, Vermont, Virginia, Washington, West Virginia, Wisconsin, Wyoming";

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 3) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Display the text");
            System.out.println("2. Search for a pattern");
            System.out.println("3. Exit program");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        displayText();
                        break;
                    case 2:
                        System.out.print("Enter the search pattern: ");
                        String pattern = scanner.nextLine();
                        StateSearcher.search(pattern, TEXT);
                        break;
                    case 3:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        scanner.close();
    }
    public static void displayText() {
        System.out.println("\n--- Text: 50 U.S. States ---");
        System.out.println(TEXT);
        System.out.println("------------------------------");
    }
            
}
