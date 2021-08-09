package models;

public class Catagory {
    private  int idCat;
    private int tenCat;

    public Catagory() {
    }

    public Catagory(int idCat, int tenCat) {
        this.idCat = idCat;
        this.tenCat = tenCat;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public int getTenCat() {
        return tenCat;
    }

    public void setTenCat(int tenCat) {
        this.tenCat = tenCat;
    }
}
