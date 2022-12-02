package commonlibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileUtils {

public static Properties readproperties(String filename)throws Exception
{
//print filename	
filename=filename.trim();

//to read any file in java
InputStream filereader=new FileInputStream(filename);

//java provide class(java.util)
Properties property=new Properties();

property.load(filereader);

return property;
}
	
	
	
}
