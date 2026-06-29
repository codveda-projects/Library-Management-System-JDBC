
import java.sql.Timestamp;

public class Transaction {
    private int transactionId;
    private int userId;
    private int bookId;
    private String status; // BORROWED or RETURNED
    private Timestamp date;

    // Constructor
    public Transaction(int transactionId, int userId, int bookId, String status, Timestamp date) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.bookId = bookId;
        this.status = status;
        this.date = date;
    }

    // Overloaded constructor (without transactionId, for new inserts)
    public Transaction(int userId, int bookId, String status) {
        this.userId = userId;
        this.bookId = bookId;
        this.status = status;
        this.date = new Timestamp(System.currentTimeMillis());
    }

    // Getters
    public int getTransactionId() {
        return transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getDate() {
        return date;
    }

    // Setters
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction [ID=" + transactionId +
               ", UserID=" + userId +
               ", BookID=" + bookId +
               ", Status=" + status +
               ", Date=" + date + "]";
    }
}
