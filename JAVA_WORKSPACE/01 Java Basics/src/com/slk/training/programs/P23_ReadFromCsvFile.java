package com.slk.training.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.slk.training.entity.Friend;

public class P23_ReadFromCsvFile {
	
	public static void main(String[] args) throws Exception {
		
		Map<Integer, Friend> friends = new HashMap<>();
		
		// 1. open the file for reading (FileReader)
		FileReader file = new FileReader("people.csv");
		
		// 2. to read line-by-line create a BufferedReader (decorator)
		BufferedReader in = new BufferedReader(file);
		
		String line = in.readLine(); // skip the header line
		
		// 3. use a loop for reading line-by-line until there is nothing to read
		while(true) {
			// 3a. read a line
			line = in.readLine();
				
			if(line==null) break;
			
			// 3b. use the String.split() to cut the line into fields
			String[] fields = line.split(",");
			
			// 3c. create a Friend object, and pass the fields into the object via setters
			Friend f = new Friend();
			f.setId(Integer.parseInt(fields[0]));
			f.setName(fields[1]);
			f.setEmail(fields[2]);
			f.setGender(fields[3]);
			f.setPhone(fields[4]);
			
			// 3d. put this object in the Map friends, with id as the key
			friends.put(f.getId(), f);
			
			// 3e. repeat the loop
		}
		
		// 4. close the streams opened (BufferedReader, FileReader)
		in.close();
		file.close();
		
		// 5. process the map
		for(Integer id: friends.keySet()) {
			Friend f = friends.get(id);
			System.out.println(f);
		}
		
	}

}
