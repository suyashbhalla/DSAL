package IB.BackTracking;

import java.sql.PreparedStatement;
import java.util.*;

public class CombinationSumII {
    Set<ArrayList<Integer>> set = new HashSet<>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<>();
        solve(a, subset, b, result,0);
        return result;
    }

    private void solve(ArrayList<Integer> a, ArrayList<Integer> subset, int b, ArrayList<ArrayList<Integer>> result, int index) {
        if(b == 0){
            if(!set.contains(subset)){
                result.add(subset);
                set.add(subset);
            }
            return;
        }

        for(int i=index;i<a.size();i++){
            int x = a.get(i);
            if(b<x){
                break;
            }
            subset.add(x);
            solve(a,new ArrayList<>(subset),b-x,result, i+1);
            subset.remove(subset.size()-1);
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);list.add(1);list.add(2);list.add(7);list.add(6);list.add(1);list.add(5);
        ArrayList<ArrayList<Integer>> arrayLists = new CombinationSumII().combinationSum(list, 1);
        for(List<Integer> list1:arrayLists){
            System.out.println(list1);
        }
    }
}
