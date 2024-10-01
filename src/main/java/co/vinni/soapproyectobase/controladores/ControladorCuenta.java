package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.servicios.ServicioCliente;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
public class ControladorCuenta {

    private static final Logger logger = LogManager.getLogger(ControladorCuenta.class);

    @Autowired
    ServicioCuenta servicioCuenta;

    @Autowired
    ServicioCliente servicioCliente;

    /*@GetMapping("/cuentas")
    public String listarEquipos(Model model){
        logger.info("Verificando ");
        model.addAttribute("equipos",servicioEquipos.obtenerEquipos());
        return "equipos";
    }*/

    @GetMapping("/cuentas/nuevo")
    public String registrarCuenta (Model model) {
        CuentaDto cuentaDto = new CuentaDto();
        model.addAttribute("cuenta", cuentaDto);
        model.addAttribute("listaclientes",this.servicioCliente.obtenerClientes());
        return "crear_cuenta";
    }

    /*@PostMapping("/cuentas/nuevo")
    public String registrarCuenta (@ModelAttribute("cuentas") CuentaDto cuenta) {
        servicioCuenta.agregarCuenta(cuenta);
        return "redirect:/cuentas";
    }*/

    @GetMapping("/cuentas/consultar/{cedula}")
    public String consultarCuenta(@PathVariable long cedula, Model model) {
        logger.info("Verificando ");
        model.addAttribute("cuentas", servicioCuenta.obtenerCuenta(cedula));
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas")
    public String consultarCuentas(Model model) {
        logger.info("Verificando ");
        System.out.println("Hola");
        model.addAttribute("cuentas", servicioCuenta.obtenerCuentas());
        return "cuentas";
    }

    @PostMapping("/cuentas")
    public String mostrarCuentas (@ModelAttribute("cuenta") CuentaDto cuenta, RedirectAttributes alerta) {
        servicioCuenta.agregarCuenta(cuenta, alerta);
        return "redirect:/cuentas";
    }

}

