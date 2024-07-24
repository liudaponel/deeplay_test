import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ponomareva.Task1;
import ponomareva.Task2;
import ponomareva.Task3;

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
}
