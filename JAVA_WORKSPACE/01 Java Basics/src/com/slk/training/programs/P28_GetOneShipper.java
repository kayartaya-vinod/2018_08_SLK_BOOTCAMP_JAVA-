package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.slk.training.utils.DbUtil;
import com.slk.training.utils.KeyboardUtil;

public class P28_GetOneShipper {

	public static void main(String[] args) {
		
		int id = KeyboardUtil.getInt("Enter id for searching: ");
		String sql = "select * from shippers where shipper_id=?";
		
		try(
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("company_name"); // rs.getString(2)
				String phone = rs.getString("phone");
				
				System.out.println("Name     = " + name);
				System.out.println("Phone    = " + phone);
			}
			else {
				System.out.println("No data found for id " + id);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
