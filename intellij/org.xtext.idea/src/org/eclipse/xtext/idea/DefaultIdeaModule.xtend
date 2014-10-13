package org.eclipse.xtext.idea

import com.google.inject.Binder
import org.eclipse.xtext.idea.containers.ResolveScopeBasedContainerManger
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.psi.PsiModelAssociations
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.service.SingletonBinding
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions

class DefaultIdeaModule extends AbstractGenericModule {

	def void configureIResourceDescriptions(Binder binder) {
		binder.bind(IResourceDescriptions).to(ProjectScopeBasedResourceDescriptions)
	}

	def Class<? extends IContainer.Manager> bindIContainer$Manager() {
		ResolveScopeBasedContainerManger
	}

	def Class<? extends IPsiModelAssociations> bindIPsiModelAssociations() {
		PsiModelAssociations
	}

	def Class<? extends IPsiModelAssociator> bindIPsiModelAssociator() {
		PsiModelAssociations
	}

	@SingletonBinding
	def Class<? extends ExportedObjectQualifiedNameIndex> bindExportedObjectQualifiedNameIndex() {
		ExportedObjectQualifiedNameIndex
	}

}
