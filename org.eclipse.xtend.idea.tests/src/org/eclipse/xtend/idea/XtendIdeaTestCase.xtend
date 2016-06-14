/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.tests.AbstractIdeaTestCase
import org.eclipse.xtext.idea.tests.LibraryUtil
import org.eclipse.xtext.idea.tests.LightToolingTest
import com.intellij.openapi.vfs.VfsUtil

/**
 * @author dhuebner - Initial contribution and API
 */
abstract class XtendIdeaTestCase extends AbstractIdeaTestCase {
	override configureModule(Module module, ModifiableRootModel model, ContentEntry entry) {
		LibraryUtil.addXtendLibrary(model)
		val srcGenFolder = VfsUtil.createDirectoryIfMissing(project.baseDir, "xtend-gen")
		entry.addSourceFolder(srcGenFolder, srcGenFolder.testSource)
		LightToolingTest.addFacetToModule(module, XtendLanguage.INSTANCE.ID)
	}

}