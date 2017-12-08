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
		long startTime = System.currentTimeMillis();
		BigInteger f = new BigInteger("1");
		BigInteger count = new BigInteger("0");
		while(b.compareTo(count) != 0){
			f = f.multiply(a);
			count = count.add(BigInteger.ONE);
		}
		long stopTime = System.currentTimeMillis();
	     long elapsedTime = stopTime - startTime;
	     System.out.println("elapsed time :" + elapsedTime);
		return f.mod(c);
	}
	
	@Override
	public BigInteger modulus2(BigInteger a, BigInteger b, BigInteger c) {
		long startTime = System.currentTimeMillis();
		BigInteger f = new BigInteger("1");
		BigInteger count = new BigInteger("0");
		while(b.compareTo(count) != 0){
			f = f.multiply(a);
			count = count.add(BigInteger.ONE);
			f = f.mod(c);
		}
		long stopTime = System.currentTimeMillis();
	     long elapsedTime = stopTime - startTime;
	     System.out.println("elapsed time :" + elapsedTime);
		return f;
	}


	@Override
	public BigInteger modulus3(BigInteger a, BigInteger b, BigInteger c) {
		long startTime = System.currentTimeMillis();
		String binaryRepresent = b.toString(2);
		BigInteger result = a;
		for(int i = 1; i < binaryRepresent.length(); i++){
			result = result.pow(2).mod(c);
			if(binaryRepresent.charAt(i) == '1'){
				result = result.multiply(a).mod(c);
			}
		}
		long stopTime = System.currentTimeMillis();
	     long elapsedTime = stopTime - startTime;
	     System.out.println("elapsed time :" + elapsedTime);
		return result;
	}


	@Override
	public BigInteger modulus4(BigInteger a, BigInteger b, BigInteger c) {
		if(b.equals(BigInteger.ZERO)){
			return BigInteger.ONE;
		}
		else if(b.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
			BigInteger y = modulus4(a, b.divide(BigInteger.valueOf(2)), c);
			return y.multiply(y).mod(c);
		}
		else{
			return ( a.mod(c).multiply(modulus4(a,b.subtract(BigInteger.ONE),c)) ).mod(c);
		}
	}

	@Override
	public Integer CRT(Integer m1, Integer m2, Integer m3) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public Integer multiplicativeInverse(Integer a, Integer n) {
		// el7eta eli gaia dih 3shan lw d5alii el awel as8r mn eltanii b3d keda brg3hom tanii b3d m3mel check el gcd
		if(a<n){
			final int temp = a;
			a = n ;
			n = temp;
		}
		final GcdEquation gcdEquation = new GcdEquation(a, n, a/n, a%n);
		final int temp = a;
		a = n ;
		n = temp;
		final boolean gcdBoolean=  gcdCheck(gcdEquation);
		if (gcdBoolean){
			// adam d5lt hena m3nah en el gcd bt3hom == 1 wel check mzbot
			final int inverse = multiInverse();
			return inverse;
		} else {
			System.out.println("la msh fol 3lik keda");
		}
		return n;
	}

	//dih function btrg3li el inverse
	private int multiInverse() {
		final ExtendedEuclideanEquation exEquation = new ExtendedEuclideanEquation(0, 1, 0);
		for (int i = 0; i < gcdEquations.size(); i++) {
			GcdEquation temp ;
			temp = (GcdEquation) gcdEquations.get(i);
			exEquation.setT(exEquation.getT1() - (temp.x3 * exEquation.getT2()));
			exEquation.setT1(exEquation.getT2());
			exEquation.setT2(exEquation.getT());
		}
		return exEquation.getT1();
		// TODO Auto-generated method stub

	}
	// bt3mel check
	public boolean gcdCheck(GcdEquation equation) {
		gcdEquations.add(equation);
		GcdEquation equationTemp = null;
		if ((equation.x2 % equation.x4 == 0 ) && equation.x4 == 1){
			equationTemp = new GcdEquation(equation.x2 , equation.x4 ,equation.x2 / equation.x4 , equation.x2 % equation.x4);
			gcdEquations.add(equationTemp);
			return true;
		}
		else if ((equation.x2 % equation.x4 == 0 ) && equation.x4 != 1){
			return false;
		}
		else if (equation.x2 % equation.x4 != 0 ){
			equationTemp = new GcdEquation(equation.x2 , equation.x4 ,equation.x2 / equation.x4 , equation.x2 % equation.x4);
		}
		return gcdCheck(equationTemp);


	}

}