	interface Second<T>{
	public void m(T t);
}
public class When {
	public static void main(String[]args){
	final int i = 1;
	Second<String> second = s -> System.out.println('b' - 'a' + s + i);
	second.m("c");
	System.out.println(2 + 10.20);
	}	
}
