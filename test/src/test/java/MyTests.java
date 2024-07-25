import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import ponomareva.Task1;
import ponomareva.Task2;
import ponomareva.Task3;
import ponomareva.Task4;

public class MyTests {
    @Test
    void task1(){
        int N = 1000;
        int[] array = new int[N];

        for(int j = 0; j < 10; ++j) {
            Task1.run(array);

            int i = 0;
            while (i < N - 1 && array[i] % 2 != 0 && array[i + 1] % 2 != 0) {
                assertTrue(array[i] <= array[i + 1]);
                ++i;
            }
            ++i;
            while (i < N - 1 && array[i] == 0) {
                ++i;
            }
            while (i < N - 1 && array[i] % 2 == 0 && array[i + 1] % 2 == 0) {
                assertTrue(array[i] >= array[i + 1]);
                ++i;
            }
        }
    }

    @Test
    void task2(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int[] array = {1, 2, 3, 3, 3, 4, 5, 5, 5, 7, 8, 7, 8, 7, 8};
        Task2.run(array);
        String expected = "Start values: [1, 2, 3, 3, 3, 4, 5, 5, 5, 7, 8, 7, 8, 7, 8]\r\n" +
                            "Maximum inclusion of an element in the array = 3 : [3, 5, 7, 8]\r\n";

        String result = outputStream.toString();
        assertEquals(expected, result);
    }

    @Test
    void task3(){
        int n = 1000;
        String sequence1 = "122";
        String sequence2 = "251";
        Task3.run(n, sequence1, sequence2);
    }

    @Test
    void task4Test1(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ArrayList<Integer> array = new ArrayList<>();
        int[] arr = {10, 11, 7, 7, 12};
        for (int el : arr) {
            array.add(el);
        }
        int K = 2;
        Task4.run(array, K);

        String expected = "[12, 11], 23, [10, 7, 7], 24";
        String result = outputStream.toString();
        assertEquals(expected, result);
    }

    @Test
    void task4Test2(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ArrayList<Integer> array = new ArrayList<>();
        int[] arr = {7, 8, 12, 1};
        for (int el : arr) {
            array.add(el);
        }
        int K = 3;
        Task4.run(array, K);

        String expected = "Невозможно";
        String result = outputStream.toString();
        assertEquals(expected, result);
    }

    @Test
    void task4Test3(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ArrayList<Integer> array = new ArrayList<>();
        int[] arr = {5, 2, 6, 4, 3, 6};
        for (int el : arr) {
            array.add(el);
        }
        int K = 4;
        Task4.run(array, K);

        String expected = "[5], 5, [6], 6, [4, 3], 7, [6, 2], 8";
        String result = outputStream.toString();
        assertEquals(expected, result);
    }

    @Test
    void task4Test4(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ArrayList<Integer> array = new ArrayList<>();
        int[] arr = {2, 5, 10, 4, 30};
        for (int el : arr) {
            array.add(el);
        }
        int K = 2;
        Task4.run(array, K);

        String expected = "Невозможно";
        String result = outputStream.toString();
        assertEquals(expected, result);
    }
}
