package Komentari;

public interface KomentarDAOImp {

    int insert(Komentari komentar);
    void update();
    Komentari getKoment(int id);
}
