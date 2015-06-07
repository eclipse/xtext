/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.macro

import com.intellij.openapi.roots.OrderEnumerator
import java.io.File
import java.net.URLClassLoader
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.idea.resource.ModuleProvider
import org.eclipse.xtext.resource.XtextResourceSet

class IdeaProcessorProvider extends ProcessorInstanceForJvmTypeProvider {

	override getProcessorInstance(JvmType type) {
		val resourceSet = type.eResource.resourceSet as XtextResourceSet
		val module = ModuleProvider.findModule(resourceSet)
		val roots = OrderEnumerator.orderEntries(module).recursively.classes.pathsList.virtualFiles
		val urls = roots.map[new File(path).toURI.toURL]
		val classLoader = new URLClassLoader(urls, TransformationContext.classLoader)
		return classLoader.loadClass(type.identifier).newInstance
	}
}