# Programacion funcional

Funciones como ciudadanos de primera clase.
Definirlos por demanda, 

### Funciones puras.

Siempre generan el mismo resultado si enviamos el mismo reultado para los mismos parametros, funcionan en aislamiento , no dependen del estado del sistema adicional a esto son deterministas. podemos predecir su resultado

- No genera valores aleatorios.
- No genera efectos secundarios.(consultar si un cliente tiene un saldo mayor a 0.)

```
  sum(5,3) => 8
```

| Funcion | Invoca Pura | Invoca Impura | 
| ------  | ----------- | ------------- |
| Pura    | O           | X             |
| Impura  | O           | O             |

Una funcion pura no puede invocar una funcion impura porque se vuelve impredecible.

### Funciones impuras 
Funciones impredecibles, no podemos pronosticar el resultado.

## Efectos secundarios
Todo cambio observable desde fuera del sistema.

X funcion que al ejecutarla cambia el color de algo.

# Los efectos secundarios son inevitables.

Codigo bien estructura con responsabilidades aisladas, funciones impuras como entradas de la informacion.

## Funcion de orden mayor
- toma una funcion como parametro
- Retorna una funcion como resultado.

Ventajas.
 - Pasar comportamiento
 - compartir medio de comunicacion
 - compartir logicas Reglas.

## Funciones Lambda.

Una lambda es una funcion anonima, no tiene nombre.

## Por que usarlas
- Es un comportamiento unico
- Una regla que solo se requiere en un lugar
- Es una funcion extremadamente simple.

una lambda sigue siendo una funcion.

## Inmutabilidad.

### Ventajas.

- Una vez se crea un objeto este no cambia.
- Funciones sin efectos secundarios.
- una funcion sin efectos secundarios,no genera problemas al usar threads.

### Desventajas.

- Nueva instancia por cada modificacion.
- Especial atencion al diseño
- Objetos mutables fuera de nuestro alcance.


Una funcion recibe un tipo de dato y genera de salida otro tipo de dato.

Functional<R,T>

Como ahora en java las funciones son tipos estos pueden ser enviados como parametros declarados en una funcion o retornados por algunos metodos si lo requerimos.

ejecutamos una funcion, llamando el metodo apply()

Tambien existe otra interface que se llama 
Predicate<?> esta siempre retorna un valor Booleano, debes tener en cuenta que 
este ya no se puede llamar usando el metodo apply(), tiene que llamarse el metodo test()

# Consumer y Supplier
El consumer por deduccion se puede decir que consume un dato
El supplier se encarga de suplir una necesesidad o proveer un dato.

# Operators y BiFunction

## UnaryOperator
 ```
    UnaryOperator <String> quota = text -> "\"" + text + "\"";
    System.out.println(quota.apply("Gustavo"));  
 ```

 ## BiFunction
 ```
    BiFunction<Integer, Integer, Integer> multiplicacio = (x, y) -> x * y;
    System.out.println(multiplicacio.apply(3,4));

    BinaryOperator<Integer> binaryOperator =(x,y) -> x*y;
    System.out.println(binaryOperator.apply(12,13));

 ```

# SAM
Una interfaz con un unico metodo sin definir.(Single Abstract Method),
para poder crear una interfaz funcional debo usar una anotacion en java la cual se denomina

```
@FunctionalInterface
interface Trifunction<T, U, V, R> {
   R apply(T t, U u, V v);
}
```

Ahora como se aplica programacion funcional a un proyecto que ya esta andando y que lleva varios meses de construccion.

# Referencia de metodos.

:: se usan con este operador los metodos tambien son funciones ligadas a un objeto o ha una clase
 el metodo debe cumplir algunas caracteristicas. Deben cumplir con la misma cantidad y tipo de parametros usados.

 # Analizando la inferencia de tipos.

Java se encarga de saber cual es el tipo de dato que se recibe y se genera de vuelta,  


# Sintaxis de funciones lambda.

Las funciones lambda tiene como estructura , es una funcion anonima , un metodo que no pertenece a una clase.

```
   parametro -> {body de la funcion}
   (x,y) -> {body pasando x cantidad de parametros.}
   //Cuando no se recibe un dato
   () -> {Body de la lambda}
```


# Predicados 
Retornar un boolean dependiendo la expresion que se quiera evaluar.

```
   Predicate<String> predicado = text -> text.isEmpty();
```

# Metodos Default

Podemos agregas muchos metodos que tengan una definicion de como comportarse en una interfaz.

# Chaining
La forma en que se encadena el llamado de metodos con java, podemos entender con un ejemplo mas basico:

```
 static class Say{

    public Say hello(){
      System.out.println("Saludando");
      return this;
    }

    public Say adios(){
      System.out.println("Despidiendome");
      return this;
    }
  }

  ...
  public static void main(String[] args) {
    Say saludador = new Say();
    saludador.hello().adios();
  }
```

### Funciones de orden mayor, son las que toman como parametro una funcion o retornan otra funcion, o pueden ser los dos casos al mismo tiempo.


## Composicion de funciones.

## Optional

Nos permite encapsular valores, de esta forma tenemos una manera elegante de comprobar los valores Null, y podemos comprobar 
mediante acceso a metodos para validar si hay valores presentes y adicional tambien podemos pasar Consumer o Suppliers segun nuestro requerimientos.

``` 
   public static Optional<String> nameReturn(){
      if(false){
          return Optional.of("Gustavo desde optional");
      }
      return Optional.empty();
   }
   .......
    public static void main(String[] args) {
        //System.out.println(unTexto().length());
        //Este nos da un nullPointe
        nameReturn().ifPresent(texto -> System.out.println(texto));
        if(nameReturn().isPresent()){
            System.out.println("Encontramos el valor");
        }
        nameReturn().flatMap((s) -> Optional.of(s.toUpperCase())).ifPresent(System.out::println);

        nameReturn().orElseGet( () ->"Invalid Value");
    }
```


## Stream
Es un flujo de datos auto-iterables, en este flujo de datos o pipe podemos empezar a hacer operaciones. 
a continuacion operaciones con Stream

``` 
   List<String> nombres = Arrays.asList("Gustavo","Adolfo","Cortes","Mondragon");
   nombres.stream().forEach(System.out::println);
   Stream<String> courses = Stream.of("Matematicas","español", "Ingles", "Quimica","otra");
   courses.map(e->e.toUpperCase()).forEach(System.out::println);
   Stream<Integer> length = courses.map(s -> s.length());
   Optional<Integer> posibleMaximo = length.max((x, y) -> x - y);
   posibleMaximo.ifPresent(n -> System.out.println(n));
   
   //Esto fallara
```

##### Por que falla?? Los Stream solo se pueden consumir una unica vez, una vez consumido un stream no se puede operar de nuevo.


### Tipo de operaciones en los Streams
- Intermedia
 Que retorna cualquier tipo de Stream.
- Final
Que retorna un tipo de dato diferente a un Stream o no Retorna nada.