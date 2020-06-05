package LC.challenge.june;

import java.util.Random;

class Solution {

    int prefixSum[];

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int x = new Random().nextInt(prefixSum[prefixSum.length-1])+1;
        /*for(int i=0;i<prefixSum.length;i++){
            if(x<=prefixSum[i]){
                return i;
            }
        }
        return prefixSum.length-1;*/
        int l = 0, r = prefixSum.length - 1, m;
        while (l<=r) {
            m = (l + r) >>> 1;
            if (x < prefixSum[m]) {
                r = m - 1;
            } else if (x > prefixSum[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}

public class PickAndWait {
    public static void main(String[] args) {
        int w[] = {1, 7, 2};
        Solution solution = new Solution(w);
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }
}
