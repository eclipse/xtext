/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import com.intellij.openapi.module.Module
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.CompilerPhases

/**
 * @author kosyakov - Initial contribution and API
 */
class IndexingAwareGlobalSearchScope extends GlobalSearchScope {

	@Accessors(PUBLIC_SETTER)
	ResourceSet resourceSet

	@Accessors(PUBLIC_SETTER)
	GlobalSearchScope filterScope

	@Accessors(PUBLIC_SETTER)
	GlobalSearchScope searchScope

	@Inject
	CompilerPhases compilerPhases

	override getProject() {
		searchScope.project
	}

	override compare(VirtualFile file1, VirtualFile file2) {
		searchScope.compare(file1, file2)
	}

	override contains(VirtualFile file) {
		if (compilerPhases.isIndexing(resourceSet) && filterScope.contains(file)) {
			return false
		}
		searchScope.contains(file)
	}

	override isSearchInLibraries() {
		searchScope.searchInLibraries
	}

	override isSearchInModuleContent(Module aModule) {
		if (compilerPhases.isIndexing(resourceSet) && filterScope.isSearchInModuleContent(aModule)) {
			return false
		}
		searchScope.isSearchInModuleContent(aModule)
	}

}