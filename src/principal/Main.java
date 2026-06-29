package principal;

import conexion.Conexion;
import dao.MaterialDAO;
import negocio.Inventario;
import modelo.Material;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        
        Conexion.probarConexion();
        MaterialDAO dao = new MaterialDAO();
        

        int opcion;

        do {

            System.out.println("\n===== SISTEMA INVENTARIO TENARIS =====");
            System.out.println("1. Registrar material");
            System.out.println("2. Mostrar materiales");
            System.out.println("3. Buscar material");
            System.out.println("4. Actualizar stock");
            System.out.println("5. Eliminar material");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch(opcion) {

                case 1:

                    try {

                        System.out.print("ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Stock: ");
                        int stock = sc.nextInt();

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();

                        Material material =
                                new Material(id, nombre, stock, precio);
                        
                        inventario.agregar(material);
                        
                        boolean guardadoExitoso = dao.insertar(material);
                        if (guardadoExitoso) {
                            System.out.println("¡Material guardado con éxito en MySQL!");
                        } else {
                            System.out.println("Advertencia: No se pudo replicar en la base de datos.");
                        }


                        System.out.println("Material registrado.");

                    } catch(Exception e) {

                     System.out.println("Ocurrió un error:");
                     e.printStackTrace();
                     sc.nextLine();
}
                    

                    break;

                case 2:

                 ArrayList<Material> materiales = dao.listar();

                 if (materiales.isEmpty()) {
                 System.out.println("No hay materiales registrados.");
    } else {

        for (Material m : materiales) {
            m.mostrarInfo();
        }

    }

    break;

                case 3:

                    System.out.print("Ingrese ID: ");
                    int buscar = sc.nextInt();

                    Material encontrado =
                            inventario.buscar(buscar);

                    if(encontrado != null) {

                        encontrado.mostrarInfo();

                    } else {

                        System.out.println("Material no encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("ID del material: ");
                    int idActualizar = sc.nextInt();

                    Material actualizar =
                            inventario.buscar(idActualizar);

                    if(actualizar != null) {

                        System.out.print("Nuevo stock: ");
                        int nuevoStock = sc.nextInt();

                        actualizar.setStock(nuevoStock);

                        System.out.println("Stock actualizado.");

                    } else {

                        System.out.println("Material no encontrado.");
                    }

                    break;

                case 5:

                    System.out.print("ID a eliminar: ");
                    int eliminar = sc.nextInt();

                    if(inventario.eliminar(eliminar)) {

                        System.out.println("Material eliminado.");

                    } else {

                        System.out.println("Material no encontrado.");
                    }

                    break;

                case 6:

                    System.out.println("Fin del sistema.");
                    break;

                default:

                    System.out.println("Opcion incorrecta.");
            }

        } while(opcion != 6);

        sc.close();
    }
}
