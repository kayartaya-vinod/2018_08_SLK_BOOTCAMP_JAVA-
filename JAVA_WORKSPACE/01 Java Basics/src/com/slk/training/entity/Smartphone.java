package com.slk.training.entity;

// an object of Smartphone class is 
// an instanceof Smartphone
// an instanceof Camera
// an instanceof Object
public class Smartphone implements Camera {

	public void makeCall() {
		System.out.println("Calling....");
	}

	public void viewContacts() {
		System.out.println("Viewing contacts...");
	}

	@Override
	public void takePicture() {
		System.out.println("Taking picture using smartphone");
	}

	@Override
	public void recordVideo() {
		System.out.println("Recording video using smartphone");
	}

	@Override
	public void deletePicture() {
		System.out.println("Deleting picture from smartphone");

	}

	@Override
	public void browserPictures() {
		System.out.println("Browsing pictures in smartphone");

	}
}
