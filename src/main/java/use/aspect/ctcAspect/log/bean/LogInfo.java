package use.aspect.ctcAspect.log.bean;

import java.io.Serializable;

import use.common.session.ISessionUser;


@SuppressWarnings("serial")
public class LogInfo implements Serializable{

	private ISessionUser user = null;
	private String ownerSys = "";
	private String logType ="";
	private String logInfo ="";
	public ISessionUser getUser() {
		return user;
	}
	public void setUser(ISessionUser user) {
		this.user = user;
	}
	public String getOwnerSys() {
		return ownerSys;
	}
	public void setOwnerSys(String ownerSys) {
		this.ownerSys = ownerSys;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}
}
