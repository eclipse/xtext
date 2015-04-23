/*******************************************************************************
 * @license
 * Copyright (c) 2010, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/*eslint-env browser, amd, node*/
define("orion/editor/tooltip", [ //$NON-NLS-0$
	'i18n!orion/editor/nls/messages', //$NON-NLS-0$
	'orion/editor/textView', //$NON-NLS-0$
	'orion/editor/projectionTextModel', //$NON-NLS-0$
	'orion/Deferred', //$NON-NLS-0$
	'orion/editor/util', //$NON-NLS-0$
	'orion/PageLinks', //$NON-NLS-0$
	'orion/URITemplate', //$NON-NLS-0$
	'orion/webui/littlelib', //$NON-NLS-0$
	'orion/util' //$NON-NLS-0$
], function(messages, mTextView, mProjectionTextModel, Deferred, textUtil, PageLinks, URITemplate, lib, util) {

	/** @private */
	function Tooltip (view) {
		this._view = view;
		var parent = view.getOptions("parent"); //$NON-NLS-0$
		this._create(parent ? parent.ownerDocument : document);
	}
	Tooltip.getTooltip = function(view) {
		if (!view._tooltip) {
			 view._tooltip = new Tooltip(view);
		}
		return view._tooltip;
	};
	Tooltip.prototype = /** @lends orion.editor.Tooltip.prototype */ {
		_create: function(document) {
			if (this._tooltipDiv) { return; }
			var tooltipDiv = this._tooltipDiv = util.createElement(document, "div"); //$NON-NLS-0$
			tooltipDiv.tabIndex = 0;
			tooltipDiv.className = "textviewTooltip"; //$NON-NLS-0$
			tooltipDiv.setAttribute("aria-live", "assertive"); //$NON-NLS-1$ //$NON-NLS-0$
			tooltipDiv.setAttribute("aria-atomic", "true"); //$NON-NLS-1$ //$NON-NLS-0$
			this._tooltipDiv.style.visibility = "hidden"; //$NON-NLS-0$
			var tooltipContents = this._tooltipContents = util.createElement(document, "div"); //$NON-NLS-0$
			tooltipDiv.appendChild(tooltipContents);
			document.body.appendChild(tooltipDiv);
			var self = this;
			textUtil.addEventListener(document, "mousedown", this._mouseDownHandler = function(event) { //$NON-NLS-0$
				if (!self.isVisible()) { return; }
				if (textUtil.contains(tooltipDiv, event.target || event.srcElement)) { return; }
				self.hide();
			}, true);
			textUtil.addEventListener(document, "mousemove", this._mouseMoveHandler = function(event) { //$NON-NLS-0$
				if (!self.isVisible()) { return; }
				if (self.OKToHide(event.clientX, event.clientY)) {
					self.hide();
				}
			}, true);
			textUtil.addEventListener(tooltipDiv, "mouseover", /* @callback */ function(event) { //$NON-NLS-0$
				self._inTooltip = true;
			}, false);
			textUtil.addEventListener(tooltipDiv, "mouseout", /* @callback */ function(event) { //$NON-NLS-0$
				self._inTooltip = false;
			}, false);
			textUtil.addEventListener(tooltipDiv, "keydown", function(event) { //$NON-NLS-0$
				if (event.keyCode === 27) {
					self.hide();
				}
			}, false);
			this._view.addEventListener("Destroy", function() { //$NON-NLS-0$
				self.destroy();
			});
		},
		_getWindow: function() {
			var document = this._tooltipDiv.ownerDocument;
			return document.defaultView || document.parentWindow;
		},
		destroy: function() {
			if (!this._tooltipDiv) { return; }
			this.hide();
			var parent = this._tooltipDiv.parentNode;
			if (parent) { parent.removeChild(this._tooltipDiv); }
			var document = this._tooltipDiv.ownerDocument;
			textUtil.removeEventListener(document, "mousedown", this._mouseDownHandler, true); //$NON-NLS-0$
			textUtil.removeEventListener(document, "mousemove", this._mouseMoveHandler, true); //$NON-NLS-0$
			this._tooltipDiv = null;
		},
		_hasFocus: function() {
			var tooltipDiv = this._tooltipDiv;
			if (!tooltipDiv) { return false; }
			var document = tooltipDiv.ownerDocument;
			return textUtil.contains(tooltipDiv, document.activeElement);
		},
		_setContentRange: function(start, end) {
			this._contentRangeStart = start;
			this._contentRangeEnd = end;
			var tv = this._view;
			var curLine = tv.getLineAtOffset(start);
			var endLine = tv.getLineAtOffset(end);
			
			// Adjust start / end to be on the current line if necessary
			if (curLine !== endLine) {
				start = tv.getLineStart(curLine);
				// 'getLineEnd' isn't API in textView but is in textModel...
				end = tv.getModel().getLineEnd(curLine);
			}
			
			var height = tv.getLineHeight(curLine);
			var startPos = tv.getLocationAtOffset(start);
			var endPos = tv.getLocationAtOffset(end);
			
			var viewRect = { x: startPos.x, y: startPos.y, 
								width: endPos.x - startPos.x, height: height};
								
			viewRect = this._view.convert(viewRect, "document", "page"); //$NON-NLS-0$ //$NON-NLS-1$
			this._hoverArea = {left: viewRect.x, top: viewRect.y, 
								width: viewRect.width, height: viewRect.height};
		},
		_isInRect: function(rect, x, y) {
			if (!rect){
				return false;
			}
			var xOK = x >= rect.left && x <= (rect.left + rect.width);
			var yOK = y >= rect.top && y <= (rect.top + rect.height);
			return xOK && yOK;
		},
		/**
		 * @name hide
		 * @description Hides the current hover popup
		 * @function
		 * @public
		 * @param {int} hideDelay Delay the hide by this many millisecs (defaults to the 'hideDelay' field
		 * of this tooltip)
		*/
		hide: function() {
			if (!this.isVisible()) { return; }
			
			if (this.hover) {
				this.hover.clearQuickFixes();
			}

			if (this._hasFocus()) {
				this._view.focus();
			}
			if (this._contentsView) {
				this._contentsView.destroy();
				this._contentsView = null;
			}
			if (this._tooltipContents) {
				this._tooltipContents.innerHTML = "";
			}
			this._tooltipDiv.style.visibility = "hidden"; //$NON-NLS-0$
			this._tooltipDiv.style.left = "auto"; //$NON-NLS-0$
			this._tooltipDiv.style.right = "auto";		 //$NON-NLS-0$	
			this._tooltipDiv.style.top = "auto";	 //$NON-NLS-0$		
			this._tooltipDiv.style.bottom = "auto";		 //$NON-NLS-0$	
			this._tooltipDiv.style.width = "auto";		 //$NON-NLS-0$	
			this._tooltipDiv.style.height = "auto";		 //$NON-NLS-0$	
			
			// cancel any outstanding defers
			if (this._hoverInfo) {
				this._hoverInfo.forEach(function(info) {
					info.cancel();
				});
			}

			// Values that can be overridden by returned info			
			this._target = undefined;
			this._offsetX = undefined;
			this._offsetY = undefined;
			this._position = undefined;
			this._hoverArea = undefined;
			this._preventTooltipClose = undefined;

			// vlaues that are calculated
			this._hoverInfo = undefined;
			this._hoverRect = undefined;
			this._tipRect = undefined;
		},
		/**
		 * @name isVisible
		 * @description Returns a boolean indicating whether the tooltip is currently visible
		 * @function
		 * @public
		 * @returns {boolean} 'true' iff the tooltip is currently visible
		*/
		isVisible: function() {
			return this._tooltipDiv && this._tooltipDiv.style.visibility === "visible"; //$NON-NLS-0$
		},
		/**
		 * @name OKToHover
		 * @description Returns whether a new hover can be opened in the editor.  New hovers
		 * may be prevented from opening because an existing hover has focus or is otherwise unready
		 * to be closed. Provide x,y coordinates to check if that location is within the bounding rectangle
		 * around the tooltip.
		 * @function
		 * @param x Location to check if within bounds, usually a cursor location
		 * @param y Location to check if within bounds, usually a cursor location
		 * @returns {Boolean} returns whether a new hover can be opened in the editor
		 */
		OKToHover: function(x, y) {
			if (!this.isVisible()){
				return true;
			}
			if (this._preventTooltipClose && this._preventTooltipClose()){
				return false;
			}
			if (this._hasFocus()){
				return false;
			}
			return !this._isInRect(this._hoverArea, x, y);
		},
		/**
		 * @name OKToHide
		 * @description Returns whether an existing hover should be hidden or if it should stay open.
		 * A hover may stay open if it has focus or the user's mouse x and y coordinates are within the bounding
		 * rectangle around the tooltip.
		 * @function
		 * @param x Location to check if within bounds, usually a cursor location
		 * @param y Location to check if within bounds, usually a cursor location
		 * @returns {Boolean} returns whether the existing hover should be closed
		 */
		OKToHide: function(x, y) {
			if (!this.isVisible()){
				return false;
			}
			if (this._preventTooltipClose && this._preventTooltipClose()){
				return false;
			}
			if (this._hasFocus()){
				return false;
			}
			return !this._isInRect(this._hoverRect, x, y);
		},
		/**
		 * @name show
		 * @description Show the tooltip using the current target
		 * @function
		 * @public
		 * @param {boolean} autoHide If 'true' then the tooltip will call 'hide' once the 'hideDelay'
		 * timer expires. if 'false' then the tooltip will remain visible until dismissed by the User.
		 *
		 * Note that if 'autoHide' is false then the tooltip will attempt to set the focus onto the
		 * resulting tooltip.
		*/
		show: function(target, giveFocus) {
			if (!target) {
				return;
			}
			
			var tooltipDiv = this._tooltipDiv;
			var tooltipContents = this._tooltipContents;
			if (!tooltipDiv || !tooltipContents){
				return;
			}
			
			// Don't process if we're in the hoverArea or tip rects
			if (this._isInRect(this._hoverArea, target.clientX, target.clientY)
					|| this._isInRect(this._tipRect, target.clientX, target.clientY)) {
				return;
			}
			
			var info = target.getTooltipInfo();

			if (!info) {
				return;
			}
			
			if (this.isVisible()) {
				this.hide();
			}
			
			// Capture optional positioning
			this._position = info.position;
			this._hoverArea = info.hoverArea;
			this._offsetX = info.offsetX;
			this._offsetY = info.offsetY;
			
			this._target = target;
			
			tooltipDiv.style.left = tooltipDiv.style.right = tooltipDiv.style.width = tooltipDiv.style.height = 
				tooltipContents.style.width = tooltipContents.style.height = "auto"; //$NON-NLS-0$
			var tooltipDoc = tooltipDiv.ownerDocument;
			var documentElement = tooltipDoc.documentElement;
			
			var contents = info.contents;
			if (contents instanceof Array) {
				contents = this._getAnnotationContents(contents, info.context);			
			}
			
			if (this.hover && info.offset !== undefined && !contents) {
				var context = Object.create(null); 
				if (info.context){
					context = info.context;
				}
				context.offset = info.offset;
				this._hoverInfo = this.hover.computeHoverInfo(context);
			}
			
			if (typeof contents === "string") { //$NON-NLS-0$
				tooltipContents.innerHTML = contents;
			} else if (this._isNode(contents)) {
				tooltipContents.appendChild(contents);
			} else if (contents instanceof mProjectionTextModel.ProjectionTextModel) {
				this._offsetX = -1;  // re-position to match the visible comment
				this._offsetY = -3;  // re-position to match the visible comment
				
				var view = this._view;
				var options = view.getOptions();
				options.wrapMode = false;
				options.parent = tooltipContents;
				var tooltipTheme = "tooltipTheme"; //$NON-NLS-0$
				var theme = options.themeClass;
				if (theme) {
					theme = theme.replace(tooltipTheme, "");
					if (theme) { theme = " " + theme; } //$NON-NLS-0$
					theme = tooltipTheme + theme;
				} else {
					theme = tooltipTheme;
				}
				options.themeClass = theme;
				var contentsView = this._contentsView = new mTextView.TextView(options);
				//TODO need to find a better way of sharing the styler for multiple views
				var listener = {
					onLineStyle: function(e) {
						view.onLineStyle(e);
					}
				};
				contentsView.addEventListener("LineStyle", listener.onLineStyle); //$NON-NLS-0$
				contentsView.setModel(contents);
				var size = contentsView.computeSize();
				tooltipContents.style.width = size.width + "px"; //$NON-NLS-0$
				tooltipContents.style.height = size.height + "px"; //$NON-NLS-0$
				contentsView.resize();
			} else if (!(this._hoverInfo && this._hoverInfo.length)) {
				return;
			}
			
			if (info.width) {
				tooltipDiv.style.width = info.width + "px"; //$NON-NLS-0$
			}
			if (info.height) {
				tooltipDiv.style.height = info.height + "px"; //$NON-NLS-0$
				tooltipDiv.style.overflowY = "auto"; //$NON-NLS-0$
			}
			
			var top = parseInt(this._getNodeStyle(tooltipDiv, "padding-top", "0"), 10); //$NON-NLS-1$ //$NON-NLS-0$
			top += parseInt(this._getNodeStyle(tooltipDiv, "border-top-width", "0"), 10); //$NON-NLS-1$ //$NON-NLS-0$
			top = info.y - top;
			tooltipDiv.style.top = top + "px"; //$NON-NLS-0$
			tooltipDiv.style.maxHeight = (documentElement.clientHeight - top - 10) + "px"; //$NON-NLS-0$
			tooltipDiv.style.opacity = "1"; //$NON-NLS-0$
			
			if (info.preventTooltipClose){
				this._preventTooltipClose = info.preventTooltipClose;
			}
			
			var self = this;
			if (this._hoverInfo) {
				this._hoverInfo.forEach(function(info) {
					Deferred.when(info, function (data) {
						if (data) {
							if (self._renderContent(tooltipDoc, tooltipContents, data)) {
								self._showTooltip(giveFocus, tooltipDiv);
							
								// Adjust the hoverRect to match the new content
								var divBounds = lib.bounds(tooltipDiv);
								self._setHoverRect(self._hoverArea, divBounds);
							}
						}
					}, function(error) {
						if (typeof console !== "undefined") { //$NON-NLS-0$
							console.log("Error computing hover tooltip"); //$NON-NLS-0$
							console.log(error && error.stack);
						}
					});
				});
			}
			
			// Delay the showing of a tootip with no 'static' contents
			if (contents) {
				this._showTooltip(giveFocus, tooltipDiv);
			}
		},
		_showTooltip: function(giveFocus, tooltipDiv) {
			if (this.isVisible()){
				return;
			}

			// HACK! Fake a contentBox if necessary
			if (!this._hoverArea) {
				// Use the whole line
				var curOffset = this._view.getOffsetAtLocation(this._target.x, this._target.y);
				if (curOffset >= 0) {
					var start = this._view.getNextOffset(curOffset, 
										{ unit: "word", count: -1}); //$NON-NLS-0$
					var end = this._view.getNextOffset(curOffset, 
										{ unit: "word", count: 0}); //$NON-NLS-0$
					this._setContentRange(start, end);
				} else {
					this._hoverArea = {
						left: this._target.clientX-8, top: this._target.clientY -8,
						width: 16, height: 16
					};
				}
			}
			
			// Align the tooltip with the hover area
			var tipDiv = this._tooltipDiv;
			var divBounds = lib.bounds(tipDiv);
			if (!this._position) { this._position = "below"; } //$NON-NLS-0$
			if (!this._offsetX) { this._offsetX = 0; }
			if (!this._offsetY) { this._offsetY = 0; }

			var tipRect = {
				width: divBounds.width,
				height: divBounds.height
			};	
			switch (this._position) {
				case "left": //$NON-NLS-0$
					tipRect.left = this._hoverArea.left - (divBounds.width + this._offsetX);
					tipRect.top = this._hoverArea.top + this._offsetY;
				break;
				case "right": //$NON-NLS-0$
					tipRect.left = (this._hoverArea.left + this._hoverArea.width) + this._offsetX;
					tipRect.top = this._hoverArea.top + this._offsetY;
				break;
				case "above": //$NON-NLS-0$
					tipRect.left = this._hoverArea.left + this._offsetX;
					tipRect.top = this._hoverArea.top - (divBounds.height + this._offsetY);
				break;
				case "below": //$NON-NLS-0$
					tipRect.left = this._hoverArea.left + this._offsetX;
					tipRect.top = (this._hoverArea.top + this._hoverArea.height) + this._offsetY;
				break;
			}

			tipDiv.style.left = tipRect.left + "px"; //$NON-NLS-0$
			tipDiv.style.top = tipRect.top + "px"; //$NON-NLS-0$

			this._setHoverRect(this._hoverArea, tipRect);
			
			this._tooltipDiv.style.visibility = "visible"; //$NON-NLS-0$

			if (giveFocus === true) {
				this._setInitialFocus(tooltipDiv);
			}
		},
		_setHoverRect: function(hoverArea, tipRect) {
			var left = Math.min(hoverArea.left, tipRect.left);
			var top = Math.min(hoverArea.top, tipRect.top);
			var positionRight = hoverArea.left + hoverArea.width;
			var tipRight = tipRect.left + tipRect.width;
			var right = Math.max(positionRight, tipRight);
			var positionBottom = hoverArea.top + hoverArea.height;
			var tipBottom = tipRect.top + tipRect.height;
			var bottom = Math.max(positionBottom, tipBottom);
			
			this._tipRect = tipRect;
			this._hoverRect = {
				left: left,
				top : top,
				width: right - left,
				height: bottom - top
			};
		},
		_setInitialFocus: function(tooltipDiv) {
			// Any buttons ?
			var button = lib.$("button", tooltipDiv); //$NON-NLS-0$
			if (button) {
				button.focus();
				return;
			}
			// Any links ?
			var link = lib.$("a", tooltipDiv); //$NON-NLS-0$
			if (link) {
				link.focus();
				var self = this;
				link.addEventListener("click", function() { //$NON-NLS-0$
					self.hide();
				});
				return;
			}
			// Give up and focus on the first tabbable
			var toFocus = lib.firstTabbable(tooltipDiv);
			if (toFocus) {
				toFocus.focus();
			}
		},
		_renderContent: function(tooltipDoc, tooltipContents, data) {
			if (typeof data.content === 'undefined' && typeof data.uriTemplate === 'undefined') { //$NON-NLS-0$ //$NON-NLS-1$
			    return false;
			}
			var sectionDiv = util.createElement(tooltipDoc, "div"); //$NON-NLS-0$;
			// render the title, if any
			if (data.title) {
				var titleDiv = util.createElement(tooltipDoc, "div"); //$NON-NLS-0$;
				titleDiv.innerHTML = this.hover.renderMarkDown ? this.hover.renderMarkDown(data.title) : data.title;
				sectionDiv.appendChild(titleDiv);
			}
			var contentDiv = util.createElement(tooltipDoc, "div"); //$NON-NLS-0$
			switch(data.type) { //$NON-NLS-0$
				case 'delegatedUI': { //$NON-NLS-0$
					// The delegated UI is not included in the 8.0 release, see Bug 449240.
				}
				case 'html': { //$NON-NLS-0$
					if (data.content){
						var iframe = document.createElement("iframe"); //$NON-NLS-0$
						iframe.id = 'HtmlHover'; //$NON-NLS-0$
						iframe.name = 'HTML Hover'; //$NON-NLS-0$
						iframe.type = "text/html"; //$NON-NLS-0$
						iframe.sandbox = "allow-scripts allow-same-origin allow-forms"; //$NON-NLS-0$
						iframe.style.border = "none"; //$NON-NLS-0$
						iframe.style.width = "auto"; //$NON-NLS-0$
						iframe.style.height = "auto"; //$NON-NLS-0$
						iframe.srcdoc = data.content;
						if (data.width) {
							iframe.style.width = data.width;
						}
						if (data.height) {
							iframe.style.height = data.height;
						}
						sectionDiv.appendChild(iframe);
					}
					break;
				}
				case 'markdown': { //$NON-NLS-0$
					if (this.hover.renderMarkDown) {
						contentDiv.innerHTML = this.hover.renderMarkDown(data.content);
					}
					break;
				}
				default: {
					contentDiv.appendChild(tooltipDoc.createTextNode(data.content));
				}
			}
			sectionDiv.appendChild(contentDiv);
			tooltipContents.appendChild(sectionDiv);
			return true;
		},
		
		/**
		 * @name _getAnnotationContents
		 * @description Takes a list of annotation and renders them in the tooltip
		 * @function
		 * @private
		 * @param annotations the list of annotations to render
		 * @param context optional object containing context information, such as where the annotations are displayed (ruler, editor, etc.)
		 * @returns returns document node containing rendered tooltip content
		 */
		_getAnnotationContents: function(annotations, context) {
			var annotation;
			var newAnnotations = [];
			for (var j = 0; j < annotations.length; j++) {
				annotation = annotations[j];
				if (annotation.title !== "" && !annotation.groupAnnotation) { 
					newAnnotations.push(annotation); 
				}
			}
			annotations = newAnnotations;
			if (annotations.length === 0) {
				return null;
			}
			var self = this;
			var html;
			var document = this._tooltipDiv.ownerDocument;
			var view = this._view;
			var model = view.getModel();
			var baseModel = model.getBaseModel ? model.getBaseModel() : model;
			function getText(start, end) {
				var textStart = baseModel.getLineStart(baseModel.getLineAtOffset(start));
				var textEnd = baseModel.getLineEnd(baseModel.getLineAtOffset(end), true);
				return baseModel.getText(textStart, textEnd);
			}
			function getAnnotationHTML(annotation, showQuickfixes) {
				var title = annotation.title;
				var result = util.createElement(document, "div"); //$NON-NLS-0$
				result.className = "tooltipRow"; //$NON-NLS-0$
				if (annotation.html) {
					var htmlHolder = util.createElement(document, "div"); //$NON-NLS-0$
					htmlHolder.className = "tooltipImage"; //$NON-NLS-0$
					htmlHolder.innerHTML = annotation.html;
					if (htmlHolder.lastChild) {
						textUtil.addEventListener(htmlHolder.lastChild, "click", function() { //$NON-NLS-0$
							var start = annotation.start, end = annotation.end;
							if (model.getBaseModel) {
								start = model.mapOffset(start, true);
								end = model.mapOffset(end, true);
							}
							view.setSelection(start, end, 1 / 3, function() { self.hide(); });
						}, false);
					}
					result.appendChild(htmlHolder); //$NON-NLS-0$
				}
				if (!title) {
					title = getText(annotation.start, annotation.end);
				}
				if (typeof title === "function") { //$NON-NLS-0$
					title = annotation.title();
				}
				if (typeof title === "string") { //$NON-NLS-0$
					var span = util.createElement(document, "span"); //$NON-NLS-0$
					span.className = "tooltipTitle"; //$NON-NLS-0$
					span.appendChild(document.createTextNode(title));
					title = span;
				}
				result.appendChild(title);
				
				// Handle quick fixes
				if (showQuickfixes) {
					self.hover.renderQuickFixes(annotation, result);
				}
				
				// Set the hover area to the annotation if it's not already set
				if (!self._hoverArea) {
					self._setContentRange(annotation.start, annotation.end);
				}
				return result;
			}
			
			// Don't show quickfixes for ruler annotations (left or right side)
			var showQuickfixes = self.hover ? true : false;
			if (showQuickfixes && context && context.source && context.source.indexOf('ruler') >= 0){ //$NON-NLS-0$
				showQuickfixes = false;
			}			
			
			if (annotations.length === 1) {
				annotation = annotations[0];
				if (annotation.title !== undefined) {
					html = getAnnotationHTML(annotation, showQuickfixes);
					if (html.firstChild) {
						var className = html.firstChild.className;
						if (className) { className += " "; } //$NON-NLS-0$
						className += "single"; //$NON-NLS-0$
						html.firstChild.className = className;
					}
					return html;
				} else {
					// Don't create a projection model if we are in the editor it will just duplicate the content the user is looking at
					if (context && context.source && context.source === 'editor'){ //$NON-NLS-0$
						return null;
					}
					var newModel = new mProjectionTextModel.ProjectionTextModel(baseModel);
					var lineStart = baseModel.getLineStart(baseModel.getLineAtOffset(annotation.start));
					var charCount = baseModel.getCharCount();
					if (annotation.end !== charCount) {
						newModel.addProjection({start: annotation.end, end: charCount});
					}
					if (lineStart > 0) {
						newModel.addProjection({start: 0, end: lineStart});
					}
					return newModel;
				}
			} else {
				var tooltipHTML = util.createElement(document, "div"); //$NON-NLS-0$
				var em = util.createElement(document, "em"); //$NON-NLS-0$
				em.appendChild(document.createTextNode(messages.multipleAnnotations));
				tooltipHTML.appendChild(em);
				for (var i = 0; i < annotations.length; i++) {
					annotation = annotations[i];
					html = getAnnotationHTML(annotation, showQuickfixes);
					if (html) {
						tooltipHTML.appendChild(html);
					}
				}
				return tooltipHTML;
			}
		},

		_getNodeStyle: function(node, prop, defaultValue) {
			return textUtil.getNodeStyle(node, prop, defaultValue);
		},
		_isNode: function (obj) {
			return typeof Node === "object" ? obj instanceof Node : //$NON-NLS-0$
				obj && typeof obj === "object" && typeof obj.nodeType === "number" && typeof obj.nodeName === "string"; //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		}
	};
	return {Tooltip: Tooltip};
});
