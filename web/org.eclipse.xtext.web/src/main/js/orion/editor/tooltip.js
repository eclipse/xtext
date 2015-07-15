/*******************************************************************************
 * @license
 * Copyright (c) 2010, 2015 IBM Corporation and others.
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
	'orion/webui/littlelib', //$NON-NLS-0$
	'orion/util' //$NON-NLS-0$
], function(messages, mTextView, mProjectionTextModel, Deferred, textUtil, lib, util) {

/**
 * @name Tooltip
 * @description Tooltip support for text views
 * 
 * show() - Opens the tooltip
 * update() - Updates the content of the open tooltip
 * onHover() - Checks if the x,y coordinates are outside the current tooltip area and updates the tooltip if necessary
 * hide() - Closes the tooltip
 * isVisible() - Returns whether the tooltip is currently showing
 * 
 * The methods above ask for a tooltipInfo object, which must contain a callback function getTooltipInfo()
 * This function must return an info object with the following contents:
 * 
 * Info {
 * 	Contents {string, html element, annotation array, etc.} Contents to display, if undefined, the hover service will be asked for content
 * 	Context {source, offset, offsetStart, offsetEnd}} Information used to modify the tooltip position or contents
 * 	Position {String} One of left, right, top, bottom used to position the tooltip relative to the anchor area
 * 	AnchorArea {x, y, width, height} rectangle defining the source of the tooltip and where to position relative to
 * 	TooltipArea {x, y, width, height} rectangle to define the tooltip's exact placement rather than a relative position to the anchor
 * 	TooltipOffsetX {Number} Hint to move the tooltip position horizontally
 * 	TooltipOffsetY {Number} Hint to move the tooltip position vertically
 * 
 * @param view
 */
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
			document.body.appendChild(tooltipDiv);
			var self = this;
			textUtil.addEventListener(document, "mousedown", this._mouseDownHandler = function(event) { //$NON-NLS-0$
				if (!self.isVisible()) { return; }
				if (textUtil.contains(tooltipDiv, event.target || event.srcElement)) { return; }
				if (!self._locked){
					self.hide();
				}
			}, true);
			textUtil.addEventListener(document, "mousemove", this._mouseMoveHandler = function(event) { //$NON-NLS-0$
				if (!self.isVisible() || self._locked || self._hasFocus()) { return; }
				if (self._isInRect(self._outerArea, event.clientX, event.clientY)){ return; }
				self.hide();
			}, true);
			textUtil.addEventListener(tooltipDiv, "focus", /* @callback */ function(event) { //$NON-NLS-0$
				if (!self._locked){
					self._tooltipDiv.classList.add('textViewTooltipOnFocus'); //$NON-NLS-0$
				}
			}, false);
			textUtil.addEventListener(tooltipDiv, "blur", /* @callback */ function(event) { //$NON-NLS-0$
				self._tooltipDiv.classList.remove('textViewTooltipOnFocus'); //$NON-NLS-0$
			}, false);
			textUtil.addEventListener(tooltipDiv, "mouseenter", /* @callback */ function(event) { //$NON-NLS-0$
				if (!self._locked){
					self._tooltipDiv.classList.add('textViewTooltipOnHover'); //$NON-NLS-0$
				}
			}, false);
			textUtil.addEventListener(tooltipDiv, "mouseleave", /* @callback */ function(event) { //$NON-NLS-0$
				if (!self._hasFocus()){
					self._tooltipDiv.classList.remove('textViewTooltipOnHover'); //$NON-NLS-0$
				}
			}, false);
			textUtil.addEventListener(tooltipDiv, "keydown", function(event) { //$NON-NLS-0$
				if (event.keyCode === 27) {
					if (!self._locked){
						self.hide();
					}
				}
			}, false);
			this._view.addEventListener("Destroy", function() { //$NON-NLS-0$
				self.destroy();
			});
		},
		destroy: function() {
			if (!this._tooltipDiv) { return; }
			this.hide();
			var parent = this._tooltipDiv.parentNode;
			if (parent) { parent.removeChild(this._tooltipDiv); }
			var doc = this._tooltipDiv.ownerDocument;
			textUtil.removeEventListener(doc, "mousedown", this._mouseDownHandler, true); //$NON-NLS-0$
			textUtil.removeEventListener(doc, "mousemove", this._mouseMoveHandler, true); //$NON-NLS-0$
			this._tooltipDiv = null;
		},
		
		/**
		 * @name show
		 * @description Show the tooltip using the given target information
		 * @function
		 * @param target The target through which the info is obtained
		 * @param locked If true locks the tooltip (never hides unless 'hide' is called)
		 * @param giveFocus If true forces the focus onto the tooltip (used for F2 processing)
		 */
		show: function(tooltipInfo, locked, giveFocus) {
			this._locked = locked;
			this._giveFocus = giveFocus;
			this._processInfo(tooltipInfo.getTooltipInfo());
		},
		
		/**
		 * @name update
		 * @description Updates the information in an already visible tooltip
		 * @function
		 * @param target The target through which the info is obtained
		 * @param locked If true locks the tooltip (never hides unless 'hide' is called)
		 * @param giveFocus If true forces the focus onto the tooltip (used for F2 processing)
		 */
		update: function(tooltipInfo) {
			if (!tooltipInfo){
				return;
			}
			this._processInfo(tooltipInfo.getTooltipInfo(), true);
		},
		
		/**
		 * @name onHover
		 * @description Show the tooltip using the given target information. Only called for hover events.
		 * @function
		 * @param target
		 * @param giveFocus
		 */
		onHover: function(tooltipInfo, x, y) {
			if (!tooltipInfo) {
				return;
			}
			
			// Don't process if we're in the anchor or tooltip
			if (this._isInRect(this._anchorArea, x, y)
					|| this._isInRect(this._tooltipArea, x, y)
					|| this._locked
					|| this._hasFocus()) {
				return;
			}
			
			this._processInfo(tooltipInfo.getTooltipInfo());
		},		
	
		/**
		 * @name hide
		 * @description Hides the current tooltip (if it's showing)
		 * @function
		 * @public
		*/
		hide: function(clearLock) {
			if (clearLock) {
				this._locked = undefined;
			}
			if (!this.isVisible()){
				return;
			}
				
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
				this._tooltipDiv.removeChild(this._tooltipContents);
				this._tooltipContents = null;
			}
			
			// Code projections are displayed using the editor theme colors
			this._tooltipDiv.classList.remove("textviewTooltipCodeProjection"); //$NON-NLS-0$
			this._tooltipDiv.classList.remove("textviewTooltipOnHover"); //$NON-NLS-0$
			this._tooltipDiv.classList.remove("textviewTooltipOnFocus"); //$NON-NLS-0$
			
			this._tooltipDiv.style.visibility = "hidden"; //$NON-NLS-0$
			this._tooltipDiv.style.left = "";
			this._tooltipDiv.style.right = "";
			this._tooltipDiv.style.top = "";
			this._tooltipDiv.style.bottom = "";
			this._tooltipDiv.style.width = "auto";		 //$NON-NLS-0$
			this._tooltipDiv.style.maxWidth = "";
			this._tooltipDiv.style.height = "auto";		 //$NON-NLS-0$	
			this._tooltipDiv.style.maxHeight = "";		 //$NON-NLS-0$
			this._tooltipDiv.style.overflowX = "";		 //$NON-NLS-0$	
			this._tooltipDiv.style.overflowY = "";		 //$NON-NLS-0$	
			
			this._giveFocus = undefined;
			this._locked = undefined;
			
			this._anchorArea = undefined;  // Area of text/ruler/etc. we are showing a tooltip for
			this._tooltipArea = undefined;  // The area the tooltip covers
			this._outerArea = undefined; // The rectangle encapsulating both anchor and tooltip areas where we want to keep the tooltip open
			
			// cancel any outstanding defers
			if (this._hoverPromises) {
				this._hoverPromises.forEach(function(info) {
					if (!info.resolved) {
						info.cancel();
					}
				});
			}
			this._hoverPromises = undefined;
			
			// values that are calculated
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
		 * @name _processInfo
		 * @description Renders the content, positions the tooltip then makes the tooltip visible
		 * @function
		 * @private
		 * @param info {Object} The info object passed by the caller
		 * 
		 * Info:
		 * 1) Contents
		 * 2) Context
		 * 3) Position string left, right, top, bottom
		 * 4) AnchorArea x, y, width, height
		 * 5) TooltipArea x, y, width, height
		 * 6) TooltipOffsetX
		 * 7) TooltipOffsetY
		 * 8) AllowFullWidth
		 * 
		 * @param update Whether to update the existing tooltip contents or open a new tooltip
		 */
		_processInfo: function(info, update) {
			if (!this._tooltipDiv){
				return;
			}
			
			var newTooltipContents;
			if (update && this._tooltipContents) {
				this._tooltipContents.innerHTML = "";
				newTooltipContents = this._tooltipContents;
			} else {
 				newTooltipContents = util.createElement(this._tooltipDiv.ownerDocument, "div"); //$NON-NLS-0$
 			}
 			
			if (info) {
				// Render provided content
				if (info.contents) {
					if (this._renderImmediateInfo(newTooltipContents, info.contents, info.context)) {
						this._showContents(newTooltipContents, info, update);
						return true;
					}
				}
				
				// If no immediate content, check if hover service plug-ins have content
				if (this.hover && info.context){
					this._hoverPromises = this.hover.computeHoverInfo(info.context);
					if (this._hoverPromises) {
						var self = this;
						var promises = this._hoverPromises.slice(0);
						promises.forEach(function(hoverPromise) {
							Deferred.when(hoverPromise, function (data) {
								// Remove this promise from the list so we don't try cancelling it while processing (see hide())
								if (self._hoverPromises){
									var index = self._hoverPromises.indexOf(hoverPromise);
									if (index >= 0){
										self._hoverPromises.splice(index, 1);
									}
								}
								if (data) {
									if (self._renderPluginContent(newTooltipContents, data)) {
										if (data.offsetStart){
											info.context.offsetStart = data.offsetStart;
										}
										if (data.offsetEnd){
											info.context.offsetEnd = data.offsetEnd;
										}
										if (data.allowFullWidth){
											info.allowFullWidth = data.allowFullWidth;
										}
										self._showContents(newTooltipContents, info, update);
									}
								}
							}, function(error) {
								if (console && error && error.name !== 'Cancel') { //$NON-NLS-0$ //$NON-NLS-1$
									console.log("Error computing hover tooltip"); //$NON-NLS-0$
									console.log(error && error.stack);
								}
							});
						});
						return true;
					}
				}
			}
		},
		/**
		 * @name _showContents
		 * @description Takes the rendered contents, positions the tooltip, opens the tooltip
		 * @function
		 * @private
		 * @param newContentsDiv
		 * @param info
		 * @param update
		 */
		_showContents: function _showContents(newContentsDiv, info, update) {
			if (!update){
				this.hide();
			} else {
				// If update is called but the set tooltip area is different, recreate the tooltip with the new sizing (ex: content assist resizing)
				// We could also check if the set anchor area is different, but no one would be using it
				if (this._tooltipArea && info.tooltipArea){
					if (this._tooltipArea.left !== info.tooltipArea.left || this._tooltipArea.top !== info.tooltipArea.top || this._tooltipArea.width !== info.tooltipArea.width || this._tooltipArea.height !== info.tooltipArea.height){
						this._anchorArea = null;
						this._tooltipArea = null;
						this._outerArea = null;
					}
				}
			}
			
			this._tooltipContents = newContentsDiv;
			this._tooltipDiv.appendChild(newContentsDiv);
			
			if (!this._anchorArea){
				this._anchorArea = this._computeAnchorArea(info);
			}
			if (!this._tooltipArea){
				// This function performs two tasks, computing the rectangle and setting all the style properties
				this._tooltipArea = this._computeTooltipArea(info, this._anchorArea, this._tooltipDiv);
			}
			if (!this._outerArea){
				this._outerArea = this._computeOuterArea(this._anchorArea, this._tooltipArea);
			}

			this._tooltipDiv.style.visibility = "visible"; //$NON-NLS-0$
			
			if (this._giveFocus) {
				this._setInitialFocus(this._tooltipDiv);
				this._giveFocus = undefined;
			}
		},
		
		/**
		 * @name _computeAnchorArea
		 * @description Computes and returns the rectangle that the tooltip is anchored to.  For example the anchor for an annotation 
		 * 				may be its text range.
		 * @function
		 * @private
		 * @param info {Object} the info object passed by the caller.
		 * @returns returns the computed rectangle anchor area
		 */
		_computeAnchorArea: function _computeAnchorArea(info){
			if (info.anchorArea){
				if (info.anchorArea.top && info.anchorArea.left && info.anchorArea.height && info.anchorArea.width){
					return info.anchorArea;
				}
			}
			
			if (info.context){
				if (info.context.offsetStart && info.context.offsetEnd){
					return this._computeRectangleFromOffset(info.context.offsetStart, info.context.offsetEnd);
				}
				
				if (info.context.offset >= 0){
					// Use the enclosing word
					var start = this._view.getNextOffset(info.context.offset, { unit: "word", count: -1}); //$NON-NLS-0$
					var end = this._view.getNextOffset(info.context.offset, { unit: "word", count: 0}); //$NON-NLS-0$
					return this._computeRectangleFromOffset(start, end);
				}
			}
			
			return {top: 0, left: 0, height: 0, width: 0};
		},
		
		/**
		 * @name _computeTooltipPosition
		 * @description Defines the tooltip area and placement.  Returns the rectangle defining the tooltip area and sets the tooltipDiv
		 * 				style to match the rectangles values.
		 * @param info the tooltip info object passed by the caller
		 * @param anchorArea the computed tooltip anchor area to which the tooltip will be positioned
		 * @param tooltipDiv the div for the tooltip, this function will modify its style to match the computed position/size
		 * @returns returns the computed tooltip area rectangle
		 * @function
		 * @private
		 */
		_computeTooltipArea: function _computeTooltipArea(info, anchorArea, tooltipDiv){
			var documentElement = tooltipDiv.ownerDocument.documentElement;
			
			// TODO This padding must match what is in tooltip.css
			var padding = 16;
			
			// Callers can specify the exact placement of the tooltip
			if (info.tooltipArea && info.tooltipArea.top && info.tooltipArea.left && info.tooltipArea.height && info.tooltipArea.width){										 
					tooltipDiv.style.overflowY = "auto"; //$NON-NLS-0$ // If caller specifies a height, allow scrolling
					tooltipDiv.style.resize = "none"; //$NON-NLS-0$
					tooltipDiv.style.top = (info.tooltipArea.top) + "px"; //$NON-NLS-0$
					tooltipDiv.style.left = (info.tooltipArea.left) + "px"; //$NON-NLS-0$
					tooltipDiv.style.height = (info.tooltipArea.height - padding) + "px"; //$NON-NLS-0$
					tooltipDiv.style.width = (info.tooltipArea.width - padding) + "px"; //$NON-NLS-0$
					return info.tooltipArea;
			}
			
			var divBounds = tooltipDiv.getBoundingClientRect();
			var tipRect = {
				width: divBounds.width,
				height: divBounds.height
			};
			
			var position = info.position ? info.position : "below"; //$NON-NLS-0$
			
			var viewBounds = (this._view._rootDiv ? this._view._rootDiv : documentElement).getBoundingClientRect();
			var viewportLeft = viewBounds.left;
			var viewportTop = viewBounds.top;
			var viewportWidth = viewBounds.width;
			var viewportHeight = viewBounds.height;
			
			// Set a default size for the tooltip
			var defWidth = viewportWidth;
			if (!info.allowFullWidth){
				defWidth = Math.min(viewportWidth/2, 600);
				var defHeight = Math.min(viewportHeight/2, 400);
				tipRect.width = Math.min(tipRect.width, defWidth);
				tipRect.height = Math.min(tipRect.height, defHeight);
			}
			
			// Hack for single line tooltips that wrap, set a minimum height to make them show 2 lines without scrolling
			// The largest line height was MacOS Chrome with 20px+padding.  So 25 is the minimum height we are sure we are one two lines
			// Similarly, the minimum height for the tooltip is two lines (20px x 2 + padding) (this will actually show three lines on Win7 Chrome)
			if ((25+padding) > tipRect.height && tipRect.width > (defWidth-padding)){
				tipRect.height = 40+padding;
			}

			var spaceBelow = viewportHeight - (anchorArea.top + anchorArea.height - viewportTop);
			var spaceAbove = anchorArea.top - viewportTop;
			var spaceRight = viewportWidth - (anchorArea.left + anchorArea.width - viewportLeft);
			
			// If there is not enough space above or below, swap the position.  Can't do the same for right/left because rulers are at client bounds
			if (position === "above" && tipRect.height > spaceAbove && tipRect.height <= spaceBelow){ //$NON-NLS-0$
				position = "below"; //$NON-NLS-0$
			} else if (position === "below" && tipRect.height > spaceBelow && tipRect.height <= spaceAbove){ //$NON-NLS-0$
				position = "above"; //$NON-NLS-0$
			}
			
			var offsetX = info.tooltipOffsetX ? info.tooltipOffsetX : 0;
			var offsetY = info.tooltipOffsetY ? info.tooltipOffsetY : 0;
			
			// Attempt to line up tooltip with the anchor area
			// If not enough space, shift the tooltip horiz (above/below) or vert (left/right) until it fits
			// Force the tooltip to start within the viewport area
			// Set maximum sizes for remaining area in the viewport area
			switch (position){
				case "left": //$NON-NLS-0$
					if ((tipRect.height + offsetY) > (spaceBelow + anchorArea.height)){
						// Shift the top of the tooltip upwards to fit, ignore the offset value
						tipRect.top = viewportHeight + viewportTop - tipRect.height;
					} else {
						tipRect.top = anchorArea.top + offsetY;
					}
					tipRect.top = Math.max(tipRect.top, viewportTop);
					tipRect.left = Math.max(anchorArea.left - tipRect.width + offsetX, viewportLeft);
				break;
				case "right": //$NON-NLS-0$
					if ((tipRect.height + offsetY) > (spaceBelow + anchorArea.height)){
						// Shift the top of the tooltip upwards to fit, ignore the offset value
						tipRect.top = viewportHeight + viewportTop - tipRect.height;
					} else {
						tipRect.top = anchorArea.top + offsetY;
					}
					tipRect.top = Math.max(tipRect.top, viewportTop);
					tipRect.left = Math.max(anchorArea.left + anchorArea.width + offsetX, viewportLeft);
				break;
				case "above": //$NON-NLS-0$
					if ((tipRect.width + offsetX) > (spaceRight + anchorArea.width)){
						// Shift the left side of the tooltip to the left, ignore the offset value
						tipRect.left = viewportWidth + viewportLeft - tipRect.width;
					} else {
						tipRect.left = anchorArea.left + offsetX;
					}
					tipRect.left = Math.max(tipRect.left, viewportLeft);
					tipRect.top = Math.max(anchorArea.top - tipRect.height + offsetY, viewportTop);
				break;
				case "below": //$NON-NLS-0$
					if ((tipRect.width + offsetX) > (spaceRight + anchorArea.width)){
						// Shift the left side of the tooltip to the left, ignore the offset value
						tipRect.left = viewportWidth + viewportLeft - tipRect.width;
					} else {
						tipRect.left = anchorArea.left + offsetX;
					}
					tipRect.left = Math.max(tipRect.left, viewportLeft);
					tipRect.top = Math.max(anchorArea.top + anchorArea.height + offsetY, viewportTop);
				break;
			}
			
			tipRect.maxWidth = Math.min(viewportWidth + viewportLeft - tipRect.left, viewportWidth);
			tipRect.maxHeight = Math.min(viewportHeight + viewportTop - tipRect.top, viewportHeight);
			
			// Adjust sizes for div padding, but not the actual tooltip box.
			tooltipDiv.style.maxWidth = (tipRect.maxWidth - padding) + "px"; //$NON-NLS-0$
			tooltipDiv.style.maxHeight = (tipRect.maxHeight - padding) + "px"; //$NON-NLS-0$
			tooltipDiv.style.width = (tipRect.width - padding) + "px"; //$NON-NLS-1$
			tooltipDiv.style.height = (tipRect.height - padding) + "px"; //$NON-NLS-1$
			tooltipDiv.style.left = tipRect.left + "px"; //$NON-NLS-0$
			tooltipDiv.style.top = tipRect.top + "px"; //$NON-NLS-0$
			return tipRect;
		},
		
		_computeOuterArea: function _computeOuterArea(anchorArea, tooltipArea){
			var left = Math.min(anchorArea.left, tooltipArea.left);
			var top = Math.min(anchorArea.top, tooltipArea.top);
			var positionRight = anchorArea.left + anchorArea.width;
			var tipRight = tooltipArea.left + tooltipArea.width;
			var right = Math.max(positionRight, tipRight);
			var positionBottom = anchorArea.top + anchorArea.height;
			var tipBottom = tooltipArea.top + tooltipArea.height;
			var bottom = Math.max(positionBottom, tipBottom);
				
			return {
					left: left,
					top : top,
					width: right - left,
					height: bottom - top
				};
		},
		
		/*
		 ******************************************************************************************************************* 
		 * Utility: This section contains various utility methods
		 ******************************************************************************************************************* 
		 */
		_hasFocus: function() {
			var tooltipDiv = this._tooltipDiv;
			if (!tooltipDiv) { return false; }
			return textUtil.contains(tooltipDiv, tooltipDiv.ownerDocument.activeElement);
		},
		_isNode: function (obj) {
			return typeof Node === "object" ? obj instanceof Node : //$NON-NLS-0$
				obj && typeof obj === "object" && typeof obj.nodeType === "number" && typeof obj.nodeName === "string"; //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
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
		_isInRect: function(rect, x, y) {
			if (!rect){
				return false;
			}
			var xOK = x >= rect.left && x <= (rect.left + rect.width);
			var yOK = y >= rect.top && y <= (rect.top + rect.height);
			return xOK && yOK;
		},
		mapOffset: function(offset, parent) {
			var textView = this._view;
			var model = textView.getModel();
			if (model.getBaseModel) {
				offset = model.mapOffset(offset, parent);
			}
			return offset;
		},
		_computeRectangleFromOffset: function(start, end) {
			// The offsets from annotations/hovering don't account for the projection model (folded comments) Bug 456715
			start = this.mapOffset(start);
			end = this.mapOffset(end);
			
			var tv = this._view;
			var curLine = tv.getLineAtOffset(start);
			var endLine = tv.getLineAtOffset(end);
			
			// Adjust start / end to be on the current line if necessary
			if (curLine !== endLine) {
				// 'getLineEnd' isn't API in textView but is in textModel...
				end = tv.getModel().getLineEnd(curLine);
			}
			
			var height = tv.getLineHeight(curLine);
			var startPos = tv.getLocationAtOffset(start);
			var endPos = tv.getLocationAtOffset(end);
			
			var viewRect = { x: startPos.x, y: startPos.y, 
								width: endPos.x - startPos.x, height: height};
								
			viewRect = this._view.convert(viewRect, "document", "page"); //$NON-NLS-0$ //$NON-NLS-1$
			return {left: viewRect.x, top: viewRect.y, width: viewRect.width, height: viewRect.height};
		},
		/*
		 ******************************************************************************************************************* 
		 * Rendering: This section deals with rendering supplied data into HTML for inclusion into the Info Popup.
		 ******************************************************************************************************************* 
		 */
		_renderPluginContent: function(contentsDiv, data) {
			var document = this._tooltipDiv.ownerDocument;
			// data object should be an object containing the type and content.  If no type or unknown type, default to string.
			if (typeof data !== 'string' && typeof data.content === 'undefined') { //$NON-NLS-0$ //$NON-NLS-1$
			    return false;
			}
			
			var sectionDiv = util.createElement(document, "div"); //$NON-NLS-0$;
			// render the title, if any
			if (data.title) {
				var titleDiv = util.createElement(document, "div"); //$NON-NLS-0$;
				titleDiv.innerHTML = this.hover.renderMarkDown ? this.hover.renderMarkDown(data.title) : data.title;
				sectionDiv.appendChild(titleDiv);
			}
			var contentDiv = util.createElement(document, "div"); //$NON-NLS-0$
			
			if (typeof data === 'string'){ //$NON-NLS-0$
				contentDiv.appendChild(document.createTextNode(data));
			} else {
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
							iframe.style.width = "100%"; //$NON-NLS-0$
							iframe.style.height = "100%"; //$NON-NLS-0$
							// TODO The iframe computed height is always 3px smaller than the tooltip, giving the impression of inconsistent padding
							this._tooltipDiv.style.paddingBottom = "5px";  //$NON-NLS-0$
							iframe.srcdoc = data.content;
							if (data.width) {
								iframe.style.width = data.width;
							}
							if (data.height) {
								iframe.style.height = data.height;
							}
							sectionDiv.style.height = '100%';  //$NON-NLS-0$ // Height should grow on resize
							contentsDiv.style.height = '100%';  //$NON-NLS-0$
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
						contentDiv.appendChild(document.createTextNode(data.content));
					}
				}
			}
			sectionDiv.appendChild(contentDiv);
			contentsDiv.appendChild(sectionDiv);
			return true;
		},
		/*
		 * Empty or empty array = call hover service for dynamic content
		 * Array = annotations
		 * String = HTML text
		 * Node = HTML node
		 * ProjectionTextModel = code projection
		 */
		_renderImmediateInfo: function _renderImmediateInfo(contentsDiv, contents, context) {						
			// If it's an annotation then process the annotation(s) to get the actual data
			if (contents instanceof Array) {
				contents = this._getAnnotationContents(contents, context);			
				if (!contents) {
					return false;
				}
			}
			
			if (typeof contents === "string") { //$NON-NLS-0$
				contentsDiv.innerHTML = contents;
				return true;
			} else if (this._isNode(contents)) {
				contentsDiv.appendChild(contents);
				return true;
			} else if (contents instanceof mProjectionTextModel.ProjectionTextModel) {
				var view = this._view;
				var options = view.getOptions();
				options.wrapMode = false;
				options.parent = contentsDiv;
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
				
				// TODO This is a hack to compute the projection size we will have in the tooltip, we remove the child after computing
				this._tooltipDiv.appendChild(contentsDiv);
				// Use the editor colors with a simple border
				this._tooltipDiv.classList.add("textviewTooltipCodeProjection"); //$NON-NLS-0$
				var size = contentsView.computeSize();
				// Adjust the size for the padding
				contentsDiv.style.width = (size.width+8) + "px"; //$NON-NLS-0$
				contentsDiv.style.height = (size.height+8) + "px"; //$NON-NLS-0$
				contentsView.resize();
				this._tooltipDiv.removeChild(contentsDiv);
				return true;
			}
			return false;
		},
		
		/**
		 * @name _getAnnotationContents
		 * @description Takes a list of annotation and renders them in the tooltip
		 * @function
		 * @private
		 * @param annotations the list of annotations to render
		 * @param context optional object containing where the annotations are displayed (ruler, editor, etc.)
		 * @returns returns document node containing rendered tooltip content
		 */
		_getAnnotationContents: function(annotations, context) {
			var self = this;
			var inEditor = self.hover ? true : false;
			if (inEditor && context && context.source && context.source.indexOf('ruler') >= 0){ //$NON-NLS-0$
				inEditor = false;
			}
			
			var annotation;
			var newAnnotations = [];
			for (var j = 0; j < annotations.length; j++) {
				annotation = annotations[j];
				if (annotation.title !== "" && !annotation.groupAnnotation) {
					// Don't display untitled annotations in the editor such as occurrences as the code is already visible
					if (!inEditor || annotation.title){
						newAnnotations.push(annotation); 
					}
				}
			}
			annotations = newAnnotations;
			if (annotations.length === 0) {
				return null;
			}
			
			
			var html;
			var document = this._tooltipDiv.ownerDocument;
			var view = this._view;
			var model = view.getModel();
			var baseModel = model.getBaseModel ? model.getBaseModel() : model;
			
			// If this is a code folding annotation, display code projection
			if (annotations.length === 1 && annotations[0].type === "orion.annotation.folding") {
				var newModel = new mProjectionTextModel.ProjectionTextModel(baseModel);
				var lineStart = baseModel.getLineStart(baseModel.getLineAtOffset(annotations[0].start));
				var charCount = baseModel.getCharCount();
				if (annotations[0].end !== charCount) {
					newModel.addProjection({start: annotations[0].end, end: charCount});
				}
				if (lineStart > 0) {
					newModel.addProjection({start: 0, end: lineStart});
				}
				return newModel;
			}
			
			if (annotations.length === 1) {
				html = getAnnotationHTML(annotations[0], inEditor);
				if (html && html.firstChild) {
					var className = html.firstChild.className;
					if (className) { className += " "; } //$NON-NLS-0$
					className += "single"; //$NON-NLS-0$
					html.firstChild.className = className;
				}
				return html;
			} else {
				var tooltipHTML = util.createElement(document, "div"); //$NON-NLS-0$
				var em = util.createElement(document, "em"); //$NON-NLS-0$
				em.appendChild(document.createTextNode(messages.multipleAnnotations));
				tooltipHTML.appendChild(em);
				for (var i = 0; i < annotations.length; i++) {
					html = getAnnotationHTML(annotations[i], inEditor);
					if (html) {
						tooltipHTML.appendChild(html);
					}
				}
				return tooltipHTML;
			}
			
			function getAnnotationHTML(annotation, inEditor) {
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
					var textStart = baseModel.getLineStart(baseModel.getLineAtOffset(annotation.start));
					var textEnd = baseModel.getLineEnd(baseModel.getLineAtOffset(annotation.end), true);
					title = baseModel.getText(textStart, textEnd);
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
				if (inEditor) {
					self.hover.renderQuickFixes(annotation, result);
				}
				if (context){	
					// Set the hover area to the annotation if it's not already set
					context.offsetStart = annotation.start;
					context.offsetEnd = annotation.end;
				}
				return result;
			}
		}
		
	};
	return {Tooltip: Tooltip};
});
