/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.junit.Ignore

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class AutoEditTest extends AbstractCStyleLanguageAutoEditTest {
	
	new() {
		super(XtendFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXtendLibrary
	}
	
	@Ignore
	override testSingleQuotedStringLiteral_15() {
//		super.testSingleQuotedStringLiteral_15()
	}
	
}