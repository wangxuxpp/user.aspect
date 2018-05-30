package use.aspect.ctcAspect.log.initial;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import use.aspect.ctcAspect.util.LogUtil;

public class LogQueueDestroy implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if(LogUtil.getLog() != null)
		{
			LogUtil.getLog().close();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
