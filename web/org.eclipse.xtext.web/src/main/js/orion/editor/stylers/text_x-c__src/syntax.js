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
define("orion/editor/stylers/text_x-c__src/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"alignas", "alignof", "asm", "and_eq", "and", "auto", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"bitand", "bitor", "bool", "break", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"case", "catch", "char16_t", "char32_t", "char", "class", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"compl", "constexpr", "const_cast", "const", "continue", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"decltype", "default", "delete", "double", "do", "dynamic_cast", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"else", "enum", "explicit", "export", "extern", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"false", "float", "for", "friend", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"goto", //$NON-NLS-0$
		"if", "inline", "int", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"long", //$NON-NLS-0$
		"mutable", //$NON-NLS-0$
		"namespace", "new", "noexcept", "not_eq", "not", "nullptr", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"operator", "or_eq", "or", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"private", "protected", "public", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"register", "reinterpret_cast", "return", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"short", "signed", "sizeof", "static_assert", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"static_cast", "static", "struct", "switch", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"template", "this", "thread_local", "throw", "true", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"try", "typedef", "typeid", "typename", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"union", "unsigned", "using", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"virtual", "void", "volatile", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"wchar_t", "while", //$NON-NLS-1$ //$NON-NLS-0$
		"xor_eq", "xor", //$NON-NLS-1$ //$NON-NLS-0$
		"_Bool", "_Complex", "_Imaginary" //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];

	var directives = [
		"define", "elif", "else", "endif", "error", "ifdef", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"ifndef", "if", "include", "line", "pragma", "undef" //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.cpp", //$NON-NLS-0$
		contentTypes: ["text/x-c++src", "text/x-c++"], //$NON-NLS-1$ //$NON-NLS-0$
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
				name: "keyword.operator.cpp" //$NON-NLS-0$
			}
		],
		repository: {
			directive: {
				match: "#\\s*(?:" + directives.join("|") + ")\\b[^$]*", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "meta.preprocessor.cpp" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
