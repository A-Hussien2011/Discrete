import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author a7med
 *
 */
public class SolverImp implements Solver {

	List gcdEquations = new ArrayList<GcdEquation>();
	@Override
	public BigInteger modulus1(BigInteger a, BigInteger b, BigInteger c) {
		final long startTime = System.currentTimeMillis();
		BigInteger f = new BigInteger("1");
		BigInteger count = new BigInteger("0");
		while(b.compareTo(count) != 0){
			f = f.multiply(a);
			count = count.add(BigInteger.ONE);
		}
		final long stopTime = System.currentTimeMillis();
		final long elapsedTime = stopTime - startTime;
		System.out.println("elapsed time :" + elapsedTime);
		return f.mod(c);
	}

	@Override
	public BigInteger modulus2(BigInteger a, BigInteger b, BigInteger c) {
		final long startTime = System.currentTimeMillis();
		BigInteger f = new BigInteger("1");
		BigInteger count = new BigInteger("0");
		while(b.compareTo(count) != 0){
			f = f.multiply(a);
			count = count.add(BigInteger.ONE);
			f = f.mod(c);
		}
		final long stopTime = System.currentTimeMillis();
		final long elapsedTime = stopTime - startTime;
		System.out.println("elapsed time :" + elapsedTime);
		return f;
	}


	@Override
	public BigInteger modulus3(BigInteger a, BigInteger b, BigInteger c) {
		final long startTime = System.currentTimeMillis();
		final String binaryRepresent = b.toString(2);
		BigInteger result = a;
		for(int i = 1; i < binaryRepresent.length(); i++){
			result = result.pow(2).mod(c);
			if(binaryRepresent.charAt(i) == '1'){
				result = result.multiply(a).mod(c);
			}
		}
		final long stopTime = System.currentTimeMillis();
		final long elapsedTime = stopTime - startTime;
		System.out.println("elapsed time :" + elapsedTime);
		return result;
	}


	@Override
	public BigInteger modulus4(BigInteger a, BigInteger b, BigInteger c) {
		if(b.equals(BigInteger.ZERO)){
			return BigInteger.ONE;
		}
		else if(b.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
			final BigInteger y = modulus4(a, b.divide(BigInteger.valueOf(2)), c);
			return y.multiply(y).mod(c);
		}
		else{
			return ( a.mod(c).multiply(modulus4(a,b.subtract(BigInteger.ONE),c)) ).mod(c);
		}
	}

	@Override
	public Integer CRT(int[] a, int[] m, int k) {
		int A = 0 ;
		int M = 1;
		final int [] Mi = new int[k];
		final int [] mInverse = new int[k];
		for (int i = 0; i < k ; i++) {

			M = M * m[i];
		}

		for (int i = 0; i < k; i++) {

			Mi[i] = M / m[i] ;

		}

		for (int i = 0 ; i < k ; i++){

			mInverse [i] = this.multiplicativeInverse( Mi[i] , m[i] );
		}

		for (int i = 0; i < k ; i++) {

			A = A + a[i] * Mi[i] * mInverse[i] ;

		}

		A = A % M ;


		return  A ;
	}

	@Override
	public Integer multiplicativeInverse(Integer a, Integer m) {
		a = a % m;
		for (int x = 1; x < m; x++) {
			if ((a * x) % m == 1) {
				return x;
			}
		}
		return 1;
	}


}