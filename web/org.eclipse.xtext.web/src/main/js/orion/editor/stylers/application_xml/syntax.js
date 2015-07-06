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

define("orion/editor/stylers/application_xml/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "orion.xml", //$NON-NLS-0$
		contentTypes: ["application/xml", "application/xhtml+xml"], //$NON-NLS-1$ //$NON-NLS-0$
		patterns: [
			{include: "#comment"}, //$NON-NLS-0$
			{include: "#doctype"}, //$NON-NLS-0$
			{include: "#xmlDeclaration"}, //$NON-NLS-0$
			{include: "#tag"}, //$NON-NLS-0$
			{include: "#ampersandEscape"} //$NON-NLS-0$
		],
		repository: {
			ampersandEscape: {
				match: "&lt;|&gt;|&amp;", //$NON-NLS-0$
				name: "constant.character" //$NON-NLS-0$
			},
			comment: {
				begin: {match: "<!--", literal: "<!--"}, //$NON-NLS-0$
				end: {match: "-->", literal: "-->"}, //$NON-NLS-0$
				name: "comment.block.xml", //$NON-NLS-0$
				patterns: [
					{
						match: "(\\b)(TODO)(\\b)(((?!-->).)*)", //$NON-NLS-0$
						name: "meta.annotation.task.todo", //$NON-NLS-0$
						captures: {
							2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
							4: {name: "comment.line"} //$NON-NLS-0$
						}
					}
				]
			},
			doctype: {
				begin: "<!(?:doctype|DOCTYPE)", //$NON-NLS-0$
				end: ">", //$NON-NLS-0$
				name: "meta.tag.doctype.xml", //$NON-NLS-0$
				captures: {
					0: {name: "meta.tag.doctype.xml"}, //$NON-NLS-0$
				},
				patterns: [
					{include: "#comment"}, //$NON-NLS-0$
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"} //$NON-NLS-0$
				]
			},
			tag: {
				begin: "</?[A-Za-z0-9]+", //$NON-NLS-0$
				end: "/?>", //$NON-NLS-0$
				captures: {
					0: {name: "meta.tag.xml"}, //$NON-NLS-0$
				},
				patterns: [
					{include: "#comment"}, //$NON-NLS-0$
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"} //$NON-NLS-0$
				]	
			},
			xmlDeclaration: {
				begin: "<\\?xml", //$NON-NLS-0$
				end: "\\?>", //$NON-NLS-0$
				captures: {
					0: {name: "meta.tag.declaration.xml"}, //$NON-NLS-0$
				},
				patterns: [
					{include: "#comment"}, //$NON-NLS-0$
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"} //$NON-NLS-0$
				],
				name: "meta.tag.declaration.xml" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: []
	};
});
