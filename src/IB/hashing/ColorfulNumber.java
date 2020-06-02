package IB.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    public int colorful(int A) {
        Set<Long> set = new HashSet<Long>();
        ArrayList<Long> list = new ArrayList<>();
        while(A!=0){
            list.add(new Long(A%10));
            A=A/10;
        }
        long temp=1;
        for(int i=0;i<list.size();i++){
            temp=list.get(i);
            if(set.contains(temp)){
                return 0;
            }
            set.add(temp);
            for(int j=i+1;j<list.size();j++){
                temp*=list.get(j);
                if(set.contains(temp)){
                    return 0;
                }
                set.add(temp);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(99));
    }
}
