package practica1;

/**
*
* Clase EntradaNoNumericaException
*
* La clase 'EntradaNoNumericaException' extiende la clase Exception.
* Esta excepción personalizada se lanza cuando se encuentra una entrada no numérica.
*
* @author Antonio Rodriguez
* @version 1.0.0
* @since 28/03/2024
*
* @see Notas
*
*/
public class EntradaNoNumericaException extends Exception {

/**
 * Constructor de la clase 'EntradaNoNumericaException'.
 * Toma un mensaje como argumento y lo pasa al constructor de la superclase.
 *
 * @param mensaje El mensaje que se muestra cuando se lanza la excepción.
 * 
 */
 public EntradaNoNumericaException(String mensaje) {
     super(mensaje);
 }
}