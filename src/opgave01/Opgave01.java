package opgave01;

import opgave01.models.IntegerVault;

public class Opgave01 {
    public static void main(String[] args) {
        IntegerVault<Integer> integerVault = new IntegerVault<>(42, "My password");
        System.out.println(integerVault.getSecret("My password"));

        IntegerVault<String> stringVault = new IntegerVault<>("42 i tekst", "My password");
        System.out.println(stringVault.getSecret("My password"));
    }
}
