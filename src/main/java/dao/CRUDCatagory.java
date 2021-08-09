package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDCatagory {
    private ConnectionSQL connectionSQL;

    public CRUDCatagory() {
        connectionSQL = new ConnectionSQL();
    }
        public List<String> selectAllCategory() {
            List<String> listCategory = new ArrayList<>();
            String SELECT_ALL_CATEGORY = "select * from Category";
            try {
                PreparedStatement pS = connectionSQL.getConnection().prepareStatement(SELECT_ALL_CATEGORY);
                ResultSet rs = pS.executeQuery();
                while (rs.next()) {
                    String danhmuc = rs.getString("danhmuc");
                    listCategory.add(danhmuc);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return listCategory;
        }

}
