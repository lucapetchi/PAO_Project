package Bank.Domain;

public class Atm {

    private String adresa;
    protected Double sold;

    public Atm(String adresa){
        this.adresa=adresa;
        this.sold=10000.0;
    }
    public Atm(String adresa,double sold){
        this.adresa=adresa;
        this.sold=sold;
    }
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }
}
