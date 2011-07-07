/*
	jQuery Coda-Slider v2.0 - http://www.ndoherty.biz/coda-slider
	Copyright (c) 2009 Niall Doherty
	This plugin available for use in all personal or commercial projects under both MIT and GPL licenses.
*/

var sliderCount = 1;

$.fn.codaSlider = function(settings) {

	settings = $.extend({
		autoHeight: true,
		autoHeightEaseDuration: 1000,
		autoHeightEaseFunction: "easeInOutExpo",
		autoSlide: false,
		autoSlideInterval: 7000,
		autoSlideStopWhenClicked: true,
		crossLinking: true,
		dynamicArrows: true,
		dynamicArrowLeftText: "&#171; left",
		dynamicArrowRightText: "right &#187;",
		dynamicTabs: true,
		dynamicTabsAlign: "center",
		dynamicTabsPosition: "top",
		externalTriggerSelector: "a.xtrig",
		firstPanelToLoad: 1,
		panelTitleSelector: "h2.title",
		slideEaseDuration: 1000,
		slideEaseFunction: "easeInOutExpo"
	}, settings);
	
	return this.each(function(){
		
		var slider = $(this);
		var sliderId = this.id;
		
		// If we need arrows
		if (settings.dynamicArrows) {
			slider.parent().addClass("arrows");
			slider.before('<div class="coda-nav-left" id="coda-nav-left-' + sliderCount + '"><a href="#">' + settings.dynamicArrowLeftText + '</a></div>');
			slider.after('<div class="coda-nav-right" id="coda-nav-right-' + sliderCount + '"><a href="#">' + settings.dynamicArrowRightText + '</a></div>');
		};
		
		var panels = slider.find(".panel");
		var panelWidth = panels.width();
		var panelCount = panels.size();
		var panelContainerWidth = panelWidth*panelCount;
		var navClicks = 0; // Used if autoSlideStopWhenClicked = true
		
		// Surround the collection of panel divs with a container div (wide enough for all panels to be lined up end-to-end)
		$('.panel', slider).wrapAll('<div class="panel-container"></div>');
		// Specify the width of the container div (wide enough for all panels to be lined up end-to-end)
		$(".panel-container", slider).css({ width: panelContainerWidth });
		
		// Cache and remove the panel id's so we can suppress default browser scroll behaviour
		var panelCache = $.map(panels, function(e, i) {
			var id = e.id; e.id = '';
			return id || i + 1 + ''; // force storage as string
		});

		// Specify the current panel.
		// If the loaded URL has a hash (cross-linking), we're going to use that hash to give the slider a specific starting position...
		if (settings.crossLinking && location.hash) {
			var currentPanel = getHashPanel(location.hash.slice(1));
			var offset = - (panelWidth*(currentPanel - 1));
			$('.panel-container', slider).css({ marginLeft: offset });
		// If that's not the case, check to see if we're supposed to load a panel other than Panel 1 initially...
		} else if (settings.firstPanelToLoad != 1 && settings.firstPanelToLoad <= panelCount) { 
			var currentPanel = settings.firstPanelToLoad;
			var offset = - (panelWidth*(currentPanel - 1));
			$('.panel-container', slider).css({ marginLeft: offset });
		// Otherwise, we'll just set the current panel to 1...
		} else { 
			var currentPanel = 1;
		};
			
		// Left arrow click
		$("#coda-nav-left-" + sliderCount + " a").click(function(){
			navClicks++;
			if (currentPanel == 1) {
				offset = - (panelWidth*(panelCount - 1));
				alterPanelHeight(panelCount - 1);
				currentPanel = panelCount;
				slider.siblings('.coda-nav').find('a.current').removeClass('current').parents('ul').find('li:last a').addClass('current');
			} else {
				currentPanel -= 1;
				alterPanelHeight(currentPanel - 1);
				offset = - (panelWidth*(currentPanel - 1));
				slider.siblings('.coda-nav').find('a.current').removeClass('current').parent().prev().find('a').addClass('current');
			};
			$('.panel-container', slider).animate({ marginLeft: offset }, settings.slideEaseDuration, settings.slideEaseFunction);
			return updateHash();
		});
			
		// Right arrow click
		$('#coda-nav-right-' + sliderCount + ' a').click(function(){
			navClicks++;
			if (currentPanel == panelCount) {
				offset = 0;
				currentPanel = 1;
				alterPanelHeight(0);
				slider.siblings('.coda-nav').find('a.current').removeClass('current').parents('ul').find('a:eq(0)').addClass('current');
			} else {
				offset = - (panelWidth*currentPanel);
				alterPanelHeight(currentPanel);
				currentPanel += 1;
				slider.siblings('.coda-nav').find('a.current').removeClass('current').parent().next().find('a').addClass('current');
			};
			$('.panel-container', slider).animate({ marginLeft: offset }, settings.slideEaseDuration, settings.slideEaseFunction);
			return updateHash();
		});
		
		// If we need a dynamic menu
		if (settings.dynamicTabs) {
			var dynamicTabs = '<div class="coda-nav" id="coda-nav-' + sliderCount + '"><ul></ul></div>';
			switch (settings.dynamicTabsPosition) {
				case "bottom":
					slider.parent().append(dynamicTabs);
					break;
				default:
					slider.parent().prepend(dynamicTabs);
					break;
			};
			ul = $('#coda-nav-' + sliderCount + ' ul');
			// Create the nav items
			$('.panel', slider).each(function(n) {
				ul.append('<li class="tab' + (n+1) + '"><a href="#' + getPanelHash(n+1) + '">' + $(this).find(settings.panelTitleSelector).text() + '</a></li>');												
			});
			navContainerWidth = slider.width() + slider.siblings('.coda-nav-left').width() + slider.siblings('.coda-nav-right').width();
			ul.parent().css({ width: navContainerWidth });
			switch (settings.dynamicTabsAlign) {
				case "center":
					ul.css({ width: ($("li", ul).width() + 2) * panelCount });
					break;
				case "right":
					ul.css({ float: 'right' });
					break;
			};
		};
			
		// If we need a tabbed nav
		$('#coda-nav-' + sliderCount + ' a').each(function(z) {
			// What happens when a nav link is clicked
			$(this).bind("click", function() {
				navClicks++;
				$(this).addClass('current').parents('ul').find('a').not($(this)).removeClass('current');
				offset = - (panelWidth*z);
				alterPanelHeight(z);
				currentPanel = z + 1;
				$('.panel-container', slider).animate({ marginLeft: offset }, settings.slideEaseDuration, settings.slideEaseFunction);
				return updateHash();
			});
		});
		
		// External triggers (anywhere on the page)
		$(settings.externalTriggerSelector).each(function() {
			// Make sure this only affects the targeted slider
			if (sliderId == $(this).attr("rel")) {
				$(this).bind("click", function() {
					navClicks++;
					targetPanel = getHashPanel($(this).attr("href").replace(/.*#/, ''));
					offset = - (panelWidth*(targetPanel - 1));
					alterPanelHeight(targetPanel - 1);
					currentPanel = targetPanel;
					// Switch the current tab:
					slider.siblings('.coda-nav').find('a').removeClass('current').parents('ul').find('li:eq(' + (targetPanel - 1) + ') a').addClass('current');
					// Slide
					$('.panel-container', slider).animate({ marginLeft: offset }, settings.slideEaseDuration, settings.slideEaseFunction);
					return updateHash();
				});
			};
		});
			
		// Specify which tab is initially set to "current"
		$("#coda-nav-" + sliderCount + " a:eq(" + (currentPanel - 1) + ")").addClass("current");

		// Set the height of the first panel
		if (settings.autoHeight) {
			panelHeight = $('.panel:eq(' + (currentPanel - 1) + ')', slider).height();
			slider.css({ height: panelHeight });
		};
		
		// Trigger autoSlide
		if (settings.autoSlide) {
			slider.ready(function() {
				setTimeout(autoSlide,settings.autoSlideInterval);
			});
		};
		
		// Return panel number for specified hash via a cache lookup
		function getHashPanel(panelHash) {
			var panelNum = $.inArray(panelHash + '', panelCache);
			return panelNum < 0 ? 1 : panelNum + 1;
		}

		// Return cached hash for current/specified panel
		function getPanelHash(panelNumber) {
			return panelCache[(panelNumber || currentPanel) - 1];
		}
		
		// Update URL hash for current panel
		function updateHash() {
			if (settings.crossLinking) { location.hash = getPanelHash() }; // Change the URL hash (cross-linking)
			return false;
		}
		
		function alterPanelHeight(x) {
			if (settings.autoHeight) {
				panelHeight = $('.panel:eq(' + x + ')', slider).height()
				slider.animate({ height: panelHeight }, settings.autoHeightEaseDuration, settings.autoHeightEaseFunction);
			};
		};
		
		function autoSlide() {
			if (navClicks == 0 || !settings.autoSlideStopWhenClicked) {
				if (currentPanel == panelCount) {
					var offset = 0;
					currentPanel = 1;
				} else {
					var offset = - (panelWidth*currentPanel);
					currentPanel += 1;
				};
				alterPanelHeight(currentPanel - 1);
				// Switch the current tab:
				slider.siblings('.coda-nav').find('a').removeClass('current').parents('ul').find('li:eq(' + (currentPanel - 1) + ') a').addClass('current');
				// Slide:
				$('.panel-container', slider).animate({ marginLeft: offset }, settings.slideEaseDuration, settings.slideEaseFunction);
				setTimeout(autoSlide,settings.autoSlideInterval);
			};
		};
		
		sliderCount++;
		
	});
};