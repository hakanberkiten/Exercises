import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("Central Library");

        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 310, Type.FANTASY, 9780618968633L, true);
        Book book2 = new Book("1984", "George Orwell", 328, Type.SCIENCE_FICTION, 9780451524935L, true);
        Book book3 = new Book("Dracula", "Bram Stoker", 418, Type.HORROR, 9780141439846L, true);

        Member member1 = new Member(library, "Alice", "Smith", 25, "alice.smith@gmail.com", "2024-01-15");
        Member member2 = new Member(library, "Bob", "Johnson", 30, "bob.johnson@gmail.com", "2024-02-22");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addMember(member1);
        library.addMember(member2);

        System.out.println("Library Details After Adding Members and Books:");
        System.out.println(library);

        System.out.println("\n" + member1.getName() + " borrows 'The Hobbit'.");
        member1.borrowBook(book1);

        System.out.println("\nSimulating a 16-day delay...");
        member1.getBorrowDates().put(book1, LocalDate.now().minusDays(16)); 

        System.out.println("\n" + member1.getName() + " returns 'The Hobbit' late.");
        member1.returnBook(book1);

        System.out.println("\n" + member1.getName() + "'s punishment count: " + member1.getCountOfPunishment());

        System.out.println("\n" + member2.getName() + " tries to borrow 'The Hobbit'.");
        member2.borrowBook(book1);

        System.out.println("\n" + member2.getName() + " returns 'The Hobbit' on time.");
        member2.returnBook(book1);

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n" + member1.getName() + " borrows and returns '1984' late (Penalty " + i + ").");
            member1.borrowBook(book2);
            member1.getBorrowDates().put(book2, LocalDate.now().minusDays(16)); 
            member1.returnBook(book2);
        }

        System.out.println("\nFinal Library Details:");
        System.out.println(library);
    }
}
