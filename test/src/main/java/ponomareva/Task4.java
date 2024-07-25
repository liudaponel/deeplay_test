package ponomareva;

import java.util.ArrayList;
import java.util.Collections;

public class Task4 {
    /**
     * –азделение массива на K частей.
     * »спользован алгоритм, в котором сначала сортируетс€ начальный массив,
     * а затем дл€ каждой i-й части выбираютс€ числа, начина€ с наибольшего,
     * которые при суммировании дают L + i. ≈сли дл€ какой-то части не удалось
     * собрать сумму L + i, значит, ответ будет "Ќевозможно".
     * »наче ответ в формате [1, 2], 3, [2, 1, 1], 4
     * √де 1,2 - перва€ часть с суммой 3;
     * а 2, 1, 1 - втора€ часть с суммой 4.
     * @param array массив, который нужно разделить на K частей
     * @param K параметр, задающий на сколько частей нужно разделить массив
     * **/
    public static void run(ArrayList<Integer> array, int K) {
        double L_double = countL(array, K);
        if (L_double - Math.floor(L_double) != 0) {
            System.out.print("Ќевозможно");
            return;
        }
        int L = (int) L_double;

        array.sort(Collections.reverseOrder());

        ArrayList<Integer> curArray = new ArrayList<>(array);
        ArrayList<Integer> indexesToDelete = new ArrayList<>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>(K);
        boolean allGood = true;
        for (int i = 0; i < K; ++i) {
            answer.add(new ArrayList<>());
            int index = 0;
            boolean foundSum = false;
            while (index < curArray.size()) {
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
                    if (indexesToDelete.size() == 0) {
                        break;
                    }
                    index = indexesToDelete.get(0) + 1;
                    answer.get(i).clear();
                    indexesToDelete.clear();
                }
            }

            if (!foundSum) {
                allGood = false;
                break;
            }
        }

        if (!allGood) {
            System.out.print("Ќевозможно");
        } else {
            for (int i = 0; i < K - 1; ++i) {
                System.out.print(answer.get(i) + ", " + (L + i) + ", ");
            }
            System.out.print(answer.get(K - 1) + ", " + (L + K - 1));
        }
    }

    private static double countL(ArrayList<Integer> array, int K) {
        int sum = 0;
        for (int el : array) {
            sum += el;
        }
        return (double) (sum - (K - 1) * K / 2) / K;
    }
}
