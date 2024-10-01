package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cuenta")
@Table(name = "CUENTAS")
public class Cuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUENTAS")
    @SequenceGenerator(name = "SEQ_CUENTAS", sequenceName = "SEQ_CUENTAS", allocationSize = 1)
    @Column(name = "CUENT_SEQ", nullable = false)
    private long secuencia;

    @Column(name = "CUENT_TIPODOCUMENTO", nullable = false)
    private String tipoCuenta;

    @Column(name = "CUENT_SALDO", nullable = false)
    private long saldo;

    @Column(name = "CUENT_NUMEROCUENTA", nullable = false)
    private long numeroCuenta;

    @ManyToOne
    @JoinColumn(name = "CLI_CEDULA")
    private Cliente cliente;
    
}
