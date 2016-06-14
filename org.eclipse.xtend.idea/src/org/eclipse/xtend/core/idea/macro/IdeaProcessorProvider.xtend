/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.macro

import java.io.File
import java.net.URL
import java.net.URLClassLoader
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtext.idea.util.FilteringClassLoader

import static extension com.intellij.openapi.roots.OrderEnumerator.*
import static extension org.eclipse.xtext.idea.resource.ModuleProvider.*

class IdeaProcessorProvider extends ProcessorInstanceForJvmTypeProvider {

	static val MACRO_PACKAGE_NAMES = #{
		'org.eclipse.xtend.lib.macro',
		'org.eclipse.xtend2.lib',
		'org.eclipse.xtext.xbase.lib',
		'com.google.common'
	}

	override getClassLoader(EObject ctx) {
		new URLClassLoader(ctx.urls, macroClassLoader)
	}

	protected def getMacroClassLoader() {
		new FilteringClassLoader(TransformationContext.classLoader) [ name |
			MACRO_PACKAGE_NAMES.exists[packageName|name.startsWith(packageName)]
		]
	}

	protected def URL[] getUrls(EObject context) {
		return context.eResource.resourceSet.findModule.orderEntries.recursively.classes.pathsList.virtualFiles.map [
			new File(path).toURI.toURL
		]
	}

}