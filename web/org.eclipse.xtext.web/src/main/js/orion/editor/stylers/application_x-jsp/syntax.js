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
define("orion/editor/stylers/application_x-jsp/syntax", ["orion/editor/stylers/lib/syntax", "orion/editor/stylers/text_x-java-source/syntax", "orion/editor/stylers/text_html/syntax"], //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	function(mLib, mJava, mHTML) {

	var pageAttributeNames = [
		"autoFlush", "buffer", "contentType", "errorPage", "extends", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"import", "info", "isErrorPage", "isThreadSafe", "language", "pageEncoding", "session" //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push.apply(grammars, mJava.grammars);
	grammars.push.apply(grammars, mHTML.grammars);
	grammars.push({
		id: "orion.jsp", //$NON-NLS-0$
		contentTypes: ["application/x-jsp"], //$NON-NLS-0$
		patterns: [
			{include: "orion.html"}, //$NON-NLS-0$
			{include: "#jspComment"}, //$NON-NLS-0$
			{include: "#jspJavaFragment"}, //$NON-NLS-0$
			{include: "#jspDirectiveInclude"}, //$NON-NLS-0$
			{include: "#jspDirectivePage"}, //$NON-NLS-0$
			{include: "#jspDirectiveTaglib"} //$NON-NLS-0$
		],
		repository: {
			jspComment: {
				begin: {match: "<%--", literal: "<%--"}, //$NON-NLS-1$ //$NON-NLS-0$
				end: {match: "--%>", literal: "<%--"}, //$NON-NLS-1$ //$NON-NLS-0$
				name: "comment.block.jsp", //$NON-NLS-0$
				patterns: [
					{
						match: "(\\b)(TODO)(\\b)(((?!--%>).)*)", //$NON-NLS-0$
						name: "meta.annotation.task.todo", //$NON-NLS-0$
						captures: {
							2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
							4: {name: "comment.line"} //$NON-NLS-0$
						}
					}
				]
			},
			jspDirectiveInclude: {
				begin: "<%@\\s+include(?:\\s|$)", //$NON-NLS-0$
				end: "%>", //$NON-NLS-0$
				captures: {
					0: {name: "entity.name.directive.include.jsp"} //$NON-NLS-0$
				},
				patterns: [
					{
						match: "\\bfile\\b", //$NON-NLS-0$
						name: "entity.other.attribute-name.jsp" //$NON-NLS-0$
					},
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
				]
			},
			jspDirectivePage: {
				begin: "<%@\\s+page(?:\\s|$)", //$NON-NLS-0$
				end: "%>", //$NON-NLS-0$
				captures: {
					0: {name: "entity.name.directive.page.jsp"} //$NON-NLS-0$
				},
				patterns: [
					{
						match: "\\b(?:" + pageAttributeNames.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
						name: "entity.other.attribute-name.jsp" //$NON-NLS-0$
					},
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
				]
			},
			jspDirectiveTaglib: {
				begin: "<%@\\s+taglib(?:\\s|$)", //$NON-NLS-0$
				end: "%>", //$NON-NLS-0$
				captures: {
					0: {name: "entity.name.directive.taglib.jsp"} //$NON-NLS-0$
				},
				patterns: [
					{
						match: "\\b(?:uri|prefix)\\b", //$NON-NLS-0$
						name: "entity.other.attribute-name.jsp" //$NON-NLS-0$
					},
					{include: "orion.lib#string_doubleQuote"}, //$NON-NLS-0$
					{include: "orion.lib#string_singleQuote"}, //$NON-NLS-0$
				]
			},
			jspJavaFragment: {
				begin: "<%(?:=|!)?(?:\\s|$)", //$NON-NLS-0$
				end: "%>", //$NON-NLS-0$
				captures: {
					0: {name: "entity.name.declaration.java"} //$NON-NLS-0$
				},
				contentName: "source.java.embedded.jsp", //$NON-NLS-0$
				patterns: [
					{include: "orion.java"} //$NON-NLS-0$
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
