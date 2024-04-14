package Bank;

import java.util.Arrays;
import java.util.Random;

public class ContService {

    String[] names={"Ionescu","Georgescu","Popescu","Popa","Ion","George","Pascu","Calinescu","Calin","Culinescu","Radulescu","Ceausescu"};
    String[] fname={"Andrei","Andreea","Ionut","Ioana","Luca","Catalin","Catalina","Miruna","Alex","Alexandru","David","Corina"};
    private Cont[] conturi= new Cont[10];
    private Card[] carduri = new Card[10];

    public ContService(){
        initializeCont();
    }
    public String Random(String[] array){
        Random generator = new Random();
        int randomIndex = generator.nextInt(array.length);
        return array[randomIndex];
    }
    private void initializeCont(){
        for (int i = 0;i < conturi.length;i++){
            conturi[i]= new Cont(i+100,Random(names)+ " " + Random(fname));
            carduri[i]= new Card(conturi[i]);
        }
    }
    public void display(){
        System.out.println(Arrays.toString(conturi));
    }
    public Cont selectById(int id){
        return conturi[id-100];
    }
}
