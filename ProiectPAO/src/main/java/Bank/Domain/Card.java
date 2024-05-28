package Bank.Domain;

public class Card {
    private int idCard;
    private int idCont;
    private boolean blocat;

    private String tipCard;



    public Card(int id) {
        this.idCard = id+1000;
        this.idCont = id;
        this.blocat = false;
        this.tipCard="Card Basic";
    }
    public Card(int idCard,int idCont,boolean blocat,String tipCard) {
        this.idCard = idCard;
        this.idCont = idCont;
        this.blocat = blocat;
        this.tipCard=tipCard;
    }
    public Card(Cont cont){
        this.blocat=false;
        this.idCard=cont.getId()+1000;
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
    public String getTipCard(){
        return tipCard;
    }

    public boolean isBlocat() {
        return blocat;
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
