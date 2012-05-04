package theatreProject.shared;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class User {
	@PrimaryKey
	@Persistent
	private String email;

	@Persistent
	private String name;

	@Persistent
	private String extraInfo;

	@Persistent
	private boolean isAdmin;


	public User(String email, String name, String extraInfo) {
		super();
		this.email = email;
		this.name = name;
		this.extraInfo = extraInfo;
		this.isAdmin = false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	@SuppressWarnings("unused")
	private User(){}
}