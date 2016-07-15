package wb.store.model;

public class Item {
	private String name;
	private String description;
	private float price;
	
	public Item(){}
	
	public Item(String name, String description, float price){
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
