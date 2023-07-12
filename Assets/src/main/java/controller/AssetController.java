package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;

import DAO.DAOAsset;
import model.Asset;

@WebServlet("/assetlink")
public class AssetController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String name=req.getParameter("name");
	String os=req.getParameter("dropdown");
	String version =req.getParameter("version");
	String screen=req.getParameter("radio");
	
	String is5GSupported=req.getParameter("checkbox");;
	String notes=req.getParameter("notes");
	
	Asset asset=new Asset(name, os, version, screen, is5GSupported, notes);
	DAOAsset asset2=new DAOAsset(DBConnect.getConn());
	boolean status=asset2.addAsset(asset);
	
	HttpSession session =req.getSession();
	
	if(status)
	{
		session.setAttribute("success", "Asset Added");
		resp.sendRedirect("showAssets.jsp");
	}
	else {
		session.setAttribute("success", " Something error on server");
		resp.sendRedirect("showAssets.jsp");
	}
	
	
	}

}
