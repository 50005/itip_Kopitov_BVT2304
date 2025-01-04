import java.util.regex.*;

public class WordsStartingWith {
    public static void main(String[] args) {
        System.out.println(one("I wrote code that works. That's all I need."));
    }
    public static String one(String n) {
        String ret = "" ;
        try {
            String text = n;
            char startingLetter = 'w';

            Pattern pattern = Pattern.compile("\\b" + startingLetter + "\\w*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
        catch (Exception x){
            System.out.println("Ошибка" + x.getMessage() );
        }
        return ret ;
    }
}