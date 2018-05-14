import java.util.Date;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSleep implements Callable{

	Logger  logger = LoggerFactory.getLogger(ThreadSleep.class); 
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		logger.info("Current Time"+new Date());
		Thread.sleep(10000);
		return "Thread is active now";
	}

}
