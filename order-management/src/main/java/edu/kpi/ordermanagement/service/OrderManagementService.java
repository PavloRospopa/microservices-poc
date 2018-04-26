package edu.kpi.ordermanagement.service;

import edu.kpi.ordermanagement.domain.LineItem;
import edu.kpi.ordermanagement.domain.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderManagementService {

    private List<Order> cache;

    @PostConstruct
    public void init() {
        this.cache = new ArrayList<>();

        Order demo = Order.builder()
                .id("demo")
                .accountId("1")
                .item(LineItem.builder().name("apple").quantity(3).price(5).build())
                .item(LineItem.builder().name("pineapple").quantity(2).price(4).build())
                .build();
        this.cache.add(demo);
    }

    public Optional<Order> read(String id) {
        return cache.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();
    }

    public List<Order> readAll() {
        return new ArrayList<>(cache);
    }

    public List<Order> findBy(String accountId) {

        return cache.stream().filter(order -> order.getAccountId().equals(accountId))
                .collect(Collectors.toList());
    }

    public Order create(Order order) {
        order.setId(UUID.randomUUID().toString());
        cache.add(order);

        return order;
    }

    public void delete(String id) {
        Order o = read(id).orElseThrow(NoSuchElementException::new);

        cache.remove(o);
    }

    public void update(Order update) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).getId().equals(update.getId())) {
                cache.set(i, update);
                return;
            }
        }

        throw new NoSuchElementException();
    }
}
