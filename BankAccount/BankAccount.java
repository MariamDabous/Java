public class BankAccount{
    double checkingbalance;
    double savingsbalance;
    public static int numberOfAccounts = 0;
    public static int totalOfMoney = 0;

    public BankAccount(){
        numberOfAccounts++;
    }

    public double getCheckingBalance() {
        return checkingbalance;
    }

    public double getSavingsBalance() {
        return savingsbalance;
    }

    public void deposit(double depositMoney, String SavingOrChecking) {
        if(SavingOrChecking=="check"){
            checkingbalance+=depositMoney;
            totalOfMoney+=depositMoney;
        }
        else if(SavingOrChecking=="save"){
            savingsbalance+=depositMoney;
            totalOfMoney+=depositMoney;
        }
        
    }

    public void withdraw(double withdrawMoney, String SavingOrChecking) {
        if(withdrawMoney< savingsbalance && SavingOrChecking=="save" ){
            savingsbalance-=withdrawMoney;
            totalOfMoney-=withdrawMoney;
        }
        else if(withdrawMoney< checkingbalance && SavingOrChecking=="check" ){
            checkingbalance-=withdrawMoney;
            totalOfMoney-=withdrawMoney;
        }
        
    }

    public void totalMoney(){
        System.out.println(totalOfMoney);
        System.out.println(numberOfAccounts);
        
        
    }


}