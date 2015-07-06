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
define("orion/editor/stylers/text_x-lua/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	// from http://www.lua.org/ftp/refman-5.0.pdf
	var keywords = [
		"and", //$NON-NLS-0$
		"break", //$NON-NLS-0$
		"do", //$NON-NLS-0$
		"else", "elseif", "end", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"false", "for", "function", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"if", "in", //$NON-NLS-1$ //$NON-NLS-0$
		"local", //$NON-NLS-0$
		"nil", "not", //$NON-NLS-1$ //$NON-NLS-0$
		"or", //$NON-NLS-0$
		"repeat", "return", //$NON-NLS-1$ //$NON-NLS-0$
		"then", "true", //$NON-NLS-1$ //$NON-NLS-0$
		"until", //$NON-NLS-0$
		"while", //$NON-NLS-0$
	];

	// base library functions and variables
	// from http://lua-users.org/files/wiki_insecure/users/thomasl/luarefv51.pdf
	var base_functions = [
		"assert", "arg", //$NON-NLS-1$ //$NON-NLS-0$
		"collectgarbage", //$NON-NLS-0$
		"dofile", //$NON-NLS-0$
		"error", //$NON-NLS-0$
		"getfenv", "getmetatable", //$NON-NLS-1$ //$NON-NLS-0$
		"ipairs", //$NON-NLS-0$
		"load", "loadfile", "loadstring", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"next", //$NON-NLS-0$
		"pairs", "pcall", "print", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"rawequal", "rawget", "rawset", "require", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"select", "setfenv", "setmetatable", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"tonumber", "tostring", "type", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"unpack", //$NON-NLS-0$
		"xpcall" //$NON-NLS-0$
	];
	var base_variables = [
		"_G", //$NON-NLS-0$
		"LUA_INIT", "LUA_PATH", "LUA_CPATH", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"_VERSION" //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.lua", //$NON-NLS-0$
		contentTypes: ["text/x-luasrc", "text/x-lua"], //$NON-NLS-1$ //$NON-NLS-0$
		patterns: [
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
			{include: "orion.c-like#comment_singleLine"}, //$NON-NLS-0$
			{include: "#comment_block_dash_dash"}, //$NON-NLS-0$
			{include: "#comment_singleLine_dash_dash"}, //$NON-NLS-0$
			{include: "orion.lib#brace_open"}, //$NON-NLS-0$
			{include: "orion.lib#brace_close"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_open"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_close"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_open"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_close"}, //$NON-NLS-0$
			{include: "orion.lib#operator"}, //$NON-NLS-0$
			{include: "orion.lib#number_decimal"}, //$NON-NLS-0$
			{include: "orion.lib#number_hex"}, //$NON-NLS-0$
			{include: "#base_functions"}, //$NON-NLS-0$
			{include: "#base_variables"}, //$NON-NLS-0$
			{include: "#reserved_underscore_capital"}, //$NON-NLS-0$
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.lua" //$NON-NLS-0$
			}
		],
		repository: {
			comment_block_dash_dash: {
				begin: {match: "--\\[\\[", literal: "--[["}, //$NON-NLS-1$ //$NON-NLS-0$
				end: {match: "\\]\\]", literal: "]]"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.block.dash-dash.lua", //$NON-NLS-0$
				patterns: [
					{
						match: "(\\b)(TODO)(\\b)(((?!\\]\\]).)*)", //$NON-NLS-0$
						name: "meta.annotation.task.todo", //$NON-NLS-0$
						captures: {
							2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
							4: {name: "comment.block"} //$NON-NLS-0$
						}
					}
				]
			},
			comment_singleLine_dash_dash: {
				begin: {match: "--", literal: "--"}, //$NON-NLS-1$ //$NON-NLS-0$
				end: {match: "$", literal: ""}, //$NON-NLS-0$
				name: "comment.line.dash-dash.lua", //$NON-NLS-0$
				patterns: [
					{
						include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
					}
				]
			},
			base_functions: {
				match: "\\b(?:" + base_functions.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "support.function.lua" //$NON-NLS-0$
			},
			base_variables: {
				match: "\\b(?:" + base_variables.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "support.variable.lua" //$NON-NLS-0$
			},
			// _ANYCAPITALS is reserved in Lua
			reserved_underscore_capital: {
				match: "\\b_[A-Z]*\\b", //$NON-NLS-0$
				name: "constant.other.userdefined.lua" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
