package IB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {
    public int longestConsecutive(final List<Integer> A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i:A){
            set.add(i);
        }
        int result = 0;
        for(int i:A){
            int t=1;
            int x=i-1;
            while(set.contains(x)){
                t++;
                set.remove(x);
                x--;
            }
            while(set.contains(i+1)){
                t++;
                set.remove(i+1);
                i++;
            }
            result = Math.max(result, t);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer ar[]= {100, 4, 200, 1, 3, 2};
        //Integer ar[]= {100, -4, 200, -1, -3, -2};
        //Integer ar[]= {-1,-2,0};
        //Integer ar[]= {6, 4, 5, 2, 3 };
        //Integer ar[]= {1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        List<Integer> list = Arrays.asList(ar);
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(list));
    }
}
