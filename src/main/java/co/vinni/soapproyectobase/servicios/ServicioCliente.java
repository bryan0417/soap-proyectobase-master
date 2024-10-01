package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.repositorios.RepositorioCliente;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioCliente implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    RepositorioCliente repoCliente;

    public List listaCliente = new ArrayList<>();
    public void registrar (ClienteDto clienteDto) {
        repoCliente.save(modelMapper.map(clienteDto, Cliente.class));
    }
    public List<ClienteDto> obtenerClientes () {
        TypeToken<List<ClienteDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoCliente.findAll(), typeToken.getType());
    }
}
