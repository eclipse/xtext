/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.SyntaxFilteredScopes;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xtype.XtypePackage;
import static org.eclipse.xtext.xbase.typesystem.IExpressionScope.Anchor.*;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class XbaseIdeContentProposalProvider extends IdeContentProposalProvider {
	public static class ValidFeatureDescription implements Predicate<IEObjectDescription> {
		@Inject
		private OperatorMapping operatorMapping;

		@Override
		public boolean apply(IEObjectDescription input) {
			if (input instanceof IIdentifiableElementDescription) {
				IIdentifiableElementDescription identifiableElementDescription = (IIdentifiableElementDescription) input;
				if (!identifiableElementDescription.isVisible()
						|| !identifiableElementDescription.isValidStaticState()) {
					return false;
				}
				if (identifiableElementDescription.getName().getFirstSegment().startsWith("operator_")) {
					return operatorMapping.getOperator(identifiableElementDescription.getName()) == null;
				}
			}
			return true;
		}
	}

	@Inject
	private XbaseGrammarAccess xbaseGrammarAccess;

	@Inject
	private XbaseIdeContentProposalProvider.ValidFeatureDescription featureDescriptionPredicate;

	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private IIdeTypesProposalProvider typesProposalProvider;

	@Inject
	private SyntaxFilteredScopes syntaxFilteredScopes;

	@Override
	public boolean filterKeyword(Keyword keyword, ContentAssistContext context) {
		String value = keyword.getValue();
		if (value.length() > 1 && Character.isLetter(value.charAt(0))) {
			if ("as".equals(value) || "instanceof".equals(value)) {
				EObject previousModel = context.getPreviousModel();
				if (previousModel instanceof XExpression) {
					if (context.getPrefix().length() == 0
							&& NodeModelUtils.getNode(previousModel).getEndOffset() > context.getOffset()) {
						return false;
					}
					LightweightTypeReference type = typeResolver.resolveTypes(previousModel)
							.getActualType((XExpression) previousModel);
					if (type == null || type.isPrimitiveVoid()) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	protected void _createProposals(RuleCall ruleCall, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (xbaseGrammarAccess.getXExpressionRule().equals(ruleCall.getRule())) {
			if (ruleCall.eContainer() instanceof Group
					&& "XParenthesizedExpression".equals(GrammarUtil.containingRule(ruleCall).getName())) {
				createLocalVariableAndImplicitProposals(context.getCurrentModel(), WITHIN,
						context, acceptor);
			}
		} else {
			super._createProposals(ruleCall, context, acceptor);
		}
	}

	@Override
	protected void _createProposals(Assignment assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		EObject model = context.getCurrentModel();
		if (xbaseGrammarAccess.getXFeatureCallAccess().getFeatureAssignment_2().equals(assignment)) {
			completeXFeatureCall(model, context, acceptor);
		} else if (xbaseGrammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_0_0_0_2().equals(assignment)
				|| xbaseGrammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_1_2().equals(assignment)
		) {
			completeXMemberFeatureCall(model, assignment, context, acceptor);
		} else if (xbaseGrammarAccess.getXBlockExpressionAccess().getExpressionsAssignment_2_0().equals(assignment)
				|| xbaseGrammarAccess.getXExpressionInClosureAccess().getExpressionsAssignment_1_0()
						.equals(assignment)) {
			completeWithinBlock(model, context, acceptor);
		} else if (xbaseGrammarAccess.getXAssignmentAccess().getFeatureAssignment_0_1().equals(assignment)
				|| xbaseGrammarAccess.getXAssignmentAccess().getFeatureAssignment_1_1_0_0_1().equals(assignment)) {
			completeXAssignment(model, assignment, context, acceptor);
		} else if (xbaseGrammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0().equals(assignment)
				|| xbaseGrammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1()
						.equals(assignment)) {
			completeJavaTypes(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, context, acceptor);
		} else if (xbaseGrammarAccess.getXRelationalExpressionAccess().getTypeAssignment_1_0_1().equals(assignment)) {
			completeJavaTypes(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, context, acceptor);
		} else if ((xbaseGrammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2()
				.equals(assignment)
				|| xbaseGrammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1()
						.equals(assignment))) {
			completeJavaTypes(XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, context, acceptor);
		} else if (xbaseGrammarAccess.getXTypeLiteralAccess().getTypeAssignment_3().equals(assignment)) {
			completeJavaTypes(XbasePackage.Literals.XTYPE_LITERAL__TYPE, context, acceptor);
		} else if (xbaseGrammarAccess.getXConstructorCallAccess().getConstructorAssignment_2().equals(assignment)) {
			completeJavaTypes(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, context,
					TypeFilters.NON_ABSTRACT, acceptor);
		} else if (xbaseGrammarAccess.getXForLoopExpressionAccess().getEachExpressionAssignment_3().equals(assignment)
				|| xbaseGrammarAccess.getXSwitchExpressionAccess().getDefaultAssignment_5_2().equals(assignment)
				|| xbaseGrammarAccess.getXCasePartAccess().getCaseAssignment_2_1().equals(assignment)
				|| xbaseGrammarAccess.getXCatchClauseAccess().getExpressionAssignment_4().equals(assignment)
				|| xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_0()
						.equals(assignment)
				|| xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_1_1()
						.equals(assignment)
				|| xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getExpressionAssignment_5().equals(assignment)
				|| xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionAssignment_9()
						.equals(assignment)
				|| xbaseGrammarAccess.getXClosureAccess().getExpressionAssignment_2().equals(assignment)
				|| xbaseGrammarAccess.getXShortClosureAccess().getExpressionAssignment_1().equals(assignment)) {
			createLocalVariableAndImplicitProposals(model, WITHIN, context, acceptor);
		} else if (xbaseGrammarAccess.getXForLoopExpressionAccess().getForExpressionAssignment_1().equals(assignment)
				|| xbaseGrammarAccess.getXVariableDeclarationAccess().getRightAssignment_3_1().equals(assignment)) {
			createLocalVariableAndImplicitProposals(model, BEFORE, context, acceptor);
		} else if (xbaseGrammarAccess.getXCasePartAccess().getThenAssignment_3_0_1().equals(assignment)) {
			createLocalVariableAndImplicitProposals(model, AFTER, context, acceptor);
		} else if (xbaseGrammarAccess.getXOrExpressionAccess().getFeatureAssignment_1_0_0_1().equals(assignment)
				|| xbaseGrammarAccess.getXAndExpressionAccess().getFeatureAssignment_1_0_0_1().equals(assignment)
				|| xbaseGrammarAccess.getXEqualityExpressionAccess().getFeatureAssignment_1_0_0_1().equals(assignment)
				|| xbaseGrammarAccess.getXRelationalExpressionAccess().getFeatureAssignment_1_1_0_0_1()
						.equals(assignment)
				|| xbaseGrammarAccess.getXOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1()
						.equals(assignment)
				|| xbaseGrammarAccess.getXAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1().equals(assignment)
				|| xbaseGrammarAccess.getXMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1()
						.equals(assignment)
				|| xbaseGrammarAccess.getXPostfixOperationAccess().getFeatureAssignment_1_0_1().equals(assignment)
		) {
			completeBinaryOperation(model, assignment, context, acceptor);
		} else if (xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_0()
				.equals(assignment)
				|| xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_1_1()
						.equals(assignment)) {

			completeXBasicForLoopInit(model, context, acceptor);
		} else if (xbaseGrammarAccess.getXUnaryOperationAccess().getFeatureAssignment_0_1().equals(assignment)) {
			// Don't propose unary operations
		} else {
			super._createProposals(assignment, context, acceptor);
		}
	}

	protected void completeJavaTypes(EReference reference, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		completeJavaTypes(reference, context, Predicates.alwaysTrue(), acceptor);
	}

	protected void completeJavaTypes(EReference reference, ContentAssistContext context,
			Predicate<? super ITypeDescriptor> filter, IIdeContentProposalAcceptor acceptor) {
		typesProposalProvider.createTypeProposals(reference, context, filter, acceptor);
	}

	protected void completeXFeatureCall(EObject model, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (model != null) {
			if (typeResolver.resolveTypes(model).hasExpressionScope(model,
					WITHIN)) {
				return;
			}
		}
		if (model instanceof XMemberFeatureCall) {
			ICompositeNode node = NodeModelUtils.getNode(model);
			if (isInMemberFeatureCall(model, node.getEndOffset(), context)) {
				return;
			}
		}
		createLocalVariableAndImplicitProposals(model, AFTER, context, acceptor);
	}

	protected void completeWithinBlock(EObject model, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		ICompositeNode node = NodeModelUtils.getNode(model);
		if (node.getOffset() >= context.getOffset()) {
			createLocalVariableAndImplicitProposals(model, BEFORE, context, acceptor);
			return;
		}
		if (model instanceof XBlockExpression) {
			EList<XExpression> children = ((XBlockExpression) model).getExpressions();
			for (int i = children.size() - 1; i >= 0; i--) {
				XExpression child = children.get(i);
				ICompositeNode childNode = NodeModelUtils.getNode(child);
				if (childNode.getEndOffset() <= context.getOffset()) {
					createLocalVariableAndImplicitProposals(child, AFTER, context,
							acceptor);
					return;
				}
			}
		}
		if (node.getEndOffset() <= context.getOffset()) {
			if (model instanceof XFeatureCall && model.eContainer() instanceof XClosure
					|| node.getEndOffset() == context.getOffset() && context.getPrefix().length() == 0) {
				return;
			}
			if (isInMemberFeatureCall(model, node.getEndOffset(), context)) {
				return;
			}
			createLocalVariableAndImplicitProposals(model, AFTER, context, acceptor);
			return;
		}
		if (isInMemberFeatureCall(model, node.getEndOffset(), context) || model instanceof XClosure) {
			return;
		}
		createLocalVariableAndImplicitProposals(model, BEFORE, context, acceptor);
	}

	protected boolean isInMemberFeatureCall(EObject model, int endOffset, ContentAssistContext context) {
		if (model instanceof XMemberFeatureCall && endOffset >= context.getOffset()) {
			List<INode> featureNodes = NodeModelUtils.findNodesForFeature(model,
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
			if (!featureNodes.isEmpty()) {
				INode featureNode = Iterables.getFirst(featureNodes, null);
				if (featureNode != null && featureNode.getTotalOffset() < context.getOffset()
						&& featureNode.getTotalEndOffset() >= context.getOffset()) {
					return true;
				}
			}
		}
		return false;
	}

	protected void completeXAssignment(EObject model, Assignment assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		String ruleName = getConcreteSyntaxRuleName(assignment);
		if (isOperatorRule(ruleName)) {
			completeBinaryOperation(model, assignment, context, acceptor);
		}
	}

	protected boolean isOperatorRule(String ruleName) {
		return ruleName != null && ruleName.startsWith("Op");
	}

	protected void completeBinaryOperation(EObject model, Assignment assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (model instanceof XBinaryOperation) {
			if (context.getPrefix().length() == 0) {
				INode currentNode = context.getCurrentNode();
				int offset = currentNode.getOffset();
				int endOffset = currentNode.getEndOffset();
				if (offset < context.getOffset() && endOffset >= context.getOffset()
						&& currentNode.getGrammarElement() instanceof CrossReference) {
					// Don't propose another binary operator
					return;
				}
			}
			if (NodeModelUtils.findActualNodeFor(model).getEndOffset() <= context.getOffset()) {
				createReceiverProposals((XExpression) model, (CrossReference) assignment.getTerminal(), context, acceptor);
			} else {
				createReceiverProposals(((XBinaryOperation) model).getLeftOperand(), (CrossReference) assignment.getTerminal(),
						context, acceptor);
			}
		} else {
			EObject previousModel = context.getPreviousModel();
			if (previousModel instanceof XExpression) {
				if (context.getPrefix().length() == 0
						&& NodeModelUtils.getNode(previousModel).getEndOffset() > context.getOffset()) {
					return;
				}
				createReceiverProposals((XExpression) previousModel, (CrossReference) assignment.getTerminal(), context, acceptor);
			}
		}
	}

	protected void completeXBasicForLoopInit(EObject model, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		ICompositeNode node = NodeModelUtils.getNode(model);
		if (node.getOffset() >= context.getOffset()) {
			createLocalVariableAndImplicitProposals(model, BEFORE, context, acceptor);
			return;
		}
		if (model instanceof XBasicForLoopExpression) {
			EList<XExpression> children = ((XBasicForLoopExpression) model).getInitExpressions();
			for (int i = children.size() - 1; i >= 0; i--) {
				XExpression child = children.get(i);
				ICompositeNode childNode = NodeModelUtils.getNode(child);
				if (childNode.getEndOffset() <= context.getOffset()) {
					createLocalVariableAndImplicitProposals(child, AFTER, context, acceptor);
					return;
				}
			}
		}
		createLocalVariableAndImplicitProposals(model, BEFORE, context, acceptor);
	}

	protected void completeXMemberFeatureCall(EObject model, Assignment assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (model instanceof XMemberFeatureCall) {
			createReceiverProposals(((XMemberFeatureCall) model).getMemberCallTarget(),
					(CrossReference) assignment.getTerminal(), context, acceptor);
		} else {
			if (model instanceof XAssignment) {
				createReceiverProposals(((XAssignment) model).getAssignable(),
						(CrossReference) assignment.getTerminal(), context, acceptor);
			}
		}
	}

	protected void createLocalVariableAndImplicitProposals(EObject model, IExpressionScope.Anchor anchor,
			ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		String prefix = context.getPrefix();
		if (prefix.length() > 0 && !Character.isJavaIdentifierStart(prefix.charAt(0))) {
			return;
		}
		IResolvedTypes resolvedTypes = null;
		if (model != null) {
			resolvedTypes = typeResolver.resolveTypes(model);
		} else {
			resolvedTypes = typeResolver.resolveTypes(context.getResource());
		}
		IExpressionScope expressionScope = resolvedTypes.getExpressionScope(model, anchor);
		IScope scope = expressionScope.getFeatureScope();
		getCrossrefProposalProvider().lookupCrossReference(scope,
				xbaseGrammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0(),
				context, acceptor, featureDescriptionPredicate);
	}

	protected void createReceiverProposals(XExpression receiver, CrossReference crossReference,
			ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(receiver);
		LightweightTypeReference receiverType = resolvedTypes.getActualType(receiver);
		if (receiverType == null || receiverType.isPrimitiveVoid()) {
			return;
		}
		IExpressionScope expressionScope = resolvedTypes.getExpressionScope(receiver, RECEIVER);
		IScope scope = null;
		EObject currentModel = context.getCurrentModel();
		if (currentModel != receiver) {
			if (currentModel instanceof XMemberFeatureCall
					&& ((XMemberFeatureCall) currentModel).getMemberCallTarget() == receiver) {
				scope = syntaxFilteredScopes
						.create(expressionScope.getFeatureScope((XAbstractFeatureCall) currentModel), crossReference);
			} else {
				scope = syntaxFilteredScopes.create(expressionScope.getFeatureScope(), crossReference);
			}
		} else {
			scope = syntaxFilteredScopes.create(expressionScope.getFeatureScope(), crossReference);
		}
		getCrossrefProposalProvider().lookupCrossReference(scope, crossReference, context, acceptor,
				featureDescriptionPredicate);
	}

	protected String _getConcreteSyntaxRuleName(Assignment assignment) {
		return getConcreteSyntaxRuleName(assignment.getTerminal());
	}

	protected String _getConcreteSyntaxRuleName(CrossReference crossReference) {
		if (crossReference.getTerminal() instanceof RuleCall) {
			return getConcreteSyntaxRuleName(crossReference.getTerminal());
		}
		return null;
	}

	protected String _getConcreteSyntaxRuleName(RuleCall ruleCall) {
		return ruleCall.getRule().getName();
	}

	@Override
	public void createProposals(AbstractElement element, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (element instanceof Assignment) {
			_createProposals((Assignment) element, context, acceptor);
			return;
		} else if (element instanceof CrossReference) {
			_createProposals((CrossReference) element, context, acceptor);
			return;
		} else if (element instanceof Keyword) {
			_createProposals((Keyword) element, context, acceptor);
			return;
		} else if (element instanceof RuleCall) {
			_createProposals((RuleCall) element, context, acceptor);
			return;
		} else if (element != null) {
			_createProposals(element, context, acceptor);
			return;
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.asList(element, context, acceptor).toString());
		}
	}

	protected String getConcreteSyntaxRuleName(AbstractElement element) {
		if (element instanceof Assignment) {
			return _getConcreteSyntaxRuleName((Assignment) element);
		} else if (element instanceof CrossReference) {
			return _getConcreteSyntaxRuleName((CrossReference) element);
		} else if (element instanceof RuleCall) {
			return _getConcreteSyntaxRuleName((RuleCall) element);
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.asList(element).toString());
		}
	}
}
