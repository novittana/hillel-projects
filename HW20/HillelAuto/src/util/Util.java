package util;

public class Util {
    protected static Integer id = 0;

    public static Integer getId() {
        return ++Util.id;
    }

    public static boolean isEmailValid(String email) {
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == "@".charAt(0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMilleageValid(Integer mileage) {
        if ((mileage >= 0) && (mileage <= 999999)) {
            return true;
        }
        return false;
    }
}

