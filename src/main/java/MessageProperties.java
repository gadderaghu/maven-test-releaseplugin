import java.util.ArrayList;
import java.util.Set;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageProperties implements Callable {
	
	Logger logger = LoggerFactory.getLogger(MessageProperties.class);
	private static ArrayList<String> listOfProps = new ArrayList<String>();
	static{
		listOfProps.add("http.request.uri");
		listOfProps.add("http.query.string");
		listOfProps.add("http.query.params");
		listOfProps.add("http.listener.path");
		listOfProps.add("http.remote.address");
		listOfProps.add("http.uri.params");
		listOfProps.add("accept");
		listOfProps.add("host");
		listOfProps.add("connection");
		listOfProps.add("http.version");
		listOfProps.add("http.method");
		listOfProps.add("http.relative.path");
		listOfProps.add("http.scheme");
		listOfProps.add("http.request.path");
		listOfProps.add("user-agent");
	}
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage  message = eventContext.getMessage();
		Set<String> inboundProps= message.getInboundPropertyNames();
		/*logger.info("Mule Message Inbound Properies"+inboundProps);
		logger.info("Static Inbound Properies"+ listOfProps);
		inboundProps.removeAll(listOfProps);
		logger.info("Headers Inbound Properties::inboundProps::"+inboundProps);
		logger.info("Headers Inbound Properties::listOfProps::"+listOfProps);*/
		for(String propertyName: inboundProps){
			message.setOutboundProperty(propertyName, message.getInboundProperty(propertyName));
		}
		logger.info("Mule Message"+message);
		return null;
	}

}
