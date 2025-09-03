package corejava.threepillar;

public class MainExec {
    public static void main(String[] args) {
        String first = "Anitha";
        String second = "Somal";
        StringCompare compareObj = new StringCompare(first, second);
        String result = Util.compare(compareObj);
        System.out.println("Result is " + result);
    }
}
