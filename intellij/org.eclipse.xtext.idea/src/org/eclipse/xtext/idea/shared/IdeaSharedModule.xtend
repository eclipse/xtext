package org.eclipse.xtext.idea.shared

import com.google.inject.AbstractModule
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.PsiModelAssociations
import org.eclipse.xtext.psi.PsiTreeChangeToDeltaConverter
import org.eclipse.xtext.psi.PsiTreeChangeToDeltaConverterImpl
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceServiceProvider

class IdeaSharedModule extends AbstractModule {

	override protected configure() {
		bind(CompilerPhases)

		bind(IPsiModelAssociations).to(PsiModelAssociations)
		bind(ExportedObjectQualifiedNameIndex).asEagerSingleton
		bind(IResourceServiceProvider.Registry).toInstance(IResourceServiceProvider.Registry.INSTANCE)

		bind(PsiTreeChangeToDeltaConverter).to(PsiTreeChangeToDeltaConverterImpl)
	}

}