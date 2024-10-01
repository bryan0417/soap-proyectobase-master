package co.vinni.soapproyectobase.dto;

import co.vinni.soapproyectobase.entidades.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CuentaDto {
    private long secuencia;
    private Cliente cliente;
    private String tipoCuenta;
    private long saldo;
    private long numeroCuenta;
}
