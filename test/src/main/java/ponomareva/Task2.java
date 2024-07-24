package ponomareva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void run(int[] array){
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        for (int el: array) {
            if(frequencies.containsKey(el)) {
                frequencies.put(el, frequencies.get(el) + 1);
            }
            else{
                frequencies.put(el, 1);
            }
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> el_map: frequencies.entrySet()) {
            if(el_map.getValue() > max){
                max = el_map.getValue();
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> el_map: frequencies.entrySet()) {
            if(el_map.getValue() == max){
                result.add(el_map.getKey());
            }
        }

        System.out.println("Maximum inclusion of an element in the array = " + max);
        System.out.println("This is " + result);
    }
}
