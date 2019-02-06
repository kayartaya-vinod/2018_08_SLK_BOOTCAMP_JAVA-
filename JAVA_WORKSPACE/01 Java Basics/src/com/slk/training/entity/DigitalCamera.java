package com.slk.training.entity;

public class DigitalCamera implements Camera {
	
	public void adjustBrightness() {
		System.out.println("Adjusting brightness using digital camera");
	}
	
	public void adjustFocalLength() {
		System.out.println("Adjusting focal length using digital camera");
	}

	@Override
	public void takePicture() {
		System.out.println("Taking picture using digital camera");
	}

	@Override
	public void recordVideo() {
		System.out.println("Recording video using digital camera");
	}

	@Override
	public void deletePicture() {
		System.out.println("Deleting picture from digital camera");
	}

	@Override
	public void browserPictures() {
		System.out.println("Browsing pictures in digital camera");
	}

}
