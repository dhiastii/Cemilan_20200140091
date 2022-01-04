/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemilan_20200140091;

/**
 *
 * @author digitaldeveloper
 */
public class ProsesData {
    public Double harga(String HarSayur){
        Double hargaa = Double.valueOf(HarSayur);
        return hargaa;
    }
    public Double jumlahbeli(String JumBeli){
        Double jumlahsayuran= Double.valueOf(JumBeli);
        return jumlahsayuran;
    }
    public Double totalbayar(Double JumBayar, Double Diskon){
        Double totalbayar = JumBayar - Diskon;
        return totalbayar;
    }
    public Double jumlahbayar(Double HarSayur, Double JumBeli){
        Double jumlahbayar = HarSayur * JumBeli;
        return jumlahbayar;
    }
    public String Diskon (Double jumlahbayar){
    
        String Diskon = null;
        
        if (jumlahbayar < 16000) {
            Diskon = "0";
        }else if (jumlahbayar < 25000){
            Diskon = "10";
        }else{
            Diskon = "15";
        }
        return Diskon;
    }
    public Double JumDiskon(Double jumlahbayar, Integer Diskon){
        
        Double JumDiskon = jumlahbayar * Diskon/100;
    
        return JumDiskon;
    }
    public void HasilDiskon (Double totalbayar, Double jumlahbayar, Double JumDiskon, Integer Diskon){
        
        if(jumlahbayar < 16000){
            Diskon = 0;
            totalbayar = jumlahbayar - (jumlahbayar*Diskon/100);
            JumDiskon = jumlahbayar*Diskon/100;
            
        }else if( jumlahbayar < 25000){
            Diskon = 10;
            totalbayar = jumlahbayar - (jumlahbayar*Diskon/100);
            JumDiskon = jumlahbayar*Diskon/100;
        }else {
            Diskon = 15;
            totalbayar = jumlahbayar - (jumlahbayar*Diskon/100);
            JumDiskon = jumlahbayar*Diskon/100;
        }
    }
    
public String UangCust (Double duitorang, Double totalbayar){
        Double kembalian = duitorang - totalbayar;
        if(duitorang >= totalbayar){
            return "Kembalian Anda : Rp."+kembalian;
        }else{
            return "Uang Anda Kurang Rp"+kembalian;
        }
}
}
