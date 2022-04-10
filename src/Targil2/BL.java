package Targil2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {
       return DataSource.allProducts.stream().filter(p-> p.getProductId() == productId).findAny().orElse(null);
    }

    @Override
    public Order getOrderById(long orderId) {
        return DataSource.allOrders.stream().filter(o-> o.getOrderId() == orderId).findAny().orElse(null);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return DataSource.allCustomers.stream().filter(c-> c.getId() == customerId).findAny().orElse(null);
    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
      return DataSource.allProducts.stream().filter(p-> p.getCategory() == cat && p.getPrice() <= price)
              .sorted(Comparator.comparingLong(Product::getProductId))
              .collect(Collectors.toList());
    }

    @Override
    public List<Customer> popularCustomers() {
       return DataSource.allCustomers.stream().filter(c -> c.getTier() == 3)
               .filter(c -> DataSource.allOrders.stream().filter(o-> o.getCustomrId() == c.getId()).count() > 10)
               .sorted(Comparator.comparingLong(Customer::getId))
               .collect(Collectors.toList());
    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        //To do
        return null;
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        //To do
        return 0;
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        //To do
        return null;
    }

    @Override
    public List<Product> getOrderProducts(long orderId)
    {
        //To do
        return null;
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        //To do
        return null;
    }

    @Override
    public Product getMaxOrderedProduct() {
        //To do
        return null;

    }
    @Override
    public double sumOfOrder(long orderID) {
        //To do
        return 0;
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        //To do
        return null;
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        //To do
        return null;

    }

}
