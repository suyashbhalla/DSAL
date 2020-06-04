package LC.challenge.june;

public class ReverseString {

    public void reverseString(char[] s) {
        int i=0,j=s.length-1;
        char t;
        while(i<j){
            t= s[i];
            s[i]=s[j];
            s[j]=t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char ch[]= "HEL".toCharArray();
        new ReverseString().reverseString(ch);
        System.out.println(new String(ch));
    }
}
