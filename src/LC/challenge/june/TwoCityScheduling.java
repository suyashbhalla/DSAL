package LC.challenge.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwoCityScheduling {
    class Cost{
        int aCityCost;
        int bCityCost;
        int dif;

        public Cost(int aCityCost, int bCityCost) {
            this.aCityCost = aCityCost;
            this.bCityCost = bCityCost;
            this.dif = Math.abs(aCityCost - bCityCost);
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        List<Cost> list = new ArrayList<>();
        for(int i=0;i<costs.length;i++){
            list.add(new Cost(costs[i][0], costs[i][1]));
        }
        Collections.sort(list, new Comparator<Cost>() {
            @Override
            public int compare(Cost o1, Cost o2) {
                return Integer.compare(o2.dif, o1.dif);
            }
        });

        int aCount=0,bCount=0;
        int minCost = 0;
        for(Cost cost:list){
            if(cost.aCityCost<cost.bCityCost && aCount<list.size()/2){
                minCost+=cost.aCityCost;
                aCount++;
            }else if(bCount<list.size()/2){
                minCost+=cost.bCityCost;
                bCount++;
            }else {
                minCost+=cost.aCityCost;
                aCount++;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        //int costs[][]={{10,20},{30,200},{400,50},{30,20}};
        int costs[][]={{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println(new TwoCityScheduling().twoCitySchedCost(costs));
    }
}
