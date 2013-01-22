/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.jdt.annotation.NonNullByDefault

/**
 * Calculates where to insert new members into exisitng Xtend code.
 * 
 * @author Jan Koehnlein
 */
@NonNullByDefault
class InsertionOffsets {

	def getNewFieldInsertOffset(EObject call, XtendClass ownerClass) {
		if (ownerClass.members.empty)
			return inEmpty(ownerClass)
		val lastDefinedField = ownerClass.members.filter(typeof(XtendField)).last
		if (lastDefinedField == null)
			return before(ownerClass.members.head)
		else
			return after(lastDefinedField)
	}

	def getNewMethodInsertOffset(EObject call, XtendClass ownerClass) {
		val callingMember = EcoreUtil2::getContainerOfType(call, typeof(XtendMember))
		if (callingMember == null)
			throw new IllegalStateException("Missing method not called from Xtend member")
		if (ownerClass.members.contains(callingMember))
			return after(callingMember)
		else if (ownerClass.members.empty)
			return inEmpty(ownerClass)
		else
			return after(ownerClass.members.last)
	}

	def getNewConstructorInsertOffset(EObject call, XtendClass ownerClass) {
		val lastDefinedConstructor = ownerClass.members.filter(typeof(XtendConstructor)).last
		if(lastDefinedConstructor == null)
			return getNewFieldInsertOffset(call, ownerClass)		
		else	
			return after(lastDefinedConstructor)
	}

	def protected before(EObject element) {
		NodeModelUtils::findActualNodeFor(element).offset
	}

	def protected after(EObject element) {
		val node = NodeModelUtils::findActualNodeFor(element)
		node.offset + node.length
	}
	
	def protected inEmpty(XtendClass ownerClass) {
		val classNode = NodeModelUtils::findActualNodeFor(ownerClass)
		val openingBraceNode = classNode.leafNodes.findFirst[text == "{"]
		if(openingBraceNode != null)
			openingBraceNode.offset + 1
		else 
			classNode.offset + classNode.length
	}
}
