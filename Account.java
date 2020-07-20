package Assignment2_200448160;

import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private double accountBalance = 0;
    private String accountName;

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        if (accountNumber.matches("^[a-zA-Z0-9]*$")) {
            this.accountNumber = accountNumber;
        } else System.out.println("Error: Account number can only be an alphanumeric value without spaces");
    }

    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        if(accountBalance >= 0) {
            this.accountBalance = accountBalance;
        }
        else System.out.println("Error: Your account balance can not be negative");
    }

    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        if(accountName.matches("[A-Z][a-zA-Z]+|[A-Z][a-zA-Z]+\\s+[a-zA-Z]+|[A-Z][a-zA-Z]+\\s*[-]*\\s*+[a-zA-Z]+")) {
            this.accountName = accountName;
        }
        else System.out.println("Error: Please enter a valid Account Name. Remember to capitalize the first letter");
    }

    public Account(String accountNumber, double accountBalance, String accountName){
       if (accountNumber.matches("^[a-zA-Z0-9]*$") == true
               && accountBalance >= 0
               && accountName.matches("[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*)*$") == true){
           this.accountNumber = accountNumber;
           this.accountBalance = accountBalance;
           this.accountName = accountName;
           System.out.println("Your account has been added");
       }
       else if(accountBalance < 0){
           System.out.println("Error: Your account balance can not be negative");
           System.out.println("Account can not be created");
       }
       else if (accountNumber.matches("^[a-zA-Z0-9]*$") == false){
           System.out.println("Error: Account number can only be an alphanumeric value without spaces");
           System.out.println("Account can not be created");
       }

       else if(accountName.matches("[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*)*$") == false){
           System.out.println("Error: Please enter a valid Account Name. Remember to capitalize the first letter");
           System.out.println("Account can not be created");
       }
    }
    @Override
    public String toString(){
        return  "Account {" + "Account Name='" + getAccountName() + "\'"
                + ", Account Balance=" + getAccountBalance()
                + ", Account Number=" + getAccountNumber() + '}';
    }
}
