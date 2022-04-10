package Targil2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Long.parseLong;

public class Order {

    private long orderId;
    private Date orderDate;
    private Date deliveryDate;
    private OrderStatus status;

    private long customrId;

    public Order(String orderInfo) {
        List<String> orderData = Arrays.asList(orderInfo.split("\\s"));
        orderId = Long.parseLong(orderData.get(1));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            orderDate = sdf.parse(orderData.get(3));
            deliveryDate = sdf.parse(orderData.get(5));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        status = OrderStatus.valueOf(orderData.get(5));
    }

    public Order(long Oid, Date OorderDate, Date OdeliveryDate, OrderStatus Ostatus, long OcustomrId) {
        setOrderId(Oid);
        setOrderDate(OorderDate);
        setDeliveryDate(OdeliveryDate);
        setStatus(Ostatus);
        setCustomrId(OcustomrId);
    }


    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        return "order: " + getOrderId() + " order date: " + ft.format(getOrderDate()) + " delivery date: " + ft.format(getDeliveryDate()) + " status: " + getStatus() + " customr id: " + getCustomrId() + "\n";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getCustomrId() {
        return customrId;
    }

    public void setCustomrId(long customrId) {
        this.customrId = customrId;
    }
}