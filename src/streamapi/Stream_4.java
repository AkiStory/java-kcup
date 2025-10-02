package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream_4 {
	static Set<String> wordSet(List<String> sentences) {
		return sentences.stream()
			.flatMap(s -> Arrays.stream(s.split("\\s+")))
			.map(String::toLowerCase)
			.filter(s -> !s.isEmpty())
			.collect(Collectors.toSet()); // toSet = 중복제거

	}

	//for/if문
	// Set<String> result = new HashSet<>();
	// 	for (String line : sentences) {
	// 		for (String w : line.split("\\s+")) {
	// 			String s = w.toLowerCase().trim();
	// 			if (!s.isEmpty())
	// 				result.add(s);
	// 		}
	// 	}
	// 	return result;

	static void main(String[] args) {
		List<String> sentences = Arrays.asList(
			"Hello Stream API",
			"hello  java  stream",
			" "
		);
		System.out.println(wordSet(sentences));
	}
}
