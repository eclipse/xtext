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
define("orion/editor/stylers/text_x-python/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-0$
	var keywords = [
		"and", "as", "assert", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"break", //$NON-NLS-0$
		"class", "continue", //$NON-NLS-1$ //$NON-NLS-0$
		"def", "del", //$NON-NLS-1$ //$NON-NLS-0$
		"exec", "elif", "else", "except", "Ellipsis", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"False", "finally", "for", "from", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"global", //$NON-NLS-0$
		"if", "import", "in", "is", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"lambda", //$NON-NLS-0$
		"not", "None", "NotImplemented", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"or", //$NON-NLS-0$
		"pass", "print", //$NON-NLS-1$ //$NON-NLS-0$
		"raise", "return", //$NON-NLS-1$ //$NON-NLS-0$
		"try", "True", //$NON-NLS-1$ //$NON-NLS-0$
		"while", "with", //$NON-NLS-1$ //$NON-NLS-0$
		"yield" //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.python", //$NON-NLS-0$
		contentTypes: ["text/x-python"], //$NON-NLS-0$
		patterns: [
			{
				begin: "(['\"])\\1\\1", //$NON-NLS-0$
				end: "\\1\\1\\1", //$NON-NLS-0$
				name: "string.quoted.triple.python" //$NON-NLS-0$
			}, 
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
			{
				begin: {match: "#", literal: "#"}, //$NON-NLS-0$
				end: {match: "$", literal: ""}, //$NON-NLS-0$
				name: "comment.line.number-sign.python", //$NON-NLS-0$
				patterns: [
					{
						include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
					}
				]
			},
			{include: "orion.lib#brace_open"}, //$NON-NLS-0$
			{include: "orion.lib#brace_close"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_open"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_close"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_open"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_close"}, //$NON-NLS-0$
			{include: "orion.lib#operator"}, //$NON-NLS-0$
			{include: "#number_decimal"}, //$NON-NLS-0$
			{include: "orion.lib#number_hex"}, //$NON-NLS-0$ 
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.python" //$NON-NLS-0$
			}
		],
		repository: {
			number_decimal: {
				match: "\\b-?(?:\\.\\d+|\\d+\\.?\\d*)[lL]?\\b", //$NON-NLS-0$
				name: "constant.numeric.number.python" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
