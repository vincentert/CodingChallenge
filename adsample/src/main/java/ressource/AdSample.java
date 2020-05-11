package ressource;

public class AdSample {
	private Contacts contacts;
	private Item item;
	private Phone phone;
	private String creationDate;
	private Long price;
	private String [] publicationOptions;
	private String reference;
	
	public AdSample(Contacts contacts, Item item, Phone phone, String creationDate, Long price,
			String[] publicationOptions, String reference) {
		super();
		this.contacts = contacts;
		this.item = item;
		this.phone = phone;
		this.creationDate = creationDate;
		this.price = price;
		this.publicationOptions = publicationOptions;
		this.reference = reference;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String[] getPublicationOptions() {
		return publicationOptions;
	}

	public void setPublicationOptions(String[] publicationOptions) {
		this.publicationOptions = publicationOptions;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
}
