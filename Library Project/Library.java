import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library{
    private String name;
    private int numberOfBooks;
    private int numberOfMember;
    private List<Member> memberList;
    private List<Book> bookList;
    private HashMap<Book,Member> takenBooks;


    public Library(String name) {
        this.name = name;
        this.numberOfBooks = 0;
        this.numberOfMember = 0;
        memberList = new ArrayList<>();
        bookList = new ArrayList<>();
        takenBooks = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
    public void setNumberOfMember(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public List<Book> getBookList() {
        return bookList;
    }
    public List<Member> getMemberList() {
        return memberList;
    }
    public HashMap<Book,Member> getTakenBooks() {
        return takenBooks;
    }
    public String printBookList() {
        StringBuilder sb = new StringBuilder();
        for(Book book : bookList){
            sb.append("Name: "+book.getName() + " Author: " + book.getAuthor() + "\n");
        }

        return sb.toString();
    }

    public void removeMember(Member member) {
        memberList.remove(member);
        numberOfMember--;
        System.out.println("Member " + member.getName() + " " + member.getSurname() + " has been removed.");
    }
    public String getName() {
        return name;
    }
    public String printMemberList() {
        StringBuilder sb = new StringBuilder();
        for(Member member : memberList){
            sb.append("Name: "+member.getName() + " Surname: " + member.getSurname() + " Membering Date: " + member.getMemberingDate() + "\n");
        }

        return sb.toString();
    }
    public int getNumberOfBooks() {
        return numberOfBooks;
    }
    public int getNumberOfMember() {
        return numberOfMember;
    }

    public void addMember(Member member){
        memberList.add(member);
        numberOfMember+=1;
    }

    public void addBook(Book book){
        bookList.add(book);
        numberOfBooks+=1;
    }

    


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: " + name +"\n");
        sb.append("Book number: " + numberOfBooks + "\n");
        sb.append("Member number: " + numberOfMember + "\n");
        sb.append(printMemberList());
        sb.append(printBookList());

        return sb.toString();

    }



}
