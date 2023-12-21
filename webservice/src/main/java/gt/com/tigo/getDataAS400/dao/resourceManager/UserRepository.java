package gt.com.tigo.getDataAS400.dao.resourceManager;

import gt.com.tigo.getDataAS400.model.resourceManager.AdmUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AdmUsuarioEntity, Long>, JpaSpecificationExecutor<AdmUsuarioEntity> {

    AdmUsuarioEntity findByUuid(String uuid);

    AdmUsuarioEntity findByCorreoElectronico(String correoElectronico);

}
