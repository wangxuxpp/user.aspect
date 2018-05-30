package use.aspect.egfAspect.aspect.controll;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import use.aspect.egfAspect.annotation.RetrunJson;
import use.common.json.JSONResult;
import use.common.util.ExceptionUtil;




@Aspect
@Component
public class ReturnJsonAspect implements IAspectInterface{

	protected final Logger log = LoggerFactory.getLogger(ReturnJsonAspect.class);
	
	@Pointcut(value="@annotation(egfAspectSupport.annotation.RetrunJson)")
	public void saveLog() {
	} 

	
	@Around(value="@annotation(an)")
	public JSONResult saveLogInvoke(ProceedingJoinPoint jp , RetrunJson an)
	{
		JSONResult json = new JSONResult();
		try
		{
			Object r = null;
			if(jp.getArgs().length >0)
			{
				r = jp.proceed(jp.getArgs());
			}else {
				r = jp.proceed();
			}
			if(r != null)
			{
				json.setData(r);
//				if (r instanceof Map)
//				{
//					json.setData((Map)r);
//				} else {
//					json.setData(an.mapKey() , r);
//				}
			}
			json.setJsonMessage(an.successMessage());
			json.setJsonType("success");	
		}catch(Exception er)
		{
			String info = an.errorMessage()+er.getMessage();
			json.setJsonType("error");
			json.setJsonMessage(info);
			
			ExceptionUtil.throwError(er, log);
		} catch (Throwable e) {
			String info = an.errorMessage()+e.getMessage();
			json.setJsonType("error");
			json.setJsonMessage(info);
			
			ExceptionUtil.throwError(e, log);
		}
		return json;
	}
}
