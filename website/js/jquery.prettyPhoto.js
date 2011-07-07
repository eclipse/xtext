/* ------------------------------------------------------------------------
	Class: prettyPhoto
	Use: Lightbox clone for jQuery
	Author: Stephane Caron (http://www.no-margin-for-errors.com)
	Version: 3.0
------------------------------------------------------------------------- */

(function($) {
	$.prettyPhoto = {version: '3.0'};
	
	$.fn.prettyPhoto = function(pp_settings) {
		pp_settings = jQuery.extend({
			animationSpeed: 'fast', /* fast/slow/normal */
			slideshow: false, /* false OR interval time in ms */
			autoplay_slideshow: false, /* true/false */
			opacity: 0.80, /* Value between 0 and 1 */
			showTitle: true, /* true/false */
			allowresize: true, /* true/false */
			default_width: 500,
			default_height: 344,
			counter_separator_label: '/', /* The separator for the gallery counter 1 "of" 2 */
			theme: 'facebook', /* light_rounded / dark_rounded / light_square / dark_square / facebook */
			hideflash: false, /* Hides all the flash object on a page, set to TRUE if flash appears over prettyPhoto */
			wmode: 'opaque', /* Set the flash wmode attribute */
			autoplay: true, /* Automatically start videos: True/False */
			modal: false, /* If set to true, only the close button will close the window */
			overlay_gallery: true, /* If set to true, a gallery will overlay the fullscreen image on mouse over */
			changepicturecallback: function(){}, /* Called everytime an item is shown/changed */
			callback: function(){}, /* Called when prettyPhoto is closed */
			markup: '<div class="pp_pic_holder"> \
						<div class="ppt">&nbsp;</div> \
						<div class="pp_top"> \
							<div class="pp_left"></div> \
							<div class="pp_middle"></div> \
							<div class="pp_right"></div> \
						</div> \
						<div class="pp_content_container"> \
							<div class="pp_left"> \
							<div class="pp_right"> \
								<div class="pp_content"> \
									<div class="pp_loaderIcon"></div> \
									<div class="pp_fade"> \
										<a href="#" class="pp_expand" title="Expand the image">Expand</a> \
										<div class="pp_hoverContainer"> \
											<a class="pp_next" href="#">next</a> \
											<a class="pp_previous" href="#">previous</a> \
										</div> \
										<div id="pp_full_res"></div> \
										<div class="pp_details clearfix"> \
											<a class="pp_close" href="#">Close</a> \
											<p class="pp_description"></p> \
											<div class="pp_nav"> \
												<a href="#" class="pp_arrow_previous">Previous</a> \
												<p class="currentTextHolder">0/0</p> \
												<a href="#" class="pp_arrow_next">Next</a> \
											</div> \
										</div> \
									</div> \
								</div> \
							</div> \
							</div> \
						</div> \
						<div class="pp_bottom"> \
							<div class="pp_left"></div> \
							<div class="pp_middle"></div> \
							<div class="pp_right"></div> \
						</div> \
					</div> \
					<div class="pp_overlay"></div>',
			gallery_markup: '<div class="pp_gallery"> \
								<a href="#" class="pp_arrow_previous">Previous</a> \
								<ul> \
									{gallery} \
								</ul> \
								<a href="#" class="pp_arrow_next">Next</a> \
							</div>',
			image_markup: '<img id="fullResImage" src="" />',
			flash_markup: '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="{width}" height="{height}"><param name="wmode" value="{wmode}" /><param name="allowfullscreen" value="true" /><param name="allowscriptaccess" value="always" /><param name="movie" value="{path}" /><embed src="{path}" type="application/x-shockwave-flash" allowfullscreen="true" allowscriptaccess="always" width="{width}" height="{height}" wmode="{wmode}"></embed></object>',
			quicktime_markup: '<object classid="clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B" codebase="http://www.apple.com/qtactivex/qtplugin.cab" height="{height}" width="{width}"><param name="src" value="{path}"><param name="autoplay" value="{autoplay}"><param name="type" value="video/quicktime"><embed src="{path}" height="{height}" width="{width}" autoplay="{autoplay}" type="video/quicktime" pluginspage="http://www.apple.com/quicktime/download/"></embed></object>',
			iframe_markup: '<iframe src ="{path}" width="{width}" height="{height}" frameborder="no"></iframe>',
			inline_markup: '<div class="pp_inline clearfix">{content}</div>'
		}, pp_settings);
		
		// Global variables accessible only by prettyPhoto
		var matchedObjects = this, percentBased = false, correctSizes,
		
		// prettyPhoto container specific
		pp_contentHeight, pp_contentWidth, pp_containerHeight, pp_containerWidth,
		
		// Window size
		windowHeight = $(window).height(), windowWidth = $(window).width(),

		// Global elements
		pp_slideshow;
		
		doresize = true, scrollPos = _getScroll();
	
		// Window/Keyboard events
		$(window).unbind('scroll').scroll(function(){ scrollPos = _getScroll(); _centerOverlay(); });
		$(window).unbind('resize').resize(function(){ _centerOverlay(); _resizeOverlay(); });
		$(document).unbind('keydown').keydown(function(e){
			if(typeof $pp_pic_holder != 'undefined'){
				if($pp_pic_holder.is(':visible')){
					switch(e.keyCode){
						case 37:
							$.prettyPhoto.changePage('previous');
							break;
						case 39:
							$.prettyPhoto.changePage('next');
							break;
						case 27:
							if(!settings.modal)
							$.prettyPhoto.close();
							break;
					};
					return false;
				};
			};
		});
		
		
		/**
		* Initialize prettyPhoto.
		*/
		$.prettyPhoto.initialize = function() {
			settings = pp_settings;
			
			if($.browser.msie && parseInt($.browser.version) == 6) settings.theme = "light_square"; // Fallback to a supported theme for IE6
			
			_buildOverlay(this); // Build the overlay {this} being the caller
			
			setItem = (_getFileType($(this).attr('href')) != 'youtube') ? $(this).attr('href').toLowerCase() : $(this).attr('href');
			
			setPosition = jQuery.inArray(setItem, pp_images); // Define where in the array the clicked item is positionned

			$.prettyPhoto.open();
			
			return false;
		}


		/**
		* Opens the prettyPhoto modal box.
		* @param image {String,Array} Full path to the image to be open, can also be an array containing full images paths.
		* @param title {String,Array} The title to be displayed with the picture, can also be an array containing all the titles.
		* @param description {String,Array} The description to be displayed with the picture, can also be an array containing all the descriptions.
		*/
		$.prettyPhoto.open = function() {
			if(typeof settings == "undefined"){ // Means it's an API call, need to manually get the settings and set the variables
				settings = pp_settings;
				_buildOverlay(this); // Build the overlay {this} being the caller
				pp_images = $.makeArray(arguments[0]);
				pp_titles = (arguments[1]) ? $.makeArray(arguments[1]) : $.makeArray("");
				pp_descriptions = (arguments[2]) ? $.makeArray(arguments[2]) : $.makeArray("");
				isSet = (pp_images.length > 1) ? true : false;
				setPosition = 0;
			}

			if($.browser.msie && $.browser.version == 6) $('select').css('visibility','hidden'); // To fix the bug with IE select boxes
			
			if(settings.hideflash) $('object,embed').css('visibility','hidden'); // Hide the flash

			_checkPosition($(pp_images).size()); // Hide the next/previous links if on first or last images.
		
			$('.pp_loaderIcon').show();
		
			// Fade the content in
			if($ppt.is(':hidden')) $ppt.css('opacity',0).show();
			$pp_overlay.show().fadeTo(settings.animationSpeed,settings.opacity);

			// Display the current position
			$pp_pic_holder.find('.currentTextHolder').text((setPosition+1) + settings.counter_separator_label + $(pp_images).size());

			// Set the description
			$pp_pic_holder.find('.pp_description').show().html(unescape(pp_descriptions[setPosition]));

			// Set the title
			(settings.showTitle && pp_titles[setPosition] != "") ? $ppt.html(unescape(pp_titles[setPosition])) : $ppt.html('&nbsp;');
			
			// Get the dimensions
			movie_width = ( parseFloat(grab_param('width',pp_images[setPosition])) ) ? grab_param('width',pp_images[setPosition]) : settings.default_width.toString();
			movie_height = ( parseFloat(grab_param('height',pp_images[setPosition])) ) ? grab_param('height',pp_images[setPosition]) : settings.default_height.toString();
			
			// If the size is % based, calculate according to window dimensions
			if(movie_width.indexOf('%') != -1 || movie_height.indexOf('%') != -1){
				movie_height = parseFloat(($(window).height() * parseFloat(movie_height) / 100) - 100);
				movie_width = parseFloat(($(window).width() * parseFloat(movie_width) / 100) - 100);
				percentBased = true;
			};
			
			// Fade the holder
			$pp_pic_holder.fadeIn(function(){
				imgPreloader = "";
				
				// Inject the proper content
				switch(_getFileType(pp_images[setPosition])){
					case 'image':
						imgPreloader = new Image();

						// Preload the neighbour images
						nextImage = new Image();
						if(isSet && setPosition > $(pp_images).size()) nextImage.src = pp_images[setPosition + 1];
						prevImage = new Image();
						if(isSet && pp_images[setPosition - 1]) prevImage.src = pp_images[setPosition - 1];

						$pp_pic_holder.find('#pp_full_res')[0].innerHTML = settings.image_markup;
						$pp_pic_holder.find('#fullResImage').attr('src',pp_images[setPosition]);

						imgPreloader.onload = function(){
							// Fit item to viewport
							correctSizes = _fitToViewport(imgPreloader.width,imgPreloader.height);

							_showContent();
						};

						imgPreloader.onerror = function(){
							alert('Image cannot be loaded. Make sure the path is correct and image exist.');
							$.prettyPhoto.close();
						};
					
						imgPreloader.src = pp_images[setPosition];
					break;
				
					case 'youtube':
						correctSizes = _fitToViewport(movie_width,movie_height); // Fit item to viewport

						movie = 'http://www.youtube.com/v/'+grab_param('v',pp_images[setPosition]);
						if(settings.autoplay) movie += "&autoplay=1";
					
						toInject = settings.flash_markup.replace(/{width}/g,correctSizes['width']).replace(/{height}/g,correctSizes['height']).replace(/{wmode}/g,settings.wmode).replace(/{path}/g,movie);
					break;
				
					case 'vimeo':
						correctSizes = _fitToViewport(movie_width,movie_height); // Fit item to viewport
					
						movie_id = pp_images[setPosition];
						movie = 'http://vimeo.com/moogaloop.swf?clip_id='+ movie_id.replace('http://vimeo.com/','');
						if(settings.autoplay) movie += "&autoplay=1";
				
						toInject = settings.flash_markup.replace(/{width}/g,correctSizes['width']).replace(/{height}/g,correctSizes['height']).replace(/{wmode}/g,settings.wmode).replace(/{path}/g,movie);
					break;
				
					case 'quicktime':
						correctSizes = _fitToViewport(movie_width,movie_height); // Fit item to viewport
						correctSizes['height']+=15; correctSizes['contentHeight']+=15; correctSizes['containerHeight']+=15; // Add space for the control bar
				
						toInject = settings.quicktime_markup.replace(/{width}/g,correctSizes['width']).replace(/{height}/g,correctSizes['height']).replace(/{wmode}/g,settings.wmode).replace(/{path}/g,pp_images[setPosition]).replace(/{autoplay}/g,settings.autoplay);
					break;
				
					case 'flash':
						correctSizes = _fitToViewport(movie_width,movie_height); // Fit item to viewport
					
						flash_vars = pp_images[setPosition];
						flash_vars = flash_vars.substring(pp_images[setPosition].indexOf('flashvars') + 10,pp_images[setPosition].length);

						filename = pp_images[setPosition];
						filename = filename.substring(0,filename.indexOf('?'));
					
						toInject =  settings.flash_markup.replace(/{width}/g,correctSizes['width']).replace(/{height}/g,correctSizes['height']).replace(/{wmode}/g,settings.wmode).replace(/{path}/g,filename+'?'+flash_vars);
					break;
				
					case 'iframe':
						correctSizes = _fitToViewport(movie_width,movie_height); // Fit item to viewport
				
						frame_url = pp_images[setPosition];
						frame_url = frame_url.substr(0,frame_url.indexOf('iframe')-1);
				
						toInject = settings.iframe_markup.replace(/{width}/g,correctSizes['width']).replace(/{height}/g,correctSizes['height']).replace(/{path}/g,frame_url);
					break;
				
					case 'inline':
						// to get the item height clone it, apply default width, wrap it in the prettyPhoto containers , then delete
						myClone = $(pp_images[setPosition]).clone().css({'width':settings.default_width}).wrapInner('<div id="pp_full_res"><div class="pp_inline clearfix"></div></div>').appendTo($('body'));
						correctSizes = _fitToViewport($(myClone).width(),$(myClone).height());
						$(myClone).remove();
						toInject = settings.inline_markup.replace(/{content}/g,$(pp_images[setPosition]).html());
					break;
				};

				if(!imgPreloader){
					$pp_pic_holder.find('#pp_full_res')[0].innerHTML = toInject;
				
					// Show content
					_showContent();
				};
			});

			return false;
		};

	
		/**
		* Change page in the prettyPhoto modal box
		* @param direction {String} Direction of the paging, previous or next.
		*/
		$.prettyPhoto.changePage = function(direction){
			currentGalleryPage = 0;
			
			if(direction == 'previous') {
				setPosition--;
				if (setPosition < 0){
					setPosition = 0;
					return;
				};
			}else if(direction == 'next'){
				if(pp_slideshow && $('.pp_arrow_next').is('.disabled')) {
					setPosition = -1;
				}else if($('.pp_arrow_next').is('.disabled')){
					return;
				}
				setPosition++;
			}else{
				setPosition=direction;
			};

			if(!doresize) doresize = true; // Allow the resizing of the images

			_hideContent(function(){ $.prettyPhoto.open(); });
		};


		/**
		* Change gallery page in the prettyPhoto modal box
		* @param direction {String} Direction of the paging, previous or next.
		*/
		$.prettyPhoto.changeGalleryPage = function(direction){
			if(direction=='next'){
				currentGalleryPage ++;

				if(currentGalleryPage > totalPage){
					currentGalleryPage = 0;
				};
			}else if(direction=='previous'){
				currentGalleryPage --;

				if(currentGalleryPage < 0){
					currentGalleryPage = totalPage;
				};
			};
			
			// Slide the pages, logic ++
			$pp_pic_holder.find('.pp_gallery li').each(function(i){
				$(this).animate({
					'left': (i * itemWidth) - ((itemsPerPage * itemWidth) * currentGalleryPage)
				});
			});
		};


		/**
		* Start the slideshow...
		*/
		$.prettyPhoto.startSlideshow = function(){
			if(typeof pp_slideshow == 'undefined'){
				$pp_pic_holder.find('.pp_play').unbind('click').removeClass('pp_play').addClass('pp_pause').click(function(){
					$.prettyPhoto.stopSlideshow();
					return false;
				});
			}else{
				$.prettyPhoto.changePage('next');
			};
			
			pp_slideshow = setTimeout($.prettyPhoto.startSlideshow,settings.slideshow);
		}


		/**
		* Stop the slideshow...
		*/
		$.prettyPhoto.stopSlideshow = function(){
			$pp_pic_holder.find('.pp_pause').unbind('click').removeClass('pp_pause').addClass('pp_play').click(function(){
				$.prettyPhoto.startSlideshow();
				return false;
			});
			clearTimeout(pp_slideshow);
		}


		/**
		* Closes the prettyPhoto modal box.
		*/
		$.prettyPhoto.close = function(){
			clearTimeout(pp_slideshow);
			
			$pp_pic_holder.find('object,embed').css('visibility','hidden');
			
			$('div.pp_pic_holder,div.ppt,.pp_fade').fadeOut(settings.animationSpeed,function(){ $(this).remove(); });
			
			$pp_overlay.fadeOut(settings.animationSpeed, function(){
				if($.browser.msie && $.browser.version == 6) $('select').css('visibility','visible'); // To fix the bug with IE select boxes
				
				if(settings.hideflash) $('object,embed').css('visibility','visible'); // Show the flash
				
				$(this).remove(); // No more need for the prettyPhoto markup
				
				settings.callback();
				
				doresize = true;
				
				delete settings;
			});
		};
	
		/**
		* Set the proper sizes on the containers and animate the content in.
		*/
		_showContent = function(){
			$('.pp_loaderIcon').hide();
			
			$ppt.fadeTo(settings.animationSpeed,1);

			// Calculate the opened top position of the pic holder
			projectedTop = scrollPos['scrollTop'] + ((windowHeight/2) - (correctSizes['containerHeight']/2));
			if(projectedTop < 0) projectedTop = 0;

			// Resize the content holder
			$pp_pic_holder.find('.pp_content').animate({'height':correctSizes['contentHeight']},settings.animationSpeed);
			
			// Resize picture the holder
			$pp_pic_holder.animate({
				'top': projectedTop,
				'left': (windowWidth/2) - (correctSizes['containerWidth']/2),
				'width': correctSizes['containerWidth']
			},settings.animationSpeed,function(){
				$pp_pic_holder.find('.pp_hoverContainer,#fullResImage').height(correctSizes['height']).width(correctSizes['width']);

				$pp_pic_holder.find('.pp_fade').fadeIn(settings.animationSpeed); // Fade the new content

				// Show the nav
				if(isSet && _getFileType(pp_images[setPosition])=="image") { $pp_pic_holder.find('.pp_hoverContainer').show(); }else{ $pp_pic_holder.find('.pp_hoverContainer').hide(); }
			
				if(correctSizes['resized']) $('a.pp_expand,a.pp_contract').fadeIn(settings.animationSpeed); // Fade the resizing link if the image is resized
				
				settings.changepicturecallback(); // Callback!
			});
			
			if(isSet && settings.overlay_gallery && _getFileType(pp_images[setPosition])=="image") {
				itemWidth = 52+5; // 52 beign the thumb width, 5 being the right margin.
				navWidth = (settings.theme == "facebook") ? 58 : 38; // Define the arrow width depending on the theme
				
				itemsPerPage = Math.floor((correctSizes['containerWidth'] - 100 - navWidth) / itemWidth);
				itemsPerPage = (itemsPerPage < pp_images.length) ? itemsPerPage : pp_images.length;
				totalPage = Math.ceil(pp_images.length / itemsPerPage) - 1;

				// Hide the nav in the case there's no need for links
				if(totalPage == 0){
					navWidth = 0; // No nav means no width!
					$pp_pic_holder.find('.pp_gallery .pp_arrow_next,.pp_gallery .pp_arrow_previous').hide();
				}else{
					navWidth = (settings.theme == "facebook") ? 58 : 38; // Define the arrow width
					
					$pp_pic_holder.find('.pp_gallery .pp_arrow_next,.pp_gallery .pp_arrow_previous').show();
				};

				galleryWidth = itemsPerPage * itemWidth + navWidth;
				
				// Set the proper width to the gallery items
				$pp_pic_holder.find('.pp_gallery')
					.width(galleryWidth)
					.css('margin-left',-(galleryWidth/2));
					
				$pp_pic_holder.find('.pp_gallery ul').width(itemsPerPage * itemWidth);
				
				// Reposition the LIs
				$pp_pic_holder.find('.pp_gallery ul li').each(function(i){
					$(this).css({
						'position':'absolute',
						'left': i * itemWidth
					});
				});
			}else{
				$pp_pic_holder.find('.pp_content').unbind('mouseenter mouseleave');
				$pp_pic_holder.find('.pp_gallery').hide();
			};
			
			if(settings.autoplay_slideshow) {
				pp_slideshow = clearTimeout(pp_slideshow);
				$.prettyPhoto.startSlideshow();
				settings.autoplay_slideshow = false; // Because we only want it to autostart on the first opening.
			};
		};
		
		/**
		* Hide the content...DUH!
		*/
		function _hideContent(callback){
			// Fade out the current picture
			$pp_pic_holder.find('#pp_full_res object,#pp_full_res embed').css('visibility','hidden');
			$pp_pic_holder.find('.pp_fade').fadeOut(settings.animationSpeed,function(){
				$('.pp_loaderIcon').show();
				
				callback();
			});
		};
	
		/**
		* Check the item position in the gallery array, hide or show the navigation links
		* @param setCount {integer} The total number of items in the set
		*/
		function _checkPosition(setCount){
			// If at the end, hide the next link
			if(setPosition == setCount-1) {
				$pp_pic_holder.find('a.pp_next').css('visibility','hidden');
				$pp_pic_holder.find('.pp_nav a.pp_arrow_next').addClass('disabled').unbind('click');
			}else{ 
				$pp_pic_holder.find('a.pp_next').css('visibility','visible');
				$pp_pic_holder.find('.pp_nav a.pp_arrow_next.disabled').removeClass('disabled').bind('click',function(){
					$.prettyPhoto.changePage('next');
					return false;
				});
			};
		
			// If at the beginning, hide the previous link
			if(setPosition == 0) {
				$pp_pic_holder.find('a.pp_previous').css('visibility','hidden');
				$pp_pic_holder.find('.pp_nav a.pp_arrow_previous').addClass('disabled').unbind('click');
			}else{
				$pp_pic_holder.find('a.pp_previous').css('visibility','visible');
				$pp_pic_holder.find('.pp_nav a.pp_arrow_previous.disabled').removeClass('disabled').bind('click',function(){
					$.prettyPhoto.changePage('previous');
					return false;
				});
			};
			
			(setCount > 1) ? $('.pp_nav').show() : $('.pp_nav').hide(); // Hide the bottom nav if it's not a set.
		};
	
		/**
		* Resize the item dimensions if it's bigger than the viewport
		* @param width {integer} Width of the item to be opened
		* @param height {integer} Height of the item to be opened
		* @return An array containin the "fitted" dimensions
		*/
		function _fitToViewport(width,height){
			resized = false;

			_getDimensions(width,height);
			
			// Define them in case there's no resize needed
			imageWidth = width, imageHeight = height;

			if( ((pp_containerWidth > windowWidth) || (pp_containerHeight > windowHeight)) && doresize && settings.allowresize && !percentBased) {
				resized = true, fitting = false;
			
				while (!fitting){
					if((pp_containerWidth > windowWidth)){
						imageWidth = (windowWidth - 200);
						imageHeight = (height/width) * imageWidth;
					}else if((pp_containerHeight > windowHeight)){
						imageHeight = (windowHeight - 200);
						imageWidth = (width/height) * imageHeight;
					}else{
						fitting = true;
					};

					pp_containerHeight = imageHeight, pp_containerWidth = imageWidth;
				};
			
				_getDimensions(imageWidth,imageHeight);
			};

			return {
				width:Math.floor(imageWidth),
				height:Math.floor(imageHeight),
				containerHeight:Math.floor(pp_containerHeight),
				containerWidth:Math.floor(pp_containerWidth) + 40, // 40 behind the side padding
				contentHeight:Math.floor(pp_contentHeight),
				contentWidth:Math.floor(pp_contentWidth),
				resized:resized
			};
		};
		
		/**
		* Get the containers dimensions according to the item size
		* @param width {integer} Width of the item to be opened
		* @param height {integer} Height of the item to be opened
		*/
		function _getDimensions(width,height){
			width = parseFloat(width);
			height = parseFloat(height);
			
			// Get the details height, to do so, I need to clone it since it's invisible
			$pp_details = $pp_pic_holder.find('.pp_details');
			$pp_details.width(width);
			detailsHeight = parseFloat($pp_details.css('marginTop')) + parseFloat($pp_details.css('marginBottom'));
			$pp_details = $pp_details.clone().appendTo($('body')).css({
				'position':'absolute',
				'top':-10000
			});
			detailsHeight += $pp_details.height();
			detailsHeight = (detailsHeight <= 34) ? 36 : detailsHeight; // Min-height for the details
			if($.browser.msie && $.browser.version==7) detailsHeight+=8;
			$pp_details.remove();
			
			// Get the container size, to resize the holder to the right dimensions
			pp_contentHeight = height + detailsHeight;
			pp_contentWidth = width;
			pp_containerHeight = pp_contentHeight + $ppt.height() + $pp_pic_holder.find('.pp_top').height() + $pp_pic_holder.find('.pp_bottom').height();
			pp_containerWidth = width;
		}
	
		function _getFileType(itemSrc){
			if (itemSrc.match(/youtube\.com\/watch/i)) {
				return 'youtube';
			}else if (itemSrc.match(/vimeo\.com/i)) {
				return 'vimeo';
			}else if(itemSrc.indexOf('.mov') != -1){ 
				return 'quicktime';
			}else if(itemSrc.indexOf('.swf') != -1){
				return 'flash';
			}else if(itemSrc.indexOf('iframe') != -1){
				return 'iframe'
			}else if(itemSrc.substr(0,1) == '#'){
				return 'inline';
			}else{
				return 'image';
			};
		};
	
		function _centerOverlay(){
			if(doresize && typeof $pp_pic_holder != 'undefined') {
				titleHeight = $ppt.height(), contentHeight = $pp_pic_holder.height(), contentwidth = $pp_pic_holder.width();
				
				projectedTop = (windowHeight/2) + scrollPos['scrollTop'] - (contentHeight/2);
				
				$pp_pic_holder.css({
					'top': projectedTop,
					'left': (windowWidth/2) + scrollPos['scrollLeft'] - (contentwidth/2)
				});
			};
		};
	
		function _getScroll(){
			if (self.pageYOffset) {
				return {scrollTop:self.pageYOffset,scrollLeft:self.pageXOffset};
			} else if (document.documentElement && document.documentElement.scrollTop) { // Explorer 6 Strict
				return {scrollTop:document.documentElement.scrollTop,scrollLeft:document.documentElement.scrollLeft};
			} else if (document.body) {// all other Explorers
				return {scrollTop:document.body.scrollTop,scrollLeft:document.body.scrollLeft};
			};
		};
	
		function _resizeOverlay() {
			windowHeight = $(window).height(), windowWidth = $(window).width();
			
			if(typeof $pp_overlay != "undefined") $pp_overlay.height($(document).height());
		};
	
		function _buildOverlay(caller){
			// Find out if the picture is part of a set
			theRel = $(caller).attr('rel');
			galleryRegExp = /\[(?:.*)\]/;
			isSet = (galleryRegExp.exec(theRel)) ? true : false;
			
			// Put the SRCs, TITLEs, ALTs into an array.
			pp_images = (isSet) ? jQuery.map(matchedObjects, function(n, i){ if($(n).attr('rel').indexOf(theRel) != -1) return $(n).attr('href'); }) : $.makeArray($(caller).attr('href'));
			pp_titles = (isSet) ? jQuery.map(matchedObjects, function(n, i){ if($(n).attr('rel').indexOf(theRel) != -1) return ($(n).find('img').attr('alt')) ? $(n).find('img').attr('alt') : ""; }) : $.makeArray($(caller).find('img').attr('alt'));
			pp_descriptions = (isSet) ? jQuery.map(matchedObjects, function(n, i){ if($(n).attr('rel').indexOf(theRel) != -1) return ($(n).attr('title')) ? $(n).attr('title') : ""; }) : $.makeArray($(caller).attr('title'));
			
			$('body').append(settings.markup); // Inject the markup
			
			$pp_pic_holder = $('.pp_pic_holder') , $ppt = $('.ppt'), $pp_overlay = $('div.pp_overlay'); // Set my global selectors
			
			// Inject the inline gallery!
			if(isSet && settings.overlay_gallery) {
				currentGalleryPage = 0;
				toInject = "";
				for (var i=0; i < pp_images.length; i++) {
					var regex = new RegExp("(.*?)\.(jpg|jpeg|png|gif)$");
					pp_images[i] = pp_images[i].toLowerCase();
					var results = regex.exec( pp_images[i] );
					if(!results){
						classname = 'default';
					}else{
						classname = '';
					}
					toInject += "<li class='"+classname+"'><a href='#'><img src='" + pp_images[i] + "' width='50' alt='' /></a></li>";
				};
				
				toInject = settings.gallery_markup.replace(/{gallery}/g,toInject);
				
				$pp_pic_holder.find('#pp_full_res').after(toInject);
				
				$pp_pic_holder.find('.pp_gallery .pp_arrow_next').click(function(){
					$.prettyPhoto.changeGalleryPage('next');
					$.prettyPhoto.stopSlideshow();
					return false;
				});
				
				$pp_pic_holder.find('.pp_gallery .pp_arrow_previous').click(function(){
					$.prettyPhoto.changeGalleryPage('previous');
					$.prettyPhoto.stopSlideshow();
					return false;
				});
				
				$pp_pic_holder.find('.pp_content').hover(
					function(){
						$pp_pic_holder.find('.pp_gallery').fadeIn();
					},
					function(){
						$pp_pic_holder.find('.pp_gallery').fadeOut();
					});

				itemWidth = 52+5; // 52 beign the thumb width, 5 being the right margin.
				$pp_pic_holder.find('.pp_gallery ul li').each(function(i){
					$(this).css({
						'position':'absolute',
						'left': i * itemWidth
					});

					$(this).find('a').unbind('click').click(function(){
						$.prettyPhoto.changePage(i);
						$.prettyPhoto.stopSlideshow();
						return false;
					});
				});
			};
			
			
			// Inject the play/pause if it's a slideshow
			if(settings.slideshow){
				$pp_pic_holder.find('.pp_nav').prepend('<a href="#" class="pp_play">Play</a>')
				$pp_pic_holder.find('.pp_nav .pp_play').click(function(){
					$.prettyPhoto.startSlideshow();
					return false;
				});
			}
			
			$pp_pic_holder.attr('class','pp_pic_holder ' + settings.theme); // Set the proper theme
			
			$pp_overlay
				.css({
					'opacity':0,
					'height':$(document).height(),
					'width':$(document).width()
					})
				.bind('click',function(){
					if(!settings.modal) $.prettyPhoto.close();
				});

			$('a.pp_close').bind('click',function(){ $.prettyPhoto.close(); return false; });

			$('a.pp_expand').bind('click',function(e){
				// Expand the image
				if($(this).hasClass('pp_expand')){
					$(this).removeClass('pp_expand').addClass('pp_contract');
					doresize = false;
				}else{
					$(this).removeClass('pp_contract').addClass('pp_expand');
					doresize = true;
				};
			
				_hideContent(function(){ $.prettyPhoto.open(); });
		
				return false;
			});
		
			$pp_pic_holder.find('.pp_previous, .pp_nav .pp_arrow_previous').bind('click',function(){
				$.prettyPhoto.changePage('previous');
				$.prettyPhoto.stopSlideshow();
				return false;
			});
		
			$pp_pic_holder.find('.pp_next, .pp_nav .pp_arrow_next').bind('click',function(){
				$.prettyPhoto.changePage('next');
				$.prettyPhoto.stopSlideshow();
				return false;
			});
			
			_centerOverlay(); // Center it
		};
		
		return this.unbind('click').click($.prettyPhoto.initialize); // Return the jQuery object for chaining. The unbind method is used to avoid click conflict when the plugin is called more than once
	};
	
	function grab_param(name,url){
	  name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	  var regexS = "[\\?&]"+name+"=([^&#]*)";
	  var regex = new RegExp( regexS );
	  var results = regex.exec( url );
	  return ( results == null ) ? "" : results[1];
	}
	
})(jQuery);