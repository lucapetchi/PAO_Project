package Bank;

public class ContPremium extends Cont{
    private boolean premium;
    public ContPremium(int id, String nume) {
        super(id, nume);
        this.premium=true;

    }
    @Override
    public void retrageNumerar(double suma) {
        double s=getSold();
        if (s >= suma ) {
            s =s-suma;
            System.out.println("Retragere efectuata cu succes, comision 0=");
            setSold(s);
        } else {
            System.out.println("Fonduri insuficiente!");
        }

    }
}
