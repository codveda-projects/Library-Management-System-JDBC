import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryDAO dao = new LibraryDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dao.viewBooks();
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    int userIdBorrow = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookIdBorrow = sc.nextInt();
                    dao.borrowBook(userIdBorrow, bookIdBorrow);
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    int userIdReturn = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookIdReturn = sc.nextInt();
                    dao.returnBook(userIdReturn, bookIdReturn);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
