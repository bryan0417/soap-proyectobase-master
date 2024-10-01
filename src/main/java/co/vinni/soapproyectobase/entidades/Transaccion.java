package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Transaccion")
@Table(name = "TRANSACCIONES")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRANSACCIONES")
    @SequenceGenerator(name = "SEQ_TRANSACCIONES", sequenceName = "SEQ_TRANSACCIONES", allocationSize = 1)
    //private Cuenta cuenta;
    @Column(name = "TRANS_SEQ", nullable = false)
    private long secuencia;

    @Column(name = "TRANS_VALOR", nullable = false)
    private long valor;

    @Column(name = "TRANS_TIPOTRANSACCION", nullable = false)
    private String tipoTransaccion;
    //private Date fechaTransaccion;

    @Column(name = "TRANS_NUMEROTRANSACCION", nullable = false)
    private long numeroTransaccion;

}
