package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioTransaccion extends JpaRepository<Transaccion,Long>, JpaSpecificationExecutor<Transaccion> {

}
