# Prueba Técnica - Arquitectura Microservicio

Este repositorio contiene una solución para la Prueba Técnica de Arquitectura de Microservicios. A continuación, se proporciona información sobre la implementación y las funcionalidades.

## Tecnologías Utilizadas

- Java Spring Boot
- Maven
- Base de Datos Relacional (PostgreSQL 12)
- Postman v9.13.2 o Insomnia v2023.1.0
- Visual Studio Code

## Estructura del Proyecto

- `src/main/java/com/example/rest`: Contiene los paquetes y clases principales.
- `src/main/resources`: Archivos de configuración y recursos.
- `src/test`: Contiene las pruebas unitarias y de integración.

## Entidades

### Persona
- Implementa la clase persona con los siguientes datos: nombre, género, edad, identificación, dirección, teléfono.
- Se maneja como entidad JPA con una clave primaria (PK).

### Cliente
- Cliente hereda de la clase Persona.
- Un cliente tiene: clienteid, contraseña, estado.
- El cliente tiene una clave única (PK).

### Cuenta
- Cuenta es una entidad independiente.
- Una cuenta tiene: número de cuenta, tipo de cuenta, saldo inicial, estado.
- Tiene una clave única.

### Movimientos
- Movimientos es una entidad independiente.
- Un movimiento tiene: fecha, tipo de movimiento, valor, saldo.
- Tiene una clave única.

## Funcionalidades del API

### F1: Generación de CRUDS
- Endpoints generados:
  - `/cuentas`
  - `/clientes`
  - `/movimientos`
- Se implementan operaciones de Crear, Editar, Actualizar y Eliminar registros para las entidades Cliente, Cuenta y Movimiento.

### F2: Registro de Movimientos
- Al registrar un movimiento en la cuenta se tiene en cuenta:
  - Valores positivos o negativos.
  - Actualización del saldo disponible.
  - Registro de transacciones.

### F3: Registro de Movimientos (Validación de Saldo)
- Al realizar un movimiento sin saldo disponible, se muestra el mensaje de error "Saldo no disponible".

### F4: Reportes - Estado de Cuenta
- Genera un reporte de "Estado de cuenta" especificando un rango de fechas y cliente.
- Endpoint: `/reportes?fechaInicio=2022-02-01&fechaFin=2022-02-10&clienteId=2`
- Retorna información en formato JSON.

### F5: Pruebas Unitarias
- Implementa una prueba unitaria para la entidad de dominio Cliente.

### F6: Pruebas de Integración
- Implementa una prueba de integración.

### F7: Despliegue en Contenedores
- La solución se despliega y funciona en Docker.

## Casos de Uso (Ejemplos)

1. **Creación de Usuarios**
   - Nombres, Dirección, Teléfono, Contraseña, Estado
   - Ejemplo:
     ```json
     {
       "nombre": "Jose Lema",
       "direccion": "Otavalo sn y principal",
       "telefono": "098254785",
       "contraseña": "1234",
       "estado": true
     }
     ```
2. **Creación de Cuentas de Usuario**
   - Número de Cuenta, Tipo, Saldo Inicial, Estado, Cliente
   - Ejemplo:
     ```json
     {
       "numeroCuenta": "478758",
       "tipo": "Ahorros",
       "saldoInicial": 2000,
       "estado": true,
       "cliente": {
         "clienteId": "1"
       }
     }
     ```
3. **Crear una nueva Cuenta Corriente para Jose Lema**
   - Ejemplo:
     ```json
     {
       "numeroCuenta": "585545",
       "tipo": "Corriente",
       "saldoInicial": 1000,
       "estado": true,
       "cliente": {
         "clienteId": "1"
       }
     }
     ```
4. **Realizar los siguientes movimientos**
   - Ejemplo:
     ```json
     {
       "numeroCuenta": "478758",
       "tipo": "Ahorros",
       "valor": -575
     }
     ```
     ```json
     {
       "numeroCuenta": "225487",
       "tipo": "Corriente",
       "valor": 600
     }
     ```
     ```json
     {
       "numeroCuenta": "495878",
       "tipo": "Ahorros",
       "valor": 150
     }
     ```
     ```json
     {
       "numeroCuenta": "496825",
       "tipo": "Ahorros",
       "valor": -540
     }
     ```
5. **Listado de Movimiento, por fechas x usuario**
   - Ejemplo:
     ```json
     {
       "fecha": "10/2/2022",
       "cliente": "Marianela Montalvo",
       "numeroCuenta": "225487",
       "tipo": "Corriente",
       "saldoInicial": 100,
       "estado": true,
       "movimiento": 600,
       "saldoDisponible": 700
     }
     ```

## Ejecución del Proyecto

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/MikeRider27/Apirest-SpringBoot.git
