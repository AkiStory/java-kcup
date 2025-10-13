package streamlesson;

import java.util.List;

public class Stream_2 {

	static void main(String[] args) {

		List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
		List<String> names2 = List.of();

		var findFirst = names.stream().findFirst().get();
		// var throwFirst = names2.stream().findFirst().get();
		var throwFirst = names2.stream().findFirst().orElse("없다");
		var throwFirst2 = names2.stream().findFirst().isPresent();
		// .get() -> 값이 없으면 NoSuchElementException	발생

		System.out.println("findFirst = " + findFirst);
		System.out.println(throwFirst);
		System.out.println(throwFirst2);

		//findAny 아무거나찾기
		var findName = names.stream().findAny().get();
		System.out.println("findAny = " + findName); // 대체로 1번을 반환

		//match 일치하는지에 대한 boolean (allMatch, anyMatch, nonMatch)
		var matchName = names.stream().allMatch(n -> n.equals("Alice"));
		var matchName2 = names.stream().anyMatch(n -> n.equals("Alice"));
		var matchName3 = names.stream().noneMatch(n -> n.equals("Tom"));
		System.out.println("allmatch = " + matchName);
		System.out.println("anymatch = " + matchName2);
		System.out.println("nonmatch = " + matchName3);

		//reduce
		var numbers = List.of(1, 2, 3, 4, 5);
		// var sum = numbers.stream().reduce(Integer::sum).get();
		var sum = numbers.stream()
			// .reduce((x,y) -> x * y).get();
			.reduce(1, (x, y) -> x * y); // identity가 있다면 Optional이 필요없음
		//identity 기준값에 람다식을 하는 것 (identity,() -> )
		System.out.println("sum = " + sum);

	}
}