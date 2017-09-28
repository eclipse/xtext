/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@ImplementedBy(IRenameStrategy.Impl)
interface IRenameStrategy {

	def void loadAndWatchResources(RenameContext context)
	 
	def void applyRename(RenameContext context)
	
	def void applySideEffects(RenameContext context)
	
	def String getCurrentName(EObject element)
	
	class Impl implements IRenameStrategy {
		
		@Inject IResourceServiceProvider resourceServiceProvider
		
		def boolean canHandle(RenameChange change) {
			resourceServiceProvider.canHandle(change.targetURI)
		}
		
		override void loadAndWatchResources(RenameContext context) {
			context.changes.filter[ canHandle ].forEach [ change | 
				val targetResource = context.resourceSet.getResource(change.targetURI.trimFragment, true)
				EcoreUtil.resolveAll(targetResource)
				context.changeSerializer.beginRecordChanges(targetResource)
			]
		}
		
		override applyRename(RenameContext context) {
			context.changes.filter[ canHandle ].forEach [ change |
				val target = context.resourceSet.getEObject(change.targetURI, false)
				if (target instanceof EObject) {
					doRename(target, change, context)
				}
			]
		}
		
		protected def void doRename(EObject target, RenameChange change, RenameContext context) {
			val nameAttribute = getNameEAttribute(target)
			if (nameAttribute !== null)
				target.eSet(nameAttribute, change.newName)
			else
				context.issues.add(Severity.WARNING, 'Element of class ' + target.eClass.name + ' cannot be renamed.')
		}
		
		protected def EAttribute getNameEAttribute(EObject target) {
			target.eClass.EAllAttributes.filter[name == 'name' && EType == EcorePackage.Literals.ESTRING].head
		}

		override getCurrentName(EObject element) {
			element.eGet(element.nameEAttribute).toString
		}

		override applySideEffects(RenameContext context) {
		}
	}
}

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
}

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
class RenameChange {
	String newName
	URI targetURI
}