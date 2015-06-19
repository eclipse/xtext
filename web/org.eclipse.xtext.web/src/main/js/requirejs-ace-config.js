/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

({
	baseUrl: ".",
	name: "xtext/xtext-ace",
	paths: {
		"jquery": "empty:",
		"ace/ace": "empty:",
		"ace/range": "empty:",
		"ace/ext/language_tools": "empty:"
	},
	exclude: [ "jquery", "ace/range", "ace/ext/language_tools" ]
})