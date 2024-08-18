public class ElementContentInterface <T extends Comparable<? super T>>{
    //extends Comparable<? super T>
    //Declarar un atributo de la clase parámetro
    private T[] content;
    private int size;
    private int actual;
    //Constructor por defecto inicializa el objeto
    public ElementContentInterface() {
        content=(T[])new Object[5];
        
    }
    //Constructor indicando el tamano del contenedor
    public ElementContentInterface(int size) {
        content=(T[])new Object[size];
        
    }
    //Constructor con un objeto de la clase parametrizada

    public ElementContentInterface(T t) {
        content[actual+1]=t;
        actual++;
    }

    public T getT() {
        int temp=actual;
        actual--;
        return content[temp];
        
    }

    /*public void setT(T t,int index) {
        content[index] = t;
    }
    */
    public void setT(T t) {
        content[actual+1] = t;
        actual++;
        
    }

    
    public int compareTo(T t1) {
        return this.compareTo(t1);
    }
    
  
    public static <T extends Comparable<T>> int compareTo(T t1, T t2) {
        return t1.compareTo(t2);
   }
    
}
