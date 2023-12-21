package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.util.exception.RequesterNotFoundException;
import gt.com.tigo.getDataAS400.util.exception.ResourceUpdateException;

public interface UpdateService<T> {

    T update(T entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException;

}
