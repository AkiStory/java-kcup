package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream_7 {
	enum Status {NEW, PROCESSING, COMPLETED, CANCELED}

	static class Order {
		final String product;
		final int quantity;
		final Status status;

		Order(String product, int quantity, Status status) {
			this.product = product;
			this.quantity = quantity;
			this.status = status;
		}
	}

	static List<String> top3ProductsByQuantity(List<Order> orders) {
		return orders.stream()
			.filter(o -> o.status == Status.COMPLETED)
			.collect(Collectors.groupingBy(o -> o.product,
				Collectors.summingInt(o -> o.quantity)))
			.entrySet().stream()
			.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
			.limit(3)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
	}

	// 	Map<String, Integer> qty = orders.stream()
	// 		.filter(o -> o.status == test.Status.COMPLETED)
	// 		.collect(Collectors.groupingBy(o -> o.product,
	// 			Collectors.summingInt(o -> o.quantity)));
	//
	// 	return qty.entrySet().stream()
	// 		.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	// 		.limit(3)
	// 		.map(Map.Entry::getKey)
	// 		.collect(Collectors.toList());
	//}

	// for/if문
	// 	Map<String, Integer> qty = new HashMap<>();
	// 	for (Order o : orders) {
	// 		if (o.status == Status.COMPLETED) {
	// 			qty.put(o.product, qty.getOrDefault(o.product, 0) + o.quantity);
	// 		}
	// 	}
	// 	List<Map.Entry<String, Integer>> entries = new ArrayList<>(qty.entrySet());
	// 	entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
	//
	// 	List<String> result = new ArrayList<>();
	// 	for (int i = 0; i < entries.size() && i < 3; i++) {
	// 		result.add(entries.get(i).getKey());
	// 	}
	// 	return result;

	static void main(String[] args) {
		List<Order> orders = Arrays.asList(
			new Order("Apple", 10, Status.COMPLETED),
			new Order("Banana", 20, Status.COMPLETED),
			new Order("Apple", 5, Status.COMPLETED),
			new Order("Kiwi", 5, Status.PROCESSING),
			new Order("Kiwi", 7, Status.COMPLETED)
		);
		System.out.println(top3ProductsByQuantity(orders));
	}
}
