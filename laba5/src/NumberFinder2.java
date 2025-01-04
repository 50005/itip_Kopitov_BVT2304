import java.util.regex.*;

public class NumberFinder2 {
    public static void main(String[] args) {
        System.out.println(one("The price of the product is $19,99 and the discount is $-5.00"));
    }
    public static String one(String n) {
        String ret = "" ;
        try {
            String text = n;
            Pattern pattern = Pattern.compile("-?\\d+(\\.|,\\d+)?");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                ret = ret + " " + matcher.group() ;
            }
        }
        catch (Exception x){
            System.out.println("Ошибка" + x.getMessage() );
        }
        return ret ;
    }
}