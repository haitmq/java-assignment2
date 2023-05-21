package Model;

public abstract class User {
//    thuộc tính gồm tên và id của khách hàng ( số CCCD)
    private String name;
    private String customerId;

    public User() {
    }

//    getter và setter của name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

//    getter và setter của CCCD
    public String getCustomerId() {
        return customerId;
    }
//    setter của customerId sử dụng phương thức kiểm tra isValidCCCD từ class SupportFunction
    public void setCustomerId(String customerId) {
        if(SupportFunction.isValidCCCD(customerId)) {
//            Nếu số CCCD hợp lệ thì gán giá trị cho customerId của account
            this.customerId =customerId;
        } else {
            System.out.println("Số CCCD không chính xác");
//            Nếu không hợn lệ thì quăng lỗi
            System.out.println(1/0);
        }
    }
}
