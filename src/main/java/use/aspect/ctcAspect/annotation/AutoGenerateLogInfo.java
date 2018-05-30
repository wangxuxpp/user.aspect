package use.aspect.ctcAspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoGenerateLogInfo {

	public String logSystem();
	public String logWin() default "用户";
	public String logInfo();

	public String UserSessionKey() default "SYS_SESSION_USER";
	
}
