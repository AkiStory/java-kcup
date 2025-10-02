package streamapi;

import java.util.Arrays;
import java.util.List;

public class Stream_2 {
	static List<String> cleanAndSort(List<String> names) {
		return names.stream().map(String::trim)
			.filter(n -> n.length() >= 3)
			.map(String::toUpperCase)
			.distinct().sorted().toList();

		//for/if문
		// 	Set<String> seen = new HashSet<>();
		// 	List<String> result = new ArrayList<>();
		// 	for (String raw : names) {
		// 		String s = raw.trim();
		// 		if (s.length() >= 3) {
		// 			String up = s.toUpperCase();
		// 			if (!seen.contains(up)) {
		// 				seen.add(up);
		// 				result.add(up);
		// 			}
		// 		}
		// 	}
		// 	Collections.sort(result);
		// 	return result;

	}

	static void main(String[] args) {
		List<String> in = Arrays.asList("amy", "BO", "amy", "alice", "Alice", "bob ");
		System.out.println(cleanAndSort(in));
	}

}
