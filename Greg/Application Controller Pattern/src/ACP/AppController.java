package ACP;

/**
 * Created by gvh57 on 10/10/2016.
 */
public class AppController {

    public void determineType(String type){

//        determine what user entered
        if(type.equals("c") || type.equals("C")) {
            pestList pest = new pestList();
            SalesRep rep = new SalesRep();

            System.out.println("Here is a list of pests you may encounter in your home.");
            pest.list();


            System.out.println("\nYou may have encountered one of the following Sales Representatives.");
            rep.list();

        }else{
            ServicePro sp = new ServicePro();

            System.out.println("Here are our available Service Professionals.");
            sp.list();

        }


    }

}
