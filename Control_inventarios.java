

import java.util.HashMap;
import java.util.Scanner;

class Reto3 {

    private final Scanner scanner = new Scanner(System.in);

    

    public String read() {
        return this.scanner.nextLine();

    }

    public void run() {
        BaseDatosProducto ListaProductos = new BaseDatosProducto();
        String operacion = read();
        String[] datos = read().split(" ");

        Producto producto = new Producto(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]));

        if (operacion.equals("ACTUALIZAR") && ListaProductos.verificarExistencia(producto)) {
            ListaProductos.actualizar(producto);
            ListaProductos.generarInforme();

        } else if (operacion.equals("AGREGAR") && !ListaProductos.verificarExistencia(producto)) {
            ListaProductos.agregar(producto);
            ListaProductos.generarInforme();
        } else if (operacion.equals("BORRAR") && ListaProductos.verificarExistencia(producto)) {

            ListaProductos.borrar(producto);
           ListaProductos.generarInforme();

        } else {
            System.out.println("ERROR");
        }
    }

}

class BaseDatosProducto {

    HashMap<Integer, Producto> ListaProductos = new HashMap<>();

    public BaseDatosProducto() {
       ListaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        ListaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
       ListaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        ListaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        ListaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        ListaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        ListaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        ListaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        ListaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        ListaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));
    }

    public void agregar(Producto producto) {
        ListaProductos.put(producto.getCodigo(), producto);

    }

    public void actualizar(Producto producto) {
        ListaProductos.replace(producto.getCodigo(), producto);

    }

    public void borrar(Producto producto) {
        ListaProductos.remove(producto.getCodigo());
    }

    public boolean verificarExistencia(Producto producto) {
        return ListaProductos.containsKey(producto.getCodigo());
    }

    public String precioMenor (){
        String nombre = ((Producto) ListaProductos.values().toArray()[0]).getNombre();
        double precio = ((Producto) ListaProductos.values().toArray()[0]).getPrecio();
        for (Producto producto: ListaProductos.values()){
            if (producto.getPrecio() < precio){
                nombre = producto.getNombre();
                precio = producto.getPrecio();

            }
        }
        return nombre;
    }

    public String precioMayor (){
        String nombre = ((Producto) ListaProductos.values().toArray()[0]).getNombre();
        double precio = ((Producto) ListaProductos.values().toArray()[0]).getPrecio();
        for (Producto producto: ListaProductos.values()){
            if (producto.getPrecio() > precio){
                nombre = producto.getNombre();
                precio = producto.getPrecio();

            }
        }
        return nombre;
        }

    public double promedio(){
        double suma=0;
        for(Producto producto: ListaProductos.values()){
            suma += producto.getPrecio();
        }
        return suma/ListaProductos.size();
        }
         public void generarInforme(){;
         System.out.println(precioMayor()+" "+precioMenor()+" "+String.format("%.1f", promedio()) );
         

        }
         
}
       




class Producto {

    private Integer codigo;
    private String nombre;
    private Double precio;
    private Integer inventario;

    public Producto(Integer codigo, String nombre, Double precio, Integer inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

}
