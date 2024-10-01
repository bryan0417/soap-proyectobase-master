package co.vinni.soapproyectobase.servicios;


import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.dto.TransaccionDto;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.entidades.Transaccion;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioTransaccion;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class ServicioTransaccion implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    RepositorioTransaccion repoTransaccion;

    @Autowired
    ServicioCuenta serviCuenta;


    public void agregarTransaccion (TransaccionDto transaccionDto, long numeroTransaccion) {
        TypeToken<List<CuentaDto>> typeToken = new TypeToken<>() {};
        List<CuentaDto> cuentasDto = modelMapper.map(serviCuenta.repoCuenta.findAll(), typeToken.getType());
        for (CuentaDto x: cuentasDto) {
            if (transaccionDto.getTipoTransaccion().equals("Retiro")){
                Random rand = new Random();
                long numeroAleatorio = (long) (rand.nextDouble() * 900000000L) + 100000000L;
                transaccionDto.setNumeroTransaccion(numeroAleatorio);
                if (numeroTransaccion == x.getNumeroCuenta()) {
                    if (transaccionDto.getValor() <= x.getSaldo()) {
                        long nuevoSaldo = x.getSaldo()-transaccionDto.getValor();
                        x.setSaldo(nuevoSaldo);
                        System.out.println("RETIRO EXITOSO");
                        repoTransaccion.save(modelMapper.map(transaccionDto, Transaccion.class));
                    } /*else {
                        System.out.println("El monto es menor al valor que desea retirar");
                    }*/
                } /*else {
                    System.out.println("No se encuentra ese número de cuenta");
                }*/
            } else if (transaccionDto.getTipoTransaccion().equals("Consignar")) {
                Random rand = new Random();
                long numeroAleatorio = (long) (rand.nextDouble() * 900000000L) + 100000000L;
                transaccionDto.setNumeroTransaccion(numeroAleatorio);
                if (numeroTransaccion == x.getNumeroCuenta()) {
                    long nuevoSaldo = x.getSaldo()+transaccionDto.getValor();
                    x.setSaldo(nuevoSaldo);
                    System.out.println("CONSIGNACIÓN EXITOSA");
                    repoTransaccion.save(modelMapper.map(transaccionDto, Transaccion.class));
                }
            }

        }
    }

    public void agregarTransaccion (TransaccionDto transaccionDto, long numeroTransaccion1, long numeroTransaccion2) {
        TypeToken<List<CuentaDto>> typeToken = new TypeToken<>() {};
        List<CuentaDto> cuentasDto = modelMapper.map(serviCuenta.repoCuenta.findAll(), typeToken.getType());
        for (CuentaDto x: cuentasDto) {
            for (CuentaDto y: cuentasDto) {
                if (numeroTransaccion1 == x.getNumeroCuenta() && numeroTransaccion2 == y.getNumeroCuenta()) {
                    Random rand = new Random();
                    long numeroAleatorio = (long) (rand.nextDouble() * 900000000L) + 100000000L;
                    transaccionDto.setNumeroTransaccion(numeroAleatorio);
                    if (transaccionDto.getValor() <= x.getSaldo()); {
                        long nuevoSaldo1 = x.getSaldo()-transaccionDto.getValor();
                        x.setSaldo(nuevoSaldo1);
                        long nuevoSaldo2 = y.getSaldo()+transaccionDto.getValor();
                        y.setSaldo(nuevoSaldo2);
                        repoTransaccion.save(modelMapper.map(transaccionDto, Transaccion.class));
                    }
                }
            }

        }
    }

    public List<TransaccionDto> obtenerTransacciones () {
        TypeToken<List<TransaccionDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoTransaccion.findAll(), typeToken.getType());
    }
}

