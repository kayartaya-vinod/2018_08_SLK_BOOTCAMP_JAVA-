package com.slk.training.programs;

import com.slk.training.entity.Camera;
import com.slk.training.entity.DigitalCamera;
import com.slk.training.entity.Smartphone;

public class P10_PolymorphismDemo {

	public static void main(String[] args) {
		
		// reference of an interface can be created
		// but an object an interface type cannot be created!
		Camera c1;
		
		// an object of an interface is "REALIZED" using a class
		// that implements the interface
		
		// For example, an object of a camera can be realized using
		// an object of Smartphone or DigitalCamera classes
		
		c1 = new DigitalCamera();
		c1.takePicture();
		c1.browserPictures();
		
		
		System.out.println();
		
		c1 = new Smartphone();
		c1.takePicture();
		c1.browserPictures();
		
		
		
		
	}
}
