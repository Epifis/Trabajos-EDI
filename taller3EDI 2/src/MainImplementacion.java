import java.util.ArrayList;

// Clase principal para la implementación
public class MainImplementacion {

    public static void main(String[] args) {
        // Crear objetos Estudiante
        Estudiante e1 = new Estudiante("Natalia", 20, "Civil", 3, 10);
        Estudiante e2 = new Estudiante("Patricia", 21, "Derecho", 3, 18);
        Estudiante e3 = new Estudiante("Danilo", 22, "Medicina", 3, 18);
        Estudiante e4 = new Estudiante("Martha", 20, "Arquitectura", 2, 22);
        Estudiante e5 = new Estudiante("Matias", 18, "Arquitectura", 7, 40);

        // Comparación de los objetos usando compareTo
        System.out.println("Comparación entre e1 y e2: " + e1.compareTo(e2)); 
        System.out.println("Comparación entre e1 y e3: " + e1.compareTo(e3)); 
        System.out.println("Comparación entre e1 y e4: " + e1.compareTo(e4)); 
        System.out.println("Comparación entre e2 y e3: " + e2.compareTo(e3)); 

        // Ejemplo de ordenación en una lista
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3);
        estudiantes.add(e4);
        estudiantes.add(e5);

        System.out.println("Estudiantes antes de ordenar:\n");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}
