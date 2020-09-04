package pl.sdacademy.sdatddadvanced.verifiers;

public class SurnameVerifier {

    public boolean isValid(final String surname) {
        return surname.length() >= 2;
    }
}
