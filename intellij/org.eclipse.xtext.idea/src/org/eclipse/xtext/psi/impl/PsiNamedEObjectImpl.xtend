/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl

import com.google.inject.Inject
import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import com.intellij.util.IncorrectOperationException
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.idea.nodemodel.ASTNodeExtension
import org.eclipse.xtext.psi.PsiEObjectFactory
import org.eclipse.xtext.psi.PsiNamedEObject
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub

import static extension org.eclipse.xtext.GrammarUtil.*

class PsiNamedEObjectImpl<PsiE extends PsiNamedEObject, T extends PsiNamedEObjectStub<PsiE>> extends PsiEObjectImpl<PsiE, T> implements PsiNamedEObject {
	
	@Inject
	extension ASTNodeExtension

	@Inject
	extension PsiEObjectFactory psiEObjectFactory

	new(T stub, IStubElementType<T, PsiE> nodeType) {
		super(stub, nodeType)
	}

	new(ASTNode node) {
		super(node)
	}

	override getNameIdentifier() {
		val nameNode = findNameNode
		if (nameNode == null) {
			return null
		}
		new PsiEObjectIdentifierImpl(nameNode.psi)
	}

	override getName() {
		val stub = stub
		if (stub != null) {
			return stub.name
		}
		
		val significantTextRegion = significantTextRegion
		val startIndex = significantTextRegion.offset
		val endIndex = startIndex + significantTextRegion.length
		val result = containingFile.text.substring(startIndex, endIndex)
		return result
	}

	override PsiNamedEObject setName(String name) throws IncorrectOperationException {
		val nameNode = findNameNode
		if (nameNode === null) return this
		
		val grammarElement = nameNode.grammarElement
		if (grammarElement === null) return this
		
		if (grammarElement.terminalRuleCall) {
			val newNameNode = name.createLeafIdentifier(nameNode)
			nameNode.treeParent.replaceChild(nameNode, newNameNode)
		} else {
			val newNameNode = name.createCompositeIdentifier(this.name, nameNode).firstChildNode
			nameNode.replaceAllChildrenToChildrenOf(newNameNode)
		}
		this
	} 
	
	protected def findNameNode() {
		val nameFeature = nameFeature
		if (nameFeature === null) return null

		node.findNodesForFeature(nameFeature).head
	}
	
	protected def getNameFeature() {
		val grammarElement = node.grammarElement
		if(grammarElement === null) return null

		val rule = if (grammarElement instanceof RuleCall)
				grammarElement.rule
			else 
				grammarElement.containingRule
		val classifier = rule.type?.classifier
		val feature = if(classifier instanceof EClass) classifier.getEStructuralFeature('name')
		if (feature instanceof EAttribute && !feature.many && String.isAssignableFrom(feature.EType.instanceClass))
			return feature

		return null
	}

	override String toString() {
		'''org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(«elementType»:«findNameNode?.elementType ?: 'null'»)«IF class !== PsiNamedEObjectImpl»('anonymous')«ENDIF»'''
	}

}
