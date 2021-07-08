package test;

import static java.lang.Math.sqrt;

public class getquad {
    
    public static double[] CalQuad(double a, double b, double c) {
        double first = sqrt((b*b)-(4*a*c));
        double seconda = -b + first;
        double secondb = -b - first;
        double resulta = seconda/(2*a);
        double resultb = secondb/(2*a);
        double[] results = new double[2];
        results[0] = resulta;
        results[1] = resultb;
        return results;
    }
}
