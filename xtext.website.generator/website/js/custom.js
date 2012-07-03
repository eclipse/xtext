// JavaScript Document for Theflow
			
$(document).ready(function() {

//Thumbnail hover effect for gallery
$('.thumb').hover(function(){  
	$(this).find(".zoom_icon").animate({opacity: 1}, 300);
	}  
	, function(){  
	$(this).find(".zoom_icon").animate({opacity: 0.0}, 300);
});

$('.introduction').hover(function(){  
	$(this).find(".zoom_icon").animate({opacity: 1}, 300);
	}  
	, function(){  
	$(this).find(".zoom_icon").animate({opacity: 0.4}, 300);
});

}); //close document.ready


