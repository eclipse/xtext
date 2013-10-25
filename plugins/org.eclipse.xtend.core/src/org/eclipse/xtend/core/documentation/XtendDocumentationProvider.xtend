/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.documentation

import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendDocumentationProvider extends MultiLineCommentDocumentationProvider {
	
	override getDocumentation(EObject o) {
		if (!shouldBeHandeled(o)) {
			return null;
		}
		super.getDocumentation(o)
	}
	
	override getDocumentationNodes(EObject o) {
		if (!shouldBeHandeled(o)) {
			return emptyList;
		}
		super.getDocumentationNodes(o)
	}
	
	/**
	 * The Xtend parser constructs a synthetic nested XtendClass to hold annotations which should be ignored as a documentation provider
	 */
	def boolean shouldBeHandeled(EObject o) {
		!(o instanceof XtendTypeDeclaration && o.eContainingFeature == XtendPackage.Literals.XTEND_MEMBER__ANNOTATION_INFO)
	}
	
}