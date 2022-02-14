public class Buggy {
	public boolean isPrime(int x) {
		int max = 1;
		for (int i = 2; i < x / 2; i++) {
			if (x % i == 0)
				max = i;
		}
		if (x == 2 || max == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Buggy a = new Buggy();
		for (int i = 1; i < 100; ++i) {
			System.out.println(i + ": " + a.isPrime(i));
		}
	}
}
