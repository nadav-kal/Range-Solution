import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {
        // Check your code here
        range(1,100);
    }

    public static void range(int min, int max) {

        if (min > max) {
            return;
        }
        else if(min == max) {
            System.out.println(min);
        }
        else {
            int randomNumber = randomInRange(min, max);
            System.out.println(randomNumber);
            range(min, randomNumber - 1);
            range(randomNumber + 1, max);
        }
    }

    public static void iterativeRange(int min, int max) {

        Stack<Integer> params = new Stack<Integer>();
        params.push(max);
        params.push(min);

        while(params.size() > 0) {

            min = params.pop();
            max = params.pop();

            if(min == max) {
                System.out.println(min);
            }
            else if(min < max) {
                int randomNumber = randomInRange(min, max);
                System.out.println(randomNumber);
                params.push(randomNumber - 1);
                params.push(min);
                params.push(max);
                params.push(randomNumber + 1);
            }
        }
    }

    public static int randomInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
