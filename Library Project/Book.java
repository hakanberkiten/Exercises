
public class Book{
    private String author;
    private String name;
    private int page;
    private Type type;
    private long ISBN;
    private boolean available;
    private int currentPage;

    public Book(String name ,String author, int page , Type type,long ISBN,boolean available) {
        this.name = name;
        this.author = author;
        this.page = page;
        this.type = type;
        this.ISBN = ISBN;
        this.available = available;
        currentPage = 0;
    }
// GETTERS
    public String getAuthor() {
        return author;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public long getISBN() {
        return ISBN;
    }public String getName() {
        return name;
    }public int getPage() {
        return page;
    }public Type getType() {
        return type;
    }
    public boolean isAvailable() {
        return available;
    }
// SETTERS
    public void setAuthor(String author) {
        this.author = author;
    }public void setISBN(long iSBN) {
        ISBN = iSBN;
    }public void setName(String name) {
        this.name = name;
    }public void setPage(int page) {
        this.page = page;
    }public void setType(Type type) {
        this.type = type;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public void getNextPage(){
        currentPage +=1;

    }
    public void getPreviousPage(){
        currentPage -=1;
    }

    


}
