
abstract class LibraryItem{
	private int id;
	private String title;
	private int stock;
	private boolean isBorrowed;


	public LibraryItem(int id, String title, int stock) {
        this.id = id;
        this.title = title;
        this.stock = stock;
		this.isBorrowed = false;
    }

	public int getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public int getStock() {
        return stock;
    }
	public void decrementStock(){
		if(stock>0){
			stock--;
		}else{
			throw new IllegalStateException("Item is out of stock.");
		}
	}
	public boolean isBorrowed() {
        return isBorrowed;
    }
	public boolean borrow() {
        if (stock > 0) {
            decrementStock();
            return true;
        }
        return false;
    }
	
	public void returnItem(){
		stock++;
	}
	public abstract String getItemDetails();
}
