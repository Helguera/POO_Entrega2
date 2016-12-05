# Primera práctica de POO
**Introducción**:
En esta ocasión hay que implementar una clase *Pack* que utilizará productos, y la clase *Producto*.
Hay que utilizar una abstracción de ambas, llamada *Vendible*.
Hemos utilizado *Vendible* como interfaz, asi aseguramos que Productos y Packs tengan ciertos métodos en común y desarrollar el polimorfismo.
A la hora de implementarlo en un futuro de forma física, la máquina utilizaría las clases Pack y Producto, pero como son clases diferentes, en la extracción del ArrayList, utilizarían la interfaz Vendible, es decir, llenan un ArrayList con packs y productos, pero los extraen como Vendibles.
- [ ] Preguntar si esto está bien.
- [ ] Preguntar si estructura de Vendible es válida.
- [ ] Preguntar si hay que hacer **JUnit** de *Vendible*, y en él introducir el cambio de tipo [Producto, Pack] -> Vendible.


## Producto:
Igual que la práctica anterior.
Ahora implementa la interfaz Vendible.

**De la interfaz *Vendible*:**
- [x] getVendible.
- [x] setVendible.
- [x] setNoVendible.
- [x] getNombre.
- [x] getPVP.
- [x] getIdentificador.


## Pack:
Implementa la interfaz *Vendible*.
- [x] Utiliza la clase _Producto_, y está compuesto por un array de Producto, que para ser vendible tiene que haber más de 2.
- [x] No puede haber dos productos iguales.
- [x] El precio del pack tiene un 20% de descuento.
- [x] Identificador del pack.

**Del pack:**
- [x] *setIdentificador()*
- [x] *size()*: Número de productos que contiene el pack.
- [x] *getProductosDelPack()*: Qué productos hay en el pack.
- [x] *contains()*: Ver si el pack contiene un determinado producto. <boolean>
- [x] *add()*: Añadir un producto al pack.
- [x] *remove()*: Elimina el producto del pack.

**De la interfaz *Vendible*:**

- [x] getVendible.
- [x] setVendible.
- [x] setNoVendible.
- [x] getNombre.
- [x] getPVP.
- [x] getIdentificador.


## Vendible:
Interfaz o abstracción: Será aplicable a *Producto* y a *Pack*.
- [x] getVendible.
- [x] setVendible.
- [x] setNoVendible.
- [x] getNombre.
- [x] getPVP.
- [x] getIdentificador.


## ProductoTest:
Batería de pruebas para JUnit de la clase _Producto_.
- [ ] Cambios al implementar Vendible.



## Créditos:

- [Álvaro Velasco] (https://github.com/Velastroll)
- [Javier Helguera] (https://github.com/Helguera)
