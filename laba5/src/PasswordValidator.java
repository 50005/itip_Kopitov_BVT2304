import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        System.out.println(one("Password123"));
    }
    public static String one(String n) {
        String ret = "" ;
        try {
            String password = n;
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");

            if (pattern.matcher(password).matches()) {
                System.out.println("Пароль корректен");
            } else {
                System.out.println("Пароль некорректен");
            }
        }
        catch (Exception x){
            System.out.println("Ошибка" + x.getMessage() );
        }
        return ret ;
    }
}