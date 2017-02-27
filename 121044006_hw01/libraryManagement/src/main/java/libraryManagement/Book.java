package libraryManagement;

import java.util.ArrayList;

/**
 * Created by egc on 2/24/2017.
 */
public class Book {
    /**
     * name of book
     */
    private String bookName;
    /**
     * name of author
     */
    private String author;
    /**
     * stock state
     */
    private boolean stock;

    /**
     * person who is get book
     */
    protected AbstractPerson libUser = new LibUser();

    /**
     * constractor
     * @param _bookName name of book
     * @param _author author of book
     * @param _stock stock state of book
     */
    public Book(String _bookName,String _author,boolean _stock){
        bookName=_bookName;
        author=_author;
        stock=_stock;
    }

    /**
     * default constractor
     */
    public  Book(){
        bookName="";
        author="";
        stock=true;
    }

    /**
     *
     * @param _bookName  of book
     */
    public void setBookName(String _bookName){
        bookName=_bookName;
        author="";
        stock=true;
    }

    /**
     *
     * @param _author of book
     */
    public void setAuthor(String _author){
        author=_author;
    }

    /**
     *
     * @param _stock state of book
     */
    public void setStock(boolean _stock){
        stock = _stock;
    }

    /**
     *
     * @return name of book
     */
    public String getBookName(){
        return bookName;

    }

    /**
     *
     * @return author of book
     */
    public String getAuthor(){
        return author;
    }

    /**
     *
     * @return stock state of book
     */
    public boolean getStock(){
        return stock;
    }


}

