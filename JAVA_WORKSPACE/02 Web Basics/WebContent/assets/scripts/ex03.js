// document.ready event handler
$(function() {

	var images = [ "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg",
			"7.jpg", "8.jpg", "9.jpg", "10.jpg" ];

	for (var i = 0; i < images.length; i++) {
		var image = "assets/images/" + images[i];
		$("<img>").attr("src", image)
			.addClass("slide")
			.appendTo($("#images"));
	}

	changeSlide();
});

function changeSlide() {
	// $("#images > img:last").prependTo($("#images"));
	$("#images > img:last").fadeOut(2000, function(){
		$(this).prependTo($("#images"))
			.css("display", "inline-block");
	});
	
	setTimeout(changeSlide, 2000);
}