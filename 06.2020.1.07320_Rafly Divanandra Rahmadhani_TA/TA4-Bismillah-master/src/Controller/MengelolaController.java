package Controller;

import Entity.MengelolaEntity;
import Model.JajanModel;
import Model.MengelolaModel;

import java.util.ArrayList;
import java.util.Date;

public class MengelolaController {
    public static MengelolaModel mengelolaModel = new MengelolaModel();

    public ArrayList<MengelolaEntity> getMengelola(){
        return new MengelolaModel().getMengelola();
    }

    public ArrayList<MengelolaEntity> getDetailTransaksi(){return mengelolaModel.getDetailTransaksi();}

    public void updateStok(int qty_jajan, String nama_jajan){
        mengelolaModel.updateStok(qty_jajan, nama_jajan);
    }

    public void viewMengelola(int id_transaksi){
        mengelolaModel.viewMengelola(id_transaksi);
    }

    public void insertDetail(String nama_jajan, int id_transaksi, int qty_jajan, float bayar ){
        MengelolaEntity mengelolaEntity = new MengelolaEntity();
        mengelolaEntity.setNama_jajan(nama_jajan);
        mengelolaEntity.setId_transaksi(id_transaksi);
        mengelolaEntity.setQty_jajan(qty_jajan);
        mengelolaEntity.setTotal_pembayaran(0);
        mengelolaEntity.setBayar(bayar);
        mengelolaEntity.setKembalian(0);

        mengelolaModel.insertDetail(mengelolaEntity);
    }
}
