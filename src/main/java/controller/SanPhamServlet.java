package controller;

import models.SanPham;
import services.SanPhamServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/sanpham")
public class SanPhamServlet extends HttpServlet {
    SanPhamServices sanPhamServices = new SanPhamServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                requestDispatcher = request.getRequestDispatcher("views/createSanPham.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "edit":
                int indexEdit = Integer.parseInt(request.getParameter("index"));
                request.setAttribute("sanpham", sanPhamServices.listSP.get(indexEdit));
                requestDispatcher = request.getRequestDispatcher("views/editSanPham.jsp");
                requestDispatcher.forward(request, response);
                break;
            case  "delete":
                int indexDelete = Integer.parseInt(request.getParameter("index"));
                try {
                    sanPhamServices.delete(indexDelete);
                    request.setAttribute("listSP", sanPhamServices.listSP);
                    requestDispatcher = request.getRequestDispatcher("/sanpham");
                    requestDispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "findName":
                String ten = request.getParameter("findName");
                try {
                    request.setAttribute("listSP", sanPhamServices.findByName(ten));
                    requestDispatcher = request.getRequestDispatcher("/sanpham");
                    requestDispatcher.forward(request, response);
                } catch (Exception e) {
                   e.printStackTrace();
                }
                break;
            default:
                request.setAttribute("listSP",sanPhamServices.listSP);
                requestDispatcher = request.getRequestDispatcher("views/showSanPham.jsp");
                requestDispatcher.forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;

        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        Double gia = Double.valueOf(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String mauSac = request.getParameter("mauSac");
        String mota = request.getParameter("mota");
        int idDanhMuc = Integer.parseInt(request.getParameter("idDanhMuc"));
        SanPham sanPham = new SanPham(id, ten, gia, soLuong, mauSac, mota, idDanhMuc);

        switch (action){
            case "create":
                try {
                    sanPhamServices.save(sanPham);

                }catch (Exception e){
                    e.printStackTrace();
                }
            case "edit" :
                try {
                    int index = Integer.parseInt(request.getParameter("index"));
                    sanPhamServices.edit(sanPham, index);
                }catch (Exception e){
                    e.printStackTrace();
                }

        }




    }

    }