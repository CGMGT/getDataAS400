package gt.com.tigo.getDataAS400.util.exception;

public class ResourceDeleteException extends TigoException {

    private static final  String MESSAGE = "No se ha podido eliminar el recurso.";

    public ResourceDeleteException() {
        super(MESSAGE);
    }

    public ResourceDeleteException(String message) {
        super(message);
    }

}
