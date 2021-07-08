package test;

public class checkinput {
    public static boolean checkempty(String string){
        return string.isEmpty();
    }

    public static boolean checkletter(String name) {
        boolean containsDigit = false;
        for (char c : name.toCharArray()) {
            if (containsDigit = Character.isDigit(c)) {
                break;
            }
        }
        return containsDigit;
    }
}
