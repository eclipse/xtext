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
import com.intellij.util.indexing.IndexingDataKeys
import org.eclipse.xtext.resource.XtextResourceSet

import static extension com.intellij.psi.search.GlobalSearchScope.*

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
			resourceSet.classpathURIContext = context.allScope
		}
		if (context instanceof Module) {
			val project = context.project
			resourceSet.eAdapters.add(new ProjectAdapter(project))

			val indexingAwareGlobalSearchScope = globalSearchScopeProvider.get
			indexingAwareGlobalSearchScope.resourceSet = resourceSet
			indexingAwareGlobalSearchScope.filterScope = context.moduleScope
			indexingAwareGlobalSearchScope.searchScope = context.moduleWithDependenciesAndLibrariesScope
			resourceSet.classpathURIContext = indexingAwareGlobalSearchScope
		}
		if (context instanceof PsiFile) {
			val project = context.project
			resourceSet.eAdapters.add(new ProjectAdapter(project))

			val indexingAwareGlobalSearchScope = globalSearchScopeProvider.get
			indexingAwareGlobalSearchScope.resourceSet = resourceSet
			indexingAwareGlobalSearchScope.filterScope = context.getFilterScope(project)
			indexingAwareGlobalSearchScope.searchScope = context.resolveScope
			resourceSet.classpathURIContext = indexingAwareGlobalSearchScope
		}
		resourceSet
	}

	protected def getFilterScope(PsiFile context, Project project) {
		val virtualFile = context.findVirtualFile
		val module = if (virtualFile != null)
				ModuleUtil.findModuleForFile(virtualFile, project)
		if (module == null)
			project.projectScope
		else
			module.moduleScope
	}

	protected def VirtualFile findVirtualFile(PsiFile psiFile) {
		val originalFile = psiFile.originalFile
		if (originalFile != psiFile && originalFile != null) {
			return originalFile.findVirtualFile
		}
		psiFile.getUserData(IndexingDataKeys.VIRTUAL_FILE) ?: psiFile.viewProvider.virtualFile
	}

}