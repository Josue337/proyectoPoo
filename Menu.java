public class Menu {
    public static void main(String[] args) {
        Comida comida = new Comida("cruasan", 3.99, "001", "rapida", "s");
        Cliente cliente = new Cliente("josue", "001", "josue@gmail.com");

        cliente.mostrarInfo();
        cliente.mostrarInfo();
        cliente.mostrarInfo();
        cliente.mostrarInfo();
        comida.mostrarDetalles();
    }
}
