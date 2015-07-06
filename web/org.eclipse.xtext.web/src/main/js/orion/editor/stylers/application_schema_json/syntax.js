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

define("orion/editor/stylers/application_schema_json/syntax", ["orion/editor/stylers/application_json/syntax"], function(mJSON) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"additionalItems", "additionalProperties", "allOf", "anyOf", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"default", "definitions", "dependencies", "description", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"enum", "exclusiveMaximum", "exclusiveMinimum", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"format", //$NON-NLS-0$
		"id", //$NON-NLS-0$
		"maximum", "maxItems", "maxLength", "maxProperties", "minimum", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"minItems", "minLength", "minProperties", "multipleOf", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"not", //$NON-NLS-0$
		"oneOf", //$NON-NLS-0$
		"patternProperties", "pattern", "properties", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"required", //$NON-NLS-0$
		"title", "type", //$NON-NLS-1$ //$NON-NLS-0$
		"uniqueItems" //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mJSON.grammars);
	grammars.push({
		id: "orion.json.schema", //$NON-NLS-0$
		contentTypes: ["application/schema+json"], //$NON-NLS-0$
		patterns: [
			{include: "orion.json"}, //$NON-NLS-0$
			{
				match: "(?:\\$schema|(?:\\b(?:" + keywords.join("|") + ")))\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.schema.json" //$NON-NLS-0$
			}
		]
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
