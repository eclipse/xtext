/*******************************************************************************
 * @license
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10/.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/*eslint-env browser, amd*/
define("orion/editor/stylers/text_x-go/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"break", //$NON-NLS-0$
		"case", "const", "continue", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"default", "defer", //$NON-NLS-1$ //$NON-NLS-0$
		"else", //$NON-NLS-0$
		"fallthrough", "false", "for", "func", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"goto", "go", //$NON-NLS-1$ //$NON-NLS-0$
		"if", "import", //$NON-NLS-1$ //$NON-NLS-0$
		"nil", //$NON-NLS-0$
		"package", //$NON-NLS-0$
		"range", "return", //$NON-NLS-1$ //$NON-NLS-0$
		"select", "switch", //$NON-NLS-1$ //$NON-NLS-0$
		"true", "type", //$NON-NLS-1$ //$NON-NLS-0$
		"var" //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.go", //$NON-NLS-0$
		contentTypes: ["text/x-go"], //$NON-NLS-0$
		patterns: [
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
			{
				begin: "`", //$NON-NLS-0$
				end: "`", //$NON-NLS-0$
				name: "string.quoted.raw.go", //$NON-NLS-0$
			},
			{include: "orion.c-like#comment_singleLine"}, //$NON-NLS-0$
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
				name: "keyword.operator.go" //$NON-NLS-0$
			},
			{
				match: "\\b(?:len|cap|new|make|append|close|copy|delete|complex|real|imag|panic|recover)\\b", //$NON-NLS-0$
				name: "support.function.go" //$NON-NLS-0$
			},
			{
				match: "\\b(?:bool|chan|uint8|uint16|uint32|uint64|int8|int16|int32|int64|float32|float64|complex64|complex128|byte|map|rune|uint|interface|int|uintptr|string|struct|error)\\b", //$NON-NLS-0$
				name: "support.function.type" //$NON-NLS-0$
			}
		]
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
