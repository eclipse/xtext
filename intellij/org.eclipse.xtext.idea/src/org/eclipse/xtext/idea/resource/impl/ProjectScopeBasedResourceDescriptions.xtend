package org.eclipse.xtext.idea.resource.impl

import com.google.inject.Inject
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.resource.AbstractScopeBasedSelectable
import org.eclipse.xtext.idea.resource.ProjectAdapter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescriptions

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
		this.project = ProjectAdapter.getProject(ctx)
		if (project == null) {
			throw new IllegalStateException("project is null")
		}
		setScope(GlobalSearchScope.projectScope(project))
	}

	def isIndexing() {
		if (compilerPhases.isIndexing(context)) {
			return true
		}
		DumbService.isDumb(project)
	}

}
