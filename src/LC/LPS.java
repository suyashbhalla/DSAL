package LC;

public class LPS {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
    }

    public static String longestPalindrome(String s) {
        char ch1[] = s.toCharArray();

        boolean dp[][] = new boolean[s.length()][s.length()];

        int maxLength = -1,fi=0,fj=0;

        for(int i=0;i<s.length();i++){
            dp[i][i] = true;
            if(i+1<s.length() && ch1[i] == ch1[i+1]){
                dp[i][i+1] = true;
                if(maxLength<2){
                    maxLength = 2;
                    fi = i;
                    fj = i+1;
                }
            }
        }

        for(int i=s.length()-1;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                if(dp[i+1][j-1] && ch1[i] == ch1[j]){
                    dp[i][j] = true;
                    if(maxLength<j-i+1){
                        maxLength = j-i+1;
                        fi = i;
                        fj = j;
                    }
                }
            }
        }

        return s.substring(fi,fj+1);
     }
}
