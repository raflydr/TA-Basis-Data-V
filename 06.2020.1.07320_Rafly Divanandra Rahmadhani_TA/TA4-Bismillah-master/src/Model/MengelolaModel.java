package Model;

import Database.KoneksiDB;
import Entity.JajanEntity;
import Entity.MengelolaEntity;
import Entity.TransaksiEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class MengelolaModel {
    String sql;
    public Connection conn = KoneksiDB.getconection();
    public MengelolaEntity mengelola = new MengelolaEntity();

    public ArrayList<MengelolaEntity> getMengelola() {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            String sql = "select *" +
                    "from mengelola ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MengelolaEntity mengelolaEntity = new MengelolaEntity();
                mengelolaEntity.setId_jajan(rs.getInt("id_jajan"));
                mengelolaEntity.setId_transaksi(rs.getInt("id_transaksi"));
                mengelolaEntity.setQty_jajan(rs.getInt("qty_jajan"));
                mengelolaEntity.setTotal_pembayaran(rs.getFloat("total_pembayaran"));
                mengelolaEntity.setBayar(rs.getFloat("bayar"));
                mengelolaEntity.setKembalian(rs.getFloat("kembalian"));
                mengelolaEntities.add(mengelolaEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mengelolaEntities;
    }

    public ArrayList<MengelolaEntity> getDetailTransaksi() {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            String sql = "select transaksi.*, jajan.nama_jajan, mengelola.qty_jajan, mengelola.total_pembayaran, " +
                    "mengelola.bayar, mengelola.kembalian from transaksi inner join mengelola on transaksi.id_transaksi=mengelola.id_transaksi " +
                    "inner join jajan on mengelola.id_jajan=jajan.id_jajan order by transaksi.id_transaksi ASC;";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MengelolaEntity mengelolaEntity = new MengelolaEntity();
                mengelolaEntity.setId_transaksi(rs.getInt("id_transaksi"));
                mengelolaEntity.setTgl_transaksi(rs.getDate("tgl_transaksi"));
                mengelolaEntity.setNama_jajan(rs.getString("nama_jajan"));
                //mengelolaEntity.setId_jajan(rs.getInt("id_jajan"));
                //mengelolaEntity.setId_transaksi(rs.getInt("id_transaksi"));
                mengelolaEntity.setQty_jajan(rs.getInt("qty_jajan"));
                //mengelolaEntity.setHarga_qty_jajan(rs.getFloat("harga_qty_jajan"));
                mengelolaEntity.setTotal_pembayaran(rs.getFloat("total_pembayaran"));
                //mengelolaEntity.setId_transaksi1(rs.getInt("id_transaksi"));
                //mengelolaEntity.setTgl_transaksi(rs.getDate("tgl_transaksi"));
                mengelolaEntity.setBayar(rs.getFloat("Bayar"));
                mengelolaEntity.setKembalian(rs.getFloat("kembalian"));
                mengelolaEntities.add(mengelolaEntity);
                //mengelolaEntities.add(transaksiEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mengelolaEntities;
    }

    public void updateStok(int qty_jajan, String nama_jajan){
        try {
            sql = "UPDATE jajan SET stok_jajan=stok_jajan-? WHERE nama_jajan = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, qty_jajan);
            statement.setString(2, nama_jajan);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Gagal Update");
            e.printStackTrace();
        }

    }

    public void viewMengelola(int id_transaksi){
        try {

            String sql = "select * from mengelola where id_transaksi=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_transaksi);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                mengelola.setId_jajan(rs.getInt("id_jajan"));
                System.out.println("Id jajan :" +rs.getInt("id_jajan"));
                mengelola.setId_transaksi(rs.getInt("id_transaksi"));
                System.out.println("Id transaksi :" +rs.getInt("id_transaksi"));
                mengelola.setQty_jajan(rs.getInt("qty_jajan"));
                System.out.println("Qty jajan :" +rs.getInt("qty_jajan"));
                mengelola.setTotal_pembayaran(rs.getFloat("total_pembayaran"));
                System.out.println("Total Pembayaran :" +rs.getFloat("total_pembayaran"));
                mengelola.setBayar(rs.getFloat("bayar"));
                System.out.println("Bayar :" +rs.getFloat("bayar"));
                mengelola.setKembalian(rs.getFloat("kembalian"));
                System.out.println("Kembalian :" +rs.getFloat("kembalian"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void insertDetail(MengelolaEntity mengelolaEntity){
        //int result = 0;
        try {
            sql = "insert into mengelola values ((select id_jajan from jajan where nama_jajan=?),(select id_transaksi from transaksi where id_transaksi=?),?,((select harga_jajan from jajan where nama_jajan=?)*?),?,((?-(select harga_jajan from jajan where nama_jajan=?)*?)))";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, mengelolaEntity.getNama_jajan());
            statement.setInt(2, mengelolaEntity.getId_transaksi());
            statement.setInt(3, mengelolaEntity.getQty_jajan());
            statement.setString(4, mengelolaEntity.getNama_jajan());
            statement.setInt(5, mengelolaEntity.getQty_jajan());
            statement.setFloat(6, mengelolaEntity.getBayar());
            statement.setFloat(7, mengelolaEntity.getBayar());
            statement.setString(8, mengelolaEntity.getNama_jajan());
            statement.setInt(9, mengelolaEntity.getQty_jajan());

            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Gagal Update");
            e.printStackTrace();
        }

    }
}
