import java.util.Scanner;

/**
 * Clase Criba:
 * Calcula los números primos mediante la criba de Eratóstenes
 * @see <a href="https://es.wikipedia.org/wiki/Criba_de_Erat%C3%B3stenes">Criba de Erastóstenes</a>
 */

public class Criba {

    /**
     * Método que calcula los números primos hasta el argumento que se le pasa. En caso de ser el argumento < 2, devuelve un vector vacío
     * @param dim tamaño del vector que equivale al argumento pasado + 1
     * @param esPrimo vector booleano que se utiliza para descartar los números no primos
     * @return lista de los números primos hasta el argumento
     */

    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max) {
        if (max >= 2) {
// Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
// Inicializar el array
            for (int i=0; i<dim; i++)
                esPrimo[i] = true;
// Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
// Criba
            cribar(dim, esPrimo);

// Rellenar el vector de números primos
            int[] primos = rellenarNumerosPrimos(dim, esPrimo);

            return primos;
        } else { // max < 2
            return new int[0];
// Vector vacío
        }
    }

    /**
     * Método que devuelve el vector de número primos dada la dimensión y el vector booleano que indica si son primos o no
     * @param primos vector en el que guardaremos los números que son primos
     * @return devuelve el vector de primos
     */

    public static int[] rellenarNumerosPrimos(int dim, boolean[] esPrimo) {
        int[] primos = new int[contarPrimos(dim, esPrimo)];
        for (int i=0, j=0; i< dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    /**
     * Método para contar los números primos que hay. Indica el tamaño del vector para devolver los números primos
     * @param cuenta valor que indica el total de números primos
     */

    public static int contarPrimos(int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i=0; i< dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    /**
     * Método para hacer la criba
     */

    public static void cribar(int dim, boolean[] esPrimo) {
        for (int i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                eliminarMultiplos(i, dim, esPrimo);
            }
        }
    }

    /**
     * Método utilizado para eliminar los múltimplos del número pasado como argumento
     */

    public static void eliminarMultiplos(int i, int dim, boolean[] esPrimo) {
        for (int j=2* i; j< dim; j+= i)
            esPrimo[j] = false;
    }


    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
}
