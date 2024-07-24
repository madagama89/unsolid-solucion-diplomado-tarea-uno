# Desarrollo tarea uno

## Instrucciones

En el repositorio trabajado durante las clases (https://github.com/dani-saavedra/diplomado2024-2.git) ubique la carpeta 'unsolid'.

Con las clases de esta carpeta deberá:
Crear un repositorio publico de github donde en el readme tenga los integrantes del grupo (no se permite cambiar de grupo)
Identificar los principios solid violados y documentarlos en el readme
Codificar la solución a estos principios

## Integrantes

- Claudia Alexandra Bojaca
- Sergio Josue Rodriguez
- Marlon David Garcia

## Análisis principios violados y correcciones

### Principio de Responsabilidad Única (SRP)

**Violación:**
La clase EmployeeManager tenía múltiples responsabilidades: agregar empleados, eliminar empleados, calcular salarios y guardar datos en archivos. Esto hace que la clase sea difícil de mantener y probar.

**Corrección:**
EmployeeManager se dividió en varias clases con responsabilidades únicas:
EmployeeRepository y EmployeeRepositoryImpl para la gestión de empleados.
SalaryService y SalaryServiceImpl para el cálculo de salarios.
FileStorageService y FileStorageServiceImpl para guardar datos en archivos.

### Principio de Segregación de Interfaces (ISP)

**Violación:**
La interfaz EmployeeOperations obligaba a las clases que la implementaban a definir métodos que no necesariamente necesitaban. Por ejemplo, addEmployee, removeEmployee, calculateSalary y saveToFile en una sola interfaz.

**Corrección:**
La interfaz EmployeeOperations se dividió en interfaces más pequeñas y específicas:
EmployeeRepository para agregar y eliminar empleados.
SalaryService para el cálculo de salarios.
FileStorageService para guardar datos en archivos.

### Principio de Sustitución de Liskov (LSP)

**Violación:**
La clase PartTimeEmployee anula el método getName() de una manera que rompe la funcionalidad esperada, lanzando una UnsupportedOperationException.

**Corrección:**
La clase PartTimeEmployee se corrigió para heredar correctamente de Employee y no lanzar excepciones en métodos heredados. Además, se añadió funcionalidad específica de empleados a tiempo parcial.


### Principio de Inversión de Dependencias (DIP)

**Violación:**
La clase SalaryCalculator creaba internamente una instancia de EmployeeManager, lo que hace que la clase dependa de una implementación concreta en lugar de una abstracción.

**Corrección:**
SalaryCalculator utiliza inyección de dependencias para recibir una implementación de SalaryService a través de su constructor, promoviendo la flexibilidad y facilidad de prueba.