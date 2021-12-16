public class OrderItem {

    private String orderID;
    private int orderQuantity;
    private String customerID;

    public OrderItem(String orderID, int orderQuantity, String customerID) {
        this.orderID = orderID;
        this.orderQuantity = orderQuantity;
        this.customerID = customerID;
    }
}
