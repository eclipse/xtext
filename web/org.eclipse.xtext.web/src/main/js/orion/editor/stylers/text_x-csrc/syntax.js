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
define("orion/editor/stylers/text_x-csrc/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"auto", //$NON-NLS-0$
		"break", //$NON-NLS-0$
		"case", "char", "const", "continue", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"default", "double", "do", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"else", "enum", "extern", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"float", "for", //$NON-NLS-1$ //$NON-NLS-0$
		"goto", //$NON-NLS-0$
		"if", "inline", "int", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"long", //$NON-NLS-0$
		"register", "return", //$NON-NLS-1$ //$NON-NLS-0$
		"short", "signed", "sizeof", "static", "struct", "switch", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"typedef", //$NON-NLS-0$
		"union", "unsigned", //$NON-NLS-1$ //$NON-NLS-0$
		"void", "volatile", //$NON-NLS-1$ //$NON-NLS-0$
		"while", //$NON-NLS-0$
		"_Bool", "_Complex", "_Imaginary" //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];

	var directives = [
		"define", "elif", "else", "endif", "error", "ifdef", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"ifndef", "if", "include", "line", "pragma", "undef" //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.c", //$NON-NLS-0$
		contentTypes: ["text/x-csrc", "text/x-c"], //$NON-NLS-1$ //$NON-NLS-0$
		patterns: [
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
			{include: "orion.c-like#comment_singleLine"}, //$NON-NLS-0$
			{include: "orion.lib#doc_block"}, //$NON-NLS-0$
			{include: "orion.c-like#comment_block"}, //$NON-NLS-0$
			{include: "#directive"}, //$NON-NLS-0$
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
				name: "keyword.operator.c" //$NON-NLS-0$
			}
		],
		repository: {
			directive: {
				match: "#\\s*(?:" + directives.join("|") + ")\\b[^$]*", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "meta.preprocessor.c" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords.concat(directives)
	};
});
