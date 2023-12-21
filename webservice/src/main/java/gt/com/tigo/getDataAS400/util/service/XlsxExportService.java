package gt.com.tigo.getDataAS400.util.service;

import gt.com.tigo.getDataAS400.dto.DataTableRequestDto;
import gt.com.tigo.getDataAS400.util.exception.InvalidFilterException;
import gt.com.tigo.getDataAS400.util.exception.ResourcesNotFoundException;
import org.springframework.web.servlet.ModelAndView;

public interface XlsxExportService {

    ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException;

}
