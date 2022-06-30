package Entity;
import java.util.Date;
import Entity.TransaksiEntity;

public class MengelolaEntity extends TransaksiEntity{
    TransaksiEntity transaksiEntity = new TransaksiEntity();
    private int id_jajan, id_transaksi, qty_jajan;
    private float total_pembayaran, bayar, kembalian;
    private Date tgl_transaksi;
    private int id_transaksi1;
    private String nama_jajan;

    public  MengelolaEntity() {
    }

    public MengelolaEntity(int id_jajan, int id_transaksi, int qty_jajan, float total_pembayaran, float bayar, float kembalian, String nama_jajan){
        this.id_jajan = id_jajan;
        this.id_transaksi = id_transaksi;
        this.qty_jajan = qty_jajan;
        this.total_pembayaran = total_pembayaran;
        this.bayar = bayar;
        this.kembalian = kembalian;
        this.nama_jajan = nama_jajan;
    }

    public int getId_jajan() {
        return id_jajan;
    }
    public void setId_jajan(int id_jajan) {
        this.id_jajan = id_jajan;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }
    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getQty_jajan() {
        return qty_jajan;
    }
    public void setQty_jajan(int qty_jajan) {
        this.qty_jajan = qty_jajan;
    }

    public float getBayar(){
        return bayar;
    }
    public void setBayar(float bayar){
        this.bayar = bayar;
    }

    public float getKembalian(){
        return kembalian;
    }
    public void setKembalian(float kembalian){
        this.kembalian = kembalian;
    }

    public String getNama_jajan(){
        return nama_jajan;
    }
    public void setNama_jajan(String nama_jajan){
        this.nama_jajan = nama_jajan;
    }



    public Date getTgl_transaksi(){
        return tgl_transaksi;
    }
    public void setTgl_transaksi(Date tgl_transaksi){
        this.tgl_transaksi = tgl_transaksi;
    }

    public float getTotal_pembayaran() {
        return total_pembayaran;
    }
    public void setTotal_pembayaran(float total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }
}
