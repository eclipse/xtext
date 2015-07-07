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
define("orion/editor/stylers/text_x-haml/syntax", ["orion/editor/stylers/lib/syntax", "orion/editor/stylers/text_x-ruby/syntax"], //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	function(mLib, mRuby) {

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push.apply(grammars, mRuby.grammars);
	grammars.push({
		id: "orion.haml", //$NON-NLS-0$
		contentTypes: ["text/x-haml"], //$NON-NLS-0$
		patterns: [
			{include: "#inlineRuby"}, //$NON-NLS-0$
			{include: "#interpolatedRuby"}, //$NON-NLS-0$
			{include: "#tagWithRubySymbols"}, //$NON-NLS-0$
			{include: "#tagWithHTMLAttributes"}, //$NON-NLS-0$
			{include: "#doctype"}, //$NON-NLS-0$
			{include: "#tag"}, //$NON-NLS-0$
			{include: "#htmlComment"}, //$NON-NLS-0$
			{include: "#hamlComment"}, //$NON-NLS-0$
		],
		repository: {
			doctype: {
				match: "^!!!.*$", //$NON-NLS-0$
				name: "meta.tag.doctype.haml", //$NON-NLS-0$
			},
			hamlComment: {
				// TODO multi-line comments
				match: {match: "\\-#.*$", literal: "-#"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.line.haml", //$NON-NLS-0$
				patterns: [
					{
						include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
					}
				]
			},
			htmlComment: {
				// TODO multi-line comments
				match: "/[^[].*$", //$NON-NLS-0$
				name: "comment.line.html.haml" //$NON-NLS-0$
			},
			inlineRuby: {
				// TODO end match should not eat the last content character, really need a negative look-behind
				begin: "(?:^|[^\\\\])(?:=|-|~|&==?|!==?)", //$NON-NLS-0$
				end: "(?:^|[^,])$", //$NON-NLS-0$
				patterns: [
					{include: "orion.ruby"}, //$NON-NLS-0$
				]
			},
			interpolatedRuby: {
				begin: "#{", //$NON-NLS-0$
				end: "}", //$NON-NLS-0$
				patterns: [
					{include: "orion.ruby"}, //$NON-NLS-0$
				]
			},
			tag: {
				match: "^\\s*%[^\\b]+?\\b", //$NON-NLS-0$
				name: "meta.tag.haml", //$NON-NLS-0$
			},
			tagWithHTMLAttributes: {
				begin: "(^\\s*)(%[^\\s(]+?)\\(", //$NON-NLS-0$
				end: "\\)\\s*$", //$NON-NLS-0$
				beginCaptures: {
					2: {name: "meta.tag.haml"} //$NON-NLS-0$
				},
				patterns: [
					{
						match: "[^\\s=]+(?==)", //$NON-NLS-0$
						name: "entity.name.attribute.html.haml" //$NON-NLS-0$
					},
					{include: "orion.ruby#variable"}, //$NON-NLS-0$
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
				]
			},
			tagWithRubySymbols: {
				begin: "(^\\s*)(%[^\\b]+?)\\b{", //$NON-NLS-0$
				end: "}\\s*$", //$NON-NLS-0$
				beginCaptures: {
					2: {name: "meta.tag.haml"} //$NON-NLS-0$
				},
				patterns: [
					{include: "orion.ruby#symbol"}, //$NON-NLS-0$
					{include: "orion.ruby#variable"}, //$NON-NLS-0$
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
				]
			}
		}
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: []
	};
});
