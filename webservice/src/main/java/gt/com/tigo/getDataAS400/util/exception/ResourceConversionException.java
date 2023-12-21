package gt.com.tigo.getDataAS400.util.exception;

public class ResourceConversionException extends TigoException {

    private static final String MESSAGE = "Error al convertir el recurso.";

    public ResourceConversionException() {
        super(MESSAGE);
    }

    public ResourceConversionException(String message) {
        super(message);
    }

}
