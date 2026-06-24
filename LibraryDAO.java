import java.sql.*;
import java.util.logging.Logger;

public class LibraryDAO {
    private static final Logger logger = Logger.getLogger(LibraryDAO.class.getName());

    // Add a new book
    public void addBook(int bookId, String title, String author) {
        String sql = "INSERT INTO Books (book_id, title, author, is_available) VALUES (?, ?, ?, true)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println("Could not add book. Please try again.");
            logger.severe("AddBook failed: " + e.getMessage());
        }
    }

    // Borrow a book (transaction)
    public void borrowBook(int userId, int bookId) {
        String updateBook = "UPDATE Books SET is_available = false WHERE book_id = ? AND is_available = true";
        String insertTransaction = "INSERT INTO Transactions (user_id, book_id, status, date) VALUES (?, ?, 'BORROWED', NOW())";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement(updateBook);
                 PreparedStatement stmt2 = conn.prepareStatement(insertTransaction)) {

                stmt1.setInt(1, bookId);
                int rows = stmt1.executeUpdate();

                if (rows > 0) {
                    stmt2.setInt(1, userId);
                    stmt2.setInt(2, bookId);
                    stmt2.executeUpdate();
                    conn.commit();
                    System.out.println("Book borrowed successfully.");
                } else {
                    conn.rollback();
                    System.out.println("Book not available.");
                }
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error borrowing book. Please try again.");
                logger.severe("BorrowBook failed: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            logger.severe("Connection failed in borrowBook: " + e.getMessage());
        }
    }

    // Return a book (transaction)
    public void returnBook(int userId, int bookId) {
        String updateBook = "UPDATE Books SET is_available = true WHERE book_id = ?";
        String insertTransaction = "INSERT INTO Transactions (user_id, book_id, status, date) VALUES (?, ?, 'RETURNED', NOW())";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement(updateBook);
                 PreparedStatement stmt2 = conn.prepareStatement(insertTransaction)) {

                stmt1.setInt(1, bookId);
                stmt1.executeUpdate();

                stmt2.setInt(1, userId);
                stmt2.setInt(2, bookId);
                stmt2.executeUpdate();

                conn.commit();
                System.out.println("Book returned successfully.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error returning book. Please try again.");
                logger.severe("ReturnBook failed: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            logger.severe("Connection failed in returnBook: " + e.getMessage());
        }
    }

    // View all books
    public void viewAllBooks() {
        String sql = "SELECT * FROM Books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== Library Books ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("book_id") +
                                   ", Title: " + rs.getString("title") +
                                   ", Author: " + rs.getString("author") +
                                   ", Available: " + rs.getBoolean("is_available"));
            }
        } catch (SQLException e) {
            System.out.println("Could not retrieve books.");
            logger.severe("ViewAllBooks failed: " + e.getMessage());
        }
    }
}
