public class Persona extends Thread {
    private String nombre;
    private Cuenta cuenta;
    private boolean error;

    public Persona(String nombre, Cuenta cuenta){
        this.nombre = nombre;
        this.cuenta = cuenta;
        error = false;
    }

    public void run(){
        int aux;
        while (!error) {
            aux = random();
            if(!cuenta.ingresarDinero(aux))
                error = true;
            System.out.println(nombre + ", Saldo: "+cuenta.getSaldo() + " + " +aux);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            aux = random();
            if(!cuenta.sacarDinero(aux))
                error = true;
            System.out.println(nombre + ", Saldo: "+cuenta.getSaldo() + " - " +aux);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*if(!cuenta.ingresarDinero(random()))
                error = true;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!cuenta.sacarDinero(random()))
                error = true;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
    private int random(){
        return ((int) (Math.random() * 500 + 1));
    }

}
