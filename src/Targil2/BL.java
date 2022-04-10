package Targil2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

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
        return DataSource.allOrders.stream().filter(o -> o.getOrderId() == orderId)
                .map(o -> DataSource.allOrderProducts.stream().filter(op -> op.getOrderId() == o.getOrderId()).count())
                .findAny().orElse(0L);
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
        return DataSource.allOrderProducts.stream().filter(op -> op.getOrderId() == orderId)
                .map(orderProduct -> DataSource.allProducts.stream()
                        .filter(p -> p.getProductId() == orderProduct.getProductId())
                        .findAny()
                        .orElse(null)
                ).collect(Collectors.toList());
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        return DataSource.allOrderProducts.stream().filter(op -> op.getProductId() == productId)
                .map(op -> DataSource.allOrders.stream().filter(o -> o.getOrderId() == op.getOrderId()).findAny().orElse(null))
                .filter(Objects::nonNull)
                .map(o -> DataSource.allCustomers.stream().filter(c -> c.getId() == o.getCustomrId()).findAny().orElse(null))
                .collect(Collectors.toList());
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
        return DataSource.allOrderProducts.stream().filter(op -> op.getOrderId() == orderID)
                .map(op -> op.getQuantity() * DataSource.allProducts.stream().filter(p -> p.getProductId() == op.getProductId()).findAny().orElse(new Product(0,"", ProductCategory.Accessories, 0)).getPrice())
                .reduce(0d, Double::sum);
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        return DataSource.allOrders.stream().filter(o -> sumOfOrder(o.getOrderId()) > price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        return DataSource.allCustomers.stream().filter(c-> c.getTier() == 3
        && getCustomerOrders(c.getId()).size() == DataSource.allCustomers.stream().filter(customer-> customer.getTier() == 3)
                .map(customer -> getCustomerOrders(customer.getId()).size())
                .max(Comparator.comparingInt(Integer::intValue)).orElse(0))
                .collect(Collectors.toList());
    }

}
