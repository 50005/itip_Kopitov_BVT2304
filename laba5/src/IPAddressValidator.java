import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        System.out.println(one("88.5.55.35"));
    }
    public static String one(String n) {
        String ret = "" ;
        try {
            String ipAddress = n;
            Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.)){2}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

            if (pattern.matcher(ipAddress).matches()) {
                System.out.println("IP-адрес корректен");
            } else {
                System.out.println("IP-адрес некорректен");
            }
        }
        catch (Exception x){
            System.out.println("Ошибка" + x.getMessage() );
        }
        return ret ;
    }
}