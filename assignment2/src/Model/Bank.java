package Model;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Bank {
//    thuộc tính gồm id của ngân hàng và collection customers
    private final String id;
    private final List<Customer> customers;
//      constructor
    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

//      getter của id ngân hàng
    public String getId() {
        return this.id;
    }

//      pt thêm 1 tài khoản vào collection customers
    public void addCustomer(Customer newCustomer) {
//        chỉ thêm khách hàng chưa có (nếu đã có đưa thông báo)
        if(!isCustomerExisted(newCustomer.getCustomerId())) {
            customers.add(newCustomer);
        } else {
            System.out.println("Số CCCD: "+newCustomer.getCustomerId() + " đã tồn tại trong danh sách");
        }
    }

//    pt thêm 1 tài khoản cho khách hàng đã tồn tại trong danh sách
    public void addAccount(String cusomerId, Account acount) {
        if(isCustomerExisted(cusomerId)) {
            Customer customer = getCustomerByID(cusomerId);
            customer.addAccount(acount);
        } else {
//            nếu không tồn tại thì quăng lỗi
            System.out.println("Khách hàng không tồn tại hoặc số CCCD không chính xác");
        }
    }

//    pt kiểm tra 1 khách hàng có tồn tại trong danh sách
    public boolean isCustomerExisted(String customerID) {
        boolean isCustomerExisted = false;
        for(Customer customer:customers) {
            if(customerID.equals(customer.getCustomerId())){
                isCustomerExisted = true;
                break;
            }
        }
        return isCustomerExisted;
    }

//    getter của collection customers
    public List<Customer> getCustomers() {
        return customers;
    }

// thêm 1 phương thức để lấy 1 khách hàng bằng số CCCD
    public Customer getCustomerByID(String CCCDNumber) {
        for(Customer cus: customers) {
            if(cus.getCustomerId().equals(CCCDNumber)) {
                return cus;
            }
        }
        System.out.println("Khách hàng không tồn tại");
        return null;
    }
}
