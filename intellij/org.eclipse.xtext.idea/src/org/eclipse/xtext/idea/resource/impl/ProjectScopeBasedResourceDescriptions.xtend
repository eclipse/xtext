/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource.impl

import com.google.inject.Inject
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.idea.resource.AbstractScopeBasedSelectable
import org.eclipse.xtext.idea.resource.ModuleProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResourceSet

import static java.util.Collections.emptyList

class ProjectScopeBasedResourceDescriptions extends AbstractScopeBasedSelectable implements IResourceDescriptions.IContextAware {

	@Accessors(PUBLIC_GETTER)
	Project project

	@Accessors(PUBLIC_GETTER)
	Notifier context

	@Inject CompilerPhases compilerPhases

	override getExportedObjects(EClass type, QualifiedName qualifiedName, boolean ignoreCase) {
		if (indexing) {
			return emptyList
		}
		super.getExportedObjects(type, qualifiedName, ignoreCase)
	}

	override getResourceDescription(URI uri) {
		if (indexing) {
			return null
		}
		super.getResourceDescription(uri)
	}

	override getAllResourceDescriptions() {
		if (indexing) {
			return null
		}
		super.resourceDescriptions
	}

	override setContext(Notifier ctx) {
		this.context = ctx
		val resourceSet  = EcoreUtil2.getResourceSet(ctx) as XtextResourceSet;
		val module = ModuleProvider.findModule(resourceSet)
		if (module == null) {
			throw new IllegalStateException("module is null")
		} else {
			this.project = module.project
			setScope(GlobalSearchScope.projectScope(project))
		}
	}

	def isIndexing() {
		if (compilerPhases.isIndexing(context)) {
			return true
		}
		DumbService.isDumb(project)
	}

}
