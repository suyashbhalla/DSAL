import java.util.*;

public class HotelPossible {

    static class InOutTime{
        public Integer day;
        public String type;

        public InOutTime(Integer day, String type) {
            this.day = day;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        /*int a[] = { 13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8};
        int b[] = {28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53 };*/
        /*int a[] = { 9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27};
        int b[] = {32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38  };*/
        int a[] = { 40,18};
        int b[] = {40,43  };
        ArrayList<Integer> arrive = new ArrayList<Integer>();//{{add(5);add(3);add(1);}};
        ArrayList<Integer> depart = new ArrayList<Integer>();//{{add(8);add(6);add(2);}};

        for(int i=0;i<a.length;i++){
            arrive.add(a[i]);
        }

        for(int i=0;i<b.length;i++){
            depart.add(b[i]);
        }

        System.out.println(hotel(arrive,depart, 1));
    }

    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        List<InOutTime> list = new ArrayList<>();

        for(int i=0;i<arrive.size();i++){
           list.add(new InOutTime(arrive.get(i), "start"));
           list.add(new InOutTime(depart.get(i), "end"));
        }

        Collections.sort(list, new Comparator<InOutTime>() {
            @Override
            public int compare(InOutTime o1, InOutTime o2) {
                if(o1.day == o2.day && !o1.type.equals(o2.type)){
                    if(o1.type.equals("start")){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                return o1.day.compareTo(o2.day);
            }
        });

        int activeGuest = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).type.equals("start")){
                activeGuest++;
            }else{
                activeGuest--;
            }
            if(activeGuest>K){
                return false;
            }
        }
        //System.out.println(roomRequired);
        return true;
    }


}
