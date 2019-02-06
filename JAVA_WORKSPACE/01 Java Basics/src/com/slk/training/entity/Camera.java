package com.slk.training.entity;

public interface Camera {
	
	boolean hasFlash = true;
	
	public void takePicture();

	public void recordVideo();

	public void deletePicture();

	public void browserPictures();
}
