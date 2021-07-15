package test;

public class getsimeq {
    public static double[] calsimeq(double x1, double y1, double x2, double y2, double res1, double res2) {
        double det = (x1*y2)-(y1*x2);
        double x = ((y2*res1)+(-y1*res2))/det;
        double y = ((-x2*res1)+(x1*res2))/det;
        double[] result = new double[2];
        result[0] = x;
        result[1] = y;
        return result;
    }
}
