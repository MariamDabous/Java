class TestBankAccount {
    public static void main(String[] args) {
        BankAccount Acc1 = new BankAccount();
        BankAccount Acc2 = new BankAccount();
        Acc2.deposit(500,"save");
        Acc1.deposit(1000,"save");
        Acc1.deposit(2000,"save");
        Acc1.withdraw(100,"save");
        Acc1.withdraw(50000,"save");
        Acc1.totalMoney();
    }
}
