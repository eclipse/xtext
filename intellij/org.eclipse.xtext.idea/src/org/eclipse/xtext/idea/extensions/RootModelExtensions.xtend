/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.extensions

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.SourceFolder
import com.intellij.openapi.vfs.VfsUtil

class RootModelExtensions {
	public static def getSourceFolders(Module module) {
		ModuleRootManager.getInstance(module).contentEntries.map[sourceFolders.toList].flatten
	}
	
	public static def getExistingSourceFolders(Module module) {
		module.sourceFolders.filter[file != null]
	}

	public static def getRelativePath(SourceFolder sourceFolder) {
		VfsUtil.getRelativePath(sourceFolder.file, sourceFolder.contentEntry.file)
	}
}