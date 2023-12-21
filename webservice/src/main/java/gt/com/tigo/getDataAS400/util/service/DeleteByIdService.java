package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.util.exception.RequesterNotFoundException;
import gt.com.tigo.getDataAS400.util.exception.ResourceDeleteException;
import gt.com.tigo.getDataAS400.util.exception.ResourceNotFoundException;
import gt.com.tigo.getDataAS400.util.exception.ResourceUpdateException;

public interface DeleteByIdService<T> {

    boolean deleteById(Long entityId) throws ResourceDeleteException;

    T deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException;

}
