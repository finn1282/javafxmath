package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findgcd {
    
    private static int inputlength;

    public static int calgcd(String input) {
        int result = 0;
        List<Integer> intList = getar(input);
        for (int i = 0; i<(inputlength-1); i++){
            int a1 = intList.get(i);
            int a2 = intList.get(i + 1);
            while(a1 !=  a2) {
                if(a1 > a2)
                    a1 = a1- a2;
                else
                    a2 = a2 - a1;
            }
            result = a2;
        }
        return result;
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
