package org.eclipse.xtext.serializer.serializer;

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
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.syntacticsequencertest.*;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class AbstractSyntacticSequencerTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected SyntacticSequencerTestLanguageGrammarAccess grammarAccess;
	
	@Inject
	@GenericSequencer
	protected ISemanticSequencer genericSequencer;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	protected ISemanticNodeProvider nodeProvider;
	
	public Iterable<EObject> findContexts(EObject semanticObject, Iterable<EObject> contextCandidates) {
		if(semanticObject.eClass().getEPackage() == SyntacticsequencertestPackage.eINSTANCE) 
			switch(semanticObject.eClass().getClassifierID()) {
				case SyntacticsequencertestPackage.ADD0:                        return findContexts((Add0)semanticObject, contextCandidates);
				case SyntacticsequencertestPackage.ADD1:                        return findContexts((Add1)semanticObject, contextCandidates);
				case SyntacticsequencertestPackage.ADD2:                        return findContexts((Add2)semanticObject, contextCandidates);
				case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE_LITERAL: return singleton((EObject)grammarAccess.getBooleanAlternativeLiteralRule());
				case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE:         return singleton((EObject)grammarAccess.getBooleanAlternativeRule());
				case SyntacticsequencertestPackage.MANDATORY_KEYWORDS:          return singleton((EObject)grammarAccess.getMandatoryKeywordsRule());
				case SyntacticsequencertestPackage.MODEL:                       return singleton((EObject)grammarAccess.getModelRule());
				case SyntacticsequencertestPackage.MULT2:                       return findContexts((Mult2)semanticObject, contextCandidates);
				case SyntacticsequencertestPackage.VAL0:                        return findContexts((Val0)semanticObject, contextCandidates);
				case SyntacticsequencertestPackage.VAL1:                        return findContexts((Val1)semanticObject, contextCandidates);
				case SyntacticsequencertestPackage.VAL2:                        return findContexts((Val2)semanticObject, contextCandidates);
				case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE:      return singleton((EObject)grammarAccess.getSingleCrossReferenceRule());
			}
		return Collections.emptyList();
	}
	
	/**
	 * Potential Result Contexts:
	 *     getExp0Rule()
	 *     getAddition0Rule()
	 *     getAddition0Access().getAdd0LeftAction_1_0()
	 */
	protected Iterable<EObject> findContexts(Add0 semanticObject, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getExp1Rule()
	 *     getAddition1Rule()
	 *     getAddition1Access().getAdd1LeftAction_1_0()
	 *     getPrim1Rule()
	 */
	protected Iterable<EObject> findContexts(Add1 semanticObject, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getExp2Rule()
	 *     getAddition2Rule()
	 *     getAddition2Access().getAdd2LeftAction_1_0()
	 *     getMultiplication2Rule()
	 *     getMultiplication2Access().getMult2LeftAction_1_0()
	 *     getPrim2Rule()
	 */
	protected Iterable<EObject> findContexts(Add2 semanticObject, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getExp2Rule()
	 *     getAddition2Rule()
	 *     getAddition2Access().getAdd2LeftAction_1_0()
	 *     getMultiplication2Rule()
	 *     getMultiplication2Access().getMult2LeftAction_1_0()
	 *     getPrim2Rule()
	 */
	protected Iterable<EObject> findContexts(Mult2 semanticObject, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getExp0Rule()
	 *     getAddition0Rule()
	 *     getAddition0Access().getAdd0LeftAction_1_0()
	 *     getPrim0Rule()
	 */
	protected Iterable<EObject> findContexts(Val0 semanticObject, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getExp1Rule()
	 *     getAddition1Rule()
	 *     getAddition1Access().getAdd1LeftAction_1_0()
	 *     getPrim1Rule()
	 */
	protected Iterable<EObject> findContexts(Val1 semanticObject, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getExp2Rule()
	 *     getAddition2Rule()
	 *     getAddition2Access().getAdd2LeftAction_1_0()
	 *     getMultiplication2Rule()
	 *     getMultiplication2Access().getMult2LeftAction_1_0()
	 *     getPrim2Rule()
	 */
	protected Iterable<EObject> findContexts(Val2 semanticObject, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, contextCandidates);
	}
	
	public void createSequence(EObject context, EObject semanticObject, ISemanticSequenceAcceptor sequenceAcceptor,	Acceptor errorAcceptor) {
		if(semanticObject.eClass().getEPackage() == SyntacticsequencertestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SyntacticsequencertestPackage.ADD0:
				if(context == grammarAccess.getExp0Rule() ||
				   context == grammarAccess.getAddition0Rule() ||
				   context == grammarAccess.getAddition0Access().getAdd0LeftAction_1_0()) {
					sequence_Addition0_Add0(context, (Add0) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.ADD1:
				if(context == grammarAccess.getExp1Rule() ||
				   context == grammarAccess.getAddition1Rule() ||
				   context == grammarAccess.getAddition1Access().getAdd1LeftAction_1_0() ||
				   context == grammarAccess.getPrim1Rule()) {
					sequence_Addition1_Add1(context, (Add1) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.ADD2:
				if(context == grammarAccess.getExp2Rule() ||
				   context == grammarAccess.getAddition2Rule() ||
				   context == grammarAccess.getAddition2Access().getAdd2LeftAction_1_0() ||
				   context == grammarAccess.getMultiplication2Rule() ||
				   context == grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0() ||
				   context == grammarAccess.getPrim2Rule()) {
					sequence_Addition2_Add2(context, (Add2) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE_LITERAL:
				if(context == grammarAccess.getBooleanAlternativeLiteralRule()) {
					sequence_BooleanAlternativeLiteral_BooleanAlternativeLiteral(context, (BooleanAlternativeLiteral) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE:
				if(context == grammarAccess.getBooleanAlternativeRule()) {
					sequence_BooleanAlternative_BooleanAlternative(context, (BooleanAlternative) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.MANDATORY_KEYWORDS:
				if(context == grammarAccess.getMandatoryKeywordsRule()) {
					sequence_MandatoryKeywords_MandatoryKeywords(context, (MandatoryKeywords) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model_Model(context, (Model) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.MULT2:
				if(context == grammarAccess.getExp2Rule() ||
				   context == grammarAccess.getAddition2Rule() ||
				   context == grammarAccess.getAddition2Access().getAdd2LeftAction_1_0() ||
				   context == grammarAccess.getMultiplication2Rule() ||
				   context == grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0() ||
				   context == grammarAccess.getPrim2Rule()) {
					sequence_Multiplication2_Mult2(context, (Mult2) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.VAL0:
				if(context == grammarAccess.getExp0Rule() ||
				   context == grammarAccess.getAddition0Rule() ||
				   context == grammarAccess.getAddition0Access().getAdd0LeftAction_1_0() ||
				   context == grammarAccess.getPrim0Rule()) {
					sequence_Prim0_Val0(context, (Val0) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.VAL1:
				if(context == grammarAccess.getExp1Rule() ||
				   context == grammarAccess.getAddition1Rule() ||
				   context == grammarAccess.getAddition1Access().getAdd1LeftAction_1_0() ||
				   context == grammarAccess.getPrim1Rule()) {
					sequence_Prim1_Val1(context, (Val1) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.VAL2:
				if(context == grammarAccess.getExp2Rule() ||
				   context == grammarAccess.getAddition2Rule() ||
				   context == grammarAccess.getAddition2Access().getAdd2LeftAction_1_0() ||
				   context == grammarAccess.getMultiplication2Rule() ||
				   context == grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0() ||
				   context == grammarAccess.getPrim2Rule()) {
					sequence_Prim2_Val2(context, (Val2) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE:
				if(context == grammarAccess.getSingleCrossReferenceRule()) {
					sequence_SingleCrossReference_SingleCrossReference(context, (SingleCrossReference) semanticObject, sequenceAcceptor, errorAcceptor); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (left=Addition0_Add0_1_0 right=Prim0)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Addition0_Add0(EObject context, Add0 semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD0__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD0__LEFT));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD0__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD0__RIGHT));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedAction(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getAddition0Access().getAdd0LeftAction_1_0(), semanticObject.getLeft(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.ADD0__LEFT, semanticObject.getLeft()));
		acceptAssignedParserRuleCall(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getAddition0Access().getRightPrim0ParserRuleCall_1_2_0(), semanticObject.getRight(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.ADD0__RIGHT, semanticObject.getRight()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Addition1_Add1_1_0 right=Prim1)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Addition1_Add1(EObject context, Add1 semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD1__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD1__LEFT));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD1__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD1__RIGHT));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedAction(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getAddition1Access().getAdd1LeftAction_1_0(), semanticObject.getLeft(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.ADD1__LEFT, semanticObject.getLeft()));
		acceptAssignedParserRuleCall(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getAddition1Access().getRightPrim1ParserRuleCall_1_2_0(), semanticObject.getRight(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.ADD1__RIGHT, semanticObject.getRight()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Addition2_Add2_1_0 right=Multiplication2)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Addition2_Add2(EObject context, Add2 semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD2__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD2__LEFT));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD2__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD2__RIGHT));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedAction(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getAddition2Access().getAdd2LeftAction_1_0(), semanticObject.getLeft(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.ADD2__LEFT, semanticObject.getLeft()));
		acceptAssignedParserRuleCall(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getAddition2Access().getRightMultiplication2ParserRuleCall_1_2_0(), semanticObject.getRight(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.ADD2__RIGHT, semanticObject.getRight()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     (isTrue?='kw2'?)
	 *
	 * Features:
	 *    isTrue[0, 1]
	 */
	protected void sequence_BooleanAlternativeLiteral_BooleanAlternativeLiteral(EObject context, BooleanAlternativeLiteral semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		genericSequencer.createSequence(context, semanticObject, sequenceAcceptor, errorAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     bool=BooleanAlternativeLiteral
	 *
	 * Features:
	 *    bool[1, 1]
	 */
	protected void sequence_BooleanAlternative_BooleanAlternative(EObject context, BooleanAlternative semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.BOOLEAN_ALTERNATIVE__BOOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.BOOLEAN_ALTERNATIVE__BOOL));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedParserRuleCall(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getBooleanAlternativeAccess().getBoolBooleanAlternativeLiteralParserRuleCall_1_0(), semanticObject.getBool(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.BOOLEAN_ALTERNATIVE__BOOL, semanticObject.getBool()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID val3=ID)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[1, 1]
	 *    val3[1, 1]
	 */
	protected void sequence_MandatoryKeywords_MandatoryKeywords(EObject context, MandatoryKeywords semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL1));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL2));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL3) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL3));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getMandatoryKeywordsAccess().getVal1IDTerminalRuleCall_1_0(), semanticObject.getVal1(), -1, (ILeafNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL1, semanticObject.getVal1()));
		acceptAssignedTerminal(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getMandatoryKeywordsAccess().getVal2IDTerminalRuleCall_3_0(), semanticObject.getVal2(), -1, (ILeafNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL2, semanticObject.getVal2()));
		acceptAssignedTerminal(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getMandatoryKeywordsAccess().getVal3IDTerminalRuleCall_6_0(), semanticObject.getVal3(), -1, (ILeafNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL3, semanticObject.getVal3()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         x1=MandatoryKeywords | 
	 *         x2=Exp0 | 
	 *         x3=Exp1 | 
	 *         x4=Exp2 | 
	 *         x5=SingleCrossReference | 
	 *         x6=BooleanAlternative
	 *     )
	 *     
	 *
	 * Features:
	 *    x1[0, 1]
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *    x2[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *    x3[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *    x4[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *    x5[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x6
	 *    x6[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 */
	protected void sequence_Model_Model(EObject context, Model semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		genericSequencer.createSequence(context, semanticObject, sequenceAcceptor, errorAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication2_Mult2_1_0 right=Prim2)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Multiplication2_Mult2(EObject context, Mult2 semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MULT2__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MULT2__LEFT));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MULT2__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MULT2__RIGHT));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedAction(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0(), semanticObject.getLeft(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.MULT2__LEFT, semanticObject.getLeft()));
		acceptAssignedParserRuleCall(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getMultiplication2Access().getRightPrim2ParserRuleCall_1_2_0(), semanticObject.getRight(), -1, (ICompositeNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.MULT2__RIGHT, semanticObject.getRight()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_Prim0_Val0(EObject context, Val0 semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.VAL0__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.VAL0__NAME));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getPrim0Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName(), -1, (ILeafNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.VAL0__NAME, semanticObject.getName()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_Prim1_Val1(EObject context, Val1 semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.VAL1__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.VAL1__NAME));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getPrim1Access().getNameIDTerminalRuleCall_0_1_0(), semanticObject.getName(), -1, (ILeafNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.VAL1__NAME, semanticObject.getName()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_Prim2_Val2(EObject context, Val2 semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.VAL2__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.VAL2__NAME));
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		acceptAssignedTerminal(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.getPrim2Access().getNameIDTerminalRuleCall_0_1_0(), semanticObject.getName(), -1, (ILeafNode)nodes.getNodeForSingelValue(SyntacticsequencertestPackage.Literals.VAL2__NAME, semanticObject.getName()));
		acceptFinish(sequenceAcceptor);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name=TerminalID | name=ID)
	 *         ref1=[SingleCrossReference|TerminalID]?
	 *         ref2=[SingleCrossReference|DatatypeID]?
	 *         ref3=[SingleCrossReference|ID]?
	 *         ref4=[SingleCrossReference|ID]?
	 *     )
	 *     
	 *
	 * Features:
	 *    name[0, 2]
	 *    ref1[0, 1]
	 *    ref2[0, 1]
	 *    ref3[0, 1]
	 *    ref4[0, 1]
	 */
	protected void sequence_SingleCrossReference_SingleCrossReference(EObject context, SingleCrossReference semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		genericSequencer.createSequence(context, semanticObject, sequenceAcceptor, errorAcceptor);
	}
}
