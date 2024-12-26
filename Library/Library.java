import java.util.ArrayList;
import java.util.List;

class Library<T extends LibraryItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItemById(int id) throws ItemNotFoundException {
        return items.stream().filter(item -> item.getId() == id).findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found."));
    }

    public void removeItemById(int id) throws ItemNotFoundException {
        T item = getItemById(id);
        items.remove(item);
    }
    public List<T> getItems() {
        return items;
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
        } else {
            items.forEach(item -> System.out.println(item.getItemDetails()));
        }
    }
}

