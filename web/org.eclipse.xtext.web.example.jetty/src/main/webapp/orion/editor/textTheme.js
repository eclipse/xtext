/*******************************************************************************
 * @license
 * Copyright (c) 2013,2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
 
/*eslint-env browser, amd*/
define("orion/editor/textTheme", //$NON-NLS-0$
[
	'require', //$NON-NLS-0$
	'orion/editor/eventTarget', //$NON-NLS-0$
	'orion/util' //$NON-NLS-0$
], function(require, mEventTarget, util) {
	var THEME_PREFIX = "orion-theme-"; //$NON-NLS-0$
	
	var Themes = {};

	/**
	 * Constructs a new text theme. 
	 * 
	 * @class A TextTheme is a class used to specify an editor theme.
	 * @name orion.editor.TextTheme
	 * @borrows orion.editor.EventTarget#addEventListener as #addEventListener
	 * @borrows orion.editor.EventTarget#removeEventListener as #removeEventListener
	 * @borrows orion.editor.EventTarget#dispatchEvent as #dispatchEvent
	 */
	function TextTheme(options) {
		options = options || {};
		this._document = options.document || document;
	}

	/**
	 * Gets an instance of <code>orion.editor.TextTheme</code> by name. If the name
	 * paramenter is not speficed the default text theme instance is returned.
	 * Subsequent calls of <code>getTheme</code> with the same name will return
	 * the same instance.
	 */
	TextTheme.getTheme = function(name) {
		name = name || "default"; //$NON-NLS-0$
		var theme = Themes[name];
		if (!theme) {
			theme = Themes[name] = new TextTheme();
		}
		return theme;
	};

	TextTheme.prototype = /** @lends orion.editor.TextTheme.prototype */ {
		/**
		 * Returns the theme className.
		 *
		 * @see orion.editor.TextTheme#setThemeClass
		 */
		getThemeClass: function() {
			return this._themeClass;
		},
		/**
		 * @class This object represents a style sheet for a theme manager.
		 * <p>
		 * <b>See:</b><br/>
		 * {@link orion.editor.TextTheme#setThemeClass}
		 * </p>
		 * @name orion.editor.ThemeStyleSheet
		 * 
		 * @property {String} href The href of the stylesheet
		 */
		/**
		 * Sets the theme className and style sheet.
		 * <p>
		 * If the <code>stylesheet</code> parameter is a string, it represents an inline
		 * CSS and it will be added to the document as a <i>STYLE</i> tag element.  If the
		 * <code>stylesheet</code> parameter is a <code>orion.editor.ThemeStyleSheet</code>,
		 * its href property is loaded as either a <i>STYLE</i> tag element or as a <i>LINK</i>
		 * tag element.
		 * </p>
		 * <p>
		 * Listeners of the ThemeChanged event are notify once the styled sheet is loaded
		 * into the document.
		 * </p>
		 *
		 * @param {String} className the new theme className.
		 * @param {String|orion.editor.ThemeStyleSheet} styleSheet the CSS stylesheet for the new theme className.
		 *
		 * @see orion.editor.TextTheme#getThemeClass
		 * @see orion.editor.TextTheme#onThemeChanged
		 */
		 setThemeClass: function(className, styleSheet) {
			var self = this;
			var oldThemeClass = self._themeClass;	
			self._themeClass = className;
			this._load(className, styleSheet, function() {
				self.onThemeChanged({
					type: "ThemeChanged", //$NON-NLS-0$
					oldValue: oldThemeClass,
					newValue: self.getThemeClass()
				});
			});
		},
		/**
		 * @class This is the event sent when the theme className or style sheet has changed.
		 * <p>
		 * <b>See:</b><br/>
		 * {@link orion.editor.TextTheme}<br/>
		 * {@link orion.editor.TextTheme#event:onThemeChanged}
		 * </p>
		 * @name orion.editor.ThemeChangedEvent
		 * 
		 * @property {String} oldValue The old theme clasName.
		 * @property {String} newValue The new theme className.
		 */
		/**
		 * This event is sent when the theme clasName has changed and its style sheet has been loaded in the document.
		 *
		 * @event
		 * @param {orion.editor.ThemeChangedEvent} themeChangedEvent the event
		 */
		onThemeChanged: function(themeChangedEvent) {
			return this.dispatchEvent(themeChangedEvent);
		},
		buildStyleSheet: function(themeClass, settings) {
			var convertCSSname = function(name) {
				return name.replace(this._capitalRegEx, function(match) {
					return "-" + match; //$NON-NLS-0$
				}.bind(this)).toLowerCase();
			}.bind(this);

			var parseStyles = function(object, ancestors, className, isTopLevel, result) {
				var localResult = [];
				var keys = Object.keys(object);
				keys.forEach(function(key) {
					var value = object[key];
					if (typeof(value) === "string") { //$NON-NLS-0$
						localResult.push("\t" + convertCSSname(key) + ": " + value + ";"); //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
					} else {
						parseStyles(
							value,
							className === key ? ancestors : ancestors + (isTopLevel ? " ." : ".") + key, //$NON-NLS-1$ //$NON-NLS-0$
							className,
							false,
							result);
					}
				});
				if (localResult.length) {
					result.push(ancestors + (isTopLevel ? ".textview" : "") + " {"); //$NON-NLS-0$
					result.push.apply(result, localResult);
					result.push("}"); //$NON-NLS-0$
				}
			};

			var result = [""];
			parseStyles(settings.styles, "." + themeClass, settings.className, true, result); //$NON-NLS-0$
			return result.join("\n"); //$NON-NLS-0$
		},

		/**
		 * @private
		 */
		_createStyle: function(className, styleSheet, callback, link) {
			var document = this._document;
			var id = THEME_PREFIX + className;
			var node = document.getElementById(id);
			if (node) {
				if (link || node.firstChild.data === styleSheet) {
					return;
				}
				node.removeChild(node.firstChild);
				node.appendChild(document.createTextNode(styleSheet));
			} else {
				if (link) {
					node = util.createElement(document, "link"); //$NON-NLS-0$
					node.rel = "stylesheet"; //$NON-NLS-0$
					node.type = "text/css"; //$NON-NLS-0$
					node.href = styleSheet;
					node.addEventListener("load", function() { //$NON-NLS-0$
						callback();
					});
				} else {
					node = util.createElement(document, "style"); //$NON-NLS-0$
					node.appendChild(document.createTextNode(styleSheet));
				}
				node.id = id;
				var head = document.getElementsByTagName("head")[0] || document.documentElement; //$NON-NLS-0$
				head.appendChild(node);
			}
			if (!link) {
				callback();
			}
		},
		/**
		 * @private
		 */
		_load: function (className, styleSheet, callback) {
			if (!className) {
				callback();
				return;
			}
			if (typeof styleSheet === "string") { //$NON-NLS-0$
				this._createStyle(className, styleSheet, callback);
				return;
			}
			var href = styleSheet.href;
			var extension = ".css"; //$NON-NLS-0$
			if (href.substring(href.length - extension.length) !== extension) {
				href += extension;
			}
			if (/^\//.test(href) || /[a-zA-Z0-9]+:\/\//i.test(href) || !require.toUrl /* almond cannot load dynamically */) {
				this._createStyle(className, href, callback, true);
			} else {
				var self = this;
				require(["text!" + href], function(cssText) { //$NON-NLS-0$
					self._createStyle(className, cssText, callback, false);
				});
			}
		},
		_capitalRegEx: /[A-Z]/g
	};
	mEventTarget.EventTarget.addMixin(TextTheme.prototype);
	
	return {
		TextTheme: TextTheme
	};
});
