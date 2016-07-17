package wb.store.model;

import java.io.Serializable;

public class Item implements Serializable{
	private Integer id;
	private String name;
	private String description;
	private float price;
	
	public Item(){}
	
	public Item(String name, String description, float price){
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
	}	
	
	public Item(Integer id, String name, String description, float price){
		this.setId(id);
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
