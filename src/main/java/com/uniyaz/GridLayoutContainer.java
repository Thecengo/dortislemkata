package com.uniyaz;


import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;

import java.util.concurrent.ThreadLocalRandom;

public class GridLayoutContainer extends GridLayout {

    KontrolEdici kontrolEdici = new KontrolEdici();
    Hesaplayici hesaplayici = new Hesaplayici();

    int tiklananDegerI;
    int tiklananDegerJ;

    public MyButton [][] cellButtons = new MyButton[6][6];
    int length = cellButtons.length;

    public GridLayoutContainer() {
        super(6,6);

        buildButton();
        assignFirstRowAndColumn();
        butonlardanIslemSec();
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
               if(kontrolEdici.ilkSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.EKSI_OPERAND);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.EKSI_OPERAND);
               }
               else if(kontrolEdici.ikinciSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.ARTI_OPERAND);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.ARTI_OPERAND);
               }
               else if(kontrolEdici.ucuncuSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.CARP_OPERAND);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.CARP_OPERAND);
               }
               else if(kontrolEdici.dorduncuSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.BOL_OPERAND);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.BOL_OPERAND);
               }
               else if(kontrolEdici.besinciSatirVeyaSutunMu(i, j)){
                   cellButtons[i][j].setData(GridBaslikOlusturucu.SONUC_YAZİSİ);
                   cellButtons[i][j].setCaption(GridBaslikOlusturucu.SONUC_YAZİSİ);
               }
            }
        }
    }

    public void islemYapilacakButonlaraSayiAta(int length){
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                int randomInt = ThreadLocalRandom.current().nextInt(-20, 20);
               if(!kontrolEdici.kenarMi(i,j,5)){
                   cellButtons[i][j].setCaption(randomInt+"");
                   cellButtons[i][j].setData((int)randomInt);
               }
            }
        }
    }



    public void butonlardanIslemSec(){
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

                        if(kontrolEdici.ilkSatirVeyaSutunMu(tempI,tempJ)){
                            hesaplayici.eksiSatirVeSutunuHesapla(cellButtons);
                            sonucYaz(tempI, tempJ, hesaplayici.eksiToplamSutun, hesaplayici.eksiToplamSatir);
                        }
                        else if(kontrolEdici.ikinciSatirVeyaSutunMu(tempI, tempJ)){
                            hesaplayici.artiSatirVeSutunuHesapla(cellButtons);
                           sonucYaz(tempI, tempJ, hesaplayici.artiToplamSutun, hesaplayici.artiToplamSatir);
                        }
                        else if(kontrolEdici.ucuncuSatirVeyaSutunMu(tempI,tempJ)){
                            hesaplayici.carpimSatirVeSutunuHesapla(cellButtons);
                            sonucYaz(tempI, tempJ, hesaplayici.carpimToplamSutun, hesaplayici.carpimToplamSatir);
                        }
                        else if(kontrolEdici.dorduncuSatirVeyaSutunMu(tempI, tempJ)){
                            hesaplayici.bolumSatirVeSutunuHesapla(cellButtons);

                            if(tempI == 0){
                                cellButtons[length-1][tempJ].setCaption(hesaplayici.bolumSutunSonuc+"");
                            }
                            else
                                cellButtons[tempI][length-1].setCaption(hesaplayici.bolumSatirSonuc+"");
                        }
                    }
                });
            }
        }
    }

    private void sonucYaz(int tempI, int tempJ, int sutunDegeri, int satirDegeri) {
        if(tempI == 0){
            cellButtons[length-1][tempJ].setCaption(sutunDegeri+"");
        }
        else
            cellButtons[tempI][length-1].setCaption(satirDegeri+"");
    }
}
