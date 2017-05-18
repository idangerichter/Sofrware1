package il.ac.tau.cs.sw1.hw6;

public class Polynomial {

	private double[] coefficients;
	/*
	 * Creates the zero-polynomial with p(x) = 0 for all x.
	 */
	public Polynomial()
	{
		coefficients = new double[1];
		coefficients[0] = 0;
	} 
	/*
	 * Creates a new polynomial with the given coefficients.
	 */
	public Polynomial(double[] coefficients) 
	{
		// minimize coefficients array to when an != 0
		int n = coefficients.length;
		for (int i=coefficients.length-1; i>= 0;i--){
			if (coefficients[i]!=0){
				break;
			}
			n--;
		}

		this.coefficients = new double[n];
		System.arraycopy(coefficients, 0, this.coefficients, 0, n);
	}
	/*
	 * Adds this polynomial to the given one
	 *  and returns the sum as a new polynomial.
	 */
	public Polynomial adds(Polynomial polynomial)
	{
		int n1 = getDegree();
		int n2 = polynomial.getDegree();
		int n = Math.max(n1, n2);

		double[] coefs = new double[n];
		for (int i=0;i<n;i++){
			if (i>=n1){
				for (int j=i;j<n;j++){
					coefs[j] = polynomial.getCoefficient(i);
				}
			}
			else if (i>=n2){
				for (int j=i;j<n;j++){
					coefs[j] = getCoefficient(i);
				}
			}
			else{
				coefs[i] = getCoefficient(i) + polynomial.getCoefficient(i);
			}
		}
		return new Polynomial(coefs);
	}

	/*
	 * Multiplies a to this polynomial and returns 
	 * the result as a new polynomial.
	 */
	public Polynomial multiply(double a)
	{
		return null;
		
	}
	/*
	 * Returns the degree (the largest exponent) of this polynomial.
	 */
	public int getDegree() {
		// if an == 0 => than its the zero polynomial
		if (coefficients[coefficients.length-1] == 0)
			return 0;
		return coefficients.length;
	}
	/*
	 * Returns the coefficient of the variable x 
	 * with degree n in this polynomial.
	 */
	public double getCoefficient(int n)
	{
		return coefficients[n];
	}
	
	/*
	 * Returns the first derivation of this polynomial.
	 *  The first derivation of a polynomal a0x0 + ...  + anxn is defined as 1 * a1x0 + ... + n anxn-1.
	
	 */
	public Polynomial getFirstDerivation()
	{
		return this;
	}
	
	/*
	 * given an assignment for the variable x,
	 * compute the polynomial value
	 */
	public double computePolynomial(int x)
	{
		double sum = 0;
		int x2i = 1;
		for (double coef: coefficients){
			sum += coef*x2i;
			x2i*= x;
		}
		return sum;
	}
	
	
	
	

    
    

}
