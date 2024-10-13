import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class Member {
    private Library library;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String memberingDate;
    private int countOfPunishment;
    private HashMap<Book, LocalDate> borrowDates; 

    public Member(Library library, String name, String surname, int age, String email, String memberingDate) {
        this.library = library;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.memberingDate = memberingDate;
        this.borrowDates = new HashMap<>(); 
    }

    public int getAge() {
        return age;
    }
    public HashMap<Book, LocalDate> getBorrowDates() {
        return borrowDates;
    }

    public int getCountOfPunishment() {
        return countOfPunishment;
    }

    public String getEmail() {
        return email;
    }

    public String getMemberingDate() {
        return memberingDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            library.getTakenBooks().put(book, this);
            library.setNumberOfBooks(library.getNumberOfBooks() - 1);
            borrowDates.put(book, LocalDate.now()); 
            book.setAvailable(false);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowDates.containsKey(book)) {
            LocalDate borrowDate = borrowDates.get(book);
            long daysBorrowed = ChronoUnit.DAYS.between(borrowDate, LocalDate.now());

            if (daysBorrowed > 15) {
                countOfPunishment++; 
                System.out.println("You returned the book late! Punishment added. Current penalty: " + countOfPunishment);
            }

            if (countOfPunishment >= 5) {
                library.removeMember(this);
                System.out.println("You have been removed from the library due to excessive punishmets.");
            }

            book.setAvailable(true);
            library.getTakenBooks().remove(book);
            library.setNumberOfBooks(library.getNumberOfBooks() + 1);
            borrowDates.remove(book); 
        } else {
            System.out.println("This book was not borrowed by you.");
        }
    }
}
