public class UserData {
    public static String DEFAULT_NAME = "Fabiani";
    public static String DEFAULT_EMAIL = "I.am.only.Mary@gmail.com";

    public static String WORKING_EMAIL = "I.am.only.Mary@gmail.com";
    public static String DEFAULT_PASSWORD = "798465132StInG";
    public static String SHORT_PASSWORD = "7984";

    public static String getNewRandomEmail() {
        return Math.random() + DEFAULT_EMAIL;
    }

}
