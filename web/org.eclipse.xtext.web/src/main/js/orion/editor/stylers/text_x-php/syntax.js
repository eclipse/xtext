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
define("orion/editor/stylers/text_x-php/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-0$
	var keywords = [
		"abstract", "and", "array", "as", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"callable", "class", "clone", "const", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"declare", //$NON-NLS-0$
		"echo", "empty", "eval", "extends", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"final", "function", //$NON-NLS-1$ //$NON-NLS-0$
		"global", //$NON-NLS-0$
		"implements", "include", "include_once", "insteadof", "interface", "instanceof", "isset", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"list", //$NON-NLS-0$
		"namespace", "new", //$NON-NLS-1$ //$NON-NLS-0$
		"or", //$NON-NLS-0$
		"parent", "print", "private", "protected", "public", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"require", "require_once", //$NON-NLS-1$ //$NON-NLS-0$
		"static", //$NON-NLS-0$
		"trait", //$NON-NLS-0$
		"unset", "use", //$NON-NLS-1$ //$NON-NLS-0$
		"var", //$NON-NLS-0$
		"xor", //$NON-NLS-0$
		"__halt_compiler", "__CLASS__", "__DIR__", "__FILE__", "__FUNCTION__",  //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"__LINE__", "__METHOD__", "__NAMESPACE__", "__TRAIT__"  //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];
	var controlKeywords = [
		"break", //$NON-NLS-0$
		"case", "catch", "continue", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"default", "die", "do", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"else", "elseif", "enddeclare", "endfor", "endforeach", "endif", "endswitch", "endwhile", "exit", //$NON-NLS-8$ //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"finally", "for", "foreach", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"goto", //$NON-NLS-0$
		"if", //$NON-NLS-0$
		"return", //$NON-NLS-0$
		"switch", //$NON-NLS-0$
		"throw", "try", //$NON-NLS-1$ //$NON-NLS-0$
		"while", //$NON-NLS-0$
		"yield" //$NON-NLS-0$
	];
	var constants = [
		"false", "FALSE", "null", "NULL", "true", "TRUE" //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];
	var languageVariables = ["self"]; //$NON-NLS-0$

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.php", //$NON-NLS-0$
		contentTypes: ["text/x-php"], //$NON-NLS-0$
		patterns: [
			{
				begin: "(?i)<(\\?|%(?!php))(?:=|php)?(?:\\s|$)", //$NON-NLS-0$
				end: "[\\1]>", //$NON-NLS-0$
				captures: {
					0: {name: "entity.name.declaration.php"} //$NON-NLS-0$
				},
				contentName: "source.php.embedded", //$NON-NLS-0$
				patterns: [
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
					{include: "orion.c-like#comment_singleLine"}, //$NON-NLS-0$
					{include: "orion.lib#doc_block"}, //$NON-NLS-0$
					{include: "orion.c-like#comment_block"}, //$NON-NLS-0$
					{
						match: {match: "#.*", literal: "#"}, //$NON-NLS-0$
						name: "comment.line.number-sign.php", //$NON-NLS-0$
						patterns: [
							{include: "orion.lib#todo_comment_singleLine"} //$NON-NLS-0$
						]
					}, {
						begin: "<<<(\\w+)$", //$NON-NLS-0$
						end: "^\\1;$", //$NON-NLS-0$
						name: "string.unquoted.heredoc.php" //$NON-NLS-0$
					}, {
						begin: "<<<'(\\w+)'$", //$NON-NLS-0$
						end: "^\\1;$", //$NON-NLS-0$
						name: "string.unquoted.heredoc.nowdoc.php" //$NON-NLS-0$
					},
					{include: "orion.lib#brace_open"}, //$NON-NLS-0$
					{include: "orion.lib#brace_close"}, //$NON-NLS-0$
					{include: "orion.lib#bracket_open"}, //$NON-NLS-0$
					{include: "orion.lib#bracket_close"}, //$NON-NLS-0$
					{include: "orion.lib#parenthesis_open"}, //$NON-NLS-0$
					{include: "orion.lib#parenthesis_close"}, //$NON-NLS-0$
					{include: "orion.lib#operator"}, //$NON-NLS-0$
					{
						match: "\\b0[bB][01]+\\b", //$NON-NLS-0$
						name: "constant.numeric.binary.php" //$NON-NLS-0$
					},
					{include: "orion.lib#number_decimal"}, //$NON-NLS-0$
					{include: "orion.lib#number_hex"}, //$NON-NLS-0$
					{
						match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
						name: "keyword.operator.php" //$NON-NLS-0$
					},
					{
						match: "\\b(?:" + controlKeywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
						name: "keyword.control.php" //$NON-NLS-0$
					},
					{
						match: "\\b(?:" + constants.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
						name: "constant.language.php" //$NON-NLS-0$
					},
					{
						match: "\\b(?:" + languageVariables.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
						name: "variable.language.php" //$NON-NLS-0$
					}
				]
			}, {
				include: "orion.html" //$NON-NLS-0$
			}
		]
	});

	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords.concat(controlKeywords).concat(constants).concat(languageVariables)
	};
});
