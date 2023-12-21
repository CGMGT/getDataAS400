package gt.com.tigo.getDataAS400.model.as400;

import gt.com.tigo.getDataAS400.util.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ServiceEntity extends AbstractEntity {
    private String correlativo;
    private String tipoOrdenTrabajo;
    private String noOrdenTrabajo;
    private String codigoDeServicio;
    private String cantidadServicio;
    private String descripcionServicio;
    private String valorServicio;
    private String telefonoServicio;
    private String estadoServicio;

    @Id
    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getTipoOrdenTrabajo() {
        return tipoOrdenTrabajo;
    }

    public void setTipoOrdenTrabajo(String tipoOrdenTrabajo) {
        this.tipoOrdenTrabajo = tipoOrdenTrabajo;
    }

    public String getNoOrdenTrabajo() {
        return noOrdenTrabajo;
    }

    public void setNoOrdenTrabajo(String noOrdenTrabajo) {
        this.noOrdenTrabajo = noOrdenTrabajo;
    }

    public String getCodigoDeServicio() {
        return codigoDeServicio;
    }

    public void setCodigoDeServicio(String codigoDeServicio) {
        this.codigoDeServicio = codigoDeServicio;
    }

    public String getCantidadServicio() {
        return cantidadServicio;
    }

    public void setCantidadServicio(String cantidadServicio) {
        this.cantidadServicio = cantidadServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(String valorServicio) {
        this.valorServicio = valorServicio;
    }

    public String getTelefonoServicio() {
        return telefonoServicio;
    }

    public void setTelefonoServicio(String telefonoServicio) {
        this.telefonoServicio = telefonoServicio;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
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
