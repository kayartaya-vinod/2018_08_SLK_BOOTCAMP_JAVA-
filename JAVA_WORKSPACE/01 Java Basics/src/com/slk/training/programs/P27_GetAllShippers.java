package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.slk.training.utils.DbUtil;

public class P27_GetAllShippers {

	public static void main(String[] args) {
		
		try(
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from shippers");
			ResultSet rs = stmt.executeQuery();
		){
			while(rs.next()) {
				int id = rs.getInt("shipper_id"); // rs.getInt(1)
				String name = rs.getString("company_name"); // rs.getString(2)
				String phone = rs.getString("phone");
				
				System.out.printf("%2d %-30s %-20s\n", id, name, phone);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
