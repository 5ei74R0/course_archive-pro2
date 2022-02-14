public class Throw5 {
	public static void main(String[] args) {
		try {
			Integer temp = Integer.valueOf("aaa");
            System.out.println(temp);
        } catch (Exception e) {
			System.err.println("Exception caught!");
		} catch (NumberFormatException e) {
			System.err.println("NumberFormatException caught!");
		}
	}
}
