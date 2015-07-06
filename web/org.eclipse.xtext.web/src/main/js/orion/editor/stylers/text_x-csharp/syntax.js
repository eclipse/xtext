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
define("orion/editor/stylers/text_x-csharp/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"abstract", "as", //$NON-NLS-1$ //$NON-NLS-0$
		"base", "bool", "break", "byte", "by", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"case", "catch", "char", "checked", "class", "const", "continue", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"decimal", "default", "delegate", "descending", "double", "do", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"else", "enum", "event", "explicit", "extern", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"false", "finally", "fixed", "float", "foreach", "for", "from", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"goto", "group", //$NON-NLS-1$ //$NON-NLS-0$
		"if", "implicit", "int", "interface", "internal", "into", "in", "is", //$NON-NLS-6$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"lock", "long", //$NON-NLS-1$ //$NON-NLS-0$
		"namespace", "new", "null", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"object", "operator", "orderby", "out", "override", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"params", "private", "protected", "public", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"readonly", "ref", "return", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"sbyte", "sealed", "select", "short", "sizeof", "stackalloc", "static", "string", "struct", "switch", //$NON-NLS-9$ //$NON-NLS-8$ //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$ 
		"this", "throw", "true", "try", "typeof", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"uint", "ulong", "unchecked", "unsafe", "ushort", "using", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"var", "virtual", "volatile", "void", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"while", "where", //$NON-NLS-1$ //$NON-NLS-0$
		"yield" //$NON-NLS-0$
	];

	var preprocessorDirectives = [
		"define", //$NON-NLS-0$
		"elif", "else", "endif", "endregion", "error", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"if", //$NON-NLS-0$
		"line", //$NON-NLS-0$
		"pragma checksum", "pragma warning", "pragma", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"region", //$NON-NLS-0$
		"undef", //$NON-NLS-0$
		"warning" //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.csharp", //$NON-NLS-0$
		contentTypes: ["text/x-csharp"], //$NON-NLS-0$
		patterns: [
			{
				match: "^\\s*#(?:" + preprocessorDirectives.join("|") + ")\\b[^$]*", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "meta.preprocessor.csharp" //$NON-NLS-0$
			},
			{include: "#string_verbatim"}, //$NON-NLS-0$
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
			{include: "#doc_line"}, //$NON-NLS-0$
			{include: "orion.c-like#comment_singleLine"}, //$NON-NLS-0$
			{include: "#doc_block"}, //$NON-NLS-0$
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
				name: "keyword.operator.csharp" //$NON-NLS-0$
			}
		],
		repository: {
			doc_block: {
				begin: {match: "/\\*\\*", literal: "/**"}, //$NON-NLS-1$ //$NON-NLS-0$
				end: {match: "\\*/", literal: "*/"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.block.documentation.csharp", //$NON-NLS-0$
				patterns: [
					{
						match: "<[^\\s>]*>", //$NON-NLS-0$
						name: "meta.documentation.tag" //$NON-NLS-0$
					}, {
						match: "(\\b)(TODO)(\\b)(((?!\\*/).)*)", //$NON-NLS-0$
						name: "meta.annotation.task.todo", //$NON-NLS-0$
						captures: {
							2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
							4: {name: "comment.block"} //$NON-NLS-0$
						}
					}
				]
			},
			doc_line: {
				match: {match: "// /.*", literal: "// /"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.line.documentation.csharp", //$NON-NLS-0$
				patterns: [
					{
						match: "<[^\\s>]*>", //$NON-NLS-0$
						name: "meta.documentation.tag" //$NON-NLS-0$
					}, {
						include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
					}
				]
			},
			string_verbatim: {
				begin: '@"', //$NON-NLS-0$
				end: '^(?:""|[^"])*"(?!")', //$NON-NLS-0$
				name: "string.quoted.verbatim.csharp", //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
