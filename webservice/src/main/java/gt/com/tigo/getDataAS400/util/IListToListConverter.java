package gt.com.tigo.getDataAS400.util;

import java.util.List;

public interface IListToListConverter<T> {

    List<List<String>> toList(List<T> list);

}
