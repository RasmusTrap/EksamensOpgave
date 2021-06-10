package com.example.demo.bootstrap;


import com.example.demo.model.Kommune;
import com.example.demo.repository.KommuneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final KommuneRepository kommuneRepository;


    public BootStrapData(KommuneRepository kommuneRepository){
        this.kommuneRepository = kommuneRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Kommune kommune = new Kommune();
        kommune.setKommuneNavn("København");
        kommune.setIndbyggere(1336982);

        Kommune kommune1 = new Kommune();
        kommune1.setKommuneNavn("Aarhus");
        kommune1.setIndbyggere(282910);

        Kommune kommune2 = new Kommune();
        kommune2.setKommuneNavn("Aalborg");
        kommune2.setIndbyggere(111219);

        Kommune kommune3 = new Kommune();
        kommune3.setKommuneNavn("Odense");
        kommune3.setIndbyggere(180760);

        Kommune kommune4 = new Kommune();
        kommune4.setKommuneNavn("Vejle");
        kommune4.setIndbyggere(58777);

        Kommune kommune5 = new Kommune();
        kommune5.setKommuneNavn("Esbjerg");
        kommune5.setIndbyggere(72044);

        Kommune kommune6 = new Kommune();
        kommune6.setKommuneNavn("Frederiksberg");
        kommune6.setIndbyggere(53532);

        Kommune kommune7 = new Kommune();
        kommune7.setKommuneNavn("Randers");
        kommune7.setIndbyggere(62623);

        Kommune kommune8 = new Kommune();
        kommune8.setKommuneNavn("Viborg");
        kommune8.setIndbyggere(43912);

        Kommune kommune9 = new Kommune();
        kommune9.setKommuneNavn("Silkeborg");
        kommune9.setIndbyggere(34132);

        kommuneRepository.save(kommune);
        kommuneRepository.save(kommune1);
        kommuneRepository.save(kommune2);
        kommuneRepository.save(kommune3);
        kommuneRepository.save(kommune4);
        kommuneRepository.save(kommune5);
        kommuneRepository.save(kommune6);
        kommuneRepository.save(kommune7);
        kommuneRepository.save(kommune8);
        kommuneRepository.save(kommune9);
    }
}
