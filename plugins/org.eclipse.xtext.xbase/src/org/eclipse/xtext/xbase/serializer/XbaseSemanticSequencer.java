package org.eclipse.xtext.xbase.serializer;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.SerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.tokens.IValueSerializer;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAdditiveExpressionElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAndExpressionElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAssignmentElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XEqualityExpressionElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XFeatureCallElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XMemberFeatureCallElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XMultiplicativeExpressionElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XOrExpressionElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XOtherOperatorExpressionElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XRelationalExpressionElements;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class XbaseSemanticSequencer extends AbstractXbaseSemanticSequencer {
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private IScopeProvider scopeProvider;
	
	@Inject
	private IValueSerializer valueSerializer;
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XUnaryOperation) | 
	 *         (leftOperand=XOtherOperatorExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOther] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XRelationalExpression_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpCompare] rightOperand=XOtherOperatorExpression) | 
	 *         (leftOperand=XEqualityExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpEquality] rightOperand=XRelationalExpression) | 
	 *         (leftOperand=XAndExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAnd] rightOperand=XEqualityExpression) | 
	 *         (leftOperand=XOrExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOr] rightOperand=XAndExpression) | 
	 *         (leftOperand=XAssignment_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpMultiAssign] rightOperand=XAssignment)
	 *     )
	 */
	@Override
	protected void sequence_XAdditiveExpression(EObject context, XBinaryOperation operation) {
		INodesForEObjectProvider nodes = createNodeProvider(operation);
		SequenceFeeder acceptor = createSequencerFeeder(operation, nodes);
		XAdditiveExpressionElements opAdd = grammarAccess.getXAdditiveExpressionAccess();
		XMultiplicativeExpressionElements opMulti = grammarAccess.getXMultiplicativeExpressionAccess();
		XOtherOperatorExpressionElements opOther = grammarAccess.getXOtherOperatorExpressionAccess();
		XRelationalExpressionElements opCompare = grammarAccess.getXRelationalExpressionAccess();
		XEqualityExpressionElements opEquality = grammarAccess.getXEqualityExpressionAccess();
		XAndExpressionElements opAnd = grammarAccess.getXAndExpressionAccess();
		XOrExpressionElements opOr = grammarAccess.getXOrExpressionAccess();
		XAssignmentElements opMultiAssign = grammarAccess.getXAssignmentAccess();
		
		IScope scope = scopeProvider.getScope(operation, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		Set<String> operatorNames = Sets.newHashSet();
		for (IEObjectDescription desc : scope.getElements(operation.getFeature()))
			operatorNames.add(qualifiedNameConverter.toString(desc.getName()));
				
		ICompositeNode featureNode = (ICompositeNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, operation.getFeature());
		String featureToken;
		
		if((featureToken = getValidOperator(operation, opAdd.getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
			acceptor.accept(opAdd.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
			acceptor.accept(opAdd.getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
			acceptor.accept(opAdd.getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
		} else if((featureToken = getValidOperator(operation, opMulti.getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
			acceptor.accept(opMulti.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
			acceptor.accept(opMulti.getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
			acceptor.accept(opMulti.getRightOperandXUnaryOperationParserRuleCall_1_1_0(), operation.getRightOperand());
		} else if((featureToken = getValidOperator(operation, opOther.getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
			acceptor.accept(opOther.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
			acceptor.accept(opOther.getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
			acceptor.accept(opOther.getRightOperandXAdditiveExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
		} else if((featureToken = getValidOperator(operation, opCompare.getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
			acceptor.accept(opCompare.getXBinaryOperationLeftOperandAction_1_1_0_0_0(), operation.getLeftOperand());
			acceptor.accept(opCompare.getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
			acceptor.accept(opCompare.getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0(), operation.getRightOperand());
		} else if((featureToken = getValidOperator(operation, opEquality.getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
			acceptor.accept(opEquality.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
			acceptor.accept(opEquality.getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
			acceptor.accept(opEquality.getRightOperandXRelationalExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
		} else if((featureToken = getValidOperator(operation, opAnd.getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
			acceptor.accept(opAnd.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
			acceptor.accept(opAnd.getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
			acceptor.accept(opAnd.getRightOperandXEqualityExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
		} else if((featureToken = getValidOperator(operation, opOr.getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
			acceptor.accept(opOr.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
			acceptor.accept(opOr.getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
			acceptor.accept(opOr.getRightOperandXAndExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
		} else if((featureToken = getValidOperator(operation, opMultiAssign.getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
			acceptor.accept(opMultiAssign.getXBinaryOperationLeftOperandAction_1_1_0_0_0(), operation.getLeftOperand());
			acceptor.accept(opMultiAssign.getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
			acceptor.accept(opMultiAssign.getRightOperandXAssignmentParserRuleCall_1_1_1_0(), operation.getRightOperand());
		} else if (errorAcceptor != null) {
			errorAcceptor.accept(new SerializationDiagnostic(operation, context, "Operator "+operatorNames+" is not supported."));
		} 
		acceptor.finish();
	}
	
	protected String getValidOperator(EObject semanticObject, RuleCall ruleCall, Iterable<String> names, ICompositeNode node) {
		for (String name : names)
			if (valueSerializer.isValid(semanticObject, ruleCall, name, null))
				return valueSerializer.serializeAssignedValue(semanticObject, ruleCall, name, node, errorAcceptor);
		return null;
	}
	
	
	
	/**
	 * Constraint:
	 *     (
	 *         declaringType=[JvmDeclaredType|StaticQualifier]?
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
	 *         feature=[JvmIdentifiableElement|IdOrSuper]
	 *         (explicitOperationCall?='(' (featureCallArguments+=XShortClosure | (featureCallArguments+=XExpression featureCallArguments+=XExpression*))?)?
	 *     )
	 *     
	 *
	 * Features:
	 *    feature[1, 1]
	 *    typeArguments[0, *]
	 *    featureCallArguments[1, *]
	 *         EXCLUDE_IF_UNSET explicitOperationCall
	 *    explicitOperationCall[0, 1]
	 *         MANDATORY_IF_SET featureCallArguments
	 *         EXCLUDE_IF_UNSET featureCallArguments
	 *         MANDATORY_IF_SET featureCallArguments
	 *         MANDATORY_IF_SET featureCallArguments
	 *    declaringType[0, 1]
	 */
	@Override
	protected void sequence_XFeatureCall(EObject context, XFeatureCall call) {
		INodesForEObjectProvider nodes = createNodeProvider(call);
		SequenceFeeder acceptor = createSequencerFeeder(call, nodes);
		XFeatureCallElements xfce = grammarAccess.getXFeatureCallAccess();

		// declaringType=[JvmDeclaredType|StaticQualifier]?
		if (call.getDeclaringType() != null)
			acceptor.accept(xfce.getDeclaringTypeJvmDeclaredTypeStaticQualifierParserRuleCall_1_0_1(), call.getDeclaringType());

		// (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
		List<JvmTypeReference> typeArguments = call.getTypeArguments();
		if (!typeArguments.isEmpty()) {
			acceptor.accept(xfce.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0(), typeArguments.get(0), 0);
			for (int i = 1; i < typeArguments.size(); i++)
				acceptor.accept(xfce.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0(), typeArguments.get(i), i);
		}

		// feature=[JvmIdentifiableElement|IdOrSuper]
		acceptor.accept(xfce.getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_3_0_1(), call.getFeature());

		// (explicitOperationCall?='(' (featureCallArguments+=XShortClosure | (featureCallArguments+=XExpression featureCallArguments+=XExpression*))?)?
		if (call.isExplicitOperationCall()) {
			acceptor.accept(xfce.getExplicitOperationCallLeftParenthesisKeyword_4_0_0());
			if (!call.getFeatureCallArguments().isEmpty()) {
				if (isXShortClosure(call, XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, nodes)) {
					acceptor.accept(xfce.getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0(), call.getFeatureCallArguments().get(0), 0);
				} else {
					acceptor.accept(xfce.getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0(), call.getFeatureCallArguments().get(0), 0);
					for (int i = 1; i < call.getFeatureCallArguments().size(); i++)
						acceptor.accept(xfce.getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0(), call.getFeatureCallArguments().get(i), i);
				}
			}
		}
		acceptor.finish();
	}
	
	
	protected boolean isXShortClosure(EObject semanticObject, EReference reference, INodesForEObjectProvider nodes) {
		List<?> values = (List<?>) semanticObject.eGet(reference);
		if (values.size() != 1 || !(values.get(0) instanceof XClosure))
			return false;
		INode node = nodes.getNodeForMultiValue(reference, 0, 0, values.get(0));
		if (node != null && node.getGrammarElement() instanceof RuleCall)
			return ((RuleCall) node.getGrammarElement()).getRule() == grammarAccess.getXShortClosureRule();
		return true;
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         memberCallTarget=XMemberFeatureCall_XMemberFeatureCall_1_1_0_0_0
	 *         (nullSafe?='?.' | spreading?='*.')?
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
	 *         feature=[JvmIdentifiableElement|ID]
	 *         (explicitOperationCall?='(' (memberCallArguments+=XShortClosure | (memberCallArguments+=XExpression memberCallArguments+=XExpression*))?)?
	 *     )
	 *     
	 *
	 * Features:
	 *    feature[1, 1]
	 *    typeArguments[0, *]
	 *    memberCallTarget[1, 1]
	 *    memberCallArguments[1, *]
	 *         EXCLUDE_IF_UNSET explicitOperationCall
	 *    explicitOperationCall[0, 1]
	 *         MANDATORY_IF_SET memberCallArguments
	 *         EXCLUDE_IF_UNSET memberCallArguments
	 *         MANDATORY_IF_SET memberCallArguments
	 *         MANDATORY_IF_SET memberCallArguments
	 *    spreading[0, 1]
	 *         EXCLUDE_IF_SET nullSafe
	 *    nullSafe[0, 1]
	 *         EXCLUDE_IF_SET spreading
	 */
	@Override
	protected void sequence_XMemberFeatureCall(EObject context, XMemberFeatureCall semanticObject) {
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder acceptor = createSequencerFeeder(semanticObject, nodes);
		XMemberFeatureCallElements xmfce = grammarAccess.getXMemberFeatureCallAccess();

		// memberCallTarget=XMemberFeatureCall_XMemberFeatureCall_1_1_0_0_0
		acceptor.accept(xmfce.getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(), semanticObject.getMemberCallTarget());

		// (nullSafe?='?.' | spreading?='*.')?
		if (semanticObject.isNullSafe())
			acceptor.accept(xmfce.getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
		else if (semanticObject.isSpreading())
			acceptor.accept(xmfce.getSpreadingAsteriskFullStopKeyword_1_1_0_0_1_2_0());

		// (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
		List<JvmTypeReference> typeArguments = semanticObject.getTypeArguments();
		if (!typeArguments.isEmpty()) {
			acceptor.accept(xmfce.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0(), typeArguments.get(0), 0);
			for (int i = 1; i < typeArguments.size(); i++)
				acceptor.accept(xmfce.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0(), typeArguments.get(i), i);
		}

		// feature=[JvmIdentifiableElement|ID]
		acceptor.accept(xmfce.getFeatureJvmIdentifiableElementValidIDParserRuleCall_1_1_2_0_1(), semanticObject.getFeature());

		// (explicitOperationCall?='(' (memberCallArguments+=XShortClosure | (memberCallArguments+=XExpression memberCallArguments+=XExpression*))?)?
		if (semanticObject.isExplicitOperationCall()) {
			acceptor.accept(xmfce.getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
			if (!semanticObject.getMemberCallArguments().isEmpty()) {
				if (isXShortClosure(semanticObject, XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, nodes)) {
					acceptor.accept(xmfce.getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0(), semanticObject.getMemberCallArguments().get(0), 0);
				} else {
					acceptor.accept(xmfce.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0(), semanticObject.getMemberCallArguments().get(0), 0);
					for (int i = 1; i < semanticObject.getMemberCallArguments().size(); i++)
						acceptor.accept(xmfce.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0(), semanticObject.getMemberCallArguments().get(i), i);
				}
			}
		}
		acceptor.finish();
	}
	
	/**
	 * Constraint:
	 *     (
	 *         constructor=[JvmConstructor|QualifiedName]
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
	 *         (arguments+=XShortClosure | (arguments+=XExpression arguments+=XExpression*))?
	 *     )
	 *     
	 *
	 * Features:
	 *    constructor[1, 1]
	 *    arguments[1, *]
	 *    typeArguments[0, *]
	 */
	@Override
	protected void sequence_XConstructorCall(EObject context, XConstructorCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
