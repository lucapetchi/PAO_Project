package Bank.Service;
import Bank.Domain.*;

import javax.print.attribute.standard.MediaSize;

public class OtherService {

    public OtherService(){

    }

    public void nrClientiBanca(Banca banca){
        System.out.println(banca.getClientsNumber());
    }
    public void inscrie_client_banca(Banca banca,Cont c){
        banca.addCont(c);
    }
    public void afiseaza_clienti_banca(Banca banca){
        System.out.println(banca.getConturi());
    }
    public void efectueazaTranzactie(Cont c1,Cont c2,double suma){
        Tranzactie t= new Tranzactie(c1,c2,suma);
        t.AfisareTranzactie();
    }
    public void genereazaExtrasCont(Cont cont){
        ExtrasCont extras= new ExtrasCont(cont);
        extras.afiseazaExtrasCont();
    }
    public void vizualizareTipCard(Card card) {
        System.out.println(card.getTipCard());
    }


}
