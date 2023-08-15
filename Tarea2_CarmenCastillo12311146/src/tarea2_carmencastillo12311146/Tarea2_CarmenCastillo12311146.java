/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea2_carmencastillo12311146;

import java.util.Scanner;

/**
 *
 * @author casti
 */
public class Tarea2_CarmenCastillo12311146 {

    static Scanner sc = new Scanner(System.in, "ISO-8859-1");
    static Scanner leer = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguirmenu = true;
        while (seguirmenu) {
            System.out.println(" ");
            System.out.println("Menu");
            System.out.println("1. Replace.");
            System.out.println("2. Factorial.");
            System.out.println("3. Mensajes.");
            System.out.println("4. Promedios.");
            System.out.println("5. Aprobado o Reprobado.");
            System.out.println("6. Contains.");
            System.out.println("7. Salir.");
            System.out.print("Ingrese su opcion: ");
            int opcionmenu = leer.nextInt();
            System.out.println("");

            switch (opcionmenu) {
                case 1:
                    System.out.println("Opción 1 [Replace]");
                    System.out.print("Ingrese una palabra: ");
                    String pal = sc.nextLine();
                    System.out.print("Ingrese el caracter que quisiera reemplazar: ");
                    char oldcar = sc.next().charAt(0);
                    System.out.print("Ingrese el nuevo caracter: ");
                    char newcar = sc.next().charAt(0); //leer los dos caract

                    MetodoReplace(pal, oldcar, newcar); //llamar el metodo

                    break;

                case 2:
                    System.out.println("Opción 2 [Factorial]");
                    System.out.print("Ingrese un numero para encontrar su factorial: ");
                    int numfact = leer.nextInt();
                    while (numfact < 0) {
                        System.out.print("Por favor ingrese numeros positivos: ");
                        numfact = leer.nextInt();
                    }

                    EncontrarFactorial(numfact);

                    break;

                case 3:
                    System.out.println("Opción 3 [Mensajes]");
                    System.out.print("Ingrese su oración deseada: ");
                    String oracion = sc.nextLine();
                    ImprimirMensaje(oracion);

                    break;

                case 4:
                    System.out.println("Opción 4 [Promedios]");
                    PromedioNotas();

                    break;

                case 5:
                    System.out.println("Opción 5 [Aprobado o Reprobado]");
                    System.out.print("Ingrese su nota: ");
                    int nota = leer.nextInt();
                    boolean aprobado = AprobReprob(nota);
                    if (aprobado == true) {
                        System.out.println("Usted aprobó.");
                    } else {
                        System.out.println("Usted reprobó.");
                    }

                    break;

                case 6:
                    System.out.println("Opción 6 [Contains]");
                    System.out.print("Ingrese su primera palabra/cadena: ");
                    String cadpr = sc.nextLine();
                    System.out.print("Ingrese su segunda palabra/cadena: ");
                    String cadsec = sc.nextLine();

                    boolean contiene = MContains(cadpr, cadsec);

                    if (contiene == true) {
                        System.out.println("La cadena principal contiene la subcadena.");
                    } else {
                        System.out.println("La cadena principal no contiene la subcadena.");
                    }

                    break;

                default:
                    seguirmenu = false;
                    break;

            }

        }

    }

    public static String MetodoReplace(String palabra, char carviejo, char carnuevo) {
        boolean igual = false;
        for (int i = 1; i < palabra.length(); i++) { //recorrer la cadena
            char letra = palabra.charAt(i);
            if (carviejo == letra) {
                igual = true;
                break;
            }
        }
        while (igual == false) {
            System.out.println("Ël caracter no está.");
            System.out.print("Reingrese el caracter a reemplazar: ");
            carviejo = leer.next().charAt(0);
        }
        palabra = palabra.replace(carviejo, carnuevo);
        System.out.println("Su nueva palabra es: " + palabra);

        return palabra;
    }

    public static int EncontrarFactorial(int numero) {
        int factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i; //multiplicar el contador hasta que llegue al numero y acumularlo cada que se multiplique
        }

        System.out.println("El factorial de " + numero + " es " + factorial + ".");

        return factorial;

    }

    public static void ImprimirMensaje(String orac) {

        System.out.println("Su oración fue: [" + orac + "]"); //no retorna nada por ser un void

    }

    public static int PromedioNotas() {
        int acum = 0;
        for (int i = 1; i <= 4; i++) {
            System.out.print("Ingrese su nota numero " + i + ": ");
            int nota = leer.nextInt();
            acum += nota;
        }

        int promedio = acum / 4;
        System.out.println("El promedio de las cuatro notas fue: " + promedio);

        return promedio;

    }

    public static boolean AprobReprob(int not) {
        //boolean aprob = true;
        if (not >= 60) {
            return true; //retorna true si aprueba
        } else {
            return false;
        }

    }

    public static boolean MContains(String pr, String sec) {

        for (int i = 0; i <= pr.length() - sec.length(); i++) { //restarle a la cadena principal la segunda cadena para que no se desborde
            if (pr.substring(i, i + sec.length()).equals(sec)) { //Usar el substring para comparar
                return true;
            }
        }

        return false;

    }

}
