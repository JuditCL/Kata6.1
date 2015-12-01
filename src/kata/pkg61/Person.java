package kata.pkg61;
public class Person {
    private final int ID;
    private final String name;
    private final String Mail;
    private final float peso;
    private final String genero;

    public Person(int ID, String name, String Mail, float peso, String genero) {
        this.ID = ID;
        this.name = name;
        this.Mail = Mail;
        this.peso = peso;
        this.genero = genero;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return Mail;
    }

    public float getPeso() {
        return peso;
    }

    public String getGenero() {
        return genero;
    }

    
    
}
