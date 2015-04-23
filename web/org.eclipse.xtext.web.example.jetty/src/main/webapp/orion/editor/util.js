/*******************************************************************************
 * @license
 * Copyright (c) 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/
 
/*eslint-env browser, amd*/
define("orion/editor/util", [], function() { //$NON-NLS-0$
	
	/** @private */
	function addEventListener(node, type, handler, capture) {
		if (typeof node.addEventListener === "function") { //$NON-NLS-0$
			node.addEventListener(type, handler, capture === true);
		} else {
			node.attachEvent("on" + type, handler); //$NON-NLS-0$
		}
	}
	/** @private */
	function removeEventListener(node, type, handler, capture) {
		if (typeof node.removeEventListener === "function") { //$NON-NLS-0$
			node.removeEventListener(type, handler, capture === true);
		} else {
			node.detachEvent("on" + type, handler); //$NON-NLS-0$
		}
	}
	/** @private */
	function contains(topNode, node) {
		if (!node) { return false; }
		if (!topNode.compareDocumentPosition) {
			var temp = node;
			while (temp) {
				if (topNode === temp) {
					return true;
				}
				temp = temp.parentNode;
			}
			return false;
		}
		return topNode === node || (topNode.compareDocumentPosition(node) & 16) !== 0;
	}
	/** @private */
	function getNodeStyle(node, prop, defaultValue) {
		var value;
		if (node) {
			value = node.style[prop];
			if (!value) {
				if (node.currentStyle) {
					var index = 0, p = prop;
					while ((index = p.indexOf("-", index)) !== -1) { //$NON-NLS-0$
						p = p.substring(0, index) + p.substring(index + 1, index + 2).toUpperCase() + p.substring(index + 2);
					}
					value = node.currentStyle[p];
				} else {
					var css = node.ownerDocument.defaultView.getComputedStyle(node, null);
					value = css ? css.getPropertyValue(prop) : null;
				}
			}
		}
		return value || defaultValue;
	}

	/**
	 * @class
	 * @private
	 * @name orion.editor.Animation
	 * @description Creates an animation.
	 * @param {Object} options Options controlling the animation.
	 * @param {Array} options.curve Array of 2 values giving the start and end points for the animation.
	 * @param {Number} [options.duration=350] Duration of the animation, in milliseconds.
	 * @param {Function} [options.easing]
	 * @param {Function} [options.onAnimate]
	 * @param {Function} [options.onEnd]
	 * @param {Number} [options.rate=20] The time between frames, in milliseconds.
	 */
	var Animation = /** @ignore */ (function() {
		function Animation(options) {
			this.options = options;
		}
		/**
		 * Plays this animation.
		 * @function
		 * @memberOf orion.editor.Animation.prototype
		 * @name play
		 */
		Animation.prototype.play = function() {
			var duration = (typeof this.options.duration === "number") ? this.options.duration : 350, //$NON-NLS-0$
			    rate = (typeof this.options.rate === "number") ? this.options.rate : 20, //$NON-NLS-0$
			    easing = this.options.easing || this.defaultEasing,
			    onAnimate = this.options.onAnimate || function() {},
			    start = this.options.curve[0],
			    end = this.options.curve[1],
			    range = (end - start),
			    startedAt = -1,
				propertyValue,
				self = this;

			function onFrame() {
				startedAt = (startedAt === -1) ? new Date().getTime() : startedAt;
				var now = new Date().getTime(),
				    percentDone = (now - startedAt) / duration;
				if (percentDone < 1) {
					var eased = easing(percentDone);
					propertyValue = start + (eased * range);
					onAnimate(propertyValue);
				} else {
					onAnimate(end);
					self.stop();
				}
			}
			this.interval = this.options.window.setInterval(onFrame, rate);
		};
		/**
		 * Stops this animation.
		 * @function
		 * @memberOf orion.editor.Animation.prototype
		 */
		Animation.prototype.stop = function() {
			this.options.window.clearInterval(this.interval);
		    var onEnd = this.options.onEnd || function () {};
			onEnd();
		};
		Animation.prototype.defaultEasing = function(x) {
			return Math.sin(x * (Math.PI / 2));
		};
		return Animation;
	}());

	return {
		contains: contains,
		getNodeStyle: getNodeStyle,
		addEventListener: addEventListener,
		removeEventListener: removeEventListener,
		Animation: Animation
	};
});