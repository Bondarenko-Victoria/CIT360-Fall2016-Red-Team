package ACP;

import java.util.HashMap;

/**
 * Created by gvh57 on 10/10/2016.
 */
public class AppController {

    public static HashMap<String, Handler> companyInfo = new HashMap<String, Handler>();

    public AppController(){
        companyInfo.put("c", new SalesRep());
        companyInfo.put("s", new ServicePro());
        companyInfo.put("p", new pestList());
    }

    public void determineType(String type){

        Handler request = companyInfo.get(type);
        request.list();

    }

}
