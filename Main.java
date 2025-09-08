import java.util.Scanner;

public class Main {
    
    public static int fibonacciNormal(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int a = 0, b = 1, c = 0;
            for (int i = 1; i < n - 1; i++) { // En el primer caso (3) sólo se ejecuta 1 vez
                 c = a + b;
                 a = b;
                 b = c;   
            }
            return c;
        }
    }
    public static int fibonacciRecursivo(int n) {
        if (n == 0) { 
            return 0; // Caso base
        } else if (n == 1) {
            return 1; // Caso base
        } else { 
            return fibonacciRecursivo(n -1) + fibonacciRecursivo(n -2); // Llamadas a sí mismo
        }
    }
    public static boolean subsetSum(int[] conjunto, int numero, int tamaño, int cont) {
        if (tamaño == 0) { // Si está vacío el conjunto o ya recorrió todo y no encontró nada
            return false;  // Caso base
        } else {
            if (conjunto[tamaño] >= numero) { // Si el elemento es mayor o igual al número se ignora
                return subsetSum(conjunto, numero, tamaño - 1, cont);
            } else {
                if (cont == tamaño) {
                    return subsetSum(conjunto, numero, tamaño -1, cont = 0);
                } else {
                    if (conjunto[cont] + conjunto[tamaño] == numero) {
                        System.out.print(" "+ conjunto[cont] + " + " + conjunto[tamaño] + " ");
                        return true;
                    } else {
                        return subsetSum(conjunto, numero, tamaño, ++cont);
                    }
                }
            }
        }
    }
    //public static void solucionSudoku(int[] matriz) {}
    
    public static void main(String[] args) {
        
        // Primer problema: Serie de Fibonacci recursiva. Implementa una función recursiva en Java que calcule el enésimo número en la serie de Fibonacci. Asegúrate de incluir tanto el caso base como el caso recursivo.
        // Segundo problema: Suma de subconjuntos (Subset Sum). Desarrolla un algoritmo recursivo para determinar si existe un subconjunto de un conjunto dado de enteros que sume un valor objetivo.
        // Tercer problema: Algoritmo de backtracking para el problema del sudoku. Implementa un algoritmo de backtracking que resuelva un Sudoku. El programa debe llenar las celdas vacías del tablero de Sudoku dado.
        Scanner input = new Scanner(System.in);
        boolean ciclo = true;
        int[] conjunto = {1,2,3,4,5,6,7,8,9}; // Conjunto de enteros pre-definido
        int tamaño = conjunto.length, cont = 0;

        while(ciclo) {
            System.out.println("\n ==== Menú de acciones ====");
            System.out.print("1) Serie fibonacci \n" +
                                "2) Suma de subconjunto \n" +
                                "3) Sudoku \n" +
                                "4) Salir \n" + 
                                "=> ");
            int seleccion = input.nextInt();
            input.nextLine(); // Limpiar buffer

            switch(seleccion) {
                case 1: // Serie fibonacci
                    System.out.print("¿Qué elemento quiere ver de la serie fibonacci? => ");
                    int topeFibonacci = input.nextInt();
                    input.nextLine(); // Limpiar buffer
                    System.out.println("Fibonacci normal: " + fibonacciNormal(topeFibonacci));
                    System.out.println("Fibonacci con recursividad: " + fibonacciRecursivo(topeFibonacci));
                    break;
                case 2: // Suma de subconjunto
                    System.out.print("¿De qué número quiere obtener la suma? => ");
                    int numero = input.nextInt();
                    input.nextLine(); // Limpiar buffer
                    if (subsetSum(conjunto, numero, tamaño -1, cont)) { // true false
                        System.out.println("Sí es posible obtener " + numero);
                    } else {
                        System.out.println("No hay elementos que den la suma de " + numero);
                    }
                    break;
                case 3: // Sudoku
                    System.out.println("Aquí debe estar la llamada a la función del sudoku. ");
                    // sudokuSolucion(int[] matriz);
                    break;
                case 4: // Salir
                    ciclo = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        
    }
}
