package org.eclipse.xtext.xtend2.serializer;

import java.util.Collections;
import static java.util.Collections.singleton;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.serializer.GenericSequencer;
import org.eclipse.xtext.serializer.ISemanticNodeProvider;
import org.eclipse.xtext.serializer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ITransientValueService;
import org.eclipse.xtext.serializer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.impl.AbstractSemanticSequencer;
import org.eclipse.xtext.xtend2.services.Xtend2GrammarAccess;
import org.eclipse.xtext.xtend2.xtend2.*;
import org.eclipse.xtext.common.types.*;
import org.eclipse.xtext.xbase.*;
import org.eclipse.xtext.xtype.*;
import org.eclipse.xtext.xbase.serializer.XbaseSemanticSequencer;

import com.google.inject.Inject;
import com.google.inject.Provider;	

@SuppressWarnings("restriction")
public class AbstractXtend2SemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected Xtend2GrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	protected ISemanticNodeProvider nodeProvider;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	@Inject
	protected Provider<XbaseSemanticSequencer> superSequencerProvider;
	 
	protected XbaseSemanticSequencer superSequencer; 
	
	@Override
	public void init(ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequenceAcceptor, errorAcceptor);
		this.superSequencer = superSequencerProvider.get();
		this.superSequencer.init(sequenceAcceptor, errorAcceptor); 
	}
	
	public Iterable<EObject> findContexts(EObject semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		if(semanticObject.eClass().getEPackage() == Xtend2Package.eINSTANCE) 
			switch(semanticObject.eClass().getClassifierID()) {
				case Xtend2Package.XTEND_CLASS:           return singleton((EObject)grammarAccess.getClassRule());
				case Xtend2Package.CREATE_EXTENSION_INFO: return singleton((EObject)grammarAccess.getCreateExtensionInfoRule());
				case Xtend2Package.DECLARED_DEPENDENCY:   return findContexts((DeclaredDependency)semanticObject, consultContainer, contextCandidates);
				case Xtend2Package.XTEND_FILE:            return singleton((EObject)grammarAccess.getFileRule());
				case Xtend2Package.XTEND_FUNCTION:        return findContexts((XtendFunction)semanticObject, consultContainer, contextCandidates);
				case Xtend2Package.XTEND_IMPORT:          return singleton((EObject)grammarAccess.getImportRule());
				case Xtend2Package.RICH_STRING_LITERAL:   return findContexts((RichStringLiteral)semanticObject, consultContainer, contextCandidates);
				case Xtend2Package.RICH_STRING:           return findContexts((RichString)semanticObject, consultContainer, contextCandidates);
				case Xtend2Package.RICH_STRING_ELSE_IF:   return singleton((EObject)grammarAccess.getRichStringElseIfRule());
				case Xtend2Package.RICH_STRING_FOR_LOOP:  return findContexts((RichStringForLoop)semanticObject, consultContainer, contextCandidates);
				case Xtend2Package.RICH_STRING_IF:        return findContexts((RichStringIf)semanticObject, consultContainer, contextCandidates);
			}
		else if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) 
			switch(semanticObject.eClass().getClassifierID()) {
				case TypesPackage.JVM_FORMAL_PARAMETER:             return findContexts((JvmFormalParameter)semanticObject, consultContainer, contextCandidates);
				case TypesPackage.JVM_LOWER_BOUND:                  return singleton((EObject)grammarAccess.getJvmLowerBoundRule());
				case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE: return findContexts((JvmParameterizedTypeReference)semanticObject, consultContainer, contextCandidates);
				case TypesPackage.JVM_TYPE_PARAMETER:               return singleton((EObject)grammarAccess.getJvmTypeParameterRule());
				case TypesPackage.JVM_UPPER_BOUND:                  return findContexts((JvmUpperBound)semanticObject, consultContainer, contextCandidates);
				case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:      return findContexts((JvmWildcardTypeReference)semanticObject, consultContainer, contextCandidates);
			}
		else if(semanticObject.eClass().getEPackage() == XbasePackage.eINSTANCE) 
			switch(semanticObject.eClass().getClassifierID()) {
				case XbasePackage.XNULL_LITERAL:                 return findContexts((XNullLiteral)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XBINARY_OPERATION:             return findContexts((XBinaryOperation)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XASSIGNMENT:                   return findContexts((XAssignment)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XBLOCK_EXPRESSION:             return findContexts((XBlockExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XBOOLEAN_LITERAL:              return findContexts((XBooleanLiteral)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XCASE_PART:                    return singleton((EObject)grammarAccess.getXCasePartRule());
				case XbasePackage.XCASTED_EXPRESSION:            return findContexts((XCastedExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XCATCH_CLAUSE:                 return singleton((EObject)grammarAccess.getXCatchClauseRule());
				case XbasePackage.XCLOSURE:                      return findContexts((XClosure)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XCONSTRUCTOR_CALL:             return findContexts((XConstructorCall)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XDO_WHILE_EXPRESSION:          return findContexts((XDoWhileExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XFEATURE_CALL:                 return findContexts((XFeatureCall)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XFOR_LOOP_EXPRESSION:          return findContexts((XForLoopExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XIF_EXPRESSION:                return findContexts((XIfExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XINT_LITERAL:                  return findContexts((XIntLiteral)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XMEMBER_FEATURE_CALL:          return findContexts((XMemberFeatureCall)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XINSTANCE_OF_EXPRESSION:       return findContexts((XInstanceOfExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XRETURN_EXPRESSION:            return findContexts((XReturnExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XSTRING_LITERAL:               return findContexts((XStringLiteral)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XSWITCH_EXPRESSION:            return findContexts((XSwitchExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XTHROW_EXPRESSION:             return findContexts((XThrowExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION: return findContexts((XTryCatchFinallyExpression)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XTYPE_LITERAL:                 return findContexts((XTypeLiteral)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XUNARY_OPERATION:              return findContexts((XUnaryOperation)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XVARIABLE_DECLARATION:         return findContexts((XVariableDeclaration)semanticObject, consultContainer, contextCandidates);
				case XbasePackage.XWHILE_EXPRESSION:             return findContexts((XWhileExpression)semanticObject, consultContainer, contextCandidates);
			}
		else if(semanticObject.eClass().getEPackage() == XtypePackage.eINSTANCE) 
			switch(semanticObject.eClass().getClassifierID()) {
				case XtypePackage.XFUNCTION_TYPE_REF: return findContexts((XFunctionTypeRef)semanticObject, consultContainer, contextCandidates);
			}
		return Collections.emptyList();
	}
	
	/**
	 * Potential Result Contexts:
	 *     getMemberRule()
	 *     getDeclaredDependencyRule()
	 */
	protected Iterable<EObject> findContexts(DeclaredDependency semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getMemberRule()
	 *     getFunctionRule()
	 */
	protected Iterable<EObject> findContexts(XtendFunction semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringLiteralRule()
	 *     getRichStringLiteralStartRule()
	 *     getRichStringLiteralInbetweenRule()
	 *     getRichStringLiteralEndRule()
	 *     getInternalRichStringLiteralRule()
	 */
	protected Iterable<EObject> findContexts(RichStringLiteral semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getXStringLiteralRule()
	 *     getRichStringRule()
	 *     getInternalRichStringRule()
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXLiteralRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(RichString semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getParameterRule()
	 *     getJvmFormalParameterRule()
	 */
	protected Iterable<EObject> findContexts(JvmFormalParameter semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getJvmTypeReferenceRule()
	 *     getJvmParameterizedTypeReferenceRule()
	 *     getJvmArgumentTypeReferenceRule()
	 */
	protected Iterable<EObject> findContexts(JvmParameterizedTypeReference semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getJvmUpperBoundRule()
	 *     getJvmUpperBoundAndedRule()
	 */
	protected Iterable<EObject> findContexts(JvmUpperBound semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getJvmArgumentTypeReferenceRule()
	 *     getJvmWildcardTypeReferenceRule()
	 */
	protected Iterable<EObject> findContexts(JvmWildcardTypeReference semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getRichStringForLoopRule()
	 */
	protected Iterable<EObject> findContexts(RichStringForLoop semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getRichStringIfRule()
	 */
	protected Iterable<EObject> findContexts(RichStringIf semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXLiteralRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXNullLiteralRule()
	 */
	protected Iterable<EObject> findContexts(XNullLiteral semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XBinaryOperation semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XAssignment semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXBlockExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XBlockExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXLiteralRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXBooleanLiteralRule()
	 */
	protected Iterable<EObject> findContexts(XBooleanLiteral semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XCastedExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXLiteralRule()
	 *     getXClosureRule()
	 *     getXShortClosureRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XClosure semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXConstructorCallRule()
	 */
	protected Iterable<EObject> findContexts(XConstructorCall semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXDoWhileExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XDoWhileExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXFeatureCallRule()
	 */
	protected Iterable<EObject> findContexts(XFeatureCall semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXForLoopExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XForLoopExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getJvmTypeReferenceRule()
	 *     getXFunctionTypeRefRule()
	 *     getJvmArgumentTypeReferenceRule()
	 */
	protected Iterable<EObject> findContexts(XFunctionTypeRef semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXIfExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XIfExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXLiteralRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXIntLiteralRule()
	 */
	protected Iterable<EObject> findContexts(XIntLiteral semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XMemberFeatureCall semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XInstanceOfExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXReturnExpressionRule()
	 */
	protected Iterable<EObject> findContexts(XReturnExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getXStringLiteralRule()
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXLiteralRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XStringLiteral semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXSwitchExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XSwitchExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXThrowExpressionRule()
	 */
	protected Iterable<EObject> findContexts(XThrowExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXTryCatchFinallyExpressionRule()
	 */
	protected Iterable<EObject> findContexts(XTryCatchFinallyExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXLiteralRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXTypeLiteralRule()
	 */
	protected Iterable<EObject> findContexts(XTypeLiteral semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XUnaryOperation semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionInsideBlockRule()
	 *     getXVariableDeclarationRule()
	 */
	protected Iterable<EObject> findContexts(XVariableDeclaration semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getRichStringPartRule()
	 *     getXExpressionRule()
	 *     getXAssignmentRule()
	 *     getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOrExpressionRule()
	 *     getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAndExpressionRule()
	 *     getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXEqualityExpressionRule()
	 *     getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXRelationalExpressionRule()
	 *     getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
	 *     getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
	 *     getXOtherOperatorExpressionRule()
	 *     getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXAdditiveExpressionRule()
	 *     getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXMultiplicativeExpressionRule()
	 *     getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
	 *     getXUnaryOperationRule()
	 *     getXCastedExpressionRule()
	 *     getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
	 *     getXMemberFeatureCallRule()
	 *     getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
	 *     getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
	 *     getXPrimaryExpressionRule()
	 *     getXParenthesizedExpressionRule()
	 *     getXWhileExpressionRule()
	 *     getXExpressionInsideBlockRule()
	 */
	protected Iterable<EObject> findContexts(XWhileExpression semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Xtend2Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Xtend2Package.XTEND_CLASS:
				if(context == grammarAccess.getClassRule()) {
					sequence_Class_XtendClass(context, (XtendClass) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.CREATE_EXTENSION_INFO:
				if(context == grammarAccess.getCreateExtensionInfoRule()) {
					sequence_CreateExtensionInfo_CreateExtensionInfo(context, (CreateExtensionInfo) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.DECLARED_DEPENDENCY:
				if(context == grammarAccess.getMemberRule() ||
				   context == grammarAccess.getDeclaredDependencyRule()) {
					sequence_DeclaredDependency_DeclaredDependency(context, (DeclaredDependency) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.XTEND_FILE:
				if(context == grammarAccess.getFileRule()) {
					sequence_File_XtendFile(context, (XtendFile) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.XTEND_FUNCTION:
				if(context == grammarAccess.getMemberRule() ||
				   context == grammarAccess.getFunctionRule()) {
					sequence_Function_XtendFunction(context, (XtendFunction) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.XTEND_IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import_XtendImport(context, (XtendImport) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.RICH_STRING_LITERAL:
				if(context == grammarAccess.getRichStringLiteralInbetweenRule()) {
					sequence_RichStringLiteralInbetween_RichStringLiteral(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInternalRichStringLiteralRule()) {
					sequence_InternalRichStringLiteral_RichStringLiteral(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRichStringLiteralEndRule()) {
					sequence_RichStringLiteralEnd_RichStringLiteral(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRichStringLiteralRule()) {
					sequence_RichStringLiteral_RichStringLiteral(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRichStringLiteralStartRule()) {
					sequence_RichStringLiteralStart_RichStringLiteral(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.RICH_STRING:
				if(context == grammarAccess.getXStringLiteralRule() ||
				   context == grammarAccess.getRichStringRule() ||
				   context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_RichString_RichString(context, (RichString) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInternalRichStringRule()) {
					sequence_InternalRichString_RichString(context, (RichString) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.RICH_STRING_ELSE_IF:
				if(context == grammarAccess.getRichStringElseIfRule()) {
					sequence_RichStringElseIf_RichStringElseIf(context, (RichStringElseIf) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.RICH_STRING_FOR_LOOP:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getRichStringForLoopRule()) {
					sequence_RichStringForLoop_RichStringForLoop(context, (RichStringForLoop) semanticObject); 
					return; 
				}
				else break;
			case Xtend2Package.RICH_STRING_IF:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getRichStringIfRule()) {
					sequence_RichStringIf_RichStringIf(context, (RichStringIf) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_FORMAL_PARAMETER:
				if(context == grammarAccess.getParameterRule()) {
					sequence_Parameter_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_LOWER_BOUND:
				if(context == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceRule() ||
				   context == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				if(context == grammarAccess.getJvmTypeParameterRule()) {
					sequence_JvmTypeParameter_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_UPPER_BOUND:
				if(context == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmWildcardTypeReferenceRule()) {
					sequence_JvmWildcardTypeReference_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XbasePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XbasePackage.XNULL_LITERAL:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXNullLiteralRule()) {
					sequence_RichStringPart_XNullLiteral(context, (XNullLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBINARY_OPERATION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XAdditiveExpression_XBinaryOperation(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XASSIGNMENT:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XAssignment_XAssignment(context, (XAssignment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBLOCK_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXBlockExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XBlockExpression_XBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXBooleanLiteralRule()) {
					sequence_XBooleanLiteral_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCASE_PART:
				if(context == grammarAccess.getXCasePartRule()) {
					sequence_XCasePart_XCasePart(context, (XCasePart) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCASTED_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XCastedExpression_XCastedExpression(context, (XCastedExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCATCH_CLAUSE:
				if(context == grammarAccess.getXCatchClauseRule()) {
					sequence_XCatchClause_XCatchClause(context, (XCatchClause) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCLOSURE:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXClosureRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XClosure_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXShortClosureRule()) {
					sequence_XShortClosure_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXConstructorCallRule()) {
					sequence_XConstructorCall_XConstructorCall(context, (XConstructorCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XDO_WHILE_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXDoWhileExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XDoWhileExpression_XDoWhileExpression(context, (XDoWhileExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFEATURE_CALL:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXFeatureCallRule()) {
					sequence_XFeatureCall_XFeatureCall(context, (XFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFOR_LOOP_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXForLoopExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XForLoopExpression_XForLoopExpression(context, (XForLoopExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XIF_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXIfExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XIfExpression_XIfExpression(context, (XIfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINT_LITERAL:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXIntLiteralRule()) {
					sequence_XIntLiteral_XIntLiteral(context, (XIntLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XMEMBER_FEATURE_CALL:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XMemberFeatureCall_XMemberFeatureCall(context, (XMemberFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XRelationalExpression_XInstanceOfExpression(context, (XInstanceOfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XRETURN_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXReturnExpressionRule()) {
					sequence_XReturnExpression_XReturnExpression(context, (XReturnExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSTRING_LITERAL:
				if(context == grammarAccess.getXStringLiteralRule() ||
				   context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XStringLiteral_XStringLiteral(context, (XStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSWITCH_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXSwitchExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XSwitchExpression_XSwitchExpression(context, (XSwitchExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTHROW_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXThrowExpressionRule()) {
					sequence_XThrowExpression_XThrowExpression(context, (XThrowExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXTryCatchFinallyExpressionRule()) {
					sequence_XTryCatchFinallyExpression_XTryCatchFinallyExpression(context, (XTryCatchFinallyExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTYPE_LITERAL:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXTypeLiteralRule()) {
					sequence_XTypeLiteral_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XUNARY_OPERATION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XUnaryOperation_XUnaryOperation(context, (XUnaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XVARIABLE_DECLARATION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXVariableDeclarationRule()) {
					sequence_XVariableDeclaration_XVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XWHILE_EXPRESSION:
				if(context == grammarAccess.getRichStringPartRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXWhileExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule()) {
					sequence_XWhileExpression_XWhileExpression(context, (XWhileExpression) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XtypePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				if(context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getXFunctionTypeRefRule() ||
				   context == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_XFunctionTypeRef_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)?
	 *         extends=JvmTypeReference?
	 *         (implements+=JvmTypeReference implements+=JvmTypeReference*)?
	 *         members+=Member*
	 *     )
	 *     
	 *
	 * Features:
	 *    typeParameters[0, *]
	 *    name[1, 1]
	 *    extends[0, 1]
	 *    implements[0, *]
	 *    members[0, *]
	 */
	protected void sequence_Class_XtendClass(EObject context, XtendClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? createExpression=XExpression)
	 *
	 * Features:
	 *    createExpression[1, 1]
	 *    name[0, 1]
	 */
	protected void sequence_CreateExtensionInfo_CreateExtensionInfo(EObject context, CreateExtensionInfo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (extension?='extension'? type=JvmTypeReference name=ID?)
	 *
	 * Features:
	 *    name[0, 1]
	 *    type[1, 1]
	 *    extension[0, 1]
	 */
	protected void sequence_DeclaredDependency_DeclaredDependency(EObject context, DeclaredDependency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (package=QualifiedName? imports+=Import* xtendClass=Class?)
	 *
	 * Features:
	 *    imports[0, *]
	 *    xtendClass[0, 1]
	 *    package[0, 1]
	 */
	protected void sequence_File_XtendFile(EObject context, XtendFile semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         override?='override'?
	 *         dispatch?='dispatch'?
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)?
	 *         (returnType=JvmTypeReference | createExtensionInfo=CreateExtensionInfo)?
	 *         name=ID
	 *         (parameters+=Parameter parameters+=Parameter*)?
	 *         (expression=XBlockExpression | expression=RichString)?
	 *     )
	 *     
	 *
	 * Features:
	 *    declaringType[0, *]
	 *    name[1, 1]
	 *    expression[0, 2]
	 *    returnType[0, 1]
	 *         EXCLUDE_IF_SET createExtensionInfo
	 *    parameters[0, *]
	 *    override[0, 1]
	 *    dispatch[0, 1]
	 *    createExtensionInfo[0, 1]
	 *         EXCLUDE_IF_SET returnType
	 */
	protected void sequence_Function_XtendFunction(EObject context, XtendFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((static?='static' extension?='extension'?)? importedNamespace=QualifiedNameWithWildCard)
	 *
	 * Features:
	 *    importedNamespace[1, 1]
	 *    static[0, 1]
	 *         MANDATORY_IF_SET extension
	 *    extension[0, 1]
	 *         EXCLUDE_IF_UNSET static
	 */
	protected void sequence_Import_XtendImport(EObject context, XtendImport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=RICH_TEXT_INBETWEEN
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_InternalRichStringLiteral_RichStringLiteral(EObject context, RichStringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(semanticObject, grammarAccess.getInternalRichStringLiteralAccess().getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0(), semanticObject.getValue(), -1, (ILeafNode)nodes.getNodeForSingelValue(XbasePackage.Literals.XSTRING_LITERAL__VALUE, semanticObject.getValue()));
		acceptFinish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         expressions+=InternalRichStringLiteral | 
	 *         (expressions+=RichStringLiteralInbetween (expressions+=RichStringPart expressions+=RichStringLiteralInbetween)+)
	 *     )
	 *     
	 *
	 * Features:
	 *    expressions[3, *]
	 */
	protected void sequence_InternalRichString_RichString(EObject context, RichString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parameterType=JvmTypeReference? name=ID)
	 *
	 * Features:
	 *    name[1, 1]
	 *    parameterType[0, 1]
	 */
	protected void sequence_JvmFormalParameter_JvmFormalParameter(EObject context, JvmFormalParameter semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 *
	 * Features:
	 *    typeReference[1, 1]
	 */
	protected void sequence_JvmLowerBound_JvmLowerBound(EObject context, JvmLowerBound semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] (arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)?)
	 *
	 * Features:
	 *    arguments[0, *]
	 *    type[1, 1]
	 */
	protected void sequence_JvmParameterizedTypeReference_JvmParameterizedTypeReference(EObject context, JvmParameterizedTypeReference semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID ((constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*) | constraints+=JvmLowerBound)?)
	 *
	 * Features:
	 *    arrayType[1, *]
	 *    name[1, 1]
	 */
	protected void sequence_JvmTypeParameter_JvmTypeParameter(EObject context, JvmTypeParameter semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 *
	 * Features:
	 *    typeReference[1, 1]
	 */
	protected void sequence_JvmUpperBoundAnded_JvmUpperBound(EObject context, JvmUpperBound semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 *
	 * Features:
	 *    typeReference[1, 1]
	 */
	protected void sequence_JvmUpperBound_JvmUpperBound(EObject context, JvmUpperBound semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((constraints+=JvmUpperBound | constraints+=JvmLowerBound)?)
	 *
	 * Features:
	 *    constraints[0, 2]
	 */
	protected void sequence_JvmWildcardTypeReference_JvmWildcardTypeReference(EObject context, JvmWildcardTypeReference semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parameterType=JvmTypeReference name=ID)
	 *
	 * Features:
	 *    name[1, 1]
	 *    parameterType[1, 1]
	 */
	protected void sequence_Parameter_JvmFormalParameter(EObject context, JvmFormalParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (if=XExpression then=InternalRichString)
	 *
	 * Features:
	 *    if[1, 1]
	 *    then[1, 1]
	 */
	protected void sequence_RichStringElseIf_RichStringElseIf(EObject context, RichStringElseIf semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF));
			if(transientValues.isValueTransient(semanticObject, Xtend2Package.Literals.RICH_STRING_ELSE_IF__THEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Xtend2Package.Literals.RICH_STRING_ELSE_IF__THEN));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedParserRuleCall(semanticObject, grammarAccess.getRichStringElseIfAccess().getIfXExpressionParserRuleCall_1_0(), semanticObject.getIf(), -1, (ICompositeNode)nodes.getNodeForSingelValue(Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF, semanticObject.getIf()));
		acceptAssignedParserRuleCall(semanticObject, grammarAccess.getRichStringElseIfAccess().getThenInternalRichStringParserRuleCall_2_0(), semanticObject.getThen(), -1, (ICompositeNode)nodes.getNodeForSingelValue(Xtend2Package.Literals.RICH_STRING_ELSE_IF__THEN, semanticObject.getThen()));
		acceptFinish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         declaredParam=JvmFormalParameter
	 *         forExpression=XExpression
	 *         before=XExpression?
	 *         separator=XExpression?
	 *         after=XExpression?
	 *         eachExpression=InternalRichString
	 *     )
	 *     
	 *
	 * Features:
	 *    forExpression[1, 1]
	 *    eachExpression[1, 1]
	 *    declaredParam[1, 1]
	 *    separator[0, 1]
	 *    before[0, 1]
	 *    after[0, 1]
	 */
	protected void sequence_RichStringForLoop_RichStringForLoop(EObject context, RichStringForLoop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (if=XExpression then=InternalRichString elseIfs+=RichStringElseIf* else=InternalRichString?)
	 *
	 * Features:
	 *    if[1, 1]
	 *    then[1, 1]
	 *    elseIfs[0, *]
	 *    else[0, 1]
	 */
	protected void sequence_RichStringIf_RichStringIf(EObject context, RichStringIf semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=RICH_TEXT_END
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_RichStringLiteralEnd_RichStringLiteral(EObject context, RichStringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(semanticObject, grammarAccess.getRichStringLiteralEndAccess().getValueRICH_TEXT_ENDTerminalRuleCall_1_0(), semanticObject.getValue(), -1, (ILeafNode)nodes.getNodeForSingelValue(XbasePackage.Literals.XSTRING_LITERAL__VALUE, semanticObject.getValue()));
		acceptFinish();
	}
	
	
	/**
	 * Constraint:
	 *     value=RICH_TEXT_INBETWEEN
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_RichStringLiteralInbetween_RichStringLiteral(EObject context, RichStringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(semanticObject, grammarAccess.getRichStringLiteralInbetweenAccess().getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0(), semanticObject.getValue(), -1, (ILeafNode)nodes.getNodeForSingelValue(XbasePackage.Literals.XSTRING_LITERAL__VALUE, semanticObject.getValue()));
		acceptFinish();
	}
	
	
	/**
	 * Constraint:
	 *     value=RICH_TEXT_START
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_RichStringLiteralStart_RichStringLiteral(EObject context, RichStringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(semanticObject, grammarAccess.getRichStringLiteralStartAccess().getValueRICH_TEXT_STARTTerminalRuleCall_1_0(), semanticObject.getValue(), -1, (ILeafNode)nodes.getNodeForSingelValue(XbasePackage.Literals.XSTRING_LITERAL__VALUE, semanticObject.getValue()));
		acceptFinish();
	}
	
	
	/**
	 * Constraint:
	 *     value=RICH_TEXT
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_RichStringLiteral_RichStringLiteral(EObject context, RichStringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(semanticObject, grammarAccess.getRichStringLiteralAccess().getValueRICH_TEXTTerminalRuleCall_1_0(), semanticObject.getValue(), -1, (ILeafNode)nodes.getNodeForSingelValue(XbasePackage.Literals.XSTRING_LITERAL__VALUE, semanticObject.getValue()));
		acceptFinish();
	}
	
	
	/**
	 * Constraint:
	 *     {XNullLiteral}
	 *
	 * Features:
	 */
	protected void sequence_RichStringPart_XNullLiteral(EObject context, XNullLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         expressions+=RichStringLiteral | 
	 *         (
	 *             expressions+=RichStringLiteralStart
	 *             expressions+=RichStringPart
	 *             (expressions+=RichStringLiteralInbetween expressions+=RichStringPart)*
	 *             expressions+=RichStringLiteralEnd
	 *         )
	 *         
	 *     )
	 *     
	 *
	 * Features:
	 *    expressions[3, *]
	 */
	protected void sequence_RichString_RichString(EObject context, RichString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
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
	 *     
	 *
	 * Features:
	 *    feature[8, 8]
	 *    leftOperand[8, 8]
	 *    rightOperand[8, 8]
	 */
	protected void sequence_XAdditiveExpression_XBinaryOperation(EObject context, XBinaryOperation semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (feature=[JvmIdentifiableElement|ID] value=XAssignment) | 
	 *         (assignable=XMemberFeatureCall_XAssignment_1_0_0_0_0 feature=[JvmIdentifiableElement|ID] value=XAssignment)
	 *     )
	 *     
	 *
	 * Features:
	 *    feature[2, 2]
	 *    assignable[1, 1]
	 *         EXCLUDE_IF_UNSET feature
	 *         MANDATORY_IF_SET feature
	 *         EXCLUDE_IF_UNSET value
	 *         MANDATORY_IF_SET value
	 *         EXCLUDE_IF_SET feature
	 *         EXCLUDE_IF_SET value
	 *    value[2, 2]
	 */
	protected void sequence_XAssignment_XAssignment(EObject context, XAssignment semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expressions+=XExpressionInsideBlock*)
	 *
	 * Features:
	 *    expressions[0, *]
	 */
	protected void sequence_XBlockExpression_XBlockExpression(EObject context, XBlockExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (isTrue?='true'?)
	 *
	 * Features:
	 *    isTrue[0, 1]
	 */
	protected void sequence_XBooleanLiteral_XBooleanLiteral(EObject context, XBooleanLiteral semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (typeGuard=JvmTypeReference? case=XExpression? then=XExpression)
	 *
	 * Features:
	 *    case[0, 1]
	 *    then[1, 1]
	 *    typeGuard[0, 1]
	 */
	protected void sequence_XCasePart_XCasePart(EObject context, XCasePart semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (target=XCastedExpression_XCastedExpression_1_0_0_0 type=JvmTypeReference)
	 *
	 * Features:
	 *    type[1, 1]
	 *    target[1, 1]
	 */
	protected void sequence_XCastedExpression_XCastedExpression(EObject context, XCastedExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (declaredParam=JvmFormalParameter expression=XExpression)
	 *
	 * Features:
	 *    expression[1, 1]
	 *    declaredParam[1, 1]
	 */
	protected void sequence_XCatchClause_XCatchClause(EObject context, XCatchClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((formalParameters+=JvmFormalParameter formalParameters+=JvmFormalParameter*)? expression=XExpression)
	 *
	 * Features:
	 *    formalParameters[0, *]
	 *    expression[1, 1]
	 */
	protected void sequence_XClosure_XClosure(EObject context, XClosure semanticObject) {
		superSequencer.createSequence(context, semanticObject);
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
	protected void sequence_XConstructorCall_XConstructorCall(EObject context, XConstructorCall semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (body=XExpression predicate=XExpression)
	 *
	 * Features:
	 *    predicate[1, 1]
	 *    body[1, 1]
	 */
	protected void sequence_XDoWhileExpression_XDoWhileExpression(EObject context, XDoWhileExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
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
	protected void sequence_XFeatureCall_XFeatureCall(EObject context, XFeatureCall semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (declaredParam=JvmFormalParameter forExpression=XExpression eachExpression=XExpression)
	 *
	 * Features:
	 *    forExpression[1, 1]
	 *    eachExpression[1, 1]
	 *    declaredParam[1, 1]
	 */
	protected void sequence_XForLoopExpression_XForLoopExpression(EObject context, XForLoopExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((paramTypes+=JvmTypeReference paramTypes+=JvmTypeReference*)? returnType=JvmTypeReference)
	 *
	 * Features:
	 *    paramTypes[0, *]
	 *    returnType[1, 1]
	 */
	protected void sequence_XFunctionTypeRef_XFunctionTypeRef(EObject context, XFunctionTypeRef semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (if=XExpression then=XExpression else=XExpression?)
	 *
	 * Features:
	 *    if[1, 1]
	 *    then[1, 1]
	 *    else[0, 1]
	 */
	protected void sequence_XIfExpression_XIfExpression(EObject context, XIfExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_XIntLiteral_XIntLiteral(EObject context, XIntLiteral semanticObject) {
		superSequencer.createSequence(context, semanticObject);
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
	protected void sequence_XMemberFeatureCall_XMemberFeatureCall(EObject context, XMemberFeatureCall semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=XRelationalExpression_XInstanceOfExpression_1_0_0_0_0 type=[JvmType|QualifiedName])
	 *
	 * Features:
	 *    type[1, 1]
	 *    expression[1, 1]
	 */
	protected void sequence_XRelationalExpression_XInstanceOfExpression(EObject context, XInstanceOfExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=XExpression?)
	 *
	 * Features:
	 *    expression[0, 1]
	 */
	protected void sequence_XReturnExpression_XReturnExpression(EObject context, XReturnExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((formalParameters+=JvmFormalParameter formalParameters+=JvmFormalParameter*)? expression=XExpression)
	 *
	 * Features:
	 *    formalParameters[0, *]
	 *    expression[1, 1]
	 */
	protected void sequence_XShortClosure_XClosure(EObject context, XClosure semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_XStringLiteral_XStringLiteral(EObject context, XStringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(semanticObject, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_0_1_0(), semanticObject.getValue(), -1, (ILeafNode)nodes.getNodeForSingelValue(XbasePackage.Literals.XSTRING_LITERAL__VALUE, semanticObject.getValue()));
		acceptFinish();
	}
	
	
	/**
	 * Constraint:
	 *     (localVarName=ID? switch=XExpression cases+=XCasePart+ default=XExpression?)
	 *
	 * Features:
	 *    switch[1, 1]
	 *    cases[1, *]
	 *    default[0, 1]
	 *    localVarName[0, 1]
	 */
	protected void sequence_XSwitchExpression_XSwitchExpression(EObject context, XSwitchExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=XExpression
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_XThrowExpression_XThrowExpression(EObject context, XThrowExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=XExpression ((catchClauses+=XCatchClause+ finallyExpression=XExpression?) | finallyExpression=XExpression))
	 *
	 * Features:
	 *    expression[1, 1]
	 *    finallyExpression[0, 2]
	 *    catchClauses[1, *]
	 *         MANDATORY_IF_SET finallyExpression
	 *         EXCLUDE_IF_SET finallyExpression
	 */
	protected void sequence_XTryCatchFinallyExpression_XTryCatchFinallyExpression(EObject context, XTryCatchFinallyExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     type=[JvmType|QualifiedName]
	 *
	 * Features:
	 *    type[1, 1]
	 */
	protected void sequence_XTypeLiteral_XTypeLiteral(EObject context, XTypeLiteral semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (feature=[JvmIdentifiableElement|OpUnary] operand=XCastedExpression)
	 *
	 * Features:
	 *    feature[1, 1]
	 *    operand[1, 1]
	 */
	protected void sequence_XUnaryOperation_XUnaryOperation(EObject context, XUnaryOperation semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (writeable?='var'? ((type=JvmTypeReference name=ID) | name=ID) right=XExpression?)
	 *
	 * Features:
	 *    type[1, 1]
	 *         EXCLUDE_IF_UNSET name
	 *         MANDATORY_IF_SET name
	 *         EXCLUDE_IF_SET name
	 *    name[1, 2]
	 *    right[0, 1]
	 *    writeable[0, 1]
	 */
	protected void sequence_XVariableDeclaration_XVariableDeclaration(EObject context, XVariableDeclaration semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (predicate=XExpression body=XExpression)
	 *
	 * Features:
	 *    predicate[1, 1]
	 *    body[1, 1]
	 */
	protected void sequence_XWhileExpression_XWhileExpression(EObject context, XWhileExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
}
