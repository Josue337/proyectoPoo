//clase 3
public class Bebida extends Producto implements Descuento{
    private String tipo;
    private boolean esAlcoholica;

    public Bebida(String nombre, double precio, String codigo, String tipo, String esAlcoholica){
        super(nombre, precio, codigo);
        this.tipo = tipo;
        if(esAlcoholica.equalsIgnoreCase("si")){
            this.esAlcoholica = true;
        }else{
            this.esAlcoholica = false;
        }
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Precio: $" + String.format("%.2f", this.getPrecio()));
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Tipo: " + this.tipo);
        System.out.println("¿Es alcohólica?: " + (this.esAlcoholica ? "Sí" : "No"));
        System.out.println("===================================");
    }

    @Override
    public void preparar(){
        System.out.println("Preparando " + this.getNombre());
    }


    @Override
    public void aplicarDescuento(double porcentaje){
        if(porcentaje <= 0){
            System.out.println("Ingrese un porcentaje valido");
            return;
        }

        double descuento = this.getPrecio() - (this.getPrecio()*(porcentaje/100));

        this.setPrecio(descuento);
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public boolean getEsAlcoholica() {
        return esAlcoholica;
    }
    public void setEsAlcoholica(boolean esAlcoholica) {
        this.esAlcoholica = esAlcoholica;
    }
}