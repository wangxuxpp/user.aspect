package use.aspect.ctcAspect.log.initial;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import use.aspect.ctcAspect.log.LogQueue;
import use.aspect.ctcAspect.util.LogUtil;

public class LogQueueInital implements ServletContainerInitializer {

	protected final Logger log = LoggerFactory.getLogger(LogQueueInital.class);
	
	public void onStartup(Set<Class<?>> arg0, ServletContext sct)
			throws ServletException {
		// TODO Auto-generated method stub
		log.info("初始化日志队列--START");
		LogQueue l = new LogQueue(2048 , true);
		LogUtil.setLog(l);
		sct.addListener(LogQueueDestroy.class);
		log.info("初始化日志队列--END");
	}

}
