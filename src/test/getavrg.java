package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class getavrg {
    
    public static int inputlength = 0;
    
    public static double calmean(String input) {
        int[] intList = getar(input);
        double listlength = intList.length;
        double mean = (IntStream.of(intList).sum())/listlength;
        return mean;
    }
    
    public static double calmedian(String input) {
        double median = 0;
        int[] intList = getar(input);
        int listlength = intList.length;
        Arrays.sort(intList);
        if (listlength % 2 == 0) {
            double first =(intList[listlength/2]);
            double second =(intList[(listlength/2)-1]); 
            median = (first+second)/2;
        }
        else {
            median = intList[(listlength-1)/2];
        }
        return median;
    }
    
    public static int calmode(String input) {
        int[] intList = getar(input);
        Integer[] intl = Arrays.stream( intList ).boxed().toArray( Integer[]::new );
        Integer ss = Stream.of(intl).collect(Collectors.groupingBy(Integer::valueOf))
                .values()
                .stream()
                .sorted((a, b) -> b.size() - a.size())
                .collect(Collectors.toList()).get(0).get(0);
        return ss;
    }
    
    public static int[] getar(String input) {
        input = input.replaceAll("\\s+","");
        List<String> inputs = Arrays.asList(input.split(","));
        inputlength = inputs.size();
        int[] intList = new int[inputlength];
        intList = inputs.stream().mapToInt(Integer::parseInt).toArray();
        return intList;
    }
}
