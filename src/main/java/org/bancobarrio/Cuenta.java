package org.bancobarrio;
/*
 *programadores
        JOSUE SALAZAR
        STEVEN TANQUINO
 */

/*
 *Esta clase se denomina cuenta modelada una cuenta bancaria con los
 *atributos: saldo, numero de consignaciones, numeros de retiros,tasa anual de interes y
 *comision mensual
 **/

import org.w3c.dom.ls.LSOutput;

public class Cuenta {
    //Atributo que define el sueldo
    //de una cuenta bancaria

    public float saldo;
    //Atributo que define el numero
    //de consignaciones realizadas en una
    //cuenta bancaria

    public int numConsignacion = 0;
    /*Atributo que define el numero de retiros
    de una cuenta bancaria*/

    public int numRetiro = 0;
    /*Atributos que define la tasa anual de intereses
    de una cuenta bancaria*/

    public float tasaAnual;
    /*Atributo que define la comision
    mensual que se cobra a una cuenta bancaria*/

    public float comisionMensual = 0;

    /*Constructor de la clase cuenta
     * @param salado parametro que define el saldo de la cuenta
     * @param tasaAnual parametro que define la tasa anual
     * de interes de la cuenta
     **/

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    /*
     * Metodo que recibe una cantidad de dinero a
     * depositar y actualiza el saldo de la cuenta
     * @Param saldo parametro que define la cantidad
     * de dinero a depositar en la cuenta*/
    public void depositar(float cantidad) {
        /*Se actualiza el saldo con la cantidad
         * depostada*/
        saldo += cantidad;
        /*Se actualiza el numero de depositos realizadas
        a la cuenta*/
        numConsignacion = numConsignacion + 1;

    }

    /*retirar una cantidad de dinero
    en al cuenta actualizando su saldo ;
    el valor a retirar no debe superar el saldo

    METODO QUE RECIBE UN PARAMETRO
    QUE RECIBE UNA CANTIDAD A RETIRAR Y ACTUALIZA EL SALDO DE LA
    CUENTA
     PARAMETRO SALDO que defina la cantidad de dinero a retirar

     */

    public void retirar(float cantidad) {
        /*
         para poder realizar el retiro
         *  realiza el numero de retiro menos la
         * cantidad (saldo) */
        float nuevosaldo=saldo-cantidad;
        /*comparo si la cantidad a retirar es mas alto
        * que el saldo no se puede retirar  cuenta ahorros */

        if ( nuevosaldo>=0) {
            saldo -= cantidad;
            numRetiro += 1;
        }
        else{
            System.out.println("NO SE PUEDE RETIRAR EL VALOR");
            System.out.println("YA QUE SUPERA EL SALDO DE SU CUENTA");
            System.out.println("SU SALDO ES: " + saldo);
        }
    }

    /*calcular el interes mensual de la cuenta y actualiza
    el saldo correspondiente
    * */

    // no recibo ningun parametro ya que mi tasa anual ya tengo determinada en mi contructor
    public void calcularInteres (){
        /*convertimos la tasa anual a tasa mensual*/
        float tasamensual = tasaAnual/12;
        /*convertimos  a dinero el interes*/
        float interesmensual=saldo*tasamensual;
        /*actualizamos el saldo aplicando el interes*/
         saldo+=interesmensual;
         System.out.println("SU INTERES MENSUAL ES DE: "+ interesmensual + " %");
    }

    /*extracto mensual
    actualiza el saldo restando la comision mensual
    y calculando el interes mensual  correspondiente
    utilizando el metodo anterior(calcular interes)*/

    public void extractoMensual ()
    {
       saldo-=comisionMensual;
       /*LLAMO AL METODO CALCULAR INTERES */
       calcularInteres();
    }


}
