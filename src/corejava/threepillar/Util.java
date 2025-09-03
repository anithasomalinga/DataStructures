package corejava.threepillar;

public class Util {
    public static String compare(final StringCompare object)
    {
        String first = object.getFirst();
        String second = object.getSecond();
//        String result = null;
        if(first!=null && second!=null){
            if(first.length() + second.length() > 10) {
                return null;
            } else {
                return second;
            }
        }
        return null;
    }
}
