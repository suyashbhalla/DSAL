package IB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

    HashSet<ArrayList<Integer>> set = new HashSet<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A.size()==1){
            result.add(A);
            return result;
        }
        solve(A, result);
        return result;
    }

    public void solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result){
        for(int i=0;i<A.size()-1;i++){
            swap(A, i,i+1);
            if(!set.contains(A)){
                set.add(new ArrayList<>(A));
                result.add(new ArrayList<>(A));
                solve(new ArrayList<>(A), result);
            }
        }
    }



    public void swap(ArrayList<Integer> subset, int i, int j){
        int x= subset.get(i);
        subset.set(i, subset.get(j));
        subset.set(j, x);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);
        ArrayList<ArrayList<Integer>> arrayLists = new Permutations().permute(list);
        for(List<Integer> list1:arrayLists){
            System.out.println(list1);
        }
        System.out.println(arrayLists.size());
    }
}
