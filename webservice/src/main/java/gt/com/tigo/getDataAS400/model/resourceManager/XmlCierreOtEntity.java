package gt.com.tigo.getDataAS400.model.resourceManager;

import gt.com.tigo.getDataAS400.util.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "XML_CIERRE_OT", schema = "", catalog = "")
public class XmlCierreOtEntity extends AbstractEntity {
    private Long id;
    private String xmlRequest;
    private String descripcion;
    private Timestamp fechaCreacion;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXmlRequest() {
        return xmlRequest;
    }

    public void setXmlRequest(String xmlRequest) {
        this.xmlRequest = xmlRequest;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public void setFechaCreacion(Timestamp fechaCreacion) {
        // is not implemented
    }

    @Override
    public void setUsuarioCreacion(String usuarioCreacion) {
        // is not implemented
    }

    @Override
    public void setFechaModificacion(Timestamp fechaModificacion) {
        // is not implemented
    }

    @Override
    public void setUsuarioModificacion(String usuarioModificacion) {
        // is not implemented
    }
}
