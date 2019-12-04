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
        for (int i = 0; i < 200 ; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aux = random();

            cuenta.ingresarDinero(aux, nombre);


            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aux = random();

            cuenta.sacarDinero(aux, nombre);


        }
    }
    private int random(){
        return ((int) (Math.random() * 500 + 1));
    }

}
