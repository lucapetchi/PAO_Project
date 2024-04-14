package Bank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtrasCont {
    private int idCont;
    private String numeDetinator;
    private double sold;

    private Set<Tranzactie> tranzactii;

    public ExtrasCont(int idCont, String numeDetinator, double sold){
        this.idCont=idCont;
        this.numeDetinator=numeDetinator;
        this.sold=sold;
        this.tranzactii=new HashSet<Tranzactie>();
    }
    public ExtrasCont(Cont cont) {
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

}
