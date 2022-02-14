public class Throw1 {

	public static void methodA(String fruit) throws Exception {
		if (fruit.equals("orange"))
			throw new Exception("ORANGE!");
		System.out.println("Fruit = " + fruit);
	}

	public static void main(String[] args) throws Exception {
		methodA("apple");
		System.out.println("Let's eat!");
		methodA("orange");
		System.out.println("The end");
	}
}
