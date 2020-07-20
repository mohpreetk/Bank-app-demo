package Assignment2_200448160;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    public static Scanner Sc1 = new Scanner(System.in);
    private String bankName;
    private String branchLocation;
    private static ArrayList<Account> accounts = new ArrayList<>();

    public static ArrayList<Bank> banks = new ArrayList<>();

    public int noOfAccounts = 0;
    public int noOfAccountsCreated = 0;
    public boolean flag;

    public Bank(String bankName, String branchLocation) {
        this.bankName = bankName;
        this.branchLocation = branchLocation;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }
    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public Account returnAccount(String accountNumber) {
        Account foundAccount = null;
        for (int i = 0; i < noOfAccounts; i++) {
            if (accountNumber.equals(accounts.get(i).getAccountNumber())) {
                foundAccount = accounts.get(i);
            }
        }
        return foundAccount;
    }

    public String parseInput(String userInput, String toBeChecked) {
        String[] splitInput = userInput.split(" ");
        String returnedString = null;
        for (int i = 0; i < splitInput.length; i++) {
            if (splitInput[i].equals(toBeChecked)) {
                returnedString = splitInput[i];
            }
        }
        return returnedString;
    }

    public void directUser(int userChoice) {
        switch (userChoice) {
            case 0:
                exit();
                break;
            case 1:
                addAccount();
                break;
            case 2:
                viewAccounts();
                break;
            case 3:
                accountDetails();
                break;
            case 4:
                modifyAccount();
                break;
            case 5:
                deleteAccount();
                break;
            case 6:
                summary();
                break;
            case 7:
                help();
                break;
            default:
                System.out.println("Make a valid choice");

        }
    }

    public void addAccount() {
        try {
            System.out.println("Please input your name");
            String accountName = Sc1.next();
            String discardExtraLine = Sc1.nextLine();
            System.out.println("Please choose an account number. It should be alphanumeric");
            String accountNumber = Sc1.nextLine();
            System.out.println("Please input the balance you want to deposit");
            double accountBalance = Sc1.nextDouble();
            if(accountNumber.matches("^[a-zA-Z0-9]*$") == true){
                System.out.println(true);
            }
            Account ac1 = new Account(accountNumber, accountBalance, accountName);
            accounts.add(ac1);
            noOfAccounts++;
            noOfAccountsCreated++;
            System.out.printf("Please enter the next choice you want to make. Press 7 and type help for help.");
            int userChoice = Sc1.nextInt();
            Bank.banks.get(0).directUser(userChoice);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please give valid inputs.");
            addAccount();
        }
    }

    public void viewAccounts() {
        for (int i = 0; i < noOfAccounts; i++) {
            System.out.println(accounts.get(i));
            System.out.printf("%n----------------------------%n");
        }
        System.out.printf("Please enter the next choice you want to make. Press 7 and type help for help.");
        int userChoice = Sc1.nextInt();
        Bank.banks.get(0).directUser(userChoice);
    }

    public void accountDetails() {
        System.out.println("Please input the account number you want to see the details for. Enter it in the format \"view (your account number) details\"");
        String discardExtraLine = Sc1.nextLine();
        String userInput = Sc1.nextLine();
        for (int i = 0; i < noOfAccounts; i++) {
            if ((parseInput(userInput, accounts.get(i).getAccountNumber())) != null && (returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber()))) != null) {
                System.out.println(returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber())));
                flag = true;
            }
        }
        if (flag == false){
            System.out.println("Account not found");
        }
        System.out.printf("Please enter the next choice you want to make. Press 7 and type help for help.");
        int userChoice = Sc1.nextInt();
        Bank.banks.get(0).directUser(userChoice);
    }

    public void modifyAccount() {
        System.out.println("Please input the account number you want to modify. Enter it in the format \"modify (your account number) \" or \"modify (your account number) (your option)\"");
        String discardExtraLine = Sc1.nextLine();
        String userInput = Sc1.nextLine();
        for (int i = 0; i < noOfAccounts; i++) {
            if ((parseInput(userInput, accounts.get(i).getAccountNumber())) != null && (returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber()))) != null && !userInput.endsWith("name") && !userInput.endsWith("number") && !userInput.endsWith("balance")) {
                System.out.printf("Select one of the following:%na) name -- Press 1%n" +
                        "b) number -- Press 2%n" +
                        "c) balance -- Press 3%n");
                if (Sc1.nextInt() == 1){
                    System.out.println("Enter new name");
                    String newAccountName = Sc1.nextLine();
                    accounts.get(i).setAccountName(newAccountName);
                }
                else if (Sc1.nextInt() == 2){
                    System.out.println("Enter new account number");
                    String newAccountNumber = Sc1.nextLine();
                    accounts.get(i).setAccountNumber(newAccountNumber);
                }
                else if (Sc1.nextInt() == 3){
                    System.out.println("Enter new balance");
                    double newAccountBalance = Sc1.nextDouble();
                    accounts.get(i).setAccountBalance(newAccountBalance);
                }
                else if (Sc1.nextInt() == 0) {
                    System.out.printf("Thank you for using %s Bank%n", bankName);
                    Runner.getStarted(bankName, branchLocation);
                }
                System.out.println(returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber())));
                flag = true;
            }
            else if ((parseInput(userInput, accounts.get(i).getAccountNumber())) != null && (returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber()))) != null && userInput.endsWith("name")) {
                discardExtraLine = Sc1.nextLine();
                System.out.println("Enter new name");
                String newAccountName = Sc1.nextLine();
                accounts.get(i).setAccountName(newAccountName);
                flag = true;
                System.out.printf("Name updated successfully");
            }
            else if ((parseInput(userInput, accounts.get(i).getAccountNumber())) != null && (returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber()))) != null && userInput.endsWith("number")) {
                discardExtraLine = Sc1.nextLine();
                System.out.println("Enter new account number");
                String newAccountNumber = Sc1.nextLine();
                accounts.get(i).setAccountNumber(newAccountNumber);
                flag = true;
                System.out.printf("Number updated successfully");
            }
            else if ((parseInput(userInput, accounts.get(i).getAccountNumber())) != null && (returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber()))) != null && userInput.endsWith("balance")) {
                discardExtraLine = Sc1.nextLine();
                System.out.println("Enter new balance");
                double newAccountBalance = Sc1.nextDouble();
                accounts.get(i).setAccountBalance(newAccountBalance);
                flag = true;
                System.out.printf("Balance updated successfully");
            }
        }
        if (flag == false){
            System.out.println("Account not found");
        }
        System.out.printf("Please enter the next choice you want to make. Press 7 and type help for help.");
        int userChoice = Sc1.nextInt();
        Bank.banks.get(0).directUser(userChoice);
    }

    public void deleteAccount() {
        System.out.println("Please input the account number you want to delete. Enter it in the format \"delete (your account number) \"");
        String discardExtraLine = Sc1.nextLine();
        String userInput = Sc1.nextLine();
        flag = false;
        for (int i = 0; i < noOfAccounts; i++) {
            if ((parseInput(userInput, accounts.get(i).getAccountNumber())) != null && (returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber()))) != null) {
                System.out.println(returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber())));
                System.out.println("Are you sure you want to delete this account?(Y/N)");
                if (Sc1.next().equals("Y")) {
                    accounts.remove(returnAccount(parseInput(userInput, accounts.get(i).getAccountNumber())));
                    noOfAccounts--;
                }
                else {
                    System.out.println("The account was not deleted.");
                }
                flag = true;
            }
        }
        if (flag == false){
            System.out.println("Account not found");
        }
        System.out.printf("Please enter the next choice you want to make. Press 7 and type help for help.");
        int userChoice = Sc1.nextInt();
        Bank.banks.get(0).directUser(userChoice);
    }

    public void help() {
        String discardExtraLine = Sc1.nextLine();
        if (Sc1.nextLine().equals("help")) {
            System.out.printf("Welcome to our help centre.%n" +
                    "Here is a list of all commands that are valid in our program.%n%n" +
                    "NOTE: You need to press ENTER after every input and all Inputs are CASE-SENSITIVE%n%n" +
                    "Available banks: Scotia, TD, CIBC, RBC and BMO.%n" +
                    "Available branch locations: Toronto, Brampton, Barrie, Mississauga and London%n%n" +
                    "You will then have a directive menu displayed. Choose the option from the list:%n" +
                    "a) Add Account -- Press 1%n" +
                    "b) View Accounts -- Press 2%n" +
                    "c) Account Details -- Press 3%n" +
                    "d) Modify Account -- Press 4%n" +
                    "e) Delete Account -- Press 5%n" +
                    "f) Summary -- Press 6%n" +
                    "g) Help -- Press 7%n%n" +
                    "To ADD an account, you need to press 1 and give%n" +
                    "a) your name(Alphabets, spaces, hyphens;first letter should be capital)%n" +
                    "b) your account number(Alphabets and numbers, atleast one alphabet and one number)%n" +
                    "c) your account balance(Can not be negative)%n%n" +
                    "To VIEW ALL THE ACCOUNTS in the bank: Press 2 in the directive menu.%n%n" +
                    "To VIEW all the account details: press 3 and type \"view (your account number) details\"%n" +
                    "Note: The command should exactly be the same. Account number is case sensitive. Do not include brackets.%n%n" +
                    "To MODIFY account information: press 4 and type modify \"modify (your account number)\" and select the information you want to modify:%n" +
                    "a) name -- Press 1%n" +
                    "b) number -- Press 2%n" +
                    "c) balance -- Press 3%n" +
                    "Or you can type modify \"modify (your account number) (your option)\"%n" +
                    "Then you can set the new information.%n" +
                    "Note: The command should exactly be the same. Account number is case sensitive. Do not include brackets.%n%n" +
                    "To DELETE an account: press 5 and type \"delete (your account number)\"%n" +
                    "Note: The command should exactly be the same. Account number is case sensitive. Do not include brackets.%n%n" +
                    "To get the SUMMARY of your session, press 6 in the directive menu and type \"summary\"%n%n" +
                    "To get some HELP, just press 7 in the directive menu and type \"help\"%n%n" +
                    "Thank you for using our services!!!%n");
            System.out.printf("Please enter the next choice you want to make. Press 7 and type help for help.");
            int userChoice = Sc1.nextInt();
            Bank.banks.get(0).directUser(userChoice);
        }
    }

    public void summary() {
        String discardExtraLine = Sc1.nextLine();
        if (Sc1.nextLine().equals("summary")) {
            System.out.printf("The number of accounts created during the process are %d%n", noOfAccountsCreated);
            double balance = 0;
            for (int i = 0; i < noOfAccounts; i++) {
                balance = balance + accounts.get(i).getAccountBalance();
            }
            System.out.printf("The sum of the balances of all accounts is %f%n", balance);
            System.out.printf("Average of all account balances is %f%n", (balance / noOfAccounts));
            System.out.printf("Please enter the next choice you want to make. Press 7 and type help for help.");
            int userChoice = Sc1.nextInt();
            Bank.banks.get(0).directUser(userChoice);
        }
    }

    public void exit(){
            System.out.printf("Thank you for using %s Bank%n%n", bankName);
            Runner.getStarted(bankName, branchLocation);
    }
}
