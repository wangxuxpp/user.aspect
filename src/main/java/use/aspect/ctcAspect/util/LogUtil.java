package use.aspect.ctcAspect.util;

import use.aspect.ctcAspect.log.LogQueue;

public class LogUtil {

	private static LogQueue logService = null;
	
	public static LogQueue getLog()
	{
		return logService;
	}
	public static void setLog(LogQueue log)
	{
		logService = log;
	}
}
