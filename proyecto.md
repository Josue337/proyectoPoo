### **Clases con Atributos y Métodos**  

#### **1. Clase Abstracta: `Producto`**  
**Atributos:**  
- `nombre` (String)  
- `precio` (double)  
- `codigo` (String)  

**Métodos:**  
- Constructor (`nombre`, `precio`, `codigo`)  
- `mostrarDetalles()` (abstracto)  
- `preparar()` (abstracto)  
- Getters/Setters para todos los atributos  

#### **2. Clase Hija: `Comida` (hereda de `Producto`)**  
**Atributos adicionales:**  
- `tipo` (String)  
- `vegetariana` (boolean)  

**Métodos:**  
- Constructor (`nombre`, `precio`, `codigo`, `tipo`, `vegetariana`)  
- Sobrescribe `mostrarDetalles()` (muestra todos los atributos)  
- Sobrescribe `preparar()` (ej: "Preparando comida [nombre]")  
- Getters/Setters para nuevos atributos  

---

#### **3. Clase Hija: `Bebida` (hereda de `Producto` e implementa `Descuento`)**  
**Atributos adicionales:**  
- `tamaño` (String)  
- `alcoholica` (boolean)  

**Métodos:**  
- Constructor (`nombre`, `precio`, `codigo`, `tamaño`, `alcoholica`)  
- Sobrescribe `mostrarDetalles()`  
- Sobrescribe `preparar()`  
- Implementa `aplicarDescuento(double porcentaje)` (reduce el precio)  
- Getters/Setters para nuevos atributos  

---

#### **4. Interfaz: `Descuento`**  
**Método:**  
- `aplicarDescuento(double porcentaje)` (debe ser implementado)  

---

#### **5. Clase: `Cliente`**  
**Atributos:**  
- `nombre` (String)  
- `id` (String)  
- `correo` (String)  

**Métodos:**  
- Constructor (`nombre`, `id`, `correo`)  
- `mostrarInfo()` (imprime detalles del cliente)  
- Getters/Setters  

---

#### **6. Clase: `Pedido` (usa composición con `Producto`)**  
**Atributos:**  
- `productos` (arreglo de `Producto`)  
- `contadorProductos` (int)  
- `cliente` (Cliente)  
- `fecha` (String)  

**Métodos:**  
- Constructor (`cliente`, `fecha`, `capacidadMaxima`)  
- `agregarProducto(Producto producto)`  
- `eliminarProducto(String codigo)`  
- `listarProductos()`  
- `calcularTotal()` (suma precios de productos)  
- Getters/Setters  

---

#### **7. Clase: `Cafeteria` (implementa `Descuento`)**  
**Atributos:**  
- `nombre` (String)  
- `ubicacion` (String)  
- `pedidos` (arreglo de `Pedido`)  
- `contadorPedidos` (int)  

**Métodos:**  
- Constructor (`nombre`, `ubicacion`, `capacidadMaximaPedidos`)  
- `agregarPedido(Pedido pedido)`  
- `eliminarPedido(String fecha)`  
- `listarPedidos()`  
- Implementa `aplicarDescuento(double porcentaje)` (ej: descuento general)  
- Getters/Setters  

---

### **Requisitos Adicionales:**  
- Todas las clases usan **encapsulamiento** (atributos privados + getters/setters).  
- **Validaciones**:  
  - No permitir IDs de clientes o códigos de productos repetidos.  
  - Controlar límites de capacidad en arreglos.  
- **Menú principal** debe permitir:  
  - Agregar/listar/eliminar/buscar elementos.  
  - Mostrar totales (clientes, productos, pedidos).  

Puedes implementar estas clases en Java siguiendo esta estructura. ¡Éxito con tu proyecto! 🚀