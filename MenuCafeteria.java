import java.util.Scanner;

public class MenuCafeteria {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Cafeteria cafeteria = new Cafeteria("el sabor de la exclavitud", "unipampliona", 100);

        int opcionPrincipal;
        do {
         
            System.out.println("\n==========================================================");
            System.out.println("=== Menú Principal Cafetería " + cafeteria.getNombre()+ " ===");
            System.out.println("==========================================================");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Productos");
            System.out.println("3. Gestión de Pedidos");
            System.out.println("4. Descripcion de la cafeteria");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = input.nextInt();
            input.nextLine();
            System.out.println("________________________");

            switch (opcionPrincipal) {
                case 1:
                    menuClientes(cafeteria, input);
                    break;
                case 2:
                    menuProductos(cafeteria, input);
                    break;
                case 3:
                    menuPedidos(cafeteria, input);
                    break;
                case 4:
                    mostrarDescripcionCafeteria();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionPrincipal != 0);

        input.close();
    }

    public static void mostrarDescripcionCafeteria(){
        System.out.println("""
\nBienvenidos a "Sabor de la Exclavitud", la cafetería hecha por negros, para negros. Aquí, cada taza de café te lleva de vuelta a nuestras raícesafricanas, recordándote de dónde venimos y lo que hemos superado.

Todo nuestro café es recolectado, tostado y molido por manos negras. Desde la plantación hasta tu taza, cada grano lleva el sudor y la resistencia de nuestra gente. Nuestro menú ofrece delicias auténticas, preparadas con ingredientes frescos y mucho amor.

Al entrar, te sumerges en un ambiente auténticamente negro, decorado con arte africano y muebles hechos a mano. El aroma del café recién molido te transporta a las plantaciones de café de África, donde nuestra historia comenzó.

Ven a "Sabor de la Exclavitud" y disfruta de un café que no solo sabe bien, sino que también te conecta con tu herencia. Apoya a una empresa negra, propiedad de negros, y celebra nuestra cultura y resistencia.
                """);
    }

    public static void menuClientes(Cafeteria cafeteria, Scanner input) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Listar clientes");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    cafeteria.agregarCliente(input);
                    break;
                case 2:
                    cafeteria.eliminarCliente(input);
                    break;
                case 3:
                    cafeteria.listarClientes();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void menuProductos(Cafeteria cafeteria, Scanner input) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Productos ---");
            System.out.println("1. Agregar comida");
            System.out.println("2. Agregar bebida");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Listar productos");
            System.out.println("5. Aplicar descuento a bebidas");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    cafeteria.agregarComida(input);
                    break;
                case 2:
                    cafeteria.agregarBebida(input);
                    break;
                case 3:
                    cafeteria.eliminarProducto(input);
                    break;
                case 4:
                    cafeteria.listarProductos();
                    break;
                case 5:
                    cafeteria.aplicarDescuentoBebidas(input);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void menuPedidos(Cafeteria cafeteria, Scanner input) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Pedidos ---");
            System.out.println("1. Agregar pedido");
            System.out.println("2. Eliminar pedido");
            System.out.println("3. Listar pedidos");
            System.out.println("4. Cobrar pedido");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    cafeteria.crearPedido(input);
                    break;
                case 2:
                    cafeteria.eliminarPedido(input);
                    break;
                case 3:
                    cafeteria.listarPedidos();
                    break;
                case 4:
                    cafeteria.cobrarPedido(input);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
