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
define("orion/editor/stylers/text_x-vbhtml/syntax", [
	"orion/editor/stylers/application_xml/syntax",
	"orion/editor/stylers/text_html/syntax",
	"orion/editor/stylers/text_x-vb/syntax"], function(mXML, mHTML, mVB) { //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$

	var grammars = [];
	grammars.push.apply(grammars, mXML.grammars);
	grammars.push.apply(grammars, mHTML.grammars);
	grammars.push.apply(grammars, mVB.grammars);
	grammars.push({
		id: "orion.vbhtml", //$NON-NLS-0$
		contentTypes: ["text/x-vbhtml"], //$NON-NLS-0$
		patterns: [
			{include: "#vbhtmlComment"}, //$NON-NLS-0$
			{include: "#codeBlock"}, //$NON-NLS-0$
			{include: "#expression"}, //$NON-NLS-0$
			{include: "#reference"}, //$NON-NLS-0$
			{include: "orion.html"}, //$NON-NLS-0$
		],
		repository: {
			vbhtmlComment: {
				begin: {match: "@\\*", literal: "@*"}, //$NON-NLS-1$ //$NON-NLS-0$
				end: {match: "\\*@", literal: "*@"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.block.vbhtml", //$NON-NLS-0$
			},
			codeBlock: {
				begin: "(?i)^\\s*@code", //$NON-NLS-0$
				end: "(?i)end code", //$NON-NLS-0$
				captures: {
					0: {name: "entity.name.declaration.vb"} //$NON-NLS-0$
				},
				contentName: "source.vb.embedded.vbhtml", //$NON-NLS-0$
				patterns: [
				    {include: "orion.xml#tag"}, //$NON-NLS-0$
				    {include: "#reference"}, //$NON-NLS-0$
					{include: "orion.vb"}, //$NON-NLS-0$
				]
			},
			expression: {
				match: "(?i)^\\s*@(?!code)[^$]*", //$NON-NLS-0$
				patterns: [
				    {include: "#reference"}, //$NON-NLS-0$
					{include: "orion.vb"}, //$NON-NLS-0$
				]
			},
			reference: {
				match: "@", //$NON-NLS-0$
				name: "entity.name.declaration.vb" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: []
	};
});
