import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SolverImp test = new SolverImp();
//		System.out.println(test.multiplicativeInverse(20, 73));
		BigInteger a = new BigInteger("8");
		BigInteger b = new BigInteger("4");
		BigInteger n = new BigInteger("10");
		System.out.println(test.modulus3(a, b, n));
	}
	
}