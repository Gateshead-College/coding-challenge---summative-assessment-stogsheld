import java.util.ArrayList;

public class Order{

    private String customerID;
    private ArrayList<OrderItem> orders;

    public Order(String customerID, ArrayList<OrderItem> orders) {
        this.customerID = customerID;
        this.orders = orders;
    }
}
