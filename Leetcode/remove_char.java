public class remove_char {
    public String clearDigits(String s) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                System.out.println(str.toString() + " " + c);
                str.deleteCharAt(i);
                for (int j = i-1; j >=0 ; j--) {
                    char c1 = str.charAt(j);
                    if (Character.isAlphabetic(c1)) {
                        str.deleteCharAt(j);
                        break;
                    }

                }
                i-=2;
            }

        }
        return str.toString();
    }

    public static void main(String[] args) {
        remove_char r = new remove_char();
        //System.out.println(r.clearDigits("abcd"));
        System.out.println(r.clearDigits("cb34"));
    }
}
