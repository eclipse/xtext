/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

/**
 * Calculates where to insert new members into exisitng Xtend code.
 * 
 * @author Jan Koehnlein
 */
class InsertionOffsets {

	def getNewTypeInsertOffset(/* @Nullable */ EObject call, XtendTypeDeclaration ownerType) {
		after(ownerType)
	}

	def getNewFieldInsertOffset(/* @Nullable */ EObject call, XtendTypeDeclaration ownerType) {
		if (ownerType.members.empty)
			return inEmpty(ownerType)
		val callingMember = EcoreUtil2.getContainerOfType(call, XtendField)
		if (callingMember !== null && ownerType.members.contains(callingMember))
			return before(callingMember)
		val lastDefinedField = ownerType.members.filter(XtendField).last
		if (lastDefinedField === null)
			return before(ownerType.members.head)
		else
			return after(lastDefinedField)
	}

	def getNewMethodInsertOffset(/* @Nullable */ EObject call, XtendTypeDeclaration ownerType) {
		val callingMember = EcoreUtil2.getContainerOfType(call, XtendMember)
		if (callingMember !== null && ownerType.members.contains(callingMember))
			return after(callingMember)
		else if (ownerType.members.empty)
			return inEmpty(ownerType)
		else
			return after(ownerType.members.last)
	}

	def getNewConstructorInsertOffset(/* @Nullable */ EObject call, XtendTypeDeclaration ownerType) {
		val lastDefinedConstructor = ownerType.members.filter(XtendConstructor).last
		if(lastDefinedConstructor === null)
			return getNewFieldInsertOffset(call, ownerType)		
		else	
			return after(lastDefinedConstructor)
	}

	def protected before(EObject element) {
		NodeModelUtils.findActualNodeFor(element).offset
	}

	def protected after(EObject element) {
		val node = NodeModelUtils.findActualNodeFor(element)
		node.endOffset
	}
	
	def protected inEmpty(XtendTypeDeclaration ownerType) {
		val classNode = NodeModelUtils.findActualNodeFor(ownerType)
		val openingBraceNode = classNode.leafNodes.findFirst[text == "{"]
		if(openingBraceNode !== null)
			openingBraceNode.offset + 1
		else 
			classNode.endOffset
	}
}
