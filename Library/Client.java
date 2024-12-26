import java.util.ArrayList;
import java.util.List;

class Client {
    private int id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems;


    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedItems=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }
    public boolean returnItem(LibraryItem item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);  // Remove item from borrowed items
            item.returnItem();  // Increase stock in the item
            return true;
        } else {
            return false;  // Item was not borrowed by this client
        }
    }

    public String getClientDetails() {
        return "Client [ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }
}

