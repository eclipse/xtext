/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

define([], function() {
	
	if (!Function.prototype.bind) {
		Function.prototype.bind = function(target) {
			if (typeof this !== 'function')
				throw new TypeError('bind target is not callable');
			var args = Array.prototype.slice.call(arguments, 1);
			var unboundFunc = this;
			var nopFunc = function() {};
			boundFunc = function() {
				var localArgs = Array.prototype.slice.call(arguments);
				return unboundFunc.apply(this instanceof nopFunc ? this : target,
						args.concat(localArgs));
			};
			nopFunc.prototype = this.prototype;
			boundFunc.prototype = new nopFunc();
			return boundFunc;
		}
	}
	
	if (!Array.prototype.map) {
		Array.prototype.map = function(callback, thisArg) {
			if (this == null)
				throw new TypeError('this is null');
			if (typeof callback !== 'function')
				throw new TypeError('callback is not callable');
			var srcArray = Object(this);
			var len = srcArray.length >>> 0;
			var tgtArray = new Array(len);
			for (var i = 0; i < len; i++) {
				if (i in srcArray)
					tgtArray[i] = callback.call(thisArg, srcArray[i], i, srcArray);
			}
			return tgtArray;
		}
	}
	
	if (!Array.prototype.forEach) {
		Array.prototype.forEach = function(callback, thisArg) {
			if (this == null)
				throw new TypeError('this is null');
			if (typeof callback !== 'function')
				throw new TypeError('callback is not callable');
			var srcArray = Object(this);
			var len = srcArray.length >>> 0;
			for (var i = 0; i < len; i++) {
				if (i in srcArray)
					callback.call(thisArg, srcArray[i], i, srcArray);
			}
		}
	}
	
	return {};
});
