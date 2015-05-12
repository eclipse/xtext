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
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.web.server.contentassist.AbstractDeclarativeWebContentProposalProvider
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.eclipse.xtext.web.server.contentassist.CrossrefProposalCreator
import org.eclipse.xtext.web.server.contentassist.Proposals
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
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IExpressionScope
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xtype.XtypePackage

class XbaseWebContentProposalProvider extends AbstractDeclarativeWebContentProposalProvider {

	static class ValidFeatureDescription implements Predicate<IEObjectDescription> {
		@Inject OperatorMapping operatorMapping

		override boolean apply(IEObjectDescription input) {
			if (input instanceof IIdentifiableElementDescription) {
				val IIdentifiableElementDescription desc = input as IIdentifiableElementDescription
				if (!desc.isVisible || !desc.isValidStaticState)
					return false // filter operator method names from CA
				if (input.name.firstSegment.startsWith("operator_")) {
					return operatorMapping.getOperator(input.name) === null
				}
				return true
			}
			return true
		}
	}

	@Inject ITypesProposalProvider typeProposalProvider
	
	@Inject ValidFeatureDescription featureDescriptionPredicate
	
	@Inject XbaseQualifiedNameValueConverter qualifiedNameValueConverter
	
	@Inject IBatchTypeResolver typeResolver
	
	@Inject CommonTypeComputationServices typeComputationServices
	
	@Inject SyntaxFilteredScopes syntaxFilteredScopes
	
	override dispatch void createProposals(Keyword keyword, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		if (isKeywordWorthyToPropose(keyword, context)) {
			super._createProposals(keyword, context, acceptor)
		}
	}

	protected def boolean isKeywordWorthyToPropose(Keyword keyword, ContentAssistContext context) {
		if (keyword.value == 'as' || keyword.value == 'instanceof') {
			val previousModel = context.previousModel
			if (previousModel instanceof XExpression) {
				if (context.prefix.length === 0) {
					if (NodeModelUtils.getNode(previousModel).endOffset > context.offset) {
						return false
					}
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
	
	@Proposals(rule = 'XImportDeclaration', feature = 'importedType')
	def completeXImportDeclaration_ImportedType(ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		val ITypesProposalProvider.Filter filter = [ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
			!TypeMatchFilters.isInternalClass(simpleTypeName, enclosingTypeNames)
		]
		completeJavaTypes(context, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, true,
			qualifiedNameValueConverter, filter, acceptor)
	}

	@Proposals(rule = 'JvmParameterizedTypeReference', feature = 'type')
	def completeJvmParameterizedTypeReference_Type(ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor)
	}

	@Proposals(rule = 'XConstructorCall', feature = 'constructor')
	def completeXConstructorCall_Constructor(ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		val ITypesProposalProvider.Filter filter = [ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
			!TypeMatchFilters.isInternalClass(simpleTypeName, enclosingTypeNames)
				&& !TypeMatchFilters.isAbstract(modifiers) && !TypeMatchFilters.isInterface(modifiers)
		]
		completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true,
			qualifiedNameValueConverter, filter, acceptor)
	}

	@Proposals(rule = 'XRelationalExpression', feature = 'type')
	def completeXRelationalExpression_Type(ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor)
	}

	@Proposals(rule = 'XTypeLiteral', feature = 'type')
	def completeXTypeLiteral_Type(EObject model, Assignment assignment, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		val ITypesProposalProvider.Filter filter = [ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
			!TypeMatchFilters.isInternalClass(simpleTypeName, enclosingTypeNames)
		]
		completeJavaTypes(context, XbasePackage.Literals.XTYPE_LITERAL__TYPE, true,
			qualifiedNameValueConverter, filter, acceptor)
	}

	protected def void completeJavaTypes(ContentAssistContext context, EReference reference,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		val ITypesProposalProvider.Filter filter = [ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
			!TypeMatchFilters.isInternalClass(simpleTypeName, enclosingTypeNames)
		]
		completeJavaTypes(context, reference, qualifiedNameValueConverter, filter, acceptor)
	}

	protected def void completeJavaTypes(ContentAssistContext context, EReference reference,
			ITypesProposalProvider.Filter filter, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeJavaTypes(context, reference, qualifiedNameValueConverter, filter, acceptor)
	}

	protected def void completeJavaTypes(ContentAssistContext context, EReference reference,
			IValueConverter<String> valueConverter, ITypesProposalProvider.Filter filter,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeJavaTypes(context, reference, false, valueConverter, filter, acceptor)
	}

	protected def void completeJavaTypes(ContentAssistContext context, EReference reference, boolean forced,
			IValueConverter<String> valueConverter, ITypesProposalProvider.Filter filter,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		val prefix = context.prefix
		if (prefix.length() > 0) {
			if (Character.isJavaIdentifierStart(prefix.charAt(0))) {
				if (!forced) {
					if (!prefix.contains(".") && !prefix.contains(".") &&
						!Character.isUpperCase(prefix.charAt(0))) return
				}
				typeProposalProvider.createTypeProposals(context, reference, filter, valueConverter, acceptor)
			}
		} else {
			if (forced) {
				val INode lastCompleteNode = context.getLastCompleteNode()
				if (lastCompleteNode instanceof ILeafNode && !(lastCompleteNode as ILeafNode).isHidden()) {
					if (lastCompleteNode.getLength() > 0 &&
						lastCompleteNode.getTotalEndOffset() === context.getOffset()) {
						val text = lastCompleteNode.text
						val lastChar = text.charAt(text.length() - 1)
						if (Character.isJavaIdentifierPart(lastChar)) {
							return;
						}
					}
				}
				typeProposalProvider.createTypeProposals(context, reference, filter, valueConverter, acceptor)
			}
		}
	}

	@Proposals(rule = 'XFeatureCall', feature = 'feature')
	def completeXFeatureCall_Feature(EObject model, ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
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

	@Proposals(rule = 'XForLoopExpression', feature = 'eachExpression')
	def completeXForLoopExpression_EachExpression(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XForLoopExpression', feature = 'forExpression')
	def completeXForLoopExpression_ForExpression(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor)
	}

	@Proposals(rule = 'XSwitchExpression', feature = 'default')
	def completeXSwitchExpression_Default(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XCasePart', feature = 'then')
	def completeXCasePart_Then(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor)
	}

	@Proposals(rule = 'XCasePart', feature = 'case')
	def completeXCasePart_Case(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XBlockExpression', feature = 'expressions')
	def completeXBlockExpression_Expressions(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeWithinBlock(model, context, acceptor)
	}

	@Proposals(rule = 'XExpressionInClosure', feature = 'expressions')
	def completeXExpressionInClosure_Expressions(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeWithinBlock(model, context, acceptor)
	}

	protected def void completeWithinBlock(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
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
				val featureNode = featureNodes.get(0)
				if (featureNode.totalOffset < context.offset &&
					featureNode.totalEndOffset >= context.offset) {
					return true
				}
			}
		}
		return false
	}

	@Proposals(rule = 'XAssignment', feature = 'feature')
	def completeXAssignment_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		val ruleName = getConcreteSyntaxRuleName(assignment)
		if (isOperatorRule(ruleName)) {
			completeBinaryOperationFeature(model, assignment, context, acceptor)
		}
	}

	protected def boolean isOperatorRule(String ruleName) {
		return ruleName !== null && ruleName.startsWith('Op')
	}

	@Proposals(rule = 'XOrExpression', feature = 'feature')
	def completeXOrExpression_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeBinaryOperationFeature(model, assignment, context, acceptor)
	}

	@Proposals(rule = 'XAndExpression', feature = 'feature')
	def completeXAndExpression_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeBinaryOperationFeature(model, assignment, context, acceptor)
	}

	@Proposals(rule = 'XEqualityExpression', feature = 'feature')
	def completeXEqualityExpression_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeBinaryOperationFeature(model, assignment, context, acceptor)
	}

	@Proposals(rule = 'XRelationalExpression', feature = 'feature')
	def completeXRelationalExpression_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeBinaryOperationFeature(model, assignment, context, acceptor)
	}

	@Proposals(rule = 'XOtherOperatorExpression', feature = 'feature')
	def completeXOtherOperatorExpression_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeBinaryOperationFeature(model, assignment, context, acceptor)
	}

	@Proposals(rule = 'XAdditiveExpression', feature = 'feature')
	def completeXAdditiveExpression_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeBinaryOperationFeature(model, assignment, context, acceptor)
	}

	@Proposals(rule = 'XMultiplicativeExpression', feature = 'feature')
	def completeXMultiplicativeExpression_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeBinaryOperationFeature(model, assignment, context, acceptor)
	}

	@Proposals(rule = 'XUnaryOperation', feature = 'feature')
	def completeXUnaryOperation_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
	}

	@Proposals(rule = 'XPostfixOperation', feature = 'feature')
	def completeXPostfixOperation_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		completeBinaryOperationFeature(model, assignment, context, acceptor)
	}

	protected def void completeBinaryOperationFeature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
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

	@Proposals(rule = 'XCatchClause', feature = 'expression')
	def completeXCatchClause_Expression(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XExpression')
	def complete_XExpression(EObject model, RuleCall ruleCall, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		if (ruleCall.eContainer instanceof Group && GrammarUtil.containingRule(ruleCall).name == 'XParenthesizedExpression') {
			createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
		}
	}

	@Proposals(rule = 'XBasicForLoopExpression', feature = 'initExpressions')
	def completeXBasicForLoopExpression_InitExpressions(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
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

	@Proposals(rule = 'XBasicForLoopExpression', feature = 'updateExpressions')
	def completeXBasicForLoopExpression_UpdateExpressions(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XBasicForLoopExpression', feature = 'expression')
	def completeXBasicForLoopExpression_Expression(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XBasicForLoopExpression', feature = 'eachExpression')
	def completeXBasicForLoopExpression_EachExpression(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XClosure', feature = 'expression')
	def completeXClosure_Expression(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XShortClosure', feature = 'expression')
	def completeXShortClosure_Expression(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor)
	}

	@Proposals(rule = 'XMemberFeatureCall', feature = 'feature')
	def completeXMemberFeatureCall_Feature(EObject model, Assignment assignment,
			ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		if (model instanceof XMemberFeatureCall) {
			createReceiverProposals((model as XMemberFeatureCall).memberCallTarget,
				assignment.terminal as CrossReference, context, acceptor)
		} else if (model instanceof XAssignment) {
			createReceiverProposals((model as XAssignment).assignable,
				assignment.terminal as CrossReference, context, acceptor)
		}
	}

	@Proposals(rule = 'XVariableDeclaration', feature = 'right')
	def completeXVariableDeclaration_Right(EObject model, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor)
	}

	protected def void createLocalVariableAndImplicitProposals(EObject context, IExpressionScope.Anchor anchor,
			ContentAssistContext contentAssistContext, IAcceptor<ContentAssistResult.Entry> acceptor) {
		var String prefix = contentAssistContext.prefix
		if (prefix.length() > 0) {
			if (!Character.isJavaIdentifierStart(prefix.charAt(0))) {
				return
			}
		}
		val resolvedTypes = if (context !== null)
				typeResolver.resolveTypes(context)
			else
				typeResolver.resolveTypes(contentAssistContext.resource)
		val expressionScope = resolvedTypes.getExpressionScope(context, anchor)
		val scope = expressionScope.featureScope
		val proposalCreator = new XbaseCrossrefProposalCreator(contentAssistContext, qualifiedNameConverter,
			typeComputationServices, 'IdOrSuper')
		lookupCrossReference(scope, context, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE,
			acceptor, featureDescriptionPredicate, proposalCreator)
	}

	protected def void createReceiverProposals(XExpression receiver, CrossReference crossReference,
			ContentAssistContext contentAssistContext, IAcceptor<ContentAssistResult.Entry> acceptor) {
		val resolvedTypes = typeResolver.resolveTypes(receiver)
		val receiverType = resolvedTypes.getActualType(receiver)
		if (receiverType === null || receiverType.isPrimitiveVoid) {
			return
		}
		val expressionScope = resolvedTypes.getExpressionScope(receiver, IExpressionScope.Anchor.RECEIVER)
		var IScope scope
		val currentModel = contentAssistContext.currentModel
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
		val ruleName = getConcreteSyntaxRuleName(crossReference)
		val proposalCreator = new XbaseCrossrefProposalCreator(contentAssistContext, qualifiedNameConverter,
			typeComputationServices, ruleName)
		lookupCrossReference(scope, receiver, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE,
			acceptor, featureDescriptionPredicate, proposalCreator)
	}

	protected def dispatch String getConcreteSyntaxRuleName(Assignment assignment) {
		getConcreteSyntaxRuleName(assignment.terminal)
	}

	protected def dispatch String getConcreteSyntaxRuleName(RuleCall ruleCall) {
		ruleCall.rule.name
	}

	protected def dispatch String getConcreteSyntaxRuleName(CrossReference crossReference) {
		if (crossReference.terminal instanceof RuleCall) {
			getConcreteSyntaxRuleName(crossReference.terminal)
		}
	}
	
	protected def lookupCrossReference(IScope scope, EObject model, EReference reference,
			IAcceptor<ContentAssistResult.Entry> acceptor, Predicate<IEObjectDescription> filter,
			CrossrefProposalCreator proposalCreator) {
		for (IEObjectDescription candidate : scope.allElements) {
			if (filter.apply(candidate)) {
				acceptor.accept(proposalCreator.apply(candidate))
			}
		}
	}

}