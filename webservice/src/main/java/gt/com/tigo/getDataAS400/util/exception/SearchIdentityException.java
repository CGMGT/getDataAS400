package gt.com.tigo.getDataAS400.util.exception;

public class SearchIdentityException extends Exception {

    private static final String MESSAGE = "Error al recuperar la información del usuario.";

    public SearchIdentityException() {
        super(MESSAGE);
    }

    public SearchIdentityException(String message) {
        super(message);
    }

}
