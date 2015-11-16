/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.nodemodel

import com.google.inject.Singleton
import com.intellij.lang.ASTNode
import com.intellij.psi.impl.source.tree.RecursiveTreeElementWalkingVisitor
import com.intellij.psi.impl.source.tree.TreeElement
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.Action
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

import static extension org.eclipse.xtext.GrammarUtil.*
import com.intellij.psi.PsiErrorElement

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class ASTNodeExtension {

	def List<ASTNode> findNodesForFeature(ASTNode node, EStructuralFeature structuralFeature) {
		val actualNode = node.findActualNodeFor(structuralFeature.EContainingClass)
		if (actualNode instanceof TreeElement)
			return actualNode.findNodesForFeature(structuralFeature)

		return emptyList
	}

	protected def ASTNode findActualNodeFor(ASTNode node, EClass type) {
		if(node === null || type === null) return null

		var result = node
		while (result !== null &&
			!(result.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY) ?: false))
			result = result.treeParent

		val actualType = result.EClass
		if (EcoreUtil2.isAssignableFrom(type, actualType))
			return result

		return null
	}

	protected def List<ASTNode> findNodesForFeature(
		TreeElement treeElement,
		EStructuralFeature structuralFeature
	) {
		val result = <ASTNode>newArrayList
		val featureName = structuralFeature.name
		treeElement.acceptTree(new RecursiveTreeElementWalkingVisitor() {

			override protected visitNode(TreeElement element) {
				if (element instanceof PsiErrorElement)
					return;

				if (element === treeElement) {
					super.visitNode(element)
					return;
				}
				
				val grammarElement = element.grammarElement
				if (grammarElement instanceof Action) {
					var firstChild = element.firstChildNode
					while (firstChild.grammarElement instanceof Action)
						firstChild = firstChild.firstChildNode
					
					val assignment = firstChild.grammarElement.containingAssignment
					if (assignment !== null && featureName == assignment.feature)
						result += element
					
					return;
				}

				if (grammarElement !== null) {
					val assignment = grammarElement.containingAssignment
					if (assignment !== null) {
						if (featureName == assignment.feature)
							result += element
						return;
					}
				}
				super.visitNode(element)
			}

		})
		return result
	}

	def EClass getEClass(ASTNode node) {
		val grammarElement = node.grammarElement
		if(grammarElement === null) return null

		val type = switch grammarElement {
			Action: grammarElement.type
			RuleCall: grammarElement.rule?.type
			default: grammarElement.containingRule.type
		}
		val classifier = type?.classifier
		if (classifier instanceof EClass)
			return classifier

		return null
	}

	def getGrammarElement(ASTNode element) {
		val elementType = element?.elementType
		if (elementType instanceof IGrammarAwareElementType)
			elementType.grammarElement
	}

}