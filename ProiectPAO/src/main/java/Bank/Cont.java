package Bank;

public class Cont {
    protected int id;
    protected String numeClient;
    protected double sold;

    protected Card card;
    protected ExtrasCont extrasCont;

    public Cont(int id,String nume){
        this.id=id;
        this.numeClient=nume;
        this.sold=0.0;
        System.out.println("S-a creeat un cont nou pentru clientul "+ nume);
        this.extrasCont= new ExtrasCont(id,nume,0.0);
        this.card=new Card(this.id);

    }
    public void depuneNumerar(double suma) {
        this.sold += suma;
    }
    public void retrageNumerar(double suma) {
        if (this.sold >= suma + 0.01*suma) {
            this.sold =this.sold-suma-0.01*suma;
            System.out.println("Retragere efectuata cu succes, comision 1%="+0.01*suma);
        } else {
            System.out.println("Fonduri insuficiente!");
        }

    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }
    @Override
    public String toString(){
        return "Cont:" +
                "Nume: " + numeClient + '\'' + "Id: " + id + '\'' + "Sold: " + sold + "\'";
    }
}

