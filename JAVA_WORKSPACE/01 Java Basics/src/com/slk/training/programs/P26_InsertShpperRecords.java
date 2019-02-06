package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.slk.training.utils.DbUtil;
import com.slk.training.utils.KeyboardUtil;

public class P26_InsertShpperRecords {

	public static void main(String[] args) {
		
		String sql = "insert into shippers values(?, ?, ?)"; // not an SQL syntax
		
		try(Connection conn = DbUtil.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			// conn.prepareStatement(sql); sends the actual command to the server
			// which gets parsed, and compiled into backend native format, stored
			// in users's session on the server, and comes back with a reference to the same
			
			while(true) {
				System.out.println("Enter shipper details: ");
				int id = KeyboardUtil.getInt("Id    >> ");
				String name = KeyboardUtil.getString("Name  >> ");
				String phone = KeyboardUtil.getString("Phone >> ");
				
				// before sending the values to the server for execution
				// set the same with the stmt
				stmt.setInt(1, id);
				stmt.setString(2,  name);
				stmt.setString(3, phone);
				
				// now execute the command
				stmt.executeUpdate(); 
				// sends the data to the server, which executes 
				// the pre-compiled sql command with these values
				
				System.out.println("Record inserted!");
				
				String ans = KeyboardUtil.getString("Wish to add one more? yes/no (yes): ");
				if(ans.equalsIgnoreCase("no")) {
					break;
				}

			}
			
		}
		catch(Exception ex) {
			System.out.println("there was an error: " + ex);
		}
		
	}
}
