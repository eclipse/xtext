/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.tests.formatting

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtext.idea.tests.LibraryUtil
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseFileType
import org.eclipse.xtext.xbase.idea.formatting.AbstractXbaseAutoEditTest

class XbaseAutoEditTest extends AbstractXbaseAutoEditTest {

	new() {
		super(PureXbaseFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		LibraryUtil.addXbaseLibrary(model)
	}
}
