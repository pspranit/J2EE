package model;

public class Asset {
	
	private int id;
	private String name;
	private String operatingSystem;
	private String version;
	private String screenSize;
	private String is5GSupported;
	private String notes;
	public Asset(String name, String operatingSystem, String version, String screenSize, String is5gSupported,
			String notes) {
		super();
		this.name = name;
		this.operatingSystem = operatingSystem;
		this.version = version;
		this.screenSize = screenSize;
		is5GSupported = is5gSupported;
		this.notes = notes;
	}
	public Asset() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public String getIs5GSupported() {
		return is5GSupported;
	}
	public void setIs5GSupported(String is5gSupported) {
		is5GSupported = is5gSupported;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Asset [id=" + id + ", name=" + name + ", operatingSystem=" + operatingSystem + ", version=" + version
				+ ", screenSize=" + screenSize + ", is5GSupported=" + is5GSupported + ", notes=" + notes + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getOperatingSystem()=" + getOperatingSystem()
				+ ", getVersion()=" + getVersion() + ", getScreenSize()=" + getScreenSize() + ", getIs5GSupported()="
				+ getIs5GSupported() + ", getNotes()=" + getNotes() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
