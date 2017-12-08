import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		final SolverImp test = new SolverImp();
		final BigInteger a = new BigInteger("6");
		final BigInteger b = new BigInteger("3");
		final BigInteger n = new BigInteger("10");

		////		System.out.println(test.modulus1(a, b, n));
		////		System.out.println(test.modulus2(a, b, n));
		//		System.out.println(test.modulus3(a, b, n));
		System.out.println(test.multiplicativeInverse(3, 26));

	}

}