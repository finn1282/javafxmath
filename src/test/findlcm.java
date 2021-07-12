package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findlcm {
    
    private static int inputlength;

    public static double callcm(String input) {
        double result = 0;
        int firs = 0;
        List<Double> doubleList = getar(input);
        for (int i = 0; i<(inputlength-1); i++){
            double a1 = doubleList.get(i),  a2 = doubleList.get(i + 1);
            int gcd = calgcd((int) a1, (int) a2);
            result = (a1*a2)/gcd;
        }
        return result;
    }
    
    public static int calgcd(int a1, int a2) {
        int gcd = 1;
        for(int i = 1; i <= a1 && i <= a2; i++)
        {
            if(a1%i==0 && a2%i==0)
                gcd = i;
        }
        return gcd;
    }

    public static List<Double> getar(String input) {
        input = input.replaceAll("\\s+","");
        List<String> inputs = Arrays.asList(input.split(","));
        inputlength = inputs.size();
        List<Double> doubleList = new ArrayList<Double>(inputlength);
        for(String s : inputs) doubleList.add(Double.valueOf(s));
        return doubleList;
    }
}