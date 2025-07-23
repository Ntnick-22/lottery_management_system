
	import java.util.Arrays;

	import java.util.Scanner;

	public class LotteryTickets {

		// Data Members
		private int[] userNumbers;
		private int[] luckyNumbers;
		private LotteryTickets[] userTickets;
		private int ticketCount = 0;

		// Constructors
		public LotteryTickets() {   //Default constructor
			userTickets = new LotteryTickets[0];
		}

		//Parameter constructors []
		public LotteryTickets(int[] userNumbers) {
			this.userNumbers = userNumbers;
		}

		// Getters and Setters
		public void setNumberOfDraws(int numDraws) {
			userTickets = new LotteryTickets[numDraws];
		}

		 int[] getUserNumbers() {
			return userNumbers;
		}

	// Method: Option 1: Buy a lottery ticket
		public void buyLotteryTicket(Scanner scanner) {
			if (ticketCount >= userTickets.length) {
				System.out.println("You have reached the maximum number of tickets for this session.");
				return;
			}

			int[] ticketNumbers = new int[6]; //create array tikcetnumbers to store 6 numbers index 5
			boolean isValid;

			do {
				isValid = true;
				System.out.println("Please enter 6 unique numbers between 1 and 50:");


				// keep numbers from the user
				for (int i = 0; i < 6; i++) {
					System.out.print("Enter Number " + (i + 1) + ": ");
					ticketNumbers[i] = scanner.nextInt();

					// Check if number is within range
					if (ticketNumbers[i] < 1 || ticketNumbers[i] > 50) {
						System.out.println("Invalid input! Numbers must be between 1 and 50.");
						isValid = false;
						break; //go back to do and loop test again
					}

					// Check for duplicates
					for (int j = 0; j < i; j++) {
						if (ticketNumbers[i] == ticketNumbers[j]) {   //compare numbers
							System.out.println("Invalid input! Duplicate numbers are not allowed.");
							isValid = false;
							break;  //go back to do and loop test again
						}
					}
					if (!isValid	) break; //exit loop
				}
			} while (!isValid); // save here
			// Save the ticket
			userTickets[ticketCount] = new LotteryTickets(ticketNumbers);
			ticketCount++; // Increment the ticket count after saving the ticket
			System.out.println("Lottery ticket saved successfully!");
		}


	  // Method: Option 2: Generate the winning numbers

		 // luckyNumbers = new int[]{5,12,23,34,45,49};  //test code here
		 // int[] userNumbers = {5, 12, 23, 34, 45, 49}; //test code here

		public void generateWinningNumbers() {

					luckyNumbers = new int[6];

		for (int i = 0; i < 6; i++) {
			// Generate a random number between 1 and 50
			luckyNumbers[i] = 	(int)(Math.random() * 50) + 1;
		}

		   System.out.print("\nThe Jackpot Numbers are: "+ Arrays.toString(luckyNumbers));

	}
	 // Method to display entries
		public void displayEntries(int[] userNumbers) {
			for (int i = 0; i < 6; i++) {
				System.out.print(userNumbers[i] + ", ");
			}

		}

		// Method: Option 3: Check if you won or lose
		public void checkingWinorLose() {

			//Process
			if (ticketCount == 0) {
				System.out.println("No tickets, please buy a ticket first.");

			}


			else{
		   for (int i = 0; i < ticketCount; i++) {
				int matchCount = countMatches(userTickets[i].getUserNumbers(), luckyNumbers);
			   System.out.println("Ticket " + (i + 1) + ": " + Arrays.toString(userTickets[i].getUserNumbers()) +
										  " - Matches: " + matchCount);
				displayPrize(matchCount);  //call display method here with matchcount parameter
			}
		}
		}
		// Method to display the prize
		public void displayPrize(int matchCount) {   // create method display prize to show the drawer the prize   --add int matchcount in the parameter

		//Process
			  if (matchCount == 6) {
						System.out.println("Congratulations! You are the Jackpot Winner and won $1 million!");
					}
					else if (matchCount == 5)
					{
						System.out.println("Congratulations! You win $500,000!");
					}
					else if (matchCount == 4) {
						System.out.println("Congratulations! You win $1,000!");
					}
					else if (matchCount == 3) {
						System.out.println("Congratulations! You win $25!");
					}
					else {
						System.out.println("Sorry! No win, better luck next time!");
					}
				}

		// Method to count matches between user numbers and winning numbers
		public int countMatches(int[] userNumbers, int[] winningNumbers) { // method with usernumbers array and winningnumbers array
				int matchCount = 0;  //initiate as 0
				for (int i = 0; i < userNumbers.length; i++) {  // check all numbers inside the usernumbers array
					for (int j = 0; j < winningNumbers.length; j++) {   //check all numbers insidde the winningnuumbers array
						if (userNumbers[i] == winningNumbers[j]) {   //compare here
							matchCount++;
							break;
						}
					}
				}
				return matchCount;
		}

		// Method: Option 4: View previous lottery entries
		public void viewPreviousEntries() {
			//Process
			if (ticketCount == 0) {
				System.out.println("No previous entries found.");

			}else{

			System.out.println("Previous Lottery Entries:");
			for (int i = 0; i < ticketCount; i++) {
			   System.out.println("Ticket " + (i + 1) + ": " + Arrays.toString(userTickets[i].getUserNumbers())); //to show numbers in array
		}
	   }
	 }


	} //class