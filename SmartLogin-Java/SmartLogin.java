import java.util.Scanner;
Scanner input = new Scanner(System.in); /* Dispatch the scanner class at global scope for inputting interface */

void main() {
	System.out.print("\033[H\033[2J");
	System.out.flush();

	System.out.println("\n\nWelcome to the Smart-Login program -> \n");
	String programDetail = """
	Objective:

	# Create an account with inserted credenitals
	# Log in to the account using the credentials

	---------------------------------------------
	""";

	System.out.println(programDetail);

	System.out.println("\n# Create an account #\n");

	System.out.print(">>> Enter a username: ");
	String insertedUsername = input.nextLine(); /* Set the stored username */

	System.out.print(">>> Enter a password: ");
	String insertedPassword = input.nextLine(); /* Set the stored password */

	if (insertedUsername.length() > 0 && insertedPassword.length() > 0) {
		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.println("\nAccount created successfully!");
		
		userModeExecution(3, insertedUsername, insertedPassword); /*Pass in the attempt count, stored username and password. */
	} else {
		System.out.println("\n\n______________________________________________");
		System.out.println("\n--> Account creation failed - no valid credential provided. <--\n");

	}

	input.close();
}

void userModeExecution(int attemptCount, String insertedUsername, String insertedPassword) {
	System.out.println("\n__________________________________________");
	System.out.println("\n * Log in to your account. *\n");

	System.out.println(String.format(">> Attempt count remaining: %s# <<", attemptCount));

	System.out.print("\n>>> Enter username: ");
	String username = input.nextLine();

	System.out.print(">>> Enter password: ");
	String password = input.nextLine();

	if (insertedUsername.equals(username) && insertedPassword.equals(password)) {
		System.out.println("\n--| Login successful! Welcome. |--\n");
	} else {
		attemptCount--;
		System.out.println("\n--> Error: Incorrect credentials <--\n");

		System.out.println(String.format(">> Attempt count remaining: %d#<<", attemptCount));

		System.out.print("\n>>> Enter username: ");
		username = input.nextLine();

		System.out.print(">>> Enter password: ");
		password = input.nextLine();

		if (insertedUsername.equals(username) && insertedPassword.equals(password)) {
			System.out.println("\n--| Login successful! welcome. |--\n");
		} else {
			attemptCount--;
			System.out.println("\n--> Error: Incorrect credentials <--\n");

			System.out.println(String.format(">> Attempt count remaining: %d# <<", attemptCount));

			System.out.print("\n>>> Enter username: ");
			username = input.nextLine();

			System.out.print(">>> Enter password: ");
			password = input.nextLine();

			if (insertedUsername.equals(username) && insertedPassword.equals(password)) {
				System.out.println("\n--| Login successful! Welcome. |--\n");
			} else {
				adminModeExecution(attemptCount, insertedUsername, insertedPassword); ;
			}
		}
	}
}

void adminModeExecution(int attemptCount, String insertedUsername, String insertedPassword) {
	System.out.print("\033[H\033[2J");
	System.out.flush();

	System.out.println("\n_________________________________");
	System.out.println("\n>> Account locked. Only the adminstrator can reset it.\n");

	System.out.print(">>> Admin username: ");
	String admin = input.nextLine();

	System.out.print(">>> Admin password: ");
	String admin_password = input.nextLine();

	if (admin.equals("admin") && admin_password.equals("pickle")) {
		String adminModeTemplate = """

		Choose an action:

		1. Reset login attempts
		2. Logout
		""";

		System.out.println(adminModeTemplate);

		System.out.print("\n>>> Enter an option to select the action: ");
		String adminModeOption = input.nextLine();

		switch (adminModeOption) {
			case "1":
				attemptCount = 3;
				System.out.println("\nResetting the login attempt...");

				userModeExecution(attemptCount, insertedUsername, insertedPassword);
				break;

			case "2":
				System.out.println("\nLogging out...Goodbye");
				input.close();
				
				break;

			default:
				System.out.println(String.format("The %s option is out of bound and does not exist. <--\n", adminModeOption));
				adminModeExecution(attemptCount, insertedUsername, insertedPassword); 

				break;
		}
	} else {
		System.out.println("\n________________________________");
		System.out.println("\n--> Invalid credentials. System remains locked. <--\n");

		input.close();
	}
}