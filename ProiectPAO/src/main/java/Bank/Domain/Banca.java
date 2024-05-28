package Bank.Domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Banca {

    private String nume;

    protected List<Cont> conturi=new ArrayList<>();
    protected List<Atm> atms= new ArrayList<>();

    public Banca(String nume){
        this.nume=nume;
        this.atms=new ArrayList<>();
        this.conturi=new ArrayList<>();
    }

    public int getClientsNumber(){
        return this.conturi.size();
    }
    public void addAtm(Atm a){
        this.atms.add(a);
    }
    public void addCont(Cont c){
        this.conturi.add(c);
        this.conturi.sort(Comparator.comparing(Int->c.getId()));
    }
    public List<Atm> getAtms() {
        return atms;
    }

    public void setAtms(List<Atm> atms) {
        this.atms = atms;
    }

    public List<Cont> getConturi() {
        return conturi;
    }

    public void setConturi(List<Cont> conturi) {
        this.conturi = conturi;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
