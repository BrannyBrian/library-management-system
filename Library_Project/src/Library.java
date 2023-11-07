import java.util.HashMap;
import java.util.Map;

class Library {
    private Map<String, Integer> booksInventory;

    public Library() {
        booksInventory = new HashMap<>();
    }

    // Method to add books to the library system
    public void addBook(String title, String author, int quantity) {
        String bookKey = title + " by " + author;
        int currentQuantity = booksInventory.getOrDefault(bookKey, 0);
        booksInventory.put(bookKey, currentQuantity + quantity);
        System.out.println(quantity + " copies of \"" + title + " by " + author + "\" added to the library.");
    }

    // Method to borrow books from the library
    public void borrowBook(String title, int quantity) {
        String bookKey = title;
        if (booksInventory.containsKey(bookKey)) {
            int availableQuantity = booksInventory.get(bookKey);
            if (availableQuantity >= quantity) {
                booksInventory.put(bookKey, availableQuantity - quantity);
                System.out.println(quantity + " copies of \"" + title + "\" borrowed.");
            } else {
                System.out.println("Insufficient copies of \"" + title + "\" available.");
            }
        } else {
            System.out.println("\"" + title + "\" is not available in the library.");
        }
    }

    // Method to return books to the library
    public void returnBook(String title, int quantity) {
        String bookKey = title;
        if (booksInventory.containsKey(bookKey)) {
            int currentQuantity = booksInventory.get(bookKey);
            booksInventory.put(bookKey, currentQuantity + quantity);
            System.out.println(quantity + " copies of \"" + title + "\" returned.");
        } else {
            System.out.println("\"" + title + "\" is not part of the library's collection.");
        }
    }
}

class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 5);
        library.addBook("To Kill a Mockingbird", "Harper Lee", 3);

        // Borrowing books from the library
        library.borrowBook("Harry Potter and the Sorcerer's Stone", 2);
        library.borrowBook("The Great Gatsby", 1); // Book not available

        // Returning books to the library
        library.returnBook("Harry Potter and the Sorcerer's Stone", 1);
        library.returnBook("The Catcher in the Rye", 2); // Book not part of the library
    }
}
