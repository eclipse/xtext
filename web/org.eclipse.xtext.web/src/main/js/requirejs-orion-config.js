/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

({
	baseUrl: ".",
	name: "xtext/xtext-orion",
	paths: {
		"jquery": "empty:",
		"text": "../../../build/tmp/js/requirejs-plugins/text",
		"i18n": "../../../build/tmp/js/requirejs-plugins/i18n",
		"webtools/cssContentAssist": "orion/webtools/cssContentAssist",
		"webtools/htmlContentAssist": "orion/webtools/htmlContentAssist",
		"webtools/util": "orion/webtools/util",
		"javascript/compilationUnit": "orion/javascript/compilationUnit",
		"csslint": "orion/csslint"
	},
	include: [ "orion/editor/stylers/lib/syntax" ],
	exclude: [ "jquery", "text" ]
})