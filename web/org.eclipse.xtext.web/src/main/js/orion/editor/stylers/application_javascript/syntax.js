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

define("orion/editor/stylers/application_javascript/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"class", "const", //$NON-NLS-1$ //$NON-NLS-0$
		"debugger", "delete", //$NON-NLS-1$ //$NON-NLS-0$
		"enum", "export", "extends", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"function", //$NON-NLS-0$
		"implements", "import", "in", "instanceof", "interface", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"let", //$NON-NLS-0$
		"new", //$NON-NLS-0$
		"package", "private", "protected", "public", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"static", "super", //$NON-NLS-1$ //$NON-NLS-0$
		"typeof", //$NON-NLS-0$
		"var", "void", //$NON-NLS-1$ //$NON-NLS-0$
		"with" //$NON-NLS-0$
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
		"while", //$NON-NLS-0$
		"yield" //$NON-NLS-0$
	];
	var languageVariables = ["this"]; //$NON-NLS-0$
	var constants = [
		"false", "null", "true", "undefined" //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.js", //$NON-NLS-0$
		contentTypes: ["application/javascript"], //$NON-NLS-0$
		patterns: [
			{
				begin: "'(?:\\\\.|[^\\\\'])*\\\\$", //$NON-NLS-0$
				end: "^(?:$|(?:\\\\.|[^\\\\'])*('|[^\\\\]$))", //$NON-NLS-0$
				name: "string.quoted.single.js" //$NON-NLS-0$
			}, {
				begin: '"(?:\\\\.|[^\\\\"])*\\\\$', //$NON-NLS-0$
				end: '^(?:$|(?:\\\\.|[^\\\\"])*("|[^\\\\]$))', //$NON-NLS-0$
				name: "string.quoted.double.js" //$NON-NLS-0$
			},
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
			{include: "orion.c-like#comment_singleLine"}, //$NON-NLS-0$
			{
				match: "/(?![\\s\\*])(?:\\\\.|[^/])+/(?:[gim]{0,3})", //$NON-NLS-0$
				name: "string.regexp.js" //$NON-NLS-0$
			},
			{include: "orion.lib#doc_block"}, //$NON-NLS-0$
			{include: "orion.c-like#comment_block"}, //$NON-NLS-0$
			{include: "#jsFunctionDef"}, //$NON-NLS-0$
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
				name: "keyword.operator.js" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + controlKeywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.control.js" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + constants.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "constant.language.js" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + languageVariables.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "variable.language.js" //$NON-NLS-0$
			}
		],
		repository: {
			jsFunctionDef: {
				/*
				 * http://stackoverflow.com/questions/2008279/validate-a-javascript-function-name/2008444#2008444
				 * was referenced in the composition of the "begin" pattern below.
				 */
				begin: "(function)(\\s+[_$a-zA-Z\\xA0-\\uFFFF][_$a-zA-Z0-9\\xA0-\\uFFFF]*)?\\s*\\(", //$NON-NLS-0$
				end: "\\)", //$NON-NLS-0$
				captures: {
					1: {name: "keyword.operator.js"}, //$NON-NLS-0$
					2: {name: "entity.name.function.js"} //$NON-NLS-0$
				},
				patterns: [
					{include: "orion.c-like#comment_singleLine"}, //$NON-NLS-0$
					{include: "orion.c-like#comment_block"}, //$NON-NLS-0$
					{
						match: "[^\\s,]+", //$NON-NLS-0$
						name: "variable.parameter.js" //$NON-NLS-0$
					}
				]
			}
		}
	});

	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords.concat(controlKeywords).concat(languageVariables).concat(constants)
	};
});
