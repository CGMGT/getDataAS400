package gt.com.tigo.getDataAS400.dao.resourceManager;

import gt.com.tigo.getDataAS400.model.resourceManager.XmlCierreOtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XmlCierreOtRepository extends JpaRepository<XmlCierreOtEntity, Long>, JpaSpecificationExecutor<XmlCierreOtEntity> {
}
