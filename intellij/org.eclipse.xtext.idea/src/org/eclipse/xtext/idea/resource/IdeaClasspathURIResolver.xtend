/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.intellij.openapi.module.Module
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.psi.XtextPsiUtils
import org.eclipse.xtext.resource.ClasspathUriUtil
import org.eclipse.xtext.resource.IClasspathUriResolver
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.Computable

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class IdeaClasspathURIResolver implements IClasspathUriResolver {

	override resolve(Object context, URI classpathUri) {
		if (!(context instanceof Module)) {
			throw new IllegalArgumentException("Expected a module as context but got " + context)
		}
		if (!ClasspathUriUtil.isClasspathUri(classpathUri)) {
			return classpathUri
		}
		val module = context as Module
		val scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module)
		val uri = ApplicationManager.application.runReadAction([
			val files = FilenameIndex.getFilesByName(module.project, classpathUri.lastSegment, scope)
			for (file : files) {
				val vf = XtextPsiUtils.findVirtualFile(file)
				if (vf != null && vf.exists) {
					val uri = VirtualFileURIUtil.getURI(vf);
					if (uri.toString.endsWith(classpathUri.path)) {
						return uri
					}
				}
			}
		] as Computable<URI>)
		return uri ?: classpathUri
	}

}