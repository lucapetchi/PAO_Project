package Bank;

public class Card {
    private int idCard;
    private int idCont;
    private boolean blocat;

    private String tipCard;
    private static int i =1000;


    public Card(int id) {
        this.idCard = i;
        i++;
        this.idCont = id;
        this.blocat = false;
        this.tipCard="Card Basic";
    }
    public Card(Cont cont){
        this.blocat=false;
        this.idCard=i;
        i++;
        this.idCont=cont.getId();
        if (cont.sold>100){
            this.tipCard="Card Metal";
        }
        else{
            this.tipCard="Card Basic";
        }
    }
    public void Upgrade(Cont cont){
        if(cont.getSold()>= 1000){
            cont.card.tipCard="Card Metal";
            System.out.println("Upgrade card eligibil");
        }
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdCont() {
        return idCont;
    }

    public void setIdCont(int idCont) {
        this.idCont = idCont;
    }

    public void blocheazaCard() {
        this.blocat = true;
    }

    public void deblocheazaCard() {
        this.blocat = false;
    }

}
