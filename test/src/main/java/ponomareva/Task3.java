package ponomareva;

import java.util.Random;

public class Task3 {
    public static void run(int n, String sequence_1, String sequence_2) {
        int count_win_1 = 0;
        int count_win_2 = 0;
        int count_draw = 0;

        for(int i = 0; i < COUNT_RANDOM_SEQUENCES; ++i){
            String cur_sequence = generateRandomSequence(n);
            int count_seq_1 = countOccurrences(cur_sequence, sequence_1);
            int count_seq_2 = countOccurrences(cur_sequence, sequence_2);

            if(count_seq_1 > count_seq_2){
                ++count_win_1;
            }
            else if (count_seq_1 < count_seq_2) {
                ++count_win_2;
            }
            else{
                ++count_draw;
            }
        }

        double probability_win_1 = (double) count_win_1 / COUNT_RANDOM_SEQUENCES;
        double probability_win_2 = (double) count_win_2 / COUNT_RANDOM_SEQUENCES;
        double probability_draw = (double) count_draw / COUNT_RANDOM_SEQUENCES;

        System.out.println("The probability of winning the first player: " + probability_win_1);
        System.out.println("The probability of winning the second player: " + probability_win_2);
        System.out.println("The probability of draw: " + probability_draw);
    }

    private static int countOccurrences(String sequence, String subSequence){
        int fromIndex = 0;
        int count = 0;
        int len = subSequence.length();
        while((fromIndex = sequence.indexOf(subSequence, fromIndex)) != -1){
            ++count;
            fromIndex += len;
        }
        return count;
    }

    private static String generateRandomSequence(int n) {
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; ++i) {
            int num = random.nextInt(6) + 1;
            sb.append(num);
        }

        return sb.toString();
    }

    private static final int COUNT_RANDOM_SEQUENCES = 1000000;
    private static final Random random = new Random();
}
