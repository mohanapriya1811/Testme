package learnJava;

public class StaticKeyword {

	static int number;
	
	static int initNum(int number) {
		return number;
	}
	
	void displayNum() {
		System.out.println(StaticKeyword.initNum(number));
	}
	public static void main(String[] args) {
		StaticKeyword st = new StaticKeyword();
		StaticKeyword.initNum(50);
		st.displayNum();
		StaticKeyword.number = 25;
		st.displayNum();
		StaticKeyword.number = 35;
		st.displayNum();
		System.out.println(StaticKeyword.number);
	}
}
