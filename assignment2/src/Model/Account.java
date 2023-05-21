package Model;

public class Account {
    //    thuộc tính
    private String accountNumber;
    private double balance;
    //    constructor
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
//    default constructor
    public Account() {

    }
    //    getter và setter của AccountNumber (số tài khoản)
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //    getter và setter của balance (sô dư tài khoản)
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //    Kiểm tra xem tài khoản có phải là premium không
    public boolean isPremium() {
        boolean premium = false;
        if(this.getBalance()>=((double) 10_000_000)){
            premium = true;
        }
        return premium;
    }
    //   override từ phuong thức toString của class Object
    @Override
    public String toString() {
        return ("|    " + this.getAccountNumber()+" |                            | "+SupportFunction.formatBalance(this.getBalance()));
    }
}
