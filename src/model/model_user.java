package model;

public class model_user {
    private static String email;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        model_user.email = email;
    }

    public static void clearSession() {
        email = null;
    }
}
