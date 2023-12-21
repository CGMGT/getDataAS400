package gt.com.tigo.getDataAS400.security;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorized {
}
