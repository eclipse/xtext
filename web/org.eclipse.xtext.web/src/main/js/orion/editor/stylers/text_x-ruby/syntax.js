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
define("orion/editor/stylers/text_x-ruby/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"alias_method", "alias", "attr_accessor", "attr_reader", "attr_writer", "attr", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"BEGIN", //$NON-NLS-0$
		"class", //$NON-NLS-0$
		"defined?", "def", //$NON-NLS-1$ //$NON-NLS-0$
		"END", "extend", //$NON-NLS-1$ //$NON-NLS-0$
		"gem", //$NON-NLS-0$
		"include", "initialize", "in", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"load",  "lambda", //$NON-NLS-1$ //$NON-NLS-0$
		"module_function", "module", //$NON-NLS-1$ //$NON-NLS-0$
		"new", "not", //$NON-NLS-1$ //$NON-NLS-0$
		"public", "prepend", "private", "protected", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"require_relative", "require", //$NON-NLS-1$ //$NON-NLS-0$
		"undef", //$NON-NLS-0$
		"__ENCODING__", "__END__", "__FILE__", "__LINE__" //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];
	var controlKeywords = [
		"and", //$NON-NLS-0$
		"begin", "break", //$NON-NLS-1$ //$NON-NLS-0$
		"case", "catch", //$NON-NLS-1$ //$NON-NLS-0$
		"do", //$NON-NLS-0$
		"else", "elsif", "end", "ensure", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"fail", "for", //$NON-NLS-1$ //$NON-NLS-0$
		"if", //$NON-NLS-0$
		"loop", //$NON-NLS-0$
		"next", //$NON-NLS-0$
		"or", //$NON-NLS-0$
		"raise", "redo", "rescue", "retry", "return", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"then", "throw", //$NON-NLS-1$ //$NON-NLS-0$
		"unless", "until", //$NON-NLS-1$ //$NON-NLS-0$
		"when", "while", //$NON-NLS-1$ //$NON-NLS-0$
		"yield" //$NON-NLS-0$
	];
	var constants = [
		"false", "nil", "true" //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];
	var languageVariables = ["self", "super"]; //$NON-NLS-1$ //$NON-NLS-0$

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.ruby", //$NON-NLS-0$
		contentTypes: ["text/x-ruby"], //$NON-NLS-0$
		patterns: [
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
			{include: "#symbol_quoted_single"}, //$NON-NLS-0$
			{include: "#symbol_quoted_double"}, //$NON-NLS-0$
			{include: "#symbol"}, //$NON-NLS-0$
			{include: "#classRef"}, //$NON-NLS-0$
			{
				match: "/(?![\\s])(?:\\\\.|[^/])+/(?:[ioxmuesn]\\b)?", //$NON-NLS-0$
				name: "string.regexp.ruby" //$NON-NLS-0$
			}, {
				match: {match: "#.*", literal: "#"}, //$NON-NLS-0$
				name: "comment.line.number-sign.ruby", //$NON-NLS-0$
				patterns: [
					{include: "orion.lib#todo_comment_singleLine"} //$NON-NLS-0$
				]
			}, {
				begin: {match: "^=begin\\b", literal: "=begin"}, //$NON-NLS-0$
				end: {match: "^=end\\b", literal: "=end"}, //$NON-NLS-0$
				name: "comment.block.ruby", //$NON-NLS-0$
				patterns: [
					{
						match: "(\\b)(TODO)(\\b)(((?!\\*/).)*)", //$NON-NLS-0$
						name: "meta.annotation.task.todo", //$NON-NLS-0$
						captures: {
							2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
							4: {name: "comment.block"} //$NON-NLS-0$
						}
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
			{include: "orion.lib#number_decimal"}, //$NON-NLS-0$
			{include: "orion.lib#number_hex"}, //$NON-NLS-0$
			{include: "#variable"}, //$NON-NLS-0$
			{
				match: "\\b0[bB][01]+\\b", //$NON-NLS-0$
				name: "constant.numeric.binary.ruby" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.ruby" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + controlKeywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.control.ruby" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + constants.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "constant.language.ruby" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + languageVariables.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "variable.language.ruby" //$NON-NLS-0$
			}
		],
		repository: {
			classRef: {
				match: "\\w+::\\w+" //$NON-NLS-0$
			},
			symbol: {
				match: ":\\w+", //$NON-NLS-0$
				name: "entity.name.symbol.ruby" //$NON-NLS-0$
			},
			symbol_quoted_single: {
				match: ":'[^']*'", //$NON-NLS-0$
				name: "entity.name.symbol.quoted.single.ruby" //$NON-NLS-0$
			},
			symbol_quoted_double: {
				match: ':"[^"]*"', //$NON-NLS-0$
				name: "entity.name.symbol.quoted.double.ruby" //$NON-NLS-0$
			},
			variable: {
				match: "@\\w+", //$NON-NLS-0$
				name: "entity.name.variable.ruby" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords.concat(controlKeywords).concat(constants).concat(languageVariables)
	};
});
