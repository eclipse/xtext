package org.eclipse.xtext.psi

import com.intellij.psi.ElementDescriptionLocation
import com.intellij.psi.ElementDescriptionProvider
import com.intellij.psi.PsiElement
import com.intellij.usageView.UsageViewTypeLocation
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.IXtextLanguage

class BaseXtextElementDescriptionProvider implements ElementDescriptionProvider {

	@Accessors
	val IXtextLanguage language

	new(IXtextLanguage language) {
		this.language = language
		language.injectMembers(this)
	}

	override final getElementDescription(PsiElement element, ElementDescriptionLocation location) {
		if (element?.language == language) {
			doGetElementDescription(element, location)
		}
	}

	def doGetElementDescription(PsiElement element, ElementDescriptionLocation location) {
		if (location == UsageViewTypeLocation.INSTANCE) {
			if (element instanceof PsiEObject) {
				val eObject = element.EObject
				if (eObject != null) {
					return eObject.eClass.name
				}
			}
		}
	}

}
