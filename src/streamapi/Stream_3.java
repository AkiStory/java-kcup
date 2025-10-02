package streamapi;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Stream_3 {
	enum Status {NEW, PROCESSING, COMPLETED, CANCELED}

	static class Order {
		final Status status;
		final int quantity;

		Order(Status status, int quantity) {
			this.status = status;
			this.quantity = quantity;
		}
	}

	static Map<Status, Integer> quantityByStatus(List<Order> orders) {
		return orders.stream()
			.collect(groupingBy(s -> s.status
				, summingInt(s -> s.quantity)));
	}

	//for/if문
	// Map<Status, Integer> acc = new HashMap<>();
	// for (Order o : orders) {
	// 	acc.put(o.status, acc.getOrDefault(o.status, 0) + o.quantity);
	// }
	// return acc;

	static void main(String[] args) {
		List<Order> orders = Arrays.asList(
			new Order(Status.NEW, 3),
			new Order(Status.COMPLETED, 5),
			new Order(Status.NEW, 2),
			new Order(Status.CANCELED, 1),
			new Order(Status.COMPLETED, 7)
		);
		System.out.println(quantityByStatus(orders));
	}
}
