package commonlibs.contracts;

import java.time.Duration;

public interface IAlert {

public void acceptAlert()throws Exception;

public void rejectAlert()throws Exception;

public String getMessageFromAlert()throws Exception;
	
public boolean checkAlertPresent(int timeoutInseconds)throws Exception;

boolean checkAlertPresent(Duration timeoutInseconds) throws Exception;
		
}
