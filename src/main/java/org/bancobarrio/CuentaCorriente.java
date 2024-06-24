package org.bancobarrio;

public class CuentaCorriente extends Cuenta {
    // Atributo para almacenar el valor del sobregiro
    private float sobregiro;
    private int numConsignacion = 0;
    private int numRetiro = 0;
    private float comisionMensual=0;

    // Constructor de la clase CuentaCorriente
    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa); // Llama al constructor de la clase padre (Cuenta)
        sobregiro = 0; // Inicializa el sobregiro en 0 al crear una nueva cuenta corriente
    }

    // Método para realizar un retiro de la cuenta corriente
    public void retirar(float cantidad) {
        if (cantidad > saldo) {
            // Si la cantidad a retirar es mayor que el saldo disponible,
            // se calcula y se añade al sobregiro la cantidad que se excede
            sobregiro += cantidad - saldo;
            // Se retira el saldo disponible
            super.retirar(saldo);
        } else {
            // Si la cantidad a retirar es menor o igual al saldo disponible,
            // se realiza el retiro normalmente
            super.retirar(cantidad);
        }
    }

    // Método para realizar un depósito en la cuenta corriente
    public void depositar(float cantidad) {
        super.depositar(cantidad); // Se invoca al método de la clase padre para depositar
        // Si hay un sobregiro pendiente
        if (sobregiro > 0) {
            // Se verifica si la cantidad depositada es suficiente para reducir el sobregiro
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro; // Se reduce el sobregiro
                sobregiro = 0; // Se establece el sobregiro en 0
            } else {
                sobregiro -= cantidad; // Se reduce el sobregiro por la cantidad depositada
                cantidad = 0; // No hay cantidad para reducir el saldo
            }
            super.retirar(cantidad); // Se actualiza el saldo de la cuenta después de reducir el sobregiro
        }
    }

    public void setComisionMensual() {
        // Definir la comisión base mensual
        float comisionBase = 5.0f;

        // Determinar si se aplican comisiones adicionales basadas en el número de transacciones
        int numeroTransacciones = numConsignacion + numRetiro;
        float comisionPorTransacciones = 0.0f;
        if (numeroTransacciones > 10) {
            comisionPorTransacciones = (numeroTransacciones - 10) * 1.0f; // Se cobra 1 unidad de comisión por cada transacción adicional después de las primeras 10
        }

        // Calcular la comisión total sumando la comisión base y la comisión por transacciones adicionales
        comisionMensual = comisionBase + comisionPorTransacciones;
    }

    // Método para obtener el número total de transacciones
    public int getNumeroTransacciones() {
        return numConsignacion + numRetiro;
    }

    // Método para imprimir información sobre la cuenta corriente
    public void imprimir() {
        // Se muestra el saldo de la cuenta
        System.out.println("Saldo de la cuenta: " + saldo);
        // Se muestra el número total de transacciones realizadas
        System.out.println("Número de transacciones realizadas: " + getNumeroTransacciones());
        // Se muestra el valor del sobregiro actual
        System.out.println("Valor de sobregiro: " + sobregiro);
    }

    // Se muestra la comisión mensual calculada
    public void impComisionMensual() {
        setComisionMensual(); // Actualiza el valor de la comisión mensual
        System.out.println("Comisión mensual: " + comisionMensual);
    }

}