/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import com.google.inject.Inject
import com.intellij.ide.projectView.impl.ProjectViewPane
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.GeneratedSourcesFilter
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import java.util.List
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class TraceBasedGeneratedSourcesFilter extends GeneratedSourcesFilter {
	
	@Inject ITraceForVirtualFileProvider traceProvider
	
	new() {
		IdeaSharedInjectorProvider.injectMembers(this)
	}
	
	override isGeneratedSource(VirtualFile file, Project project) {
		// TODO called very often and very frequent - check if we need to make it faster
		return traceProvider.isGenerated(new VirtualFileInProject(file, project))
	}
	
	override getOriginalElements(PsiElement element) {
		// don't navigate to the original element on double click in project explorer
		val currentStack = Thread.currentThread.stackTrace
		if (currentStack.subList(15, 20).exists[ frame |
			frame.className.startsWith(ProjectViewPane.name)
		]) {
			return emptyList
		}
		return traceProvider.getOriginalElements(element)
	}
	
	def List<? extends PsiElement> getGeneratedElements(PsiElement element) {
		return traceProvider.getGeneratedElements(element)
	}
	
}