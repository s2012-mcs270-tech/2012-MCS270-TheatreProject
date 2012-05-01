package theatreProject.domain.shared;

import java.io.Serializable;

public class User implements Serializable {
	public String name;
	public String email;
	private boolean isAdmin;
	private String extraInfo;
	
	private static final long serialVersionUID = 7649793065322010303L;
	
	public User(String name, String email, String extraInfo) {
		this.name = name;
		this.email = email;
		this.extraInfo = extraInfo;
		this.isAdmin = false; 
	}
	
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
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof User))
			return false;
		User other = (User) o;
		if(this.name == null && other.name != null)
			return false;
		if(this.name != null && !this.name.equals(other.name))
			return false;
		if(this.email == null && other.email != null)
			return false;
		if(this.email != null && !this.email.equals(other.email))
			return false;
		if(this.isAdmin != other.isAdmin)
			return false;
		if(this.extraInfo == null && other.extraInfo != null)
			return false;
		if(this.extraInfo != null && !this.extraInfo.equals(other.extraInfo))
			return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		return email==null ? 0 : email.hashCode();
	}
}
