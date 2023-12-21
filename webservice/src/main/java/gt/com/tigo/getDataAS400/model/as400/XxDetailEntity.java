package gt.com.tigo.getDataAS400.model.as400;

import gt.com.tigo.getDataAS400.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class XxDetailEntity extends AbstractEntity {
    private String correlativoDetalle;
    private String tipoOrdenTrabajo;
    private String noOrdenTrabajo;
    private String numeroDeSolicitud;
    private String producto;
    private String serie;
    private String tag;
    private String signoNegativo;
    private String codigoDeCliente;
    private String anexoProducto;
    private String telefonoProducto;
    private String planDeAnexo;
    private String descripcionPlan;
    private String valorPlan;
    private String latitud;
    private String longitud;

    @Id
    public String getCorrelativoDetalle() {
        return correlativoDetalle;
    }

    public void setCorrelativoDetalle(String correlativoDetalle) {
        this.correlativoDetalle = correlativoDetalle;
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

    public String getNumeroDeSolicitud() {
        return numeroDeSolicitud;
    }

    public void setNumeroDeSolicitud(String numeroDeSolicitud) {
        this.numeroDeSolicitud = numeroDeSolicitud;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSignoNegativo() {
        return signoNegativo;
    }

    public void setSignoNegativo(String signoNegativo) {
        this.signoNegativo = signoNegativo;
    }

    public String getCodigoDeCliente() {
        return codigoDeCliente;
    }

    public void setCodigoDeCliente(String codigoDeCliente) {
        this.codigoDeCliente = codigoDeCliente;
    }

    public String getAnexoProducto() {
        return anexoProducto;
    }

    public void setAnexoProducto(String anexoProducto) {
        this.anexoProducto = anexoProducto;
    }

    public String getTelefonoProducto() {
        return telefonoProducto;
    }

    public void setTelefonoProducto(String telefonoProducto) {
        this.telefonoProducto = telefonoProducto;
    }

    public String getPlanDeAnexo() {
        return planDeAnexo;
    }

    public void setPlanDeAnexo(String planDeAnexo) {
        this.planDeAnexo = planDeAnexo;
    }

    public String getDescripcionPlan() {
        return descripcionPlan;
    }

    public void setDescripcionPlan(String descripcionPlan) {
        this.descripcionPlan = descripcionPlan;
    }

    public String getValorPlan() {
        return valorPlan;
    }

    public void setValorPlan(String valorPlan) {
        this.valorPlan = valorPlan;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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
