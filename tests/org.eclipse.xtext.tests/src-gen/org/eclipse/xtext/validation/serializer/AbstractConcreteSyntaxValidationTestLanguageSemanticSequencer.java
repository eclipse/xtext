package org.eclipse.xtext.validation.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.validation.csvalidationtest.AltList1;
import org.eclipse.xtext.validation.csvalidationtest.AltList2;
import org.eclipse.xtext.validation.csvalidationtest.AlternativeMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.AssignedAction;
import org.eclipse.xtext.validation.csvalidationtest.Combination1;
import org.eclipse.xtext.validation.csvalidationtest.Combination2;
import org.eclipse.xtext.validation.csvalidationtest.Combination3;
import org.eclipse.xtext.validation.csvalidationtest.Combination4;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;
import org.eclipse.xtext.validation.csvalidationtest.EmptyAlternativeSub;
import org.eclipse.xtext.validation.csvalidationtest.GroupMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.Heuristic1;
import org.eclipse.xtext.validation.csvalidationtest.List1;
import org.eclipse.xtext.validation.csvalidationtest.List2;
import org.eclipse.xtext.validation.csvalidationtest.List3;
import org.eclipse.xtext.validation.csvalidationtest.List4;
import org.eclipse.xtext.validation.csvalidationtest.List5;
import org.eclipse.xtext.validation.csvalidationtest.Model;
import org.eclipse.xtext.validation.csvalidationtest.SimpleAlternative;
import org.eclipse.xtext.validation.csvalidationtest.SimpleGroup;
import org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.StaticSimplification;
import org.eclipse.xtext.validation.csvalidationtest.TransientObject;
import org.eclipse.xtext.validation.csvalidationtest.TransientObjectSub;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1;
import org.eclipse.xtext.validation.csvalidationtest.TwoVersion;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub2;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2SubAction;
import org.eclipse.xtext.validation.services.ConcreteSyntaxValidationTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractConcreteSyntaxValidationTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CsvalidationtestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CsvalidationtestPackage.ALT_LIST1:
				if(context == grammarAccess.getAltList1Rule()) {
					sequence_AltList1(context, (AltList1) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.ALT_LIST2:
				if(context == grammarAccess.getAltList2Rule()) {
					sequence_AltList2(context, (AltList2) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.ALTERNATIVE_MULTIPLICITIES:
				if(context == grammarAccess.getAlternativeMultiplicitiesRule()) {
					sequence_AlternativeMultiplicities(context, (AlternativeMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.ASSIGNED_ACTION:
				if(context == grammarAccess.getAssignedActionSecondRule()) {
					sequence_AssignedActionSecond(context, (AssignedAction) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAssignedActionRule()) {
					sequence_AssignedAction(context, (AssignedAction) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAssignedActionAccess().getAssignedActionChildAction_2_0()) {
					sequence_AssignedAction_AssignedAction_2_0(context, (AssignedAction) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.COMBINATION1:
				if(context == grammarAccess.getCombination1Rule()) {
					sequence_Combination1(context, (Combination1) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.COMBINATION2:
				if(context == grammarAccess.getCombination2Rule()) {
					sequence_Combination2(context, (Combination2) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.COMBINATION3:
				if(context == grammarAccess.getCombination3Rule()) {
					sequence_Combination3(context, (Combination3) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.COMBINATION4:
				if(context == grammarAccess.getCombination4Rule()) {
					sequence_Combination4(context, (Combination4) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.EMPTY_ALTERNATIVE_SUB:
				if(context == grammarAccess.getStaticSimplificationRule()) {
					sequence_StaticSimplification(context, (EmptyAlternativeSub) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.GROUP_MULTIPLICITIES:
				if(context == grammarAccess.getGroupMultiplicitiesRule()) {
					sequence_GroupMultiplicities(context, (GroupMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.HEURISTIC1:
				if(context == grammarAccess.getHeuristic1Rule()) {
					sequence_Heuristic1(context, (Heuristic1) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.LIST1:
				if(context == grammarAccess.getList1Rule()) {
					sequence_List1(context, (List1) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.LIST2:
				if(context == grammarAccess.getList2Rule()) {
					sequence_List2(context, (List2) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.LIST3:
				if(context == grammarAccess.getList3Rule()) {
					sequence_List3(context, (List3) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.LIST4:
				if(context == grammarAccess.getList4Rule()) {
					sequence_List4(context, (List4) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.LIST5:
				if(context == grammarAccess.getList5Rule()) {
					sequence_List5(context, (List5) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.SIMPLE_ALTERNATIVE:
				if(context == grammarAccess.getSimpleAlternativeRule()) {
					sequence_SimpleAlternative(context, (SimpleAlternative) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.SIMPLE_GROUP:
				if(context == grammarAccess.getSimpleGroupRule()) {
					sequence_SimpleGroup(context, (SimpleGroup) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.SIMPLE_MULTIPLICITIES:
				if(context == grammarAccess.getSimpleMultiplicitiesRule()) {
					sequence_SimpleMultiplicities(context, (SimpleMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.STATIC_SIMPLIFICATION:
				if(context == grammarAccess.getStaticSimplificationRule()) {
					sequence_StaticSimplification(context, (StaticSimplification) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.TRANSIENT_OBJECT:
				if(context == grammarAccess.getTransientObjectRule()) {
					sequence_TransientObject(context, (TransientObject) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.TRANSIENT_OBJECT_SUB:
				if(context == grammarAccess.getTransientObjectSubRule()) {
					sequence_TransientObjectSub(context, (TransientObjectSub) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1:
				if(context == grammarAccess.getTransientSerializeables1Rule()) {
					sequence_TransientSerializeables1(context, (TransientSerializeables1) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.TWO_VERSION:
				if(context == grammarAccess.getTwoVersionNo1Rule()) {
					sequence_TwoVersionNo1(context, (TwoVersion) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTwoVersionNo2Rule()) {
					sequence_TwoVersionNo2(context, (TwoVersion) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTwoVersionRule()) {
					sequence_TwoVersion(context, (TwoVersion) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.UNASSIGNED_ACTION1:
				if(context == grammarAccess.getUnassignedAction1Rule()) {
					sequence_UnassignedAction1(context, (UnassignedAction1) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB:
				if(context == grammarAccess.getUnassignedAction2Rule()) {
					sequence_UnassignedAction2(context, (UnassignedAction2Sub) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB1:
				if(context == grammarAccess.getUnassignedAction3Rule()) {
					sequence_UnassignedAction3(context, (UnassignedAction2Sub1) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB2:
				if(context == grammarAccess.getUnassignedAction3Rule()) {
					sequence_UnassignedAction3(context, (UnassignedAction2Sub2) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.UNASSIGNED_RULE_CALL1_SUB:
				if(context == grammarAccess.getUnassignedRuleCall1SubRule()) {
					sequence_UnassignedRuleCall1Sub(context, (UnassignedRuleCall1Sub) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnassignedRuleCall1Rule()) {
					sequence_UnassignedRuleCall1(context, (UnassignedRuleCall1Sub) semanticObject); 
					return; 
				}
				else break;
			case CsvalidationtestPackage.UNASSIGNED_RULE_CALL2_SUB_ACTION:
				if(context == grammarAccess.getUnassignedRuleCall2SubRule()) {
					sequence_UnassignedRuleCall2Sub(context, (UnassignedRuleCall2SubAction) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnassignedRuleCall2Rule()) {
					sequence_UnassignedRuleCall2(context, (UnassignedRuleCall2SubAction) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     ((val1=ID val2=ID) | (val1=ID val3=ID) | (val1=ID val4=ID?))
	 *
	 * Features:
	 *    val1[0, 3]
	 *    val2[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val3
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val4
	 *    val3[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val2
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val4
	 *    val4[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val2
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val3
	 */
	protected void sequence_AltList1(EObject context, AltList1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val1+=ID val2=ID) | (val1+=ID val1+=ID* val3=ID))
	 *
	 * Features:
	 *    val1[0, *]
	 *    val2[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val3
	 *    val3[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val2
	 */
	protected void sequence_AltList2(EObject context, AltList2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val2=ID | val3=ID)? (val4+=ID | val5+=ID)+ (val6+=ID | val7+=ID)*)
	 *
	 * Features:
	 *    val2[0, 1]
	 *         EXCLUDE_IF_SET val3
	 *    val3[0, 1]
	 *         EXCLUDE_IF_SET val2
	 *    val4[0, *]
	 *    val5[0, *]
	 *    val6[0, *]
	 *    val7[0, *]
	 */
	protected void sequence_AlternativeMultiplicities(EObject context, AlternativeMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[1, 1]
	 */
	protected void sequence_AssignedActionSecond(EObject context, AssignedAction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (child=AssignedAction_AssignedAction_2_0 val1=ID)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    child[1, 1]
	 */
	protected void sequence_AssignedAction(EObject context, AssignedAction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((child=AssignedAction_AssignedAction_2_0 val1=ID) | val1=ID)
	 *
	 * Features:
	 *    val1[0, 2]
	 *    child[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 */
	protected void sequence_AssignedAction_AssignedAction_2_0(EObject context, AssignedAction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID (val2=ID (val3=ID | val4=ID))?)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[0, 1]
	 *         MANDATORY_IF_SET val3
	 *         MANDATORY_IF_SET val4
	 *    val3[0, 1]
	 *         EXCLUDE_IF_SET val4
	 *         EXCLUDE_IF_UNSET val2
	 *    val4[0, 1]
	 *         EXCLUDE_IF_SET val3
	 *         EXCLUDE_IF_UNSET val2
	 */
	protected void sequence_Combination1(EObject context, Combination1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID (val2=ID | (val3+=ID val4+=ID)*))
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[0, 1]
	 *         EXCLUDE_IF_SET val3
	 *         EXCLUDE_IF_SET val4
	 *    val3[0, *]
	 *         SAME val4
	 *         EXCLUDE_IF_SET val2
	 *    val4[0, *]
	 *         SAME val3
	 *         EXCLUDE_IF_SET val2
	 */
	protected void sequence_Combination2(EObject context, Combination2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID | val2=INT | val3=STRING)*
	 *
	 * Features:
	 *    val1[0, *]
	 *    val2[0, *]
	 *    val3[0, *]
	 */
	protected void sequence_Combination3(EObject context, Combination3 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1+=ID val2+=ID val3+=ID)+
	 *
	 * Features:
	 *    val1[1, *]
	 *         SAME val2
	 *         SAME val3
	 *    val2[1, *]
	 *         SAME val1
	 *         SAME val3
	 *    val3[1, *]
	 *         SAME val1
	 *         SAME val2
	 */
	protected void sequence_Combination4(EObject context, Combination4 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID (val2=ID val3=ID)? (val4+=ID val5+=ID)+ (val6+=ID val7+=ID)*)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[0, 1]
	 *         EXCLUDE_IF_UNSET val3
	 *         MANDATORY_IF_SET val3
	 *    val3[0, 1]
	 *         EXCLUDE_IF_UNSET val2
	 *         MANDATORY_IF_SET val2
	 *    val4[1, *]
	 *         SAME val5
	 *    val5[1, *]
	 *         SAME val4
	 *    val6[0, *]
	 *         SAME val7
	 *    val7[0, *]
	 *         SAME val6
	 */
	protected void sequence_GroupMultiplicities(EObject context, GroupMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((a+=ID b+=ID)* (a+=ID c+=ID)* (b+=ID c+=ID)*)
	 *
	 * Features:
	 *    a[0, *]
	 *    b[0, *]
	 *    c[0, *]
	 */
	protected void sequence_Heuristic1(EObject context, Heuristic1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1+=ID val1+=ID*)
	 *
	 * Features:
	 *    val1[1, *]
	 */
	protected void sequence_List1(EObject context, List1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1+=ID val1+=ID*)?
	 *
	 * Features:
	 *    val1[0, *]
	 */
	protected void sequence_List2(EObject context, List2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val1+=ID val1+=ID*) | val2=ID)
	 *
	 * Features:
	 *    val1[0, *]
	 *         EXCLUDE_IF_SET val2
	 *    val2[0, 1]
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 */
	protected void sequence_List3(EObject context, List3 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1+=ID val1+=ID* val2=ID)
	 *
	 * Features:
	 *    val1[1, *]
	 *    val2[1, 1]
	 */
	protected void sequence_List4(EObject context, List4 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val1+=ID val1+=ID* val2=ID) | val3=ID)
	 *
	 * Features:
	 *    val1[0, *]
	 *         EXCLUDE_IF_UNSET val2
	 *         EXCLUDE_IF_SET val3
	 *    val2[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val3
	 *    val3[0, 1]
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val2
	 */
	protected void sequence_List5(EObject context, List5 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         x1=SimpleGroup | 
	 *         x2=SimpleAlternative | 
	 *         x3=SimpleMultiplicities | 
	 *         x4=GroupMultiplicities | 
	 *         x5=AlternativeMultiplicities | 
	 *         x6=AssignedAction | 
	 *         x7=AssignedActionSecond | 
	 *         x8=UnassignedAction1 | 
	 *         x9=UnassignedAction2 | 
	 *         x10=UnassignedAction3 | 
	 *         x11=UnassignedRuleCall1 | 
	 *         x12=UnassignedRuleCall2 | 
	 *         x13=Combination1 | 
	 *         x14=Combination2 | 
	 *         x15=Combination3 | 
	 *         x16=Combination4 | 
	 *         x17=List1 | 
	 *         x18=List2 | 
	 *         x19=List3 | 
	 *         x20=List4 | 
	 *         x21=List5 | 
	 *         x22=AltList1 | 
	 *         x23=AltList2 | 
	 *         x24=TransientObject | 
	 *         x25=TransientSerializeables1 | 
	 *         x26=StaticSimplification | 
	 *         x27=TwoVersion | 
	 *         x28=Heuristic1
	 *     )
	 *
	 * Features:
	 *    x1[0, 1]
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x2[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x3[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x4[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x5[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x6[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x7[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x8[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x9[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x10[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x11[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x12[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x13[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x14[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x15[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x16[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x17[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x18[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x19[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x20[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x21[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x22[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x23[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x24[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x25[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x26[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x27
	 *         EXCLUDE_IF_SET x28
	 *    x27[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x28
	 *    x28[0, 1]
	 *         EXCLUDE_IF_SET x1
	 *         EXCLUDE_IF_SET x2
	 *         EXCLUDE_IF_SET x3
	 *         EXCLUDE_IF_SET x4
	 *         EXCLUDE_IF_SET x5
	 *         EXCLUDE_IF_SET x6
	 *         EXCLUDE_IF_SET x7
	 *         EXCLUDE_IF_SET x8
	 *         EXCLUDE_IF_SET x9
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x16
	 *         EXCLUDE_IF_SET x17
	 *         EXCLUDE_IF_SET x18
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *         EXCLUDE_IF_SET x23
	 *         EXCLUDE_IF_SET x24
	 *         EXCLUDE_IF_SET x25
	 *         EXCLUDE_IF_SET x26
	 *         EXCLUDE_IF_SET x27
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID | val2=ID)
	 *
	 * Features:
	 *    val1[0, 1]
	 *         EXCLUDE_IF_SET val2
	 *    val2[0, 1]
	 *         EXCLUDE_IF_SET val1
	 */
	protected void sequence_SimpleAlternative(EObject context, SimpleAlternative semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[1, 1]
	 */
	protected void sequence_SimpleGroup(EObject context, SimpleGroup semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.SIMPLE_GROUP__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.SIMPLE_GROUP__VAL1));
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.SIMPLE_GROUP__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.SIMPLE_GROUP__VAL2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleGroupAccess().getVal1IDTerminalRuleCall_1_0(), semanticObject.getVal1());
		feeder.accept(grammarAccess.getSimpleGroupAccess().getVal2IDTerminalRuleCall_2_0(), semanticObject.getVal2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID? val3+=ID+ val4+=ID*)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[0, 1]
	 *    val3[1, *]
	 *    val4[0, *]
	 */
	protected void sequence_SimpleMultiplicities(EObject context, SimpleMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val2=ID? val3=ID*)
	 *
	 * Features:
	 *    val2[0, 1]
	 *    val3[0, *]
	 */
	protected void sequence_StaticSimplification(EObject context, EmptyAlternativeSub semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID? val2=ID? val3=ID*)
	 *
	 * Features:
	 *    val1[0, 1]
	 *    val2[0, 1]
	 *    val3[0, *]
	 */
	protected void sequence_StaticSimplification(EObject context, StaticSimplification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val2=ID val3=ID)
	 *
	 * Features:
	 *    val2[1, 1]
	 *    val3[1, 1]
	 */
	protected void sequence_TransientObjectSub(EObject context, TransientObjectSub semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.TRANSIENT_OBJECT_SUB__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.TRANSIENT_OBJECT_SUB__VAL2));
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.TRANSIENT_OBJECT_SUB__VAL3) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.TRANSIENT_OBJECT_SUB__VAL3));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTransientObjectSubAccess().getVal2IDTerminalRuleCall_0_0(), semanticObject.getVal2());
		feeder.accept(grammarAccess.getTransientObjectSubAccess().getVal3IDTerminalRuleCall_1_0(), semanticObject.getVal3());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID nested=TransientObjectSub)?
	 *
	 * Features:
	 *    val1[0, 1]
	 *         EXCLUDE_IF_UNSET nested
	 *         MANDATORY_IF_SET nested
	 *    nested[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 */
	protected void sequence_TransientObject(EObject context, TransientObject semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.TRANSIENT_OBJECT__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.TRANSIENT_OBJECT__VAL1));
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.TRANSIENT_OBJECT__NESTED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.TRANSIENT_OBJECT__NESTED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTransientObjectAccess().getVal1IDTerminalRuleCall_1_0_0(), semanticObject.getVal1());
		feeder.accept(grammarAccess.getTransientObjectAccess().getNestedTransientObjectSubParserRuleCall_1_1_0(), semanticObject.getNested());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((val1=ID enum1=TransientSerializeables1Enum)? (val2=ID int1=INT)?)
	 *
	 * Features:
	 *    val1[0, 1]
	 *         EXCLUDE_IF_UNSET enum1
	 *         MANDATORY_IF_SET enum1
	 *    enum1[0, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *    val2[0, 1]
	 *         EXCLUDE_IF_UNSET int1
	 *         MANDATORY_IF_SET int1
	 *    int1[0, 1]
	 *         EXCLUDE_IF_UNSET val2
	 *         MANDATORY_IF_SET val2
	 */
	protected void sequence_TransientSerializeables1(EObject context, TransientSerializeables1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (shared1=ID? shared2=ID (shared3+=ID shared3+=ID*)? version1=ID?)
	 *
	 * Features:
	 *    shared1[0, 1]
	 *    shared2[1, 1]
	 *    shared3[0, *]
	 *    version1[0, 1]
	 */
	protected void sequence_TwoVersionNo1(EObject context, TwoVersion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (shared1=ID? shared2=ID (shared3+=ID shared3+=ID*)? extra1=ID? ((extra2=ID extra3=ID) | extra4=ID)?)
	 *
	 * Features:
	 *    shared1[0, 1]
	 *    shared2[1, 1]
	 *    shared3[0, *]
	 *    extra1[0, 1]
	 *    extra2[0, 1]
	 *         EXCLUDE_IF_UNSET extra3
	 *         MANDATORY_IF_SET extra3
	 *         EXCLUDE_IF_SET extra4
	 *    extra3[0, 1]
	 *         EXCLUDE_IF_UNSET extra2
	 *         MANDATORY_IF_SET extra2
	 *         EXCLUDE_IF_SET extra4
	 *    extra4[0, 1]
	 *         EXCLUDE_IF_SET extra2
	 *         EXCLUDE_IF_SET extra3
	 */
	protected void sequence_TwoVersionNo2(EObject context, TwoVersion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (shared1=ID? shared2=ID (shared3+=ID shared3+=ID*)? version1=ID?) | 
	 *         (shared1=ID? shared2=ID (shared3+=ID shared3+=ID*)? extra1=ID? ((extra2=ID extra3=ID) | extra4=ID)?)
	 *     )
	 *
	 * Features:
	 *    shared1[0, 2]
	 *    shared2[0, 2]
	 *    shared3[0, *]
	 *    version1[0, 1]
	 *         EXCLUDE_IF_UNSET shared2
	 *         EXCLUDE_IF_SET shared1
	 *         EXCLUDE_IF_SET shared2
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET extra1
	 *         EXCLUDE_IF_SET extra2
	 *         EXCLUDE_IF_SET extra3
	 *         EXCLUDE_IF_SET extra4
	 *    extra1[0, 1]
	 *         EXCLUDE_IF_UNSET shared2
	 *         EXCLUDE_IF_SET shared1
	 *         EXCLUDE_IF_SET shared2
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET version1
	 *    extra2[0, 1]
	 *         EXCLUDE_IF_UNSET extra3
	 *         MANDATORY_IF_SET extra3
	 *         EXCLUDE_IF_SET extra4
	 *         EXCLUDE_IF_UNSET shared2
	 *         EXCLUDE_IF_SET shared1
	 *         EXCLUDE_IF_SET shared2
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET version1
	 *    extra3[0, 1]
	 *         EXCLUDE_IF_UNSET extra2
	 *         MANDATORY_IF_SET extra2
	 *         EXCLUDE_IF_SET extra4
	 *         EXCLUDE_IF_UNSET shared2
	 *         EXCLUDE_IF_SET shared1
	 *         EXCLUDE_IF_SET shared2
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET version1
	 *    extra4[0, 1]
	 *         EXCLUDE_IF_SET extra2
	 *         EXCLUDE_IF_SET extra3
	 *         EXCLUDE_IF_UNSET shared2
	 *         EXCLUDE_IF_SET shared1
	 *         EXCLUDE_IF_SET shared2
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET shared3
	 *         EXCLUDE_IF_SET version1
	 */
	protected void sequence_TwoVersion(EObject context, TwoVersion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID?)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[0, 1]
	 */
	protected void sequence_UnassignedAction1(EObject context, UnassignedAction1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID?)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[0, 1]
	 */
	protected void sequence_UnassignedAction2(EObject context, UnassignedAction2Sub semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID?)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[0, 1]
	 */
	protected void sequence_UnassignedAction3(EObject context, UnassignedAction2Sub1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID?)
	 *
	 * Features:
	 *    val1[1, 1]
	 *    val2[0, 1]
	 */
	protected void sequence_UnassignedAction3(EObject context, UnassignedAction2Sub2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val1=ID
	 *
	 * Features:
	 *    val1[1, 1]
	 */
	protected void sequence_UnassignedRuleCall1Sub(EObject context, UnassignedRuleCall1Sub semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID)
	 *
	 * Features:
	 *    val2[1, 1]
	 *    val1[1, 1]
	 */
	protected void sequence_UnassignedRuleCall1(EObject context, UnassignedRuleCall1Sub semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.UNASSIGNED_RULE_CALL1_SUB__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.UNASSIGNED_RULE_CALL1_SUB__VAL2));
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.UNASSIGNED_RULE_CALL1_SUB__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.UNASSIGNED_RULE_CALL1_SUB__VAL1));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnassignedRuleCall1SubAccess().getVal1IDTerminalRuleCall_0(), semanticObject.getVal1());
		feeder.accept(grammarAccess.getUnassignedRuleCall1Access().getVal2IDTerminalRuleCall_2_0(), semanticObject.getVal2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {UnassignedRuleCall2SubAction}
	 *
	 * Features:
	 */
	protected void sequence_UnassignedRuleCall2Sub(EObject context, UnassignedRuleCall2SubAction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val2=ID
	 *
	 * Features:
	 *    val2[1, 1]
	 */
	protected void sequence_UnassignedRuleCall2(EObject context, UnassignedRuleCall2SubAction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CsvalidationtestPackage.Literals.UNASSIGNED_RULE_CALL2_SUB__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvalidationtestPackage.Literals.UNASSIGNED_RULE_CALL2_SUB__VAL2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnassignedRuleCall2Access().getVal2IDTerminalRuleCall_2_0(), semanticObject.getVal2());
		feeder.finish();
	}
}
