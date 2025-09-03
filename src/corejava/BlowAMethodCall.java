package corejava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BlowAMethodCall {
    public static void main(String[] args) {
        List<Integer> list = List.of(7,1,2);
        boolean result = isStart(list);
        System.out.println(result);
    }

    public static boolean isStart(List<Integer> list){
//        list = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        list.add(2);
        System.out.println(list.size());
        return false;
    }
}
