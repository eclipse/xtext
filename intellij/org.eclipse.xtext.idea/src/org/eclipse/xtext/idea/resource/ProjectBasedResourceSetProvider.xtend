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
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import org.eclipse.xtext.resource.XtextResourceSet
import com.intellij.psi.search.GlobalSearchScope

@Singleton
class ProjectBasedResourceSetProvider implements IResourceSetProvider {

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	override get(Object context) {
		val resourceSet = resourceSetProvider.get
		if (context instanceof Project) {
			resourceSet.eAdapters.add(new ProjectAdapter(context))
			resourceSet.classpathURIContext = GlobalSearchScope.allScope(context)
		}
		if (context instanceof PsiFile) {
			resourceSet.eAdapters.add(new ProjectAdapter(context.project))
			resourceSet.classpathURIContext = context.resolveScope
		}
		resourceSet
	}

}
