import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class CountingBits {


    /**
     * Given an integer n, return an array ans of length n + 1 such that 
     * for each i (0 <= i <= n), 
     * ans[i] is the number of 1's in the binary representation of i.
     * 
     * Using tabulation.
     * 
     * Time: O(n) - Space: O(n)
     * 
     * Runtime: 1 ms, faster than 99.93% of Java online submissions.
     * Memory Usage: 43.4 MB, less than 37.18% of Java online submissions.
     */
    static int[] countBits(int n) {

        // **** sanity checks ****
        if (n == 0) return new int[1];

        // **** initialization ****
        int[] table = new int[n + 1];

        // **** populate table ****
        for (int i = 1; i <= n; i++)
            table[i] = table[i >> 1] + (i & 1);
        
        // **** return table ****
        return table;
    }


    /**
     * Given an integer n, return an array ans of length n + 1 such that 
     * for each i (0 <= i <= n), 
     * ans[i] is the number of 1's in the binary representation of i.
     * 
     * Brute force approach.
     * 
     * Time: O(n * log(n)) - Space: O(n)
     * 
     * Runtime: 8 ms, faster than 15.76% of Java online submissions.
     * Memory Usage: 43.1 MB, less than 64.72% of Java online submissions.
     */
    static int[] bruteForce(int n) {

        // **** sanity checks ****
        if (n == 0) return new int[1];

        // **** initialization ****
        int[] ans = new int[n + 1];

        // **** loop computing answer ****
        for (int i = 0; i <= n; i++) {

            // **** for ease of use ****
            int num = i;

            // **** loop counting bits set to 1 ****
            int count = 0;
            for ( ; num != 0; num >>= 1) {
                if (num % 2 == 1)
                    count++;
            }

            // **** update answer array ****
            ans[i] = count;
        }

        // **** return answer ****
        return ans;
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** initialization ****
        long start  = 0;
        long end    = 0;
        int[] ans   = null;

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read n ****
        int n = Integer.parseInt(br.readLine().trim());

        // **** check top limit ****
        if (n > 105)
            n = 105;

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< n: " + n);

        // **** compute and display result ****
        start = System.nanoTime();
        ans = bruteForce(n);
        end = System.nanoTime();
        System.out.println("main <<< bruteForce: " + Arrays.toString(ans));
        System.out.println("main <<< time: " + (end - start) + " ns.");

        // **** compute and display result ****
        start = System.nanoTime();
        ans = countBits(n);
        end = System.nanoTime();
        System.out.println("main <<<  countBits: " + Arrays.toString(ans));
        System.out.println("main <<< time: " + (end - start) + " ns.");
    }
}