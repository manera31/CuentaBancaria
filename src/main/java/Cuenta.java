public class Cuenta {
    private double saldo;
    private double maxSaldo;


    public Cuenta(double saldo, double maxSaldo) {
        this.saldo = saldo;
        this.maxSaldo = maxSaldo;
    }

    public synchronized void ingresarDinero(double dineroAIngresar, String nombre){
        while ((saldo + dineroAIngresar) > maxSaldo) {
            System.out.println(nombre + " cantidad a ingresar " + dineroAIngresar + " saldo: " + saldo);
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if((saldo + dineroAIngresar) > maxSaldo){
            System.out.println(nombre + " intenta sumar. Se ha alcanzado el maximo. Intento de suma " + dineroAIngresar + " (" + (saldo+dineroAIngresar) + ")");

        } else {
            System.out.print(nombre + ", Saldo: " + saldo + " + " + dineroAIngresar + " = ");
            saldo += dineroAIngresar;
            System.out.println(saldo);
        }
        notifyAll();
    }

    public synchronized void sacarDinero(double cantidadASacar, String nombre){
        while ((saldo - cantidadASacar) < 0) {
            System.out.println(nombre + " cantidad a sacar " + cantidadASacar + " saldo: " + saldo);
            try {
                wait(); }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if((saldo - cantidadASacar) < 0){
            System.out.println(nombre + " intenta restar. Se ha alcanzado el minimo. Intento de resta " + cantidadASacar+ " (" + (saldo+cantidadASacar) + ")");
        }else {
            System.out.print(nombre + ", Saldo: " + saldo + " - " + cantidadASacar + " = ");
            saldo -= cantidadASacar;
            System.out.println(saldo);
        }
        notifyAll();
    }
}
