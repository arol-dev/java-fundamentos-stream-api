# Ejercicio de Implementación de la API Stream de Java

## Descripción General
Este ejercicio ayuda a los estudiantes de fundamentos de Java a entender los conceptos de programación funcional
reimplementando la funcionalidad principal de la API Stream. Los estudiantes trabajarán con expresiones lambda,
referencias a métodos e interfaces funcionales siguiendo principios de desarrollo guiado por tests.

## Objetivos de Aprendizaje
- Comprender los conceptos de programación funcional en Java
- Aprender cómo funcionan las expresiones lambda y las referencias a métodos
- Entender el concepto de operaciones intermedias vs terminales
- Practicar con interfaces funcionales (Predicate, Function, Consumer, Supplier)
- Experimentar con la metodología de desarrollo guiado por tests

## Descarga del ejercicio

Para mayor facilidad de gestión, antes de empezar a trabajar, haz un fork de este repositorio y trabaja desde allí.
Una vez acabes, harás un PR de tu fork a este repositorio.

## Pasos

### Requisitos Previos
- Java 11 o superior
- JUnit 5 (para ejecutar los tests)
- IDE con soporte para Java (IntelliJ IDEA, Eclipse, VS Code)

### Configuración
1. Importa el proyecto en tu IDE
2. Asegúrate de que JUnit 5 esté en tu classpath
3. Ejecuta los tests para ver los fallos actuales

## Instrucciones del Ejercicio

### Fase 1: Entendiendo la Estructura
1. **Examina la Interfaz**: Estudia `dev.arol.javafundamentos.stream.CustomStream.java` para entender los métodos que necesitas implementar
2. **Revisa los Tests**: Mira `dev.arol.javafundamentos.stream.CustomStreamTest.java` para entender el comportamiento esperado
3. **Analiza el Esqueleto**: Comprueba `CustomStreamImpl.java` para ver la estructura

### Fase 2: Guía de Implementación
**¡Sigue los tests en orden!** Cada test está numerado y se construye sobre la funcionalidad anterior.

#### Conceptos Clave a Recordar:
1. **Inmutabilidad**: Las operaciones de stream deben devolver nuevos streams, no modificar los existentes
2. **Evaluación Perezosa**: En streams reales, las operaciones intermedias son perezosas (aunque esta versión simplificada es ansiosa)
3. **Cortocircuito**: Operaciones como `anyMatch()` deben parar tan pronto como se determine el resultado
4. **Interfaces Funcionales**: Usa las interfaces funcionales proporcionadas correctamente
   - `Predicate<T>` - toma T, devuelve boolean
   - `Function<T, R>` - toma T, devuelve R
   - `Consumer<T>` - toma T, devuelve void

## Conceptos Clave de Programación Funcional Aprendidos

### Expresiones Lambda
- Sintaxis: `(parámetro) -> expresión`
- Ejemplo: `n -> n * 2`, `(a, b) -> a + b`

### Referencias a Métodos
- Método estático: `Integer::parseInt`
- Método de instancia: `String::toUpperCase`
- Constructor: `ArrayList::new`

### Interfaces Funcionales
- `Predicate<T>`: `boolean test(T t)`
- `Function<T, R>`: `R apply(T t)`
- `Consumer<T>`: `void accept(T t)`
- `Supplier<T>`: `T get()`

### Operaciones de Stream
- **Intermedias**: Devuelven streams, se pueden encadenar
- **Terminales**: Devuelven resultados finales, terminan el stream