package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.util.exception.RequesterNotFoundException;
import gt.com.tigo.getDataAS400.util.exception.ResourceCreateException;

public interface CreateService<T> {

    T create(T entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException;

}
