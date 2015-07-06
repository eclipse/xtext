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
define([], function() {
	function mixin(target/*, source..*/) {
		var hasOwnProperty = Object.prototype.hasOwnProperty;
		for (var j = 1, len = arguments.length; j < len; j++) {
			var source = arguments[j];
			for (var key in source) {
				if (hasOwnProperty.call(source, key)) {
					target[key] = source[key];
				}
			}
		}
		return target;
	}

	/**
	 * @name orion.objects
	 * @class Object-oriented helpers.
	 */
	return {
		/**
		 * Creates a shallow clone of the given <code>object</code>.
		 * @name orion.objects.clone
		 * @function
		 * @static
		 * @param {Object|Array} object The object to clone. Must be a "normal" Object or Array. Other built-ins,
		 * host objects, primitives, etc, will not work.
		 * @returns {Object|Array} A clone of <code>object</code>.
		 */
		clone: function(object) {
			if (Array.isArray(object)) {
				return Array.prototype.slice.call(object);
			}
			var clone = Object.create(Object.getPrototypeOf(object));
			mixin(clone, object);
			return clone;
		},
		/**
		 * Mixes all <code>source</code>'s own enumerable properties into <code>target</code>. Multiple source objects
		 * can be passed as varargs.
		 * @name orion.objects.mixin
		 * @function
		 * @static
		 * @param {Object} target
		 * @param {Object} source
		 */
		mixin: mixin,
		/**
		 * Wraps an object into an Array if necessary.
		 * @name orion.objects.toArray
		 * @function
		 * @static
		 * @param {Object} obj An object.
		 * @returns {Array} Returns <code>obj</code> unchanged, if <code>obj</code> is an Array. Otherwise returns a 1-element Array
		 * whose sole element is <code>obj</code>.
		 */
		toArray: function(o) {
			return Array.isArray(o) ? o : [o];
		}
	};
});