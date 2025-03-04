package Core.Lession1.HW3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < intList.size(); i++) {
            if ((intList.get(i) > 0 && (intList.get(i) % 2 == 0))) {
                resultList.add(intList.get(i));
            }
        }
        Collections.sort(resultList);
        System.out.println(resultList.toString());
    }
}
