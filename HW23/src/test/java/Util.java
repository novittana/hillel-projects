public class Util {
    protected static int uniqId = 0;

    public static int getId() {
        return Util.uniqId++;
    }

    public static String getRandomPrefix(boolean respectPassRequirements) {
        String text = "";
        String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 5; i++) {
            text += possible.charAt((int) Math.floor(Math.random() * possible.length()));
        }
        return text + (respectPassRequirements ? "sS" + Util.getId() : "");
    }

}
