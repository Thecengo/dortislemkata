package com.uniyaz;

/*
*Hesaplamalarin hangi satır veya sutuna ait olacağını belirlemek için bu sınıf olusturulmustur.
* */
public class KontrolEdici {

    public boolean besinciSatirVeyaSutunMu(int i, int j) {
        return i == 0 && j == 5 || i == 5 && j == 0;
    }

    public boolean dorduncuSatirVeyaSutunMu(int i, int j) {
        return i == 0 && j == 4 || i == 4 && j == 0;
    }

    public boolean ucuncuSatirVeyaSutunMu(int i, int j) {
        return i == 0 && j == 3 || i == 3 && j == 0;
    }

    public boolean ikinciSatirVeyaSutunMu(int i, int j) {
        return i == 0 && j == 2 || i == 2 && j == 0;
    }

    public boolean ilkSatirVeyaSutunMu(int i, int j) {
        return i==0 && j==1 ||j==0 && i==1;
    }

    public boolean kenarMi(int i, int j, int length){
        return i == 0 || j == 0 ;
    }
}
