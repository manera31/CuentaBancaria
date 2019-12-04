public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(2000, 4000);
        Persona persona1 = new Persona("Persona 1", cuenta);
        Persona persona2 = new Persona("Persona 2", cuenta);
        persona1.start();
        persona2.start();
    }
}
