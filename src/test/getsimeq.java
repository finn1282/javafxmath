package test;

public class getsimeq {
    public static double[] calsimeq(int x1, int y1, int x2, int y2, int res1, int res2) {
        int det = (x1*y2)-(y1*x2);
        double x = ((y2*res1)+(-y1*res2))/det;
        double y = ((-x2*res1)+(x1*res2))/det;
        double[] result = new double[2];
        result[0] = x;
        result[1] = y;
        return result;
    }
}
