package use.aspect.egfAspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 项目名称:egfAspectSupport
 * 类型名称:RetrunJson
 * 类型描述:返回json包装对象
 * 作者:wx
 * 创建时间:2016年8月23日
 * @version:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RetrunJson {

	/**
	 * 错误信息
	 * @return
	 */
	public String errorMessage() default "错误";
	/**
	 * 成功信息
	 * @return
	 */
	public String successMessage() default "";
	/**
	 * json key值
	 * @return
	 */
	public String mapKey() default "result";
}
