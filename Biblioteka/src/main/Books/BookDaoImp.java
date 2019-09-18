package Books;

import java.util.List;

public interface BookDaoImp  {

    public int insert(Book b);
    public Book getBook(int num);
    public void DeleteBook(Book b);
    public void UpdateBook(Book b);
    List SearchBook(String search);
}
