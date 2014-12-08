/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.macro

import com.google.inject.Inject
import com.intellij.openapi.roots.ProjectRootManager
import java.io.File
import java.net.URLClassLoader
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.psi.IPsiModelAssociations

class IdeaProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
	
	@Inject
	extension IPsiModelAssociations
	
	override getProcessorInstance(JvmType type) {
		val file = type.psiElement.containingFile
		val project = type.psiElement.project
		val path = ProjectRootManager.getInstance(project).fileIndex.getClassRootForFile(file.virtualFile).path
		val url = new File(path).toURL
		val classLoader = new URLClassLoader(#[url], TransformationContext.classLoader)
		classLoader.loadClass(type.identifier).newInstance
	}
	
}