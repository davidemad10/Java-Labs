import java.util.*;



public class LibraryManagementSystem {
    private static Library<LibraryItem> library = new Library<>();
    private static List<Client> clients = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Manage Library Items");
            System.out.println("2. Manage Clients");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageLibraryItems(scanner);
                    break;
                case 2:
                    manageClients(scanner);
                    break;
                case 3:
                    borrowItem(scanner);
                    break;
                case 4:
                    returnItem(scanner);
                    break;
                case 5:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void borrowItem(Scanner scanner) {
        System.out.print("Enter Client ID: ");
        int clientId = scanner.nextInt();
        Optional<Client> optionalClient = clients.stream()
                .filter(client -> client.getId() == clientId)
                .findFirst();

        if (!optionalClient.isPresent()) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter Item ID: ");
        int itemId = scanner.nextInt();
        try {
            LibraryItem item = library.getItemById(itemId);
            if (item.borrow()) {
                optionalClient.get().borrowItem(item);
                System.out.println("Item borrowed successfully.");
            } else {
                System.out.println("Item is not available.");
            }
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void returnItem(Scanner scanner) {
        System.out.print("Enter Client ID: ");
        int clientId = scanner.nextInt();
        Optional<Client> optionalClient = clients.stream()
                .filter(client -> client.getId() == clientId)
                .findFirst();

        if (!optionalClient.isPresent()) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter Item ID: ");
        int itemId = scanner.nextInt();
        try {
            LibraryItem item = library.getItemById(itemId);
            if (optionalClient.get().returnItem(item)) {
                System.out.println("Item returned successfully.");
            } else {
                System.out.println("Client did not borrow this item.");
            }
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void manageLibraryItems(Scanner scanner) {
        while (true) {
            System.out.println("\nLibrary Items Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. View Item Details");
            System.out.println("4. Remove Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId=0;
                    while (true) {
                        try {
                            bookId = scanner.nextInt();
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. ID Must be Integer Number only.");
                            scanner.nextLine();
                        }
                    } 
                    while (true) {
                        try {
                            if (library.getItemById(bookId) != null) {
                                System.out.println("A book with this ID already exists. Please enter a unique Book ID: ");
                                bookId = scanner.nextInt();
                            } else {
                                break; 
                            }
                        } catch (ItemNotFoundException e) {
                            break; 
                        }
                    }

                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter Book Stock: ");
                    int bookStock=0;
                    while (true) {
                        try {
                            bookStock = scanner.nextInt();
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Stock Must be Integer Number only.");
                            scanner.nextLine();
                        }
                    } 
                    Book newBook = new Book(bookId, bookTitle, bookAuthor, bookStock);
                    library.addItem(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Magazine ID: ");
                    int magaId=0;
                    while (true) {
                        try {
                            magaId = scanner.nextInt();
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. ID Must be Integer Number only.");
                            scanner.nextLine();
                        }
                    } 
                    while (true) {
                        try {
                            if (library.getItemById(magaId) != null) {
                                System.out.println("A book with this ID already exists. Please enter a unique Book ID: ");
                                magaId = scanner.nextInt();
                            } else {
                                break; 
                            }
                        } catch (ItemNotFoundException e) {
                            break; 
                        }
                    }
                    scanner.nextLine(); 
                    System.out.print("Enter Magazine Title: ");
                    String magTitle = scanner.nextLine();
                    System.out.print("Enter Magazine Issue Number: ");
                    int issueNumber = 0;
                    while (true) {
                        try {
                            issueNumber = scanner.nextInt();
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. issue number must be integer only.");
                            scanner.nextLine();
                        }
                    }   
                    System.out.print("Enter magazine Stock: ");
                    int stock = 0;
                    while (true) {
                        try {
                            stock = scanner.nextInt();
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. stock should be Integer Number only.");
                            scanner.nextLine();
                        }
                    } 
                    Magazine newMagaza=new Magazine(magaId, magTitle, issueNumber,stock);
                    library.addItem(newMagaza);
                    System.out.println("Magazine added successfully.");
                    break;
                case 3:
                    System.out.print("Enter Item ID: ");
                    int itemId = scanner.nextInt();
                    try {
                        LibraryItem item = library.getItemById(itemId);
                        System.out.println(item.getItemDetails());
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter Item ID: ");
                    int removeId = scanner.nextInt();
                    try {
                        library.removeItemById(removeId);
                        System.out.println("Item removed successfully.");
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    library.displayItems();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageClients(Scanner scanner) {
        while (true) {
            System.out.println("\nClients Menu");
            System.out.println("1. Add Client");
            System.out.println("2. View Client Details");
            System.out.println("3. Remove Client");
            System.out.println("4. Display All Clients");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int clientId = -1;
                    boolean isUnique = false;
                
                    while (!isUnique) {
                        System.out.print("Enter Client ID: ");
                        int clientid=0;
                        while (true) {
                            try {
                                clientid = scanner.nextInt();
                                break; 
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. ID Must be Integer Number only.");
                                scanner.nextLine();
                            }
                        } 
                        
                        isUnique = true;
                        for (Client client : clients) {
                            if (client.getId() == clientId) {
                                System.out.println("A client with this ID already exists. Please enter a unique Client ID.");
                                isUnique = false;
                                break;
                            }
                        }
                    }
                    scanner.nextLine();
                    System.out.print("Enter Client Name: ");
                    String clientName = scanner.nextLine();
                    System.out.print("Enter Client Email: ");
                    String clientEmail = scanner.nextLine();
                    clients.add(new Client(clientId, clientName, clientEmail));
                    System.out.println("Client added successfully.");
                    break;
		        case 2:
                    System.out.print("Enter Client ID: ");
                    int searchId = scanner.nextInt();
                    Optional<Client> optionalClient = clients.stream()
                                                    .filter(client -> client.getId() == searchId)
                                                    .findFirst();

                    if (optionalClient.isPresent()) {
                    System.out.println(optionalClient.get().getClientDetails());
                    } else {
                    System.out.println("Client with ID " + searchId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Client ID: ");
                    int removeClientId = scanner.nextInt();
                    if (clients.removeIf(client -> client.getId() == removeClientId)) {
                        System.out.println("Client removed successfully.");
                    } else {
                        System.out.println("Client with ID " + removeClientId + " not found.");
                    }
                    break;
                case 4:
                    if (clients.isEmpty()) {
                        System.out.println("No clients in the system.");
                    } else {
                        clients.forEach(client -> System.out.println(client.getClientDetails()));
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

