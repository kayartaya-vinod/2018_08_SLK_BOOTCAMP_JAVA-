package com.slk.training.programs;

import com.slk.training.entity.InvalidNameException;
import com.slk.training.entity.InvalidPriceException;
import com.slk.training.entity.Product;

public class P08_ExceptionsDemo {
	
	public static void main(String[] args) throws InvalidPriceException, InvalidNameException {
		
		Product p1 = new Product();
		
		p1.setId(1);
		p1.setName(" ");
		p1.setPrice(-15000.0);
		
		System.out.println(p1);
	}

}
