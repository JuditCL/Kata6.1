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
    }
}