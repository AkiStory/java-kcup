package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream_5 {
	//age >= 20인 사람만 대상으로 내림차순, 상위 3명 이름
	static class Person {
		final String name;
		final int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	static List<String> top3AdultNames(List<Person> people) {
		return people.stream()
			.filter(p -> p.age >= 20)
			.map(p -> p.name)
			.sorted(Comparator.reverseOrder())
			.toList();
	}

	//for/if문
	// 	List<Person> adults = new ArrayList<>();
	// 	for (Person p : people) {
	// 		if (p.age >= 20)
	// 			adults.add(p);
	// 	}
	// 	adults.sort((a, b) -> Integer.compare(b.age, a.age));
	//
	// 	List<String> result = new ArrayList<>();
	// 	for (int i = 0; i < adults.size() && i < 3; i++) {
	// 		result.add(adults.get(i).name);
	// 	}
	// 	return result;

	static void main(String[] args) {
		List<Person> people = Arrays.asList(
			new Person("Amy", 19),
			new Person("Bob", 22),
			new Person("Cody", 31),
			new Person("Daisy", 44),
			new Person("Evan", 18)
		);
		System.out.println(top3AdultNames(people));
	}
}
