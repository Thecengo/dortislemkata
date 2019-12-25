package com.uniyaz;


import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;

import java.util.concurrent.ThreadLocalRandom;

public class GridLayoutContainer extends GridLayout {

    int tiklananDegerI;
    int tiklananDegerJ;

    int artiToplamSutun;
    int artiToplamSatir;

    int eksiToplamSutun = 0;
    int eksiToplamSatir = 0;

    int carpimToplamSutun = 1;
    int carpimToplamSatir = 1;

    int bolumToplamSutun = 0;
    int bolumToplamSatir = 0;
    double bolumSatirSonuc = 1;
    double bolumSutunSonuc = 1;
    int sonButonDegeri = 0;

    public MyButton [][] cellButtons = new MyButton[6][6];

    int length = cellButtons.length;
    public GridLayoutContainer() {
        super(6,6);

        buildButton();
        assignFirstRowAndColumn();
        secilenIslemiButondanDinle();
        islemYapilacakButonlaraSayiAta(5);

    }

    public void buildButton(){
        for (int i = 0; i < 6 ; i++){
            for (int j = 0; j < 6 ; j++){
                cellButtons[i][j] = new MyButton();
                addComponent(cellButtons[i][j]);
            }
        }
    }

    public void assignFirstRowAndColumn(){
        for (int i = 0; i < 6 ; i++){
            for (int j = 0; j < 6 ; j++){
               if(ilkSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.EKSI_OPERAND);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.EKSI_OPERAND);
               }
               else if(ikinciSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.ARTI_OPERAND);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.ARTI_OPERAND);
               }
               else if(ucuncuSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.CARP_OPERAND);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.CARP_OPERAND);
               }
               else if(dorduncuSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.BOL_OPERAND);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.BOL_OPERAND);
               }
               else if(besinciSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.SONUC_YAZİSİ);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.SONUC_YAZİSİ);
               }
            }
        }
    }

    private boolean besinciSatirVeyaSutunMu(int i, int j) {
        return i == 0 && j == 5 || i == 5 && j == 0;
    }

    private boolean dorduncuSatirVeyaSutunMu(int i, int j) {
        return i == 0 && j == 4 || i == 4 && j == 0;
    }

    private boolean ucuncuSatirVeyaSutunMu(int i, int j) {
        return i == 0 && j == 3 || i == 3 && j == 0;
    }

    private boolean ikinciSatirVeyaSutunMu(int i, int j) {
        return i == 0 && j == 2 || i == 2 && j == 0;
    }

    private boolean ilkSatirVeyaSutunMu(int i, int j) {
        return i==0 && j==1 ||j==0 && i==1;
    }

    public void islemYapilacakButonlaraSayiAta(int length){
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                int randomInt = ThreadLocalRandom.current().nextInt(-20, 20);
               if(!kenarMi(i,j,5)){
                   cellButtons[i][j].setCaption(randomInt+"");
                   cellButtons[i][j].setData((int)randomInt);
               }
            }
        }
    }

    public void eksiSatirVeSutunuHesapla(){
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
        System.out.printf("eksi toplam satir : %d  eksi toplam sutun : %d",eksiToplamSatir,eksiToplamSutun);
    }

    public void artiSatirVeSutunuHesapla(){
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

        System.out.printf("arti toplam satir : %d  arti toplam sutun : %d",artiToplamSutun,artiToplamSatir);
    }

    public void carpimSatirVeSutunuHesapla(){
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

        System.out.printf("carpi toplam satir : %d  carp toplam sutun : %d",carpimToplamSutun,carpimToplamSatir);
    }

    public void bolumSatirVeSutunuHesapla(){
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
        System.out.printf("bolum toplam satir : %f  bolum toplam sutun : %f", bolumSatirSonuc, bolumSutunSonuc);
    }

    public boolean kenarMi(int i, int j, int length){
        return i == 0 || j == 0 ;
    }

    public void secilenIslemiButondanDinle(){
        for (int i = 0; i < 5 ; i++){
            for (int j = 0; j < 5 ; j++){
                int tempI = i;
                int tempJ = j;
                cellButtons[i][j].addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        Notification.show(tempI +""+ tempJ);
                        tiklananDegerI = tempI;
                        tiklananDegerJ = tempJ;
                        if(ilkSatirVeyaSutunMu(tempI,tempJ)){
                            eksiSatirVeSutunuHesapla();
                            sonucYaz(tempI, tempJ, eksiToplamSutun, eksiToplamSatir);
                        }
                        else if(ikinciSatirVeyaSutunMu(tempI, tempJ)){
                            artiSatirVeSutunuHesapla();
                           sonucYaz(tempI, tempJ, artiToplamSutun, artiToplamSatir);
                        }
                        else if(ucuncuSatirVeyaSutunMu(tempI,tempJ)){
                            carpimSatirVeSutunuHesapla();
                            sonucYaz(tempI, tempJ, carpimToplamSutun, carpimToplamSatir);
                        }
                        else if(dorduncuSatirVeyaSutunMu(tempI, tempJ)){
                            bolumSatirVeSutunuHesapla();
                            if(tempI == 0){
                                cellButtons[length-1][tempJ].setCaption(bolumSutunSonuc+"");
                            }
                            else
                                cellButtons[tempI][length-1].setCaption(bolumSatirSonuc+"");
                        }
                    }
                });
            }
        }

        System.out.printf("%d %d",tiklananDegerI,tiklananDegerJ);

    }

    private void sonucYaz(int tempI, int tempJ, int sutunDegeri, int satirDegeri) {
        if(tempI == 0){
            cellButtons[length-1][tempJ].setCaption(sutunDegeri+"");
        }
        else
            cellButtons[tempI][length-1].setCaption(satirDegeri+"");
    }
}
