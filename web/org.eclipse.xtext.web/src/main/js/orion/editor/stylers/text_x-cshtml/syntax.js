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
define("orion/editor/stylers/text_x-cshtml/syntax", [
	"orion/editor/stylers/application_xml/syntax",
	"orion/editor/stylers/text_html/syntax",
	"orion/editor/stylers/text_x-csharp/syntax"], function(mXML, mHTML, mCSharp) { //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$

	var grammars = [];
	grammars.push.apply(grammars, mXML.grammars);
	grammars.push.apply(grammars, mHTML.grammars);
	grammars.push.apply(grammars, mCSharp.grammars);
	grammars.push({
		id: "orion.cshtml", //$NON-NLS-0$
		contentTypes: ["text/x-cshtml"], //$NON-NLS-0$
		patterns: [
			{include: "#comment"}, //$NON-NLS-0$
			{include: "#codeBlock"}, //$NON-NLS-0$
			{include: "#expression"}, //$NON-NLS-0$
			{include: "#reference"}, //$NON-NLS-0$
			{include: "orion.html"}, //$NON-NLS-0$
		],
		repository: {
			comment: {
				begin: {match: "@\\*", literal: "@*"}, //$NON-NLS-1$ //$NON-NLS-0$
				end: {match: "\\*@", literal: "*@"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.block.cshtml", //$NON-NLS-0$
			},
			codeBlock: {
				begin: "(^\\s*)(@)(?=([^{]*){)", //$NON-NLS-0$
				end: "}", //$NON-NLS-0$
				captures: {
					2: {name: "entity.name.declaration.csharp"} //$NON-NLS-0$
				},
				contentName: "source.csharp.embedded.cshtml", //$NON-NLS-0$
				patterns: [
				    {include: "orion.xml#tag"}, //$NON-NLS-0$
				    {include: "#reference"}, //$NON-NLS-0$
					{include: "orion.csharp"}, //$NON-NLS-0$
				]
			},
			expression: {
				match: "^\\s*@[^{]*$", //$NON-NLS-0$
				patterns: [
				    {include: "#reference"}, //$NON-NLS-0$
					{include: "orion.csharp"}, //$NON-NLS-0$
				]
			},
			reference: {
				match: "@", //$NON-NLS-0$
				name: "entity.name.declaration.csharp" //$NON-NLS-0$
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: []
	};
});
