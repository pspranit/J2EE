package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Asset;

public class DAOAsset {
	 private Connection con;
	public DAOAsset(Connection conn) {
		this.con=conn;
	}
	public boolean addAsset(Asset asset) {
		
		boolean status=false;
		String query="insert into assets (name,os,version,screen_size,is5GSupported,notes)values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, asset.getName());
			preparedStatement.setString(2, asset.getOperatingSystem());
			preparedStatement.setString(3, asset.getVersion());
			preparedStatement.setString(4, asset.getScreenSize());
			preparedStatement.setString(5, asset.getIs5GSupported());
			preparedStatement.setString(6, asset.getNotes());
			
			int count=preparedStatement.executeUpdate();
			
			if(count == 1)
			{
				status=true;;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<Asset> showAsset()
	{
		List<Asset> assets=new ArrayList<Asset>();
		Asset asset=null;
		try {
			PreparedStatement preparedStatement=con.prepareStatement("select * from assets");
			ResultSet res=preparedStatement.executeQuery();
			
			while(res.next())
			{
				asset=new Asset();
				asset.setId(res.getInt(1));
				asset.setName(res.getString(2));
				asset.setOperatingSystem(res.getString(3));
				asset.setVersion(res.getString(4));
				asset.setScreenSize(res.getString(5));
				asset.setIs5GSupported(res.getString(6));
				asset.setNotes(res.getString(7));
				
				assets.add(asset);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assets;
	}

}
