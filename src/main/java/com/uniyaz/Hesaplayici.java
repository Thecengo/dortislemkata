package com.uniyaz;

/*
*Butonlardan secilen islemlere göre satır ve sütunların bölme, çarpma, toplama ve çıkarma yapması amaçlanmıştır.
* eksi, arti, carpım, bolum metotları secilen butonun özelliğine göre davranış sergilemektedir.
* */
public class Hesaplayici {

    int sonButonDegeri;

    int artiToplamSutun;
    int artiToplamSatir;

    int eksiToplamSutun;
    int eksiToplamSatir;

    int carpimToplamSutun = 1;
    int carpimToplamSatir = 1;

    int bolumToplamSutun;
    int bolumToplamSatir;
    double bolumSatirSonuc = 1.0;
    double bolumSutunSonuc = 1.0;

    public void eksiSatirVeSutunuHesapla(MyButton[][] cellButtons){
        for (int i = 1; i < 5 ; i++) {
            for (int j = 1; j < 2; j++) {
                eksiToplamSutun = (int)cellButtons[i][j].getData() - eksiToplamSutun;
            }
        }
        for(int i = 1; i < 2 ; i++){
            for(int j = 1; j < 5 ; j++){
                eksiToplamSatir = (int) cellButtons[i][j].getData() - eksiToplamSatir;
            }
        }
    }

    public void artiSatirVeSutunuHesapla(MyButton[][] cellButtons){
        for (int i = 1; i < 5 ; i++) {
            for (int j = 2; j < 3; j++) {
                artiToplamSutun  = (int)cellButtons[i][j].getData() + artiToplamSutun ;
            }
        }
        for(int i = 2; i < 3 ; i++){
            for(int j = 1; j < 5 ; j++){
                artiToplamSatir = (int)cellButtons[i][j].getData() + artiToplamSatir;
            }
        }
    }

    public void carpimSatirVeSutunuHesapla(MyButton[][] cellButtons){
        for (int i = 1; i < 5 ; i++) {
            for (int j = 3; j < 4; j++) {
                carpimToplamSutun  = (int)cellButtons[i][j].getData() * carpimToplamSutun ;
            }
        }
        for(int i = 3; i < 4 ; i++){
            for(int j = 1; j < 5 ; j++){
                carpimToplamSatir = (int)cellButtons[i][j].getData() * carpimToplamSatir;
            }
        }
    }

    public void bolumSatirVeSutunuHesapla(MyButton[][] cellButtons){
        for (int i = 1; i < 5 ; i++) {
            for (int j = 4; j < 5; j++) {
                bolumToplamSutun  = (int)cellButtons[i][j].getData() + bolumToplamSutun ;
                sonButonDegeri = (int)cellButtons[i][j].getData();
            }
        }
        bolumSatirSonuc = bolumToplamSutun / sonButonDegeri;

        for(int i = 4; i < 5 ; i++){
            for(int j = 1; j < 5 ; j++){
                bolumToplamSatir = (int)cellButtons[i][j].getData() + bolumToplamSatir;
                sonButonDegeri = (int)cellButtons[i][j].getData();
            }
        }

        bolumSutunSonuc = bolumToplamSatir / sonButonDegeri;
    }
}
