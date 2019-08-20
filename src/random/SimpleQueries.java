
import java.util.*;

public class SimpleQueries {

    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        /*A.add(1);
        A.add(2);
        A.add(4);*/
        /*A.add(81);A.add(27);A.add(171);A.add(22);A.add(41);A.add(24);
        A.add(22);A.add(19);A.add(188);A.add(122);*/
        A.add(122);A.add(122);A.add(122);
        A.add(122);A.add(122);A.add(122);A.add(122);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(11);
        B.add(51);
        B.add(40);

        System.out.println(toProd(90));
        System.out.println(solve(A, B) + " \nCorrect :");
        //System.out.println(solve1(A, B));
        long ar[] = {637L, 679L, 681L, 697L, 718L};
        System.out.println(searchIndex(ar,698));
    }

    public static ArrayList<Integer> solve1(ArrayList<Integer> as, ArrayList<Integer> qs) {
        int n = as.size();
        Stack<Integer> st = new Stack<Integer>();
        int[] left = new int[n];
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && as.get(st.peek()) < as.get(i)) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st = new Stack<Integer>();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && as.get(st.peek()) <= as.get(i)) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        Map<Integer, Integer> prod = new HashMap<Integer, Integer>();
        List<int[]> counts = new ArrayList<int[]>();
        for (int i = 0; i < n; ++i) {
            System.out.print((i - left[i]) +"-" + (right[i] - i)+" ");
            int cnt = (i - left[i]) * (right[i] - i);
            int a = as.get(i);
            Integer pr = prod.get(a);
            if (pr == null) {
                pr = toProd(a);
                prod.put(a, pr);
            }
            counts.add(new int[]{pr, cnt});
        }

        Collections.sort(counts, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for(int []x:counts){
            System.out.print("( "+x[0]+" "+x[1]+") ");
        }
        int[] vals = new int[n];
        long[] bounds = new long[n];
        for (int i = 0; i < n; ++i) {
            int [] c = counts.get(i);
            vals[i] = c[0];
            bounds[i] = c[1];
            if (i > 0) bounds[i] += bounds[i - 1];
            if (bounds[i] > Integer.MAX_VALUE * 2L) bounds[i] = Integer.MAX_VALUE * 2L;
        }
        System.out.println(Arrays.toString(bounds));
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int q : qs) {
            int pos = Arrays.binarySearch(bounds, q);
            if (pos < 0) {
                pos = -1 - pos;
            }
            res.add(vals[pos]);
        }
        return res;
    }

    private final static long b = (long) (1e9 + 7);

    private static int toProd(int a) {
        long res = a;
        for (int d = 2; d * d <= a; ++d) {
            if (a % d != 0) continue;
            int m = (d * d == a) ? d : a;
            res = (res * m) % b;
        }
        return (int) res;
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        int leftSearch[] = getLeftHighestIndexList(A);
        int rightSearch[] = getRightHighestIndexList(A);
        List<int[]> list = new ArrayList<>();
        /*System.out.println(Arrays.toString(leftSearch));
        System.out.println(Arrays.toString(rightSearch));*/
        for(int i=0;i<leftSearch.length;i++){
            Integer val = getProductOfDivisors(A.get(i));
            Integer freq = (leftSearch[i]*rightSearch[i]);
            list.add(i,new int[]{val,freq});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });

                //System.out.println(map);

        long ar[]= new long[list.size()];
        int val[]= new int[list.size()];
        int i=0;
        for(int lr[]:list){
            val[i]=lr[0];
            if(i==0){
                ar[i] = lr[1];
                i++;
                continue;
            }
            ar[i] = ar[i-1] + lr[1];
            if (ar[i] > Integer.MAX_VALUE * 2L) ar[i] = Integer.MAX_VALUE * 2L;
            i++;
        }
        //System.out.println(Arrays.toString(val));

        ArrayList<Integer> ret = new ArrayList<>();
        for(Integer x:B){
            ret.add(val[searchIndex(ar,x)]);
        }
        return ret;
    }

    private static int searchIndex(long[] ar, Integer i) {
        int x = Arrays.binarySearch(ar,i);
        if(x>=0){
            return x;
        }
        return (-1 - x)<ar.length?(-1 - x):ar.length-1;
    }

    private static int[] getRightHighestIndexList(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[a.size()];
        ret[a.size()-1] = 1;
        stack.push(a.size()-1);
        for (int i=a.size()-2;i>=0;i--){
            int c =1;
            while(!stack.isEmpty() && a.get(stack.peek())<=a.get(i)){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ret[i] =stack.peek()-i;
            }else {
                ret[i] = a.size()-i;
            }
            stack.push(i);
        }
        return ret;
    }

    private static int[] getLeftHighestIndexList(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[a.size()];
        ret[0] = 1;
        stack.push(0);
        for (int i=1;i<a.size();i++){
            int c =1;
            while(!stack.isEmpty() && a.get(stack.peek())<a.get(i)){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ret[i] =i-stack.peek();
            }else {
                ret[i] = i+1;
            }
            stack.push(i);
        }
        return ret;
    }

    private static HashMap<Integer,Integer> mp= new HashMap<Integer,Integer>();

    public static int getProductOfDivisors(int n) {
        if(mp.containsKey(n)){
            return mp.get(n);
        }
        if (n == 1) {
            return 1;
        }
        Long ret = 1L;int q = n;
        for (int i = 2; n > 1; i++) {
            int c = 0;
            while (n % i == 0) {
                c++;
                n = n / i;
            }
            ret = (ret * (c + 1))%b;
            //System.out.println(c);
        }
        int r=(int) (Math.pow(q, (double) ret / 2)%b);
        mp.put(q,r);
        return r;
    }
}
