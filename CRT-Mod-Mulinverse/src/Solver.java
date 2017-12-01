import java.math.BigInteger;

/**
 * @author a7med
 *
 */
public interface Solver {
	
	public BigInteger modulus1(BigInteger a, BigInteger b, BigInteger c);
	
	public BigInteger modulus2(BigInteger a, BigInteger b, BigInteger c);
	
	public BigInteger modulus3(BigInteger a, BigInteger b, BigInteger c);
	
	public BigInteger modulus4(BigInteger a, BigInteger b, BigInteger c);
	
	public Integer multiplicativeInverse(Integer a, Integer n);
	
	public Integer CRT(Integer m1, Integer m2, Integer m3);
	
}