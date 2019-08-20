import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ArrayQuery {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ar[] = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(str[i]);
        }
        int Q = Integer.parseInt(br.readLine());

        int temp =0;
        while (Q--!=0){
            str=br.readLine().split(" ");

            if(str[0].equals("Increment")){
                ar[Integer.parseInt(str[1])]++;
                continue;
            }

            if(str[0].equals("Left")){
                temp--;
                continue;
            }

            if(str[0].equals("Left")){
                temp++;
                continue;
            }

            if(temp<0){

            }

            if(str[0].equals("Update")){
                ar[Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
                continue;
            }

            System.out.println(ar[Integer.parseInt(str[1])]);

        }


    }
}
