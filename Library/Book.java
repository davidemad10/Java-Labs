class Book extends LibraryItem{
	private String author;
	
	public Book(int id,String title , String author , int stock){
		super(id,title,stock);
		this.author=author;
	}
	public String getAuthor(){
		return author;
	}
	@Override
	public String getItemDetails(){
		return "Book [ID="+getId()+", Tittle" + getTitle() + ", Author=" + author + "]";
	}
	public void increaseStock() {
        super.returnItem(); 
    }
}
