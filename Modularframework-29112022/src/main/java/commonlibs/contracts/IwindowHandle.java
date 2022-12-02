package commonlibs.contracts;

import java.util.Set;

public interface IwindowHandle {

public void switchToAnyWindow(String windowhandle)throws Exception;
	
public void switchToAnyWindow(int childWindowIndex)throws Exception;
	
public String getwindowHandle()throws Exception;
	
public Set<String> getwindowHandles()throws Exception;
	
	
}
