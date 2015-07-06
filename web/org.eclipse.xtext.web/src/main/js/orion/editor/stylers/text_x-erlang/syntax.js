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
define("orion/editor/stylers/text_x-erlang/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"xor", //$NON-NLS-0$
		"when", //$NON-NLS-0$
		"try", //$NON-NLS-0$
		"rem", "receive", //$NON-NLS-1$ //$NON-NLS-0$
		"query", //$NON-NLS-0$
		"orelse", "or", "of", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"not", //$NON-NLS-0$
		"let", //$NON-NLS-0$
		"if", //$NON-NLS-0$
		"fun", //$NON-NLS-0$
		"end", //$NON-NLS-0$
		"div", //$NON-NLS-0$
		"cond", "catch", "case", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"bxor", "bsr", "bsl", "bor", "bnot", "begin", "band", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"andalso", "and", "after" //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];

	// For Preprocessors, Records and so on specified with hyphens
	var hyphenKeywords = [
		"vsn", //$NON-NLS-0$
		"undef", //$NON-NLS-0$
		"type", //$NON-NLS-0$
		"spec", //$NON-NLS-0$
		"record", //$NON-NLS-0$
		"on_load", "opaque", //$NON-NLS-1$ //$NON-NLS-0$
		"module", //$NON-NLS-0$
		"include_lib", "include", "import", "ifndef", "ifdef", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"file", //$NON-NLS-0$
		"export_type", "export", "endif", "else", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"define", //$NON-NLS-0$
		"callback", "compile", //$NON-NLS-1$ //$NON-NLS-0$
		"behaviour" //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.erlang", //$NON-NLS-0$
		contentTypes: ["text/x-erlang"], //$NON-NLS-0$
		patterns: [
			{include: "#comment"}, //$NON-NLS-0$
			{include: "#stringSingleLine"}, //$NON-NLS-0$
			{include: "#stringMultiLine"}, //$NON-NLS-0$
			{include: "#method"}, //$NON-NLS-0$
			{include: "orion.lib#brace_open"}, //$NON-NLS-0$
			{include: "orion.lib#brace_close"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_open"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_close"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_open"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_close"}, //$NON-NLS-0$
			{include: "orion.lib#operator"}, //$NON-NLS-0$
			{include: "orion.lib#number_decimal"}, //$NON-NLS-0$
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.erlang" //$NON-NLS-0$
			},
			{
				match: "^\\s*-(?:" + hyphenKeywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.erlang" //$NON-NLS-0$
			}
		],
		repository: {
			comment: {
				match: "%.*", //$NON-NLS-0$
				name: "comment.line.erlang", //$NON-NLS-0$
				patterns: [
					{
						include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
					}
				]
			},
			method: {
				match: "(^|\\s)[a-zA-Z0-9_.]+(?=\\(|\\s\\()", //$NON-NLS-0$
			    name: "entity.name.function.erlang" //$NON-NLS-0$
			},
			stringMultiLine: {
				begin: '"(?:\\\\.|[^\\\\"])*$', //$NON-NLS-0$
				end: '^(?:\\\\.|[^\\\\"])*"', //$NON-NLS-0$
				name: "string.quoted.double.erlang" //$NON-NLS-0$
			},
			stringSingleLine: {
				match: '"(?:\\\\.|[^\\\\"])*"', //$NON-NLS-0$
				name: "string.quoted.double.erlang" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
