import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ponomareva.Task1;
import ponomareva.Task2;
import ponomareva.Task3;
import ponomareva.Task4;

import java.util.ArrayList;

public class MyTests {
    @Test
    void task1(){
        int N = 1000;
        int[] array = new int[N];
        Task1.run(array);

        int i = 0;
        while(i < N - 1 && array[i] % 2 != 0 && array[i + 1] % 2 != 0) {
            assertTrue(array[i] <= array[i + 1]);
            ++i;
        }
        ++i;
        while(i < N - 1 && array[i] == 0) {
            ++i;
        }
        while(i < N - 1 && array[i] % 2 == 0 && array[i + 1] % 2 == 0) {
            assertTrue(array[i] >= array[i + 1]);
            ++i;
        }
    }

    @Test
    void task2(){
        int[] array = {1, 2, 3, 3, 3, 4, 5, 5, 5, 7, 8, 7, 8, 7, 8};
        Task2.run(array);
    }

    @Test
    void task3(){
        int n = 1000;
        String sequence1 = "122";
        String sequence2 = "251";
        Task3.run(n, sequence1, sequence2);
    }

    @Test
    void task4(){
        ArrayList<Integer> array = new ArrayList<>();
        int[] arr = {10, 11, 7, 7, 12};
        for (int el : arr) {
            array.add(el);
        }
        int K = 2;
        Task4.run(array, K);

        ArrayList<Integer> array2 = new ArrayList<>();
        int[] arr2 = {7, 8, 12, 1};
        for (int el : arr2) {
            array2.add(el);
        }
        int K2 = 3;
        Task4.run(array2, K2);

        ArrayList<Integer> array3 = new ArrayList<>();
        int[] arr3 = {5, 2, 6, 4, 3, 6};
        for (int el : arr3) {
            array3.add(el);
        }
        int K3 = 4;
        Task4.run(array3, K3);
    }
}
