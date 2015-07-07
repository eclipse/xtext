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
define("orion/editor/stylers/application_xquery/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"zero-digit", //$NON-NLS-0$
		"xquery", //$NON-NLS-0$
		"window", "where", "when", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"version", "variable", "validate", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"unordered", "union", //$NON-NLS-1$ //$NON-NLS-0$
		"typeswitch", "type", "tumbling", "try", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"treat", "to", "then", "text", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"switch","strip", "strict", "start", "stable", "some", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"sliding", "self", "schema-element", "schema-attribute", "schema", "satisfies", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"return", //$NON-NLS-0$
		"processing-instruction", "previous", "preserve", "preceding-sibling", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"preceding", "percent", "per-mille", "pattern-separator", "parent", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"ordering", "order", "or", "option", "only", "of", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"node", "no-preserve", "no-inherit", "next", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"ne", "NaN", "namespace-node", "namespace", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"module", "mod", "minus-sign", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"lt", "let", "least", "le", "lax", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"item", "is", "intersect", "instance", "inherit", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"infinity", "in", "import", "if", "idiv", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"gt", "grouping-separator", "group", "greatest", "ge", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"function", "for", "following-sibling", "following", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"external", "except", "every", "eq", "end", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"encoding", "empty-sequence", "empty", "else", "element", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"document-node", "div", "digit", "descending", "descendant-or-self", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"descendant", "default", "declare", "decimal-separator", "decimal-format", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"count", "copy-namespaces", "context", "construction", "comment", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"collation", "child", "catch", "castable", "cast", "case", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"by", "boundary-space", "base-uri", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"attribute", "at", "ascending", "as", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"and", "ancestor-or-self", "ancestor", "allowing" //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.xquery", //$NON-NLS-0$
		contentTypes: ["application/xquery"], //$NON-NLS-0$ // Connection to xqueryPlugin.js
		patterns: [
			{include: "#comment"},
			{include: "#variable"},
			{include: "#multiLineDoubleQuote"}, 
			{include: "#multiLineSingleQuote"}, 
			{include: "orion.xml#tag"}, 
			{include: "orion.lib#brace_open"}, //$NON-NLS-0$
			{include: "orion.lib#brace_close"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_open"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_close"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_open"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_close"}, //$NON-NLS-0$
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.js" //$NON-NLS-0$
			}
		],
		repository: {
			comment: {
				begin: {match: "\\(:", literal: "(:"}, //$NON-NLS-0$
				end: {match: ":\\)", literal: ":)"}, //$NON-NLS-0$ 
				name: "comment.block.xquery", //$NON-NLS-0$
				patterns: [
					{
						match: "(\\b)(TODO)(\\b)(((?!:\\)).)*)", //$NON-NLS-0$ // match: "(\\b)(TODO)(\\b)(((?!-->).)*)", //$NON-NLS-0$
						name: "meta.annotation.task.todo", //$NON-NLS-0$
						captures: {
							2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
							4: {name: "comment.block"} //$NON-NLS-0$
						}
					}
				]
			},
			variable: {
				match: "\\$[a-zA-z0-9_]+",
				name: "variable.other.xquery" 
			},
			multiLineDoubleQuote: {
				begin: "\"",
				end: "\"",
				name: "string.quoted.double"
			},
			multiLineSingleQuote: {
				begin: "\'",
				end: "\'",
				name: "string.quoted.single"
			}
		}

	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
