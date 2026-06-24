import java.sql.*;

public class LibraryDAO {

    public void viewBooks() {
        String query = "SELECT * FROM Books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getInt("book_id") + " | " +
                                   rs.getString("title") + " | " +
                                   rs.getString("author") + " | Available: " +
                                   rs.getBoolean("is_available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrowBook(int userId, int bookId) {
        String update = "UPDATE Books SET is_available = FALSE WHERE book_id = ?";
        String insert = "INSERT INTO Transactions (user_id, book_id, status) VALUES (?, ?, 'BORROWED')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psUpdate = conn.prepareStatement(update);
             PreparedStatement psInsert = conn.prepareStatement(insert)) {

            psUpdate.setInt(1, bookId);
            psUpdate.executeUpdate();

            psInsert.setInt(1, userId);
            psInsert.setInt(2, bookId);
            psInsert.executeUpdate();

            System.out.println("Book borrowed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int userId, int bookId) {
        String update = "UPDATE Books SET is_available = TRUE WHERE book_id = ?";
        String insert = "INSERT INTO Transactions (user_id, book_id, status) VALUES (?, ?, 'RETURNED')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psUpdate = conn.prepareStatement(update);
             PreparedStatement psInsert = conn.prepareStatement(insert)) {

            psUpdate.setInt(1, bookId);
            psUpdate.executeUpdate();

            psInsert.setInt(1, userId);
            psInsert.setInt(2, bookId);
            psInsert.executeUpdate();

            System.out.println("Book returned successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
