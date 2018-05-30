package use.aspect.ctcAspect.interfa;

import org.springframework.ui.ModelMap;

public interface IBaseServiceInterface {


	ModelMap saveCheck(ModelMap requestModel);
	
	ModelMap save(ModelMap requestModel);
	
	ModelMap deleteCheck(ModelMap requestModel);
	
	ModelMap delete(ModelMap requestModel);
	
	ModelMap regainCheck(ModelMap requestModel);
	
	ModelMap regain(ModelMap requestModel);
	
	ModelMap updateCheck(ModelMap requestModel);
	
	ModelMap update(ModelMap requestModel);
	

}
