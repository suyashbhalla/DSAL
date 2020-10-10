package LC.challenge.june;

import java.util.*;

public class QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]==o1[0]?Integer.compare(o1[1],o2[1]):Integer.compare(o2[0],o1[0]);
            }
        });

        List<int[]> list = new ArrayList<>(people.length);
        for(int i[]:people){
            list.add(i[1], i);
        }

        for(int i=0;i<people.length;i++){
            people[i] = list.get(i);
        }

        return people;
    }

    public static void main(String[] args) {
        //int [][]people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int [][]people = {{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        new QueueReconstruction().reconstructQueue(people);
        for(int i[]:people){
            System.out.println(Arrays.toString(i));
        }
    }

}
