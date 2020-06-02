package IB.hashing;

import java.util.HashSet;
import java.util.Set;

public class DiffK {
    public int diffPossible(final int[] A, int B) {
        if(A.length==1){
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<A.length;i++){
            if(set.contains(A[i]+B) || set.contains(A[i]-B)){
                return 1;
            }
            set.add(A[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new DiffK().diffPossible(new int[]{1,5,1},0));
    }
}
