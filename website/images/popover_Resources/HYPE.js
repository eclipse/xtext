var HYPE = (function HYPE() {

	///////////////////////////////////////////////////////////////
	// constants
	
	this.name = "hype main object";

	this.kActionNone = 0;
	this.kActionJumpToScene = 1;
	this.kActionPresentMedia = 2;
	this.kActionPlayTimeline = 3;
	this.kActionRunJavascript = 4;
	this.kActionVisitURL = 5;
	this.kJumpToSceneOther = 0;
	this.kJumpToSceneNext = 1;
	this.kJumpToScenePrevious = 2;
	this.kJumpToSceneFirst = 3;
	this.kJumpToSceneLast = 4;
	this.kSceneTransitionNone = 0;
	this.kSceneTransitionInstant = 1;
	this.kSceneTransitionCrossfade = 2;
	this.kSceneTransitionSwap = 3;
	this.kSceneTransitionPushLeftToRight = 4;
	this.kSceneTransitionPushRightToLeft = 5;
	this.kSceneTransitionPushBottomToTop = 6;
	this.kSceneTransitionPushTopToBottom = 7;
	this.kAnimationTypeStandardKeyframe = 0;
	this.kAnimationTypeStandardVideo = 1;
	this.kTimelineDefaultIdentifier = "kTimelineDefaultIdentifier";


	///////////////////////////////////////////////////////////////
	// module-wide variables
	this.debug = false;
	this.timelineRuns = Array();	
	this.nextKeyHandlers = Array();
	this.imagesToPreload = Array();
	this.preloadedImagesCount = 0;
	this.currentValues = Array();
	this.mouseOverElement = null;
	this.transitionPropertyMapping = {"Top" : "top", "Left" : "left", "Width" : "width", "Height" : "height", "Opacity" : "opacity", "BackgroundColor" : "background-color", "LetterSpacing" : "letter-spacing", "WordSpacing" : "word-spacing", "LineHeight" : "line-height" };
	this.transitionTimingFunctionMapping = {"linear" : "linear", "easein" : "ease-in", "easeout" : "ease-out", "easeinout" : "ease-in-out" };
	this.cssTransitionsSupported = false;
	this.actionHandlers = {};
	this.timelineCompletionOverrideCallback = null;

	// set from the DocumentLoader
	this.documentName = null;
	this.resourcesFolderName = null;
	this.mainContentContainerID = null;
	this.currentSceneIndex = null;
	this.attributeTransformerMapping = null;
	this.scenes = null;
	this.javascriptMapping = null;
	this.showHypeBuiltWatermark = null;
	this.showLoadingPage = null;
	this.drawSceneBackgrounds = null;
	this.Custom = null;


	
	///////////////////////////////////////////////////////////////
	// methods

	this.documentLoad = function (e) {
		this.determineCapabilities();
		if(this.showHypeBuiltWatermark == true) {
			this.addHypeBuiltWatermark();
		}
		
		if(this.showLoadingPage == true) {
			this.overlayLoadingPage();
		}
	
		if(this.debug == true) {
			document.body.onload = function() {
				document.getElementById("HYPE_debug").style["display"] = "block";
			};
		}
		this.addAdditionalCSS();
		this.createSceneDivs();

		this.preloadImages();
	}
	
	this.determineCapabilities = function () {
		var supported = false;
		
		(function() {
			var div = document.createElement('div');
			div.innerHTML = '<div style="-webkit-transition:color 1s linear;-moz-transition:color 1s linear;"></div>';
			supported = (div.firstChild.style.webkitTransition !== undefined) || (div.firstChild.style.MozTransition !== undefined);
			delete div;
		})();
		
		this.cssTransitionsSupported = supported;
	}
	
	this.addHypeBuiltWatermark = function () {
		var contentContainer = document.getElementById(this.mainContentContainerID);
		var watermarkDiv = document.createElement("div");
		watermarkDiv.style.position = "absolute";
		watermarkDiv.style.bottom = "1px";
		watermarkDiv.style.right = "1px";
		watermarkDiv.style.zIndex = "100000";
		watermarkDiv.style.textAlign = "right";
		watermarkDiv.style.fontSize = "9px";
		watermarkDiv.style.fontFamily = "Helvetica, Arial, Sans-Serif";
		watermarkDiv.innerHTML = "<strong><a style = 'color:#777; text-decoration:none; opacity:.75;' href = 'http://www.tumultco.com/hype/'>Built with Hype</a></strong>";
		contentContainer.appendChild(watermarkDiv);
	}
	
	this.loadingPageID = function () {
		return this.mainContentContainerID + "_loadingPage";
	}
	
	this.overlayLoadingPage = function () {
		var loadingDiv = document.getElementById(this.loadingPageID());
		if(loadingDiv == null) {	
			var contentContainer = document.getElementById(this.mainContentContainerID);
			
			loadingDiv = document.createElement("div");
			loadingDiv.className = "HYPE_Loading";
			loadingDiv.id = this.loadingPageID();
			loadingDiv.style.display = "block";
			loadingDiv.style.overflow = "hidden";
			loadingDiv.style.position = "absolute";
			loadingDiv.style.width = "150px";
			loadingDiv.style.top = "40%";
			loadingDiv.style.left = "" + ((parseInt(contentContainer.style.width) / 2.0) - 75.0) + "px";
			loadingDiv.style.padding = "2px";
			loadingDiv.style.border = "3px solid #C0C0C0";
			loadingDiv.style.backgroundColor = "#F0F0F0";
			loadingDiv.style["borderRadius"] = "10px";
			loadingDiv.style["MozBorderRadius"] = "10px";
			loadingDiv.style["border-radius"] = "10px";
			loadingDiv.style["-webkit-border-radius"] = "10px";
			loadingDiv.style.textAlign = "center";
			loadingDiv.style.fontFamily = "'Lucida Grande', Helvetica, Arial, Sans-Serif";
			loadingDiv.style.fontSize = "13px";
			loadingDiv.style.fontWeight = "bold";
			loadingDiv.style.color = "#b0b0b0";
			loadingDiv.style.zIndex = "1000000";
			loadingDiv.innerHTML = "Loading";
			
			contentContainer.appendChild(loadingDiv);
		}
		
		loadingDiv.style.display = "block";
	}
	
	this.hideLoadingPage = function () {
		var loadingDiv = document.getElementById(this.loadingPageID());
		loadingDiv.style.display = "none";
	}
	
	this.createSceneDivs = function () {
		var contentContainer = document.getElementById(this.mainContentContainerID);
	
		for(var i = 0; i < this.scenes.length; i++) {
			var scene = this.scenes[i];
			var sceneDiv = document.createElement("div");
			sceneDiv.className = "HYPE_scene";
			sceneDiv.id = scene["id"];
			sceneDiv.setAttribute("HYPE_scene_index", scene["sceneIndex"]);
			sceneDiv.style["-webkit-perspective"] = scene["perspective"];
			if(this.drawSceneBackgrounds != false) {
				sceneDiv.style.backgroundColor = scene["backgroundColor"];
			}
			sceneDiv.style.display = "none";
			sceneDiv.style.overflow = "hidden";
			sceneDiv.style.position = "absolute";
			sceneDiv.style.width = contentContainer.style.width;
			sceneDiv.style.height = contentContainer.style.height;
			
			var elements = scene["initialValues"];
			for(var key in elements) {
				if(elements.hasOwnProperty(key) == false) {
					continue;
				}
				
				var element = elements[key];
				var elementElement = document.createElement(element["TagName"]);
				elementElement.className = "HYPE_element";
				elementElement.id = key;
				if(element["InnerHTML"] != null) {
					elementElement.innerHTML = element["InnerHTML"];
				}

				sceneDiv.appendChild(elementElement);
			}

			contentContainer.appendChild(sceneDiv);
		}
	}
	
	// adapted from David Morrissey's answer in:
	//    http://stackoverflow.com/questions/2710284/controlling-css-with-javascript-works-with-mozilla-but-not-with-webkit-based-brow
	this.addAdditionalCSS = function () {
		var additionalCSS = ".HYPE_scene {\
				color: #000;\
				\
				font-size: 16px;\
				font-weight: normal;\
				font-family: Helvetica, Arial, Sans-Serif;\
				font-weight: normal;\
				font-style: normal;\
				font-variant: normal;\
				\
				text-decoration:none;\
				text-align: left;\
				text-transform: none;\
				text-indent: none;\
				text-shadow: none;\
				\
				line-height: normal;\
				letter-spacing: normal;\
				white-space: normal;\
				word-spacing: normal;\
				vertical-align: baseline;\
				\
				border: none;\
				background-color: transparent;\
				background-image: none;\
			}\
			\
			.HYPE_scene div, .HYPE_scene span, .HYPE_scene applet, .HYPE_scene object, .HYPE_scene iframe,\
			.HYPE_scene h1, .HYPE_scene h2, .HYPE_scene h3, .HYPE_scene h4, .HYPE_scene h5, .HYPE_scene h6, .HYPE_scene p, .HYPE_scene blockquote, .HYPE_scene pre,\
			.HYPE_scene a, .HYPE_scene abbr, .HYPE_scene acronym, .HYPE_scene address, .HYPE_scene big, .HYPE_scene cite, .HYPE_scene code,\
			.HYPE_scene del, .HYPE_scene dfn, .HYPE_scene em, .HYPE_scene img, .HYPE_scene ins, .HYPE_scene kbd, .HYPE_scene q, .HYPE_scene s, .HYPE_scene samp,\
			.HYPE_scene small, .HYPE_scene strike, .HYPE_scene strong, .HYPE_scene sub, .HYPE_scene sup, .HYPE_scene tt, .HYPE_scene var,\
			.HYPE_scene b, .HYPE_scene u, .HYPE_scene i, .HYPE_scene center,\
			.HYPE_scene dl, .HYPE_scene dt, .HYPE_scene dd, .HYPE_scene ol, .HYPE_scene ul, .HYPE_scene li,\
			.HYPE_scene fieldset, .HYPE_scene form, .HYPE_scene label, .HYPE_scene legend,\
			.HYPE_scene table, .HYPE_scene caption, .HYPE_scene tbody, .HYPE_scene tfoot, .HYPE_scene thead, .HYPE_scene tr, .HYPE_scene th, .HYPE_scene td,\
			.HYPE_scene article, .HYPE_scene aside, .HYPE_scene canvas, .HYPE_scene details, .HYPE_scene embed, \
			.HYPE_scene figure, .HYPE_scene figcaption, .HYPE_scene footer, .HYPE_scene header, .HYPE_scene hgroup, \
			.HYPE_scene menu, .HYPE_scene nav, .HYPE_scene output, .HYPE_scene ruby, .HYPE_scene section, .HYPE_scene summary,\
			.HYPE_scene time, .HYPE_scene mark, .HYPE_scene audio, .HYPE_scene video {\
			\
				color: inherit;\
				\
				font-size: inherit;\
				font-weight: inherit;\
				font-family: inherit;\
				font-weight: inherit;\
				font-style: inherit;\
				font-variant: inherit;\
				\
				text-decoration:inherit;\
				text-align: inherit;\
				text-transform: inherit;\
				text-indent: inherit;\
				text-shadow: inherit;\
				\
				line-height: inherit;\
				letter-spacing: inherit;\
				white-space: inherit;\
				word-spacing: inherit;\
				vertical-align: inherit;\
				\
				border: none;\
				background-color: none;\
				background-image: none;\
			}\
			\
			.HYPE_scene p {\
				display: block;\
				margin-top: 1em;\
				margin-bottom: 1em;\
				margin-left: 0;\
				margin-right: 0;\
			}\
			\
			.HYPE_scene div, .HYPE_scene layer {\
				display: block;\
			}\
			\
			.HYPE_scene article, .HYPE_scene aside, .HYPE_scene footer, .HYPE_scene header, .HYPE_scene hgroup, .HYPE_scene nav, .HYPE_scene section {\
				display: block;\
			}\
			\
			.HYPE_scene blockquote {\
				display: block;\
				margin-top: 1em;\
				margin-bottom: 1em;\
				margin-left: 40px;\
				margin-right: 40px;\
			}\
			\
			.HYPE_scene figcaption {\
				display: block;\
			}\
			\
			.HYPE_scene figure {\
				display: block;\
				margin-top: 1em;\
				margin-bottom: 1em;\
				margin-left: 40px;\
				margin-right: 40px;\
			}\
			\
			.HYPE_scene q {\
				display: inline;\
			}\
			\
			.HYPE_scene q:before {\
				content: open-quote;\
			}\
			\
			.HYPE_scene q:after {\
				content: close-quote;\
			}\
			\
			.HYPE_scene center {\
				display: block;\
				text-align: center;\
			}\
			\
			.HYPE_scene hr {\
				display: block;\
				margin-top: 0.5em;\
				margin-bottom: 0.5em;\
				margin-left: auto;\
				margin-right: auto;\
				border-style: inset;\
				border-width: 1px;\
			}\
			\
			.HYPE_scene h1, .HYPE_scene h2, .HYPE_scene h3, .HYPE_scene h4, .HYPE_scene h5, .HYPE_scene h6 {\
				display: block;\
				margin-left: 0;\
				margin-right: 0;\
				font-weight: bold;\
			}\
			\
			.HYPE_scene h1 {\
				font-size: 2em;\
				margin-top: 0.67em;\
				margin-bottom: 0.67em;\
			}\
			\
			.HYPE_scene h2 {\
				font-size: 1.5em;\
				margin-top: 0.83em;\
				margin-bottom: 0.83em;\
			}\
			\
			.HYPE_scene h3 {\
				font-size: 1.17em;\
				margin-top: 1em;\
				margin-bottom: 1em;\
			}\
			\
			.HYPE_scene h4 {\
				margin-top: 1.33em;\
				margin-bottom: 1.33em;\
			}\
			\
			.HYPE_scene h5 {\
				font-size: .83em;\
				margin-top: 1.67em;\
				margin-bottom: 1.67em;\
			}\
			\
			.HYPE_scene h6 {\
				font-size: .67em;\
				margin-top: 2.33em;\
				margin-bottom: 2.33em;\
			}\
			\
			.HYPE_scene table {\
				display: table;\
				border-collapse: separate;\
				border-spacing: 2px;\
				border-color: gray;\
			}\
			\
			.HYPE_scene thead {\
				display: table-header-group;\
				vertical-align: middle;\
				border-color: inherit;\
			}\
			\
			.HYPE_scene tbody {\
				display: table-row-group;\
				vertical-align: middle;\
				border-color: inherit;\
			}\
			\
			.HYPE_scene tfoot {\
				display: table-footer-group;\
				vertical-align: middle;\
				border-color: inherit;\
			}\
			\
			.HYPE_scene col {\
				display: table-column;\
			}\
			\
			.HYPE_scene colgroup {\
				display: table-column-group;\
			}\
			\
			.HYPE_scene tr {\
				display: table-row;\
				vertical-align: inherit;\
				border-color: inherit;\
			}\
			\
			.HYPE_scene td, .HYPE_scene th {\
				display: table-cell;\
				vertical-align: inherit;\
			}\
			\
			.HYPE_scene th {\
				font-weight: bold;\
			}\
			\
			.HYPE_scene caption {\
				display: table-caption;\
				text-align: center;\
			}\
			\
			.HYPE_scene ul, .HYPE_scene menu, .HYPE_scene dir {\
				display: block;\
				list-style-type: disc;\
				margin-top: 1em;\
				margin-bottom: 1em;\
				margin-left: 0;\
				margin-right: 0;\
				padding-left: 40px;\
			}\
			\
			.HYPE_scene ol {\
				display: block;\
				list-style-type: decimal;\
				margin-top: 1em;\
				margin-bottom: 1em;\
				margin-left: 0;\
				margin-right: 0;\
				padding-left: 40px;\
			}\
			\
			.HYPE_scene li {\
				display: list-item;\
			}\
			\
			.HYPE_scene ul ul, .HYPE_scene ol ul {\
				list-style-type: circle;\
			}\
			\
			.HYPE_scene ol ol ul, .HYPE_scene ol ul ul, .HYPE_scene ul ol ul, .HYPE_scene ul ul ul {\
				list-style-type: square;\
			}\
			\
			.HYPE_scene dd {\
				display: block;\
				margin-left: 40px;\
			}\
			\
			.HYPE_scene dl {\
				display: block;\
				margin-top: 1em;\
				margin-bottom: 1em;\
				margin-left: 0;\
				margin-right: 0;\
			}\
			\
			.HYPE_scene dt {\
				display: block;\
			}\
			\
			.HYPE_scene ol ul, .HYPE_scene ul ol, .HYPE_scene ul ul, .HYPE_scene ol ol {\
				margin-top: 0;\
				margin-bottom: 0;\
			}\
			\
			.HYPE_scene u, .HYPE_scene ins {\
				text-decoration: underline;\
			}\
			\
			.HYPE_scene strong, .HYPE_scene b {\
				font-weight: bolder;\
			}\
			\
			.HYPE_scene i, .HYPE_scene cite, .HYPE_scene em, .HYPE_scene var, .HYPE_scene address {\
				font-style: italic;\
			}\
			\
			.HYPE_scene tt, .HYPE_scene code, .HYPE_scene kbd, .HYPE_scene samp {\
				font-family: monospace;\
			}\
			\
			.HYPE_scene pre, .HYPE_scene xmp, .HYPE_scene plaintext, .HYPE_scene listing {\
				display: block;\
				font-family: monospace;\
				white-space: pre;\
				margin: 1em 0;\
			}\
			\
			.HYPE_scene mark {\
				background-color: yellow;\
				color: black;\
			}\
			\
			.HYPE_scene big {\
				font-size: larger;\
			}\
			\
			.HYPE_scene small {\
				font-size: smaller;\
			}\
			\
			.HYPE_scene s, .HYPE_scene strike, .HYPE_scene del {\
				text-decoration: line-through;\
			}\
			\
			.HYPE_scene sub {\
				vertical-align: sub;\
				font-size: smaller;\
			}\
			\
			.HYPE_scene sup {\
				vertical-align: super;\
				font-size: smaller;\
			}\
			\
			.HYPE_scene nobr {\
				white-space: nowrap;\
			}\
				\
			.HYPE_scene a:-webkit-any-link {\
				color: -webkit-link;\
				text-decoration: underline;\
				cursor: auto;\
			}\
			\
			.HYPE_scene a:-webkit-any-link:active {\
				color: -webkit-activelink;\
			}\
			\
			.HYPE_scene noframes {\
				display: none;\
			}\
			\
			.HYPE_scene frameset, .HYPE_scene frame {\
				display: block;\
			}\
			\
			.HYPE_scene frameset {\
				border-color: inherit;\
			}\
			\
			.HYPE_scene iframe {\
				border: 2px inset;\
			}\
			\
			.HYPE_scene details {\
				display: block;\
			}\
			\
			.HYPE_scene summary {\
				display: block;\
			}\
			\
			@-webkit-keyframes HYPE_swapToFront {\
				0% {\
					-webkit-transform: translate3d(-168.25px, 0px, -600px) rotateY(50deg);\
					-webkit-animation-timing-function: ease-in;\
				}\
				50% {\
					-webkit-transform: translate3d(-336.5px, 0px, -300px) rotateY(40deg);\
					-webkit-animation-timing-function: ease-out;\
				}\
				100% {\
					-webkit-transform: translate3d(0px, 0px, -0px) rotateY(0deg);\
				}\
			}\
			\
			@-webkit-keyframes HYPE_swapToBack {\
				0% {\
					-webkit-transform: translate3d(0px, 0px, 0px) rotateY(0deg);\
					-webkit-animation-timing-function: ease-in;\
				}\
				50% {\
					-webkit-transform: translate3d(336.5px, 0px, -300px) rotateY(-20deg);\
					-webkit-animation-timing-function: ease-out;\
				}\
			\
				100% {\
					-webkit-transform: translate3d(168.25px, 0px, -600px) rotateY(-50deg);\
				}\
			}\
			\
			@-webkit-keyframes HYPE_crossfadeIn {\
				0% {\
					opacity: 0.0;\
					-webkit-animation-timing-function: linear;\
				}\
				100% {\
					opacity: 1.0;\
				}\
			}\
			\
			@-webkit-keyframes HYPE_crossfadeOut {\
				0% {\
					opacity: 1.0;\
					-webkit-animation-timing-function: linear;\
				}\
				100% {\
					opacity: 0.0;\
				}\
			}\
			";
		var doc = document;
		
		var css = doc.createElement('div')
		css.innerHTML = '&nbsp;<style id="" type="text/css">'+additionalCSS+'</style>&nbsp;'
		var head = doc.getElementsByTagName("head")[0]
		if (!head) { // SAFARI EARLY VERSIONS HACK! - Some safari versions don't find the "head" tag
			head = doc.createElement('div')
			doc.body.appendChild(head)
		}
		
		if (head.firstChild) {
			head.insertBefore(css.childNodes[1], head.firstChild)
		} else {
			head.appendChild(css.childNodes[1])
		}
	}

	this.preloadFinished = function () {
		if(this.showLoadingPage == true) {
			this.hideLoadingPage();
		}
		
		this.showScene(this.currentSceneIndex);
	}
	
	this.sceneNames = function () { // public
		var sceneNames = Array();		
		for(var i = 0; i < this.scenes.length; i++) {
			sceneNames.push(this.scenes[i]["name"]);
		}		
		return sceneNames;
	}
	
	this.currentSceneName = function () { // public
		return this.scenes[this.currentSceneIndex]["name"];
	}

	this.showNextScene = function (transition) { // public
		this.showScene(this.currentSceneIndex + 1, transition);
	}

	this.showPreviousScene = function (transition) { // public
		this.showScene(this.currentSceneIndex - 1, transition);
	}
	
	this.showSceneNamed = function (sceneName, transition) { // public
		var sceneIndex = myIndexOf(this.sceneNames(), sceneName);
		this.showScene(sceneIndex, transition);
	}

	this.showScene = function (sceneNumber, transition) {
		// sanity check to make sure there's a scene with this number
		if(this.identifierOfSceneAtIndex(sceneNumber) == null) {
			return;
		}
	
		var hypeDoc = this;
		var finishShowScene = (function() {
			if(hypeDoc.browserInfo.webkit != null) { // webkit
				if(transition == null || transition == hypeDoc.kSceneTransitionInstant) {
					hypeDoc.showSceneWithInstant(sceneNumber);
				} else if(transition == hypeDoc.kSceneTransitionCrossfade) {
					hypeDoc.showSceneWithCrossfade(sceneNumber);
				} else if(transition == hypeDoc.kSceneTransitionSwap) {
					hypeDoc.showSceneWithSwap(sceneNumber);
				} else if(transition == hypeDoc.kSceneTransitionPushLeftToRight || transition == hypeDoc.kSceneTransitionPushRightToLeft || transition == hypeDoc.kSceneTransitionPushBottomToTop || transition == hypeDoc.kSceneTransitionPushTopToBottom) {
					hypeDoc.showSceneWithPush(sceneNumber, transition);
				}
			} else { // everything else
				hypeDoc.showSceneWithInstant(sceneNumber);
			}
		});
	

		// handle scene unload event
		var hasUnloadTimelineRun = false;
		var currentSceneContainer = document.getElementById(this.currentSceneIdentifier());
		
		if(sceneNumber != this.currentSceneIndex && currentSceneContainer != null) {
			var sceneIndex = this.indexOfSceneWithIdentifier(this.currentSceneIdentifier());
			var onSceneUnloadData = this.scenes[sceneIndex]["onSceneUnloadAction"];
			if(onSceneUnloadData != null) {
				var onUnloadFunction = this.Apply.CreateActionHandler(this, onSceneUnloadData, null);
				if(onSceneUnloadData["type"] == this.kActionPlayTimeline && onSceneUnloadData["timelineIdentifier"] != null) {
					hasUnloadTimelineRun = true;
					this.timelineCompletionOverrideCallback = finishShowScene;
				}
				onUnloadFunction(null);
			}
		}
	
		if(hasUnloadTimelineRun == false) {
			finishShowScene();
		}
	}

	this.showSceneWithInstant = function (sceneNumber) {
		var currentSceneContainer = document.getElementById(this.currentSceneIdentifier());
		if(currentSceneContainer != null) {
			currentSceneContainer.style.display = "none";
		}
		
		this.loadScene(this.identifierOfSceneAtIndex(sceneNumber));

		var nextSceneContainer = document.getElementById(this.currentSceneIdentifier());
		nextSceneContainer.style.display = "block";
		
		this.completeSceneTransition(currentSceneContainer, nextSceneContainer);
	}

	this.showSceneWithCrossfade = function (sceneNumber) {
		var currentSceneContainer = document.getElementById(this.currentSceneIdentifier());
		if(currentSceneContainer != null) {
			currentSceneContainer.style["z-index"] = 0;
			
			if(this.drawSceneBackgrounds == false) {
				currentSceneContainer.style["-webkit-animation-duration"] = "1.1s";
				currentSceneContainer.style["-webkit-animation-name"] = "HYPE_crossfadeOut";
				//currentSceneContainer.style["opacity"] = "0.0";
			}
			
			
			//!! need to clear any box reflections before a scene transition to account for x-bug://2
			var initialValues = this.scenes[this.currentSceneIndex]["initialValues"];
			for(var key in initialValues) {
				if(initialValues.hasOwnProperty(key) == false) {
					continue;
				}
				
				document.getElementById(key).style["-webkit-box-reflect"] = null;
			}
		}
		
		this.loadScene(this.identifierOfSceneAtIndex(sceneNumber));

		var nextSceneContainer = document.getElementById(this.currentSceneIdentifier());
		nextSceneContainer.style.display = "block";
		nextSceneContainer.style["z-index"] = 1;
		nextSceneContainer.style["-webkit-animation-duration"] = "1.1s";
		nextSceneContainer.style["-webkit-animation-name"] = "HYPE_crossfadeIn";
		nextSceneContainer.style["opacity"] = "1.0";

		var hypeContext = this;
		window.setTimeout(function() { hypeContext.completeSceneTransition(currentSceneContainer, nextSceneContainer); }, (1.1 * 1000.0));
	}

	this.showSceneWithSwap = function (sceneNumber) {
		//!! this (and corresponding clear in completeSceneTransition is a workaround for x-bug://1
		document.getElementById(this.mainContentContainerID).style["-webkit-perspective"] = "600px";

		var currentSceneContainer = document.getElementById(this.currentSceneIdentifier());
		if(currentSceneContainer != null) {
			//currentSceneContainer.style.display = "none";
			currentSceneContainer.style["-webkit-animation-duration"] = "1.1s";
			//currentSceneContainer.style["-webkit-box-reflect"] = 'below 5px -webkit-gradient(linear, left top, left bottom, from(transparent), color-stop(0.5, transparent), to(white))';
			currentSceneContainer.style["-webkit-animation-name"] = "HYPE_swapToBack";
			//currentSceneContainer.style["-webkit-transform"] = "translate3d(75px, 0px, -600px) rotateY(-50deg)";
			currentSceneContainer.style["-webkit-transform"] = "translate3d(0px, 0px, 0px) rotateY(0deg)";
		}
		
		this.loadScene(this.identifierOfSceneAtIndex(sceneNumber));

		var nextSceneContainer = document.getElementById(this.currentSceneIdentifier());
		nextSceneContainer.style.display = "block";
		nextSceneContainer.style["-webkit-animation-duration"] = "1.1s";
		//nextSceneContainer.style["-webkit-box-reflect"] = 'below 5px -webkit-gradient(linear, left top, left bottom, from(transparent), color-stop(0.5, transparent), to(white))';
		nextSceneContainer.style["-webkit-animation-name"] = "HYPE_swapToFront";
		nextSceneContainer.style["-webkit-transform"] = "translate3d(0px, 0px, 0px) rotateY(0deg)";


		var hypeContext = this;
		window.setTimeout(function() { hypeContext.completeSceneTransition(currentSceneContainer, nextSceneContainer); }, (1.1 * 1000.0));
	}

	this.showSceneWithPush = function (sceneNumber, direction) {
		var contentContainer = document.getElementById(this.mainContentContainerID);

		var currentSceneContainer = document.getElementById(this.currentSceneIdentifier());
		if(currentSceneContainer != null) {
			currentSceneContainer.style[this.propertyNameForCSS3Transitions()] = "top 1.1s ease-in-out, left 1.1s ease-in-out";
			
			if(direction == this.kSceneTransitionPushLeftToRight) {
				currentSceneContainer.style.left = contentContainer.style.width;
			} else if(direction == this.kSceneTransitionPushRightToLeft) {
				currentSceneContainer.style.left = "-" + parseInt(contentContainer.style.width) + "px";
			} else if(direction == this.kSceneTransitionPushBottomToTop) {
				currentSceneContainer.style.top = "-" + parseInt(contentContainer.style.height) + "px";
			} else if(direction == this.kSceneTransitionPushTopToBottom) {
				currentSceneContainer.style.top = contentContainer.style.height;
			}
		}
		
		this.loadScene(this.identifierOfSceneAtIndex(sceneNumber));

		var nextSceneContainer = document.getElementById(this.currentSceneIdentifier());
		if(direction == this.kSceneTransitionPushLeftToRight) {
			nextSceneContainer.style.left = "-" + parseInt(contentContainer.style.width) + "px";
		} else if(direction == this.kSceneTransitionPushRightToLeft) {
			nextSceneContainer.style.left = contentContainer.style.width;
		} else if(direction == this.kSceneTransitionPushBottomToTop) {
			nextSceneContainer.style.top = contentContainer.style.height;
		} else if(direction == this.kSceneTransitionPushTopToBottom) {
			nextSceneContainer.style.top = "-" + parseInt(contentContainer.style.height) + "px";
		}
		
		nextSceneContainer.style.display = "block";
		var hypeContext = this;
		
		// need to wait a tick otherwise the transtion won't take affect
		window.setTimeout(function() {
			nextSceneContainer.style[hypeContext.propertyNameForCSS3Transitions()] = "top 1.1s ease-in-out, left 1.1s ease-in-out";
			nextSceneContainer.style.left = "0px";
			nextSceneContainer.style.top = "0px";
		}, 1);
		
		window.setTimeout(function() { hypeContext.completeSceneTransition(currentSceneContainer, nextSceneContainer); }, (1.1 * 1000.0));
	}

	function getElementsByClassName(className, elm) {
		if(elm.getElementsByClassName) {
			return elm.getElementsByClassName(className);
		} else {
			var testClass = new RegExp("(^|\\s)" + className + "(\\s|$)");
			var tag = "*";
			elm = elm || document;
			var elements = (tag == "*" && elm.all)? elm.all : elm.getElementsByTagName(tag);
			var returnElements = [];
			var current;
			var length = elements.length;
			for(var i=0; i<length; i++){
				current = elements[i];
				if(testClass.test(current.className)){
					returnElements.push(current);
				}
			}
			return returnElements;
		}
	}

	this.currentSceneIdentifier = function () {
		var scene = this.scenes[this.currentSceneIndex];
		if(scene == null) {
			return null;
		}
		
		return scene["oid"];
	}

	this.identifierOfSceneAtIndex = function (sceneIndex) {
		var scene = this.scenes[sceneIndex];
		if(scene == null) {
			return null;
		}
		return scene.oid;
	}
	
	this.indexOfSceneWithIdentifier = function (sceneIdentifier) {
		for(var i = 0; i < this.scenes.length; i++) {
			if(this.scenes[i].oid == sceneIdentifier) {
				return i;
			}
		}
		return -1;
	}

	this.preloadImages = function () {	
		for(var sceneIndex = 0; sceneIndex < this.scenes.length; sceneIndex++) {
			var initialValues = this.scenes[sceneIndex]["initialValues"];
			
			// find images in BackgroundImage initial value
			for(var index in initialValues) {
				if(initialValues.hasOwnProperty(index) == false) {
					continue;
				}
				
				var backgroundImage = initialValues[index]["BackgroundImage"];				
				if(backgroundImage != null && myIndexOf(this.imagesToPreload, backgroundImage) == -1) {
					this.imagesToPreload.push(backgroundImage);
				}
			}
			
			// find images in timeline animations for BackgroundImage
			var timelines = this.scenes[sceneIndex]["timelines"];
			for(timelineIdentifier in timelines) {
				if(timelines.hasOwnProperty(timelineIdentifier) == false) {
					continue;
				}
		
				var animations = timelines[timelineIdentifier]["animations"];
				for(var i = 0; i < animations.length; i++) {
					if(animations[i]["identifier"]  == "BackgroundImage") {
						var startBackgroundImage = animations[i]["startValue"];
						if(startBackgroundImage != null && myIndexOf(this.imagesToPreload, startBackgroundImage) == -1) {
							this.imagesToPreload.push(startBackgroundImage);
						}
						var endBackgroundImage = animations[i]["endValue"];
						if(endBackgroundImage != null && myIndexOf(this.imagesToPreload, endBackgroundImage) == -1) {
							this.imagesToPreload.push(endBackgroundImage);
						}
					}
				}
			}
		}
		
		// handle edge case of no images
		if(this.imagesToPreload.length == 0) {
			this.preloadFinished();
			return;
		}
		
		this.preloadedImagesCount = 0;
		if(this.browserInfo.ie != null) {
			this.preloadNextImage();
		} else {
			for(var index = 0; index < this.imagesToPreload.length; index++) {
				var img = new Image();
				var hypeContext = this;
				var completionHandler = function() {
					hypeContext.preloadedImagesCount += 1;
					if(hypeContext.preloadedImagesCount >= hypeContext.imagesToPreload.length) {
						hypeContext.preloadFinished();
					}
				}	
				
				img.onload = completionHandler;
				img.onerror = completionHandler;
				img.onabort = completionHandler;
				img.src = "" + this.resourcesFolderName + "/" + this.imagesToPreload[index];
			}
		}
	}
	
	// this is a hack for IE6, as it has issues loading many images and also with closures it seems...
	this.preloadNextImage = function () {
		var img = new Image();
		var hypeContext = this;
		var completionHandler = function() {
			hypeContext.preloadedImagesCount += 1;
			if(hypeContext.preloadedImagesCount >= hypeContext.imagesToPreload.length) {
				hypeContext.preloadFinished();
			} else {
				hypeContext.preloadNextImage();
			}
		}	
		
		img.onload = completionHandler;
		img.onerror = completionHandler;
		img.onabort = completionHandler;
		img.src = "" + this.resourcesFolderName + "/" + this.imagesToPreload[this.preloadedImagesCount];
	}
	
	this.addActionHandler = function (eventName, element, func) {
		this._addActionHandler(eventName, element, func);
		
		// need to make dummy to set hypeDoc.mouseOverElement correctly
		if(eventName == "onmouseover") {
			this._addActionHandler("onmouseout", element, (function (e) { return; }));
		} else if(eventName == "onmouseout") {
			this._addActionHandler("onmouseover", element, (function (e) { return; }));
		}
	}
	
	this._addActionHandler = function (eventName, element, func) {
		if(eventName == "onmouseover" && this.browserInfo.ie != null) {
			eventName = "onmouseenter";
		} else if(eventName == "onmouseout" && this.browserInfo.ie != null) {
			eventName = "onmouseleave";
		} else if(eventName == "onclick") {
			// convert click events to mouse up events because in the case of buttons, the innerhtml change can squash the click event
			eventName = "onmouseup";
		}
		
		var elementActionHandlers = this.actionHandlers[element.id];
		if(elementActionHandlers == null) {
			elementActionHandlers = {};
			this.actionHandlers[element.id] = elementActionHandlers;
		}
		
		var elementActionHandlersForEvent = elementActionHandlers[eventName];
		if(elementActionHandlersForEvent == null) {
			elementActionHandlersForEvent = Array();
			elementActionHandlers[eventName] = elementActionHandlersForEvent;
		}
		
		elementActionHandlersForEvent.push(func);
		
		var hypeDoc = this;
		element[eventName] = (function (e) {
			e = (e) ? e : window.event;
			
			// fixes behavior where inner elements cause bubbled mouseovers/mouseouts
			if(e.type == "mouseover") {
				if(hypeDoc.mouseOverElement != null) {
					// we shouldn't accept other mouse overs
					return;	
				} else {
					// we're really over something, and continue with this method
					hypeDoc.mouseOverElement = e.currentTarget;
				}
			} else if(e.type == "mouseout") {
				// get position and make sure it is really outside the element
				// code adapted from http://www.quirksmode.org/js/events_properties.html
				var posx = 0;
				var posy = 0;
				if(!e) e = window.event;
				if(e.pageX || e.pageY) {
					posx = e.pageX;
					posy = e.pageY;
				} else if (e.clientX || e.clientY) {
					posx = e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
					posy = e.clientY + document.body.scrollTop + document.documentElement.scrollTop;
				}
				
				var mouseOutElement = e.currentTarget.ownerDocument.elementFromPoint(posx, posy);
				var searchElement = e.currentTarget;												
				var currentElement = mouseOutElement;
				while(currentElement != null && currentElement != searchElement && currentElement.nodeName != 'BODY') {
					currentElement = currentElement.parentNode;
				}
				
				if(currentElement == searchElement) {
					// we're still inside
					return;
				} else {
					// set that we're really out of something, and continue with the method
					hypeDoc.mouseOverElement = null;
				}
			}
			
			for(var i = 0; i < elementActionHandlersForEvent.length; i++) {
				elementActionHandlersForEvent[i](e);
			}
		});
	}
		
	this.loadScene = function (sceneIdentifier) {
		this.pauseVideos();
		this.stopAllTimelineRuns();
		
		this.currentSceneIndex = this.indexOfSceneWithIdentifier(sceneIdentifier);
		
		var scene = document.getElementById(sceneIdentifier);
		var sceneIndex = scene.getAttribute("HYPE_scene_index");
		var elements = getElementsByClassName("HYPE_element", scene);
		
		for(var i = 0; i < elements.length; i++) {
			var initialValues = this.scenes[sceneIndex]["initialValues"][elements[i].id];
			if(initialValues == null) {
				continue;
			}
			
			// remove any action handlers
			this.actionHandlers[elements[i].id] = null;
			
			// create an array to hold all current values (used for relative keyframes)
			this.currentValues[elements[i].id] = Array();

			// always set dimensions first
			//!! this is a bit of a hack for IE, since I might rewrite elements... the correct fix would be to lookup the elementbyid each time or to make outer divs that don't change
			this.applyValue(elements[i], "Top", initialValues["Top"], true);
			this.applyValue(elements[i], "Left", initialValues["Left"], true);
			this.applyValue(elements[i], "Width", initialValues["Width"], true);
			this.applyValue(elements[i], "Height", initialValues["Height"], true);

			// apply all other attributes
			for(var attributeIdentifier in initialValues) {
				if(initialValues.hasOwnProperty(attributeIdentifier) == false) {
					continue;
				}
				var initialValue = initialValues[attributeIdentifier];
				this.applyValue(elements[i], attributeIdentifier, initialValue, true);
			}
			
			// add CSSPIE behavior (if applied to a video, quicktime won't play it)
			if(this.browserInfo.ie != null && initialValues["VideoSources"] == null) {
				elements[i].style["behavior"] = "url('" + this.resourcesFolderName.replace("'", "%27") + "/PIE.htc')";
			}
		}
		
		// install key event handlers
		var keyHandlerNames = {"onSceneKeyDownAction" : "onkeydown", "onSceneKeyUpAction" : "onkeyup", "onSceneKeyPressAction" : "onkeypress"};
		for(var handlerName in keyHandlerNames) {
			if(keyHandlerNames.hasOwnProperty(handlerName) == false) {
				continue;
			}
				
			var eventName = keyHandlerNames[handlerName];

			if(this.scenes[sceneIndex][handlerName] != null) {
				// save the chain
				if(this.nextKeyHandlers[eventName] == null && document[eventName] != null) {
					this.nextKeyHandlers[eventName] = document[eventName];
				}
				
				var keyFunction = this.Apply.CreateActionHandler(this, this.scenes[sceneIndex][handlerName], document);
				var hypeContext = this;
				document[eventName] = function (e) {
					keyFunction(e);
					if(hypeContext.nextKeyHandlers["on" + e.type] != null) {
						hypeContext.nextKeyHandlers["on" + e.type](e);
					}
				};				
			} else if(this.nextKeyHandlers[eventName] != null) {
				document[eventName] = this.nextKeyHandlers[eventName];
				this.nextKeyHandlers[eventName] = null;
			} else if(document[eventName] != null) {
				document[eventName] = null;
			}
		}	
	}

	this.completeSceneTransition = function (currentSceneContainer, nextSceneContainer) {
		// cleanup after transition
		if(currentSceneContainer != null && currentSceneContainer != nextSceneContainer) {
			currentSceneContainer.style.display = "none";
			currentSceneContainer.style["-webkit-animation-name"] = null;
			currentSceneContainer.style[this.propertyNameForCSS3Transitions()] = null;
			currentSceneContainer.style.left = "0px";
			currentSceneContainer.style.top = "0px";
		}
		
		nextSceneContainer.style["-webkit-animation-name"] = null;
		nextSceneContainer.style[this.propertyNameForCSS3Transitions()] = null;
		nextSceneContainer.style.left = "0px";
		nextSceneContainer.style.top = "0px";
		
		document.getElementById(this.mainContentContainerID).style["-webkit-perspective"] = null;
		
		var hypeDoc = this;
		var finishCompleteSceneTransition = (function() {
			// begin any animations
			hypeDoc.stopAllTimelineRuns();
			hypeDoc.startTimelineRun(hypeDoc.kTimelineDefaultIdentifier, null);
		});
		
		// scene load event
		var hasLoadTimelineRun = false;
		var sceneIndex = this.indexOfSceneWithIdentifier(nextSceneContainer.id);
		var onSceneLoadData = this.scenes[sceneIndex]["onSceneLoadAction"];
		if(onSceneLoadData != null) {
			var onLoadFunction = this.Apply.CreateActionHandler(this, onSceneLoadData, null);
			if(onSceneLoadData["type"] == this.kActionPlayTimeline && onSceneLoadData["timelineIdentifier"] != null) {
				hasLoadTimelineRun = true;
				this.timelineCompletionOverrideCallback = finishCompleteSceneTransition;
			}
			onLoadFunction(null);
		}
		
		if(hasLoadTimelineRun == false) {
			finishCompleteSceneTransition();
		}
	}

	this.untransformValue = function (value, transformerClassName) {
		if(transformerClassName == "PixelValueTransformer") {
			return parseInt(value, 10);
		} else if(transformerClassName == "DegreeValueTransformer") {
			return parseFloat(value);
		} else if(transformerClassName == "FractionalValueTransformer") {
			return parseFloat(value);
		} else if(transformerClassName == "PercentValueTransformer") {
			return (parseFloat(value) / 100.0);
		} else if(transformerClassName == "ColorValueTransformer") {
			return hex2num(value);
		}
		return value;
	}

	this.transformValue = function (value, transformerClassName) {
		if(transformerClassName == "PixelValueTransformer") {
			return "" + (Math.round(value)) + "px";
		} else if(transformerClassName == "DegreeValueTransformer") {
			return "" + value + "deg";
		} else if(transformerClassName == "FractionalValueTransformer") {
			return "" + value + "";
		} else if(transformerClassName == "PercentValueTransformer") {
			return "" + (parseFloat(value) * 100.0) + "%";
		} else if(transformerClassName == "ColorValueTransformer") {
			return num2hex(value);
		}
		
		return value;
	}

	// Color methods from http://www.openjs.com/scripts/graphics/hex_color_rbg_value_converter.php

	//Convert a hex value to its decimal value - the inputted hex must be in the
	//	format of a hex triplet - the kind we use for HTML colours. The function
	//	will return an array with three values.
	function hex2num(hex) {
		if(hex.charAt(0) == "#") hex = hex.slice(1); //Remove the '#' char - if there is one.
		hex = hex.toUpperCase();
		var hex_alphabets = "0123456789ABCDEF";
		var value = new Array(3);
		var k = 0;
		var int1,int2;
		for(var i=0;i<6;i+=2) {
			int1 = hex_alphabets.indexOf(hex.charAt(i));
			int2 = hex_alphabets.indexOf(hex.charAt(i+1)); 
			value[k] = (int1 * 16) + int2;
			k++;
		}
		return(value);
	}

	//Give a array with three values as the argument and the function will return
	//	the corresponding hex triplet.
	function num2hex(triplet) {
		var hex_alphabets = "0123456789ABCDEF";
		var hex = "#";
		var int1,int2;
		for(var i=0;i<3;i++) {
			int1 = triplet[i] / 16;
			int2 = triplet[i] % 16;

			hex += hex_alphabets.charAt(int1) + hex_alphabets.charAt(int2); 
		}
		return(hex);
	}

	this.applyValue = function (element, attributeIdentifier, value, shouldCache) {
		if(typeof value == "undefined") {
			return;
		}
	
		try {
			if(shouldCache == true) {
				this.currentValues[element.id][attributeIdentifier] = value;
			}
			this.Apply[attributeIdentifier](this, value, element);
		} catch(err) {
			if(window.console && console.log) {
				console.log("error applying " + attributeIdentifier + " : " + value + " -- " + err);
			}
		}
	}
	
	this.pauseVideos = function () {
		var currentSceneContainer = document.getElementById(this.currentSceneIdentifier());
		if(currentSceneContainer != null) {
			var videos = currentSceneContainer.getElementsByTagName("video");
			for(var i = 0; i < videos.length; i++) {
				if(videos[i].pause) {
					videos[i].pause();
				}
			}
		}
	}

	this.applyButtonFromTimelineRun = function (event, timelineIdentifier, triggeringObjectIdentifier) {
		var timeline = this.scenes[this.currentSceneIndex]["timelines"][timelineIdentifier];
		if(timeline == null) {
			return;
		}
		
		var animations = timeline["animations"];
		var element = document.getElementById(triggeringObjectIdentifier);
		
		// clear any previous button states first
		var buttonHoverValue = this.scenes[this.currentSceneIndex]["initialValues"][triggeringObjectIdentifier]["ButtonHover"];
		var buttonPressValue = this.scenes[this.currentSceneIndex]["initialValues"][triggeringObjectIdentifier]["ButtonHover"];
		if(buttonHoverValue != null && buttonHoverValue != timelineIdentifier) {
			this.resetButtonFromTimelineRun(event, buttonHoverValue, triggeringObjectIdentifier);
		}
		if(buttonPressValue != null && buttonPressValue != timelineIdentifier) {
			this.resetButtonFromTimelineRun(event, buttonPressValue, triggeringObjectIdentifier);
		}
		
		for(var i = 0; i < animations.length; i++) {
			var animation = animations[i];
			var oid = animation["oid"];
			if(oid != triggeringObjectIdentifier) {
				// should always be equal
				continue;
			}
			
			var identifier = animation["identifier"];
			var startValue = animation["endValue"];
						
			this.applyValue(element, identifier, startValue, false);
		}
	}
	
	this.resetButtonFromTimelineRun = function (event, timelineIdentifier, triggeringObjectIdentifier) {
		var timeline = this.scenes[this.currentSceneIndex]["timelines"][timelineIdentifier];
		if(timeline == null) {
			return;
		}
		var animations = timeline["animations"];
		var element = document.getElementById(triggeringObjectIdentifier);
		
		for(var i = 0; i < animations.length; i++) {
			var animation = animations[i];
			var oid = animation["oid"];
			if(oid != triggeringObjectIdentifier) { // sanity check, should always be equal
				continue;
			}
			
			if(this.cssTransitionsSupported == true && this.transitionPropertyMapping[animation["identifier"]] != null) {
				this.removeCSS3Transition(animation);
			}
			
			var identifier = animation["identifier"];
			this.applyValue(element, identifier, this.currentValues[triggeringObjectIdentifier][identifier], false);
		}
		
		event = (event) ? event : window.event;
		
		// if this was a mouse click and there's hover values, reinstate those
		if(event.type == "mouseup") {
			var buttonHoverValue = this.scenes[this.currentSceneIndex]["initialValues"][triggeringObjectIdentifier]["ButtonHover"];
			if(buttonHoverValue != null) {
				this.applyButtonFromTimelineRun(event, buttonHoverValue, triggeringObjectIdentifier);
			}
		}
	}
	
	this.createTimelineRun = function (timelineIdentifier, triggeringObjectIdentifier) {
		var timelineRun = Array();
		timelineRun.nextAnimationIndex = 0;
		timelineRun.activeAnimations = Array();
		timelineRun.timelineIdentifier = timelineIdentifier;
		timelineRun.triggeringObjectIdentifier = triggeringObjectIdentifier;
		return timelineRun;
	}
	
	this.playTimelineNamed = function (timelineName) { // public
		var timelines = this.scenes[this.currentSceneIndex]["timelines"];
		for(timelineIdentifier in timelines) {
			if(timelines.hasOwnProperty(timelineIdentifier) == false) {
				continue;
			}
		
			if(timelines[timelineIdentifier]["name"] == timelineName) {
				this.startTimelineRun(timelineIdentifier, null);
				break;
			}
		}		
	}
	
	this.startTimelineRun = function (timelineIdentifier, triggeringObjectIdentifier) {
		var timelineRun = this.createTimelineRun(timelineIdentifier, triggeringObjectIdentifier);

		this.stopIntersectingTimelines(timelineRun);
		this.timelineRuns.push(timelineRun);
	
		timelineRun.nextAnimationIndex = 0;
		timelineRun.activeAnimations = Array();
		timelineRun.animationStartTime = ((new Date).getTime()) / 1000.0;
		var animations = this.scenes[this.currentSceneIndex]["timelines"][timelineRun.timelineIdentifier]["animations"];
		if(animations.length > 0) {
			// I just use continueTimelineRun due to what looks like a timing issue in firefox with transitions that start at time 0
			//this.continueTimelineRunAtTime(animations[0]["startTime"], timelineRun);
			this.continueTimelineRun(timelineRun);
		}
		
		var hypeContext = this;
		timelineRun.animationCompletionTimeout = window.setTimeout(function() { hypeContext.timelineRunCompleteCallback(timelineRun); }, (this.timelineDuration(timelineRun) * 1000));
	}
	
	this.stopIntersectingTimelines = function (timelineRun) {
		var otherRuns = this.timelineRunsWithTriggeringObject(timelineRun.triggeringObjectIdentifier);
		var animations = this.scenes[this.currentSceneIndex]["timelines"][timelineRun.timelineIdentifier]["animations"];
	
		var timelinesToStop = Array();
		for(var i = 0; i < otherRuns.length; i++) {
			var hash = this.hashOfElementOidsAnimatedInTimeline(otherRuns[i]);
			for(var j = 0; j < animations.length; j++) {
				if(hash[animations[j]["oid"]] != null) {
					timelinesToStop.push(otherRuns[i]);
					break;
				}
			}
		}
		
		for(var i = 0; i < timelinesToStop.length; i++) {
			this.stopTimelineRun(timelinesToStop[i]);
		}
	}
	
	this.timelineRunsWithTriggeringObject = function (triggeringObjectIdentifier) {
		var runs = Array();
		for(var i = 0; i < this.timelineRuns.length; i++) {
			if(this.timelineRuns[i].triggeringObjectIdentifier == triggeringObjectIdentifier) {
				runs.push(this.timelineRuns[i]);
			}
		}
		return runs;
	}	
	
	this.hashOfElementOidsAnimatedInTimeline = function (timelineRun) {
		var hash = Array();
		
		// go through anything animating at this moment
		var activeAnimations = timelineRun.activeAnimations;
		for(var i = 0; i < activeAnimations.length; i++) {
			var oid = activeAnimations[i]["oid"]
			if(hash[oid] == null) {
				hash[oid] = "1";
			}
		}
		
		// an any upcoming animation
		var inactiveAnimations = this.scenes[this.currentSceneIndex]["timelines"][timelineRun.timelineIdentifier]["animations"];
		for(var i = timelineRun.nextAnimationIndex; i < inactiveAnimations.length; i++) {
			var oid = inactiveAnimations[i]["oid"]
			if(hash[oid] == null) {
				hash[oid] = "1";
			}
		}
		return hash;
	}
	
	this.stopTimelineRun = function (timelineRun) {
		// clear values
		window.clearTimeout(timelineRun.animationCompletionTimeout);
		timelineRun.nextAnimationIndex = 0;
		timelineRun.activeAnimations = Array();
		timelineRun.animationStartTime = null;
		
		// remove from list of timelineRuns
		var index = myIndexOf(this.timelineRuns, timelineRun);
		if(index != -1) {
			this.timelineRuns.splice(index, 1);
		}
	}
	
	this.stopAllTimelineRuns = function () {
		// stop traditional timeline runs
		while(this.timelineRuns.length > 0) {
			this.stopTimelineRun(this.timelineRuns[0]);
		}
		
		// stop CSS3 Transitions
		var scene = document.getElementById(this.currentSceneIdentifier());
		var sceneIndex = scene.getAttribute("HYPE_scene_index");
		var elements = getElementsByClassName("HYPE_element", scene);
		var cssTransitionName = this.propertyNameForCSS3Transitions();
		
		for(var i = 0; i < elements.length; i++) {
			var transition = elements[i].style[cssTransitionName];
			if(!(transition == null || transition == "")) {
				elements[i].style[cssTransitionName] = "";
			}
		}
	}
	
	this.continueTimelineRun = function (timelineRun) {
		var hypeContext = this;
		window.setTimeout(function () { hypeContext.heartbeat(timelineRun); }, ((1 * 1000.0) / hypeContext.timelineFramesPerSecond(timelineRun)));
	}

	this.continueTimelineRunAtTime = function (nextAnimationTick, timelineRun) {
		var hypeContext = this;
		window.setTimeout(function () { hypeContext.heartbeat(timelineRun); }, (nextAnimationTick * 1000.0));
	}

	this.timelineDuration = function (timelineRun) {
		return this.scenes[this.currentSceneIndex]["timelines"][timelineRun.timelineIdentifier]["duration"];
	}
	
	this.timelineFramesPerSecond = function (timelineRun) {
		return this.scenes[this.currentSceneIndex]["timelines"][timelineRun.timelineIdentifier]["framesPerSecond"];
	}
	
	this.timelineRunCompleteCallback = function (timelineRun) {
		// apply end value because this may be triggered right before the last heartbeat since it is timer based
		for(var i = 0; i < timelineRun.activeAnimations.length; i++) {
			var element = document.getElementById(timelineRun.activeAnimations[i]["oid"]);
			this.applyValue(element, timelineRun.activeAnimations[i]["identifier"], timelineRun.activeAnimations[i]["endValue"], true);
		}
		
		if(this.timelineCompletionOverrideCallback != null) {
			this.timelineCompletionOverrideCallback();
			this.timelineCompletionOverrideCallback = null;
		} else {		
			// perform action if exists
			var currentSceneContainer = document.getElementById(this.currentSceneIdentifier());
			if(currentSceneContainer != null) {
				var sceneIndex = this.indexOfSceneWithIdentifier(this.currentSceneIdentifier());
				var onSceneAnimationCompleteData = this.scenes[sceneIndex]["onSceneAnimationCompleteAction"];
				if(onSceneAnimationCompleteData != null) {
					var onSceneAnimationCompleteFunction = this.Apply.CreateActionHandler(this, onSceneAnimationCompleteData, currentSceneContainer);
					onSceneAnimationCompleteFunction(currentSceneContainer);
				}
			}
		}
	}
	
	this.heartbeat = function (timelineRun) {
		if(myIndexOf(this.timelineRuns, timelineRun) == -1 || timelineRun.animationStartTime == null) {
			return;
		}
	
		var currentTime = (((new Date).getTime()) / 1000.0) - timelineRun.animationStartTime;
		
		if(this.debug) {
			debugArea().innerHTML = "" + (Math.round(currentTime * 100) / 100);
		}
		
		var animations = this.scenes[this.currentSceneIndex]["timelines"][timelineRun.timelineIdentifier]["animations"];
		
		for(var i = timelineRun.nextAnimationIndex; i < animations.length; i++) {
			var animation = animations[i];
			var startTime = animation["startTime"];
			if(currentTime >= startTime) {
				if(animation["type"] == this.kAnimationTypeStandardVideo) {
					var oid = animation["oid"];
					var autoplay = this.scenes[this.currentSceneIndex]["initialValues"][oid]["Autoplay"];
					var element = document.getElementById(oid);
					if(autoplay == true && element.play) {
						element.autoplay = true;
						element.play();
					}
				} else {
					// set the start value to be used for the entirety of the animation
					var identifier = animation["identifier"];
					var oid = animation["oid"];
					var isRelative = animation["isRelative"];
					
					try { // try as a guard against an animation referencing an object that doesn't exist
						if(isRelative == true && this.currentValues[oid][identifier] != null) {
							animation["relativeStartValue"] = this.currentValues[oid][identifier];
						}
					} catch(exception) {
						if(window.console && console.log) {
							console.log("failed getting a currentValue: " + exception);
						}
					}
				
					if(this.cssTransitionsSupported == true && this.transitionPropertyMapping[identifier] != null) {
						this.addCSS3Transition(animation);
					} else {
						// push onto the manually managed array
						timelineRun.activeAnimations.push(animation);
					}
				}
				timelineRun.nextAnimationIndex = i + 1;
			} else {
				break;
			}
		}
		
		for(var i = 0; i < timelineRun.activeAnimations.length; i++) {
			var startTime = timelineRun.activeAnimations[i]["startTime"];
			var duration = timelineRun.activeAnimations[i]["duration"];

			if(this.debug) {
				debugArea().innerHTML += timelineRun.activeAnimations[i]["identifier"];
			}
			
			if(currentTime < startTime + duration) {
				// apply value
				this.applyAnimation(timelineRun.activeAnimations[i], currentTime);
			} else {
				// set value to end value and remove from the list
				var element = document.getElementById(timelineRun.activeAnimations[i]["oid"]);
				this.applyValue(element, timelineRun.activeAnimations[i]["identifier"], timelineRun.activeAnimations[i]["endValue"], true);
				timelineRun.activeAnimations.splice(i, 1);
				i--;
			}
		}
		
		if(currentTime <= this.timelineDuration(timelineRun)) {
			if(timelineRun.activeAnimations.length > 0) {
				this.continueTimelineRun(timelineRun);
			} else if(timelineRun.nextAnimationIndex < animations.length) {
				this.continueTimelineRunAtTime(animations[timelineRun.nextAnimationIndex]["startTime"] - currentTime, timelineRun);
			}
		}
	}
	
	this.propertyNameForCSS3Transitions = function () {
		if(this.browserInfo.gecko != null) {
			return "MozTransition";
		}
		
		return "-webkit-transition";
	}
	
	this.removeCSS3Transition = function (animation) {
		var element = document.getElementById(animation["oid"]);
		if(element == null) {
			return;
		}
		var transitionProperty = this.transitionPropertyMapping[animation["identifier"]];
		var cssTransitionName = this.propertyNameForCSS3Transitions();
		
		var currentTransition = element.style[cssTransitionName];
		if(currentTransition != null && currentTransition != "") {
			var transitions = currentTransition.split(",");
			var newTransitions = currentTransition.split(",");
			for(var i = 0; i < transitions.length; i++) {
				if(transitions[i].indexOf(transitionProperty) != -1) {
					newTransitions.splice(i, 1);
					break;
				}
			}
			element.style[cssTransitionName] = newTransitions.join(",");
		}
	}
	
	this.addCSS3Transition = function (animation) {
		var element = document.getElementById(animation["oid"]);
		if(element == null) {
			return;
		}
		var transitionProperty = this.transitionPropertyMapping[animation["identifier"]];
		var transitionDuration = animation["duration"];
		var transitionTimingFunction = this.transitionTimingFunctionMapping[animation["timingFunction"]];
		var transitionString = "" + transitionProperty + " " + transitionDuration + "s " + transitionTimingFunction;
		var cssTransitionName = this.propertyNameForCSS3Transitions();
		
		var currentTransition = element.style[cssTransitionName];
		if(currentTransition != null && currentTransition != "") {
			var foundMatchingTransition = false;
			var transitions = currentTransition.split(",");
			for(var i = 0; i < transitions.length; i++) {
				if(transitions[i].indexOf(transitionProperty) != -1) {
					transitions[i] = transitionString;
					foundMatchingTransition = true;
					break;
				}
			}
			
			if(foundMatchingTransition == false) {
				transitions.push(transitionString);
			}
			
			element.style[cssTransitionName] = transitions.join(",");
		} else {
			element.style[cssTransitionName] = transitionString;
		}
		
		this.applyValue(element, animation["identifier"], animation["endValue"], true);
	}

	this.applyAnimation = function (animation, currentTime) {
		var startTime = animation["startTime"];
		var duration = animation["duration"];
		var identifier = animation["identifier"];
		var oid = animation["oid"];
		var relativeStartValue = animation["relativeStartValue"];
		var startValue = (relativeStartValue == null) ? animation["startValue"] : relativeStartValue;
		var endValue = animation["endValue"];
		var timingFunction = animation["timingFunction"];	

		var transformerClassName = this.attributeTransformerMapping[identifier];
		
		var element = document.getElementById(oid);
		
		var percentComplete = (currentTime - startTime) / duration;
		var adjustedPercentComplete = 1.0;
		
		if(timingFunction == "linear") {
			adjustedPercentComplete = percentComplete;
		} else if(timingFunction == "easein") {
			adjustedPercentComplete = solveCubicBezierFunction(0.42, 0.0, 1.0, 1.0, percentComplete, 1.0);
		} else if(timingFunction == "easeout") {
			adjustedPercentComplete = solveCubicBezierFunction(0.0, 0.0, 0.58, 1.0, percentComplete, 1.0);
		} else if(timingFunction == "easeinout") {
			adjustedPercentComplete = solveCubicBezierFunction(0.42, 0.0, 0.58, 1.0, percentComplete, 1.0);
		}
		
		if(transformerClassName == "PixelValueTransformer" || transformerClassName == "DegreeValueTransformer" || transformerClassName == "FractionalValueTransformer" || transformerClassName == "PercentValueTransformer") {
			var untransformedStart = this.untransformValue(startValue, transformerClassName);
			var untransformedEnd = this.untransformValue(endValue, transformerClassName);
			var untransformedCurrent = untransformedStart + ((untransformedEnd - untransformedStart) * adjustedPercentComplete);
			var currentValue = this.transformValue(untransformedCurrent, transformerClassName);		
			this.applyValue(element, identifier, currentValue, true);
		} else if(transformerClassName == "ColorValueTransformer") {
			var untransformedStart = this.untransformValue(startValue, transformerClassName);
			var untransformedEnd = this.untransformValue(endValue, transformerClassName);

			var untransformedCurrentRed = untransformedStart[0] + ((untransformedEnd[0] - untransformedStart[0]) * adjustedPercentComplete);
			var untransformedCurrentGreen = untransformedStart[1] + ((untransformedEnd[1] - untransformedStart[1]) * adjustedPercentComplete);
			var untransformedCurrentBlue = untransformedStart[2] + ((untransformedEnd[2] - untransformedStart[2]) * adjustedPercentComplete);
			
			var currentValue = this.transformValue([untransformedCurrentRed, untransformedCurrentGreen, untransformedCurrentBlue], transformerClassName);
			this.applyValue(element, identifier, currentValue, true);
		} else {
			if(adjustedPercentComplete == 1.0) {
				this.applyValue(element, identifier, endValue, true);
			}
		}
	}

	function solveEpsilon(duration) {
		return 1.0 / (200.0 * duration);
	}

	function solveCubicBezierFunction(p1x, p1y, p2x, p2y, t, duration) {
		// Convert from input time to parametric value in curve, then from
		// that to output time.
		var bezier = new UnitBezier(p1x, p1y, p2x, p2y);
		return bezier.solve(t, solveEpsilon(duration));
	}
	
	function myIndexOf(haystack, needle) {
		if(haystack.indexOf) {
			return haystack.indexOf(needle);
		} else {
			for(var i = 0; i < haystack.length; i++) {
				if(haystack[i] == needle) {
					return i;
				}
			}
		}
		return -1;
	}
	
	// modified from source found at: http://frugalcoder.us/post/2010/09/13/browser-detection.aspx
	this.browserInfo = (function () {
		var b = {};
	
		if (!navigator) return b;

		//browsermatch method...
		function bm(re) {
			var m = (navigator && navigator.userAgent && navigator.userAgent.match(re));
			return (m && m[1]);
		}

		//setup browser detection
		b.ie = parseFloat(bm(/MSIE (\d+\.\d+)/)) || null;
		b.gecko = parseFloat(bm(/Gecko\/(\d+)/)) || null;
		b.ff = parseFloat(bm(/Firefox\/(\d+\.\d+)/)) || null;
		b.khtml = parseFloat(bm(/\((KHTML)/) && 1) || null;
		b.webkit = parseFloat(bm(/AppleWebKit\/(\d+\.\d+)/));
		b.chrome = parseFloat(b.webkit && bm(/Chrome\/(\d+\.\d+)/)) || null;
		b.safari = parseFloat(b.webkit && bm(/Safari\/(\d+\.\d+)/) && bm(/Version\/(\d+\.\d+)/)) || null;
		b.opera = parseFloat(bm(/Opera\/(\d+\.\d+)/) && bm(/Version\/(\d+\.\d+)/)) || bm(/Opera\/(\d+\.\d+)/) || null;
		b.android = (navigator.userAgent.search("Android") > -1) || null;

		//delete empty values
		for (var x in b) {
			if (b[x] === null || isNaN(b[x]))
				delete b[x];
		}

		//disable IE matching for older Opera versions.
		if (b.opera && b.ie) delete b.ie;
		
		return b;
	}());


	
	function UnitBezier(p1x, p1y, p2x, p2y) {
		// Calculate the polynomial coefficients, implicit first and last control points are (0,0) and (1,1).
		this.cx = 3.0 * p1x;
		this.bx = 3.0 * (p2x - p1x) - this.cx;
		this.ax = 1.0 - this.cx -this.bx;
		 
		this.cy = 3.0 * p1y;
		this.by = 3.0 * (p2y - p1y) - this.cy;
		this.ay = 1.0 - this.cy - this.by;	
	}

	UnitBezier.prototype.sampleCurveX = function(t) {
		// `ax t^3 + bx t^2 + cx t' expanded using Horner's rule.
		return ((this.ax * t + this.bx) * t + this.cx) * t;
	};

	UnitBezier.prototype.sampleCurveY = function(t) {
		return ((this.ay * t + this.by) * t + this.cy) * t;
	};

	UnitBezier.prototype.sampleCurveDerivativeX = function(t) {
		return (3.0 * this.ax * t + 2.0 * this.bx) * t + this.cx;
	};

	// Given an x value, find a parametric value it came from.
	UnitBezier.prototype.solveCurveX = function(x, epsilon) {
		var t0;
		var t1;
		var t2;
		var x2;
		var d2;
		var i;

		// First try a few iterations of Newton's method -- normally very fast.
		for (t2 = x, i = 0; i < 8; i++) {
			x2 = this.sampleCurveX(t2) - x;
			if (Math.abs(x2) < epsilon)
				return t2;
			d2 = this.sampleCurveDerivativeX(t2);
			if (Math.abs(d2) < 1e-6)
				break;
			t2 = t2 - x2 / d2;
		}

		// Fall back to the bisection method for reliability.
		t0 = 0.0;
		t1 = 1.0;
		t2 = x;

		if (t2 < t0)
			return t0;
		if (t2 > t1)
			return t1;

		while (t0 < t1) {
			x2 = this.sampleCurveX(t2);
			if (Math.abs(x2 - x) < epsilon)
				return t2;
			if (x > x2)
				t0 = t2;
			else
				t1 = t2;
			t2 = (t1 - t0) * 0.5 + t0;
		}

		// Failure.
		return t2;
	};

	UnitBezier.prototype.solve = function(x, epsilon) {
		return this.sampleCurveY(this.solveCurveX(x, epsilon));
	};

	
	
	this.Apply = ({
			Top : function (hypeDoc, value, element) {
				element.style.top = value;
			},

			Left : function (hypeDoc, value, element) {
				element.style.left = value;
			},

			Width : function (hypeDoc, value, element) {
				value = "" + (Math.max(0, parseInt(value))) + "px";
				element.style.width = value;
				
				// for IE QT plugin	
				var embedobj = element.ownerDocument.embeds["embedobj_" + element.id];
				if(embedobj != null) {
					embedobj.setAttribute("width", value);
				}
			},

			Height : function (hypeDoc, value, element) {
				value = "" + (Math.max(0, parseInt(value))) + "px";
				element.style.height = value;
				
				// for IE QT plugin
				var embedobj = element.ownerDocument.embeds["embedobj_" + element.id];
				if(embedobj != null) {
					embedobj.setAttribute("height", value);
				}
			},			

			FontSize : function (hypeDoc, value, element) {
				element.style.fontSize = value;
			},
			
			FontFamily : function (hypeDoc, value, element) {
				element.style.fontFamily = value;
			},
			
			FontWeight : function (hypeDoc, value, element) {
				element.style.fontWeight = value;
			},
			
			FontStyle : function (hypeDoc, value, element) {
				element.style.fontStyle = value;
			},
			
			TextDecoration : function (hypeDoc, value, element) {
				element.style.textDecoration = value;
			},
			
			TextAlign : function (hypeDoc, value, element) {
				element.style.textAlign = value;
			},
			
			TextColor : function (hypeDoc, value, element) {
				element.style.color = value;
			},
			
			LetterSpacing : function (hypeDoc, value, element) {
				element.style.letterSpacing = value;
			},
			
			WordSpacing : function (hypeDoc, value, element) {
				element.style.wordSpacing = value;
			},
			
			LineHeight : function (hypeDoc, value, element) {
				element.style.lineHeight = value;
			},

			ReflectionOffset : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_ReflectionOffset", value);

				var reflectionDepth = element.getAttribute("HYPE_ReflectionDepth");
				if(reflectionDepth != null) {
					hypeDoc.Apply.ReflectionDepth(hypeDoc, reflectionDepth, element);
				}
			},

			ReflectionDepth : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_ReflectionDepth", value);
				
				var reflectionOffset = element.getAttribute("HYPE_ReflectionOffset");
				if(reflectionOffset == null) {
					//TODO: make it so this value comes from the same place for HypeAttribute and the javascript
					reflectionOffset = "8px";
				}
				
				if(hypeDoc.browserInfo.android == null) {
					if((1.0 - value) == 1.0 && element.style.removeProperty != null) {
						element.style.removeProperty("-webkit-box-reflect");
					} else {
						element.style["-webkit-box-reflect"] = "below " + reflectionOffset + " -webkit-gradient(linear, left top, left bottom, from(transparent), color-stop(" + (1.0 - value) + ", transparent), to(rgba(255, 255, 255, .5)))";
					}
				}
			},

			RotationAxis: function (hypeDoc, value, element) {
				element.setAttribute("HYPE_Axis", value);
				
				var rotateAngleValue = element.getAttribute("HYPE_Rotate");
				if(rotateAngleValue != null) {
					hypeDoc.Apply.Rotate(hypeDoc, rotateAngleValue, element);
				}	
			}, 

			Rotate : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_Rotate", value);

				var rotateAxisValue = element.getAttribute("HYPE_Axis");
				if(rotateAxisValue == null) {
					rotateAxisValue = "0";
				}
					
				if(rotateAxisValue == "0") {
					// ie 6-8
					if(hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
						var radians = Math.PI * (parseInt(value) / 180);
						var costheta = Math.cos(radians);
						var sintheta = Math.sin(radians);
						element.setAttribute("HYPE_MS_rotation", "progid:DXImageTransform.Microsoft.Matrix(M11=" + costheta + ",M12=" + (sintheta * -1) + ",M21=" + sintheta + ",M22=" + costheta + ",SizingMethod='auto expand')");
						hypeDoc.Apply.ApplyMSFilters(element);
						return;
					}
					
					// webkit
					element.style["-webkit-transform"] = "rotate(" + value + ")";
					
					// mozilla
					element.style["MozTransform"] = "rotate(" + value + ")";
					
					// opera
					element.style.OTransform = "rotate(" + value + ")";
					
					// ie-9
					element.style["-ms-transform"] = "rotate(" + value + ")";
				} else if(rotateAxisValue == "1") {
					element.style["-webkit-transform"] = "rotateY(" + value + ")";		
				} else if(rotateAxisValue == "2") {
					element.style["-webkit-transform"] = "rotateX(" + value + ")";		
				}				
			},

			ApplyMSFilters : function (element) {
				var opacity8 = element.getAttribute("HYPE_MS_opacity8");
				var opacity5 = element.getAttribute("HYPE_MS_opacity5");
				var rotation = element.getAttribute("HYPE_MS_rotation");
				var background = element.getAttribute("HYPE_MS_background");
				
				var filterText = "";
				if(opacity8 != null) {
					filterText += " " + opacity8;
				}
				if(opacity5 != null) {
					filterText += " " + opacity5;
				}
				if(rotation != null) {
					filterText += " " + rotation;
				}
				if(background != null) {
					filterText += " " + background;
				}
				
				element.style["filter"] = filterText;
			}, 

			Opacity : function (hypeDoc, value, element) {
				if(hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					if(parseInt(value) == 1.0) {
						// ie 8
						element.setAttribute("HYPE_MS_opacity8", "");
						// ie 5-7
						element.setAttribute("HYPE_MS_opacity5", "");	
					} else {				
						// ie 8
						element.setAttribute("HYPE_MS_opacity8", "progid:DXImageTransform.Microsoft.Alpha(Opacity=" + Math.round(value * 100) + ")");
						// ie 5-7
						element.setAttribute("HYPE_MS_opacity5", "alpha(opacity=" + Math.round(value * 100) + ")");						
					}
					hypeDoc.Apply.ApplyMSFilters(element);
				}
			
				// others
				element.style.opacity = value;
			},
			
			Cursor : function (hypeDoc, value, element) {
				element.style.cursor = value;
			},
			
			UserSelect : function (hypeDoc, value, element) {
				// webkit
				element.style["-webkit-user-select"] = value;
				
				// mozilla
				element.style["MozUserSelect"] = value;
				
				// ie
				element.onselectstart = (function() { return false; });
			},

			BorderWidthLeft : function (hypeDoc, value, element) {
				element.style.borderLeftWidth = value;
			},

			BorderWidthRight : function (hypeDoc, value, element) {
				element.style.borderRightWidth = value;
			},

			BorderWidthTop : function (hypeDoc, value, element) {
				element.style.borderTopWidth = value;
			},

			BorderWidthBottom : function (hypeDoc, value, element) {
				element.style.borderBottomWidth = value;
			},

			BorderColorLeft : function (hypeDoc, value, element) {
				element.style.borderLeftColor = value;
			},

			BorderColorRight : function (hypeDoc, value, element) {
				element.style.borderRightColor = value;
			},

			BorderColorTop : function (hypeDoc, value, element) {
				element.style.borderTopColor = value;
			},

			BorderColorBottom : function (hypeDoc, value, element) {
				element.style.borderBottomColor = value;
			},

			BorderStyleLeft : function (hypeDoc, value, element) {
				element.style.borderLeftStyle = value;
			},

			BorderStyleRight : function (hypeDoc, value, element) {
				element.style.borderRightStyle = value;
			},

			BorderStyleTop : function (hypeDoc, value, element) {
				element.style.borderTopStyle = value;
			},

			BorderStyleBottom : function (hypeDoc, value, element) {
				element.style.borderBottomStyle = value;
			},
			
			MSBorderRadius : function (element) {
				var topLeft = element.getAttribute("HYPE_MS_BorderTopLeftRadius");
				if(topLeft == null) {
					topLeft = "0px";
				}
				var topRight = element.getAttribute("HYPE_MS_BorderTopRightRadius");
				if(topRight == null) {
					topRight = "0px";
				}
				var bottomLeft = element.getAttribute("HYPE_MS_BorderBottomLeftRadius");
				if(bottomLeft == null) {
					bottomLeft = "0px";
				}
				var bottomRight = element.getAttribute("HYPE_MS_BorderBottomRightRadius");
				if(bottomRight == null) {
					bottomRight = "0px";
				}
				
				element.style["border-radius"] = "" + topLeft + " " + topRight + " " + bottomRight + " " + bottomLeft;
			},
			
			BorderRadiusTopLeft : function (hypeDoc, value, element) {
				element.style.borderTopLeftRadius = value;
				
				// firefox 3.6
				element.style["MozBorderRadiusTopleft"] = value;
				
				// PIE IE
				if(hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					element.setAttribute("HYPE_MS_BorderTopLeftRadius", value);
					hypeDoc.Apply.MSBorderRadius(element);
				}
			},
			
			BorderRadiusTopRight : function (hypeDoc, value, element) {
				element.style.borderTopRightRadius = value;

				// firefox 3.6
				element.style["MozBorderRadiusTopright"] = value;
				
				// PIE IE
				if(hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					element.setAttribute("HYPE_MS_BorderTopRightRadius", value);
					hypeDoc.Apply.MSBorderRadius(element);
				}
			},
			
			BorderRadiusBottomLeft : function (hypeDoc, value, element) {
				element.style.borderBottomLeftRadius = value;
				
				// firefox 3.6
				element.style["MozBorderRadiusBottomleft"] = value;

				// PIE IE
				if(hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					element.setAttribute("HYPE_MS_BorderBottomLeftRadius", value);
					hypeDoc.Apply.MSBorderRadius(element);
				}
			},
			
			BorderRadiusBottomRight : function (hypeDoc, value, element) {
				element.style.borderBottomRightRadius = value;

				// firefox 3.6
				element.style["MozBorderRadiusBottomright"] = value;
				
				// PIE IE
				if(hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					element.setAttribute("HYPE_MS_BorderBottomRightRadius", value);
					hypeDoc.Apply.MSBorderRadius(element);
				}
			},
			
			VideoSources : function (hypeDoc, value, element) {
				element.innerHTML = "";
			
				var objectEmbedSource = null;
			
				for(var i = 0; i < value.length; i++) {
					var sourceInfo = value[i];
					var sourceElement = element.ownerDocument.createElement("source");
					sourceElement.src = "" + hypeDoc.resourcesFolderName + "/" + sourceInfo["filename"];
					if(sourceInfo["type"] != null) {
						sourceElement.setAttribute("type", sourceInfo["type"]);
					}
					
					if(objectEmbedSource == null && sourceInfo["type"] != "video/ogg" && sourceInfo["type"] != "video/webm") {
						objectEmbedSource = "" + hypeDoc.resourcesFolderName + "/" + sourceInfo["filename"];
					}
					
					element.appendChild(sourceElement);
				}
				
				if(objectEmbedSource != null && hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					// replace the video tag with the div tag, and then put an embed to the quicktime plugin inside
					var div = element.ownerDocument.createElement("div");
					for(var i = 0; i < element.attributes.length; i++) {
						var attr = element.attributes.item(i);
						div.setAttribute(attr.name, attr.value);
					}
					if(element.hasChildNodes) {
						for(var i = 0; i < element.childNodes.length; i++) {
							div.appendChild(element.childNodes.item(i));
						}
					}
					div.style.cssText = element.style.cssText;
					
					element.parentNode.replaceChild(div, element);
										
					var controls = "false";					
					if(div.getAttribute("controls") != null && (div.getAttribute("controls") == "controls" || div.getAttribute("controls") == "1" || div.getAttribute("controls") == "True" || div.getAttribute("controls") == "true")) {
						controls = "true";
					}

					var loop = "false";					
					if(div.getAttribute("loop") != null && (div.getAttribute("loop") == "loop" || div.getAttribute("loop") == "1" || div.getAttribute("loop") == "True" || div.getAttribute("loop") == "true")) {
						loop = "true";
					}

					var mute = "100";					
					if(div.getAttribute("mute") != null && (div.getAttribute("mute") == "loop" || div.getAttribute("mute") == "1" || div.getAttribute("mute") == "True" || div.getAttribute("mute") == "true")) {
						mute = "0";
					}
					
					var embedSource = "<embed ";
						embedSource += " src = '" + objectEmbedSource + "' ";
						embedSource += " classid = 'clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B' ";
						embedSource += " codebase = 'http://www.apple.com/qtactivex/qtplugin.cab' ";
						embedSource += " width = '" + div.style["width"] + "' ";
						embedSource += " height = '" + div.style["height"] + "' ";
						embedSource += " enablejavascript = 'true' ";
						embedSource += " postdomevents = 'true' ";
						embedSource += " scale = 'tofit' ";
						embedSource += " name = 'embedobj_" + div.id + "' "
						embedSource += " id = 'embedobj_" + div.id + "' "
						embedSource += " controller = '" + controls + "' ";
						embedSource += " loop = '" + loop + "' ";
						embedSource += " volume = '" + mute + "' ";
						embedSource += " autoplay = 'false' ";
						embedSource += "></embed>";
					
					div.innerHTML = embedSource;
					
					div.play = (function () {
						var embedobj = element.ownerDocument.embeds["embedobj_" + this.id];
						hypeDoc.Apply.Play(true, embedobj);
					});
					div.pause = (function () {
						var embedobj = element.ownerDocument.embeds["embedobj_" + this.id];
						hypeDoc.Apply.Play(false, embedobj);
					});
				}
				
			},
			
			
			// this is internal for IE support
			Play : function (value, embedobj) {
				var hasLoaded = false;
				try {
					hasLoaded = embedobj.GetControllerVisible() != null;
				} catch(err) { }
				
				if(hasLoaded == true) {
					if(value == true) {
						embedobj.Play()
					} else {
						embedobj.Pause()
					}
				} else {
					// retry once the object is loaded
					window.setTimeout(function() { hypeDoc.Apply.Play(true, embedobj) }, 100);
				}
			},

			Autoplay : function (hypeDoc, value, element) {
				// autoplay is now used by Hype's animation system
				element.autoplay = false;// (value != 0);
			},

			Controls : function (hypeDoc, value, element) {
				element.setAttribute("controls", value);
				element.controls = (value != 0);
				var embedobj = element.ownerDocument.embeds["embedobj_" + element.id];
				
				if(embedobj != null && hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					var hasLoaded = false;
					try {
						hasLoaded = embedobj.GetControllerVisible() != null;
					} catch(err) { }
					
					if(hasLoaded == true) {
						var booleanValue = parseInt(value) != 0;
						embedobj.SetControllerVisible(booleanValue);
					} else {
						// retry once the object is loaded
						window.setTimeout(function() { hypeDoc.Apply.Controls(hypeDoc, value, element) }, 100);
					}
				}
			},

			Muted : function (hypeDoc, value, element) {
				element.setAttribute("mute", value);
				element.volume = (value != 0) ? "0.0" : "1.0";

				var embedobj = element.ownerDocument.embeds["embedobj_" + element.id];
				if(embedobj != null && hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					var hasLoaded = false;
					try {
						hasLoaded = embedobj.GetMute() != null;
					} catch(err) { }

					if(hasLoaded == true) {
						var booleanValue = parseInt(value) != 0;
						embedobj.SetMute(booleanValue);
					} else {
						// retry once the object is loaded
						window.setTimeout(function() { hypeDoc.Apply.Muted(hypeDoc, value, element) }, 100);
					}
				}
			},

			Loop : function (hypeDoc, value, element) {
				element.setAttribute("loop", value);
				element.loop = (value != 0);

				var embedobj = element.ownerDocument.embeds["embedobj_" + element.id];
				if(embedobj != null && hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9) {
					var hasLoaded = false;
					try {
						hasLoaded = embedobj.GetIsLooping() != null;
					} catch(err) { }

					if(hasLoaded == true) {
						var booleanValue = parseInt(value) != 0;
						embedobj.SetIsLooping(booleanValue);
					} else {
						// retry once the object is loaded
						window.setTimeout(function() { hypeDoc.Apply.Loop(hypeDoc, value, element) }, 100);
					}
				}
			},

			Position : function (hypeDoc, value, element) {
				element.style.position = value;
			},

			Display : function (hypeDoc, value, element) {
				element.style.display = value;
			},
			
			AltText : function (hypeDoc, value, element) {
				element.setAttribute("title", value);
				element.setAttribute("alt", value);
			},

			BackgroundColor : function (hypeDoc, value, element) {
				element.style.backgroundColor = value;
			},

			BackgroundGradientStartColor : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_BackgroundGradientStartColor", value);
				hypeDoc.Apply.BackgroundGradient(hypeDoc, element);
			},
			
			BackgroundGradientEndColor : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_BackgroundGradientEndColor", value);
				hypeDoc.Apply.BackgroundGradient(hypeDoc, element);
			},
			
			BackgroundGradientAngle : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_BackgroundGradientAngle", value);
				hypeDoc.Apply.BackgroundGradient(hypeDoc, element);
			},
			
			BackgroundGradient : function (hypeDoc, element) {
				var backgroundGradientStartColor = element.getAttribute("HYPE_BackgroundGradientStartColor");
				if(backgroundGradientStartColor == null || backgroundGradientStartColor == "") {
					return;
				}
				var backgroundGradientEndColor = element.getAttribute("HYPE_BackgroundGradientEndColor");
				if(backgroundGradientEndColor == null || backgroundGradientEndColor == "") {
					return;
				}
				var backgroundGradientAngle = element.getAttribute("HYPE_BackgroundGradientAngle");
				if(backgroundGradientAngle == null) {
					return;
				}
				
				function rotateAngle(angle, byDegrees) {
					return (parseFloat(angle) + byDegrees) % 360;
				}
				
				function percentRectFromAngle(angle, element) {
					angle = rotateAngle(angle, 270);
					var width = parseFloat(element.style.width);
					var height = parseFloat(element.style.height);
					
					var slope = Math.sin((angle / 180.0) * Math.PI) / Math.cos((angle / 180.0) * Math.PI);
					var y1 = (slope * (width / 2.0)) + (height / 2.0); // y intersection on the right line
					var x1 = ((height / 2.0) / slope) + (width / 2.0);  // x intersection on the top line
					
					// decide to use the x or y axis
					if(y1 < 0 || y1 > height) {
						y1 = height;
					} else {
						x1 = width;
					}

					// the other point will always be the inverse x/y
					var x2 = width - x1;
					var y2 = height - y1;

					// swap the points depending on our angle so the line is continuously sweeping
					if(angle > 135 && angle <= 315) {
						var temp = x2;
						x2 = x1;
						x1 = temp;
						temp = y2;
						y2 = y1;
						y1 = temp;
					}

					// convert to percentages for the CSS gradient
					var x1Percent = Math.round((x1 / width) * 100);
					var y1Percent = Math.round((y1 / height) * 100);
					var x2Percent = Math.round((x2 / width) * 100);
					var y2Percent = Math.round((y2 / height) * 100);	
					
					return { "x1" : x1Percent, "y1" : y1Percent, "x2" : x2Percent, "y2" : y2Percent };
				}
				
				if(hypeDoc.browserInfo.webkit != null) {
					var percentRectValues = percentRectFromAngle(backgroundGradientAngle, element);
					element.style.backgroundImage = "-webkit-gradient(linear, " + percentRectValues["x1"] + "% " + percentRectValues["y1"] + "%, " + percentRectValues["x2"] + "% " + percentRectValues["y2"] + "%, from(" + backgroundGradientStartColor + "), to(" + backgroundGradientEndColor + "))";
				} else if(hypeDoc.browserInfo.gecko != null) {
					element.style.backgroundImage = "-moz-linear-gradient(" + (rotateAngle(360 - Math.abs(parseFloat(backgroundGradientAngle)), 270)) + "deg, " + backgroundGradientStartColor + ", " + backgroundGradientEndColor + ")";
				} else if(hypeDoc.browserInfo.ie != null) {
					element.style["-pie-background"] = "linear-gradient(" + (rotateAngle(360 - Math.abs(parseFloat(backgroundGradientAngle)), 270)) + "deg, " + backgroundGradientStartColor + ", " + backgroundGradientEndColor + ")";
				} else if(hypeDoc.browserInfo.opera != null) {
					element.style.backgroundImage = "-o-linear-gradient(" + (rotateAngle(360 - Math.abs(parseFloat(backgroundGradientAngle)), 270)) + "deg, " + backgroundGradientStartColor + ", " + backgroundGradientEndColor + ")";
				} else {
					element.style.backgroundImage = "linear-gradient(" + (rotateAngle(360 - Math.abs(parseFloat(backgroundGradientAngle)), 270)) + "deg, " + backgroundGradientStartColor + ", " + backgroundGradientEndColor + ")";
				}
			},

			BackgroundImage : function (hypeDoc, value, element) {
				//!! do not do this for webkit based browsers because they work the old way and this will cause a crash! (need to file)
				if(hypeDoc.browserInfo.webkit == null && (element.style.backgroundRepeat == null || element.style.backgroundRepeat == "" || element.style.backgroundRepeat == "no-repeat")) {
					// need to create an img tag because IE and FF 3.5 can't scale background images
					var imgId = "img_" + element.id;
					var imgElement = document.getElementById(imgId);
					if(imgElement != null) {
						imgElement.parentNode.removeChild(imgElement);
					}
					
					var img = document.createElement("img");
					img.src = "" + hypeDoc.resourcesFolderName + "/" + value;
					img.id = imgId;
					img.style.position = "absolute";
					img.style.width = "100%";
					img.style.height = "100%";
					img.style.top = "0px";
					img.style.left = "0px";
					img.style.zIndex = "-10000";
					
					// for pngs on IE 7-8, add a fix for a background color
					if(hypeDoc.browserInfo.ie != null && hypeDoc.browserInfo.ie < 9 && hypeDoc.browserInfo.ie > 6 && value.substr(value.length-4).toLowerCase() == '.png') {
						var msBackgroundGradient = "progid:DXImageTransform.Microsoft.gradient(startColorstr=#00FFFFFF,endColorstr=#00FFFFFF)";
						img.setAttribute("HYPE_MS_background", msBackgroundGradient);
						hypeDoc.Apply.ApplyMSFilters(img);
					}
					
					element.appendChild(img);
				} else {
					element.style.backgroundImage = "url('" + (hypeDoc.resourcesFolderName + "/" + value).replace("'", "%27") + "')";
				}
			},

			BackgroundSize : function (hypeDoc, value, element) {
				element.style.backgroundSize = value;
				
				// webkit
				element.style["-webkit-background-size"] = value;
				
				// mozilla
				element.style["MozBackgroundSize"] = value;
			},

			BackgroundOrigin : function (hypeDoc, value, element) {
				element.style.backgroundOrigin = value;
				
				// webkit
				element.style["-webkit-background-origin"] = value;
				
				// mozilla
				element.style["MozBackgroundOrigin"] = value;
			},

			BackgroundRepeat : function (hypeDoc, value, element) {
				// remove that extra img tag we added in backgroundImage
				if(value != null && value != "no-repeat") {
					var img = document.getElementById("img_" + element.id);
					if(img != null) {
						element.style.backgroundImage = "url('" + img.src.replace("'", "%27") + "')";
						img.parentNode.removeChild(img);
					}
				}
			
				element.style.backgroundRepeat = value;
			},

			Overflow : function (hypeDoc, value, element) {
				element.style.overflow = value;
			},

			PaddingLeft : function (hypeDoc, value, element) {
				element.style.paddingLeft = value;
			},
			
			PaddingRight : function (hypeDoc, value, element) {
				element.style.paddingRight = value;
			},
			
			PaddingTop : function (hypeDoc, value, element) {
				element.style.paddingTop = value;
			},
			
			PaddingBottom : function (hypeDoc, value, element) {
				element.style.paddingBottom = value;
			},
			
			BoxShadowXOffset : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_BoxShadowXOffset", value);
				hypeDoc.Apply.BoxShadow(element);
			},

			BoxShadowYOffset : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_BoxShadowYOffset", value);
				hypeDoc.Apply.BoxShadow(element);
			},
			
			BoxShadowColor : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_BoxShadowColor", value);
				hypeDoc.Apply.BoxShadow(element);
			},
			
			BoxShadowBlurRadius : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_BoxShadowBlurRadius", value);
				hypeDoc.Apply.BoxShadow(element);
			},
			
			BoxShadow : function (element) {
				var boxShadowXOffset = element.getAttribute("HYPE_BoxShadowXOffset");
				if(boxShadowXOffset == null) {
					return;
				}
				var boxShadowYOffset = element.getAttribute("HYPE_BoxShadowYOffset");
				if(boxShadowYOffset == null) {
					return;
				}
				var boxShadowShadowColor = element.getAttribute("HYPE_BoxShadowColor");
				if(boxShadowShadowColor == null) {
					return;
				}
				var boxShadowBlurRadius = element.getAttribute("HYPE_BoxShadowBlurRadius");
				if(boxShadowBlurRadius == null) {
					return;
				}
				
				var xOffset = parseFloat(boxShadowXOffset);
				var yOffset = parseFloat(boxShadowYOffset);

				// remove it so that IE can properly rotate
				if(xOffset == 0 && yOffset == 0 && parseFloat(boxShadowBlurRadius) == 0) {
					if(element.style.removeAttribute) { // IE 6-8 does not have css.removeProperty, but removeAttribute will work
						element.style.removeAttribute("-webkit-box-shadow");
						element.style.removeAttribute("MozBoxShadow");
						element.style.removeAttribute("boxShadow");
						element.style.removeAttribute("box-shadow");
					} else {
						element.style.removeProperty("-webkit-box-shadow");
						element.style.removeProperty("MozBoxShadow");
						element.style.removeProperty("boxShadow");
						element.style.removeProperty("box-shadow");					
					}
					return;
				}
				
				// webkit
				element.style["-webkit-box-shadow"] = "" + xOffset + "px " + yOffset + "px " + boxShadowBlurRadius + " " + boxShadowShadowColor;
				
				// mozilla
				element.style["MozBoxShadow"] = "" + xOffset + "px " + yOffset + "px " + boxShadowBlurRadius + " " + boxShadowShadowColor;
				
				// firefox 4.0
				element.style["boxShadow"] = "" + xOffset + "px " + yOffset + "px " + boxShadowBlurRadius + " " + boxShadowShadowColor;
				
				// ie
				element.style["box-shadow"] = "" + xOffset + "px " + yOffset + "px " + boxShadowBlurRadius + " " + boxShadowShadowColor;
			},


			TextShadowXOffset : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_TextShadowXOffset", value);
				hypeDoc.Apply.TextShadow(element);
			},

			TextShadowYOffset : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_TextShadowYOffset", value);
				hypeDoc.Apply.TextShadow(element);
			},
			
			TextShadowColor : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_TextShadowColor", value);
				hypeDoc.Apply.TextShadow(element);
			},
			
			TextShadowBlurRadius : function (hypeDoc, value, element) {
				element.setAttribute("HYPE_TextShadowBlurRadius", value);
				hypeDoc.Apply.TextShadow(element);
			},
			
			TextShadow : function (element) {
				var textShadowXOffset = element.getAttribute("HYPE_TextShadowXOffset");
				if(textShadowXOffset == null) {
					return;
				}
				var textShadowYOffset = element.getAttribute("HYPE_TextShadowYOffset");
				if(textShadowYOffset == null) {
					return;
				}
				var textShadowShadowColor = element.getAttribute("HYPE_TextShadowColor");
				if(textShadowShadowColor == null) {
					return;
				}
				var textShadowBlurRadius = element.getAttribute("HYPE_TextShadowBlurRadius");
				if(textShadowBlurRadius == null) {
					return;
				}
				
				var xOffset = parseFloat(textShadowXOffset);
				var yOffset = parseFloat(textShadowYOffset);

				element.style.textShadow = "" + xOffset + "px " + yOffset + "px " + textShadowBlurRadius + " " + textShadowShadowColor;
			},

			WordWrap : function (hypeDoc, value, element) {
				element.style.wordWrap = value;
			},
				 
			WhiteSpaceCollapsing : function (hypeDoc, value, element) {
				element.style.whiteSpaceCollapsing = value;
			},
				 
			ZIndex : function (hypeDoc, value, element) {
				element.style.zIndex = value;
			},

			CreateActionHandler : function (hypeDoc, value, element) {
				return function(e) {				
					var type = value["type"];
					if(type == hypeDoc.kActionJumpToScene) {
						var sceneSymbol = value["sceneSymbol"];
						var transition = value["transition"];
						if(sceneSymbol == null || sceneSymbol == hypeDoc.kJumpToSceneOther) {
							var sceneIndex = hypeDoc.indexOfSceneWithIdentifier(value["sceneOid"]);
							hypeDoc.showScene(sceneIndex, transition);
						} else if(sceneSymbol == hypeDoc.kJumpToSceneNext) {
							hypeDoc.showNextScene(transition);
						} else if(sceneSymbol == hypeDoc.kJumpToScenePrevious) {
							hypeDoc.showPreviousScene(transition);
						} else if(sceneSymbol == hypeDoc.kJumpToSceneFirst) {
							hypeDoc.showScene(0, transition);
						} else if(sceneSymbol == hypeDoc.kJumpToSceneLast) {
							hypeDoc.showScene(hypeDoc.scenes.length - 1, transition);
						}
					}/* else if(type == kActionPresentMedia) {
						
					}*/ else if(type == hypeDoc.kActionPlayTimeline) {
						if(value["timelineIdentifier"] != null) {
							hypeDoc.startTimelineRun(value["timelineIdentifier"], (element != null ? element.id : null));
						}
					} else if(type == hypeDoc.kActionRunJavascript) {
						var functionName = hypeDoc.javascriptMapping[value["javascriptOid"]];
						hypeDoc.Custom[functionName](hypeDoc.API, element);
					} else if(type == hypeDoc.kActionVisitURL) {
						var url = value["goToURL"];
						if(url != null) {						
							var openInNewWindow = value["openInNewWindow"];
							if(openInNewWindow == true) {
								window.open(url);
							} else {
								document.location = url;
							}
						}
					}
				};
			},

			ActionOnMouseClick : function (hypeDoc, value, element) {
				hypeDoc.addActionHandler("onclick", element, hypeDoc.Apply.CreateActionHandler(hypeDoc, value, element));
			},
			
			ActionOnMouseOver : function (hypeDoc, value, element) {
				hypeDoc.addActionHandler("onmouseover", element, hypeDoc.Apply.CreateActionHandler(hypeDoc, value, element));
			},
			
			ActionOnMouseOut : function (hypeDoc, value, element) {
				hypeDoc.addActionHandler("onmouseout", element, hypeDoc.Apply.CreateActionHandler(hypeDoc, value, element));
			},

			ActionOnMouseUp : function (hypeDoc, value, element) {
				hypeDoc.addActionHandler("onmouseup", element, hypeDoc.Apply.CreateActionHandler(hypeDoc, value, element));
			},

			ActionOnMouseDown : function (hypeDoc, value, element) {
				hypeDoc.addActionHandler("onmousedown", element, hypeDoc.Apply.CreateActionHandler(hypeDoc, value, element));
			},
			
			CreateButtonHandler : function (hypeDoc, value, element) {
				return function(e) {
					hypeDoc.applyButtonFromTimelineRun(e, value, element.id);
				};
			},
			
			CreateButtonResetHandler : function (hypeDoc, value, element) {
				return function(e) {
					hypeDoc.resetButtonFromTimelineRun(e, value, element.id);
				};
			},
			
			ButtonHover : function (hypeDoc, value, element) {
				hypeDoc.addActionHandler("onmouseover", element, hypeDoc.Apply.CreateButtonHandler(hypeDoc, value, element));
				hypeDoc.addActionHandler("onmouseout", element, hypeDoc.Apply.CreateButtonResetHandler(hypeDoc, value, element));
			},
			
			ButtonPress : function (hypeDoc, value, element) {
				hypeDoc.addActionHandler("onmousedown", element, hypeDoc.Apply.CreateButtonHandler(hypeDoc, value, element));
				hypeDoc.addActionHandler("onmouseup", element, hypeDoc.Apply.CreateButtonResetHandler(hypeDoc, value, element));
			},

			InnerHTML : function (hypeDoc, value, element) {
				var img = document.getElementById("img_" + element.id);
				var imgClone = (img != null) ? img.cloneNode(true) : null;			
				element.innerHTML = value;				
				if(imgClone != null) {
					element.appendChild(imgClone);
				}
			},
			
			TagName : function (hypeDoc, value, element) {
				// can't change this after the fact!
			}
			
		});


	
	///////////////////////////////////////////////////////////////
	// exported (public) interfaces
	
	this.API = {};
	var _internal = this;
		
	this.API.kSceneTransitionInstant = this.kSceneTransitionInstant;
	this.API.kSceneTransitionCrossfade = this.kSceneTransitionCrossfade;
	this.API.kSceneTransitionSwap = this.kSceneTransitionSwap;
	this.API.kSceneTransitionPushLeftToRight = this.kSceneTransitionPushLeftToRight;
	this.API.kSceneTransitionPushRightToLeft = this.kSceneTransitionPushLeftToRight;
	this.API.kSceneTransitionPushBottomToTop = this.kSceneTransitionPushBottomToTop;
	this.API.kSceneTransitionPushTopToBottom = this.kSceneTransitionPushTopToBottom;
	
	this.API.documentName = function () {
		return _internal.documentName;
	}
	
	this.API.sceneNames = function () {
		return _internal.sceneNames();
	}
	
	this.API.currentSceneName = function () {
		return _internal.currentSceneName();
	}
	
	this.API.showSceneNamed = function (sceneName, optionalTransition) {
		_internal.showSceneNamed(sceneName, optionalTransition);
	}
	
	this.API.showNextScene = function (optionalTransition) {
		_internal.showNextScene(optionalTransition);
	}
	
	this.API.showPreviousScene = function (optionalTransition) {
		_internal.showPreviousScene(optionalTransition);
	}
	
	this.API.playTimelineNamed = function(timelineName) {
		_internal.playTimelineNamed(timelineName);
	}

});

HYPE.documents = {};

for(var HYPE_DocumentLoadIndex = 0; HYPE_DocumentLoadIndex < window.HYPE_DocumentsToLoad.length; HYPE_DocumentLoadIndex++) {
	window.HYPE_DocumentsToLoad[0]();
	window.HYPE_DocumentsToLoad.splice(0,1);
}
