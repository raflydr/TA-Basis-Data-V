package Entity;

import java.util.Date;

public class TransaksiEntity {
    private int id_transaksi;
    private Date tgl_transaksi;

    public  TransaksiEntity() {
    }
    public TransaksiEntity(int id_transaksi, Date tgl_transaksi) {
        this.id_transaksi = id_transaksi;
        this.tgl_transaksi = tgl_transaksi;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }
    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Date getTgl_transaksi() {
        return tgl_transaksi;
    }
    public void setTgl_transaksi(Date tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

}
