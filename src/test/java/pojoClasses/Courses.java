package pojoClasses;

import java.util.List;

public class Courses {
	
	private List<WebApplication> webAutomation;
	public List<WebApplication> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebApplication> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	private List<Api> api;
	private List<Mobile> mobile;

}
