package Bank.Domain;

import Bank.Domain.Cont;

public class Tranzactie {
    Cont sursa;
    Cont destinatie;
    private int idTranzactie;
    private double suma;

    static int i= 0;


    public Tranzactie(Cont sursa, Cont destinatie, double suma) {
        this.sursa=sursa;
        this.destinatie=destinatie;
        double soldSursa=sursa.getSold();
        double soldDestinatie=destinatie.getSold();
        this.idTranzactie = i;
        i=i+1;
        this.suma = suma;
        if(soldSursa >= suma){
            sursa.setSold(soldSursa-suma);
            destinatie.setSold(soldDestinatie+suma);
            System.out.println("Tranzactie efectuata cu succes");
        }
        else{
            System.out.println("Fonduri insuficiente pentru tranzactie");
        }
        sursa.extrasCont.AddTransaction(this);
        destinatie.extrasCont.AddTransaction(this);


    }

    public Tranzactie(int id, double suma) {
        this.sursa=null;
        this.destinatie=null;
        this.idTranzactie=id;
        this.suma=suma;
    }

    public void AfisareTranzactie(){
        System.out.println("Tranzactie in valoare de " + suma + " sursa: " + sursa.getNumeClient() + " destinatar: " + destinatie.getNumeClient() );
    }

    public double getSuma() {
        return suma;
    }
}
