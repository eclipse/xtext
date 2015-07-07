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
define("orion/editor/stylers/text_x-java-source/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"abstract", //$NON-NLS-0$
		"boolean", "byte", //$NON-NLS-1$ //$NON-NLS-0$
		"char", "class", //$NON-NLS-1$ //$NON-NLS-0$
		"double", //$NON-NLS-0$
		"extends", //$NON-NLS-0$
		"final", "float", //$NON-NLS-1$ //$NON-NLS-0$
		"implements", "import", "instanceof", "int", "interface", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"long", //$NON-NLS-0$
		"native", "new", //$NON-NLS-1$ //$NON-NLS-0$
		"package", "private", "protected", "public", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"short", "static", "synchronized", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"throws", "transient", //$NON-NLS-1$ //$NON-NLS-0$
		"void", "volatile" //$NON-NLS-1$ //$NON-NLS-0$
	];
	var controlKeywords = [
		"break", //$NON-NLS-0$
		"case", "catch", "continue", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"default", "do", //$NON-NLS-1$ //$NON-NLS-0$
		"else", //$NON-NLS-0$
		"finally", "for", //$NON-NLS-1$ //$NON-NLS-0$
		"if", //$NON-NLS-0$
		"return", //$NON-NLS-0$
		"switch", //$NON-NLS-0$
		"throw", "try", //$NON-NLS-1$ //$NON-NLS-0$
		"while" //$NON-NLS-0$
	];
	var constants = [
		"false", "null", "true" //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];
	var languageVariables = ["this", "super"]; //$NON-NLS-1$ //$NON-NLS-0$

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.java", //$NON-NLS-0$
		contentTypes: ["text/x-java-source"], //$NON-NLS-0$
		patterns: [
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
			{include: "orion.c-like#comment_singleLine"}, //$NON-NLS-0$
			{include: "orion.lib#doc_block"}, //$NON-NLS-0$
			{include: "orion.c-like#comment_block"}, //$NON-NLS-0$
			{include: "orion.lib#brace_open"}, //$NON-NLS-0$
			{include: "orion.lib#brace_close"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_open"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_close"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_open"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_close"}, //$NON-NLS-0$
			{include: "orion.lib#operator"}, //$NON-NLS-0$
			{include: "orion.lib#number_decimal"}, //$NON-NLS-0$
			{include: "orion.lib#number_hex"}, //$NON-NLS-0$
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.java" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + controlKeywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.control.java" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + constants.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "constant.language.java" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + languageVariables.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "variable.language.java" //$NON-NLS-0$
			}
		]
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords.concat(controlKeywords).concat(constants).concat(languageVariables)
	};
});
