/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.ui.refactoring.XbaseReferenceUpdater

/**
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * @since 2.12
 */
class XtendReferenceUpdater extends XbaseReferenceUpdater {
	
	override protected createReferenceUpdate(EObject referringElement, URI referringResourceURI, EReference reference, int indexInList, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		// Anonymous classes report two references to the constructor of the superclass.
		// Filter one of them to avoid duplicate text edits. 
		if(referringElement instanceof XConstructorCall && referringElement.eContainer() instanceof AnonymousClass && newTargetElement instanceof JvmType) {
			return;
		}
		super.createReferenceUpdate(referringElement, referringResourceURI, reference, indexInList, newTargetElement, updateAcceptor)
	}
	
	override protected getNotImportTypeReferences(Iterable<IReferenceDescription> referenceDescriptions) {
		val result = super.getNotImportTypeReferences(referenceDescriptions).toList
		val localClassesFragmentPart = "@localClasses."
		// sort @localClasses to the end since the refactoring of local classes is order dependent
		result.sort[o1,o2|
			val f1 = o1.sourceEObjectUri.fragment
			val f2 = o2.sourceEObjectUri.fragment
			if (f1.contains(localClassesFragmentPart) && f2.contains(localClassesFragmentPart)) {
				return f1.compareTo(f2)
			}
			if (f1.contains(localClassesFragmentPart)) {
				return 1
			}
			if (f2.contains(localClassesFragmentPart)) {
				return -1
			}
			return f1.compareTo(f2)
		]
		result
	}
	
}