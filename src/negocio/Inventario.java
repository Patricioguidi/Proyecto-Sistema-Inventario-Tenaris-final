package negocio;

import modelo.Material;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Material> materiales = new ArrayList<>();

    public void agregar(Material material) {
        materiales.add(material);
    }

    public void mostrarTodos() {

        if(materiales.isEmpty()) {
            System.out.println("No hay materiales cargados.");
            return;
        }

        for(Material m : materiales) {
            m.mostrarInfo();
        }
    }

    public Material buscar(int id) {

        for(Material m : materiales) {

            if(m.getId() == id) {
                return m;
            }
        }

        return null;
    }

    public boolean eliminar(int id) {

        Material material = buscar(id);

        if(material != null) {
            materiales.remove(material);
            return true;
        }

        return false;
    }
}