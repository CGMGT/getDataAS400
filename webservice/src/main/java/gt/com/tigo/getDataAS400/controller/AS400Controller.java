package gt.com.tigo.getDataAS400.controller;

import gt.com.tigo.getDataAS400.dto.DataTableRequestDto;
import gt.com.tigo.getDataAS400.dto.TigoResponseDto;
import gt.com.tigo.getDataAS400.model.as400.OrdenTrabajoEntity;
import gt.com.tigo.getDataAS400.service.AS400Service;
import gt.com.tigo.getDataAS400.util.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@CrossOrigin
@RestController
@RequestMapping("/work-order")
public class AS400Controller extends AbstractController<OrdenTrabajoEntity, AS400Service>{
    private static final Logger LOGGER = LoggerFactory.getLogger(AS400Controller.class);



    @Override
    public ResponseEntity<TigoResponseDto> findAll() {
        return null;
    }

    @GetMapping("/findById/{woNum}")
    public ResponseEntity findById(@PathVariable(required = true)  Long woNum) {
        LOGGER.debug(String.format("@%s::findById(%s)", this.getClass().getName(), woNum));

        try {
            return ResponseEntity.ok(new TigoResponseDto(super.service.findWoById(woNum)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @GetMapping("/findDetailById/{woNum}")
    public ResponseEntity findDetailById(@PathVariable(required = true)  Long woNum) {
        LOGGER.debug(String.format("@%s::findDetailById(%s)", this.getClass().getName(), woNum));

        try {
            return ResponseEntity.ok(new TigoResponseDto(super.service.findWoById(woNum)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @GetMapping("/GetCloseWoXmlRequest/{woNum}")
    public ResponseEntity GetCloseWoXmlRequest(@PathVariable(required = true)  Long woNum) {
        LOGGER.debug(String.format("@%s::GetCloseWoXmlRequest(%s)", this.getClass().getName(), woNum));

        try {
            return ResponseEntity.ok(new TigoResponseDto(super.service.getXmlCloseWo(woNum)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @GetMapping("/GetXmlRequest4Close/{woNum}")
    public ResponseEntity GetXmlRequest4Close(@PathVariable(required = true)  Long woNum) {
        LOGGER.debug(String.format("@%s::GetXmlRequest4Close(%s)", this.getClass().getName(), woNum));

        try {
            return ResponseEntity.ok(super.service.getXmlCloseWo(woNum));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<TigoResponseDto> findByPage(DataTableRequestDto dataTableRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> create(OrdenTrabajoEntity entity, Long requesterId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> update(OrdenTrabajoEntity entity, Long requesterId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> deleteById(Long entityId, Long requesterId) {
        return null;
    }

    @Override
    public ModelAndView exportToXlsx(DataTableRequestDto dataTableRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<ByteArrayResource> exportToCsv(DataTableRequestDto dataTableRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> count(DataTableRequestDto dataTableRequestDto) {
        return null;
    }
}
