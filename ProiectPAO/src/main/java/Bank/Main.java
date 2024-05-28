package Bank;



import Bank.Database.DatabaseConfig;
import Bank.Database.CreateTables;
import Bank.Domain.*;
import Bank.Repository.ContRepository;
import Bank.Service.ContService;
import Bank.Service.OtherService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CreateTables setupData= new CreateTables();
        setupData.createTableCont();
        setupData.createTableCard();
        setupData.createTableExtras();
        setupData.createTableTranzactie();
        ContService contService= new ContService();
        Banca bcr =new Banca("BCR");
        Banca brd =new Banca("BRD");
        Banca ing =new Banca("ING");
        Banca bt =new Banca("BT");
        //contService.display();
        //Cont client1 = contService.selectById(101);
        //Cont client2 = contService.selectById(102);
        //Cont client3 = contService.selectById(103);
        Cont clientul= new Cont(1003,"Ionut",100);
        //contService.addCont(clientul);
        //contRepository.delete("Ionut");
        //contService.depuneNumerar(1003,1000);
        //contService.display(1003);
        contService.displayAll();
        contService.deleteAll();
        OtherService otherService = new OtherService();
        otherService.inscrie_client_banca(bcr,clientul);
        //Tranzactie t1= new Tranzactie(client1,client2,400);
        //Tranzactie t2= new Tranzactie(client2,client3,300);
        //t2.AfisareTranzactie();
        //client1.extrasCont.afiseazaExtrasCont();
       // System.out.println(client1.getSold());



        }

    }
