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
define("orion/editor/stylers/text_x-vb/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
	    "AddHandler", "AddressOf", "Aggregate", "Alias", "AndAlso", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "And", "Ansi", "Assembly", "Async", "As", "Auto", "Await", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Binary", "Boolean", "ByRef", "Byte", "ByVal", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Call", "Case", "Catch", "CBool", "CByte", "CChar", "CDate", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "CDbl", "CDec", "Char", "CInt", "Class", "CLng", "CObj", "Compare", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Const", "CShort", "CSng", "CStr", "CType", "Custom", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Date", "Decimal", "Declare", "Default", "Delegate", "Dim", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "DirectCast", "Distinct", "Double", "Do", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Each", "ElseIf", "Else", "EndIf", "End", "Enum", "Equals", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Erase", "Error", "Event", "Exit", "Explicit", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "False", "Finally", "For", "Friend", "From", "Function", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "GetType", "Get", "GoSub", "GoTo", "Group By", "Group Join", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Handles", //$NON-NLS-0$
	    "If", "Implements", "Imports", "Inherits", "Integer", "Interface", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Into", "In", "IsFalse", "IsTrue", "Is", "Iterator", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Join", //$NON-NLS-5$
	    "Key", //$NON-NLS-5$
	    "Let", "Lib", "Like", "Long", "Loop", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Me", "Mid", "Module", "Mod", "MustInherit", "MustOverride", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "MyBase", "MyClass", //$NON-NLS-1$ //$NON-NLS-0$
	    "Namespace", "New", "Next", "Nothing", "NotInheritable", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "NotOverridable", "Not", //$NON-NLS-1$ //$NON-NLS-0$
	    "Object", "Off", "On", "Optional", "Option", "Order By", "OrElse", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Or", "Overloads", "Overridable", "Overrides", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "ParamArray", "Preserve", "Private", "Property", "Protected", "Public", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "RaiseEvent", "ReadOnly", "ReDim", "REM", "RemoveHandler", "Resume", "Return", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Select", "Set", "Shadows", "Shared", "Short", "Single", "Skip While", "Skip", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Static", "Step", "Stop", "Strict", "String", "Structure", "Sub", "SyncLock", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Take While", "Take", "Text", "Then", "Throw", "To", "True", "Try", "TypeOf", //$NON-NLS-8$ //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Unicode", "Until", //$NON-NLS-1$ //$NON-NLS-0$
	    "Variant", //$NON-NLS-0$
	    "Wend", "When", "Where", "While", "WithEvents", "With", "WriteOnly", //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	    "Xor", //$NON-NLS-0$
	    "Yield" //$NON-NLS-0$
	];

	var preprocessorDirectives = ["Const", "ElseIf", "Else", "End", "ExternalSource", "If", "Region"]; //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.vb", //$NON-NLS-0$
		contentTypes: ["text/x-vb"], //$NON-NLS-0$
		patterns: [
			{
				match: "^\\s*#(?:" + preprocessorDirectives.join("|") + ")\\b[^$]*", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "meta.preprocessor.vb" //$NON-NLS-0$
			},
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "#doc"}, //$NON-NLS-0$
			{include: "#comment"}, //$NON-NLS-0$
			{include: "orion.lib#brace_open"}, //$NON-NLS-0$
			{include: "orion.lib#brace_close"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_open"}, //$NON-NLS-0$
			{include: "orion.lib#bracket_close"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_open"}, //$NON-NLS-0$
			{include: "orion.lib#parenthesis_close"}, //$NON-NLS-0$
			{include: "orion.lib#operator"}, //$NON-NLS-0$
			{include: "orion.lib#number_decimal"}, //$NON-NLS-0$
			{include: "#number_hex"}, //$NON-NLS-0$
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.vb" //$NON-NLS-0$
			}
		],
		repository: {
			comment: {
				begin: {match: "'", literal: "'"}, //$NON-NLS-1$ //$NON-NLS-0$
				end: {match: "$", literal: ""}, //$NON-NLS-0$
				name: "comment.line.vb", //$NON-NLS-0$
				patterns: [
					{
						include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
					}
				]
			},
			doc: {
				match: {match: "'''.*", literal: "'''"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.line.documentation.vb", //$NON-NLS-0$
				patterns: [
					{
						match: "<[^\\s>]*>", //$NON-NLS-0$
						name: "meta.documentation.tag" //$NON-NLS-0$
					}, {
						include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
					}
				]
			},
			number_hex: {
				match: "&[hH][0-9A-Fa-f]+\\b", //$NON-NLS-0$
				name: "constant.numeric.hex.vb" //$NON-NLS-0$
			},
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
