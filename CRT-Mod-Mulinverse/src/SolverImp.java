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
		BigInteger f = new BigInteger("1");
		BigInteger count = new BigInteger("0");
		while(b.compareTo(count) != 0){
			f = f.multiply(a);
			count = count.add(BigInteger.ONE);
		}
		return f.mod(c);
	}
	
	@Override
	public BigInteger modulus2(BigInteger a, BigInteger b, BigInteger c) {
		BigInteger f = new BigInteger("1");
		BigInteger count = new BigInteger("0");
		while(b.compareTo(count) != 0){
			f = f.multiply(a);
			count = count.add(BigInteger.ONE);
			f = f.mod(c);
		}
		return f;
	}


	@Override
	public BigInteger modulus3(BigInteger a, BigInteger b, BigInteger c) {
		
		String multiBinary = b.toString(2);
		BigInteger f = new BigInteger("1");
		for(int i = 0; i <= multiBinary.length() - 1; i++){
			f = f.multiply(f);
			f = f.mod(c);
			if(multiBinary.charAt(i) == '1'){
				f = f.multiply(a);
				f = f.mod(c);
			}
		}
		return f;
	}


	@Override
	public BigInteger modulus4(BigInteger a, BigInteger b, BigInteger c) {
		// TODO Auto-generated method stub
		return null;
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