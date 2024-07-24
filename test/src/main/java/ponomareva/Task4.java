package ponomareva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task4 {
    public static void run(ArrayList<Integer> array, int K){
        double L_double = countL(array, K);
        if(L_double - Math.floor(L_double) != 0){
            System.out.println("Невозможно");
            return;
        }
        int L = (int)L_double;

        array.sort(Collections.reverseOrder());

        ArrayList<Integer> curArray = new ArrayList<>(array);
        ArrayList<Integer> indexesToDelete = new ArrayList<>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>(K);
        boolean allGood = true;
        for(int i = 0; i < K; ++i){
            answer.add(new ArrayList<>());
            int index = 0;
            int newIndex = 0;
            boolean foundSum = false;
            while(index < curArray.size()) {
                int cur_sum = 0;
                while (index < curArray.size() && cur_sum <= L + i) {
                    Integer cur_num = curArray.get(index);
                    if (cur_sum + cur_num < L + i) {
                        answer.get(i).add(cur_num);
                        indexesToDelete.add(index);
                        cur_sum += cur_num;
                    } else if (cur_sum + cur_num == L + i) {
                        answer.get(i).add(cur_num);
                        indexesToDelete.add(index);
                        cur_sum += cur_num;
                        break;
                    }
                    ++index;
                }

                if (cur_sum == L + i) {
                    for (int j = indexesToDelete.size() - 1; j >= 0; j--) {
                        int indexDelete = indexesToDelete.get(j);
                        curArray.remove(indexDelete);
                    }
                    indexesToDelete.clear();
                    foundSum = true;
                    break;
                } else {
                    if(indexesToDelete.size() == 0){
                        break;
                    }
                    newIndex = indexesToDelete.get(0) + 1;
                    answer.get(i).clear();
                    indexesToDelete.clear();
                    index = newIndex;
                }
            }

            if(!foundSum){
                allGood = false;
                break;
            }
        }

        if(!allGood){
            System.out.print("Невозможно ");
        }
        else{
            for(int i = 0; i < K - 1; ++i) {
                System.out.print(answer.get(i) + ", " + (L + i) + ", ");
            }
            System.out.print(answer.get(K-1) + ", " + (L + K - 1) + ". ");
        }
    }

    private static double countL(ArrayList<Integer> array, int K){
        int sum = 0;
        for (int el : array) {
            sum += el;
        }
        return (double) (sum - (K - 1) * K / 2 ) / K;
    }

    private static void swap(int[] array, int index_1, int index_2){
        int tmp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = tmp;
    }
}
