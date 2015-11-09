

$(document).ready(function() {
	rotate("#screenshots", 10000);
	rotate("#newsticker", 5000);

	pimp_prettyphoto_videos();

	// documentation menu
	pimp_up_documentation_menu();

	// syntax coloring
	$('pre > code').filter(function() {
			return !($(this).attr('class') === undefined);
		}
	).each(function() {
		$(this).attr('class', $(this).attr('class').replace('language','lang'));
		$(this).addClass('prettyprint')
		$(this).addClass('linenums')
	})
	prettyPrint();

	// anchor fix
	scroll_if_anchor(window.location.hash);
	$("body").on("click", "a", scroll_if_anchor);

	// scroll up button
	$(window).scroll(function(){
	if ($(this).scrollTop() > 100) {
	  $('.scrollup').removeClass("animated fadeOutRight");
	  $('.scrollup').fadeIn().addClass("animated fadeInRight");
	} else {
	  $('.scrollup').removeClass("animated fadeInRight");
	  $('.scrollup').fadeOut().addClass("animated fadeOutRight");
	}
	});

	$('.scrollup, .navbar-brand').click(function(){
		$("html, body").animate({ scrollTop: 0 }, 'slow', function(){
			$("nav li a").removeClass('active');
		});
		return false;
	});
	

	$('.has-popover').popover({
		trigger: 'click hover',
		delay: { show: 100, hide: 50 },
		placement: "bottom"
	});

	var po = document.createElement('script');
	po.type = 'text/javascript';
	po.async = true;
	po.src = 'https://apis.google.com/js/plusone.js';
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(po, s);
});


function pimp_prettyphoto_videos() {
	$('a[data-rel]').each(function() {
		$(this).attr('rel', $(this).data('rel'));
	});

	$("a[rel^='prettyPhoto']").prettyPhoto({
		animation_speed: 'fast',
		slideshow: 5000,
		autoplay_slideshow: false,
		opacity: 0.80,
		show_title: true,
		theme: 'ligh_square',
		overlay_gallery: false,
		social_tools: false
	});

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
}

/**
 * Check a href for an anchor. If exists, and in document, scroll to it.
 * If href argument ommited, assumes context (this) is HTML Element,
 * which will be the case when invoked by jQuery after an event
 */
function scroll_if_anchor(href) {
    href = typeof(href) == "string" ? href : $(this).attr("href");
    
    if (href == null || href == undefined) {
    	return;
    }
    href = href.substring(href.indexOf("#"))
    // You could easily calculate this dynamically if you prefer
    var fromTop = 60;
    
    // If our Href points to a valid, non-empty anchor, and is on the same page (e.g. #foo)
    // Legacy jQuery and IE7 may have issues: http://stackoverflow.com/q/1593174
    if(href.indexOf("#") == 0) {
        var $target = $(href);
        
        // Older browser without pushState might flicker here, as they momentarily
        // jump to the wrong position (IE < 10)
        if($target.length) {
            $('html, body').animate({ scrollTop: $target.offset().top - fromTop });
            if(history && "pushState" in history) {
                history.pushState({}, document.title, window.location.pathname + href);
                return false;
            }
        }
    }
}    

/**
 * Adds second level anchors to the documentation menu for every
 * to <h2> tags with id.
 */
function pimp_up_documentation_menu() {
	var path = window.location.pathname.split('/');
	var lastSegment = path[path.length - 1];
	$('#nav-outline > li > a[href$="'+lastSegment+'"]').each(function() {        
		var sections = $('.doc-contents > h2[id]')
		if (sections.length > 0) {
			var contents = '<ul>';
			for (i = 0; i < sections.length; i++) {
				var section = sections[i];
				contents += '<li><a href="#'+section.id+'">'+$(section).text()+'</a></li>';
			}
			$(this).parent().append(contents+'</ul>');
		}
	});
}

function rotate(id, timeout) {
	var elements = $(id+" li");
	var showNext = function (index) {
	    if (index >= elements.length) {
	        index = 0;
	    }
	    elements.hide().slice(index, index+1).fadeIn();
	    setTimeout(function(){ showNext(index+1) }, timeout);
	}
	showNext(Math.floor((Math.random() * elements.length) + 1));
}
