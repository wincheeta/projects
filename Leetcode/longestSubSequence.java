public class longestSubSequence {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] M = new int[text1.length()+1][text2.length()+2];
            for (int i = 1; i <text1.length()+1; i++) {
                int a = i;
                for (int j = 1; j <text2.length()+1; j++) {
                    if (text1.charAt(a-1) == text2.charAt(j-1)) {
                        M[a][j] = Math.max(Math.max(M[a][j], M[a][j-1]+1),Math.max(M[a-1][j-1]+1,M[a-1][j]+1));
                        System.out.println(a+" "+j+" "+text1.charAt(a-1)+ " "+ M[a-1][j]);
                        if (a<text1.length()) {a++;}
                    } else {
                        M[a][j] = M[a][j] = Math.max(Math.max(M[a][j], M[a][j-1]),Math.max(M[a-1][j-1],M[a-1][j]));
                    }
                }

            }
            for (int i = 0; i <text1.length()+1; i++) {
                for (int j = 0; j <text2.length()+1; j++) {
                    System.out.print(M[i][j]);

                }
                System.out.println();
            }
            return M[text1.length()][text2.length()];
        }

    public static void main(String[] args) {
        longestSubSequence solution = new longestSubSequence();
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        System.out.println(solution.longestCommonSubsequence(text1,text2));
    }
}

