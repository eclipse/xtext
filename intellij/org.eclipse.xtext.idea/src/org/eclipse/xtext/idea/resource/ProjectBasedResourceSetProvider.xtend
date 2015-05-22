/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.IndexingDataKeys
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.XtextResourceSet

@Singleton
class ProjectBasedResourceSetProvider implements IResourceSetProvider {

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	@Inject
	Provider<IndexingAwareGlobalSearchScope> globalSearchScopeProvider

	override get(Object context) {
		val resourceSet = resourceSetProvider.get
		if (context instanceof Project) {
			resourceSet.eAdapters.add(new ProjectAdapter(context))
			resourceSet.classpathURIContext = GlobalSearchScope.allScope(context)
		}
		if (context instanceof PsiFile) {
			val project = context.project
			resourceSet.eAdapters.add(new ProjectAdapter(project))

			val searchScope = context.resolveScope
		
			val virtualFile = context.findVirtualFile
			val module = if(virtualFile != null) ModuleUtil.findModuleForFile(virtualFile, project)
			val filterScope = if (module == null)
					GlobalSearchScope.projectScope(project)
				else
					GlobalSearchScope.moduleScope(module)

			val indexingAwareGlobalSearchScope = globalSearchScopeProvider.get
			indexingAwareGlobalSearchScope.resourceSet = resourceSet
			indexingAwareGlobalSearchScope.filterScope = filterScope
			indexingAwareGlobalSearchScope.searchScope = searchScope
			resourceSet.classpathURIContext = indexingAwareGlobalSearchScope
		}
		resourceSet
	}

	protected def VirtualFile findVirtualFile(PsiFile psiFile) {
		val originalFile = psiFile.originalFile
		if (originalFile != psiFile && originalFile != null) {
			return originalFile.findVirtualFile
		}
		psiFile.getUserData(IndexingDataKeys.VIRTUAL_FILE) 
		?: psiFile.viewProvider.virtualFile
	}

}

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
