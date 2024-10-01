package co.vinni.soapproyectobase;

import co.vinni.soapproyectobase.controladores.ControladorCliente;
import co.vinni.soapproyectobase.controladores.ControladorCuenta;
import co.vinni.soapproyectobase.controladores.ControladorTransaccion;
import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.entidades.Transaccion;
//import co.vinni.soapproyectobase.gui.VPrincipal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import co.vinni.soapproyectobase.repositorios.RepositorioCliente;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioTransaccion;
import co.vinni.soapproyectobase.servicios.ServicioTransaccion;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Log4j2
@SpringBootApplication
public class SoapProyectobaseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SoapProyectobaseApplication.class, args);
        System.out.println("Proyecto base");
    }

    @Autowired
    RepositorioCliente repoCliente;

    @Autowired
    RepositorioCuenta repoCuenta;
    @Autowired
    RepositorioTransaccion repoTransaccion;

    //@Autowired
    //ControladorCliente controladorCliente;

    @Override
    public void run(String... arg) throws Exception {

        /*Cliente cliente = new Cliente();
        cliente.setCedula(1000287921);
        cliente.setNombre("Bryan");
        cliente.setApellido("Montes Gonzalez");
        cliente.setCorreo("gmail.com");
        cliente.setCelular(1234456789);
        cliente.setTipoDocumento("CC");


        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(1234567);
        cuenta.setTipoCuenta("Cuenta ahorros");
        cuenta.setSaldo(0);
        cuenta.setSecuencia(1);
        cuenta.setCliente(cliente);
        Cuenta cuenta2 = new Cuenta(2,"Cuenta corriente",0,123,cliente);
        List<Cuenta> cuentaList = new ArrayList<>();
        cuentaList.add(cuenta);
        cuentaList.add(cuenta2);

        cliente.setCuentas(cuentaList);

        repoCliente.save(cliente);

        repoCuenta.save(cuenta);

        Transaccion transaccion = new Transaccion();
        transaccion.setSecuencia(1);
        transaccion.setValor(500);
        transaccion.setTipoTransaccion("Retiro");
        transaccion.setNumeroTransaccion(1234567);

        repoTransaccion.save(transaccion);*/

        //List<ClienteDto> clientes = new ArrayList<>();
        //ControladorCliente cc = new ControladorCliente();
        //clientes = cc.consultarClientes();
        //System.out.println(clientes);

        //repoCliente.findAllClientes();


        //Cuenta cnt = new Cuenta(cl,"Cuenta ahorros",0,123456);

        //Cliente cl = new Cliente(1000287921,"Bryan","Montes","CC","bmontesg@ucentral.edu.co",318527928,);
        //Cliente cl1 = new Cliente(1023861049,"Yipsi","Diaz","CC","ydiazs@ucentral.edu.co",323456756);

        //repoCliente.save(cl);
        //repoCliente.save(cl1);





        /*Scanner leer = new Scanner(System.in);
        boolean bandera = true;

        while (bandera == true) {
            System.out.println("Menú");
            System.out.println("1. Agregar cuenta");
            System.out.println("2. Realizar transacciones");
            System.out.println("3. Visualizar datos cuenta");
            System.out.println("4. Salir");
            System.out.println("Digite el número (1-4):");
            int elegir = leer.nextInt();

            if (elegir == 1) {
                System.out.println("Ingresar Cliente: ");
                System.out.println("Nombre(s):");
                leer.nextLine();
                String nombre = leer.nextLine();
                System.out.println("Apellidos:");
                String apellido = leer.nextLine();
                System.out.println("Tipo Documento:");
                String tipoDocumento = leer.nextLine();
                System.out.println("Cedula:");
                long cedula = leer.nextLong();
                System.out.println("Correo:");
                String correo = leer.next();
                System.out.println("celular:");
                long celular = leer.nextLong();
                System.out.println("Tipo de Cuenta:");
                leer.nextLine();
                String tipoCuenta = leer.nextLine();

                Cliente cl0 = new Cliente(nombre,apellido,cedula,tipoDocumento,correo,celular);
                Cuenta cnt = new Cuenta(cl0,tipoCuenta,0,0);
                ControladorCuenta Ccu = new ControladorCuenta();
                Ccu.registrar(cnt);
            }
            if (elegir == 2) {
                System.out.println("Realizar transacción: ");
                System.out.println("1. Retiro");
                System.out.println("2. Consignar");
                System.out.println("3. Transferencia");
                System.out.println("4. Cancelar (Volver al menú)");
                System.out.println("Digite el número (1-4):");
                int elegir2 = leer.nextInt();
                if (elegir2 == 1) {
                    System.out.println("Digite el número de Cuenta:");
                    long numeroCuenta = leer.nextLong();
                    System.out.println("Cifra del retiro:");
                    long valor = leer.nextLong();
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    //String fechaFormateada = sdf.format(fechaActual);
                    Transaccion trs = new Transaccion(valor,"Retiro",0);
                    ControladorTransaccion Ct = new ControladorTransaccion();
                    Ct.agregarTransaccion(trs,numeroCuenta);
                    ServicioTransaccion xx = new ServicioTransaccion();
                    System.out.println(xx.listaTransacciones);
                }
                if (elegir2 == 2) {
                    System.out.println("Digite el número de Cuenta:");
                    long numeroCuenta = leer.nextLong();
                    System.out.println("Cifra de la consignación:");
                    long valor = leer.nextLong();
                    Transaccion trs = new Transaccion(valor,"Consignar",0);
                    ControladorTransaccion Ct = new ControladorTransaccion();
                    Ct.agregarTransaccion(trs,numeroCuenta);
                }
                if (elegir2 == 3) {
                    System.out.println("Digite el número de cuenta(Transferir dinero):");
                    long numeroCuenta1 = leer.nextLong();
                    System.out.println("Digite el número de Cuenta(Recibe dinero):");
                    long numeroCuenta2 = leer.nextLong();
                    System.out.println("Cifra de la transferencia:");
                    long valor = leer.nextLong();
                    Transaccion trs = new Transaccion(valor,"Transferir",0);
                    ControladorTransaccion Ct = new ControladorTransaccion();
                    Ct.agregarTransaccion(trs,numeroCuenta1, numeroCuenta2);
                }
            }
            if (elegir == 3) {
                System.out.println("Visualizar datos:");
                System.out.println("1. Todas las cuentas");
                System.out.println("2. Una cuenta en específico (Numero de cedula)");
                System.out.println("3. Todas las transferencias");
                int elegir3 = leer.nextInt();
                if (elegir3 == 1) {
                    ControladorCuenta cuenta = new ControladorCuenta();
                    List<Cuenta> listaCuenta = cuenta.consultarCuentas();
                    System.out.println("************************************************");
                    System.out.println("                     CUENTAS");
                    //System.out.println("Nombre    Apellidos    tipo documento    cédula    correo    celular    tipo cuenta    saldo    numero cuenta");
                    for (Cuenta mostrarCuentas : listaCuenta) {
                        //System.out.println(x.getCliente().getNombre()+"  "+x.getCliente().getApellido()+"   "+x.getCliente().getTipoDocumento()+"   "+x.getCliente().getCedula()+"   "+x.getCliente().getCorreo()+"   "+x.getCliente().getCelular()+"   "+x.getTipoCuenta()+"   "+x.getSaldo()+"   "+x.getNumeroCuenta());
                        System.out.println(mostrarCuentas);
                    }
                    System.out.println("************************************************");
                }
                if (elegir3 == 2) {
                    System.out.println("Digite el número de cedula:");
                    long cedula = leer.nextLong();
                    ControladorCuenta cuenta = new ControladorCuenta();
                    System.out.println("************************************************");
                    Cuenta mostrarCuenta = cuenta.consultarCuenta(cedula);
                    System.out.println(mostrarCuenta);
                    System.out.println("************************************************");
                }
                if (elegir3 == 3) {
                    ControladorTransaccion transaccion = new ControladorTransaccion();
                    List<Transaccion> listaTransaccio = transaccion.obtenerTransacciones();
                    System.out.println(listaTransaccio);
                }
            }
            if (elegir == 4) {
                bandera = false;
            }

        }







        //cliente.getNombre();
        //Cliente cl = new Cliente("Bryan","Montes",1000287921,"CC","bgmail.com",318527928);
        //UtilidadArchivos.guardar("datoCliente.txt", cl);
        //ControladorCliente Ccl = new ControladorCliente();
        //Ccl.registrar(cl);

        //Cliente Clien = (Cliente) UtilidadArchivos.obtener("datoCliente.txt");
        //Cliente x = Ccl.consultarCliente(1000287921);
        //System.out.println(x);



        //Cliente cl1 = new Cliente("X","M",1234567890,"CC","123gmail.com",318347928);
        //Cuenta cnt1 = new Cuenta(cl1,"Retiro",542541);

        //Cliente cl2 = new Cliente("Yipsi","Díaz",1023861049,"CC","ydiazsgmail.com",319385640);
        //Cuenta cnt2 = new Cuenta(cl2,"Retiro",542541);
        //UtilidadArchivos.guardar("datoCuenta.txt", cnt);

        //Ccu.registrar(cnt1);
        //Ccu.registrar(cnt2);


        //Cuenta Cuent = (Cuenta) UtilidadArchivos.obtener("datoCuenta.txt");
        //Cuenta y = Ccu.consultarCuenta(1000287921);
        //System.out.println(y);







        //SpringApplication.run(SoapProyectobaseApplication.class, args);
        //System.out.println("proyecto base");
//
        //Equipo equipo = new Equipo();
        //equipo.setSerial(1);
        //equipo.setNombre("millos");
        //equipo.setDescripción("De bogota");
//
        //ControladorEquipos controladorEquipos = new ControladorEquipos();
        //Equipo eleuipo = controladorEquipos.consultarEquipo();
        //System.out.println(eleuipo);
        //new VPrincipal().setVisible(true);
*/
    }

}
