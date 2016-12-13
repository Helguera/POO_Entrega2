# Primera práctica de POO
**Introducción**:
En esta ocasión hay que implementar una clase *Pack* que utilizará productos, y la clase *Producto*.
Hay que utilizar una abstracción de ambas, llamada *Vendible*.
Hemos utilizado *Vendible* como clase abstracta, asi aseguramos que Productos y Packs tengan ciertos métodos en común y desarrollar el polimorfismo.


## Producto:
Igual que la práctica anterior.
Ahora implementa la clase abstracta Vendible.

**De la clase abstracta *Vendible*:**
- [x] getNombre.
- [x] getPVP: Se redefine.
- [x] getIdentificador.


## Pack:
Implementa la clase abstracta *Vendible*.
- [x] Utiliza la clase _Producto_, y está compuesto por un array de Producto, que para ser vendible tiene que haber más de 2.
- [x] No puede haber dos productos iguales.
- [x] El precio del pack tiene un 20% de descuento.
- [x] Identificador del pack.

**Del pack:**
- [x] *setIdentificador()*
- [x] *size()*: Número de productos que contiene el pack.
- [x] *getProductosDelPack()*: Qué productos hay en el pack.
- [x] *contains()*: Ver si el pack contiene un determinado producto. <boolean>
- [x] *add(Producto [])*: Añadir una lista de productos al pack.
- [x] *add(Producto)*: Añade un producto al pack.
- [x] *remove()*: Elimina el producto del pack.

**De la  clase abstracta *Vendible*:**

- [x] getNombre.
- [x] getPVP: Se redefine
- [x] getIdentificador.


## Vendible:
Abstracción: Será aplicable a *Producto* y a *Pack*.

- [x] getNombre.
- [x] getPVP: No está implementada
- [x] getIdentificador.


## ProductoTest:
Batería de pruebas para JUnit de la clase _Producto_.
- [ ] Cambios al implementar Vendible.



## Créditos:

- [Álvaro Velasco] (https://github.com/Velastroll)
- [Javier Helguera] (https://github.com/Helguera)
