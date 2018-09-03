package testing;

public class Test {

	public static void main(String[] args) {
		try {
			f();
		} catch (TIJException2 e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally block");
		}
	}
	
	public static void f() throws TIJException2 {
		try {
			g();
		} catch (TIJException e) {
			throw new TIJException2();
		}
	}
	
	public static void g() throws TIJException {
		throw new TIJException();
	}
}

class TIJException2 extends Exception {
	public TIJException2() {
		super();
	}
}
class TIJException extends Exception {
	
	private String mess;
	
	public TIJException() {
		super();
	}
	
	public TIJException(String arg) {
		super(arg);
		mess = arg;
	}
	
	public void printField() {
		System.out.println(mess);
	}
}