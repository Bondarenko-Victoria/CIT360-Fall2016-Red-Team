import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

/**
 * Created by Brian on 10/10/2016.
 */

public class AndroidHandlerSandbox implements Handler{

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
