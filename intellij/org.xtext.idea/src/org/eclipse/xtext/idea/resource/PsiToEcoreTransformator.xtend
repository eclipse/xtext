package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.impl.source.tree.LeafElement
import java.io.Reader
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.parser.IParser
import org.eclipse.xtext.parser.ParseResult
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType
import org.eclipse.xtext.util.ReplaceRegion

import static extension org.eclipse.xtext.GrammarUtil.*
import org.eclipse.xtext.Action

class PsiToEcoreTransformator implements IParser {

	@Accessors(PUBLIC_SETTER)
	BaseXtextFile xtextFile
	
	@Accessors(PUBLIC_GETTER)
	var PsiToEcoreAdapter adapter

	@Inject
	extension PsiToEcoreTransformationContext.PsiToEcoreTransformationContextProvider

	override parse(Reader reader) {
		val transformationContext = transform
		
		adapter = new PsiToEcoreAdapter(transformationContext)
		
		val rootAstElement = transformationContext.current
		val rootNode = transformationContext.currentNode
		val hadErrors = transformationContext.hadErrors
		new ParseResult(rootAstElement, rootNode, hadErrors)
	}

	protected def transform() {
		val transformationContext = xtextFile.newTransformationContext
		for (child : xtextFile.node.getChildren(null)) {
			child.transform(transformationContext)
		}
		transformationContext
	}

	protected dispatch def void transform(ASTNode it, extension PsiToEcoreTransformationContext transformationContext) {
		throw new IllegalStateException('Unexpected ast node: ' + it)
	}

	protected dispatch def void transform(LeafElement it,
		extension PsiToEcoreTransformationContext transformationContext) {
		val elementType = elementType
		if (elementType instanceof IGrammarAwareElementType) {
			transform(elementType.grammarElement, transformationContext)	
		} else {
			newLeafNode
		}
	}

	protected dispatch def void transform(CompositeElement it,
		extension PsiToEcoreTransformationContext transformationContext) {
		if (it instanceof PsiErrorElement) {
			transformChildren(transformationContext)
			appendSyntaxError
		} else {
			val elementType = elementType
			if (elementType instanceof IGrammarAwareElementType) {
				transform(elementType.grammarElement, transformationContext)
			}
		}
	}

	protected def dispatch void transform(ASTNode it, EObject grammarElement,
		extension PsiToEcoreTransformationContext transformationContext) {
		throw new IllegalStateException('Unexpected grammar element: ' + grammarElement + ', for node: ' + it)
	}

	protected def dispatch void transform(LeafElement it, Keyword keyword,
		extension PsiToEcoreTransformationContext transformationContext) {
		newLeafNode(keyword, keyword.value)
	}

	protected def dispatch void transform(LeafElement it, RuleCall ruleCall,
		extension PsiToEcoreTransformationContext transformationContext) {
		switch rule : ruleCall.rule {
			TerminalRule:
				newLeafNode(ruleCall, rule.name)
			default:
				throw new IllegalStateException('Unexpected rule: ' + rule)
		}
	}

	protected def dispatch void transform(CompositeElement it, ParserRule rule,
		extension PsiToEcoreTransformationContext transformationContext) {
		newCompositeNode
		transformChildren(transformationContext)
		compress
	}
	
	protected def dispatch void transform(CompositeElement it, Action action,
		extension PsiToEcoreTransformationContext transformationContext) {
		val value = current
		action.forceCreateModelElement
		assign(value, action)
		newCompositeNodeAsParentOfCurrentNode(action)
	}

	protected def dispatch void transform(CompositeElement it, RuleCall ruleCall,
		extension PsiToEcoreTransformationContext transformationContext) {
		switch rule : ruleCall.rule {
			ParserRule case rule.datatypeRule: {
				newCompositeNode
				val childTransformationContext = transformationContext.branch.withDatatypeRule 
				transformChildren(childTransformationContext).sync
				if (ruleCall.ensureModelElementCreated) {
					val datatypeRuleToken = childTransformationContext.datatypeRuleToken
					assign(datatypeRuleToken, ruleCall, rule.name)
				}
				childTransformationContext.merge
				compress
			}
			EnumRule,
			ParserRule: {
				newCompositeNode
				val childTransformationContext = transformationContext.branch
				transformChildren(childTransformationContext).sync
				if (ruleCall.ensureModelElementCreated) {
					val child = childTransformationContext.current
					if (child != null) {
						assign(child, ruleCall, rule.name)
					}	
				}
				childTransformationContext.merge
				compress
			}
			default:
				throw new IllegalStateException('Unexpected rule: ' + rule)
		}
	}

	protected def dispatch void transform(LeafElement it, CrossReference crossReference,
		extension PsiToEcoreTransformationContext transformationContext) {
		crossReference.ensureModelElementCreated
		newLeafNode
	}

	protected def dispatch void transform(CompositeElement it, CrossReference crossReference,
		extension PsiToEcoreTransformationContext transformationContext) {
		newCompositeNode
		crossReference.ensureModelElementCreated
		transformChildren(transformationContext)
		compress
	}
	
	protected def transformChildren(CompositeElement it, extension PsiToEcoreTransformationContext transformationContext) {
		for (child : getChildren(null)) {
			child.transform(transformationContext)
		}
		transformationContext
	}

	override parse(ParserRule rule, Reader reader) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override parse(RuleCall ruleCall, Reader reader, int initialLookAhead) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override reparse(IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
