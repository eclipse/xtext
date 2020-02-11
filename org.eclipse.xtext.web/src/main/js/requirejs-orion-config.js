/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

({
	baseUrl: ".",
	name: "xtext/xtext-orion",
	paths: {
		"jquery": "empty:",
		"orion/Deferred": "empty:",
		"orion/codeEdit": "empty:",
		"orion/keyBinding": "empty:",
		"orion/editor/annotations": "empty:",
		"embeddedEditor/builder/embeddedEditor": "empty:",
		"embeddedEditor/helper/bootstrap": "empty:"
	},
	exclude: [
		"jquery", "orion/Deferred", "orion/codeEdit", "orion/keyBinding",
		"orion/editor/annotations", "embeddedEditor/builder/embeddedEditor",
		"embeddedEditor/helper/bootstrap"
	]
})