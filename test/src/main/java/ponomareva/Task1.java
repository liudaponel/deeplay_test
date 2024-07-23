package ponomareva;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void run(int[] array){
        fillArray(array);
        System.out.println(Arrays.toString(array));

        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    private static void fillArray(int[] array){
        Random random = new Random();

        for(int i = 0; i < array.length; ++i){
            array[i] = random.nextInt();
        }
    }

    private static void sortArray(int[] array){
        int n = array.length;
        int end_odd = 0;
        int start_even = n - 1;
        while(end_odd < start_even) {
            while(end_odd < n && array[end_odd] % 2 != 0){
                ++end_odd;
            }
            while (start_even >= 0 && array[start_even] % 2 == 0){
                --start_even;
            }

            if(end_odd < start_even){
                swap(array, end_odd, start_even);
            }
        }
        --end_odd;
        ++start_even;

        Arrays.sort(array, 0, end_odd + 1);
        Arrays.sort(array, start_even, n);

        while(array[start_even] == 0){
            ++start_even;
        }

        for(int i = 0; i <= (n - 1 - start_even) / 2; ++i){
            swap(array, start_even + i, n - 1 - i);
        }
    }

    private static void swap(int[] array, int index_1, int index_2){
        int tmp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = tmp;
    }
}
