public class Cuenta {
    private double saldo;
    private double maxSaldo;
    private boolean disponible;


    public Cuenta(double saldo, double maxSaldo) {
        this.saldo = saldo;
        this.maxSaldo = maxSaldo;
        disponible = false;
    }

    public synchronized boolean ingresarDinero(double dineroAIngresar){
        while (disponible == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = true;
        notifyAll();
        if((saldo + dineroAIngresar) > maxSaldo){
            return false;
        } else {
            saldo += dineroAIngresar;
            return true;
        }
    }

    public synchronized boolean sacarDinero(double cantidadASacar){
        while (disponible == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false;
        notifyAll();
        if((saldo - cantidadASacar) < 0){
            return false;
        }else {
            saldo -= cantidadASacar;
            return true;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
