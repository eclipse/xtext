/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

import org.eclipse.xtend.idea.autoedit.AutoEditTest

/**
 * @author kosyakov - Initial contribution and API
 */
class AutoEditInMethodBodyTest extends AutoEditTest {

	static val PREFIX = "class Foo {\n\tfoo() {\n"

	static val SUFFIX = "\n}\n}"
	
	override protected configureByText(String code) {
		super.configureByText(PREFIX + code + SUFFIX)
	}
	
	override protected assertState(String editorState) {
		super.assertState(PREFIX + editorState + SUFFIX)
	}

	
}