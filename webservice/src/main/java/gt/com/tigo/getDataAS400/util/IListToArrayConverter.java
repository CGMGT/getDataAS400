package gt.com.tigo.getDataAS400.util;

import java.util.List;

public interface IListToArrayConverter<T> {

    List<Object[]> toArray(List<T> list);

}
