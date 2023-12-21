package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.dto.DataTableRequestDto;
import gt.com.tigo.getDataAS400.util.exception.InvalidFilterException;

public interface CountService {

    Long count(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException;

}
