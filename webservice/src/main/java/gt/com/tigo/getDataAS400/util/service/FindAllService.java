package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.util.exception.ResourcesNotFoundException;

import java.util.List;

public interface FindAllService<T> {

    List<T> findAll() throws ResourcesNotFoundException;

}
