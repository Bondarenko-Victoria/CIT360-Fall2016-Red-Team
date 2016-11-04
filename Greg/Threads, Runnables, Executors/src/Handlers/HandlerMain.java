package Handlers;


import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

/**
 * Created by gvh57 on 10/19/2016.
 */
public class HandlerMain implements Handler {

    @Override
    public boolean handleMessage(MessageContext context) {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }

}
