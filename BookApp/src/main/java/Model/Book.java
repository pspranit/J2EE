package Model;


public class Book {

    private int bookid;
    private String authorName;
    private String bookName;
    private double bookPrice;
    private double bookRating;
    private String publishedDate;
    private int userId;


    public Book(int bookid, String authorName, String bookName, double bookPrice, double bookRating, String publishedDate, int userId) {
        this.bookid = bookid;
        this.authorName = authorName;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookRating = bookRating;
        this.publishedDate = publishedDate;
        this.userId = userId;
    }

    public Book() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getBookRating() {
        return bookRating;
    }

    public void setBookRating(double bookRating) {
        this.bookRating = bookRating;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BookData{" +
                "bookid=" + bookid +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookRating=" + bookRating +
                ", publishedDate='" + publishedDate + '\'' +
                ", userId=" + userId +
                '}';
    }
}

