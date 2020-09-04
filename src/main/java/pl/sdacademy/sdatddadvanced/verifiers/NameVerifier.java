package pl.sdacademy.sdatddadvanced.verifiers;

public class NameVerifier {

    public boolean isNameValid(final String name) {
        return !name.isEmpty() && name.contains(" ");
    }
}
