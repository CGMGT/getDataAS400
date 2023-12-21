package gt.com.tigo.getDataAS400.model.as400;

import gt.com.tigo.getDataAS400.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class OrdenTrabajoEntity extends AbstractEntity {
    private String noOrdenTrabajo;
    private String tipoOrdenTrabajo;
    private String estado;
    private String nombreCliente;
    private String numeroDeSolicitud;
    private String telefonosContacto;
    private String direccionInstalacion;
    private String referenciaDireccion;
    private String nodo;
    private String codigoVendedor;
    private String codigoDeMotivo;
    private String signoNegativo;
    private String codigoDeCliente;
    private String localizacion;
    private String fechaEnvio;
    private String horaEnvio;
    private String colilla;
    private String hub;
    private String usuario;
    private String contador;
    private String causaBaja;
    private List<DetailEntity> detalle;

    @Id
    public String getNoOrdenTrabajo() {
        return noOrdenTrabajo;
    }

    public void setNoOrdenTrabajo(String noOrdenTrabajo) {
        this.noOrdenTrabajo = noOrdenTrabajo;
    }

    public String getTipoOrdenTrabajo() {
        return tipoOrdenTrabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipoOrdenTrabajo(String tipoOrdenTrabajo) {
        this.tipoOrdenTrabajo = tipoOrdenTrabajo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroDeSolicitud() {
        return numeroDeSolicitud;
    }

    public void setNumeroDeSolicitud(String numeroDeSolicitud) {
        this.numeroDeSolicitud = numeroDeSolicitud;
    }

    public String getTelefonosContacto() {
        return telefonosContacto;
    }

    public void setTelefonosContacto(String telefonosContacto) {
        this.telefonosContacto = telefonosContacto;
    }

    public String getDireccionInstalacion() {
        return direccionInstalacion;
    }

    public void setDireccionInstalacion(String direccionInstalacion) {
        this.direccionInstalacion = direccionInstalacion;
    }

    public String getReferenciaDireccion() {
        return referenciaDireccion;
    }

    public void setReferenciaDireccion(String referenciaDireccion) {
        this.referenciaDireccion = referenciaDireccion;
    }

    public String getNodo() {
        return nodo;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getCodigoDeMotivo() {
        return codigoDeMotivo;
    }

    public void setCodigoDeMotivo(String codigoDeMotivo) {
        this.codigoDeMotivo = codigoDeMotivo;
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

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(String horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public String getColilla() {
        return colilla;
    }

    public void setColilla(String colilla) {
        this.colilla = colilla;
    }

    public String getHub() {
        return hub;
    }

    public void setHub(String hub) {
        this.hub = hub;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }

    public String getCausaBaja() {
        return causaBaja;
    }

    public void setCausaBaja(String causaBaja) {
        this.causaBaja = causaBaja;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<DetailEntity> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetailEntity> detalle) {
        this.detalle = detalle;
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
