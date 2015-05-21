/*******************************************************************************
 * @license
 * Copyright (c) 2011, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*eslint-env browser, amd*/
define(function(){
	
	var OPERATOR = {
		NUL: {first:"", sep:",", named: false, ifemp: "", allow: "U"}, //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"+": {first:"", sep:",", named: false, ifemp: "", allow: "U+R"}, //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		".": {first:".", sep:",", named: false, ifemp: "", allow: "U"}, //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"/": {first:"/", sep:"/", named: false, ifemp: "", allow: "U"}, //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		";": {first:";", sep:";", named: true, ifemp: "", allow: "U"}, //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"?": {first:"?", sep:"&", named: true, ifemp: "=", allow: "U"}, //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"&": {first:"&", sep:"&", named: true, ifemp: "=", allow: "U"}, //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"#": {first:"#", sep:",", named: false, ifemp: "", allow: "U+R"}, //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		",": {first:"", sep:",", named: false, ifemp: "", allow: "U+R-,"} //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	};

	var VARSPEC_REGEXP = /^((?:(?:[a-zA-Z0-9_])|(?:%[0-9A-F][0-9A-F]))(?:(?:[a-zA-Z0-9_.])|(?:%[0-9A-F][0-9A-F]))*)(?:(\*)|:([0-9]+))?$/;
	var PCT_ENCODED_G = /%25[0-9A-F][0-9A-F]/g;

	function Literal(text) {
		this._text = text;
	}

	Literal.prototype = {
		expand: function(vars) {
			return encodeURI(this._text);
		}
	};
	
	function decodePercent(str) {
		return str.replace("%25", "%");
	}
	
	function encodeString(value, encoding) {
		if (encoding === "U") { //$NON-NLS-0$
			return encodeURIComponent(value).replace(/[!'()*]/g, function(str) {
				return '%' + str.charCodeAt(0).toString(16).toUpperCase(); //$NON-NLS-0$
			});
		}
		if (encoding === "U+R") { //$NON-NLS-0$
			return encodeURI(value).replace(/%5B/g, '[').replace(/%5D/g, ']').replace(PCT_ENCODED_G, decodePercent); //$NON-NLS-1$ //$NON-NLS-0$
		}
		if (encoding === "U+R-,") { //$NON-NLS-0$
			return encodeURI(value).replace(/%5B/g, '[').replace(/%5D/g, ']').replace(/,/g, '%2C'); //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		}
		throw new Error("Unknown allowed character set: " + encoding);
	}
	
	function encodeArray(value, encoding, separator) {
		var result = [];
		for (var i=0; i < value.length; i++) {
			if (typeof(value[i]) !== "undefined") { //$NON-NLS-0$
				result.push(encodeString(value[i], encoding));
			}
		}
		return result.join(separator);
	}
	
	function encodeObject(value, encoding, nameValueSeparator, pairSeparator ) {
		var keys = Object.keys(value);
		var result = [];
		for (var i=0; i < keys.length; i++) {
			if (typeof(value[keys[i]]) !== "undefined") { //$NON-NLS-0$
				result.push(encodeString(keys[i], encoding) + nameValueSeparator + encodeString(value[keys[i]], encoding));
			}
		}
		return result.join(pairSeparator);
	}
	
	function parseVarSpecs(text) {
		var result = [];
		var rawSpecs = text.split(","); //$NON-NLS-0$
		for (var i=0; i < rawSpecs.length; i++) {
			var match = rawSpecs[i].match(VARSPEC_REGEXP);
			if (match === null) {
				throw new Error("Bad VarSpec: " + text); //$NON-NLS-0$
			}
			result.push({
				name: match[1], 
				explode: !!match[2], 
				prefix: match[3] ? parseInt(match[3], 10) : -1
			}); 
		}
		return result;
	}
	
	function Expression(text) {
		if (text.length === 0) {
			throw new Error("Invalid Expression: 0 length expression"); //$NON-NLS-0$
		}
		
		this._operator = OPERATOR[text[0]];
		if (this._operator) {
			text = text.substring(1);
		} else {
			this._operator = OPERATOR.NUL;
		}
		
		this._varSpecList = parseVarSpecs(text);
	}
	
	Expression.prototype = {
		expand: function(params) {
			var result = [];
			for (var i=0; i < this._varSpecList.length; i++) {
				var varSpec = this._varSpecList[i];
				var name = varSpec.name;
				var value = params[name];
				var valueType = typeof(value);
				if (valueType !== "undefined" && value !== null) { //$NON-NLS-0$
					var resultText = result.length === 0 ? this._operator.first: this._operator.sep;			
					if (valueType === "string") { //$NON-NLS-0$
						if (this._operator.named) {
							resultText += encodeString(name, "U+R"); //$NON-NLS-0$
							resultText += (value.length === 0) ? this._operator.ifemp : "="; //$NON-NLS-0$
						}
						if (varSpec.prefix !== -1 && varSpec.prefix < value.length) {
							value = value.substring(0, varSpec.prefix);
						}
						
						resultText += encodeString(value, this._operator.allow);
					} else if (Array.isArray(value)) {
						if (value.length === 0) {
							continue; // treated as undefined and skipped
						}
						if (!varSpec.explode) {
							var encodedArray = encodeArray(value, this._operator.allow, ","); //$NON-NLS-0$
							if (this._operator.named) {
								resultText += encodeString(name, "U+R"); //$NON-NLS-0$
								resultText += (encodedArray.length === 0) ? this._operator.ifemp : "="; //$NON-NLS-0$
							}
							resultText += encodedArray;
						} else {
							resultText += encodeArray(value, this._operator.allow, this._operator.sep);
						}				
					} else if (valueType === "object") { //$NON-NLS-0$
						if (Object.keys(value).length === 0) {
							continue; // treated as undefined and skipped
						}
						if (!varSpec.explode) {
							var encodedObject = encodeObject(value, this._operator.allow, ",", ","); //$NON-NLS-1$ //$NON-NLS-0$
							if (this._operator.named) {
								resultText += encodeString(name, "U+R"); //$NON-NLS-0$
								resultText += (encodedObject.length === 0) ? this._operator.ifemp : "="; //$NON-NLS-0$
							}
							resultText += encodedObject; //$NON-NLS-0$
						} else {
							resultText += encodeObject(value, this._operator.allow, "=", this._operator.sep); //$NON-NLS-0$
						}
					} else {
						throw new Error("bad param type: " + name + " : " + valueType); //$NON-NLS-1$ //$NON-NLS-0$
					}
					result.push(resultText);
				}
			}
			return result.join("");
		}
	};

	function parseTemplate(text) {
		var result = [];
		var current = 0;	
		var curlyStartIndex = text.indexOf("{", current); //$NON-NLS-0$
		while (curlyStartIndex !== -1) {
			result.push(new Literal(text.substring(current, curlyStartIndex)));
			var curlyEndIndex = text.indexOf("}", curlyStartIndex + 1); //$NON-NLS-0$
			if (curlyEndIndex === -1) {
				throw new Error("Invalid template: " + text); //$NON-NLS-0$
			}
			result.push(new Expression(text.substring(curlyStartIndex + 1, curlyEndIndex)));
			current = curlyEndIndex + 1;
			curlyStartIndex = text.indexOf("{", current);			 //$NON-NLS-0$
		}
		result.push(new Literal(text.substring(current)));
		return result;
	}

	/**
	 * @name orion.URITemplate
	 * @class A URITemplate describes a range of Uniform Resource Identifiers through variable expansion, and allows for particular URIs to 
	 * be generated by expanding variables to actual values.</p>
	 * <p>Because the syntax and encoding rules of URIs can be complex, URITemplates are recommended over manual construction of URIs through 
	 * string concatenation or other means.</p>
	 * <p>A URITemplate is created by invoking the constructor, passing a <em>template string</em>:</p>
	 * <p><code>new URITemplate(template)</code></p>
	 * <p>The <dfn>template string</dfn> is an expression following a well-defined syntax (see <a href="http://tools.ietf.org/html/rfc6570#section-1.2">here</a>
	 * for an introduction). Most notably, the template may include variables.</p>
	 * <p>Once created, a URITemplate's {@link #expand} method can be invoked to generate a URI. Arguments to {@link #expand} give the values to be 
	 * substituted for the template variables.</p>
	 * @description Creates a new URITemplate.
	 * @param {String} template The template string. Refer to <a href="http://tools.ietf.org/html/rfc6570#section-2">RFC 6570</a> for details
	 * of the template syntax.
	 */
	function URITemplate(template) {
		this._templateComponents = parseTemplate(template);
	}
	
	URITemplate.prototype = /** @lends orion.URITemplate.prototype */ {
		/**
		 * Expands this URITemplate to a URI.
		 * @param {Object} params The parameters to use for expansion. This object is a map of keys (variable names) to values (the variable's
		 * value in the <a href="http://tools.ietf.org/html/rfc6570#section-3.2.1">expansion algorithm</a>).
		 * @returns {String} The resulting URI.
		 */
		expand: function(params) {
			var result = [];
			for (var i = 0; i < this._templateComponents.length; i++) {
				result.push(this._templateComponents[i].expand(params));
			}
			return result.join("");
		}
	};

	return URITemplate;
});