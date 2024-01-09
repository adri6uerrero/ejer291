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
    static String[] contrasenas = {"1234", "5678", "abcd"};
    static double[] saldos = {1000.0, 2000.0, 3000.0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id;
        String contrasena;
        do {
            System.out.print("Ingrese su ID: ");
            id = scanner.nextInt();
            System.out.print("Ingrese su contraseña: ");
            contrasena = scanner.next();
        } while (!login(id, contrasena));
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    retirar(id, cantidadRetiro);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    depositar(id, cantidadDeposito);
                    break;
                case 3:
                    verSaldo(id);
                    break;
                case 4:
                    System.out.println("Gracias por utilizar nuestro cajero automático. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
    static boolean login(int id, String contrasena) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id && contrasenas[i].equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
                return true;
            }
        }
        System.out.println("Credenciales incorrectas. Por favor, inténtelo nuevamente.");
        return false;
    }
    static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Retirar dinero");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Ver saldo");
        System.out.println("4. Salir");
    }
    static void retirar(int id, double cantidad) {
        int index = getIndexById(id);
        if (index != -1) {
            if (cantidad > 0 && cantidad <= saldos[index]) {
                saldos[index] -= cantidad;
                System.out.println("Retiro exitoso. Nuevo saldo: $" + saldos[index]);
            } else {
                System.out.println("Cantidad no válida o fondos insuficientes.");
            }
        } else {
            System.out.println("ID de cuenta no encontrado.");
        }
    }
    static void depositar(int id, double cantidad) {
        int index = getIndexById(id);
        if (index != -1) {
            if (cantidad > 0) {
                saldos[index] += cantidad;
                System.out.println("Depósito exitoso. Nuevo saldo: $" + saldos[index]);
            } else {
                System.out.println("Cantidad no válida.");
            }
        } else {
            System.out.println("ID de cuenta no encontrado.");
        }
    }
    static void verSaldo(int id) {
        int index = getIndexById(id);
        if (index != -1) {
            System.out.println("Saldo actual: $" + saldos[index]);
        } else {
            System.out.println("ID de cuenta no encontrado.");
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
