/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import com.intellij.lang.ASTNode
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.impl.source.tree.LeafElement
import java.io.Reader
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Action
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumLiteralDeclaration
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.idea.lang.GrammarAwarePsiErrorElement
import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.parser.IParser
import org.eclipse.xtext.parser.ParseResult
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.xtext.RuleNames

import static extension org.eclipse.xtext.GrammarUtil.*

class PsiToEcoreTransformator implements IParser {

	@Accessors(PUBLIC_SETTER)
	BaseXtextFile xtextFile
	
	@Inject
	extension RuleNames ruleNames

	@Accessors(PUBLIC_GETTER)
	var PsiToEcoreAdapter adapter

	@Inject
	extension PsiToEcoreTransformationContext.PsiToEcoreTransformationContextProvider

	override parse(Reader reader) {
		ProgressIndicatorProvider.checkCanceled
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
			child.transformNode(transformationContext)
		}
		transformationContext
	}

	protected dispatch def void transformNode(ASTNode it,
		extension PsiToEcoreTransformationContext transformationContext
	) {
		throw new IllegalStateException('Unexpected ast node: ' + it)
	}

	protected dispatch def void transformNode(LeafElement it,
		extension PsiToEcoreTransformationContext transformationContext) {
		val elementType = elementType
		if (elementType instanceof IGrammarAwareElementType) {
			transform(elementType.grammarElement, elementType, transformationContext)
		} else {
			newLeafNode
		}
	}

	protected dispatch def void transformNode(CompositeElement it,
		extension PsiToEcoreTransformationContext transformationContext) {
		ProgressIndicatorProvider.checkCanceled
		switch it {
			GrammarAwarePsiErrorElement:
				grammarElement.ensureModelElementCreated
			PsiErrorElement: {
				transformChildren(transformationContext)
				appendSyntaxError
			}
			default: {
				val elementType = elementType
				if (elementType instanceof IGrammarAwareElementType) {
					transform(elementType.grammarElement, elementType, transformationContext)
				}
			}
		}
	}

	protected def dispatch void transform(ASTNode it, EObject grammarElement,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		throw new IllegalStateException('Unexpected grammar element: ' + grammarElement + ', for node: ' + it)
	}
	
	protected def dispatch void transform(LeafElement it, EnumLiteralDeclaration enumLiteralDeclaration,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext  transformationContext) {
		transformationContext.enumerator = enumLiteralDeclaration.enumLiteral.instance
		newLeafNode(enumLiteralDeclaration, enumLiteralDeclaration.literal.value)
	}

	protected def dispatch void transform(LeafElement it, Keyword keyword,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		newLeafNode(keyword, keyword.value)
	}

	protected def dispatch void transform(LeafElement it, RuleCall ruleCall,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		switch rule : ruleCall.rule {
			TerminalRule:
				newLeafNode(ruleCall, rule.qualifiedName)
			default:
				throw new IllegalStateException('Unexpected rule: ' + rule)
		}
	}

	protected def dispatch void transform(CompositeElement it, ParserRule rule,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		newCompositeNode
		transformChildren(transformationContext)
		compress
	}

	protected def dispatch void transform(CompositeElement it, Action action,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		if (elementType.isInFragmentRule) {
			transformationContext.createModelInParentNode = true
			val actionTransformationContext = transformationContext.branch
			transformActionLeftElement(action, actionTransformationContext)
			actionTransformationContext.sync
			
			val actionRuleCall = actionTransformationContext.actionRuleCall
			if (ensureModelElementCreated(actionRuleCall)) {
				if (transformationContext.current !== null && transformationContext.current.eContainer === null) {
					actionTransformationContext.assign(transformationContext.current, action)
				} else { 
					assign(actionTransformationContext.current, actionRuleCall, actionRuleCall.rule.qualifiedName)
				}
			}
			actionTransformationContext.merge(true)
			compress
		} else {
			transformationContext.createModelInParentNode = false
			val actionTransformationContext = transformationContext.branch
			transformActionLeftElement(action, actionTransformationContext)
			actionTransformationContext.sync
			
			val actionRuleCall = actionTransformationContext.actionRuleCall
			if (ensureModelElementCreated(actionRuleCall)) {
				assign(actionTransformationContext.current, actionRuleCall, actionRuleCall.rule.qualifiedName)
			}
			actionTransformationContext.merge
			compress
		}
	}
	
	protected dispatch def void transformFirstNoneActionChild(ASTNode it, extension PsiToEcoreTransformationContext transformationContext) {
		throw new IllegalStateException('Unexpected ast node: ' + it)
	}

	protected dispatch def void transformFirstNoneActionChild(LeafElement it,
		extension PsiToEcoreTransformationContext transformationContext) {
		val elementType = elementType
		if (elementType instanceof IGrammarAwareElementType) {
			transform(elementType.grammarElement, elementType, transformationContext)
		} else {
			newLeafNode
		}
	}

	protected dispatch def void transformFirstNoneActionChild(CompositeElement it,
		extension PsiToEcoreTransformationContext transformationContext) {
		switch it {
			GrammarAwarePsiErrorElement:
				grammarElement.ensureModelElementCreated
			PsiErrorElement: {
				transformChildren(transformationContext)
				appendSyntaxError
			}
			default: {
				val elementType = elementType
				if (elementType instanceof IGrammarAwareElementType) {
					transformFirstNoneActionChild(elementType.grammarElement, elementType, transformationContext)
				}
			}
		}
	}
	
	protected def dispatch void transformFirstNoneActionChild(CompositeElement it, EObject element,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		throw new IllegalStateException('Unexpected grammar element: ' + element.eClass.name)
	}
	
	protected def dispatch void transformFirstNoneActionChild(CompositeElement it, Action action,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		val firstChild = getChildren(null).head
		firstChild.transformFirstNoneActionChild(transformationContext)
	}
	
	protected def dispatch void transformFirstNoneActionChild(CompositeElement it, AbstractElement action,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		transformNode(transformationContext)
	}
	
	protected def dispatch void transformFirstNoneActionChild(CompositeElement it, ParserRule rule,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		newCompositeNode
		transformChildren(transformationContext)
	}
	
	protected def dispatch void transformActionLeftElementNode(ASTNode it,
		
		extension PsiToEcoreTransformationContext transformationContext) {
		throw new IllegalStateException('Unexpected ast node: ' + it)
	}

	protected def dispatch void transformActionLeftElementNode(CompositeElement it,
		extension PsiToEcoreTransformationContext transformationContext) {
		val elementType = elementType
		if (elementType instanceof IGrammarAwareElementType) {
			transformActionLeftElement(elementType.grammarElement, transformationContext)
		}
	}

	protected def dispatch void transformActionLeftElement(CompositeElement it, EObject grammarElement,
		
		extension PsiToEcoreTransformationContext transformationContext) {
		throw new IllegalStateException('Unexpected grammar element: ' + grammarElement + ', for node: ' + it)
	}
	
	protected def dispatch void transformActionLeftElement(CompositeElement it, ParserRule parserRule,
		extension PsiToEcoreTransformationContext transformationContext) {
		newCompositeNode
		transformChildren(transformationContext)
	}

	protected def dispatch void transformActionLeftElement(CompositeElement it, Action action,
		extension PsiToEcoreTransformationContext transformationContext) {
		
		newCompositeNode
		ensureModelElementCreated(action)
		
		val children = getChildren(null)
		
		val leftElement = children.head
		val leftElementTransformationContext = transformationContext.branch
		leftElement.transformActionLeftElementNode(leftElementTransformationContext)
		leftElementTransformationContext.compress.sync
		leftElementTransformationContext.current.assign(action)
		
		actionRuleCall = leftElementTransformationContext.actionRuleCall

		children.tail.transformChildren(transformationContext)
	}

	protected def dispatch void transformActionLeftElement(CompositeElement it, RuleCall ruleCall,
		extension PsiToEcoreTransformationContext transformationContext) {
		newCompositeNode
		transformationContext.actionRuleCall = ruleCall
		transformChildren(transformationContext)
	}

	protected def dispatch void transform(CompositeElement it, RuleCall ruleCall,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		switch rule : ruleCall.rule {
			ParserRule case rule.datatypeRule: {
				newCompositeNode
				val childTransformationContext = transformationContext.branch.withDatatypeRule
				transformChildren(childTransformationContext).sync
				if (ruleCall.ensureModelElementCreated) {
					val datatypeRuleToken = childTransformationContext.datatypeRuleToken
					assign(datatypeRuleToken, ruleCall, rule.qualifiedName)
				}
				childTransformationContext.merge
				compress
			}
			ParserRule case rule.isFragment: {
				ruleCall.ensureModelElementCreated
				newCompositeNode
				val childTransformationContext = transformationContext.branchAndKeepCurrent
				transformChildren(childTransformationContext).sync
				childTransformationContext.merge
				compress
			}
			EnumRule,
			ParserRule: {
				newCompositeNode
				val childTransformationContext = transformationContext.branch
				transformChildren(childTransformationContext).sync
				if (ruleCall.ensureModelElementCreated) {
					val child = if (rule instanceof ParserRule) childTransformationContext.current else childTransformationContext.enumerator 
					if (child != null) {
						assign(child, ruleCall, rule.qualifiedName)
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
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		crossReference.ensureModelElementCreated
		newLeafNode
	}

	protected def dispatch void transform(CompositeElement it, CrossReference crossReference,
		IGrammarAwareElementType elementType,
		extension PsiToEcoreTransformationContext transformationContext) {
		newCompositeNode
		crossReference.ensureModelElementCreated
		transformChildren(transformationContext)
		compress
	}

	protected def transformChildren(CompositeElement it,
		extension PsiToEcoreTransformationContext transformationContext) {
		val children = getChildren(null)
		children.transformChildren(transformationContext)
	}

	protected def transformChildren(Iterable<ASTNode> children, PsiToEcoreTransformationContext transformationContext) {
		for (child : children) {
			child.transformNode(transformationContext)
		}
		transformationContext
	}

	override parse(ParserRule rule, Reader reader) {
		throw new UnsupportedOperationException("Unexpected invocation")
	}

	override parse(RuleCall ruleCall, Reader reader, int initialLookAhead) {
		throw new UnsupportedOperationException("Unexpected invocation")
	}

	override reparse(IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		throw new UnsupportedOperationException("Unexpected invocation")
	}

}
