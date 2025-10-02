package streamapi;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Stream_pra {
	static class Student {
		final String name;
		final String dept; // 부서
		final List<Integer> scores;
		final List<String> courses;

		Student(String name, String dept, List<Integer> scores, List<String> courses) {
			this.name = name;
			this.dept = dept;
			this.scores = scores;
			this.courses = courses;
		}

		double avgScore() {
			return scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		}

		@Override
		public String toString() {
			return String.format("%s(%s, avg=%.1f)", name, dept, avgScore());
		}
	}

	static List<Student> sample() {
		return Arrays.asList(
			new Student("Amy", "Dev", Arrays.asList(90, 80), Arrays.asList("Java", "Git")),
			new Student("Bob", "Dev", Arrays.asList(70, 100, 85), Arrays.asList("Java", "Spring")),
			new Student("Cara", "HR", Arrays.asList(60, 75), Arrays.asList("Excel", "Communication")),
			new Student("Dan", "HR", Arrays.asList(88, 92), Arrays.asList("Communication", "Leadership")),
			new Student("Eve", "QA", Arrays.asList(90, 90), Arrays.asList("Java", "QA"))
		);
	}

	static void main(String[] args) {
		List<Student> students = sample();

		System.out.println("1) map 이름 대문자 리스트");
		List<String> upperNames = students.stream().map(s -> s.name.toUpperCase()).toList();
		System.out.println(" " + upperNames); // [AMY BOB CARA DAN EVE]

		System.out.println("\n2) filter 평균 점수 85점 이상");
		List<String> avg85 = students.stream().filter(s -> s.avgScore() >= 85)
			.map(s -> String.format("%s(%.1f)", s.name, s.avgScore())).toList();
		// List<Student> avg85 = students.stream().filter(s -> s.avgScore() >= 85)
		// 	.toList(); // [Amy(Dev, avg=85.0), Bob(Dev, avg=85.0), Dan(HR, avg=90.0), Eve(QA, avg=90.0)]
		System.out.println(" " + avg85);

		System.out.println("\n3) flatMap 전체 수강 과목");
		List<String> flatList = students.stream().flatMap(s -> s.courses.stream())
			.distinct().sorted().toList(); // distinct = 중복제거, sorted = 정렬
		System.out.println(" " + flatList);

		System.out.println("\n4) 전체 점수 / 최고 학생");
		int totalScore = students.stream().flatMap(s -> s.scores.stream())
			.reduce(0, Integer::sum);
		System.out.println("a) 전체 점수 총합 = " + totalScore);
		Optional<Student> best = students.stream()
			.reduce((a, b) -> a.avgScore() >= b.avgScore() ? a : b);
		// ? a : b = ( if(a>=b) avg = a , else avg = b ) a와 b중에 a가 더 크면 a를 반환 아닐 시 b를 반환 삼항연산자
		System.out.println("b) 최고 평균 학생 = " + best.orElse(null));

		System.out.println("\n5) 부서별 평균 점수");
		Map<String, Double> avgByDept = students.stream()
			.collect(groupingBy(s -> s.dept, averagingDouble(Student::avgScore)
			));
		System.out.println(" " + avgByDept);

		System.out.println("\n groupingBy 수강 인원 수");
		Map<String, Long> courseCounts = students.stream().flatMap(s -> s.courses.stream())
			.collect(groupingBy(s -> s, counting()));
		System.out.println(" " + courseCounts);

	}

}
