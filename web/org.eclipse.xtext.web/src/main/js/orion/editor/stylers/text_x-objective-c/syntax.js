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
define("orion/editor/stylers/text_x-objective-c/syntax", ["orion/editor/stylers/text_x-csrc/syntax"], function(mC) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"atomic", //$NON-NLS-0$
		"BOOL", "bycopy", "byref", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"Class", //$NON-NLS-0$
		"id", "IMP", "inout", "in", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"nil", "nonatomic", "NO", "NULL", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"oneway", "out", //$NON-NLS-1$ //$NON-NLS-0$
		"Protocol", //$NON-NLS-0$
		"retain", //$NON-NLS-0$
		"SEL", "self", "super", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"YES" //$NON-NLS-0$
	];

	var atKeywords = [
		"@catch", "@class", //$NON-NLS-1$ //$NON-NLS-0$
		"@dynamic", //$NON-NLS-0$
		"@end", //$NON-NLS-0$
		"@finally", //$NON-NLS-0$
		"@implementation", "@interface", //$NON-NLS-1$ //$NON-NLS-0$
		"@private", "@property", "@protected", "@protocol", "@public", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"@selector", //$NON-NLS-0$
		"@synthesize", //$NON-NLS-0$
		"@throw", "@try" //$NON-NLS-1$ //$NON-NLS-0$
	];

	var directives = ["import"]; //$NON-NLS-0$

	var grammars = [];
	grammars.push.apply(grammars, mC.grammars);
	grammars.push({
		id: "orion.objectiveC", //$NON-NLS-0$
		contentTypes: ["text/x-objective-c"], //$NON-NLS-0$
		patterns: [
			{include: "#objectiveCString"}, //$NON-NLS-0$
			{include: "orion.c"}, //$NON-NLS-0$
			{include: "#objectiveCDirective"}, //$NON-NLS-0$
			{include: "#objectiveCKeyword"} //$NON-NLS-0$
		],
		repository: {
			objectiveCDirective: {
				match: "#\\s*(?:" + directives.join("|") + ")\\b[^$]*", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "meta.preprocessor.objective-c" //$NON-NLS-0$
			},
			objectiveCKeyword: {
				match: "(\\b(?:" + keywords.join("|") + ")|(?:" + atKeywords.join("|") + "))\\b", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.operator.objective-c" //$NON-NLS-0$
			},
			objectiveCString: {
				match: '@"(?:\\\\.|[^"])*"?', //$NON-NLS-0$
				name: "string.quoted.double.objective-c" //$NON-NLS-0$
			},
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: mC.keywords.concat(keywords).concat(directives).concat(atKeywords)
	};
});
