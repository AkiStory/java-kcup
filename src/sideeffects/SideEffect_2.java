package sideeffects;

public class SideEffect_2 {
	public static class Customer {
		Grade grade;
		int appleCount;
		int bananaCount;

		public Customer(Grade grade) {
			this.grade = grade;
		}
	}

	public enum Grade {
		BASIC,
		SILVER
	}

	static public int applePrice = 1_000;
	static public int bananaPrice = 1_200;

	static double getApplePrice(Grade grade) {

		float discountPct = 0;
		if (grade == Grade.BASIC) {
			discountPct = 0.9f;
		} else if (grade == Grade.SILVER) {
			discountPct = 0.8f;
		}
		return applePrice * discountPct;
	}

	static double getBananaPrice(Grade grade) {

		float discountPct = 0;
		if (grade == Grade.BASIC) {
			discountPct = 0.9f;
		} else if (grade == Grade.SILVER) {
			discountPct = 0.8f;
		}
		return bananaPrice * discountPct;
	}

	static void main(String[] args) {
		System.out.println("사과 기본: " + getApplePrice(Grade.BASIC));
		System.out.println("사과 실버: " + getApplePrice(Grade.SILVER));
		System.out.println("바나나 기본: " + getBananaPrice(Grade.BASIC));
		System.out.println("바나나 실버: " + getBananaPrice(Grade.SILVER));

		Customer customer1 = new Customer(Grade.BASIC);
		customer1.appleCount = 5;
		customer1.bananaCount = 2;

		Customer customer2 = new Customer(Grade.SILVER);
		customer2.appleCount = 3;
		customer2.bananaCount = 3;

		Customer[] customers = {customer1, customer2};

		float total = 0;
		for (Customer customer : customers) {
			float customerTotal = 0;
			if (customer.appleCount >= 5) {
				customerTotal += getApplePrice(customer.grade) * customer.appleCount * 0.9;
			}
			if (customer.bananaCount >= 5) {
				customerTotal += getBananaPrice(customer.grade) * customer.bananaCount * 0.9;
			}
			total += customerTotal;
		}
		System.out.println("총 매출: " + total);
	}
}