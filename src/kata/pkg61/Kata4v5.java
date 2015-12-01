package kata.pkg61;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Kata4v5 {

    public static void main(String[] args) throws FileNotFoundException,IOException, ClassNotFoundException, SQLException {
        ArrayList <Person> people = MailReader.read();
        HistogramBuilder builder = new HistogramBuilder<>(people);
        Histogram<String> domains = builder.build(new Attribute<Person,String>(){
            @Override
            public String get (Person person){
                return person.getMail().split("@")[1];
            }
        });
        HistogramDisplay histoDisplay = new HistogramDisplay(domains);
        histoDisplay.execute();
        Histogram<Float> histoPesos = builder.build(new Attribute<Person,Float>(){
            @Override
            public Float get (Person person){
                return person.getPeso();
            }
        });
        HistogramDisplay histoDisplay1 = new HistogramDisplay(histoPesos);
        histoDisplay1.execute();
        Histogram<String> histoGenero = builder.build(new Attribute<Person,String>(){
            @Override
            public String get (Person person){
                return person.getGenero();
            }
        });
        HistogramDisplay histoDisplay2 = new HistogramDisplay(histoGenero);
        histoDisplay2.execute();
        
        Histogram<Character> histoCaracteres = builder.build(new Attribute<Person,Character>(){
            @Override
            public Character get (Person person){
                return person.getMail().charAt(0);
            }
        });
        HistogramDisplay histoDisplay3 = new HistogramDisplay(histoCaracteres);
        histoDisplay3.execute();
    }
}