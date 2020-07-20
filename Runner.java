package Assignment2_200448160;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please input your bank name");
        String bankName = sc1.nextLine().toUpperCase();
        while (((bankName.equals("SCOTIA")) || (bankName.equals("TD")) || (bankName.equals("BMO")) || (bankName.equals("CIBC")) || (bankName.equals("RBC"))) == false){
            System.out.println("Please enter a valid Bank Name.");
            Runner.main(null);
        }
        System.out.println("Give the branch location of your Bank");
        String branchLocation = sc1.nextLine().toUpperCase();
        while (((branchLocation.equals("TORONTO")) || (branchLocation.equals("BRAMPTON")) || (branchLocation.equals("BARRIE")) || (branchLocation.equals("MISSISSAUGA")) || (branchLocation.equals("LONDON"))) == false){
            System.out.println("Please enter a valid Branch Location.");
            Runner.main(null);
        }
        Bank b1 = new Bank(bankName, branchLocation);
        Bank.banks.add(b1);
        getStarted(bankName, branchLocation);
    }

    public static void getStarted(String bankName, String branchLocation){
        Scanner Sc1 = new Scanner(System.in);
        System.out.printf("Welcome to %s Branch of %s Bank.%n", Bank.banks.get(0).getBranchLocation(), Bank.banks.get(0).getBankName());
        System.out.printf("Choose one of the options below:%na) Add Account -- Press 1%nb) View Accounts -- Press 2%nc) Account Details -- Press 3%nd) Modify Account -- Press 4%ne) Delete Account -- Press 5%nf) Summary -- Press 6%ng) Help -- Press 7%n");
        int userChoice = Sc1.nextInt();
        Bank.banks.get(0).directUser(userChoice);
    }
}
