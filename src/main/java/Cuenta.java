public class Cuenta {
    private double saldo;
    private double maxSaldo;

    public Cuenta(double saldo, double maxSaldo) {
        this.saldo = saldo;
        this.maxSaldo = maxSaldo;
    }

    public synchronized boolean ingresarDinero(double dineroAIngresar){
        if((saldo + dineroAIngresar) > maxSaldo){
            return false;
        } else {
            saldo += dineroAIngresar;
            return true;
        }
    }

    public synchronized boolean sacarDinero(double cantidadASacar){
        if((saldo - cantidadASacar) < 0){
            return false;
        }else {
            saldo -= cantidadASacar;
            return true;
        }
    }
}
