package gt.com.tigo.getDataAS400.util.exception;

public class ResourceSaveException extends TigoException {

    private static final  String MESSAGE = "No se ha podido guardar el recurso.";

    public ResourceSaveException() {
        super(MESSAGE);
    }

    public ResourceSaveException(String message) {
        super(message);
    }

}
