package streamlesson;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_1 {

	static void main(String[] args) {

		List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");

		System.out.println("name = " + names);
		// names.add("Frank");

		// 알파벳 e가 들어간 이름들만 모아서 출력 (filter)
		// names.stream().filter(name -> name.contains("e"))
		// .collect(Collectors.toList());
		var filteredNames = names.stream()
			.filter(name -> name.contains("e")) // names.equals.("Alice") = Alice 출력
			// 복수형일 때 단수형으로 넣는게 관례 (names -> filter(name) )
			.toList();
		System.out.println("filter = " + filteredNames);

		//map
		var mappedNames = names.stream()
			// .map(name -> name.toUpperCase()) 기본형 필터x
			.filter(name -> !name.contains("e")) // !을 사용시 아닌 것만 집합
			.map(String::toUpperCase)
			.toList();
		System.out.println("map = " + mappedNames);

		//flatmap
		List<List<Integer>> numbers = List.of(
			List.of(1, 2, 3),
			List.of(4, 5, 6),
			List.of(7, 8, 9)
		);

		var flatMapNumbers = numbers.stream()
			.flatMap(number -> number.stream())
			.toList();
		System.out.println(numbers);
		System.out.println("flatmap = " + flatMapNumbers);

		//limit 2개
		var limitedNames = names.stream().limit(2).toList();
		System.out.println("limit = " + limitedNames);

		//skip
		var skipNames = names.stream().skip(2).toList();
		System.out.println("skip = " + skipNames);

		//sort
		List<String> names1 = List.of("David", "Bob", "Eve", "Alice", "Charlie");
		var sortedNames = names1.stream().sorted().toList();
		System.out.println(names1);
		System.out.println("sort = " + sortedNames);

		var sortedReverse = names1.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println("reverse = " + sortedReverse);

		// forEach
		names1.stream().sorted().forEach(System.out::println);
		// names1.stream().sorted().forEach(name -> System.out.println(name));

		//distinct 중복제거
		var duplicatedNames = List.of("Alice", "Bob", "Alice", "Charlie", "David");
		var duplicatedNames1 = duplicatedNames.stream().distinct().toList();
		var duplicatedNames2 = duplicatedNames.stream().collect(Collectors.toSet()); // 순서를 보장X

		System.out.println(duplicatedNames1);
		System.out.println(duplicatedNames2);

	}
}
