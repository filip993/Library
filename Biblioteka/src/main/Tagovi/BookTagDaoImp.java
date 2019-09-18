package Tagovi;

public interface BookTagDaoImp {


    BookTag getBookT(int id);
    int  deleteTag(BookTag k);
    int insertTag(BookTag k);

}
