# Proyecto-Sistema-Inventario-Tenaris-final
Proyecto final gestion de inventarios
Configuracion de la base de datos
# Tecnologias utilizadas 
- Java
- NetBeans IDE
- MySQL
- JDBC
- Swing

# Configurar la base de datos
Para ejecutar correctamente el proyecto es necesario configurar la conexión a MySQL en la clase Conexion.java.

private static final String URL = "jdbc:mysql://localhost:3306/inventario_tenaris";
private static final String USER = "root";
private static final String PASSWORD = "******";

# Configuracion requerida 
Base de datos: inventario_tenaris
URL: jdbc:mysql://localhost:3306/inventario_tenaris
Usuario: root
Contraseña: Debe configurarse según la instalación local de MySQL.

# Por motivos de seguridad, la contraseña utilizada durante el desarrollo no se incluye en este repositorio. Cada usuario deberá ingresar sus propias credenciales en la clase Conexion.java antes de ejecutar la aplicación.
# Actualizar README con instrucciones de configuración de MySQL
