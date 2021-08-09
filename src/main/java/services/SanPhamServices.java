package services;

import dao.CRUDSanPham;
import models.SanPham;

import java.util.ArrayList;

public class SanPhamServices {
    CRUDSanPham crudSanPham = new CRUDSanPham();
    public ArrayList<SanPham> listSP = new ArrayList<>();


    public SanPhamServices() {
        try {
            listSP = crudSanPham.showSanPham();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void save(SanPham sanPham){
        try {
            crudSanPham.saveSanPham(sanPham);
            listSP = crudSanPham.showSanPham();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(SanPham sanPham,int index) {
        try {
            crudSanPham.editSanPham(sanPham);
            listSP = crudSanPham.showSanPham();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int index) {
        try {
            crudSanPham.deleteSanPham(listSP.get(index).getId());
            listSP = crudSanPham.showSanPham();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<SanPham> findByName(String ten) throws Exception {
        return crudSanPham.findByName(ten);
    }
}
