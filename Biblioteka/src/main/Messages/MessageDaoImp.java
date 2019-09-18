package Messages;

public interface MessageDaoImp {

    Messages getMessage(int num);
    int insertMessage(Messages m);
    void DeleteMessage(Messages m);
}
