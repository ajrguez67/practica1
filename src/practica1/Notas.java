package practica1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Clase Notas
 *
 * La clase 'Notas' se utiliza para calcular y mostrar las notas de un estudiante.
 * Incluye metodos para ingresar las notas, verificar la validez de las notas,
 * calculando la nota final, mostrando las notas y determinando si el estudiante aprobo o supendio.
 *
 * @author Antonio Rodriguez
 * @version 1.0.0
 * @since 28/03/2024
 *
 * @see EntradaNoNumericaException
 *
 */
public class Notas {

    /**
     * Variables para manejar los datos de entrada.
     * Son las notas para tres unidades diferentes.
     *
     * @see #ingresaNotas() {@link #ingresaNotas()}
     * @see #comprobacion() {@link #comprobacion()}
     * @see #calculoNotas() {@link #calculoNotas()}
     * @see #mostrar() {@link #mostrar()}
     *
     */
    private double uf1, uf2, uf3;

    /**
     * Variables para manejar los calculos.
     * Son las notas ponderadas para las tres unidades y la nota final.
     *
     * @see #calculoNotas() {@link #calculoNotas()}
     * @see #mostrar() {@link #mostrar()}
     *
     */
    private double acu1, acu2, acu3, def;

    /**
     * Escaner para tomar la entrada del usuario.
     *
     * @see java.util.Scanner
     *
     */
    private Scanner entrada = new Scanner(System.in);

    /**
     * Metodo para almacenar las notas de entrada.
     * Pide al usuario que ingrese las notas para las tres unidades.
     *
     * @see #uf1 {@link #uf1}
     * @see #uf2 {@link #uf2}
     * @see #uf3 {@link #uf3}
     * @see #solicitaNota(String) {@link #solicitaNota(String)}
     *
     */
    public void ingresaNotas() {
        System.out.println("Ingrese las notas del estudiante");
        try {
            uf1 = solicitaNota("Ingrese nota 1: ");
            uf2 = solicitaNota("Ingrese nota 2: ");
            uf3 = solicitaNota("Ingrese nota 3: ");
        } catch (EntradaNoNumericaException e) {
            System.out.println(e.getMessage());
            ingresaNotas();
        }
    }

    /**
     *
     * Metodo para solicitar una calificacion al usuario.
     * Imprime un mensaje y devuelve la entrada del usuario.
     * Si la entrada no es un numero, lanza una 'EntradaNoNumericaException'.
     *
     * @param mensaje El mensaje a imprimir para solicitar la nota.
     * @return La nota ingresada por el usuario.
     * @throws EntradaNoNumericaException Si la entrada no es un numero.
     *
     * @see #ingresaNotas() {@link #ingresaNotas()}
     * @see EntradaNoNumericaException {@link EntradaNoNumericaException}
     *
     */
    private double solicitaNota(String mensaje) throws EntradaNoNumericaException {
        System.out.print(mensaje);
        try {
            return entrada.nextDouble();
        } catch (InputMismatchException e) {
            entrada.nextLine();
            throw new EntradaNoNumericaException("Entrada no numérica. Intente de nuevo.");
        }
    }

    /**
     * Metodo para comprobar la validez de las notas de entrada.
     * Chequea si las notas para las tres unidades son menores o iguales a 10.
     * Si una nota es mayor a 10, imprime un mensaje de error.
     *
     * @see #uf1 {@link #uf1}
     * @see #uf2 {@link #uf2}
     * @see #uf3 {@link #uf3}
     * @see #validaNota(double, String) {@link #validaNota(double, String)}
     *
     */
    public void comprobacion() {
        validaNota(uf1, "nota1");
        validaNota(uf2, "nota2");
        validaNota(uf3, "nota3");
    }

    /**
     * Metodo para validar una nota.
     * Chequea si la nota es menor o igual a 10.
     * Si la nota es mayor a 10, imprime un mensaje de error.
     *
     * @param nota La nota a validar.
     * @param nombreNota El nombre de la nota para imprimir en el mensaje de error.
     *
     * @see #comprobacion() {@link #comprobacion()}
     *
     */
    private void validaNota(double nota, String nombreNota) {
        if (nota > 10) {
            System.out.println(nombreNota + " mal introducida");
        } else {
            System.out.println(nombreNota + " correcta");
        }
    }

    /**
     * Metodo para calcular la nota final.
     * Calcula las notas ponderadas para las tres unidades y las suma para obtener la nota final.
     *
     * @see #uf1 {@link #uf1}
     * @see #uf2 {@link #uf2}
     * @see #uf3 {@link #uf3}
     * @see #acu1 {@link #acu1}
     * @see #acu2 {@link #acu2}
     * @see #acu3 {@link #acu3}
     * @see #def {@link #def}
     *
     */
    public void calculoNotas() {
        acu1 = uf1 * 0.35;
        acu2 = uf2 * 0.35;
        acu3 = uf3 * 0.30;
        def = acu1 + acu2 + acu3;
    }

    /**
     * Metodo para mostrar las notas.
     * Imprime las notas para las tres unidades, las notas ponderadas y la nota final.
     *
     * @see #uf1 {@link #uf1}
     * @see #uf2 {@link #uf2}
     * @see #uf3 {@link #uf3}
     * @see #acu1 {@link #acu1}
     * @see #acu2 {@link #acu2}
     * @see #acu3 {@link #acu3}
     * @see #def {@link #def}
     *
     */
    public void mostrar() {
        System.out.println("Notas introducidas son:");
        System.out.println("nota1 = " + uf1);
        System.out.println("nota2 = " + uf2);
        System.out.println("nota3 = " + uf3);
        System.out.println("acumuado 1 = " + acu1);
        System.out.println("acumuado 2 = " + acu2);
        System.out.println("acumuado 3 = " + acu3);
        System.out.println("nota definitiva es = " + def);
    }

    /**
     * Metodo para determinar si el estudiante aprobo o suspendio.
     * Si la nota final es menor a 5, imprime "suspendio".
     * Si la nota final esta entre 5 y 10, imprime "aprobado".
     * Si la nota final no esta entre 0 y 10, imprime "error en la notas".
     *
     * @see #def {@link #def}
     *
     */
    public void aprobado() {
        if (def < 5 && def >= 0) {
            System.out.println("suspendio");
        } else if (def >= 5 && def <= 10) {
            System.out.println("aprobado");
        } else {
            System.out.println("error en la notas");
        }
    }
    
    /**
     * @deprecated Este metodo ha sido reemplazado por el metodo ingresaNotas().
     * Utilice #ingresaNotas() {@link #ingresaNotas()} en su lugar.
     */
    public void anteriorIngresaNotas() {
        System.out.println("Ingrese las notas del estudiante");
        // Sustituido por el metodo ingresaNotas()
    }

    /**
     * EL metodo principal de la clase Notas.
     * Este metodo es el punto de entrada del programa y controla el flujo del programa.
     * Crea una instancia de la clase Notas y llama a sus metodos en un orden especifico.
     *
     * @param args Un array de argumentos.
     */
    public static void main(String[] args) {
        Notas notas = new Notas();
        notas.ingresaNotas();
        notas.comprobacion();
        notas.calculoNotas();
        notas.mostrar();
        notas.aprobado();
    }
}