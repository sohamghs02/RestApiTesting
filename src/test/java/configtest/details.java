package configtest;

public class details {
	private String id;
	private String name;
	private int price;
	public details(String id, int price, String name){
		setId(id);
		setName(name);
		setPrice(price);
	}
	public details(int price, String name){
		setName(name);
		setPrice(price);
	}
	public details(int price){
		setPrice(price);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
}