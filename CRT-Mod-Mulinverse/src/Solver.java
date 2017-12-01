import java.math.BigInteger;

/**
 * @author a7med
 *
 */
public interface Solver {
	
	public BigInteger modulus(Integer a, BigInteger b, BigInteger c);
	
	public Integer multiplicativeInverse(Integer a, Integer n);
	
	public Integer CRT(Integer m1, Integer m2, Integer m3);
	
}