package IB.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {
    public int isValidSudoku(final List<String> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }

        List<HashSet<Character>> rowWise = new ArrayList<>();
        List<HashSet<Character>> colWise = new ArrayList<>();
        List<HashSet<Character>> blockWise = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            rowWise.add(new HashSet<Character>());
            colWise.add(new HashSet<Character>());
            blockWise.add(new HashSet<Character>());
        }

        for (int i = 0; i < A.size(); i++) {
            char ch[] = A.get(i).toCharArray();
            for (int j = 0; j < A.size(); j++) {
                if (ch[j] == '.') {
                    continue;
                }
                if (rowWise.get(i).contains(ch[j])) {
                    return 0;
                } else {
                    rowWise.get(i).add(ch[j]);
                }
                if (colWise.get(j).contains(ch[j])) {
                    return 0;
                } else {
                    colWise.get(j).add(ch[j]);
                }
                int block = getBlock(i, j);
                if (blockWise.get(block).contains(ch[j])) {
                    return 0;
                } else {
                    blockWise.get(block).add(ch[j]);
                }
            }
        }
        return 1;
    }

    private int getBlock(int i, int j) {
        if (i <= 2) {
            if (j <= 2) {
                return 0;
            } else if (j <= 5) {
                return 1;
            } else {
                return 2;
            }
        }
        if (i <= 5) {
            if (j <= 2) {
                return 3;
            } else if (j <= 5) {
                return 4;
            } else {
                return 5;
            }
        }
        if (j <= 2) {
            return 6;
        } else if (j <= 5) {
            return 7;
        } else {
            return 8;
        }
    }

    public static void main(String[] args) {
        String str[] = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        List<String> list = Arrays.asList(str);
        System.out.println(new ValidSudoku().isValidSudoku(list));
    }
}
