package Targil2;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAccumulator;
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
        return DataSource.allOrders.stream().filter(o-> o.getCustomrId() == customerId)
                .sorted(Comparator.comparingLong(Order::getOrderId))
                .collect(Collectors.toList());
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        //To do
        return 0;
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        return DataSource.allProducts.stream().filter(p -> DataSource.allOrderProducts.stream()
                .filter(o-> o.getProductId() == p.getProductId()).count() >= orderedtimes)
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());
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
        return DataSource.allProducts.stream().filter(p -> p.getProductId() ==
                DataSource.allOrderProducts.stream().collect(groupingBy(OrderProduct::getProductId))
                        .entrySet().stream().collect(toMap(Map.Entry::getKey, e -> e.getValue().stream().map(OrderProduct::getQuantity).reduce(0, Integer::sum))).entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElse(new AbstractMap.SimpleImmutableEntry<>(0L, 0)).getKey()
                ).findFirst().orElse(null);

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
