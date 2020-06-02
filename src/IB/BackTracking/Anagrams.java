package IB.BackTracking;

import java.util.*;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Map<ArrayList<Integer>,ArrayList<Integer>> map = new LinkedHashMap<>();
        for(int i=0;i<A.size();i++){
            String str = A.get(i);
            ArrayList<Integer> ar = getCharCount(str);
            if(!map.containsKey(ar)){
                map.put(ar, new ArrayList<Integer>());
            }
            map.get(ar).add(i+1);
        }
        result = new ArrayList<>(map.values());
        return result;
    }

    private ArrayList<Integer> getCharCount(String str) {
        ArrayList<Integer> ar = new ArrayList<>(26);
        for(int i=0;i<26;i++){
            ar.add(0);
        }
        for(char ch:str.toCharArray()){
            ar.set(ch-'a', ar.get(ch-'a')+1);
        }
        return ar;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba");
        list.add("abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa");
        list.add("babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab");list.add("abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab");
        ArrayList<ArrayList<Integer>> arrayLists = new Anagrams().anagrams(list);
        for(List<Integer> list1:arrayLists){
            System.out.println(list1);
        }
        System.out.println(arrayLists.size());
    }
}
