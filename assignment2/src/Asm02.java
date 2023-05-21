import Model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  Bổ sung của cá nhân: tạo thêm 1 lớp Supportfunction chứ các phương thức tĩnh cần dùng nhiều lần
//  phần nâng cao:
//      tiêu chí 1: đã cài đặt hàm setCustomerId() (xem phương thức setCustomerId() trong class User)
//      tiêu chí 2: đã xây dựng hàm searchCustomerByName (xem chức năng 5 của mainProgram)
//      tiêu chí 3: đã xây dựng hàm addAccount() trong file Bank ( xem phương thức addAccount() ở class Bank)


public class Asm02 {
    private static final Bank bank = new Bank();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        myProgram();
    }


//    Chương trình chính
    public static void myProgram() {
//        tạo vòng lập để quay trở về menu sau khi thực hiện xong các chức năng ( trừ chức năng 0)
        while(true) {
            tableShow();
            int fucntionChoose = validFuncInput(6);
            switch (fucntionChoose) {
                case 0:
//                    ket thuc chuong trinh
                    System.out.println("Cám ơn bạn đã sử dụng chương trình!");
                    System.out.println("Chương trình kết thúc");
                    return;
                case 1:
//                    chuc nang 1: them khach hang
                    System.out.println("+ CN:"+ fucntionChoose + " Thêm khách hàng");
                    addCustomer();
                    System.out.println(" Kết thúc chức năng 1");
                    break;
                case 2:
//                    chuc nang 2: them tai khoan cho khach hang
                    System.out.println("+ CN:"+ fucntionChoose + " Thêm tài khoản cho khách hàng");
                    addAccount();
                    System.out.println(" Kết thúc chức năng 2");
                    break;
                case 3:
//                    chuc nang 3: hien thi danh sach khach hang
                    System.out.println("+ CN:"+ fucntionChoose + " Hiển thị danh sách khách hàng");
                    showCustomers();
                    System.out.println(" Kết thúc chức năng 3");
                    break;
                case 4:
//                    chuc nang 4: tim khach hang theo so CCCD
                    System.out.println("+ CN:"+ fucntionChoose + " Tìm kiếm khách hàng theo số CCCD");
                    searchCustomerByCCCD();
                    System.out.println(" Kết thúc chức năng 4");
                    break;
                case 5:
//                    chuc nang 5: tim khach hang theo ten (hien thi danh sach gan dung)
                    System.out.println("+ CN:"+ fucntionChoose + " Tìm kiếm khách hàng theo tên");
                    searchCustomerByName();
                    System.out.println(" Kết thúc chức năng 5");
                    break;
            }
        }

    }
//  tạo bảng menu hiển thị chức năng
    public static void tableShow() {
        final String AUTHOR = "FX22585@";
        final String VERSION = "v2.0.0";
        String rowLine = "+--------------+--------------------+--------------+%n";
        int rowLineLength = rowLine.length();
        String placeHolderStr = "| %-"+ (rowLineLength-6) +"s |%n";
        System.out.format(rowLine);
        System.out.format(placeHolderStr, "NGAN HANG SO | " + AUTHOR + "@" + VERSION);
        System.out.format(rowLine);
        System.out.format(placeHolderStr, "1. Thêm khách hàng");
        System.out.format(placeHolderStr, "2. Thêm tài khoản cho khách hàng");
        System.out.format(placeHolderStr, "3. Hiển thị danh sách khách hàng");
        System.out.format(placeHolderStr, "4. Tìm theo số CCCD");
        System.out.format(placeHolderStr, "5. Tìm theo tên khách hàng");
        System.out.format(placeHolderStr, "0. Thoát");
        System.out.format(rowLine);
    }
//    tạo pt kiểm tra input chức năng đầu vào ( với tham số là số chức năng) nếu hợp lệ thì trả về chức năng
    public static int validFuncInput(int funcNumbers) {
        int functionChoose = 0;
        while(true) {
//            nếu chức năng không hợp lệ thì yêu cầu nhập lại
            try {
                System.out.print("Chức năng: ");
                String input = sc.nextLine();
                int intInput = Integer.parseInt(input);
                if((intInput>(funcNumbers-1)) || (intInput<0)) {
//                    nếu không nằm trong phạm vi chức năng thì quăng lỗi
                    System.out.println(1/0);
                }
                functionChoose = intInput;
                break;
            }
            catch(Exception e) {
                System.out.println("Chức năng không hợp lệ. Vui lòng nhập lại");
            }
        }
        return functionChoose;
    }

//    Chuc nang 1
    public static void addCustomer() {
        System.out.print("Nhập tên khách hàng: ");
        String name = sc.nextLine();
        String cccdCode;
//        sử dụng try cath để yêu cầu user nhập lại số CCCD nếu không đúng
        while(true) {
            System.out.print("Nhập số CCCD: ");
            cccdCode = sc.nextLine();
//            nếu user nhập 'return' thì trở lại menu
            if ((cccdCode.toLowerCase()).equals("return")) {
                System.out.println("Trở lại");
                return;
            } else {
                try {
                    if(bank.isCustomerExisted(cccdCode)) {
//                  Nếu người dùng đã tồn tại thì quăng lỗi
                        System.out.println("Đã tồn tại khách hàng với số CCCD: " + cccdCode + " trong danh sách");
                        System.out.println(1/0);
                    }
//                    nếu chưa tồn tại thì tạo 1 instance của lớp customer
                    Customer customer = new Customer();
//                    thêm tên và số CCCD mà người dùng đã nhập
                    customer.setCustomerId(cccdCode);
                    customer.setName(name);
//                    sau khi cac dk tren thoa man thi them khach hang vao danh sach
                    bank.addCustomer(customer);
                    System.out.println("Đã thêm khách hàng vào danh sách");
                    break;
                }
                catch (Exception e) {
                    System.out.println("Vui lòng nhập lại hoặc 'return' đẻ quay lại");
                }
            }
        }
    }

//    chuc nang 2
    public static void addAccount() {
        while (true) {
            try {
                System.out.print("Nhập số CCCD: ");
                String cccdCode = sc.nextLine();
                if(cccdCode.equals("return")) {
                    System.out.println("Quay lại");
                    return;
                } else {
                    Account newAccount = new Account();
//                    hiển thị tên khách hàng nếu có trong danh sách không thì quăng lỗi
                    System.out.println("Khách hàng: " + bank.getCustomerByID(cccdCode).getName());
                    String accNumber;
                    double accBalance;
//                    Yêu cầu người dùng nhập lại số tài khoản nếu không hợp lệ
                    while(true) {
                        try {
                            System.out.print("Nhap so tai khoan: ");
                            accNumber = sc.nextLine();
                            if(accNumber.equals("return")) {
                                System.out.println("Quay lại");
                                return;
                            }
//                            Nếu STK không hợp lệ thì quăng lỗi
                            if(!SupportFunction.isValidAccountNumber(accNumber)){
                                System.out.println("Số tài khoản không hợp lệ");
                                System.out.println(1/0);
                            }
//                            Nếu STK đã tồn tại thì quăng lỗi
                            if(bank.getCustomerByID(cccdCode).isAccountExisted(accNumber)) {
                                System.out.println("Tài khoản đã tồn tại.");
                                System.out.println(1/0);
                            }
                            newAccount.setAccountNumber(accNumber);
                            break;
                        }
                        catch(Exception e) {
                            System.out.println("Vui lòng nhập lại hoặc 'return' dể quay trở lại");
                        }
                    }
//                    yêu cầu người dùng nhập lại số dư nếu không đúng
                    while(true) {
                        try {
                            System.out.print("Nhập số dư: ");
                            String balanceInput = sc.nextLine();
                            if(balanceInput.equals("return")) {
                                System.out.println("Quay lại");
                                return;
                            }
                            accBalance = Double.parseDouble(balanceInput);
                            if(accBalance < 50_000){
                                System.out.println("Số dư không được nhỏ hơn 50.000vnd");
                                System.out.println(1/0);
                            }
                            newAccount.setBalance(accBalance);
                            break;
                        }
                        catch (Exception e) {
                            System.out.println("Vui lòng nhâp lại hoặc 'return' để quay lại");
                        }
                    }
                    bank.addAccount(cccdCode, newAccount);
                    System.out.println("Số tài khoản: " +  accNumber);
                    System.out.println("Số dư: "+ SupportFunction.formatBalance(accBalance));
                    System.out.println("Đã thêm tài khoản cho khách hàng");
                    break;
                }
            }
            catch(Exception e) {
                System.out.println("Vui lòng nhâp lại hoặc 'return' để quay lại");
            }
        }
    }

//    chuc nang 3
    public static void showCustomers() {
        if(bank.getCustomers().size()>0) {
            //        lặp qua từng khách hàng trong danh sách và hiển thị thông tin và tài khoản khách hàng
            for(Customer customer:bank.getCustomers()) {
                customer.displayInformation();
            }
            System.out.printf(SupportFunction.getRowLine());
            System.out.println("");
        } else {
            System.out.println("Hiện chưa có khách hàng trong danh sách");
        }
    }
//    chu nang 4
    public static void searchCustomerByCCCD() {
        while(true) {
            try {
                System.out.print("Nhập số CCCD: ");
                String CCCDNumber = sc.nextLine();
                if(CCCDNumber.toLowerCase().equals("return")){
                    System.out.println("Quay lại");
                    return;
                }
                if(SupportFunction.isValidCCCD(CCCDNumber)) {
                    if(!bank.isCustomerExisted(CCCDNumber)) {
                        System.out.println("Khách hàng với số CCCD: "+ CCCDNumber + " Không tồn tại trong danh sách");
                        System.out.println(1/0);
                    } else {
                        System.out.println("Kết quả tìm kiếm:");
                        Customer validCustomer = bank.getCustomerByID(CCCDNumber);
                        validCustomer.displayInformation();
                        System.out.printf(SupportFunction.getRowLine());
                        break;
                    }
                } else {
                    System.out.println("Số CCCD không hợp lệ.");
                    System.out.println(1/0);
                }
            }
            catch (Exception e) {
                System.out.println("Vui lòng nhâp lại hoặc 'return' để quay lại");
            }
        }
    }
//    chuc nang 5
//    Mô tả: Tìm tất cả các kết quả thõa mãn input, hiển thị các khách hàng bắt đầu bằng từ tìm kiếm trước
//    sau đó mới hiển thị các kết quả có chứa từ tìm kiếm
    public static void searchCustomerByName() {
//        tạo collection lưa tất cả các kết quả có thể tìm thấy
        List<Customer> results = new ArrayList<>();
//        tạo collection tạm thời lưu các kết quả có chứa từ tìm kiếm
        List<Customer> tempArr = new ArrayList<>();
        System.out.print("Nhập tên của khách hàng: ");
        String nameInput = sc.nextLine();
        int nameInputLength = nameInput.length();
//        Lặp qua tất cả các customer
        for (Customer customer: bank.getCustomers()) {
//            thêm các khách hàng bắt đầu bằng từ tìm kiếm vào results trước
            if((customer.getName().substring(0,nameInputLength).toLowerCase()).equals(nameInput.toLowerCase())){
                results.add(customer);
            } else if ((customer.getName().toLowerCase()).contains(nameInput.toLowerCase())) {
//                thêm các khách hàng có chứa từ tìm kiếm vào collection tạm thời
                tempArr.add(customer);
            }
        }
//        thêm các khách hàng từ collection tạm thời vào results
        for (Customer customer: tempArr) {
            results.add(customer);
        }
//        Hiển thị kết quả tìm kiếm
        if(results.size()>0) {
            for(Customer customer:results) {
                customer.displayInformation();
            }
            System.out.printf(SupportFunction.getRowLine());
        } else {
            System.out.println("Không tìm thấy kết quả");
        }
    }
//    Các pt phụ cho các chức năng
    public static String getCCCDInput() {
        System.out.print("Nhập số CCCD: ");
        return sc.nextLine();
    }
    public static void returnMessage() {
        System.out.println("Vui lòng nhâp lại hoặc 'return' để quay lại");
    }
}