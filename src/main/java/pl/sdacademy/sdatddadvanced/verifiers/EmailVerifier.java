package pl.sdacademy.sdatddadvanced.verifiers;

public class EmailVerifier {

    public boolean isEmailValid(final String email) {
        return email.contains("@") && email.length() > 4;
    }
}
