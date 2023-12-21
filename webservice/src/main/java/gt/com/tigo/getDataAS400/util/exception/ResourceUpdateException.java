package gt.com.tigo.getDataAS400.util.exception;

public class ResourceUpdateException extends TigoException {

    private static final  String MESSAGE = "No se ha podido actualizar el recurso.";

    public ResourceUpdateException() {
        super(MESSAGE);
    }

    public ResourceUpdateException(String message) {
        super(message);
    }

}
