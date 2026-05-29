import java.util.Scanner;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SIFRAH {

    static double carritoTotal = 0;
    static String nombreCliente;
    static String apellidosCliente;
    static String dniCliente;
    static String telefonoCliente;
    static String sucursalElegida;
    //static String productosComprados = "";
    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        // ROSADO
        System.out.println("\u001B[95m");

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                                                      ║");
        System.out.println("║   ███████╗██╗███████╗██████╗  █████╗ ██╗  ██╗        ║");
        System.out.println("║   ██╔════╝██║██╔════╝██╔══██╗██╔══██╗██║  ██║        ║");
        System.out.println("║   ███████╗██║█████╗  ██████╔╝███████║███████║        ║");
        System.out.println("║   ╚════██║██║██╔══╝  ██╔══██╗██╔══██║██╔══██║        ║");
        System.out.println("║   ███████║██║██║     ██║  ██║██║  ██║██║  ██║        ║");
        System.out.println("║   ╚══════╝╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝        ║");
        System.out.println("║                                                      ║");

        System.out.println("\u001B[35m");

        System.out.println("║         ✨ ✨ ✨ TIENDA OFICIAL ✨ ✨ ✨            ║");
        System.out.println("║                                                      ║");

        System.out.println("\u001B[96m");

        System.out.println("║        💎 Moda • Belleza • Accesorios 💎             ║");
        System.out.println("║                                                      ║");

        System.out.println("\u001B[93m");

        System.out.println("║          🌸 Bienvenida querida clienta 🌸            ║");
        System.out.println("║                                                      ║");

        System.out.println("\u001B[95m");

        System.out.println("╠══════════════════════════════════════════════════════╣");

        System.out.println("\u001B[97m");

        System.out.println("║        ♥ Gracias por elegir SIFRAH Bijou ♥          ║");

        System.out.println("\u001B[95m");

        System.out.println("╚══════════════════════════════════════════════════════╝");

        System.out.println("\u001B[0m");
        menuPrincipal(scaner);
    }

    // Menu principal
    public static void menuPrincipal(Scanner scaner) {

        int opcion;

        do {

            System.out.println("-------- MENU PRINCIPAL --------");
            System.out.println("1.- Iniciar sesion");
            System.out.println("2.- Registrarse");
            System.out.println("3.- Entrar como invitado");
            System.out.println("4.- Salir");
            System.out.println("Seleccione una opcion:");

            opcion = scaner.nextInt();
            scaner.nextLine();

            switch (opcion) {

                case 1:

                    boolean acceso = loginUsuario(scaner);

                    if (acceso) {

                        categorias();

                    }

                    break;
                case 2:
                    registro();
                    categorias();
                    break;

                case 3:
                    System.out.println("Ingreso como invitado");
                    System.out.println("Bienvenido a SIFRAH");
                    categorias();
                    break;

                case 4:
                    System.out.println("Gracias por visitar SIFRAH");
                    break;

                default:
                    System.out.println("OPCION NO VALIDA");
            }

        } while (opcion != 4);
    }

    public static boolean loginUsuario(Scanner scaner) {
        String correoIn, passIn;

        String nombre = "Cliente";

        System.out.println("----- INICIAR SESION -----");

        for (int intentos = 1; intentos <= 3; intentos++) {

            System.out.println("Ingrese su correo");
            correoIn = scaner.nextLine();

            System.out.println("Ingrese su contraseña");
            passIn = scaner.nextLine();

            boolean estructuraCorreoOk =
                    correoIn.contains("@") &&
                            correoIn.endsWith(".com");

            boolean estructuraPassOk =
                    passIn.length() >= 8 &&
                            (passIn.contains("#") || passIn.contains("@"));

            // VALIDAR ESTRUCTURA
            if (!estructuraCorreoOk || !estructuraPassOk) {

                System.out.println("Error, los datos no cumplen requisitos:");

                if (!estructuraCorreoOk) {
                    System.out.println("El correo debe contener @ y terminar en .com");
                }

                if (!estructuraPassOk) {
                    System.out.println("La contraseña debe tener minimo 8 caracteres y # o @");
                }

                System.out.println("Intento " + intentos + " de 3");

            }

            // VALIDAR CREDENCIALES
            else if (correoIn.equals("queridamiss@gmail.com")
                    && passIn.equals("12345678@")) {

                System.out.println("Ingreso exitoso a SIFRAH");
                System.out.println("Bienvenido " + nombre);

                return true;

            }

            else {

                System.out.println("Credenciales no validas");
                System.out.println("Intento " + intentos + " de 3");
            }
        }

        System.out.println("Cuenta bloqueada por demasiados intentos");
        System.out.println("Cerrando sistema...");

        System.exit(0);

        return false;
    }

    public static void registro() {

        Scanner scaner = new Scanner(System.in);

        String correo;
        String contraseña;

        boolean datosCorrectos = false;

        System.out.println("----- REGISTRESE -----");

        do {

            System.out.println("Ingrese su correo electronico:");
            correo = scaner.nextLine();

            System.out.println("Ingrese su contraseña:");
            contraseña = scaner.nextLine();

            boolean correoValido =
                    correo.contains("@") &&
                            correo.endsWith(".com");

            boolean contraseñaValida =
                    contraseña.length() >= 8 &&
                            contraseña.contains("#");

            if (correoValido && contraseñaValida) {

                datosCorrectos = true;

                System.out.println("Registro exitoso");
                System.out.println("Bienvenido a SIFRAH");

            } else {

                System.out.println("ERROR EN LOS DATOS");

                if (!correoValido) {
                    System.out.println("El correo debe contener @ y terminar en .com");
                }

                if (!contraseñaValida) {
                    System.out.println("La contraseña debe tener minimo 8 caracteres y un #");
                }

                System.out.println("Intente nuevamente");
            }

        } while (!datosCorrectos);
    }

    // categorias
    public static boolean categorias() {

        Scanner scaner = new Scanner(System.in);

        boolean estado = false;
        String continuar;

        do {

            System.out.println("ENTRE LAS SIGUIENTES TENEMOS ESTOS PRODUCTOS");
            System.out.println("Marque 1 Bisuteria");
            System.out.println("Marque 2 Bolsos y carteras");
            System.out.println("Marque 3 Accesorios de cabello");
            System.out.println("Marque 4 Complementos");
            System.out.println("Marque 5 Belleza");

            int opcion = scaner.nextInt();

            switch (opcion) {

                case 1:
                    estado = bisuteria();
                    break;

                case 2:
                    estado = bolsosYCarteras();
                    break;

                case 3:
                    estado = accesoriosCabello();
                    break;

                case 4:
                    estado = complementos();
                    break;

                case 5:
                    estado = belleza();
                    break;

                default:
                    System.out.println("OPCION NO VALIDA");
            }

            System.out.println("¿Desea agregar otro producto al carrito? SI/NO");

            scaner.nextLine();
            continuar = scaner.nextLine();

        } while (continuar.equalsIgnoreCase("SI"));

        datosEntrega(scaner);
        mostrarSucursales(scaner);
        pagar(carritoTotal, scaner);

        carritoTotal = 0;

        return estado;
    }

    public static boolean bisuteria() {

        Scanner scaner = new Scanner(System.in);

        System.out.println("CATALOGO BISUTERIA SIFRAH");
        System.out.println("1.- Anillo dorado con luna y estrella en zircón a 15.90");
        System.out.println("2.- Pulsera dorada con lazo y zircón a 31.90");
        System.out.println("3.- Pulsera dorada con corazón y zircón a 31.90");
        System.out.println("4.- Pulsera Premium Zircón Bañado en Oro Con Charms a 29.90");
        System.out.println("5.- Set Aretes Premium Zircón Bañado en Oro Delicate Dorado a 22.90");
        System.out.println("6.- Anillo Bañado en Oro Premium Zircón Regulable Mariposa Dorado a 22.90");
        System.out.println("7.- Set Aretes Premium Zircón Bañado en Oro Cherry Dorado a 22.90");
        System.out.println("8.- Set Collar + Arete Premium Zircón Bañado en Oro Puppy Dorado a 39.90");
        System.out.println("9.- Aretes Premium Zircón Bañado en Oro Bloom Dorado a 22.90");
        System.out.println("10.- Anillo Bañado en Oro Premium Zircón Flor Dorado a 22.90");

        int opcion = scaner.nextInt();
        System.out.println("Ingrese cantidad:");
        int cantidad = scaner.nextInt();

        double total = 0;

        switch (opcion) {

            case 1:
                total = 15.90 * cantidad;
                break;
            case 2:
                total = 31.90 * cantidad;
                break;
            case 3:
                total = 31.90 * cantidad;
                break;
            case 4:
                total = 29.90 * cantidad;
                break;
            case 5:
                total = 22.90 * cantidad;
                break;
            case 6:
                total = 22.90 * cantidad;
                break;
            case 7:
                total = 22.90 * cantidad;
                break;
            case 8:
                total = 39.90 * cantidad;
                break;
            case 9:
                total = 22.90 * cantidad;
                break;
            case 10:
                total = 22.90 * cantidad;
                break;
        }

        carritoTotal += total;

        System.out.println("Producto agregado al carrito");
        System.out.println("Total acumulado: S/" + carritoTotal);

        return true;
    }

    public static boolean bolsosYCarteras() {

        Scanner scaner = new Scanner(System.in);

        System.out.println("----- BOLSOS Y CARTERAS -----");
        System.out.println("1.- Mochila viajera lila = S/129.90");
        System.out.println("2.- Mochila duna rosa = S/89.90");
        System.out.println("3.- Maleta para viaje negro = S/99.90");
        System.out.println("4.- Canguro moda beige = S/39.90");
        System.out.println("5.- Mochila mini negro = S/59.90");
        System.out.println("6.- Mochila mini floral = S/59.90");
        System.out.println("7.- Crossbody negro = S/59.90");
        System.out.println("8.- Mochila duna negro = S/89.90");
        System.out.println("9.- Maleta para viaje beige = S/99.90");
        System.out.println("10.- Mochila urbana azul = S/83.90");

        int opcion = scaner.nextInt();

        System.out.println("Ingrese cantidad:");
        int cantidad = scaner.nextInt();

        double total = 0;

        switch (opcion) {

            case 1:
                total = 129.90 * cantidad;
                break;
            case 2:
                total = 89.90 * cantidad;
                break;
            case 3:
                total = 99.90 * cantidad;
                break;
            case 4:
                total = 39.90 * cantidad;
                break;
            case 5:
                total = 59.90 * cantidad;
                break;
            case 6:
                total = 59.90 * cantidad;
                break;
            case 7:
                total = 59.90 * cantidad;
                break;
            case 8:
                total = 89.90 * cantidad;
                break;
            case 9:
                total = 99.90 * cantidad;
                break;
            case 10:
                total = 83.90 * cantidad;
                break;
        }

        carritoTotal += total;

        System.out.println("Producto agregado al carrito");
        System.out.println("Total acumulado: S/" + carritoTotal);

        return true;
    }

    public static boolean accesoriosCabello() {

        Scanner scaner = new Scanner(System.in);

        System.out.println("----- ACCESORIOS DE CABELLO -----");
        System.out.println("1.- Vincha plateada con mariposas y perlas a 16.90");
        System.out.println("2.- Vincha negra con flor y cadena decorativa a 17.90");
        System.out.println("3.- Vincha blanca corazones a 12.90");
        System.out.println("4.- Vincha duo dorado a 14.90");
        System.out.println("5.- Vincha basica plana azul a 16.90");
        System.out.println("6.- Vincha con mariposas multicolor a 10.90");
        System.out.println("7.- Vincha essential nudo a 22.90");
        System.out.println("8.- Vincha slim rosa a 19.90");
        System.out.println("9.- Vincha fantasy dorado a 22.90");
        System.out.println("10.- Vincha bloom lila a 19.90");

        int opcion = scaner.nextInt();

        System.out.println("Ingrese cantidad de vinchas que desea querida clienta <3");
        int cantidad = scaner.nextInt();

        double total = 0;

        switch (opcion) {

            case 1:
                total = 16.90 * cantidad;
            break;
            case 2:
                total = 17.90 * cantidad;
                break;
            case 3:
                total = 12.90 * cantidad;
                break;
            case 4:
                total = 14.90 * cantidad;
                break;
            case 5:
                total = 16.90 * cantidad;
                break;
            case 6:
                total = 10.90 * cantidad;
                break;
            case 7:
                total = 22.90 * cantidad;
                break;
            case 8:
                total = 19.90 * cantidad;
                break;
            case 9:
                total = 22.90 * cantidad;
                break;
            case 10:
                total = 19.90 * cantidad;
                break;
        }

        carritoTotal += total;

        System.out.println("Producto agregado al carrito");
        System.out.println("Total acumulado: S/" + carritoTotal);

        return true;
    }

    public static boolean complementos() {

        Scanner scaner = new Scanner(System.in);

        System.out.println("----- COMPLEMENTOS -----");
        System.out.println("1.- Lentes marrones 39.00");
        System.out.println("2.- Lentes negros 34.00");
        System.out.println("3.- Lentes rectangulares con montura marron 34.90");
        System.out.println("4.- Lentes de sol aviador negro 49.90");
        System.out.println("5.- Lentes de sol retro print marrones 36.90");
        System.out.println("6.- Lentes de sol cateyes marrones print 34.90");
        System.out.println("7.- Pashminas femme moda animal print 34.90");
        System.out.println("8.- Pashmina moda azul 39.90");
        System.out.println("9.- Pashmina femme moda rosa 29.90");
        System.out.println("10.- Pashmina moda guinda 29.90");

        int opcion = scaner.nextInt();

        System.out.println("Ingrese cantidad:");
        int cantidad = scaner.nextInt();

        double total = 0;

        switch (opcion) {

            case 1:
                total = 39.00 * cantidad;
                break;
            case 2:
                total = 34.00 * cantidad;
                break;
            case 3:
                total = 34.90 * cantidad;
                break;
            case 4:
                total = 49.90 * cantidad;
                break;
            case 5:
                total = 36.90 * cantidad;
                break;
            case 6:
                total = 34.90 * cantidad;
                break;
            case 7:
                total = 34.90 * cantidad;
                break;
            case 8:
                total = 39.90 * cantidad;
                break;
            case 9:
                total = 29.90 * cantidad;
                break;
            case 10:
                total = 29.90 * cantidad;
                break;
        }

        carritoTotal += total;

        System.out.println("Producto agregado al carrito");
        System.out.println("Total acumulado: S/" + carritoTotal);

        return true;
    }

    public static boolean belleza() {

        Scanner scaner = new Scanner(System.in);

        System.out.println("----- BELLEZA -----");
        System.out.println("Elija que producto poner en el carrito");
        System.out.println("DISFRUTA TU RUTINA DIARIA CON NUESTROS MEJORES ARTICULOS DE BELLEZA ENCONTRARAS TODO LO QUE DESEES");
        System.out.println("1.- Neceser Porta Cosmeticos Corazon Rosa S/19.90");
        System.out.println("2.- Rizador de pestañas Rosa S/16.90");
        System.out.println("3.- Vincha para spa rosada S/9.90");
        System.out.println("4.- Kit rosa para cabello S/9.90");
        System.out.println("5.- Esponja de maquillaje rosa S/4.90");
        System.out.println("6.- Set de brochas S/24.90");
        System.out.println("7.- Cepillos desechables para pestañas S/6.90");
        System.out.println("8.- Pinzas de cejas moradas S/9.90");
        System.out.println("9.- Cepillo limpiador y exfoliante de rostro S/11.90");
        System.out.println("10.- Pinza y perfilador rosado para cejas S/6.90");

        int opcion = scaner.nextInt();

        System.out.println("Ingrese cantidad:");
        int cantidad = scaner.nextInt();

        double total = 0;

        switch (opcion) {

            case 1:
                total = 19.90 * cantidad;
                break;
            case 2:
                total = 16.90 * cantidad;
                break;
            case 3:
                total = 9.90 * cantidad;
                break;
            case 4:
                total = 9.90 * cantidad;
            break;
            case 5:
                total = 4.90 * cantidad;
            break;
            case 6:
                total = 24.90 * cantidad;
                break;
            case 7:
                total = 6.90 * cantidad;
                break;
            case 8:
                total = 9.90 * cantidad;
                break;
            case 9:
                total = 11.90 * cantidad;
            break;
            case 10:
                total = 6.90 * cantidad;
            break;
        }

        carritoTotal += total;

        System.out.println("Producto agregado al carrito");
        System.out.println("Total acumulado: S/" + carritoTotal);

        return true;
    }

    public static void datosEntrega(Scanner scaner) {

        System.out.println("-------- DATOS DE ENTREGA --------");

        System.out.println("Ingrese nombre:");
        nombreCliente = scaner.nextLine();

        System.out.println("Ingrese apellidos:");
        apellidosCliente = scaner.nextLine();

        System.out.println("Ingrese DNI:");
        dniCliente = scaner.nextLine();

        System.out.println("Ingrese telefono:");
        telefonoCliente = scaner.nextLine();
    }
    // pago
    public static boolean pagar(double total, Scanner scaner) {

        int opcionPago;
        boolean estado = false;

        System.out.println("Seleccione metodo de pago");
        System.out.println("1.- Pago con tarjeta");
        System.out.println("2.- Pago en efectivo");

        opcionPago = scaner.nextInt();
        scaner.nextLine();

        switch (opcionPago) {

            case 1:
                estado = validaPagoTarjeta(scaner, total);
                generarBoleta(total, total);
                break;

            case 2:
                estado = pagoEfectivo(total, scaner);
                break;

            default:
                System.out.println("OPCION NO VALIDA");
        }

        return estado;
    }

    // pago tarjeta
    public static boolean validaPagoTarjeta(Scanner scaner, double total) {

        String numberTarjeta, fechaVencimiento, cvv;
        boolean pAprovado = false;

        System.out.println("Monto total a pagar con tarjeta es:" + total);

        do {

            System.out.println("Ingrese los 16 digitos de la tarjeta");
            numberTarjeta = scaner.nextLine();

            System.out.println("Ingrese la fecha de caducidad (MM/AA) ");
            fechaVencimiento = scaner.nextLine();

            System.out.println("Ingrese el código de seguridads CVV");
            cvv = scaner.nextLine();

            boolean tarjetaOk = (numberTarjeta.length() == 16);
            boolean cvvOk = (cvv.length() == 3);

            boolean fechaEstructuraOk =
                    (fechaVencimiento.length() == 5 &&
                            fechaVencimiento.contains("/"));

            boolean fechaNoVencida = false;

            if (fechaEstructuraOk) {

                try {

                    DateTimeFormatter formateador =
                            DateTimeFormatter.ofPattern("MM/yy");

                    YearMonth fechaTarjeta =
                            YearMonth.parse(fechaVencimiento, formateador);

                    YearMonth fechaActual = YearMonth.now();

                    if (fechaTarjeta.isAfter(fechaActual)
                            || fechaTarjeta.equals(fechaActual)) {

                        fechaNoVencida = true;
                    }

                } catch (DateTimeParseException e) {
                    fechaEstructuraOk = false;
                }
            }
            if (tarjetaOk && fechaEstructuraOk
                    && fechaNoVencida && cvvOk) {

                System.out.println(" Autorizando fondos... transaccion exitosa");
                pAprovado = true;

            } else {

                System.out.println("Operación denegada por la pasarela bancaria");
            }

        } while (!pAprovado);

        return true;
    }

    // pago efectivo
    public static boolean pagoEfectivo(double total, Scanner scaner) {

        double pago;

        do {

            System.out.println("Total a pagar: S/" + total);

            pago = scaner.nextDouble();
            scaner.nextLine();

            if (pago < total) {
                System.out.println("Monto insuficiente");
            }

        } while (pago < total);

        generarBoleta(total, pago);

        return true;
    }

    public static void mostrarSucursales(Scanner scaner) {

        System.out.println("Escoja una sede para Recojo En Tienda");
        System.out.println("1.Real Plaza Juliaca: Jirón Tumbes 391, local LC");
        System.out.println("2.Sifrah Real Plaza Cusco: Av. Collasuyo 2964, local LC-256 (2do nivel).");
        System.out.println("3.Real Plaza Arequipa: Av. Ejército 1009, primer nivel");
        System.out.println("4.Sifrah Plaza Center Moquegua: C.C. Plaza Center, Av. Circunvalación Norte, Urb. El Gramadal 1A");
        System.out.println("5.Sifrah Mega Plaza Ica: Av. Los Maestros No. 206 del Fundo San José, Ica");
        System.out.println("Ingrese una opción:");

        int opcion = scaner.nextInt();
        scaner.nextLine();

        switch(opcion){

            case 1:
                sucursalElegida = "Real Plaza Juliaca: Jirón Tumbes 391, local LC";
                break;

            case 2:
                sucursalElegida = "Sifrah Real Plaza Cusco: Av. Collasuyo 2964, local LC-256 (2do nivel).";
                break;

            case 3:
                sucursalElegida = "Real Plaza Arequipa: Av. Ejército 1009, primer nivela";
                break;

            case 4:
                sucursalElegida = "Sifrah Plaza Center Moquegua: C.C. Plaza Center, Av. Circunvalación Norte, Urb. El Gramadal 1A";
                break;

            case 5:
                sucursalElegida = "Sifrah Mega Plaza Ica: Av. Los Maestros No. 206 del Fundo San José, Ica";
                break;

            default:
                sucursalElegida = "Sucursal no valida";
        }

        System.out.println("Pedido listo en " + sucursalElegida);
    }

    // Boleta
    public static void generarBoleta(double total, double pago) {

        double igv = total * 0.18;
        double subtotal = total - igv;
        double vuelto = pago - total;

        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
        System.out.println("          SIFRAH BIJOU S.A.C.        ");
        System.out.println("RUC: 20601466920");
        System.out.println("*************");
        System.out.println("BOLETA DE VENTA ELECTRONICA");
        System.out.println("Fecha: 16/05/2026       Hora: 10:48:20");
        System.out.println("Caja N°: 97-1");
        System.out.println("Cajero: SRPJULIACA - SIFRAH REAL PLAZA");
        System.out.println("------DATOS DEL CLIENTE------");
        System.out.println("Cliente: " + nombreCliente + " " + apellidosCliente);
        System.out.println("DNI: " + dniCliente);
        System.out.println("Telefono: " + telefonoCliente);
        System.out.println("Sucursal de recojo: " + sucursalElegida);
        System.out.println("-------------------------------------");
        System.out.println("PRODUCTOS COMPRADOS");
        System.out.println("LIGAS                  1    10");
        System.out.println("BOLSA SIFRAH           1     1");
        System.out.println("-------------------------------------");
        System.out.println("SUBTOTAL:    S/ " + subtotal);
        System.out.println("IGV (18%):   S/ " + igv);
        System.out.println("-------------------------------------");
        System.out.println("TOTAL A PAGAR: S/ " + total);
        System.out.println("DINERO RECIBIDO: S/ " + pago);
        System.out.println("VUELTO:       S/ " + vuelto);
        System.out.println("=====================================");
        System.out.println("¡GRACIAS POR TU COMPRA!");
        System.out.println("Recuerda que tienes 10 dias para");
        System.out.println("solicitar cambios o devoluciones:");
        System.out.println("- Presentar DNI y recibo original");
        System.out.println("- Producto nuevo y sin usar");
        System.out.println("- Empaques completos y buenos");
        System.out.println("- No sirve para ropa interior ni joyas");
        System.out.println("Ultimo dia para devolucion: 26/05/2026");
        System.out.println("Visitanos en: sifrah.com");
        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
    }
}