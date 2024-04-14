package Bank;


public class Main {
    public static void main(String[] args) {
        ContService contService= new ContService();
        contService.display();
        Cont client1 = contService.selectById(101);
        Cont client2 = contService.selectById(102);
        Cont client3 = contService.selectById(103);
        client1.depuneNumerar(1000);
        client2.depuneNumerar(1000);
        client3.depuneNumerar(1000);
        client3.retrageNumerar(50);
        Tranzactie t1= new Tranzactie(client1,client2,400);
        Tranzactie t2= new Tranzactie(client2,client3,300);
        t2.AfisareTranzactie();
        client1.extrasCont.afiseazaExtrasCont();
        System.out.println(client1.getSold());



        }

    }
