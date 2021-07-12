package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findgcd {
    
    private static int inputlength;

    public static int calgcd(String input) {
        int gcd = 1;
        List<Integer> intList = getar(input);
        for (int i = 0; i<(inputlength-1); i++){
            int a1 = intList.get(i),  a2 = intList.get(i + 1);
            for(int is = 1; is <= a1 && is <= a2; is++)
            {
                if(a1%is==0 && a2%is==0)
                gcd = is;
            }
        }
        return gcd;
    }

    public static List<Integer> getar(String input) {
        input = input.replaceAll("\\s+","");
        List<String> inputs = Arrays.asList(input.split(","));
        inputlength = inputs.size();
        List<Integer> intList = new ArrayList<Integer>(inputlength);
        for(String s : inputs) intList.add(Integer.valueOf(s));
        return intList;
    }
}
