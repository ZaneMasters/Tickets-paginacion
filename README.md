# Ticket API

## Descripción
Esta es una API para gestionar tickets. Permite crear, eliminar, editar y recuperar tickets con paginación. También se puede recuperar todos los tickets o filtrar por uno específico. Los tickets tienen un id, un usuario, una fecha de creación, una fecha de actualización y un estatus (abierto/cerrado).

## Requisitos
- Docker
- Docker Compose

## Ejecución en Local

1. **Compilar el Proyecto:**

   Asegúrate de que has compilado tu proyecto y generado el archivo JAR. (MAVEN install)

   ```bash
   ./mvnw clean package

2. **Tener docker**

    Asegurate que tienes docker desktop corriendo 

    y ejecuta

    # docker compose up -d 
    este comando va a instalar y hacer el build del servicio y la base de datos en postgress

3. **Pruebas**

    Puedes ejecutar pruebas con estos endpoints

    -http://localhost:8080/api/tickets
    
    /POST
    EN EL BODY JSON ej:

    {
        "usuario": "user1", "estatus": "abierto"
    }
