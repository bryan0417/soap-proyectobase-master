package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.servicios.ServicioCliente;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Log4j2
public class ControladorCliente {
    private static final Logger logger = LogManager.getLogger(ControladorCliente.class);

    @Autowired
    ServicioCliente servicioCliente;

    @GetMapping("/clientes/nuevo")
    public String registrarCliente (Model model) {
        ClienteDto clienteDto = new ClienteDto();
        model.addAttribute("cliente", clienteDto);
        return "crear_cliente";
    }

    /*@PostMapping("/clientes/nuevo")
    public String registrarCliente (ClienteDto cliente) {
        servicioCliente.registrar(cliente);
        return "crear_cliente";
    }*/

    @GetMapping("/clientes")
    public String listarClientes (Model model) {
        logger.info("Verificando ");
        model.addAttribute("clientes", servicioCliente.obtenerClientes());
        return "clientes";
    }

    @PostMapping("/clientes")
    public String mostrarClienteGuardado (@ModelAttribute("cliente") ClienteDto cliente) {
        servicioCliente.registrar(cliente);
        return "redirect:/clientes";
    }


}
