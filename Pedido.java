//clase 6
public class Pedido {
    private Producto[] productos;
    private int contP;
    private Cliente cliente;
    private String fecha;

    public Pedido(Cliente cliente, Producto[] productos,String fecha){
        this.cliente = cliente;
        this.fecha = fecha;
        this.contP = 0;
        this.productos = productos;
    }

    public void agregarProducto(Producto producto){
        if(this.contP >= 20){
            System.out.println("No hay espacio");
            return;
        }

        this.productos[contP] = producto;
        this.contP++;
        System.out.println("Agregado correctamente");
    }

    public void eliminarProducto(String codigo){
        if(this.contP == 0){
            System.out.println("No hay espaacio");
            return;
        }
        
        for (int i = 0; i < contP; i++) {
            if(this.productos[i].getCodigo().equals(codigo)){
                for (int j = i; j < contP-1; j++) {
                    this.productos[j] = this.productos[j+1];
                }
                this.productos[this.contP-1] = null;
                this.contP--;
                System.out.println("Eliminado correctamente");
                return;
            }
        } 
        System.out.println("No existe el producto");   
    }

    public void listarProductos(){
        for (int i = 0; i < this.contP; i++) {
            this.productos[i].mostrarDetalles();
        }
    }

    public void calcularTotal(){
        double total = 0;

        for (int i = 0; i < this.contP; i++) {
            total += this.productos[i].getPrecio();
        }
        System.out.println("Total: " + total);
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public int getContP() {
        return contP;
    }

    public void setContP(int contP) {
        this.contP = contP;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}