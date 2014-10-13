package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import org.eclipse.xtext.resource.XtextResourceSet
import com.intellij.psi.search.GlobalSearchScope

@Singleton
class ProjectBasedResourceSetProvider implements IResourceSetProvider {

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	override get(Object context) {
		val resourceSet = resourceSetProvider.get
		if (context instanceof Project) {
			resourceSet.eAdapters.add(new ProjectAdapter(context))
			resourceSet.classpathURIContext = GlobalSearchScope.allScope(context)
		}
		if (context instanceof PsiFile) {
			resourceSet.eAdapters.add(new ProjectAdapter(context.project))
			resourceSet.classpathURIContext = context.resolveScope
		}
		resourceSet
	}

}
