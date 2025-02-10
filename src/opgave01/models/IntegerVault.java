package opgave01.models;

public class IntegerVault<T> {
    private T secret;
    private String password;

    public IntegerVault(T secret, String password) {
        this.secret = secret;
        this.password = password;
    }


    public T getSecret(String password) {
        if (this.password.equals(password)) {
            return secret;
        }
        else {
            throw new IllegalArgumentException("Wrong password");
        }
    }
}
