package ressource;

public class Item {
	private String make;
	private String model;
	private String version;
	private String category;
	private String eanCode;
	
	public Item(String make, String model, String version, String category, String eanCode) {
		this.make = make;
		this.model = model;
		this.version = version;
		this.category = category;
		this.eanCode = eanCode;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEanCode() {
		return eanCode;
	}

	public void setEanCode(String eanCode) {
		this.eanCode = eanCode;
	}
	
	
}
