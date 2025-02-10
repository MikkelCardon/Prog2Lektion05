package opgave01.models;

public class IntegerVault {
    private Integer secret;
    private String password;

    public IntegerVault(Integer secret, String password) {
        this.secret = secret;
        this.password = password;
    }


    public Integer getSecret(String password) {
        if (this.password.equals(password)) {
            return secret;
        }
        else {
            throw new IllegalArgumentException("Wrong password");
        }
    }
}
