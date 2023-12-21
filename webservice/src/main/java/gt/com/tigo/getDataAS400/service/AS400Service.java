package gt.com.tigo.getDataAS400.service;

import gt.com.tigo.getDataAS400.dao.as400.AS400Repository;
import gt.com.tigo.getDataAS400.dto.DataTableRequestDto;
import gt.com.tigo.getDataAS400.dto.PaginatedDataDto;
import gt.com.tigo.getDataAS400.dto.ResourceDto;
import gt.com.tigo.getDataAS400.model.as400.*;
import gt.com.tigo.getDataAS400.util.exception.*;
import gt.com.tigo.getDataAS400.util.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AS400Service extends AbstractService<OrdenTrabajoEntity, AS400Repository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AS400Service.class);
    private  String HEADER = "        <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.triggercierreots.tel.bytesw.com/\">\n" +
            "           <soapenv:Header/>\n" +
            "           <soapenv:Body>\n" +
            "              <ws:triggerCierreOts>\n" +
            "                 <TriggerCierreOts>\n" +
            "                    <tipoOrdenTrabajo>:tipoOrdenTrabajo</tipoOrdenTrabajo>\n" +
            "                    <tipoDeTrx>H</tipoDeTrx>\n" +
            "                    <noOrdenTrabajo>:noOrdenTrabajo</noOrdenTrabajo>\n" +
            "                    <codigoRuta/>\n" +
            "                    <nombreCliente>:nombreCliente</nombreCliente>\n" +
            "                    <numeroDeSolicitud>:numeroDeSolicitud</numeroDeSolicitud>\n" +
            "                    <telefonosContacto>:telefonosContacto</telefonosContacto>\n" +
            "                    <direccionInstalacion>:direccionInstalacion</direccionInstalacion>\n" +
            "                    <referenciaDireccion>:referenciaDireccion</referenciaDireccion>\n" +
            "                    <nodo>:nodo</nodo>\n" +
            "                    <placa/>\n" +
            "                    <puerto/>\n" +
            "                    <codigoVendedor>:codigoVendedor</codigoVendedor>\n" +
            "                    <direccionComplemento1/>\n" +
            "                    <direccionComplemento2/>\n" +
            "                    <referenciaDireccion2/>\n" +
            "                    <nodo2/>\n" +
            "                    <placa2/>\n" +
            "                    <puerto2/>\n" +
            "                    <estadoOt>:estadoOt</estadoOt>\n" +
            "                    <codigoDeMotivo>:codigoDeMotivo</codigoDeMotivo>\n" +
            "                    <signoNegativo>:signoNegativo</signoNegativo>\n" +
            "                    <codigoDeCliente>:codigoDeCliente</codigoDeCliente>\n" +
            "                    <localizacion>:localizacion</localizacion>\n" +
            "                    <valorDe3>201</valorDe3>\n" +
            "                    <fechaEnvio>:fechaEnvio</fechaEnvio>\n" +
            "                    <horaEnvio>:horaEnvio</horaEnvio>\n" +
            "                    <colilla>:colilla</colilla>\n" +
            "                    <hub/>\n" +
            "                    <usuario>:usuario</usuario>\n" +
            "                    <contador>:contador</contador>\n" +
            "                    <causaBaja>:causaBaja</causaBaja>\n" +
            "                    <noTvCortesia/>\n" +
            "                    <noTvCobro/>\n" +
            "                    <telefono01/>\n" +
            "                    <estadoTelefono01/>\n" +
            "                    <telefono02/>\n" +
            "                    <estadoTelefono02/>\n" +
            "                    <telefono03/>\n" +
            "                    <estadoTelefono03/>\n" +
            "                    <telefono04/>\n" +
            "                    <estadoTelefono04/>\n" +
            "                    <telefono05/>\n" +
            "                    <estadoTelefono05/>\n" +
            "                    <telefono06/>\n" +
            "                    <estadoTelefono06/>\n" +
            "                    <telefono07/>\n" +
            "                    <estadoTelefono07/>\n" +
            "                    <telefono08/>\n" +
            "                    <estadoTelefono08/>\n" +
            "                    <telefono09/>\n" +
            "                    <estadoTelefono09/>\n" +
            "                    <telefono10/>\n" +
            "                    <estadoTelefono10/>\n" +
            "                    :detalles\n" +
            "                 </TriggerCierreOts>\n" +
            "              </ws:triggerCierreOts>\n" +
            "           </soapenv:Body>\n" +
            "        </soapenv:Envelope>";

    private  String DETAIL = "<detalles>\n" +
            "                       <tipoOrdenTrabajo>:tipoOrdenTrabajo</tipoOrdenTrabajo>\n" +
            "                       <tipoDeTrx>D</tipoDeTrx>\n" +
            "                       <noOrdenTrabajo>:noOrdenTrabajo</noOrdenTrabajo>\n" +
            "                       <correlativoDetalle>:correlativoDetalle</correlativoDetalle>\n" +
            "                       <numeroDeSolicitud>:numeroDeSolicitud</numeroDeSolicitud>\n" +
            "                       <producto>:producto</producto>\n" +
            "                       <serie>:serie</serie>\n" +
            "                       <tag>:tag</tag>\n" +
            "                       <imeiIcc/>\n" +
            "                       <blanco/>\n" +
            "                       <estadoOt>:estadoOt</estadoOt>\n" +
            "                       <signoNegativo>:signoNegativo</signoNegativo>\n" +
            "                       <codigoDeCliente>:codigoDeCliente</codigoDeCliente>\n" +
            "                       <anexoProducto>:anexoProducto</anexoProducto>\n" +
            "                       <telefonoProducto>:telefonoProducto</telefonoProducto>\n" +
            "                       <planDeAnexo>:planDeAnexo</planDeAnexo>\n" +
            "                       <descripcionPlan>:descripcionPlan</descripcionPlan>\n" +
            "                       <valorPlan>:valorPlan</valorPlan>\n" +
            "                       <tipoAccion>C</tipoAccion>\n" +
            "                       <codigo201>201</codigo201>\n" +
            "                       <latitud>:latitud</latitud>\n" +
            "                       <longitud>:longitud</longitud>\n" +
            "                    </detalles>";




    public OrdenTrabajoEntity findWoById(Long id) throws ResourceNotFoundException {
        LOGGER.debug(String.format("@%s::findById(%d)", this.getClass().getName(), id));


        List<Object[]> detalle = this.repository.getDetailWo(id);
        List<DetailEntity> detail = new ArrayList<>();
        for (Object[] entity : detalle){
            DetailEntity woDetail = new DetailEntity();
            woDetail.setAnexoProducto(entity[9].toString());
            woDetail.setCorrelativoDetalle(entity[0].toString());
            woDetail.setDescripcionPlan(entity[12].toString());
            woDetail.setNoOrdenTrabajo(entity[2].toString());
            woDetail.setSerie(entity[5].toString());
            woDetail.setTag(entity[6].toString());
            woDetail.setValorPlan(entity[13].toString());
            woDetail.setCodigoDeCliente(entity[8].toString());
            woDetail.setProducto(entity[4].toString());
            woDetail.setLatitud(entity[14].toString());
            woDetail.setLongitud(entity[15].toString());
            woDetail.setTelefonoProducto(entity[10].toString());
            woDetail.setTipoOrdenTrabajo(entity[1].toString());
            woDetail.setNumeroDeSolicitud(entity[3].toString());
            woDetail.setSignoNegativo(entity[7].toString());
            woDetail.setPlanDeAnexo(entity[11].toString());
            detail.add(woDetail);
        }




        OrdenTrabajoEntity entidad = this.repository.getDatosWo(id);

        entidad.setDetalle(detail);

        if (entidad == null) {
            throw new ResourceNotFoundException();
        }

        return entidad;
    }



    public String getXmlCloseWo(Long id) throws ResourceNotFoundException {
        LOGGER.debug(String.format("@%s::getXmlCloseWo(%d)", this.getClass().getName(), id));

        StringBuilder sbRequest = new StringBuilder();
        StringBuilder sbDetail = new StringBuilder();
        String xmlHeader = HEADER;


        List<Object[]> detalle = this.repository.getDetailWo(id);

        for (Object[] entity : detalle){

            String xmlDetail = DETAIL;

            xmlDetail = xmlDetail.replace(":anexoProducto",entity[9].toString());

            xmlDetail = xmlDetail.replace(":correlativoDetalle",entity[0].toString());

            xmlDetail = xmlDetail.replace(":descripcionPlan",entity[12].toString());

            xmlDetail = xmlDetail.replace(":noOrdenTrabajo",entity[2].toString());

            xmlDetail = xmlDetail.replace(":serie",entity[5].toString());

            xmlDetail = xmlDetail.replace(":tag",entity[6].toString());

            xmlDetail = xmlDetail.replace(":valorPlan",entity[13].toString());

            xmlDetail = xmlDetail.replace(":codigoDeCliente",entity[8].toString());

            xmlDetail = xmlDetail.replace(":producto",entity[4].toString());

            xmlDetail = xmlDetail.replace(":latitud",entity[14].toString());

            xmlDetail = xmlDetail.replace(":longitud",entity[15].toString());

            xmlDetail = xmlDetail.replace(":telefonoProducto",entity[10].toString());

            xmlDetail = xmlDetail.replace(":tipoOrdenTrabajo",entity[1].toString());

            xmlDetail = xmlDetail.replace(":numeroDeSolicitud",entity[3].toString());

            xmlDetail = xmlDetail.replace(":signoNegativo",entity[7].toString());

            xmlDetail = xmlDetail.replace(":planDeAnexo",entity[11].toString());

            xmlDetail = xmlDetail.replace("\n","");
            xmlDetail = xmlDetail.replace("\\","");
            sbDetail.append(xmlDetail);
        }



        // setting data wo
        OrdenTrabajoEntity entidad = this.repository.getDatosWo(id);
        xmlHeader = xmlHeader.replace(":causaBaja", entidad.getCausaBaja());
        xmlHeader = xmlHeader.replace(":codigoDeCliente", entidad.getCodigoDeCliente());
        xmlHeader = xmlHeader.replace(":colilla", entidad.getColilla());
        xmlHeader = xmlHeader.replace(":fechaEnvio", entidad.getFechaEnvio());
        xmlHeader = xmlHeader.replace(":horaEnvio", entidad.getHoraEnvio());
        xmlHeader = xmlHeader.replace(":codigoDeMotivo", entidad.getCodigoDeMotivo());
        xmlHeader = xmlHeader.replace(":codigoVendedor", entidad.getCodigoVendedor());
        xmlHeader = xmlHeader.replace(":contador", entidad.getContador());
        xmlHeader = xmlHeader.replace(":direccionInstalacion", entidad.getDireccionInstalacion());
        xmlHeader = xmlHeader.replace(":hub", entidad.getHub());
        xmlHeader = xmlHeader.replace(":localizacion", entidad.getLocalizacion());
        xmlHeader = xmlHeader.replace(":nodo", entidad.getNodo());
        xmlHeader = xmlHeader.replace(":noOrdenTrabajo", entidad.getNoOrdenTrabajo());
        xmlHeader = xmlHeader.replace(":numeroDeSolicitud", entidad.getNumeroDeSolicitud());
        xmlHeader = xmlHeader.replace(":referenciaDireccion", entidad.getReferenciaDireccion());
        xmlHeader = xmlHeader.replace(":nombreCliente", entidad.getNombreCliente());
        xmlHeader = xmlHeader.replace(":signoNegativo", entidad.getSignoNegativo());
        xmlHeader = xmlHeader.replace(":tipoOrdenTrabajo", entidad.getTipoOrdenTrabajo());
        xmlHeader = xmlHeader.replace(":telefonosContacto", entidad.getTelefonosContacto());
        xmlHeader = xmlHeader.replace(":usuario", entidad.getUsuario());
        xmlHeader = xmlHeader.replace("\n","");
        xmlHeader = xmlHeader.replace("\\","");



        sbRequest.append(xmlHeader);
        sbRequest.replace(sbRequest.indexOf(":detalles"), sbRequest.indexOf(":detalles") + 9,sbDetail.toString());

        if (sbRequest == null) {
            throw new ResourceNotFoundException();
        }

        return sbRequest.toString();
    }

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        return null;
    }

    @Override
    public OrdenTrabajoEntity create(OrdenTrabajoEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public OrdenTrabajoEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<OrdenTrabajoEntity> findAll() throws ResourcesNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<OrdenTrabajoEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public OrdenTrabajoEntity update(OrdenTrabajoEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public OrdenTrabajoEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }
}
