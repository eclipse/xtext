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
define("orion/editor/stylers/text_x-dockerfile/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"add", //$NON-NLS-0$
		"cmd", "copy", //$NON-NLS-1$ //$NON-NLS-0$
		"entrypoint", "env", "expose", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"from", //$NON-NLS-0$
		"maintainer", //$NON-NLS-0$
		"onbuild", //$NON-NLS-0$
		"run", //$NON-NLS-0$
		"user", //$NON-NLS-0$
		"volume", //$NON-NLS-0$
		"workdir" //$NON-NLS-0$
	];

	var id = "orion.dockerfile"; //$NON-NLS-0$
	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: id,
		contentTypes: ["text/x-dockerfile"], //$NON-NLS-0$
		patterns: [
			{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
			{include: "#numberSignComment"}, //$NON-NLS-0$
			{
				match: "\\b-?[0-9]+(\\.[0-9]+)?\\b", //$NON-NLS-0$
				name: "constant.numeric.dockerfile" //$NON-NLS-0$
			}, {
				match: "(?i)^\\s*(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.dockerfile" //$NON-NLS-0$
			}
		],
		repository: {
			numberSignComment: {
				begin: {match: "^\\s*#", literal: "#"}, //$NON-NLS-1$ //$NON-NLS-0$
				end: {match: "$", literal: ""}, //$NON-NLS-0$
				name: "comment.line.number-sign.dockerfile", //$NON-NLS-0$
				patterns: [
					{include: "orion.lib#todo_comment_singleLine"} //$NON-NLS-0$
				]
			}
		}
	});

	return {
		id: id,
		grammars: grammars,
		keywords: keywords
	};
});
