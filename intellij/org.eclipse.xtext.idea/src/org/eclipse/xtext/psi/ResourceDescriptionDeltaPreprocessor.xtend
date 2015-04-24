package org.eclipse.xtext.psi

import com.google.inject.Inject
import com.intellij.openapi.project.Project
import com.intellij.psi.impl.PsiTreeChangeEventImpl
import com.intellij.psi.impl.PsiTreeChangePreprocessor
import org.eclipse.xtext.idea.resource.ProjectAwareResourceDescriptions
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.resource.IResourceDescription.Event.Source
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent

class ResourceDescriptionDeltaPreprocessor implements PsiTreeChangePreprocessor {

	@Inject
	extension PsiTreeChangeToDeltaConverter

	val Source source

	val Project project

	val IResourceDescriptions resourceDescriptions

	new(Project project) {
		IdeaSharedInjectorProvider.injector.injectMembers(this)
		this.project = project
		source = ResourceDescriptionEventSource.getInstance(project)
		resourceDescriptions = ProjectAwareResourceDescriptions.getInstance(project)
	}

	override treeChanged(PsiTreeChangeEventImpl event) {
		val deltas = event.convert
		if (!deltas.empty) {
			val changeEvent = new ResourceDescriptionChangeEvent(deltas)
			source.notifyListeners(changeEvent)
		}
	}

}