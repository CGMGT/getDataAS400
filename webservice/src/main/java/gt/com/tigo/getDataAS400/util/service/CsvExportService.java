package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.dto.DataTableRequestDto;
import gt.com.tigo.getDataAS400.dto.ResourceDto;
import gt.com.tigo.getDataAS400.util.exception.InvalidFilterException;
import gt.com.tigo.getDataAS400.util.exception.ResourcesNotFoundException;

import java.io.IOException;

public interface CsvExportService {

    ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException;

}
