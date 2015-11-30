/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.tests.parsing

import com.google.inject.Inject
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiErrorElement
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.resource.XtextResource
import org.junit.Assert

import static org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder.*

import static extension org.eclipse.xtext.util.EmfFormatter.*
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.idea.nodemodel.ASTNodeExtension

class XtextResourceAsserts extends Assert {

	@Inject
	@Accessors(PUBLIC_GETTER)
	extension NodeModelPrinter nodeModelPrinter

	@Inject
	extension InvariantChecker invariantChecker
	
	@Inject
	extension ASTNodeExtension astNodeExtension

	def assertResource(XtextResource expectedResource, XtextResource actualResource) {
		assertResource(expectedResource, actualResource, true)
	}

	def assertResource(XtextResource expectedResource, XtextResource actualResource, boolean resolve) {
		val expectedRootNode = expectedResource.parseResult.rootNode
		val actualRootNode = actualResource.parseResult.rootNode
		assertEquals(expectedRootNode.print, actualRootNode.print)

		if (resolve) {
			EcoreUtil2.resolveLazyCrossReferences(expectedResource, null)
			EcoreUtil2.resolveLazyCrossReferences(actualResource, null)
		}

		val expectedRootASTElement = expectedResource.parseResult.rootASTElement
		val actualRootASTElement = actualResource.parseResult.rootASTElement
		assertEquals(expectedRootASTElement.objToStr, actualRootASTElement.objToStr)

		actualRootNode.checkInvariant
		val psiToEcoreAdapter = PsiToEcoreAdapter.findInEmfObject(actualResource)
		val rootASTNode = psiToEcoreAdapter.xtextFile.firstChild.node
		assertASTNode(rootASTNode, actualRootNode, psiToEcoreAdapter)

		assertEquals(
			rootASTNode.printAST,
			psiToEcoreAdapter.getINode(rootASTNode).printAST(psiToEcoreAdapter)
		)
	}

	protected def void assertASTNode(ASTNode astNode, ICompositeNode rootNode, PsiToEcoreAdapter psiToEcoreAdapter) {
		if (!(astNode instanceof PsiErrorElement)) {
			val node = psiToEcoreAdapter.getINode(astNode)
			assertNotNull('''The node is null the ast node: «astNode»''', node)
			assertTrue(
				'''The node «node» is not a part of the tree for the ast node: «astNode»''',
				node.belongsTo(rootNode)
			)

			assertEquals(astNode, psiToEcoreAdapter.getASTNode(node))
			
			val semanticElement = node.semanticElement
			if (semanticElement !== null) {
//				TODO : assert all features				
//				for (feature : semanticElement.eClass.EStructuralFeatures) {
//					val nodes = NodeModelUtils.findNodesForFeature(node.semanticElement,  feature)
//					val astNodes = astNode.findNodesForFeature(feature)
//					assertEquals(nodes.size, astNodes.size)
//					for (var i = 0; i < nodes.size; i++)
//						assertEquals(
//							astNodes.get(i),
//							psiToEcoreAdapter.getASTNode(nodes.get(i))
//						)
//				}
				val feature = semanticElement.eClass.getEStructuralFeature('name')
				if (feature instanceof EAttribute && !feature.many && String.isAssignableFrom(feature.EType.instanceClass)) {
					val nodes = NodeModelUtils.findNodesForFeature(node.semanticElement,  feature)
					val astNodes = astNode.findNodesForFeature(feature)
					assertEquals(nodes.size, astNodes.size)
					for (var i = 0; i < nodes.size; i++)
						assertEquals(
							astNodes.get(i),
							psiToEcoreAdapter.getASTNode(nodes.get(i))
						)
				}
			}
		}
		for (child : astNode.getChildren(null)) {
			assertASTNode(child, rootNode, psiToEcoreAdapter)
		}
	}

	protected def String printAST(ASTNode astNode) {
		if (astNode instanceof PsiErrorElement)
			return astNode.firstChildNode?.printAST

		'''
			«astNode» {
				hasSemanticElement: «astNode.getUserData(HAS_SEMANTIC_ELEMENT_KEY) ?: false»
				«FOR child : astNode.getChildren(null).map[printAST].filterNull»
					«child»
				«ENDFOR»
			}
		'''
	}

	protected def String printAST(INode node, PsiToEcoreAdapter psiToEcoreAdapter) {
		val astNode = psiToEcoreAdapter.getASTNode(node)
		val children = if (node instanceof ICompositeNode) node.children else emptyList
		'''
			«astNode» {
				hasSemanticElement: «node.hasDirectSemanticElement»
				«FOR child : children»
					«child.printAST(psiToEcoreAdapter)»
				«ENDFOR»
			}
		'''
	}

	protected def belongsTo(INode node, ICompositeNode rootNode) {
		rootNode.asTreeIterable.exists[it == node]
	}

}