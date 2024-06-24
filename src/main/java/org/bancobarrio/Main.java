package org.bancobarrio;
import java.util.Scanner;
/*programadores
  JOSUE SALAZAR
  STEVEN TANQUINO*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una cuenta de ahorros
        System.out.println("Ingrese el saldo inicial de la cuenta de ahorros:");
        float saldoAhorros = scanner.nextFloat();
        System.out.println("Ingrese la tasa anual de interés para la cuenta de ahorros:");
        float tasaAhorros = scanner.nextFloat();
        CuentaAhorros cuentaAhorros = new CuentaAhorros(saldoAhorros, tasaAhorros);

        // Crear una cuenta corriente
        System.out.println("Ingrese el saldo inicial de la cuenta corriente:");
        float saldoCorriente = scanner.nextFloat();
        System.out.println("Ingrese la tasa anual de interés para la cuenta corriente:");
        float tasaCorriente = scanner.nextFloat();
        CuentaCorriente cuentaCorriente = new CuentaCorriente(saldoCorriente, tasaCorriente);

        // Menú de opciones
        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Realizar depósito en cuenta de ahorros");
            System.out.println("2. Realizar retiro en cuenta de ahorros");
            System.out.println("3. Realizar depósito en cuenta corriente");
            System.out.println("4. Realizar retiro en cuenta corriente");
            System.out.println("5. Imprimir extracto mensual de cuentas");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad a depositar en la cuenta de ahorros:");
                    float depositoAhorros = scanner.nextFloat();
                    cuentaAhorros.depositar(depositoAhorros);
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad a retirar de la cuenta de ahorros:");
                    float retiroAhorros = scanner.nextFloat();
                    cuentaAhorros.retirar(retiroAhorros);
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad a depositar en la cuenta corriente:");
                    float depositoCorriente = scanner.nextFloat();
                    cuentaCorriente.depositar(depositoCorriente);
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad a retirar de la cuenta corriente:");
                    float retiroCorriente = scanner.nextFloat();
                    cuentaCorriente.retirar(retiroCorriente);
                    break;
                case 5:
                    System.out.println("\n--- Extracto mensual de cuentas ---");
                    System.out.println("Cuenta de ahorros:");
                    cuentaAhorros.extractoMensual();
                    cuentaAhorros.imprimir();
                    cuentaAhorros.impNumTransacciones();
                    System.out.println("\nCuenta corriente:");
                    cuentaCorriente.extractoMensual();
                    cuentaCorriente.imprimir();
                    cuentaCorriente.impComisionMensual();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}