package Model;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
//    tạo collection lưu giữ tất cả tài khoản của 1 khách hàng
    private List<Account> accounts;

//    constructor (mỗi khi 1 khách hàng được tạo sẽ tạo 1 Arraylist chứa các account
    public Customer() {
        super();
        this.accounts = new ArrayList<>();
    }
//    getter của accounts
    public List<Account> getAccounts() {
        return accounts;
    }
//    kiểm tra khách hàng có phải premium không ( nếu có 1 account là premium)
    public boolean isPremium() {
        boolean premimum=false;
        for(Account acc:accounts){
            if(acc.isPremium()) {
                premimum = true;
                break;
            }
        }
        return premimum;
    }
//  phương thức kiểm tra xem 1 account có tồn lại trong accounts collection
    public boolean isAccountExisted(String STK) {
        boolean isExisted = false;
        for (Account acccount:accounts){
            if (STK.equals(acccount.getAccountNumber())){
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }
//    pt thêm 1 account và accounts collection
    public void addAccount(Account newAccount) {
        if(!(isAccountExisted(newAccount.getAccountNumber()))) {
            this.accounts.add(newAccount);
        } else {
            System.out.println("So tai khoan da ton tai");
        }
    }
//    pt lấy tổng số dư của tất cả các tài khoản
    public double getBalance() {
        double balance = 0;
        for(Account acc: accounts) {
            balance+=acc.getBalance();
        }
        return balance;
    }
//    pt trả về thông tin của 1 khác hàng ( bao gồm các account của khách hàng)
//    phương thức này sử dụng print format để hiển thị bảng dễ đọc cho user
    public void displayInformation() {
        int rowLineLength = SupportFunction.getRowLine().length();
//        hiển thị khách hàng là premium hoặc normal
        String status = (this.isPremium()) ? "Premium":"Normal";
        System.out.printf(SupportFunction.getRowLine());
//        hiển thị thông tin khách hàng gồm số CCCD, têm, isPremium, tổng số dư
        System.out.printf("| %-12s | %17s | %-8s | %15s |%n", this.getCustomerId(), this.getName(), status, SupportFunction.formatBalance(getBalance()));
        System.out.printf(SupportFunction.getRowLine());
//        hiển thị tất cả account của khách hàng
        if(accounts.size()>0) {
            int i =1;
            for(Account acc:accounts) {
//                thông tin tài khoản gồm STT, STK và số dư
                System.out.printf("| %d | %8s | %-28s | %15s |%n",i,acc.getAccountNumber(),"",SupportFunction.formatBalance(acc.getBalance()));
                i++;
            }
        } else {
//            Nếu không có tài khoản
            System.out.printf("| %"+ (rowLineLength-6) +"s |%n","Khach hang nay hien chua co tai khoan");
        }
    }
}
