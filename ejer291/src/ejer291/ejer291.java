package ejer291;

import java.util.Scanner;

public class ejer291 {
	/*2.Simulador de Cajero Automático
   -Pasos:
     1. Crea estructuras para almacenar la información de las cuentas (por ejemplo, usando arrays para IDs, contraseñas y saldos).
     2. Implementa un sistema de login que pida al usuario su ID y contraseña y verifique estos datos.
     3. Una vez autenticado, muestra un menú con opciones como retirar, depositar y ver saldo.
     4. Para cada opción, realiza las operaciones correspondientes (actualizar saldo, mostrar información, etc.).
     5. Asegúrate de validar las entradas del usuario (por ejemplo, no permitir retirar más dinero del disponible en la cuenta).*/
	static int[] ids = {1, 2, 3};
    static String[] contrasenas = {"Adrian", "Guerrero", "Ortega"};
    static double[] saldos = {1000.0, 2000.0, 3000.0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id;
        String contrasena;
        do {
            System.out.print("Ingresa el id: ");
            id = scanner.nextInt();
            System.out.print("Ingresa la contraseña: ");
            contrasena = scanner.next();
        } while (!login(id, contrasena));
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Selecciona la opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
            /*retirar*/    
            case 1:
                    System.out.print("¿Cuanto quieres retirar?: ");
                    double cantidadRetiro = scanner.nextDouble();
                    retirar(id, cantidadRetiro);
                    break;
            /*depositar*/    
            case 2:
                    System.out.print("¿Cuanto quieres depositar?: ");
                    double cantidadDeposito = scanner.nextDouble();
                    depositar(id, cantidadDeposito);
                    break;              
            /*ver saldo*/
            case 3:
                    verSaldo(id);
                    break;
            /*salir*/
            case 4:
                    System.out.println("Gracias");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
        scanner.close();
    }
    /*Para */
    static boolean login(int id, String contrasena) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id && contrasenas[i].equals(contrasena)) {
                System.out.println("Has iniciado sesion");
                return true;
            }
        }
        System.out.println("Id/Contraseña incorrectas");
        return false;
    }
    /*El menu para ubicarte*/
    static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Retirar dinero");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Ver saldo");
        System.out.println("4. Salir");
    }
    /*Para retirar*/
    static void retirar(int id, double cantidad) {
        int index = getIndexById(id);
        if (index != -1) {
            if (cantidad > 0 && cantidad <= saldos[index]) {
                saldos[index] -= cantidad;
                System.out.println("Retirado, Nuevo saldo: $" + saldos[index]);
            } else {
                System.out.println("Cantidad no válida o no tienes dinero");
            }
        } else {
            System.out.println("ID incorrecto.");
        }
    }
    /*Para depositar*/
    static void depositar(int id, double cantidad) {
        int index = getIndexById(id);
        if (index != -1) {
            if (cantidad > 0) {
                saldos[index] += cantidad;
                System.out.println("Depositado. Nuevo saldo: $" + saldos[index]);
            } else {
                System.out.println("Cantidad no válida.");
            }
        } else {
            System.out.println("ID incorrecto.");
        }
    }
    /*Para ver el saldo*/
    static void verSaldo(int id) {
        int index = getIndexById(id);
        if (index != -1) {
            System.out.println("Saldo disponible: $" + saldos[index]);
        } else {
            System.out.println("ID incorrecto");
        }
    }
    static int getIndexById(int id) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id) {
                return i;
            }
        }
        return -1;
    }
    }
