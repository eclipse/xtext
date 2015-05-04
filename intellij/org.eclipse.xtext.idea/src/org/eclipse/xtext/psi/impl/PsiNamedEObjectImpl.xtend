/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl

import com.google.common.base.Preconditions
import com.google.inject.Inject
import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import com.intellij.util.IncorrectOperationException
import org.eclipse.xtext.psi.PsiEObjectFactory
import org.eclipse.xtext.psi.PsiNamedEObject
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

import static extension org.eclipse.xtext.GrammarUtil.*

class PsiNamedEObjectImpl<PsiE extends PsiNamedEObject, T extends PsiNamedEObjectStub<PsiE>> extends PsiEObjectImpl<PsiE, T> implements PsiNamedEObject {

	@Inject
	extension PsiEObjectFactory psiEObjectFactory

	val IGrammarAwareElementType nameType

	new(T stub, IStubElementType<T, PsiE> nodeType, IGrammarAwareElementType nameType) {
		super(stub, nodeType)
		Preconditions.checkNotNull(nameType)
		this.nameType = nameType
	}

	new(ASTNode node, IGrammarAwareElementType ... nameTypes) {
		super(node)
		Preconditions.checkArgument(!nameTypes.empty)
		this.nameType = nameTypes.findFirst [ nameType |
			node.findChildByType(nameType) != null
		]
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
		if (nameNode == null) {
			return this
		}
		if (nameType.grammarElement.terminalRuleCall) {
			val newNameNode = name.createLeafIdentifier(nameNode)
			nameNode.treeParent.replaceChild(nameNode, newNameNode)
		} else {
			val newNameNode = name.createCompositeIdentifier(this.name, nameNode).firstChildNode
			nameNode.replaceAllChildrenToChildrenOf(newNameNode)
		}
		this
	}
	
	def protected findNameNode() {
		node.findChildByType(nameType)
	}

}
