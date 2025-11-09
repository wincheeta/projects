import java.util.ArrayList;

public class towers {


    public static ArrayList<String> solve(ArrayList<String> a) {
        for (String b : a) {
            System.out.println(b);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ArrayList<String> hanoi = new ArrayList<>();
        hanoi.add("8765431");
        hanoi.add("");
        hanoi.add("");
        ArrayList a = solve(hanoi);
    }
}
