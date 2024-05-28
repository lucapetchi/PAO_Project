package Bank.Service;

import Bank.Domain.Card;
import Bank.Domain.Cont;
import Bank.Repository.CardRepository;
import Bank.Repository.ContRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class ContService {

    String[] names = {"Ionescu", "Georgescu", "Popescu", "Popa", "Ion", "George", "Pascu", "Calinescu", "Calin", "Culinescu", "Radulescu", "Ceausescu"};
    String[] fname = {"Andrei", "Andreea", "Ionut", "Ioana", "Luca", "Catalin", "Catalina", "Miruna", "Alex", "Alexandru", "David", "Corina"};

    ContRepository contRepository = new ContRepository();
    CardRepository cardRepository = new CardRepository();

    public ContService() {
        initializeCont();
    }

    public String Random(String[] array) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(array.length);
        return array[randomIndex];
    }

    private void initializeCont() {

        for (int i = 0; i <10; i++) {
            try {
                Cont contul = new Cont(i, Random(names) + " " + Random(fname));
                contRepository.insert(contul);
                //cardRepository.insert(new Card(contul));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void depuneNumerar(int idCont, double suma) {
        contRepository.updateSold(suma, idCont);
    }
    public void retrageNumerar(int idCont, double suma) {
        contRepository.updateSold(suma*-1, idCont);
    }
    public void addCont(Cont cont){
        contRepository.insert(cont);
    }
    public void display(int id){
        System.out.println(contRepository.getById(id));
    }
    public void displayAll(){
        System.out.println(contRepository.getAll());

    }
    public void deleteAll(){
        //cardRepository.deleteAll();
        contRepository.deleteAll();
    }
    public void delete(String nume){
        contRepository.delete(nume);
    }
}

