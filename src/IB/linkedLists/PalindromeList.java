package IB.linkedLists;

import java.util.List;

public class PalindromeList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        //head.next.next.next.next = new ListNode(1);
        System.out.println(lPalin(head));
    }

    public static int lPalin(ListNode A) {

        ListNode temp = null,temp1,head = A;
        int n = 0;
        while(A!=null){
            A = A.next;
            n++;
        }
        if(n<=1){
            return 1;
        }
        A = head;
        for(int i=0;i<n/2;i++){
            temp1=A.next;
            A.next = temp;
            temp = A;
            A = temp1;
        }
        if(n%2!=0){
            A=A.next;
        }
        while(temp!=null && A!=null){
            if(temp.val != A.val){
                return 0;
            }
            temp = temp.next;
            A = A.next;
        }
        return 1;
    }

}
