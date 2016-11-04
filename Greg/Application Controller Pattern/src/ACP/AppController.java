package ACP;

import java.util.HashMap;

/**
 * Created by gvh57 on 10/10/2016.
 */
public class AppController {

    public static HashMap<String, Handler> companyInfo = new HashMap<String, Handler>();

    public void AppController(){}

    public void determineType(String type){

        companyInfo.put("c", new SalesRep());
        companyInfo.put("s", new ServicePro());
        companyInfo.put("p", new pestList());

        Handler request = companyInfo.get(type);
        request.list();

    }

}
