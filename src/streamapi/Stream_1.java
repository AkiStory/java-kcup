package streamapi;

import java.util.Arrays;
import java.util.List;

public class Stream_1 {
	static int sumOfSquaresOfEven(List<Integer> nums) {
		return nums.stream()
			.filter(n -> n % 2 == 0)
			.map(n -> n * n)
			.reduce(0, Integer::sum);

		// int result = nums.stream().filter(n -> n % 2 == 0)
		// 	.map(n -> n * n).reduce(0, Integer::sum);
		// return result
	}

	// for/if문
	// 	int sum = 0;
	// 	for (int n : nums) {
	// 		if (n % 2 == 0) {
	// 			int sq = n * n;
	// 			sum += sq;
	// 		}
	// 	}
	// 	return sum;
	// }

	static void main(String[] args) {
		System.out.println(sumOfSquaresOfEven(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}
}
