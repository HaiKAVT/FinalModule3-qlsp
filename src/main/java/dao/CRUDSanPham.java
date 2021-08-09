package dao;

import models.SanPham;

import java.sql.*;
import java.util.ArrayList;

public class CRUDSanPham {
    static Connection connection = ConnectionSQL.getConnection();

    public static ArrayList<SanPham> showSanPham() throws Exception {
        String sqlSelect = "SELECT id, ten, gia, soluong, mausac, danhmuc FROM quanlysanpham.sanpham;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSelect);
        ArrayList<SanPham> listSP = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ten = resultSet.getString("ten");
            Double gia = resultSet.getDouble("gia");
            int  soLuong= resultSet.getInt("soLuong");
            String mauSac = resultSet.getString("mauSac");
           String mota = resultSet.getString("mota");
           int idDanhMuc = resultSet.getInt("idDanhMuc");
           listSP.add(new SanPham(id, ten, gia, soLuong, mauSac, mota, idDanhMuc));

        }
        return listSP;
    }
    public void saveSanPham(SanPham sanPham) throws Exception {
        String sqlSave = "insert into sanpham value(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSave);

        preparedStatement.setInt(1, sanPham.getId());
        preparedStatement.setString(2, sanPham.getTen());
        preparedStatement.setDouble(3, sanPham.getGia());
        preparedStatement.setInt(4, sanPham.getSoLuong());
        preparedStatement.setString(5, sanPham.getMauSac());
        preparedStatement.setString(5, sanPham.getMota());
        preparedStatement.setInt(1, sanPham.getIdDanhMuc());

        preparedStatement.execute();
    }
    public void editSanPham(SanPham sanPham) throws SQLException {
        String sqlEdit = "update sanpham set ten=?,gia=?,soluong=?,mausac=?, mota=?, danhmuc=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlEdit);
        preparedStatement.setInt(7, sanPham.getId());
        preparedStatement.setString(1, sanPham.getTen());
        preparedStatement.setDouble(2, sanPham.getGia());
        preparedStatement.setInt(3, sanPham.getSoLuong());
        preparedStatement.setString(4, sanPham.getMauSac());
        preparedStatement.setString(5, sanPham.getMota());
        preparedStatement.setInt(6, sanPham.getIdDanhMuc());
        preparedStatement.execute();
    }
    public void deleteSanPham(int id) throws SQLException {
        String sqldelete = "delete from sanpham where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqldelete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();

    }
    public static ArrayList<SanPham> findByName(String findName) throws SQLException {
        ArrayList<SanPham> findList = new ArrayList<>();
        String findByName = "select * from sanpham where ten like '%" + findName + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(findByName);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String ten = resultSet.getString("ten");
            Double gia = Double.parseDouble(resultSet.getString("gia"));
            int soLuong = Integer.parseInt(resultSet.getString("soLuong"));
            String mauSac = resultSet.getString("mauSac");
            String mota = resultSet.getString("mota");
            int idDanhMuc = Integer.parseInt(resultSet.getString("idDanhMuc"));

            findList.add(new SanPham(id, ten, gia, soLuong, mauSac, mota,idDanhMuc));
        }
        return findList;

    }
}
