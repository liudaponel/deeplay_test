import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ponomareva.Task1;

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
}
