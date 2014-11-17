package org.eclipse.xtext.idea.containers

import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.idea.resource.AbstractScopeBasedSelectable
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription
import org.eclipse.xtext.resource.IContainer

class ResolveScopeBasedContainer extends AbstractScopeBasedSelectable implements IContainer {

	override getResourceDescription(URI uri) {
		val psiFile = uri.findFile
		if (psiFile != null) {
			return new PsiFileBasedResourceDescription(psiFile)
		}
		null
	}

	override getResourceDescriptionCount() {
		val int[] counter = #[0]
		processFiles[ files |
			counter.set(0, counter.get(0) + files.size)
			true
		]
		counter.head
	}

	override hasResourceDescription(URI uri) {
		uri.findFile != null
	}
	
	override public setScope(GlobalSearchScope resolveScope) {
		super.setScope(resolveScope)
	}

}
