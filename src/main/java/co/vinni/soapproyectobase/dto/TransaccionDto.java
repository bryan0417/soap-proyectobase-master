package co.vinni.soapproyectobase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDto {
    //private Cuenta cuenta;
    private long valor;
    private String tipoTransaccion;
    //private Date fechaTransaccion;
    private long numeroTransaccion;
}
