import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryDAO dao = new LibraryDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    dao.addBook(bookId, title, author);
                }
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    dao.borrowBook(userId, bookId);
                }
                case 3 -> {
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    dao.returnBook(userId, bookId);
                }
                case 4 -> dao.viewAllBooks();
                case 5 -> {
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
