/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemilan_20200140091;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author digitaldeveloper
 */
@Controller
public class DataController {
    @RequestMapping("/input")
    //@ResponseBody
    public String inputdata(HttpServletRequest data, Model sayuran){
        ProsesData pd = new ProsesData();
        
        String namasayur = data.getParameter("namasayur");
        String harga = data.getParameter("hargaperkilo");
        String jumlah = data.getParameter("jumlahbeli");
        String uangcustomer = data.getParameter("uangcustomer");
        
        Double hargaa = pd.harga(harga);
        Double jumlahsayur = pd.jumlahbeli(jumlah);
        Double jumlahbayar = pd.jumlahbayar(hargaa, jumlahsayur);
        String diskon = pd.Diskon(jumlahbayar);
        Double jumlahdiskon = pd.JumDiskon(jumlahbayar, Integer.valueOf(diskon));
        Double totalbayar = pd.totalbayar(jumlahbayar, jumlahdiskon);
        pd.HasilDiskon(totalbayar, jumlahbayar, jumlahdiskon, Integer.valueOf(diskon));
        String uangkembalian = pd.UangCust(Double.valueOf(uangcustomer), totalbayar);
        
        
        sayuran.addAttribute("nama", namasayur);
        sayuran.addAttribute("harga", hargaa);
        sayuran.addAttribute("jumlahbeli", jumlah);
        sayuran.addAttribute("uangcust", uangcustomer);
        sayuran.addAttribute("jumlahawal", jumlahbayar);
        sayuran.addAttribute("ddiskon", diskon);
        sayuran.addAttribute("jumlahdiskon", jumlahdiskon);
        sayuran.addAttribute("totalbayar", totalbayar);
        sayuran.addAttribute("kembalian", uangkembalian);
      
        return "Showw";
    }
}
