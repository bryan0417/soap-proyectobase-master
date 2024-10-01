package co.vinni.soapproyectobase.dto;

import co.vinni.soapproyectobase.entidades.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteDto implements Serializable {
    private long cedula;
    //private long secuencia;
    private String nombre;
    private String apellido;
    //private long cedula;
    private String tipoDocumento;
    private String correo;
    private long celular;
}
