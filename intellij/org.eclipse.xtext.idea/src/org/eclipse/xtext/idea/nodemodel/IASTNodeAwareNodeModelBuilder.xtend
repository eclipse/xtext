package org.eclipse.xtext.idea.nodemodel

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.impl.source.tree.LeafElement
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage
import com.google.inject.ImplementedBy

@ImplementedBy(ASTNodeAwareNodeModelBuilder)
interface IASTNodeAwareNodeModelBuilder {

	def Map<ASTNode, INode> getNodesMapping()

	def Map<INode, List<ASTNode>> getReverseNodesMapping()

	def ILeafNode newLeafNode(ASTNode astNode, ICompositeNode parent)

	def ILeafNode newLeafNode(LeafElement leafElement, EObject grammarElement, ICompositeNode parent)

	def ICompositeNode newCompositeNode(CompositeElement compositeElement, ICompositeNode parent)

	def ICompositeNode newCompositeNodeAsParentOf(CompositeElement compositeElement, EObject grammarElement, int lookahead, ICompositeNode existing)

	def ICompositeNode newRootNode(PsiFile psiFile)

	def void associateWithSemanticElement(ICompositeNode node, EObject astElement)
	
	def INode setSyntaxError(INode node, SyntaxErrorMessage errorMessage)

	def ICompositeNode compressAndReturnParent(ICompositeNode compositeNode)

}