/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.documentation

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendDocumentationProvider extends MultiLineCommentDocumentationProvider {
	
	override getDocumentation(EObject o) {
		if (!shouldBeHandled(o)) {
			return null;
		}
		super.getDocumentation(o)
	}
	
	override getDocumentationNodes(EObject o) {
		if (!shouldBeHandled(o)) {
			return emptyList;
		}
		super.getDocumentationNodes(o)
	}
	
	/**
	 * The Xtend parser constructs a synthetic nested AST element to hold annotations which should be ignored as a documentation provider
	 */
	def boolean shouldBeHandled(EObject o) {
		!(o instanceof XtendAnnotationTarget && o.eContainingFeature == XtendPackage.Literals.XTEND_MEMBER__ANNOTATION_INFO)
	}
	
}