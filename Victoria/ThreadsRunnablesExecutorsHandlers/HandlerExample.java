package ThreadsRunnablesExecutorsHandlers;

/**
 * Created by Victoria on 27.09.2016.
 */

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

public class HandlerExample implements Handler {

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

    // Does not override methods from its superclass
}