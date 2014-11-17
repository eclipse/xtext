package org.eclipse.xtext.idea.nodemodel

import com.google.inject.Inject
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.AbstractNode
import org.eclipse.xtext.nodemodel.impl.CompositeNode
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder
import org.eclipse.xtext.nodemodel.impl.RootNode
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.parser.antlr.TokenTool.*

class ASTNodeAwareNodeModelBuilder extends NodeModelBuilder implements IASTNodeAwareNodeModelBuilder {

	public static val HIDDEN_KEY = Key.<Boolean>create('HIDDEN_KEY')

	public static val LOOK_AHEAD_KEY = Key.<Integer>create('LOOK_AHEAD_KEY')

	public static val TOKEN_TYPE_KEY = Key.<IElementType>create("TOKEN_TYPE_KEY");

	@Inject
	IGrammarAccess grammarAccess

	@Accessors(PUBLIC_GETTER)
	val Map<ASTNode, INode> nodesMapping = newHashMap

	@Accessors(PUBLIC_GETTER)
	val Map<INode, List<ASTNode>> reverseNodesMapping = newHashMap

	protected def void associate(ASTNode astNode, INode node) {
		nodesMapping.put(astNode, node)
		val reverseMapping = reverseNodesMapping.get(node) ?: {
			val result = newArrayList
			reverseNodesMapping.put(node, result)
			result
		}
		reverseMapping.add(astNode)
	}
	
	protected def replaceAssociations(INode oldNode, INode newNode) {
		val mapping = reverseNodesMapping.remove(oldNode)
		if (mapping != null) {
			for (astNode : mapping) {
				associate(astNode, newNode)
			}
		}
	}
	
	protected def removeAssociations(INode node) {
		val mapping = reverseNodesMapping.remove(node)
		if (mapping != null) {
			for (astNode : mapping) {
				nodesMapping.remove(astNode)
			}
		}
	}
	
	override protected replaceByRootNode(CompositeNode oldNode, RootNode rootNode) {
		val firstChild = rootNode.firstChild
		super.replaceByRootNode(oldNode, rootNode)
		if (firstChild != null) {
			removeAssociations(firstChild)
		}
		replaceAssociations(oldNode, rootNode)
	}
	
	override protected replaceChildren(AbstractNode oldNode, AbstractNode newNode) {
		super.replaceChildren(oldNode, newNode)
		replaceAssociations(oldNode, newNode)
	}

	override newLeafNode(LeafElement it, EObject grammarElement, ICompositeNode parent) {
		val leafNode = newLeafNode(startOffset, textLength, grammarElement, false, null, parent) 
		associate(leafNode)
		leafNode
	}

	override newLeafNode(ASTNode it, ICompositeNode parent) {
		val elementType = elementType
		val grammarElement = if (elementType instanceof IGrammarAwareElementType) {
				elementType.grammarElement
			} else {
				val tokenType = getUserData(TOKEN_TYPE_KEY)
				if (tokenType != null) {
					val tokenName = tokenType.toString
					if (tokenName.lexerRule) {
						val ruleName = tokenName.getLexerRuleName
						grammarAccess.grammar.allRules.findFirst[name == ruleName]
					}
				}
			}
		val hidden = getUserData(HIDDEN_KEY) ?: false
		val leafNode = newLeafNode(startOffset, textLength, grammarElement, hidden, null, parent) 
		associate(leafNode)
		leafNode
	}

	override newCompositeNode(CompositeElement it, ICompositeNode parent) {
		val elementType = elementType
		if (elementType instanceof IGrammarAwareElementType) {
			val grammarElement = elementType.grammarElement
			val lookAhead = getUserData(LOOK_AHEAD_KEY)
			val compositeNode = grammarElement.newCompositeNode(lookAhead, parent) 
			associate(compositeNode)
			compositeNode
		} else {
			throw new IllegalStateException('Composite element with unexpected element type: ' + it)
		}
	}
	
	override newCompositeNodeAsParentOf(CompositeElement it, EObject grammarElement, int lookahead, ICompositeNode existing) {
		val compositeNode = grammarElement.newCompositeNodeAsParentOf(lookahead, existing) 
		associate(compositeNode)
		compositeNode
	}
	
	override newRootNode(PsiFile psiFile) {
		newRootNode(psiFile.text)
	}

}
