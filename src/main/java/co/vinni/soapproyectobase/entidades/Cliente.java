package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cliente")
@Table(name = "CLIENTES")
public class Cliente implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@SequenceGenerator(name = "SEQ_CLIENTES", sequenceName = "SEQ_CLIENTES", allocationSize = 1)
    @Column(name = "CLI_CEDULA", nullable = false)
    private long cedula;
    //@Column(name = "CLI_SECUENCIA", nullable = false)
    //private long secuencia;

    @Column(name = "CLI_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "CLI_APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "CLI_TIPODOCUMENTO", nullable = false)
    private String tipoDocumento;

    @Column(name = "CLI_CORREO", nullable = false)
    private String correo;

    @Column(name = "CLI_CELULAR", nullable = false)
    private long celular;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;
    
}
