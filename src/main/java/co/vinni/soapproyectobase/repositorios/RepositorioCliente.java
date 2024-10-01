package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioCliente extends JpaRepository<Cliente,Long>, JpaSpecificationExecutor<Cliente> {
    //@Query( "SELECT e FROM Cliente")
    //List<Cliente> findAllClientes();

    //@Query( "SELECT e FROM Equipo e JOIN FETCH e.jugadores where e.serial = :serial  ")
    //List<Equipo> findEquipoAndEquiposJugadoresById(@Param( "serial") Long serial);

}
