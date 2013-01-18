package org.eclipse.xtend.ide.codebuilder

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

class InsertionOffsets {

	def getNewFieldInsertOffset(EObject call, XtendClass ownerClass) {
		if (ownerClass.members.empty)
			return after(ownerClass) - 2
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
			return after(ownerClass) - 2
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
}
