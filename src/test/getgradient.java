package test;

// Used to calculate and return the gradient from 4 inputs

public class getgradient {
    public static double CalGradient(double x1, double y1, double x2, double y2){
        // Uses 4 inputs in the formula (y2-y1)/(x2-x1), takes in and returns doubles
        double dify = y2-y1;
        double difx = x2-x1;
        double Gradient = dify/difx;
        return Gradient;
    }
}
