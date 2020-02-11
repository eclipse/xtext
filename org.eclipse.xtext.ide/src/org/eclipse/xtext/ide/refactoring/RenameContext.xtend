/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity
import org.eclipse.xtext.ide.serializer.IChangeSerializer

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@FinalFieldsConstructor
@Accessors(PUBLIC_GETTER)
class RenameContext {
	val List<? extends RenameChange> changes
	val ResourceSet resourceSet
	val IChangeSerializer changeSerializer
	val RefactoringIssueAcceptor issues
	
	def void addModification(RenameChange change, IChangeSerializer.IModification<EObject> modification) {
		val target = resourceSet.getEObject(change.targetURI, true)
		if (target !== null) {
			EcoreUtil.resolveAll(target.eResource)
			changeSerializer.addModification(target, modification)
		} else {
			issues.add(Severity.ERROR, 'Element cannot be found', change.targetURI)
		}
	}
}
