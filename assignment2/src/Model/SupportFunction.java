package Model;
import java.text.DecimalFormat;

public class SupportFunction {
//    tạo đường phân cách giữa các hàng
    private static String rowLine = "+--------------+------------------------------+-----------------+%n";
    public static String getRowLine() {
        return rowLine;
    }
//    tạo phương thức kiểm tra số CCCD có hợp lệ hay không
    public static boolean isValidCCCD(String CCCDNumber) {
        boolean isValid = false;
        String [][] areaCode = {{"001", "Ha Noi"},{"002", "Ha Giang"}, {"004", "Cao Bang"},
                {"006", "Bac Can"}, {"008", "Tuyen Quang"}, {"010", "Lao Cai"}, {"011", "Dien Bien"},
                {"012", "Lai Chau"}, {"014", "Son La"}, {"015", "Yen Bai"}, {"017", "Hoa Binh"},
                {"019", "Thai Nguyen"}, {"020", "Lang Son"}, {"022", "Quang Ninh"}, {"024", "Bac Giang"},
                {"025", "Phu Tho"}, {"026", "Vinh Phuc"}, {"027", "Bac Ninh"}, {"030", "Hai Duong"},
                {"031", "Hai Phong"}, {"033", "Hung Yen"}, {"034", "Thai Binh"}, {"035", "Ha Nam"},
                {"036", "Nam Dinh"}, {"037", "Ninh Binh"}, {"038", "Thanh Hoa"}, {"040", "Nghe An"},
                {"042", "Ha Tinh"},{"044", "Quang Binh"}, {"045", "Quang Tri"}, {"046", "Thua Thien Hue"},
                {"048", "Da Nang"}, {"049", "Quang Nam"}, {"051", "Quang Ngai"}, {"052", "Binh Dinh"},
                {"054", "Phu Yen"}, {"056", "Khanh Hoa"}, {"058", "Ninh Thuan"}, {"060", "Binh Thuan"},
                {"062", "Kom Tum"}, {"064", "Gia Lai"}, {"066", "Dak Lak"}, {"067", "Dak Nong"},
                {"068", "Lam Dong"}, {"070", "Binh Phuoc"}, {"072", "Tay Ninh"}, {"074", "Binh Duong"},
                {"075", "Dong Nai"}, {"077", "Ba Ria - Vung Tau"}, {"079", "Ho Chi Minh"}, {"080", "Long An"},
                {"082", "Tien Giang"}, {"083", "Ben Tre"}, {"084", "Tra Vinh"}, {"086", "Vinh Long"},
                {"087", "Dong Thap"}, {"089", "An Giang"}, {"091", "Kien Giang"}, {"092", "Can Tho"},
                {"093", "Hau Giang"}, {"094", "Soc Trang"}, {"095", "Bac lieu"}, {"096", "Ca Mau"}};
        int lenArea = areaCode.length;
        try {
//          kiem tra xem mã CCCD có là 1 chuỗi số hay không
            long longCCCDCode = Long.parseLong(CCCDNumber);
//          tao bien boolean de kiểm tra 3 chữ số đầu của mã CCCD có nằm trong 63 mã vùng hay không
            boolean isInAreaCode = false;
//                lặp qua 63 mã vùng nếu khớp thì isInAreaCode trả về true và thoát khỏi vòng lặp
            for(int i =0; i<lenArea; i++) {
                if((CCCDNumber.substring(0,3).equals(areaCode[i][0]))){
                    isInAreaCode = true;
                    break;
                }
            }
//          kiểm tra nếu mã CCCD có độ dài không bằng 12 hoặc không nằm trong 63 mã vùng thì tạo lỗi để catch
            if((CCCDNumber.length() != 12) || (!isInAreaCode)) {
                System.out.println(1/0);
            }
            isValid = true;
        }
        catch (Exception e) {
//            catch ở đây để bỏ qua các câu lệnh trên nếu có lối
//            isValid = false;
        }
        return  isValid;
    }

//    tạo pt kiểm tra số tài khoản hợp lệ không
    public static boolean isValidAccountNumber(String AccountNumber) {
        try {
            int intAcountNumber = Integer.parseInt(AccountNumber);
            if(AccountNumber.length() != 6) {
                System.out.println(1/0);
            }
        }
        catch (Exception e) {
            System.out.println("STK phải gồm 6 chữ số");
            return false;
        }
        return true;
    }

//   Tạo pt định dạnh số dư phân cách hàng nghìn
    public static String formatBalance(double balance) {
        String formatBalance = "";
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        formatBalance += (decimalFormat.format((long) balance) +"vnd");
        return formatBalance;
    }
}
