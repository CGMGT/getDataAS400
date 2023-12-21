package gt.com.tigo.getDataAS400.dao.as400;

import gt.com.tigo.getDataAS400.model.as400.OrdenTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AS400Repository extends JpaRepository<OrdenTrabajoEntity, Long> , JpaSpecificationExecutor<OrdenTrabajoEntity> {

    @Query(value = "SELECT PCNSOL\n" +
            " FROM QSTCDAT.J1PETCOM A\n" +
            " WHERE PCOTRA = ? " , nativeQuery = true)
    long getSolicitud(long ot);

    @Query(value = "    SELECT PCOTRA noOrdenTrabajo, TRIM(PCTRXL) tipoOrdenTrabajo, TRIM(PCDSTA) estado, TRIM(TCNCLI) nombreCliente, A.PCNSOL numeroDeSolicitud,\n" +
            "\t   TRIM(TCTELS) telefonosContacto, TRIM(B.PCDIRE) direccionInstalacion, TRIM(TCDEXI)referenciaDireccion,\n" +
            "       TRIM(PCCNOD) nodo, RIGHT('00' || PCCVEN,3) codigoVendedor, '000' codigoDeMotivo, CASE WHEN A.PCCCLI <0 THEN '-' ELSE '' END signoNegativo,\n" +
            "\t   ABS(A.PCCCLI) codigoDeCliente, CASE WHEN LENGTH(TRIM(B.THCLCZ)) >0 THEN TRIM(B.THCLCZ) ELSE '0' END localizacion, PCAZVI || RIGHT('0' || PCMEVI,2) || RIGHT('0' || PCDIVI, 2) fechaEnvio,\n" +
            "       PCHORI horaEnvio, TRIM(E.TCUSF5) colilla, TRIM(PCCHUB) hub, TRIM(PCUSGR) usuario, TRIM(E.TCCONT) contador, '' causaBaja\n" +
            "FROM QSTCDAT.J1PETCLI A\n" +
            " INNER JOIN QSTCDAT.J1PETCOM C ON A.PCNSOL = C.PCNSOL\n" +
            " INNER JOIN QSTCDAT.J1PETDET D ON A.PCNSOL = D.PCNSOL\n" +
            " INNER JOIN QSTCDAT.J1UBICLI B ON A.PCCCLI = B.PCCCLI AND D.PCNFOL = B.TCNFOL\n" +
            " INNER JOIN QSTCDAT.V1SERHHO E ON D.PCNFOL = E.TCNFOL\n" +
            " INNER JOIN QSTCDAT.J1ESTP01 F ON A.PCESPE = F.PCCSTA\n" +
            " WHERE D.PCCORR = 1\n" +
            "  AND C.PCOTRA = ?\n" +
            " FETCH FIRST 1 ROWS ONLY" , nativeQuery = true)
    OrdenTrabajoEntity getDatosWo(long workorder);

    @Query(value = "    SELECT TRIM(D.PCCORR) correlativoDetalle, TRIM(PCTRXL) tipoOrdenTrabajo, PCOTRA noOrdenTrabajo, A.PCNSOL numeroDeSolicitud,\n" +
            "\t   TRIM(D.PCTIPR) producto, TRIM(PTESN) serie, TRIM(PTNTAG) tag, CASE WHEN A.PCCCLI <0 THEN '-' ELSE '' END signoNegativo,\n" +
            "\t   ABS(A.PCCCLI) codigoDeCliente, TRIM(PCNFOL) anexoProducto, TRIM(PCNTEL) telefonoProducto, RIGHT('0000' || PCCOPL,5) planDeAnexo, \n" +
            "\t   TRIM(PLADES) descripcionPlan, TRIM(PLAVAL) valorPlan, '000000000' latitud, '000000000' longitud\n" +
            " FROM QSTCDAT.J1PETCLI A\n" +
            " INNER JOIN QSTCDAT.J1PETCOM C ON A.PCNSOL = C.PCNSOL\n" +
            " INNER JOIN QSTCDAT.J1PETDET D ON A.PCNSOL = D.PCNSOL\n" +
            " INNER JOIN QSTCDAT.J1TFITCE F ON D.PCNTEL = F.PTNTEL \n" +
            " INNER JOIN QSTCDAT.V1TCOPLA G ON D.PCCOPL = G.PLACOD \n" +
            " WHERE C.PCOTRA = ?\n" , nativeQuery = true)
    List<Object[]> getDetailWo(long workorder);




}
