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

define("orion/editor/stylers/application_x-ejs/syntax", ["orion/editor/stylers/application_javascript/syntax", "orion/editor/stylers/application_xml/syntax"], //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	function(mJS, mXML) {

	var grammars = [];
	grammars.push.apply(grammars, mJS.grammars);
	grammars.push.apply(grammars, mXML.grammars);
	grammars.push({
		id: "orion.ejs", //$NON-NLS-0$
		contentTypes: ["application/x-ejs"], //$NON-NLS-0$
		patterns: [
			{include: "orion.xml#comment"}, //$NON-NLS-0$
			{include: "orion.xml#doctype"}, //$NON-NLS-0$
			{
				begin: "<%=?(?:\\s|$)", //$NON-NLS-0$
				end: "%>", //$NON-NLS-0$
				captures: {
					0: {name: "entity.name.declaration.js"} //$NON-NLS-0$
				},
				contentName: "source.js.embedded.ejs", //$NON-NLS-0$
				patterns: [
					{include: "orion.js"} //$NON-NLS-0$
				]
			},
			{include: "orion.xml#tag"}, //$NON-NLS-0$
			{include: "orion.xml#ampersandEscape"} //$NON-NLS-0$
		]
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: []
	};
});
