package co.vinni.soapproyectobase.servicios;


import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCliente;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class ServicioCuenta implements Serializable {

    private final ModelMapper modelMapper;

    @Autowired
    RepositorioCuenta repoCuenta;

    public void agregarCuenta(CuentaDto cuentaDto, RedirectAttributes alerta) {
        boolean bandera = true;
        Random rand = new Random();
        long numeroAleatorio = (long) (rand.nextDouble() * 900000000L) + 100000000L;
        TypeToken<List<CuentaDto>> typeToken = new TypeToken<>() {};
        List<CuentaDto> cuentasDto = modelMapper.map(repoCuenta.findAll(), typeToken.getType());
        for (CuentaDto x: cuentasDto) {
            if (x.getCliente().getCedula() == cuentaDto.getCliente().getCedula()) {
                alerta.addFlashAttribute("warning", "Ya existe la cuenta!");
                System.out.println("Ya existe la cuenta");
                bandera = false;
                break;
            }
        }
        while (bandera == true) {
            cuentaDto.setNumeroCuenta(numeroAleatorio);
            repoCuenta.save(modelMapper.map(cuentaDto, Cuenta.class));
            System.out.println("CUENTA AGREGADA");
            bandera = false;
        }
    }

    public CuentaDto obtenerCuenta(long cedula) {
        Optional<Cuenta> optional = this.repoCuenta.findById(cedula);
        if (optional.isPresent()) {
            Cuenta lacuenta = optional.get();
            CuentaDto lacuentaDto = modelMapper.map(lacuenta,CuentaDto.class);
            return lacuentaDto;
        }

        return null;
    }

    public List<CuentaDto> obtenerCuentas() {
        TypeToken<List<CuentaDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoCuenta.findAll(), typeToken.getType());
    }
}

