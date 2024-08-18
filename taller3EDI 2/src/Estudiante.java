
class Estudiante implements ComparableDate, Datable {

    private String nombre;
    private int edad;
    private String carrera;
    private int semestre;
    private int creditos;

    // Constructor
    public Estudiante(String nombre, int edad, String carrera, int semestre, int creditos) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.semestre = semestre;
        this.creditos = creditos;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    // Implementación del método compareTo de la interfaz Comparable
    @Override
    public int compareTo(Estudiante otro) {
        // Comparar por semestre
        if (this.semestre > otro.semestre) {
            return 1;
        }
        if (this.semestre < otro.semestre) {
            return -1;
        }
        if(this.creditos > otro.creditos){
            return 1;
        }
        if(this.creditos < otro.creditos){
            return -1;
        }
        // Si los semestres son iguales, comparar por número de créditos
        return 0;
    }

    // Método toString para representar el objeto como cadena
    @Override
    public String toString() {
        return "Estudiante: "
                + "Nombre=" + nombre
                + ", Edad=" + edad
                + ", Carrera=" + carrera
                + ", Semestre=" + semestre
                + ", Creditos=" + creditos + "\n";
    }

    
    //sobreescribir los metodos de la interfaz datable
    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public int edad() {
        return edad;
    }

    @Override
    public String carrera() {
        return carrera;
    }

    @Override
    public int semestre() {
        return semestre;
    }

    @Override
    public int creditos() {
        return creditos;
    }
}
