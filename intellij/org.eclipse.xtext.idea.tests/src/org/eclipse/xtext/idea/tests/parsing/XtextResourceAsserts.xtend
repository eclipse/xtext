package org.eclipse.xtext.idea.tests.parsing

import com.google.inject.Inject
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.resource.XtextResource
import org.junit.Assert

import static extension org.eclipse.xtext.util.EmfFormatter.*

class XtextResourceAsserts extends Assert {

	@Inject
	extension NodeModelPrinter nodeModelPrinter

	@Inject
	extension InvariantChecker invariantChecker
	
	def assertResource(XtextResource expectedResource, XtextResource actualResource) {
		val expectedRootNode = expectedResource.parseResult.rootNode
		val actualRootNode = actualResource.parseResult.rootNode
		assertEquals(expectedRootNode.print, actualRootNode.print)
		
		val expectedRootASTElement = expectedResource.parseResult.rootASTElement
		val actualRootASTElement = actualResource.parseResult.rootASTElement
		assertEquals(expectedRootASTElement.objToStr, actualRootASTElement.objToStr)
		
		actualRootNode.checkInvariant
		val nodesMapping = PsiToEcoreAdapter.get(actualResource).nodesMapping
		for (astNode : nodesMapping.keySet) {
			val node = nodesMapping.get(astNode)
			assertTrue('''Node «node» is not a part of the tree''', node.belongsTo(actualRootNode))
		}
	}

	protected def belongsTo(INode node, ICompositeNode rootNode) {
		rootNode.asTreeIterable.exists[it == node]
	}
	
}