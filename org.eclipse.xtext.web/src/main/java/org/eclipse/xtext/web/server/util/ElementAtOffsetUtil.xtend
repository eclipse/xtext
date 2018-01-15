/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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
		if (crossLinkedEObject !== null) {
			return crossLinkedEObject
		} else {
			var containedEObject = resource.resolveContainedElementAt(offset)
			if (containedEObject !== null) {
				val nameRegion = containedEObject.significantTextRegion
				if (nameRegion.contains(offset))
					return containedEObject
			}
		}
		return null
	}
	
}
