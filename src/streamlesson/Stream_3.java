package streamlesson;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_3 {

	static void main(String[] args) {
		List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");

		// Collectors 최종연산
		// var nameList = names.stream().toList();
		// var nameSet = names.stream().collect(Collectors.toSet());
		// var nameMap = names.stream().collect(Collectors.toMap(name -> name.length()));
		//
		// System.out.println(nameList);
		// System.out.println(nameSet);
		// System.out.println(nameMap);

		// count
		var count1 = names.stream().count();
		var count2 = names.stream().collect(Collectors.counting());

		System.out.println(count1);
		System.out.println(count2);

		// joning -> String
		var joining1 = names.stream().collect(Collectors.joining(""));
		var joining2 = names.stream().collect(Collectors.joining(", "));
		var joining3 = names.stream().collect(Collectors.joining(", ", "[", "]"));

		System.out.println("joining = " + joining1);
		System.out.println("joining = " + joining2);
		System.out.println("joining = " + joining3);

		// 평균, 합계
		var sumLength = names.stream().collect(Collectors.summingInt(n -> n.length()));
		// var sumLength = (Integer)names.stream().mapToInt(n -> n.length()).sum();
		// var sumLength = (Integer)names.stream().mapToInt(String::length).sum();
		System.out.println("lengthsum = " + sumLength); // 23

		var avaLength = names.stream().collect(Collectors.averagingInt(n -> n.length()));
		System.out.println("lengthava = " + avaLength); // 23/5 = 4.6

		// 최대, 최소
		var minLength = names.stream().collect(Collectors
			.minBy(Comparator.comparingInt(n -> n.length()))).get();
		System.out.println("min = " + minLength);

		var maxLength = names.stream().collect(Collectors
			.maxBy(Comparator.comparingInt(n -> n.length()))).get();
		System.out.println("max = " + maxLength);

	}
}
