


import java.util.Arrays;

import java.util.Scanner;

public class LotteryApplicationSystem {

    public static void main(String[] args) {
		//Declare variables
		int choice,numberOfdraws;
        // Creating LotteryTicket Object
        LotteryTickets lotteryTickets = new LotteryTickets(); //from another class file --create here

        // Ask the user how many lottery draws they want to run
        Scanner scannerForDrawer = new Scanner(System.in);   //create scannerfordrawer  input to ask the drawer to draw
        //Input
        System.out.print("How many lottery draws would you like to run? ");

        int numberOfDraws = scannerForDrawer.nextInt();
        lotteryTickets.setNumberOfDraws(numberOfDraws);  //use from lotterytickets //recall setter here



        //Process

       do {
            System.out.println(" Lottery Application ");
            System.out.println("1. Buy a Lottery Ticket");
            System.out.println("2. Generate Winning Numbers");
            System.out.println("3. Check If You Won");
            System.out.println("4. View Previous Lottery Entries");
            System.out.println("5. Exit Application");
            System.out.print("\n Enter your choice: ");


            choice = scannerForDrawer.nextInt(); //ask the user choice here to enter the system

            switch (choice) {
                case 1:
                    lotteryTickets.buyLotteryTicket(scannerForDrawer); //call method from lotteryTickets
                    break;
                case 2:
                    lotteryTickets.generateWinningNumbers();//call method from lotteryTickets
                    break;
                case 3:
                    lotteryTickets.checkingWinorLose();//call method from lotteryTickets
                    break;
                case 4:
                    lotteryTickets.viewPreviousEntries();//call method from lotteryTickets
                    break;
                case 5:
                    System.out.println("Exiting application early. Goodbye!"); //Display message
                    return;
                default:
                    System.out.println("Please select a valid option!");  //for the rest numbers except 1 to 5
            }
            }while(choice!=5);

   }  //main
 }  //class


