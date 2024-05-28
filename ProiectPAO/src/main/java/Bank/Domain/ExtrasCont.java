package Bank.Domain;

import java.util.HashSet;
import java.util.Set;

public class ExtrasCont {
    private int idExtras;
    private int idCont;
    private String numeDetinator;
    private double sold;

    private Set<Tranzactie> tranzactii;

    public ExtrasCont(int idCont, String numeDetinator, double sold){
        this.idExtras=idCont+100;
        this.idCont=idCont;
        this.numeDetinator=numeDetinator;
        this.sold=sold;
        this.tranzactii=new HashSet<Tranzactie>();
    }
    public ExtrasCont(Cont cont) {
       this.idExtras=cont.getId()+100;
       this.idCont=cont.getId();
       this.numeDetinator=cont.getNumeClient();
       this.sold=cont.getSold();
       this.tranzactii=new HashSet<Tranzactie>();
    }
    public void AddTransaction(Tranzactie tranzactie){
        this.tranzactii.add(tranzactie);
    }

    public void afiseazaExtrasCont() {
        System.out.println("Extras de cont pentru " + this.numeDetinator);
        System.out.println("ID Cont: " + this.idCont);
        System.out.println("Sold curent: " + this.sold);
        for(Tranzactie t : tranzactii){
            t.AfisareTranzactie();
        }
    }

    public double getSold() {
        return sold;
    }

    public String getNumeDetinator() {
        return numeDetinator;
    }

    public int getIdCont() {
        return idCont;
    }
}
