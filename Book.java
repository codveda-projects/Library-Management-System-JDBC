
public class Book {
    private int bookId;
    private String title;
    private String author;
    private int quantity; // number of copies available

    // Constructor
    public Book(int bookId, String title, String author, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Utility methods
    public void borrowBook() {
        if (quantity > 0) {
            quantity--;
            System.out.println("Book borrowed successfully. Remaining copies: " + quantity);
        } else {
            System.out.println("No copies available to borrow.");
        }
    }

    public void returnBook() {
        quantity++;
        System.out.println("Book returned successfully. Total copies: " + quantity);
    }

    @Override
    public String toString() {
        return "Book [ID=" + bookId + ", Title=" + title + ", Author=" + author + ", Quantity=" + quantity + "]";
    }
}
