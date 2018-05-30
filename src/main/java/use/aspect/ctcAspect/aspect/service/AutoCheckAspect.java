package use.aspect.ctcAspect.aspect.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import use.aspect.ctcAspect.interfa.IAspectInterface;
import use.aspect.ctcAspect.interfa.IBaseServiceInterface;


@Aspect
@Component
public class AutoCheckAspect implements IAspectInterface{

	@Pointcut("@within(use.com.annotation.AutoCheckMehtod) && execution(* save(..))")
    public  void saveAspect() {
    }
	@Pointcut("@within(use.com.annotation.AutoCheckMehtod) && execution(* update(..))")
	public void updateAspect(){
		
	}
	@Pointcut("@within(use.com.annotation.AutoCheckMehtod) && execution(* delete(..))")
	public void deleteAspect(){
		
	}
	@Pointcut("@within(use.com.annotation.AutoCheckMehtod) && execution(* regain(..))")
	public void regainAspect(){
		
	}
	@Before(value="regainAspect()")
	public void regainAspectInvoke(JoinPoint jp)
	{
		if (!(jp.getTarget() instanceof IBaseServiceInterface))
		{
			return ;
		}
		if ((jp.getArgs().length != 1) && !(jp.getArgs()[0] instanceof ModelMap))
		{
			return ;
		}
		IBaseServiceInterface obj =(IBaseServiceInterface)jp.getTarget();
		ModelMap args = (ModelMap)jp.getArgs()[0];
		if (jp.getSignature().getName().equals("regain"))
		{
			obj.regainCheck(args);
		}
	}
	@Before(value="deleteAspect()")
	public void deleteAspectInvoke(JoinPoint jp)
	{
		if (!(jp.getTarget() instanceof IBaseServiceInterface))
		{
			return ;
		}
		if ((jp.getArgs().length != 1) && !(jp.getArgs()[0] instanceof ModelMap))
		{
			return ;
		}
		IBaseServiceInterface obj =(IBaseServiceInterface)jp.getTarget();
		ModelMap args = (ModelMap)jp.getArgs()[0];
		if (jp.getSignature().getName().equals("delete"))
		{
			obj.deleteCheck(args);
		}
	}
	@Before(value="updateAspect()")
	public void updateAspectInvoke(JoinPoint jp)
	{
		if (!(jp.getTarget() instanceof IBaseServiceInterface))
		{
			return ;
		}
		if ((jp.getArgs().length != 1) && !(jp.getArgs()[0] instanceof ModelMap))
		{
			return ;
		}
		IBaseServiceInterface obj =(IBaseServiceInterface)jp.getTarget();
		ModelMap args = (ModelMap)jp.getArgs()[0];
		if (jp.getSignature().getName().equals("update"))
		{
			obj.updateCheck(args);
		}
	}
	@Before(value="saveAspect()")
	public void saveAspectInvoke(JoinPoint jp)
	{
		if (!(jp.getTarget() instanceof IBaseServiceInterface))
		{
			return ;
		}
		if ((jp.getArgs().length != 1) && !(jp.getArgs()[0] instanceof ModelMap))
		{
			return ;
		}
		IBaseServiceInterface obj =(IBaseServiceInterface)jp.getTarget();
		ModelMap args = (ModelMap)jp.getArgs()[0];
		if (jp.getSignature().getName().equals("save"))
		{
			if (args.containsKey("ID") && !args.get("ID").toString().equals(""))
			{
				obj.updateCheck(args);
			} else {
				obj.saveCheck(args);
			}
			return;
		}	
	}
	
}
