package com.slk.training.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.slk.training.utils.DbUtil;
import com.slk.training.utils.KeyboardUtil;

public class P25_InsertNewShipperRecord {

	public static void main(String[] args) {
		
		try (
			Connection conn = DbUtil.getConnection();
			Statement stmt = conn.createStatement();
		) {
			System.out.println("Enter shipper details: ");
			int id = KeyboardUtil.getInt("Id    >> ");
			String name = KeyboardUtil.getString("Name  >> ");
			String phone = KeyboardUtil.getString("Phone >> ");

			// insert into shippers values (4, 'KVinod Transports', '9292727722')
			String sql = String.format("insert into shippers values(%d, '%s', '%s')", 
					id, name, phone);
			// potential scope for SQL injection; totally avoid this
			
			stmt.executeUpdate(sql);
			System.out.println("Data inserted successfully!");
		}
		catch(Exception ex) {
			System.out.println("There was a problem!");
			ex.printStackTrace();
		}
		// at the end of this try-catch execution, 
		// conn.close() and stmt.close() will be automatically called
		
		
	}
}
