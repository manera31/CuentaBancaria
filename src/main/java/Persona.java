public class Persona extends Thread {
    private String nombre;
    private Cuenta cuenta;
    private int random;

    public Persona(String nombre, double saldo, double maxSaldo){
        this.nombre = nombre;
        cuenta = new Cuenta(saldo, maxSaldo);
    }

    public void run(){
        random = ((int) (Math.random()*500+1));
        cuenta.ingresarDinero(random);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        random = ((int) (Math.random()*500+1));
        cuenta.sacarDinero(random);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        random = ((int) (Math.random()*500+1));
        cuenta.ingresarDinero(random);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        random = ((int) (Math.random()*500+1));
        cuenta.sacarDinero(random);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
