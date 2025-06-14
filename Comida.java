//clase 2
public class Comida extends Producto{
    private String tipo;
    private boolean esVegetariana;

    public Comida(String nombre, double precio, String codigo, String tipo, String esVegetariana){
        super(nombre, precio, codigo);
        this.tipo = tipo;
        if(esVegetariana.equalsIgnoreCase("si")){
            this.esVegetariana = true;
        }else{
            this.esVegetariana = false;
        }

    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Precio: $" + String.format("%.2f", this.getPrecio()));
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Tipo: " + this.tipo);
        System.out.println("¿Es Vegetariana?: " + (this.esVegetariana ? "Sí" : "No"));
        System.out.println("===================================");
    }

    @Override
    public void preparar(){
        System.out.println("Preparando " + this.getNombre());
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEsVegetariana() {
        return esVegetariana;
    }

    public void setEsVegetariana(boolean esVegetariana) {
        this.esVegetariana = esVegetariana;
    }
}
