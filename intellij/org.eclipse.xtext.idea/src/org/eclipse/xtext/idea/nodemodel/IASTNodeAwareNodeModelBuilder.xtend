package org.eclipse.xtext.idea.nodemodel

import com.google.inject.ImplementedBy
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage

@ImplementedBy(ASTNodeAwareNodeModelBuilder)
interface IASTNodeAwareNodeModelBuilder {

	val HIDDEN_KEY = Key.<Boolean>create('HIDDEN_KEY')

	val LOOK_AHEAD_KEY = Key.<Integer>create('LOOK_AHEAD_KEY')

	val TOKEN_TYPE_KEY = Key.<IElementType>create("TOKEN_TYPE_KEY");

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