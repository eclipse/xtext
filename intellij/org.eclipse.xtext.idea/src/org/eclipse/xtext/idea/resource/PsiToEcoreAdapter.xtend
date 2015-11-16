/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.intellij.lang.ASTNode
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType
import org.eclipse.xtext.util.internal.EmfAdaptable

@EmfAdaptable
class PsiToEcoreAdapter {

	@Accessors(PUBLIC_GETTER)
	val BaseXtextFile xtextFile

	@Accessors(PUBLIC_GETTER)
	val Map<ASTNode, INode> nodesMapping

	@Accessors(PUBLIC_GETTER)
	val Map<INode, List<ASTNode>> reverseNodesMapping

	new(PsiToEcoreTransformationContext context) {
		xtextFile = context.xtextFile
		nodesMapping = context.nodesMapping.unmodifiableView
		reverseNodesMapping = context.reverseNodesMapping.unmodifiableView
	}

	def INode getINode(ASTNode astNode) {
		if (astNode === null) return null

		var node = nodesMapping.get(astNode)
		val elementType = astNode.elementType
		if (elementType instanceof IGrammarAwareElementType) {
			val grammarElement = elementType.grammarElement
			while (node instanceof ICompositeNode && node.grammarElement !== grammarElement)
				node = (node as ICompositeNode).firstChild
		}
		return node
	}

	def ASTNode getASTNode(INode node) {
		if(node === null) return null
		
		var index = 0
		var originalNode = node
		while (originalNode instanceof SyntheticCompositeNode) {
			originalNode = originalNode.getParent()
			index++
		}
		val astNodes = reverseNodesMapping.get(originalNode)
		if (astNodes === null && node.rootNode === node) {
			return xtextFile.node.firstChildNode
		}
		return astNodes.get(index)
	}

}