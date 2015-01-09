package org.eclipse.xtext.idea.structureview

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.psi.PsiFile
import org.eclipse.xtext.psi.impl.BaseXtextFile

class DefaultPsiStructureViewFactory implements PsiStructureViewFactory {
	
	@Inject
	Provider<XtextFileAwareStructureViewBuilder> structureViewBuilderProvider
	
	override getStructureViewBuilder(PsiFile psiFile) {
		if (psiFile instanceof BaseXtextFile) {
			structureViewBuilderProvider.get => [
				xtextFile = psiFile
			]
		}
	}
	
}