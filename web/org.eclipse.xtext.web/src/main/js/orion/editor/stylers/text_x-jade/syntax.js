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
define("orion/editor/stylers/text_x-jade/syntax", ["orion/editor/stylers/lib/syntax", "orion/editor/stylers/application_javascript/syntax"], function(mLib, mJS) { //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"&attributes", //$NON-NLS-0$
		"block", //$NON-NLS-0$
		"case", //$NON-NLS-0$
		"default", "doctype", //$NON-NLS-1$ //$NON-NLS-0$
		"each", "else", "extends", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"for", //$NON-NLS-0$
		"if", "include",
		"mixin", //$NON-NLS-0$
		"unless", //$NON-NLS-0$
		"when", "while" //$NON-NLS-1$ //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push.apply(grammars, mJS.grammars);
	grammars.push({
		id: "orion.jade", //$NON-NLS-0$
		contentTypes: ["text/x-jade"], //$NON-NLS-0$
		patterns: [
			{include: "#comment_singleLine"}, //$NON-NLS-0$
			{include: "#code"}, //$NON-NLS-0$
			{include: "#control"}, //$NON-NLS-0$
			{include: "#caseBranch"}, //$NON-NLS-0$
			{include: "#mixinWithParameters"}, //$NON-NLS-0$
			{include: "#mixinRefWithArguments"}, //$NON-NLS-0$
			{include: "#tagWithAttributes"}, //$NON-NLS-0$
			{include: "#interpolatedJS"}, //$NON-NLS-0$
			{include: "#interpolatedTag"}, //$NON-NLS-0$
			{include: "#mixin"}, //$NON-NLS-0$
			{include: "#mixinRef"}, //$NON-NLS-0$
			{include: "#doctype"}, //$NON-NLS-0$
			{include: "#filter"}, //$NON-NLS-0$
			{include: "#case"}, //$NON-NLS-0$
			{include: "#andAttributes"}, //$NON-NLS-0$
			{include: "#otherKeywords"}, //$NON-NLS-0$
			{include: "#tag"}, //$NON-NLS-0$
		],
		repository: {
			andAttributes: {
				match: "&attributes\\b", //$NON-NLS-0$
				name: "keyword.operator.jade" //$NON-NLS-0$
			},
			"case": { //$NON-NLS-0$
				match: "(^\\s*)(case)\\b", //$NON-NLS-0$
				captures: {
					2: {name: "keyword.control.jade"} //$NON-NLS-0$
				}				
			},
			caseBranch: {
				begin: "(^\\s*)(when|default)\\s*", //$NON-NLS-0$
				end: ":|$", //$NON-NLS-0$
				patterns: [
					{include: "orion.js"} //$NON-NLS-0$
				],
				beginCaptures: {
					2: {name: "keyword.control.jade"} //$NON-NLS-0$
				},
			},
			code: {
				match: "(^\\s*- |= |!= ).*$", //$NON-NLS-0$
				patterns: [
					{include: "orion.js"} //$NON-NLS-0$
				]
			},
			comment_singleLine: {
				match: {match: "^\\s*//.*", literal: "//"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.line.double-slash.jade", //$NON-NLS-0$
				patterns: [
					{
						include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
					}
				]
			},
			control: {
				begin: "(^\\s*)(if|else( if)?|each|for|unless|while)\\b", //$NON-NLS-0$
				end: "$", //$NON-NLS-0$
				beginCaptures: {
					2: {name: "keyword.control.jade"} //$NON-NLS-0$
				},
				patterns: [
					{include: "orion.js"} //$NON-NLS-0$
				]
			},
			doctype: {
				match: "(^\\s*)(doctype.+$)", //$NON-NLS-0$
				captures: {
					2: {name: "meta.tag.doctype.jade"} //$NON-NLS-0$
				}
			},
			filter: {
				match: "(^\\s*)(:\\w+)", //$NON-NLS-0$
				captures: {
					2: {name: "entity.other.filter.jade"} //$NON-NLS-0$
				}
			},
			interpolatedJS: {
				begin: "(#{)", //$NON-NLS-0$
				end: "(})", //$NON-NLS-0$
				captures: {
					1: {name: "string.interpolated.js.jade"} //$NON-NLS-0$
				},
				patterns: [
					{include: "orion.js"} //$NON-NLS-0$
				]
			},
			interpolatedTag: {
				begin: "(#\\[)", //$NON-NLS-0$
				end: "(\\])", //$NON-NLS-0$
				captures: {
					1: {name: "string.interpolated.tag.jade"} //$NON-NLS-0$
				},
				patterns: [
					{
						begin: "(\\.|\\w+)\\s*\\(", //$NON-NLS-0$
						end: "(\\))(/)?", //$NON-NLS-0$
						beginCaptures: {
							1: {name: "meta.tag.jade"} //$NON-NLS-0$
						},
						endCaptures: {
							2: {name: "meta.tag.jade"} //$NON-NLS-0$
						},
						patterns: [
							{include: "orion.js"} //$NON-NLS-0$
						]
					}
				]
			},
			mixin: {
				match: "(^\\s*)(mixin)(\\s+)(\\w+)", //$NON-NLS-0$
				captures: {
					2: {name: "keyword.operator.jade"}, //$NON-NLS-0$
					4: {name: "entity.name.mixin.jade"} //$NON-NLS-0$
				}
			},
			mixinRef: {
				match: "(^\\s*)(\\+\\w+)", //$NON-NLS-0$
				captures: {
					2: {name: "entity.name.mixin.jade"} //$NON-NLS-0$
				}
			},
			mixinRefWithArguments: {
				begin: "(^\\s*)(\\+\\w+)\\s*\\(", //$NON-NLS-0$
				end: "\\)|$", //$NON-NLS-0$
				captures: {
					2: {name: "entity.name.mixin.jade"} //$NON-NLS-0$
				},
				patterns: [
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#number_decimal"} //$NON-NLS-0$
				]
			},
			mixinWithParameters: {
				begin: "(^\\s*)(mixin)(\\s+)(\\w+)\\s*\\(", //$NON-NLS-0$
				end: "\\)|$", //$NON-NLS-0$
				beginCaptures: {
					2: {name: "keyword.operator.jade"}, //$NON-NLS-0$
					4: {name: "entity.name.mixin.jade"} //$NON-NLS-0$
				},
				patterns: [
					{
						match: "[^\\s,]+", //$NON-NLS-0$
						name: "variable.parameter.jade" //$NON-NLS-0$
					}	
				]
			},
			otherKeywords: {
				match: "(^\\s*)(block|extends|include)\\b", //$NON-NLS-0$
				captures: {
					2: {name: "keyword.operator.jade"} //$NON-NLS-0$
				}
			},
			tag: {
				match: "(^\\s*)(\\w+|(?=\\.)|(?=#))(#\\w*|\\.\\w*)*(/?)", //$NON-NLS-0$
				captures: {
					2: {name: "meta.tag.jade"}, //$NON-NLS-0$
					4: {name: "meta.tag.jade"} //$NON-NLS-0$
				}
			},
			tagWithAttributes: {
				begin: "(^\\s*)(\\w+|(?=\\.)|(?=#))(#\\w*|\\.\\w*)*\\s*\\(", //$NON-NLS-0$
				end: "(\\))(/)?", //$NON-NLS-0$
				beginCaptures: {
					2: {name: "meta.tag.jade"} //$NON-NLS-0$
				},
				endCaptures: {
					2: {name: "meta.tag.jade"} //$NON-NLS-0$
				},
				patterns: [
					{include: "orion.js"} //$NON-NLS-0$
				]
			}
		}
	});

	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
