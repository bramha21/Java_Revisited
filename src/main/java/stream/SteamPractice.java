package stream;

import java.beans.PropertyChangeListener;
import java.util.Observer;
import java.util.regex.Pattern;

public class SteamPractice {
    public static void main(String[] args) {
        removeWhiteSpacesFromString();
        addIntergersFromString();
    }

    private static void addIntergersFromString() {
        String input = "123456";
        System.out.println(input.chars().mapToObj(x -> (int)x).reduce(0, Integer::sum));
    }

    private static void removeWhiteSpacesFromString() {
        String s = "Hi, My name is Java";
        s.chars().filter(x -> x != 32).mapToObj(x -> (char) x).forEach(System.out::print);
        System.out.println();
        s.chars().filter(x -> x != ' ').mapToObj(x -> (char) x).forEach(System.out::print);
        System.out.println();
        s.chars().mapToObj(x -> (char) x).filter(x -> x != 32).forEach(System.out::print);
        System.out.println();
        s.chars().filter(x -> !Character.isWhitespace(x)).mapToObj(x -> (char) x).forEach(System.out::print);
        System.out.println("\n====================================================================");
    }

}
