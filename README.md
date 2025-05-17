# JPA Investigadores y Experimentos
Proyecto para la gestión de investigaciones científicas con JPA(Jakarta Persisetnce API) y Hibernate. Se realizan operaciones de inserción de datos y consultas con JPQL para obtener información

## Funcionalidad:

- Insertar investigadores con su identificador institucional.
- Asociar múltiples experimentos a cada investigador.
- Asignar una estación de monitoreo a cada investigador.
- Realizar consultas con JPA sobre las entidades persistidas.

## Consultas Realizadas

1. Obtener los nombres de los investigadores y sus experimentos.
2. Mostrar nombre e identificador de investigadores con más de un experimento.
3. Mostrar las coordenadas GPS de la estación del investigador con ID = 1.

## Tecnologías utilizadas

- Java 
- JPA / Hibernate
- Jakarta Persistence
- Maven 
- Base de datos MySQL (configurado en el archivo de `persistence.xml`)
