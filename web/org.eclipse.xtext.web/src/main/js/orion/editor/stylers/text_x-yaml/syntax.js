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
define("orion/editor/stylers/text_x-yaml/syntax", [], function() { //$NON-NLS-0$
	var keywords = ["false", "null", "true"]; //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	var casts = ["!!bool", "!!float", "!!int", "!!map", "!!null", "!!omap", "!!seq", "!!str"]; //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$

	var id = "orion.yaml"; //$NON-NLS-0$
	var grammar = {
		id: id,
		contentTypes: ["text/x-yaml"], //$NON-NLS-0$
		patterns: [
			{include: "#numberSignComment"}, //$NON-NLS-0$
			{
				match: "^%(?:YAML|TAG)\\s.*", //$NON-NLS-0$
				name: "meta.directive.yaml" //$NON-NLS-0$
			}, {
				begin: "^.*?:(?:[\\t ]|$)", //$NON-NLS-0$
				end: "$", //$NON-NLS-0$
				contentName: "string.unquoted.yaml", //$NON-NLS-0$
				beginCaptures: {
					0: {
						name: "entity.name.key.yaml"
					}
				},
				patterns: [
					{include: "#numberSignComment"}, //$NON-NLS-0$
					{
						match: "^\\s*[&*]\\s*$", //$NON-NLS-0$
						name: "entity.name.tag.yaml" //$NON-NLS-0$
					}, {
						match: "(?i)^\\s*(?:" + keywords.join("|") + ")\\s*$", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
						name: "keyword.operator.yaml" //$NON-NLS-0$
					}, {
						match: "(?i)^\\s*(?:" + casts.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
						name: "keyword.operator.yaml" //$NON-NLS-0$
					}, {
						match: "(?i)^\\s*(?:-?[0-9]*(?:\\.[0-9]+)?(?:e[-+][1-9][0-9]*)?)\\s*$", //$NON-NLS-0$
						name: "constant.numeric.yaml" //$NON-NLS-0$
					}, {
						match: "(?i)^\\s*(?:-?[1-9][0-9]*|0|-?\\.inf|\\.nan)\\s*$", //$NON-NLS-0$
						name: "constant.numeric.yaml" //$NON-NLS-0$
					}
				]
			}, {
				match: "---|\\.\\.\\.", //$NON-NLS-0$
				name: "meta.separator.yaml" //$NON-NLS-0$
			}
		],
		repository: {
			numberSignComment: {
				begin: {match: "(?:^|\\s)#", literal: "#"}, //$NON-NLS-0$
				end: {match: "$", literal: ""}, //$NON-NLS-0$
				name: "comment.line.number-sign.yaml", //$NON-NLS-0$
				patterns: [
					{include: "orion.lib#todo_comment_singleLine"} //$NON-NLS-0$
				]
			}
		}
	};

	return {
		id: id,
		grammars: [grammar],
		keywords: casts.concat(keywords)
	};
});
