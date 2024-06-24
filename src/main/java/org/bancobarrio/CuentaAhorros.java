package org.bancobarrio;

/*programadores
  JOSUE SALAZAR
  STEVEN TANQUINO
*
    Es mi subclase cuenta TIENE UN NUEVO ATRIBUTO SI LA CUENTA ESTA ACTIVA
    O ESTA DESACTIVADA*/
public class CuentaAhorros extends Cuenta {
    /*ATRIBUTOS QUE IDENTIFICA SI LA CUENTA ESTA ACTIVA SI SU SALDO
     * ES SUPERIOR A 10  BOOLEANO*/
    /* atributo booleno es true o false*/
    private boolean activo;
    // Incrementa el contador de transacciones
    private int totTransacciones = 0;

    /*CONTRUCTOR DE LA CLASE CUENTA AHORROS
     * RECIBE:
     * SALDO parametro que define el saldo de la cuenta ahorros
     * TASA ANUAL parametro que define la tasa anual de interes de cuenta ahorros */

    public CuentaAhorros(float saldo, float tasa) {
        /*super es aquel que permite recibir los datos de contructor*/
        super(saldo, tasa);
        if (saldo <= 10) {
            /*LA CUENTA ESTA DESACTIVADA*/
            activo = false;
            System.out.println("SU CUENTA ESTA INACTIVA");
        } else {
            /*LA CUENTA ESTA ACTIVADA*/
            activo = true;


        }
    }

        /*estratacto mensual
        si el nomero de retiros es mayor que 4 por cada retiro adicional
        se cobrara 1 dolar comision mensual al generar el extrato , se determina si
        la cuenta esta activa o no con el saldo

        metodo que recibe na cantidad de dinero a retirar
        y actualizar el saldo de la cuenta  PARAMETRO saldo
        parametroq eu define la cantidad a retirar de una cuenta ahorros*/


    public void retirar(float cantidad) {
        if (activo)
            /*invocamos al metodo retirar la clase padre*/
            super.retirar(cantidad);
        // Incrementa el contador de transacciones
            totTransacciones++;
    }

    // Método para consignar dinero en la cuenta de ahorros
    public void depositar(float cantidad) {
        // Solo se puede consignar si la cuenta está activa
        if (activo) {
            super.depositar(cantidad); // Invocar al método heredado de la clase padre
            totTransacciones++;
        } else {
            System.out.println("No es posible consignar, la cuenta está inactiva.");
        }
    }

    public float calcularComisionMensual() {
        // Comisión base mensual
        float comisionMensual = 0;

        // Verificar si se debe aplicar una comisión adicional por inactividad
        if (!activo) {
            comisionMensual += 5; // Suponiendo una comisión base de $5 por inactividad
        }

        return comisionMensual;
    }

    /* metodo para imprimir el numero de transacciones*/
    public void impNumTransacciones() {
        System.out.println("Número total de transacciones realizadas: " + totTransacciones);
    }

    /* metodo para imprimir*/
    public void imprimir() {
        System.out.println("Saldo de la cuenta: " + saldo);
        System.out.println("Comisión mensual: " + calcularComisionMensual());
    }


}
