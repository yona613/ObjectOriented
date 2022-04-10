package Targil2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
        return DataSource.allOrders.stream().filter(o -> o.getOrderId() == orderId)
                .map(o -> DataSource.allOrderProducts.stream().filter(op -> op.getOrderId() == o.getOrderId()).count())
                .findAny().orElse(0L);
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        //To do
        return null;
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
        //To do
        return null;

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
