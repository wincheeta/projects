import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }


    public static void main(String[] args) {
        Regex obj = new Regex();
        System.out.println(obj.isMatch("aa", "a"));
        System.out.println(obj.isMatch("aa", "a*"));
        System.out.println(obj.isMatch("ab", ".*"));
        System.out.println(obj.isMatch("abcd", "abcd"));
    }
}
