import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HalloumiBoxes{
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while(T--!=0){
            String[] nK = br.readLine().split(" ");
            int n = Integer.parseInt(nK[0]);
            int k = Integer.parseInt(nK[1]);

            int ar[]=new int[n];
            boolean isOrdered=true;
            String[] arToken = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                ar[i] = Integer.parseInt(arToken[i]);
                if(i>0 && ar[i]<ar[i-1]){
                    isOrdered = false;
                }
            }

            if(n==1 || k>1 || (k==1 && isOrdered)){
                ans.append("YES");
            }else{
                ans.append("NO");
            }
            ans.append(System.lineSeparator());
        }
        System.out.println(ans);

    }
}