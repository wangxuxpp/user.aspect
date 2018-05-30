package use.aspect.ctcAspect.util;

import use.aspect.ctcAspect.aspect.service.AutoCheckAspect;
import use.aspect.ctcAspect.interfa.IAspectInterface;

public class AspectUtil {

	public static IAspectInterface getAutoCheckAspect()
	{
		return new AutoCheckAspect();
	}
}
