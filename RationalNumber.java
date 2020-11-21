public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(nume/deno);//this value is ignored! 
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    } else {
    numerator = nume;
    denominator = deno;
    }
  }

  public double getValue(){
    return (numerator*1.0)/(denominator*1.0);
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber output = new RationalNumber(getDenominator(),getNumerator());
    return output;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (getNumerator()==other.getNumerator()&&getDenominator()==other.getDenominator());
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    reduce();
    return ""+getNumerator()+"/"+getDenominator();
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    //http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    int output = 1;
    for (int i = 1; i<=Math.max(a, b); i++) {
      if (a%i==0 && b%i==0) {
        output = i;
      }
    }
    return output;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int p = gcd(Math.abs(numerator), Math.abs(denominator));
    denominator = denominator/p;
    numerator = numerator/p;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber output = new RationalNumber(getNumerator()*other.getNumerator(),getDenominator()*other.getDenominator());
    output.reduce();
    return output;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber p = other.reciprocal();
    RationalNumber output = multiply(p);
    output.reduce();
    return output;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber output = new RationalNumber(getNumerator()*other.getDenominator()+other.getNumerator()*getDenominator(),getDenominator()*other.getDenominator());
    output.reduce();
    return output;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber output = new RationalNumber(getNumerator()*other.getDenominator()-other.getNumerator()*getDenominator(),getDenominator()*other.getDenominator());
    output.reduce();
    return output;
  }
} 