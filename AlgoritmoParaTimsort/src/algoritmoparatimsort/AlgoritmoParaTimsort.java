package algoritmoparatimsort;

import java.util.Arrays;

/**
 *
 * @author Alexandra Tinjacá
 * @param <T>
 */
public class AlgoritmoParaTimsort<T extends Comparable<? super T>> {

    private static final int RUN = 32;
    /**
      RUN.
      
      El valor de RUN indica el tamaño mínimo de los subarreglos que se ordenarán con insertion sort
      Timsort usa esta técnica para optimizar el rendimiento al ordenar pequeños subarreglos, 
      ya que la inserción es más rápida en rangos pequeños.
    */
    
    // Método sort() principal
    public void sort(T[] arr) {
        /*
          Este es el método principal de ordenamiento, que sigue dos fases importantes:
          Aplicar Insertion Sort en segmentos pequeños del arreglo.
          Aplicar Merge Sort para combinar los segmentos previamente ordenados.
         */
        
        int n = arr.length;
        
        //Fase de Insertion Sort
        /*
        El arreglo se divide en subarreglos de tamaño RUN (32 en este caso).
        Para cada subarreglo, se aplica Insertion Sort. 
        Este algoritmo es eficiente para arreglos pequeños y tiene un rendimiento O(n^2), 
        pero en arreglos pequeños, como en este caso, resulta eficiente.
        */
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
            /* Se aplica Insertion Sort al subarreglo que comienza en el índice i 
               y termina en el menor de i + 31 o el final del arreglo.*/
        }

        //Fase de Merge Sort
        /*
        Después de que los subarreglos estén ordenados, el siguiente paso es combinar los subarreglos con Merge Sort. 
        La idea es que después de cada paso, 
        los subarreglos de tamaño RUN se hayan convertido en subarreglos más grandes, 
        combinando parejas de subarreglos ordenados.
        */
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                merge(arr, left, mid, right);
            }
            /*
            size = RUN: Empieza con subarreglos de tamaño RUN (que ya están ordenados) 
            y se va duplicando en cada iteración (size = 2 * size), hasta que se combina todo el arreglo.
            merge(): Este método combina dos subarreglos ordenados en un solo subarreglo ordenado.
            */
        }
    }

    // Método insertionSort
    /*
    El Insertion Sort se utiliza en subarreglos de tamaño pequeño. 
    Ordena los elementos de un subarreglo comparando los elementos uno por uno e insertándolos en su posición correcta.
    */
    private void insertionSort(T[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = arr[i];
            int j = i - 1;
            while (j >= left && less(temp, arr[j])) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        /*
        Bucle exterior: 
                Recorre el subarreglo desde left + 1 hasta right.
        Bucle interior (while): 
                Busca la posición correcta para insertar el elemento temp. 
                Si temp es menor que arr[j], se mueve el elemento a la derecha 
                hasta que se encuentra su posición correcta.
        */
    }

    // Método merge
    /*
    Este método combina dos subarreglos ordenados en un solo subarreglo ordenado. 
    Es el mismo concepto que el Merge Sort tradicional.
    */
    private void merge(T[] arr, int l, int m, int r) {
        //longitudes de los subarreglos left[] y right[].
        int len1 = m - l + 1;
        int len2 = r - m;
        
        /*
        Se crean dos arreglos temporales llamados left[] y right[] 
        para almacenar copias de los dos subarreglos que ya están ordenados. 
        Estos subarreglos se extraen del arreglo arr utilizando el método Arrays.copyOfRange():
        */
        T[] left = Arrays.copyOfRange(arr, l, m + 1);
        T[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            if (less(left[i], right[j])) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        /*
        less(left[i], right[j]): 
            Compara los elementos en las posiciones i de left[] y j de right[] 
            utilizando el método less(), que verifica si left[i] es menor que right[j].
        Si left[i] es menor, se copia left[i] al arreglo original arr[], y se incrementa el índice i.
        Si right[j] es menor o igual, se copia right[j] al arreglo original arr[], y se incrementa el índice j.
        Este proceso se repite hasta que se recorra uno de los dos subarreglos completamente.
        */
        
        /*
        Después del ciclo while, uno de los subarreglos puede tener elementos que no se han copiado todavía. 
        Esto ocurre cuando los elementos en uno de los subarreglos son todos mayores que los del otro subarreglos. 
        Por lo tanto, se necesita copiar los elementos restantes del subarreglo no agotado (ya sea left[] o right[]).
        */
        while (i < len1) {//Si todavía quedan elementos en left[], se copian al arreglo arr[].
            arr[k++] = left[i++];
        }
        while (j < len2) {//Si todavía quedan elementos en right[], se copian al arreglo arr[].
            arr[k++] = right[j++];
        }
        /*
        División del arreglo:
            Se divide el arreglo en dos subarreglos: left[] y right[]. 
            Estos subarreglos ya están ordenados.
        Combinar los subarreglos:
            Compara los elementos de left[] y right[] y los coloca en su lugar correcto en el arreglo original arr[].
        */
    }

    // Método less() para comparar dos elementos
    private boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    // Método show() para mostrar el arreglo
    public void show(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Método de prueba main()
    public static void main(String[] args) {
        // Crear una instancia de la clase AlgoritmoParaTimsort
        AlgoritmoParaTimsort<Integer> timsort = new AlgoritmoParaTimsort<>();
        AlgoritmoParaTimsort<String> timsortString = new AlgoritmoParaTimsort<>();
        AlgoritmoParaTimsort<Double> timsortdouble = new AlgoritmoParaTimsort<>();
        
        //Integer
        Integer[] arr = {5, 21, 7, 23, 19, 8, 1, 3, 45, 2, 9, 12};
        System.out.println("Array original:");
        timsort.show(arr);

        timsort.sort(arr);  // Usar la instancia para llamar a sort

        System.out.println("Array ordenado:");
        timsort.show(arr);  // Usar la instancia para llamar a show
        
        
        //String
        String[] str = {"a","b","t","e","d"};
        System.out.println("Array original:");
        timsortString.show(str);

        timsortString.sort(str);  // Usar la instancia para llamar a sort

        System.out.println("Array ordenado:");
        timsortString.show(str);  // Usar la instancia para llamar a show
        
        
        //float
        Double[] dbl = {0.0,0.1,0.2,0.8,0.4,0.3};
        System.out.println("Array original:");
        timsortdouble.show(dbl);

        timsortdouble.sort(dbl);  // Usar la instancia para llamar a sort

        System.out.println("Array ordenado:");
        timsortdouble.show(dbl);  // Usar la instancia para llamar a show
    }
}
