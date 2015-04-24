package org.eclipse.xtext.idea.resource

import com.intellij.openapi.project.Project
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.resource.IResourceDescriptions

class ProjectAwareResourceDescriptions extends ProjectScopeBasedResourceDescriptions implements IResourceDescriptions {

	static def IResourceDescriptions getInstance(Project project) {
		project.getComponent(ProjectAwareResourceDescriptions)
	}

	new(Project project) {
		IdeaSharedInjectorProvider.injector.injectMembers(this)
		setProject(project)
	}

}