package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.TransaccionDto;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.entidades.Transaccion;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import co.vinni.soapproyectobase.servicios.ServicioTransaccion;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
@Log4j2
public class ControladorTransaccion {
    private static final Logger logger = LogManager.getLogger(ControladorCuenta.class);

    @Autowired
    ServicioTransaccion servicioTransaccion;

    @PostMapping("/transaccion/nuevo")
    public String agregarTransaccion (@ModelAttribute("transaccion") TransaccionDto transaccion, long numeroCuenta) {
        servicioTransaccion.agregarTransaccion(transaccion,numeroCuenta);
        return "redirect:/transacciones";
    }

    @PostMapping("/transacciones/nuevo")
    public String agregarTransaccion (@ModelAttribute("transaccion") TransaccionDto transaccion, long numeroCuenta1, long numeroCuenta2) {
        servicioTransaccion.agregarTransaccion(transaccion,numeroCuenta1, numeroCuenta2);
        return "redirect:/transacciones";
    }

    @GetMapping("/transacciones")
    public String obtenerTransacciones(Model model) {
        logger.info("Verificando ");
        model.addAttribute("transacciones", servicioTransaccion.obtenerTransacciones());
        return "transacciones";
    }

}

