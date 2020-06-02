package IB.BackTracking;

import java.util.*;

public class SubsetsII {

    Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        result.add(subset);
        solve(0,A, result, subset);
        return result;
    }

    public void solve(int x,ArrayList<Integer> A,ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset){
        for(int i=x;i<A.size();i++){
            if(i!=x && A.get(i) == A.get(i-1)){
                continue;
            }
            subset.add(A.get(i));
            if(!set.contains(subset)){
                set.add(subset);
                result.add(new ArrayList<>(subset));
            }
            solve(i+1,A,result, subset);
            subset.remove(subset.size()-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);
        ArrayList<ArrayList<Integer>> arrayLists = new SubsetsII().subsetsWithDup(list);
        for(List<Integer> list1:arrayLists){
            System.out.println(list1);
        }
    }


}
