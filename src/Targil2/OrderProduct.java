package Targil2;

import java.util.*;
import java.util.List;

public class OrderProduct {
    private long orderId;
    private long productId;
    private int quantity;

    public OrderProduct(String orderInfo)
    {
        List<String> OrderProductData = Arrays.asList(orderInfo.split("\\s"));
        orderId = Long.parseLong(OrderProductData.get(2));
        productId = Long.parseLong(OrderProductData.get(5));
        quantity = Integer.parseInt(OrderProductData.get(7));
    }

    public OrderProduct(long oId, long pId, int quantity)
    {
        setOrderId(oId);
        setProductId(pId);
        setQuantity(quantity);
    }

    public String toString()
    {
        return "ord id: "+ getOrderId() + " prod id: "+ getProductId() +" quantity: "+ getQuantity()+"\n";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
