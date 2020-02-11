/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.documentation

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider
import com.google.inject.Singleton

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
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