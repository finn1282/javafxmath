package test;

public class getindice {
    public static double calindc(double input1, double cox1, double c1, double input2, double cox2, double c2) {
        double[] results = getix(input1, input2);
        double n1 = results[0];
        double n2 = results[1];
        double step1 = ((n2*c2)-(n1*c1));
        double step2 = ((n1*cox1)-(n2*cox2));
        double result = step1/step2;
        return result;
    }
    
    public static double[] getix(double input1, double input2) {
        double a1 = input1;
        double a2 = input2;
        double times1 = 0;
        double times2 = 0;
        while (a1 != a2) {
            if (a1 > a2) {
                a1 = a1/a2;
            }
            a2 = a2/a1;
        }
        while (input1 != 1) {
            input1 = input1/a1;
            times1++;
        }
        while (input2 != 1) {
            input2 = input2/a2;
            times2++;
        }
        double[] results = new double[3];
        results[0] = times1;
        results[1] = times2;
        return results;
    }
}
