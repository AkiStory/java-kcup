package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream_6 {
	static List<String> top5FrequentWords(List<String> sentences) {
		return sentences.stream()
			.flatMap(s -> Arrays.stream(s.split("\\W+")))
			.filter(s -> !s.isEmpty())
			.map(String::toUpperCase)
			.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
			.entrySet().stream()
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.limit(5)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
	}

	static void main(String[] args) {
		List<String> sentences = Arrays.asList(
			"Hello, Stream API!",
			"hello  java  stream",
			"Stream... HELLO?"
		);
		System.out.println(top5FrequentWords(sentences));
	}
}
