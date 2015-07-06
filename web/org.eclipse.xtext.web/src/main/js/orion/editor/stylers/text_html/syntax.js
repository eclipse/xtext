/*******************************************************************************
 * @license
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/*eslint-env browser, amd*/
define("orion/editor/stylers/text_html/syntax", ["orion/editor/stylers/application_javascript/syntax", "orion/editor/stylers/text_css/syntax", "orion/editor/stylers/application_xml/syntax"], //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	function(mJS, mCSS, mXML) {
	var attributes = [
		"accept-charset", "accept", "accesskey", "action", "align", "alt", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"async", "autocomplete", "autoplay", "autosave", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"bgcolor", "border", "buffered", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"challenge", "charset", "checked", "cite", "class", "codebase", "code", "color", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"colspan", "cols", "contenteditable", "content", "contextmenu", "controls", "coords", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"data-[A-Za-z_:][\\w.:-]*", "data", "datetime", "default", "defer", "dirname", "dir", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"disabled", "download", "draggable", "dropzone", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"enctype", //$NON-NLS-0$
		"formaction", "form", "for", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"headers", "height", "hidden", "high", "hreflang", "href", "http-equiv", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"icon", "id", "ismap", "itemprop", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"keytype", "kind", //$NON-NLS-1$ //$NON-NLS-0$
		"label", "language", "lang", "list", "loop", "low", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"manifest", "maxlength", "max", "media", "method", "min", "multiple", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"name", "novalidate", //$NON-NLS-1$ //$NON-NLS-0$
		"open", "optimum", //$NON-NLS-1$ //$NON-NLS-0$
		"pattern", "ping", "placeholder", "poster", "preload", "pubdate", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"radiogroup", "readonly", "rel", "required", "reversed", "rowspan", "rows", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"sandbox", "scoped", "scope", "seamless", "selected", "shape", "sizes", "size", "span", "spellcheck", //$NON-NLS-9$ //$NON-NLS-8$ //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"srcdoc", "srclang","srcset", "src", "start", "step", "style", "summary", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"tabindex", "target", "title", "type", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"usemap", //$NON-NLS-0$
		"value", //$NON-NLS-0$
		"width", "wrap" //$NON-NLS-1$ //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mJS.grammars);
	grammars.push.apply(grammars, mCSS.grammars);
	grammars.push.apply(grammars, mXML.grammars);
	grammars.push({
		id: "orion.html", //$NON-NLS-0$
		contentTypes: ["text/html"], //$NON-NLS-0$
		patterns: [
			{
				begin: "(?i)(<style)([^>]*)(>)", //$NON-NLS-0$
				end: "(?i)(</style>)", //$NON-NLS-0$
				captures: {
					1: {name: "meta.tag.html"}, //$NON-NLS-0$
					3: {name: "meta.tag.html"} //$NON-NLS-0$
				},
				contentName: "source.css.embedded.html", //$NON-NLS-0$
				patterns: [
					{include: "orion.css"} //$NON-NLS-0$
				]
			}, {
				begin: "(?i)<script\\s*>|<script\\s.*?(?:language\\s*=\\s*(['\"])javascript\\1|type\\s*=\\s*(['\"])(?:text|application)/(?:javascript|ecmascript)\\2).*?>", //$NON-NLS-0$
				end: "(?i)</script>", //$NON-NLS-0$
				captures: {
					0: {name: "meta.tag.html"} //$NON-NLS-0$
				},
				contentName: "source.js.embedded.html", //$NON-NLS-0$
				patterns: [
					{include: "orion.js"} //$NON-NLS-0$
				]
			}, {
				begin: "</?[A-Za-z0-9]+", //$NON-NLS-0$
				end: "/?>", //$NON-NLS-0$
				captures: {
					0: {name: "meta.tag.html"}, //$NON-NLS-0$
				},
				patterns: [
					{include: "orion.xml#comment"}, //$NON-NLS-0$
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
					{include: "#attribute"} //$NON-NLS-0$
				]
			},
			{include: "orion.xml#comment"}, //$NON-NLS-0$
			{include: "orion.xml#doctype"}, //$NON-NLS-0$
			{include: "orion.xml#ampersandEscape"} //$NON-NLS-0$
		],
		repository: {
			attribute:{
				match: "\\b(?:" + attributes.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "meta.tag.attribute.html" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: []
	};
});
