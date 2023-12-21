package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.util.exception.ResourceNotFoundException;

public interface FindByIdService<T> {

    T findById(Long id) throws ResourceNotFoundException;

}
