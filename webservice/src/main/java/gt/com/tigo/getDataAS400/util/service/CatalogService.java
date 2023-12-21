package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.dto.CatalogDto;
import gt.com.tigo.getDataAS400.util.exception.ResourcesNotFoundException;

import java.util.List;

public interface CatalogService<K, V> {

    List<CatalogDto<K,V>> getDefaultCatalog() throws ResourcesNotFoundException;

}
