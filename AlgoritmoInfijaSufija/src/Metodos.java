//Hecho por: Andrés López Corrales
import java.util.Stack;

public class Metodos {

    //Método para saber que es un operando
    public boolean esOperando (char character){
        boolean siEs = false;
        if (character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z'){
            siEs = true;
        }

        return siEs;
    }//end esOperando

    //Método para saber que operador tiene mayor prioridad
    public int operadores (char character){

        if (character == '+' || character == '-') {
            return 2;
        }
        if (character == '*' || character == '/') {
            return 1;
        }
        return Integer.MAX_VALUE;
    }//end Operadores

    //Convertir operación infija a sufija
    public String toPosfijo(String infija) {
        char aperParentesis = '('; //Parentesis Apertura
        char cierreParentesis = ')'; //Parentesis Cierre
        String operacionPosfija = "";
        Stack<Character> stack = new Stack<>(); //Pila

        for (char character : infija.toCharArray()) {
            if (character == aperParentesis) { //Identificar si hay un parentesis de apertura
                stack.push(character);
            } else if (character == cierreParentesis) { //Identificar un parentesis de cierre
                while (stack.peek() != aperParentesis) {
                    operacionPosfija += (stack.pop());
                }
                stack.pop();
            } else if (esOperando(character)) { //Identificar si es un operando
                operacionPosfija += character;
            } else {
                //Identificar operadores de mayor/menor importancia
                while (!stack.isEmpty() && operadores(character) >= operadores(stack.peek())) {
                    operacionPosfija += stack.pop();
                }
                stack.push(character);
            }
        }

        while (!stack.isEmpty()) { //Lo que queda, ponerlo hasta el final de la expresión sufija
            operacionPosfija += stack.pop();
        }

        return operacionPosfija; //Regresar operación sufija

    }//end toPosfijo

}//end Metodos
