import java.util.regex.*;

public class CapitalAfterLower {
    public static void main(String[] args) {
        System.out.println(one("Это типо какой-то вот тАкой текст для проверки работы кода"));
    }
    public static String one(String n) {
        String ret = "" ;
        try {
            String text = n;
            Pattern pattern = Pattern.compile("(?<=[а-я])([А-Я]||)");
            Matcher matcher = pattern.matcher(text);

            String result = matcher.replaceAll("!$0!");
            ret = result;
        }
        catch (Exception x){
            System.out.println("Ошибка" + x.getMessage() );
        }
        return ret ;
    }
}