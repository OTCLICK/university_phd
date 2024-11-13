package org.example.university_phd.runner;

import com.github.javafaker.Faker;
import org.example.university_phd.model.University;
import org.example.university_phd.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class GenerateUniversities implements CommandLineRunner {

    public static final int LIST_SIZE = 1000;

    Faker faker = new Faker();

    @Autowired
    private UniversityService universityService;

    @Override
    public void run(String... args) throws Exception {
        universityService.saveAllUniversities(generateUniversities());
    }

    List<String> types = List.of("institute", "academy", "university");
    List<String> departments = List.of("VM", "F", "VPPiPO", "EVT", "DOMK", "ENiTURiTS", "ADAOiF", "TTiM", "ATSnaZT", "EET",
            "BAPPiBT", "CTUTP", "ISCE", "ETiUCR", "ASiIT", "E", "VMEN", "EE", "KiSE", "UPiPD", "I", "S", "MB", "PSEiGS", "TTMiRPS",
            "LiUTS", "STSEO", "KBiSP", "TB", "TPiOTD");
    Random random = new Random();
    int randomNumber = random.nextInt(8, 15);

    public <T> T oneOf(List<T> list) {
        return list.get(faker.random().nextInt(list.size()));
    }

    public List<String> manyOf(List<String> list) {
        List<String> list1 = new ArrayList<>();       //[faker.random().nextInt(list.size())];
        for (int i = 0; i < randomNumber; i++) {
            list1.add(list.get(faker.random().nextInt(list.size())));
        }
        randomNumber = random.nextInt(3, 10);
        return list1;
    }

    private List<University> generateUniversities() throws ParseException {
        List<University> universities = new ArrayList<>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; i++) {
            universities.add(new University(
                    faker.university().name(),
                    oneOf(types),
                    manyOf(departments),
                    faker.number().numberBetween(1, 60),
                    faker.number().numberBetween(2000, 55000),
                    faker.phoneNumber().phoneNumber()
            ));
        }
        return universities;
    }
}
