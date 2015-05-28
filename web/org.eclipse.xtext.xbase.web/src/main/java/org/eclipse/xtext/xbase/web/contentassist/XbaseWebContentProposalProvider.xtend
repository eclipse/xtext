/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.contentassist

import com.google.common.base.Predicate
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Group
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBasicForLoopExpression
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.conversion.XbaseQualifiedNameValueConverter
import org.eclipse.xtext.xbase.scoping.SyntaxFilteredScopes
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IExpressionScope
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xtype.XtypePackage

import static extension org.eclipse.xtext.xbase.web.contentassist.TypeMatchFilters.*

class XbaseWebContentProposalProvider extends WebContentProposalProvider {

	static class ValidFeatureDescription implements Predicate<IEObjectDescription> {
		@Inject OperatorMapping operatorMapping

		override boolean apply(IEObjectDescription input) {
			if (input instanceof IIdentifiableElementDescription) {
				if (!input.isVisible || !input.isValidStaticState)
					return false
				// Filter operator method names from content assist
				if (input.name.firstSegment.startsWith("operator_")) {
					return operatorMapping.getOperator(input.name) === null
				}
			}
			return true
		}
	}
	
	@Inject extension XbaseGrammarAccess

	@Inject ITypesProposalProvider typeProposalProvider
	
	@Inject ValidFeatureDescription featureDescriptionPredicate
	
	@Inject XbaseQualifiedNameValueConverter qualifiedNameValueConverter
	
	@Inject IBatchTypeResolver typeResolver
	
	@Inject SyntaxFilteredScopes syntaxFilteredScopes
	
	override filterKeyword(Keyword keyword, ContentAssistContext context) {
		if (!super.filterKeyword(keyword, context))
			return false
		if (keyword.value == 'as' || keyword.value == 'instanceof') {
			val previousModel = context.previousModel
			if (previousModel instanceof XExpression) {
				if (context.prefix.length == 0 && NodeModelUtils.getNode(previousModel).endOffset > context.offset) {
					return false
				}
				var LightweightTypeReference type = typeResolver.resolveTypes(previousModel).getActualType(
					previousModel as XExpression)
				if (type === null || type.isPrimitiveVoid) {
					return false
				}
			}
		}
		return true
	}
	
	override dispatch createProposals(RuleCall ruleCall, ContentAssistContext context,
			IWebContentProposaAcceptor acceptor) {
		switch (ruleCall.rule) {
			case XExpressionRule: {
				if (ruleCall.eContainer instanceof Group && GrammarUtil.containingRule(ruleCall).name == 'XParenthesizedExpression') {
					createLocalVariableAndImplicitProposals(context.currentModel, IExpressionScope.Anchor.WITHIN, context, acceptor)
				}
			}
			default: {
				super._createProposals(ruleCall, context, acceptor)
			}
		}
	}

	override dispatch createProposals(Assignment assignment, ContentAssistContext context,
			IWebContentProposaAcceptor acceptor) {
		val model = context.currentModel
		switch (assignment) {
			
			case XFeatureCallAccess.featureAssignment_2:
				completeXFeatureCall(model, context, acceptor)
			
			case XMemberFeatureCallAccess.featureAssignment_1_0_0_0_2,
			case XMemberFeatureCallAccess.featureAssignment_1_1_2:
				completeXMemberFeatureCall(model, assignment, context, acceptor)
			
			case XBlockExpressionAccess.expressionsAssignment_2_0,
			case XExpressionInClosureAccess.expressionsAssignment_1_0:
				completeWithinBlock(model, context, acceptor)
			
			case XAssignmentAccess.featureAssignment_0_1,
			case XAssignmentAccess.featureAssignment_1_1_0_0_1:
				completeXAssignment(model, assignment, context, acceptor)
			
			case jvmParameterizedTypeReferenceAccess.typeAssignment_0,
			case jvmParameterizedTypeReferenceAccess.typeAssignment_1_4_1:
				completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor)
			
			case XRelationalExpressionAccess.typeAssignment_1_0_1:
				completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor)
				
			case XImportDeclarationAccess.importedTypeAssignment_1_0_2,
			case XImportDeclarationAccess.importedTypeAssignment_1_1:
				completeJavaTypes(context, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, true, acceptor)
			
			case XTypeLiteralAccess.typeAssignment_3:
				completeJavaTypes(context, XbasePackage.Literals.XTYPE_LITERAL__TYPE, true, acceptor)
			
			case XConstructorCallAccess.constructorAssignment_2:
				completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true,
					qualifiedNameValueConverter, !(INTERNAL || ABSTRACT || INTERFACE), acceptor)
			
			case XForLoopExpressionAccess.eachExpressionAssignment_3,
			case XSwitchExpressionAccess.defaultAssignment_5_2,
			case XCasePartAccess.caseAssignment_2_1,
			case XCatchClauseAccess.expressionAssignment_4,
			case XBasicForLoopExpressionAccess.updateExpressionsAssignment_7_0,
			case XBasicForLoopExpressionAccess.updateExpressionsAssignment_7_1_1,
			case XBasicForLoopExpressionAccess.expressionAssignment_5,
			case XBasicForLoopExpressionAccess.eachExpressionAssignment_9,
			case XClosureAccess.expressionAssignment_2,
			case XShortClosureAccess.expressionAssignment_1:
				createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
			
			case XForLoopExpressionAccess.forExpressionAssignment_1,
			case XVariableDeclarationAccess.rightAssignment_3_1:
				createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor)
			
			case XCasePartAccess.thenAssignment_3_0_1:
				createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor)
			
			case XOrExpressionAccess.featureAssignment_1_0_0_1,
			case XAndExpressionAccess.featureAssignment_1_0_0_1,
			case XEqualityExpressionAccess.featureAssignment_1_0_0_1,
			case XRelationalExpressionAccess.featureAssignment_1_1_0_0_1,
			case XOtherOperatorExpressionAccess.featureAssignment_1_0_0_1,
			case XAdditiveExpressionAccess.featureAssignment_1_0_0_1,
			case XMultiplicativeExpressionAccess.featureAssignment_1_0_0_1,
			case XPostfixOperationAccess.featureAssignment_1_0_1:
				completeBinaryOperation(model, assignment, context, acceptor)
			
			case XBasicForLoopExpressionAccess.initExpressionsAssignment_3_0,
			case XBasicForLoopExpressionAccess.initExpressionsAssignment_3_1_1:
				completeXBasicForLoopInit(model, context, acceptor)
			
			// Don't propose unary operations
			case XUnaryOperationAccess.featureAssignment_0_1: {}
			
			default: {
				super._createProposals(assignment, context, acceptor)
			}
		}
	}
	
	protected def void completeJavaTypes(ContentAssistContext context, EReference reference,
			IWebContentProposaAcceptor acceptor) {
		completeJavaTypes(context, reference, false, qualifiedNameValueConverter, !INTERNAL, acceptor)
	}

	protected def void completeJavaTypes(ContentAssistContext context, EReference reference, boolean forced,
			IWebContentProposaAcceptor acceptor) {
		completeJavaTypes(context, reference, forced, qualifiedNameValueConverter, !INTERNAL, acceptor)
	}

	protected def void completeJavaTypes(ContentAssistContext context, EReference reference, boolean forced,
			IValueConverter<String> valueConverter, ITypeFilter filter, IWebContentProposaAcceptor acceptor) {
		val prefix = context.prefix
		if (prefix.length() > 0) {
			if (Character.isJavaIdentifierStart(prefix.charAt(0))) {
				if (!forced && !prefix.contains('.') && !prefix.contains('::') && !Character.isUpperCase(prefix.charAt(0))) {
					return
				}
				typeProposalProvider.createTypeProposals(context, reference, valueConverter, filter, acceptor)
			}
		} else if (forced) {
			val INode lastCompleteNode = context.getLastCompleteNode()
			if (lastCompleteNode instanceof ILeafNode && !(lastCompleteNode as ILeafNode).isHidden
					&& lastCompleteNode.length > 0 && lastCompleteNode.totalEndOffset == context.offset) {
				val text = lastCompleteNode.text
				if (Character.isJavaIdentifierPart(text.charAt(text.length - 1))) {
					return
				}
			}
			typeProposalProvider.createTypeProposals(context, reference, valueConverter, filter, acceptor)
		}
	}

	protected def completeXFeatureCall(EObject model, ContentAssistContext context, IWebContentProposaAcceptor acceptor) {
		if (model !== null) {
			if (typeResolver.resolveTypes(model).hasExpressionScope(model, IExpressionScope.Anchor.WITHIN)) {
				return
			}
		}
		if (model instanceof XMemberFeatureCall) {
			val node = NodeModelUtils.getNode(model)
			if (isInMemberFeatureCall(model, node.endOffset, context)) {
				return
			}
		}
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor)
	}

	protected def void completeWithinBlock(EObject model, ContentAssistContext context,
			IWebContentProposaAcceptor acceptor) {
		val node = NodeModelUtils.getNode(model)
		if (node.offset >= context.offset) {
			createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor)
			return
		}
		if (model instanceof XBlockExpression) {
			val children = (model as XBlockExpression).expressions
			for (var i = children.size - 1; i >= 0; i--) {
				val child = children.get(i)
				val childNode = NodeModelUtils.getNode(child)
				if (childNode.endOffset <= context.offset) {
					createLocalVariableAndImplicitProposals(child, IExpressionScope.Anchor.AFTER, context, acceptor)
					return
				}
			}
		}
		var int endOffset = node.endOffset
		if (endOffset <= context.offset) {
			if (model instanceof XFeatureCall && model.eContainer instanceof XClosure ||
				endOffset == context.offset && context.prefix.length == 0) return;
			if (isInMemberFeatureCall(model, endOffset, context)) {
				return
			}
			createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor)
			return
		}
		if (isInMemberFeatureCall(model, endOffset, context) || model instanceof XClosure) {
			return
		}
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor)
	}

	protected def boolean isInMemberFeatureCall(EObject model, int endOffset, ContentAssistContext context) {
		if (model instanceof XMemberFeatureCall && endOffset >= context.offset) {
			val featureNodes = NodeModelUtils.findNodesForFeature(model, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE)
			if (!featureNodes.empty) {
				val featureNode = featureNodes.head
				if (featureNode.totalOffset < context.offset &&
					featureNode.totalEndOffset >= context.offset) {
					return true
				}
			}
		}
		return false
	}

	protected def completeXAssignment(EObject model, Assignment assignment,
			ContentAssistContext context, IWebContentProposaAcceptor acceptor) {
		val ruleName = getConcreteSyntaxRuleName(assignment)
		if (isOperatorRule(ruleName)) {
			completeBinaryOperation(model, assignment, context, acceptor)
		}
	}

	protected def boolean isOperatorRule(String ruleName) {
		return ruleName !== null && ruleName.startsWith('Op')
	}

	protected def void completeBinaryOperation(EObject model, Assignment assignment,
			ContentAssistContext context, IWebContentProposaAcceptor acceptor) {
		if (model instanceof XBinaryOperation) {
			if (context.prefix.length() === 0) {
				val currentNode = context.currentNode
				val offset = currentNode.offset
				val endOffset = currentNode.endOffset
				if (offset < context.offset && endOffset >= context.offset) {
					if (currentNode.grammarElement instanceof CrossReference) {
						return
					}
				}
			}
			if (NodeModelUtils.findActualNodeFor(model).endOffset <= context.offset) {
				createReceiverProposals(model as XExpression, assignment.terminal as CrossReference,
					context, acceptor)
			} else {
				createReceiverProposals((model as XBinaryOperation).leftOperand,
					assignment.terminal as CrossReference, context, acceptor)
			}
		} else {
			val previousModel = context.previousModel
			if (previousModel instanceof XExpression) {
				if (context.prefix.length === 0) {
					if (NodeModelUtils.getNode(previousModel).endOffset > context.offset) {
						return
					}
				}
				createReceiverProposals(previousModel as XExpression,
					assignment.terminal as CrossReference, context, acceptor)
			}
		}
	}

	protected def completeXBasicForLoopInit(EObject model, ContentAssistContext context,
			IWebContentProposaAcceptor acceptor) {
		val node = NodeModelUtils.getNode(model)
		if (node.offset >= context.offset) {
			createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor)
			return
		}
		if (model instanceof XBasicForLoopExpression) {
			val children = (model as XBasicForLoopExpression).initExpressions
			for (var i = children.size - 1; i >= 0; i--) {
				val child = children.get(i)
				val childNode = NodeModelUtils.getNode(child)
				if (childNode.endOffset <= context.offset) {
					createLocalVariableAndImplicitProposals(child, IExpressionScope.Anchor.AFTER, context, acceptor)
					return
				}
			}
		}
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor)
	}

	protected def completeXMemberFeatureCall(EObject model, Assignment assignment,
			ContentAssistContext context, IWebContentProposaAcceptor acceptor) {
		if (model instanceof XMemberFeatureCall) {
			createReceiverProposals((model as XMemberFeatureCall).memberCallTarget,
				assignment.terminal as CrossReference, context, acceptor)
		} else if (model instanceof XAssignment) {
			createReceiverProposals((model as XAssignment).assignable,
				assignment.terminal as CrossReference, context, acceptor)
		}
	}

	protected def void createLocalVariableAndImplicitProposals(EObject model, IExpressionScope.Anchor anchor,
			ContentAssistContext context, IWebContentProposaAcceptor acceptor) {
		var String prefix = context.prefix
		if (prefix.length() > 0 && !Character.isJavaIdentifierStart(prefix.charAt(0))) {
			return
		}
		val resolvedTypes = if (model !== null)
				typeResolver.resolveTypes(model)
			else
				typeResolver.resolveTypes(context.resource)
		val expressionScope = resolvedTypes.getExpressionScope(model, anchor)
		val scope = expressionScope.featureScope
		crossrefProposalCreator.lookupCrossReference(scope, XFeatureCallAccess.featureJvmIdentifiableElementCrossReference_2_0,
			context, acceptor, featureDescriptionPredicate)
	}

	protected def void createReceiverProposals(XExpression receiver, CrossReference crossReference,
			ContentAssistContext context, IWebContentProposaAcceptor acceptor) {
		val resolvedTypes = typeResolver.resolveTypes(receiver)
		val receiverType = resolvedTypes.getActualType(receiver)
		if (receiverType === null || receiverType.isPrimitiveVoid) {
			return
		}
		val expressionScope = resolvedTypes.getExpressionScope(receiver, IExpressionScope.Anchor.RECEIVER)
		var IScope scope
		val currentModel = context.currentModel
		if (currentModel !== receiver) {
			if (currentModel instanceof XMemberFeatureCall &&
				(currentModel as XMemberFeatureCall).memberCallTarget === receiver) {
				scope = syntaxFilteredScopes.create(expressionScope.getFeatureScope(currentModel as XAbstractFeatureCall), crossReference)
			} else {
				scope = syntaxFilteredScopes.create(expressionScope.featureScope, crossReference)
			}
		} else {
			scope = syntaxFilteredScopes.create(expressionScope.featureScope, crossReference)
		}
		crossrefProposalCreator.lookupCrossReference(scope, crossReference, context, acceptor, featureDescriptionPredicate)
	}

	protected def dispatch String getConcreteSyntaxRuleName(Assignment assignment) {
		getConcreteSyntaxRuleName(assignment.terminal)
	}

	protected def dispatch String getConcreteSyntaxRuleName(CrossReference crossReference) {
		if (crossReference.terminal instanceof RuleCall) {
			getConcreteSyntaxRuleName(crossReference.terminal)
		}
	}

	protected def dispatch String getConcreteSyntaxRuleName(RuleCall ruleCall) {
		ruleCall.rule.name
	}

}