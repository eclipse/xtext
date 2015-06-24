package org.eclipse.xtext.web.server.util

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource

class ElementAtOffsetUtil {
	
	@Inject extension EObjectAtOffsetHelper
	@Inject extension ILocationInFileProvider

	def EObject getElementAt(XtextResource resource, int offset) {
		var crossLinkedEObject = resource.resolveCrossReferencedElementAt(offset)
		if (crossLinkedEObject != null) {
			return crossLinkedEObject
		} else {
			var containedEObject = resource.resolveElementAt(offset)
			if(containedEObject != null) {
				val nameRegion = containedEObject.significantTextRegion
				if (nameRegion.contains(offset))
					return containedEObject
			}
		}
		return null
	}
}