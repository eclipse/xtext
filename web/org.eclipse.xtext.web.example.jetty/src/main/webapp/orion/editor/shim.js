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
define("orion/editor/shim", [], function() { //$NON-NLS-0$

	/**
	 * Partial ECMAScript 5 shim.
	 */
	
	if (!Object.create) {
		/* This shim does not properly support the props paramenter. It only works for Deferred.js. */
		Object.create = function(proto, props) {
			function N() {}
			N.prototype = proto;
			var result = new N();
			if (props) {
				for (var p in props) {
					if (props.hasOwnProperty(p)) {
						if (props[p].hasOwnProperty("value")) { //$NON-NLS-0$
							result[p] = props[p].value;
						} else {
							result[p] = function() {
								if (arguments.length > 0) {
									return props[p].get();
								} else {
									props[p].set(arguments);
								}
							};
						}
					}
				}
			}
			return result;
		};
	}
	if (!Object.keys) {
		Object.keys = function(o) {
			var hop = Object.prototype.hasOwnProperty, result = [];
			for (var p in o) {
				if (hop.call(o, p)) {
					result.push(p);
				}
			}
			return result;
		};
	}

	if (!Function.prototype.bind) {
		Function.prototype.bind = function (context) {
			var fn = this, fixed = Array.prototype.slice.call(arguments, 1);
			if (fixed.length) {
				return function() {
					return arguments.length	? fn.apply(context, fixed.concat(Array.prototype.slice.call(arguments))) : fn.apply(context, fixed);
				};
			}
			return function() {
				return arguments.length ? fn.apply(context, arguments) : fn.call(context);
			};
		};
	}

	
	if (!Array.isArray) {
		Array.isArray = function(obj) {
			return Object.prototype.toString.call(obj) === "[object Array]";
		};
	}
	if (!Array.prototype.indexOf) {
		Array.prototype.indexOf = function(c) {
			for (var i=0; i<this.length; i++) {
				if (this[i] === c) {
					return i;
				}
			}
			return -1;
		};
	}
	if (!Array.prototype.forEach) {
		Array.prototype.forEach = function(func) {
			for (var i=0; i<this.length; i++) {
				func(this[i], i);
			}
		};
	}
	if (!Array.prototype.map) {
		Array.prototype.map = function(func) {
			var result = new Array(this.length);
			for (var i=0; i<this.length; i++) {
				result[i] = func(this[i]);
			}
			return result;
		};
	}
	if (!Array.prototype.reduce) {
		Array.prototype.reduce = function(func, initialValue){
			var result, set = false;
			if (1 < arguments.length) {
				result = initialValue;
				set = true;
			}
			for (var i = 0; this.length > i; ++i) {
				if (set) {
					result = func(result, this[i], i, this);
				} else {
					result = this[i];
					set = true;
				}
			}
			return result;
		};
	}
	
	if (!String.prototype.trim) {
		String.prototype.trim = function(){
			return this.replace(/^\s+|\s+$/g, '');
		};
	}
	if (!String.prototype.trimLeft) {
		String.prototype.trimLeft = function(){
			return this.replace(/^\s+/g, '');
		};
	}
	if (!String.prototype.trimRight) {
		String.prototype.trimRight = function(){
			return this.replace(/\s+$/g, '');
		};
	}

	return {};
});