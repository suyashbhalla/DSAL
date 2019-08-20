import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Subset {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T--!=0){
            map =new HashMap<String, Integer>();
            String str[]=br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);

            int ar[] = new int[N];
            str = br.readLine().split(" ");
            for(int i=0;i<N;i++){
                ar[i] = Integer.parseInt(str[i]);
            }

            System.out.println(fun(ar, ar.length-1,K,1));
        }


    }




    static Map<String, Integer> map;

    private static int fun(int ar[], int index, int K,int currentVal){
        if(K==0){
            return currentVal;
        }
        if(index < 0){
            return 0;
        }
        int x,y, t = currentVal*ar[index];
        if(!map.containsKey((index-1)+":"+(K-1)+":"+t)){
            x = fun(ar, index -1, K-1,t);
            map.put((index-1)+":"+(K-1)+":"+t,x);
        }else {
            x = map.get((index-1)+":"+(K-1)+":"+t);
        }
        if(!map.containsKey((index-1)+":"+(K)+":"+currentVal)){
            y = fun(ar, index -1, K,currentVal);
            map.put((index-1)+":"+(K)+":"+currentVal,y);
        }else {
            y = map.get((index-1)+":"+(K)+":"+currentVal);
        }
        return  (int)((x+y) % 1000000007L);
    }
}
