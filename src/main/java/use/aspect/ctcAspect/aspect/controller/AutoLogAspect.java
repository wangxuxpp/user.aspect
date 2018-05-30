package use.aspect.ctcAspect.aspect.controller;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import use.aspect.ctcAspect.annotation.AutoGenerateLogInfo;
import use.aspect.ctcAspect.interfa.IAspectInterface;
import use.aspect.ctcAspect.log.bean.LogInfo;
import use.aspect.ctcAspect.util.LogUtil;
import use.common.session.ISessionUser;


@Aspect
@Component
public class AutoLogAspect implements IAspectInterface{

	@Pointcut(value="@annotation(use.com.annotation.AutoGenerateLogInfo)")
	public void saveLog() {
	} 
	
	@Before(value="@annotation(an)")
	public void saveLogInvoke(JoinPoint jp , AutoGenerateLogInfo an)
	{
		HttpServletRequest request = null;
		for(int i = 0 ; i<jp.getArgs().length ; i++)
		{
			if(jp.getArgs()[i] instanceof HttpServletRequest)
			{
				request = (HttpServletRequest)jp.getArgs()[i];
				break;
			}
		}
		if (request == null)
		{
			return;
		}
		ISessionUser us = null;
		try
		{
			us = (ISessionUser)request.getSession().getAttribute(an.UserSessionKey());
		}catch(Exception er){}
		if(us == null)
		{
			return;
		}
		if(LogUtil.getLog() == null)
		{
			return;
		}
		if(LogUtil.getLog().getFService() == null)
		{
			return;
		}
		LogInfo li = new LogInfo();
		li.setUser(us);
		li.setLogInfo(an.logInfo());
		li.setLogType(an.logWin());
		li.setOwnerSys(an.logSystem());
		LogUtil.getLog().put(li);
		
	}
}
