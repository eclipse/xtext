package org.eclipse.xtext.xbase.serializer;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.diagnostic.SerializationDiagnostic;
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
	protected void sequence_XAdditiveExpression_XBinaryOperation(EObject context, XBinaryOperation semanticObject) {
		IScope scope = scopeProvider.getScope(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		Set<String> operatorNames = Sets.newHashSet();
		for (IEObjectDescription desc : scope.getElements(semanticObject.getFeature()))
			operatorNames.add(qualifiedNameConverter.toString(desc.getName()));

		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		ICompositeNode leftNode = (ICompositeNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XBINARY_OPERATION__LEFT_OPERAND, semanticObject.getLeftOperand());
		ICompositeNode featureNode = (ICompositeNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, semanticObject.getFeature());
		ICompositeNode rightNode = (ICompositeNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND, semanticObject.getRightOperand());
		
		XAdditiveExpressionElements opAdd = grammarAccess.getXAdditiveExpressionAccess();
		XMultiplicativeExpressionElements opMulti = grammarAccess.getXMultiplicativeExpressionAccess();
		XOtherOperatorExpressionElements opOther = grammarAccess.getXOtherOperatorExpressionAccess();
		XRelationalExpressionElements opCompare = grammarAccess.getXRelationalExpressionAccess();
		XEqualityExpressionElements opEquality = grammarAccess.getXEqualityExpressionAccess();
		XAndExpressionElements opAnd = grammarAccess.getXAndExpressionAccess();
		XOrExpressionElements opOr = grammarAccess.getXOrExpressionAccess();
		XAssignmentElements opMultiAssign = grammarAccess.getXAssignmentAccess();
		
		if(isValidOperator(semanticObject, opAdd.getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1(), operatorNames)) {
			acceptAssignedAction(semanticObject, opAdd.getXBinaryOperationLeftOperandAction_1_0_0_0(), semanticObject.getLeftOperand(), -1, leftNode);
			acceptAssignedCrossRefDatatype(semanticObject, opAdd.getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1(), semanticObject.getFeature(), -1, featureNode);
			acceptAssignedParserRuleCall(semanticObject, opAdd.getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0(), semanticObject.getRightOperand(), -1, rightNode);
		} else if(isValidOperator(semanticObject, opMulti.getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1(), operatorNames)) {
			acceptAssignedAction(semanticObject, opMulti.getXBinaryOperationLeftOperandAction_1_0_0_0(), semanticObject.getLeftOperand(), -1, leftNode);
			acceptAssignedCrossRefDatatype(semanticObject, opMulti.getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1(), semanticObject.getFeature(), -1, featureNode);
			acceptAssignedParserRuleCall(semanticObject, opMulti.getRightOperandXUnaryOperationParserRuleCall_1_1_0(), semanticObject.getRightOperand(), -1, rightNode);
		} else if(isValidOperator(semanticObject, opOther.getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1(), operatorNames)) {
			acceptAssignedAction(semanticObject, opOther.getXBinaryOperationLeftOperandAction_1_0_0_0(), semanticObject.getLeftOperand(), -1, leftNode);
			acceptAssignedCrossRefDatatype(semanticObject, opOther.getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1(), semanticObject.getFeature(), -1, featureNode);
			acceptAssignedParserRuleCall(semanticObject, opOther.getRightOperandXAdditiveExpressionParserRuleCall_1_1_0(), semanticObject.getRightOperand(), -1, rightNode);
		} else if(isValidOperator(semanticObject, opCompare.getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1(), operatorNames)) {
			acceptAssignedAction(semanticObject, opCompare.getXBinaryOperationLeftOperandAction_1_1_0_0_0(), semanticObject.getLeftOperand(), -1, leftNode);
			acceptAssignedCrossRefDatatype(semanticObject, opCompare.getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1(), semanticObject.getFeature(), -1, featureNode);
			acceptAssignedParserRuleCall(semanticObject, opCompare.getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0(), semanticObject.getRightOperand(), -1, rightNode);
		} else if(isValidOperator(semanticObject, opEquality.getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1(), operatorNames)) {
			acceptAssignedAction(semanticObject, opEquality.getXBinaryOperationLeftOperandAction_1_0_0_0(), semanticObject.getLeftOperand(), -1, leftNode);
			acceptAssignedCrossRefDatatype(semanticObject, opEquality.getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1(), semanticObject.getFeature(), -1, featureNode);
			acceptAssignedParserRuleCall(semanticObject, opEquality.getRightOperandXRelationalExpressionParserRuleCall_1_1_0(), semanticObject.getRightOperand(), -1, rightNode);
		} else if(isValidOperator(semanticObject, opAnd.getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1(), operatorNames)) {
			acceptAssignedAction(semanticObject, opAnd.getXBinaryOperationLeftOperandAction_1_0_0_0(), semanticObject.getLeftOperand(), -1, leftNode);
			acceptAssignedCrossRefDatatype(semanticObject, opAnd.getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1(), semanticObject.getFeature(), -1, featureNode);
			acceptAssignedParserRuleCall(semanticObject, opAnd.getRightOperandXEqualityExpressionParserRuleCall_1_1_0(), semanticObject.getRightOperand(), -1, rightNode);
		} else if(isValidOperator(semanticObject, opOr.getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1(), operatorNames)) {
			acceptAssignedAction(semanticObject, opOr.getXBinaryOperationLeftOperandAction_1_0_0_0(), semanticObject.getLeftOperand(), -1, leftNode);
			acceptAssignedCrossRefDatatype(semanticObject, opOr.getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1(), semanticObject.getFeature(), -1, featureNode);
			acceptAssignedParserRuleCall(semanticObject, opOr.getRightOperandXAndExpressionParserRuleCall_1_1_0(), semanticObject.getRightOperand(), -1, rightNode);
		} else if(isValidOperator(semanticObject, opMultiAssign.getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1(), operatorNames)) {
			acceptAssignedAction(semanticObject, opMultiAssign.getXBinaryOperationLeftOperandAction_1_1_0_0_0(), semanticObject.getLeftOperand(), -1, leftNode);
			acceptAssignedCrossRefDatatype(semanticObject, opMultiAssign.getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1(), semanticObject.getFeature(), -1, featureNode);
			acceptAssignedParserRuleCall(semanticObject, opMultiAssign.getRightOperandXAssignmentParserRuleCall_1_1_1_0(), semanticObject.getRightOperand(), -1, rightNode);
		} else if (errorAcceptor != null) {
			errorAcceptor.accept(new SerializationDiagnostic(semanticObject, context, "Operator "+operatorNames+" is not supported."));
		} 
		acceptFinish();
	}
	
	protected boolean isValidOperator(EObject semanticObject, RuleCall ruleCall, Iterable<String> names) {
		for (String name : names)
			if (valueSerializer.isValid(semanticObject, ruleCall, name, null))
				return true;
		return false;
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
	protected void sequence_XFeatureCall_XFeatureCall(EObject context, XFeatureCall semanticObject) {
		XFeatureCallElements xfce = grammarAccess.getXFeatureCallAccess();
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		
		// declaringType=[JvmDeclaredType|StaticQualifier]?
		if(semanticObject.getDeclaringType() != null) {
			ICompositeNode declaringTypeNode = (ICompositeNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE, semanticObject.getDeclaringType());
			acceptAssignedCrossRefDatatype(semanticObject, xfce.getDeclaringTypeJvmDeclaredTypeStaticQualifierParserRuleCall_1_0_1(), semanticObject.getDeclaringType(), -1, declaringTypeNode);
		}
		
		// (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
		List<JvmTypeReference> typeArguments = semanticObject.getTypeArguments();
		if(!typeArguments.isEmpty()) {
			ICompositeNode typeArgumentNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS, 0, 0, typeArguments.get(0));
			acceptAssignedParserRuleCall(semanticObject, xfce.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0(), typeArguments.get(0), -1, typeArgumentNode);
			for(int i = 1; i<typeArguments.size(); i++) {
				typeArgumentNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS, i, i, typeArguments.get(i));
				acceptAssignedParserRuleCall(semanticObject, xfce.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0(), typeArguments.get(i), i, typeArgumentNode);
			}
		}
		
		// feature=[JvmIdentifiableElement|IdOrSuper]
		ICompositeNode featureNode = (ICompositeNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, semanticObject.getFeature());
		acceptAssignedCrossRefDatatype(semanticObject, xfce.getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_3_0_1(), semanticObject.getFeature(), -1, featureNode);
		
		// (explicitOperationCall?='(' (featureCallArguments+=XShortClosure | (featureCallArguments+=XExpression featureCallArguments+=XExpression*))?)?
		if(semanticObject.isExplicitOperationCall()) {
			ILeafNode explicitOperationCallNode = (ILeafNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XFEATURE_CALL__EXPLICIT_OPERATION_CALL, semanticObject.isExplicitOperationCall());
			acceptAssignedKeyword(semanticObject, xfce.getExplicitOperationCallLeftParenthesisKeyword_4_0_0(), semanticObject.isExplicitOperationCall(), -1, explicitOperationCallNode);
			if(!semanticObject.getFeatureCallArguments().isEmpty()) {
				if(isXShortClosure(semanticObject, XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, nodes)) {
					ICompositeNode shortClosureNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, 0, 0, semanticObject.getFeatureCallArguments().get(0));
					acceptAssignedParserRuleCall(semanticObject, xfce.getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0(), semanticObject.getFeatureCallArguments().get(0), 0, shortClosureNode);
				} else {
					ICompositeNode shortClosureNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, 0, 0, semanticObject.getFeatureCallArguments().get(0));
					acceptAssignedParserRuleCall(semanticObject, xfce.getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0(), semanticObject.getFeatureCallArguments().get(0), 0, shortClosureNode);
					for(int i = 1; i < semanticObject.getFeatureCallArguments().size(); i++) {
						shortClosureNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, i, i, semanticObject.getFeatureCallArguments().get(0));
						acceptAssignedParserRuleCall(semanticObject, xfce.getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0(), semanticObject.getFeatureCallArguments().get(i), i, shortClosureNode);
					}
				}
			}
		}
		acceptFinish();
	}
	
	
	protected boolean isXShortClosure(EObject semanticObject, EReference reference, INodesForEObjectProvider nodes) {
		List<?> values = (List<?>) semanticObject.eGet(reference);
		if (values.size() != 1 || !(values.get(0) instanceof XClosure))
			return false;
		INode node = nodes.getNodeForMultiValue(reference, 0, 0, values.get(0));
		if (node != null && node.getGrammarElement() instanceof RuleCall)
			return ((RuleCall) node.getGrammarElement()).getRule() == grammarAccess.getXShortClosureAccess()
					.getXClosureAction_0_0_0();
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
	protected void sequence_XMemberFeatureCall_XMemberFeatureCall(EObject context, XMemberFeatureCall semanticObject) {
		XMemberFeatureCallElements xmfce = grammarAccess.getXMemberFeatureCallAccess();
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		
		// memberCallTarget=XMemberFeatureCall_XMemberFeatureCall_1_1_0_0_0
		ICompositeNode memberCallTargetNode = (ICompositeNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET, semanticObject.getMemberCallTarget());
		acceptAssignedAction(semanticObject, xmfce.getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(), semanticObject.getMemberCallTarget(), -1, memberCallTargetNode);
		
		// (nullSafe?='?.' | spreading?='*.')?
		if(semanticObject.isNullSafe()) {
			ILeafNode nullSafeNode = (ILeafNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XMEMBER_FEATURE_CALL__NULL_SAFE, semanticObject.isNullSafe());
			acceptAssignedKeyword(semanticObject, xmfce.getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0(), semanticObject.isNullSafe(), -1, nullSafeNode);
		} else if(semanticObject.isSpreading()) {
			ILeafNode nullSafeNode = (ILeafNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XMEMBER_FEATURE_CALL__SPREADING, semanticObject.isSpreading());
			acceptAssignedKeyword(semanticObject, xmfce.getSpreadingAsteriskFullStopKeyword_1_1_0_0_1_2_0(), semanticObject.isSpreading(), -1, nullSafeNode);
		}
		
		// (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
		List<JvmTypeReference> typeArguments = semanticObject.getTypeArguments();
		if(!typeArguments.isEmpty()) {
			ICompositeNode typeArgumentNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS, 0, 0, typeArguments.get(0));
			acceptAssignedParserRuleCall(semanticObject, xmfce.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0(), typeArguments.get(0), -1, typeArgumentNode);
			for(int i = 1; i<typeArguments.size(); i++) {
				typeArgumentNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS, i, i, typeArguments.get(i));
				acceptAssignedParserRuleCall(semanticObject, xmfce.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0(), typeArguments.get(i), i, typeArgumentNode);
			}
		}
		
		// feature=[JvmIdentifiableElement|ID]
		ILeafNode featureNode = (ILeafNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, semanticObject.getFeature());
		acceptAssignedCrossRefTerminal(semanticObject, xmfce.getFeatureJvmIdentifiableElementIDTerminalRuleCall_1_1_2_0_1(), semanticObject.getFeature(), -1, featureNode);
		
		// (explicitOperationCall?='(' (memberCallArguments+=XShortClosure | (memberCallArguments+=XExpression memberCallArguments+=XExpression*))?)?
		if(semanticObject.isExplicitOperationCall()) {
			ILeafNode explicitOperationCallNode = (ILeafNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL, semanticObject.isExplicitOperationCall());
			acceptAssignedKeyword(semanticObject, xmfce.getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0(), semanticObject.isExplicitOperationCall(), -1, explicitOperationCallNode);
			if(!semanticObject.getMemberCallArguments().isEmpty()) {
				if(isXShortClosure(semanticObject, XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, nodes)) {
					ICompositeNode shortClosureNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, 0, 0, semanticObject.getMemberCallArguments().get(0));
					acceptAssignedParserRuleCall(semanticObject, xmfce.getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0(), semanticObject.getMemberCallArguments().get(0), 0, shortClosureNode);
				} else {
					ICompositeNode shortClosureNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, 0, 0, semanticObject.getMemberCallArguments().get(0));
					acceptAssignedParserRuleCall(semanticObject, xmfce.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0(), semanticObject.getMemberCallArguments().get(0), 0, shortClosureNode);
					for(int i = 1; i < semanticObject.getMemberCallArguments().size(); i++) {
						shortClosureNode = (ICompositeNode) nodes.getNodeForMultiValue(XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, i, i, semanticObject.getMemberCallArguments().get(0));
						acceptAssignedParserRuleCall(semanticObject, xmfce.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0(), semanticObject.getMemberCallArguments().get(i), i, shortClosureNode);
					}
				}
			}
		}
		acceptFinish();
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
	protected void sequence_XConstructorCall_XConstructorCall(EObject context, XConstructorCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
