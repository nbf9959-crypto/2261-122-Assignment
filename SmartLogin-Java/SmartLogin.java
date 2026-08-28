import java.util.Scanner; 

void main() {
		System.out.print("\033[H\033[2J"); System.out.flush();	
		Scanner input = new Scanner(System.in); 
		
		System.out.println("\n\nWelcome to the Smart-Login program -> \n"); 
		String programDetail = """
Objective: 

# Create an account with inserted credenitals 
# Log in to the account using the credentials 

---------------------------------------------
		"""; 

		String username = null; 
		String password = null; 

		int attemptCount = 3; 

		System.out.println(programDetail);

		System.out.println("\n# Create an account #\n"); 

		System.out.print(">>> Enter a username: "); 
		String inserted_username = input.nextLine(); 

		System.out.print(">>> Enter a password: "); 
		String inserted_password = input.nextLine(); 

		if (inserted_username.length() > 0 && inserted_password.length() > 0) {
			System.out.println("\nAccount created successfully!"); 

			System.out.println("\n__________________________________________"); 
			System.out.println("\n * Log in to your account. *\n"); 
			// System.out.println(String.format(">> Attempt count remaining: % # <<", "attemptCount")); 

    		System.out.println(String.format(">> Attempt count remaining: %s# <<", attemptCount));
  

			System.out.print("\n>>> Enter username: "); 
			username = input.nextLine(); 

			System.out.print(">>> Enter password: "); 
			password = input.nextLine(); 

			if(inserted_username.equals(username) && inserted_password.equals(password)) {
				System.out.println("\n--| Login successful! Welcome. |--\n"); 
			} else {
				attemptCount--; 
				System.out.println("\n--> Error: Incorrect credentials <--\n");	

				System.out.println(String.format(">> Attempt count remaining: %s#<<", attemptCount));

				System.out.print("\n>>> Enter username: "); 
				username = input.nextLine(); 

				System.out.print(">>> Enter password: ");
				password = input.nextLine(); 

				if(inserted_username.equals(username) && inserted_password.equals(password)) {
					System.out.println("\n--| Login successful! welcome. |--\n");  
				} else {
					attemptCount--; 
					System.out.println("\n--> Error: Incorrect credentials <--\n"); 

					System.out.println(String.format(">> Attempt count remaining: %s# <<", attemptCount));

					System.out.print("\n>>> Enter username: "); 
					username = input.nextLine(); 

					System.out.print(">>> Enter password: ");
					password = input.nextLine();

					if (inserted_username.equals(username) && inserted_password.equals(password)) {
						System.out.println("\n--| Login successful! Welcome. |--\n"); 
					} else {
						System.out.println("\n_________________________________"); 
						System.out.println("\n>> Account locked. Only the adminstrator can reset it.\n");

						System.out.print(">>> Admin username: "); 
						String admin = input.nextLine(); 

						System.out.print(">>> Admin password: "); 
						String admin_password = input.nextLine();

						if(admin.equals("admin") && admin_password.equals("pickle")) {
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
								System.out.println("\nResetting the login attempt...");

								break; 

								case "2":
								System.out.println("\nLogging out...Goodbye");

								break; 

								default:
							        System.out.println(String.format("The % option us out of bound and does not exist. <--\n", adminModeOption));	

								break; 
							}
						} else {
							System.out.println("\n________________________________"); 
							System.out.println("\n--> Invalid credentials. System remains locked. <--\n");
						}
					}
				}
			}
		} else {
			System.out.println("\n\n______________________________________________");
			System.out.println("\n--> Account creation failed - no valid credential provided. <--\n");
		}

		input.close();
}


