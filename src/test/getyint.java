package test;

// Used to calculate and return the y-intercept from 4 inputs

public class getyint {
    public static double CalYInt(double x1, double y1, double x2, double y2) {
        // Uses 4 inputs in the formula y-m*x, takes in and returns doubles
        double Gradient = getgradient.CalGradient(x1, y1, x2, y2);
        double YInt = y1-Gradient*x1;
        return YInt;
    }
}
