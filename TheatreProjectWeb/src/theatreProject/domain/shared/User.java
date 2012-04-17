package theatreProject.domain.shared;

import java.io.Serializable;

public class User implements Serializable {
	public String name;
	public String email;
	private boolean isAdmin;
	private String extraInfo;
	
	private static final long serialVersionUID = 7649793065322010303L;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
}
