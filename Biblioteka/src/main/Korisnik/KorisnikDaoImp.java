package Korisnik;

import java.util.List;

public interface KorisnikDaoImp {


        public List<Korisnik> getAllKorisnik();
        public int  deleteUser(Korisnik k);
        public int insertUser(Korisnik k);
        Korisnik getKorisnik(int num);

    }


