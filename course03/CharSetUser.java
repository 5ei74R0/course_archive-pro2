public class CharSetUser {
	public static void main(String[] args) {
		CharSet s = new CharSet();
		s.init();
		System.out.println("count = " + s.count());
		s.add('k'); s.add('e'); s.add('i'); s.add('e');
		System.out.println("a: " + s.search('a'));
		System.out.println("e: " + s.search('e'));
		System.out.println("i: " + s.search('i'));
		System.out.println("o: " + s.search('o'));
		System.out.println("count = " + s.count());
		s.remove('e');
		System.out.println("a: " + s.search('a'));
		System.out.println("e: " + s.search('e'));
		System.out.println("i: " + s.search('i'));
		System.out.println("o: " + s.search('o'));
		System.out.println("count = " + s.count());
		s.add('a');
		s.add('l');
		s.add('m');
		System.out.println("k: " + s.search('k'));
		System.out.println("e: " + s.search('e'));
		System.out.println("i: " + s.search('i'));
		System.out.println("a: " + s.search('a'));
		System.out.println("l: " + s.search('l'));
		System.out.println("m: " + s.search('m'));
		System.out.println("count = " + s.count());
	}
}
