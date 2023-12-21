package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.dto.DataTableRequestDto;
import gt.com.tigo.getDataAS400.dto.PaginatedDataDto;
import gt.com.tigo.getDataAS400.util.exception.InvalidFilterException;
import gt.com.tigo.getDataAS400.util.exception.ResourcesNotFoundException;

public interface FindByPageService<T> {

    PaginatedDataDto<T> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException;

}
