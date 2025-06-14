import java.util.Scanner;

public class Cafeteria {
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private Cliente[] clientes;
    private int contClientes;
    private Producto[] productos;
    private int contProductos;
    private Pedido[] pedidos;
    private int contPedidos;

    public Cafeteria(String nombre, String ubicacion, int capacidadMaxima) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.clientes = new Cliente[this.capacidadMaxima];
        this.contClientes = 0;
        this.productos = new Producto[this.capacidadMaxima];
        this.contProductos = 0;
        this.pedidos = new Pedido[this.capacidadMaxima];
        this.contPedidos = 0;
    }

    public void agregarCliente(Scanner input) {
        if (this.contClientes >= capacidadMaxima) {
            System.out.println("No hay espacio para clientes");
            return;
        }

        System.out.println("Ingresa el nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese el id: ");
        String id = input.nextLine();
        System.out.println("Ingresa el correo: ");
        String correo = input.nextLine();

        for (int i = 0; i < this.contClientes; i++) {
            if (this.clientes[i].getId().equals(id)) {
                System.out.println("El cliente ya existe.");
                return;
            }
        }

        this.clientes[this.contClientes] = new Cliente(nombre, id, correo);
        this.contClientes++;
        System.out.println("Cliente agregado");
    }

    public void eliminarCliente(Scanner input) {
        if (this.contClientes == 0) {
            System.out.println("No hay clientes para eliminar");
            return;
        }

        System.out.println("Ingrese el id a eliminar: ");
        String id = input.nextLine();

        for (int i = 0; i < this.contClientes; i++) {
            if (this.clientes[i].getId().equals(id)) {
                for (int j = i; j < this.contClientes - 1; j++) {
                    this.clientes[j] = this.clientes[j + 1];
                }
                this.clientes[--this.contClientes] = null;
                System.out.println("Cliente eliminado");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }

    public void listarClientes() {
        if (this.contClientes == 0) {
            System.out.println("No hay clientes registrados");
            return;
        }

        for (int i = 0; i < this.contClientes; i++) {
           this.clientes[i].mostrarInfo();;
        }
    }

    public void agregarComida(Scanner input) {
        if (this.contProductos >= capacidadMaxima) {
            System.out.println("No hay espacio para productos");
            return;
        }

        System.out.println("Ingresa el nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese el precio: ");
        double precio = input.nextDouble();
        input.nextLine();
        System.out.println("Ingresa el codigo: ");
        String codigo = input.nextLine();
        System.out.println("tipo: rapida, pesada, gourmet, etc...: ");
        String tipo = input.nextLine();
        System.out.println("Es vegetariana?: ");
        String esVegetariana = input.nextLine();

        for (int i = 0; i < this.contProductos; i++) {
            if (this.productos[i].getCodigo().equals(codigo)) {
                System.out.println("El producto ya existe.");
                return;
            }
        }

        this.productos[this.contProductos] = new Comida(nombre, precio, codigo, tipo, esVegetariana);
        this.contProductos++;
        System.out.println("Comida agregada");
    }

    public void agregarBebida(Scanner input) {
        if (this.contProductos >= capacidadMaxima) {
            System.out.println("No hay espacio para productos");
            return;
        }

        System.out.println("Ingresa el nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese el precio: ");
        double precio = input.nextDouble();
        input.nextLine();
        System.out.println("Ingresa el codigo: ");
        String codigo = input.nextLine();
        System.out.println("tipo: gaseosa, jugo natural, chicha, etc...: ");
        String tipo = input.nextLine();
        System.out.println("Es alcoholica?: ");
        String esAlcoholica = input.nextLine();

        for (int i = 0; i < this.contProductos; i++) {
            if (this.productos[i].getCodigo().equals(codigo)) {
                System.out.println("El producto ya existe.");
                return;
            }
        }

        this.productos[this.contProductos] = new Bebida(nombre, precio, codigo, tipo, esAlcoholica);
        this.contProductos++;
        System.out.println("Bebida agregada");
    }

    public void eliminarProducto(Scanner input) {
        if (this.contProductos == 0) {
            System.out.println("No hay productos para eliminar");
            return;
        }

        System.out.println("Ingrese el codigo a eliminar: ");
        String codigo = input.nextLine();

        for (int i = 0; i < this.contProductos; i++) {
            if (this.productos[i].getCodigo().equals(codigo)) {
                for (int j = i; j < this.contProductos - 1; j++) {
                    this.productos[j] = this.productos[j + 1];
                }
                this.productos[--this.contProductos] = null;
                System.out.println("Producto eliminado");
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    public void listarProductos() {
        if (this.contProductos == 0) {
            System.out.println("No hay productos registrados");
            return;
        }

        System.out.println("===== Información de Productos =====");
        for (int i = 0; i < this.contProductos; i++) {
            this.productos[i].mostrarDetalles();
        }
    }

    public void aplicarDescuentoBebidas(Scanner input) {
        if (this.contProductos == 0) {
            System.out.println("No hay productos para aplicar descuento");
            return;
        }

        System.out.println("Ingrese el porcentaje del descuento: ");
        double porcentaje = input.nextDouble();

        boolean hayBebidas = false;
        for (int i = 0; i < contProductos; i++) {
            if (this.productos[i] instanceof Bebida) {
                double precioActual = this.productos[i].getPrecio();
                double nuevoPrecio = precioActual - (precioActual * porcentaje / 100);
                this.productos[i].setPrecio(nuevoPrecio);
                hayBebidas = true;
            }
        }
        if (hayBebidas) {
            System.out.println("Descuento aplicado a todas las bebidas.");
        } else {
            System.out.println("No hay bebidas para aplicar descuento.");
        }
    }

    public void crearPedido(Scanner input) {
        if (this.contClientes == 0) {
            System.out.println("No hay clientes registrados");
            return;
        }

        if (this.contProductos == 0) {
            System.out.println("No hay productos registrados");
            return;
        }

        if (this.contPedidos >= capacidadMaxima) {
            System.out.println("No hay espacio para más pedidos");
            return;
        }

        System.out.println("Ingrese el id del cliente: ");
        String id = input.nextLine();

        Cliente cliente = null;
        for (int i = 0; i < this.contClientes; i++) {
            if (this.clientes[i].getId().equals(id)) {
                cliente = this.clientes[i];
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        System.out.println("Cuantos productos va a comprar:");
        int cantP = input.nextInt();
        input.nextLine();
        Producto[] productosPedido = new Producto[cantP];

        for (int i = 0; i < cantP; i++) {
            System.out.println("Ingrese el codigo del producto " + (i + 1) + ":");
            String codigo = input.nextLine();
            Producto producto = null;
            for (int j = 0; j < this.contProductos; j++) {
                if (this.productos[j].getCodigo().equals(codigo)) {
                    producto = this.productos[j];
                    break;
                }
            }
            if (producto == null) {
                System.out.println("Producto no encontrado, intente de nuevo.");
                i--;
            } else {
                productosPedido[i] = producto;
            }
        }

        System.out.println("Fecha a recoger:");
        String fecha = input.nextLine();

        this.pedidos[this.contPedidos] = new Pedido(cliente, productosPedido, fecha);
        this.contPedidos++;

        System.out.println("Productos agregados al pedido");
    }

    public void eliminarPedido(Scanner input) {
        if (this.contPedidos == 0) {
            System.out.println("No hay pedidos para eliminar");
            return;
        }

        System.out.println("Ingrese el id del cliente a eliminar pedido:");
        String id = input.nextLine();

        for (int i = 0; i < this.contPedidos; i++) {
            if (this.pedidos[i].getCliente().getId().equals(id)) {
                for (int j = i; j < this.contPedidos - 1; j++) {
                    this.pedidos[j] = this.pedidos[j + 1];
                }
                this.pedidos[--this.contPedidos] = null;
                System.out.println("Pedido eliminado");
                return;
            }
        }
        System.out.println("Pedido no encontrado");
    }

    public void listarPedidos(){
         if (this.contPedidos == 0) {
            System.out.println("No hay pedidos registrados");
            return;
        }

        System.out.println("===== Información de pedidos =====");
        for (int i = 0; i < this.contPedidos; i++) {
            System.out.println(this.pedidos[i].getCliente().getNombre());
            System.out.println(this.pedidos[i].getCliente().getId());
            System.out.println(this.pedidos[i].getFecha());
            System.out.println("____________________________");
        }
    }

    public void cobrarPedido(Scanner input) {
    if (this.contPedidos == 0) {
        System.out.println("No hay pedidos registrados");
        return;
    }

    System.out.println("Ingrese el id del cliente para cobrar su pedido:");
    String id = input.nextLine();

    for (int i = 0; i < this.contPedidos; i++) {
        Pedido pedido = this.pedidos[i];
        if (pedido.getCliente().getId().equals(id)) {
            double total = 0;
            Producto[] productos = pedido.getProductos();
            for (Producto producto : productos) {
                if (producto != null) {
                    total += producto.getPrecio();
                }
            }
            System.out.println("El total a pagar es: $" + total);
            return;
        }
    }
    System.out.println("Pedido no encontrado para el cliente indicado.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getContClientes() {
        return contClientes;
    }

    public void setContClientes(int contClientes) {
        this.contClientes = contClientes;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public int getContProductos() {
        return contProductos;
    }

    public void setContProductos(int contProductos) {
        this.contProductos = contProductos;
    }

    public Pedido[] getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

    public int getContPedidos() {
        return contPedidos;
    }

    public void setContPedidos(int contPedidos) {
        this.contPedidos = contPedidos;
    }    
}