/**
 * This class represents a Book object.
 * @version 2018
 * @author Roy Hadad
 */

public class Book
{
    private static final int MAX_DAYS = 30;
    private static final int FINE_PER_DAY = 5;
    private static final int MAX_PUBLISH_YEAR = 2018;
    private static final int MIN_PUBLISH_YEAR = 1800;
    private static final int DEFUALT_PUBLISH_YEAR = 2000;
    private static final int MIN_NUM_OF_PAGES = 1;
    private static final int DEFUALT_NUM_OF_PAGES = 1;
    private static final int DEFUALT_NUM_OF_DAYS_BORROWED = 0;
    private static final int NUM_OF_FRIDAY = 6;
    private static final int NUM_OF_SATURDAY = 0;
    private static final int PENALTY_IF_BOOK_RETURNED_ON_TIME = 0;
    private static final int DAYS_BEFORE_DOUBLE_PENALTY = 60;
    private static final int DOUBLE_PENALTY_MULTIPLIER = 2;
    
    private String _title;
    private String _author;
    private int _yearPublished;
    private int _noOfPages;
    private boolean _borrowed;
    private String _studentName;
    private Date _borrowedDate;
    private Date _returnDate;
    
    /**
     * Constructs a new Book object. If year is not valid it will be set to default 2000. 
     * If number of pages is not valid it will be set to default 1. 
     * _borrowed field is set to false. All other fields are set to null.
     * @param title book title
     * @param author book author
     * @param year the year the book was published
     * param num book number of pages
     */
    public Book(String title, String author, int year, int num)
    {
        _title = title;
        _author = author;
        if(year>MAX_PUBLISH_YEAR || year<MIN_PUBLISH_YEAR)
            _yearPublished = DEFUALT_PUBLISH_YEAR;
        else
            _yearPublished = year;
        if(num<MIN_NUM_OF_PAGES)
            _noOfPages = DEFUALT_NUM_OF_PAGES;
        else
            _noOfPages = num;
        _borrowed = false;
        _studentName = null;
        _borrowedDate = null;
        _returnDate = null;
    }
    
    /**
     * Copy constructor for Book object.
     * @param other book to be copied
     */
    public Book(Book other)
    {
        _title = other._title;
        _author = other._author;
        _yearPublished = other._yearPublished;
        _noOfPages = other._noOfPages;
        _borrowed = other._borrowed;
        _studentName = other._studentName;
        _borrowedDate = new Date(other._borrowedDate);
        _returnDate = new Date(other._returnDate);
    }
    
    /**
     * Returns the book title.
     * @return the book title
     */
    public String getTitle()
    {
        return _title;
    }
    
    /**
     * Returns the book author.
     * @return the book author
     */
    public String getAuthor()
    {
        return _author;
    }
    
    /**
     * Returns the year the book was published.
     * @return the year the book was published
     */
    public int getYear()
    {
        return _yearPublished;
    }
    
    /**
     * the year the book was published
     * @return the book number of pages
     */
    public int getPages()
    {
        return _noOfPages;
    }
    
    /**
     * Returns true if the book is borrowed; false otherwise.
     * @return true if the book is borrowed; false otherwise
     */
    public boolean getBorrowed()
    {
        return _borrowed;
    }
    
    /**
     * Returns the student name.
     * @return the student name
     */
    public String getStudentName()
    {
        return _studentName;
    }
    
    /**
     * Returns the book return date.
     * @return the book return date
     */
    public Date getReturnDate()
    {
        return new Date(_returnDate);
    }
    
    /**
     * Returns the book borrowed date.
     * @return the book borrowed date
     */
    public Date getBorrowedDate()
    {
        return new Date(_borrowedDate);
    }
    
    /**
     * Sets the book title.
     * @param s the new book title String to be set
     */
    public void setTitle(String s)
    {
        _title = s;
    }
    
    /**
     * Sets the book author.
     * @param s the new book author String to be set
     */
    public void setAuthor(String s)
    {
        _author = s;
    }
    
    /**
     * Sets the year the book was published (only if valid).
     * @param n the book published year to be set
     */
    public void setYear(int n)
    {
        if(n<=MAX_PUBLISH_YEAR && n>=MIN_PUBLISH_YEAR)
            _yearPublished = n;
    }
    
    /**
     * Sets the book number of pages (only if valid).
     * @param n the number of pages to be set
     */
    public void setPages(int n)
    {
        if(n>=MIN_NUM_OF_PAGES)
            _noOfPages = n;
    }
   
    /**
     * Checks if this book is equal to other book.
     * @param other the book to compare this book to
     * @return true if this book and other book are the same; false otherwise
     */
    public boolean equals(Book other)
    {
        return _title.equals(other._title) && _author.equals(other._author) && 
        _yearPublished==other._yearPublished && _noOfPages==other._noOfPages;
    }
    
    /**
     * Returns a string representation of this book.
     * @Override toString in class java.lang.Object
     * @return representation of this book in the following format, 
     * for example, Title: Pride and Prejudice Author: Jane Austen Year: 1813, 350 pages
     */
    public String toString()
    {
        return "Title: "+_title+"\tAuthor: "+_author+"\tYear: "+_yearPublished+", "+_noOfPages+" pages";
    }
    
    /**
     * Checks if this book is older than other book.
     * @param other the book to compare to
     * @return true if this book is older than other book; false otherwise
     */
    public boolean olderBook(Book other)
    {
        return other._yearPublished>_yearPublished;
    }
    
    /**
     * Checks if this book and other book have same author.
     * @param other the book to compare to
     * @return true if this book and other book have same author; false otherwise
     */
    public boolean sameAuthor(Book other)
    {
        return _author.equals(other._author);
    }
    
    /**
     * Gets student name and borrow date and updates the appropriate book attributes.
     * @param name the student name
     * @param d borrow date
     */
    public void borrowBook(String name, Date d)
    {
        if(!_borrowed)
        {
            _borrowed = true;
            _borrowedDate = new Date(d);
            _studentName = name;
        }
    }
    
    /**
     * Gets return date and updates the appropriate book attributes.
     * @param d Gets return date and updates the appropriate book attributes.
     * @return true if student is late or book is not borrowed; false otherwise
     */
    public boolean returnBook(Date d)
    {
        if(!_borrowed)
            return true;
        //didn't change _returnDate!, as updated in forum
        _borrowed = false;
        _studentName = null;
        if(_returnDate.difference(d)>MAX_DAYS)
        {
            _borrowedDate = null;
            return true;
        }
        else
           return false;
    }
    
    /**
     * Gets today's date and if book is borrowed returns how many days the book is borrowed; 
     * otherwise returns 0.
     * @param d today's date
     * @return how many days the book is borrowed
     */
    public int howLongBorrowed(Date d)
    {
        if(!_borrowed)
            return DEFUALT_NUM_OF_DAYS_BORROWED;
        if(d.before(_borrowedDate))
            return DEFUALT_NUM_OF_DAYS_BORROWED;
        return d.difference(_borrowedDate);
    }
    
    /**
     * Checks if book is available.
     * @param d today's date
     * @return false if the book is borrowed; 
     * otherwise if book is not borrowed returns false if today's day is Friday or Saturday; 
     * otherwise returns true
     */
    public boolean isAvailable(Date d)
    {
        if(_borrowed)
            return false;
        int todayDay = d.dayInWeek();
        return !(todayDay==NUM_OF_FRIDAY || todayDay==NUM_OF_SATURDAY);
    }
    
    /**
     * Computes penalty given return date.
     * @param d return date
     * @return penalty if book is borrowed and student is late; 0 otherwise.
     */
    public int computePenalty(Date d)
    {
        int daysBorrowed = this.howLongBorrowed(d);
        if(daysBorrowed<=MAX_DAYS)
            return PENALTY_IF_BOOK_RETURNED_ON_TIME;
        if(daysBorrowed<=DAYS_BEFORE_DOUBLE_PENALTY)
            return (daysBorrowed-MAX_DAYS)*FINE_PER_DAY;
        return (DAYS_BEFORE_DOUBLE_PENALTY-MAX_DAYS)*FINE_PER_DAY + 
        (daysBorrowed-DAYS_BEFORE_DOUBLE_PENALTY)*FINE_PER_DAY*DOUBLE_PENALTY_MULTIPLIER;
    }
}