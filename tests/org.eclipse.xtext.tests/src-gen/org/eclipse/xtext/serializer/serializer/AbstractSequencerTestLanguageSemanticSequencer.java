package org.eclipse.xtext.serializer.serializer;

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
import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.AltList2;
import org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywords;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.MultiTerminals;
import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.SimpleAlternative;
import org.eclipse.xtext.serializer.sequencertest.SimpleGroup;
import org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild1;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild2;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild3;
import org.eclipse.xtext.serializer.sequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.sequencertest.SingleEnum;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywords;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.SingleTerminals;
import org.eclipse.xtext.serializer.services.SequencerTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractSequencerTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected SequencerTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == SequencertestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SequencertestPackage.ALT_LIST1:
				if(context == grammarAccess.getAltList1Rule()) {
					sequence_AltList1_AltList1(context, (AltList1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.ALT_LIST2:
				if(context == grammarAccess.getAltList2Rule()) {
					sequence_AltList2_AltList2(context, (AltList2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.ALTERNATIVE_MULTIPLICITIES:
				if(context == grammarAccess.getAlternativeMultiplicitiesRule()) {
					sequence_AlternativeMultiplicities_AlternativeMultiplicities(context, (AlternativeMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.DEPENDENT_ALTERNATIVE1:
				if(context == grammarAccess.getDependentAlternative1Rule()) {
					sequence_DependentAlternative1_DependentAlternative1(context, (DependentAlternative1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.DEPENDENT_ALTERNATIVE2:
				if(context == grammarAccess.getDependentAlternative2Rule()) {
					sequence_DependentAlternative2_DependentAlternative2(context, (DependentAlternative2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.FLOAT:
				if(context == grammarAccess.getFloatRule()) {
					sequence_Float_Float(context, (org.eclipse.xtext.serializer.sequencertest.Float) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.GROUP_MULTIPLICITIES:
				if(context == grammarAccess.getGroupMultiplicitiesRule()) {
					sequence_GroupMultiplicities_GroupMultiplicities(context, (GroupMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.LIST1:
				if(context == grammarAccess.getList1Rule()) {
					sequence_List1_List1(context, (List1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.LIST2:
				if(context == grammarAccess.getList2Rule()) {
					sequence_List2_List2(context, (List2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.MULTI_KEYWORDS:
				if(context == grammarAccess.getMultiKeywordsRule()) {
					sequence_MultiKeywords_MultiKeywords(context, (MultiKeywords) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.MULTI_KEYWORDS_OR_ID:
				if(context == grammarAccess.getMultiKeywordsOrIDRule()) {
					sequence_MultiKeywordsOrID_MultiKeywordsOrID(context, (MultiKeywordsOrID) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.MULTI_TERMINALS:
				if(context == grammarAccess.getMultiTerminalsRule()) {
					sequence_MultiTerminals_MultiTerminals(context, (MultiTerminals) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.OPTIONAL:
				if(context == grammarAccess.getOptionalRule()) {
					sequence_Optional_Optional(context, (Optional) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SIMPLE_ALTERNATIVE:
				if(context == grammarAccess.getSimpleAlternativeRule()) {
					sequence_SimpleAlternative_SimpleAlternative(context, (SimpleAlternative) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SIMPLE_GROUP:
				if(context == grammarAccess.getSimpleGroupRule()) {
					sequence_SimpleGroup_SimpleGroup(context, (SimpleGroup) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SIMPLE_MULTIPLICITIES:
				if(context == grammarAccess.getSimpleMultiplicitiesRule()) {
					sequence_SimpleMultiplicities_SimpleMultiplicities(context, (SimpleMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE:
				if(context == grammarAccess.getSingleContainmentReferenceRule()) {
					sequence_SingleContainmentReference_SingleContainmentReference(context, (SingleContainmentReference) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD1:
				if(context == grammarAccess.getSingleContainmentReferenceChild1Rule()) {
					sequence_SingleContainmentReferenceChild1_SingleContainmentReferenceChild1(context, (SingleContainmentReferenceChild1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD2:
				if(context == grammarAccess.getSingleContainmentReferenceChild2Rule()) {
					sequence_SingleContainmentReferenceChild2_SingleContainmentReferenceChild2(context, (SingleContainmentReferenceChild2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD3:
				if(context == grammarAccess.getSingleContainmentReferenceChild3Rule()) {
					sequence_SingleContainmentReferenceChild3_SingleContainmentReferenceChild3(context, (SingleContainmentReferenceChild3) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CROSS_REFERENCE:
				if(context == grammarAccess.getSingleCrossReferenceRule()) {
					sequence_SingleCrossReference_SingleCrossReference(context, (SingleCrossReference) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_ENUM:
				if(context == grammarAccess.getSingleEnumRule()) {
					sequence_SingleEnum_SingleEnum(context, (SingleEnum) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_KEYWORDS:
				if(context == grammarAccess.getSingleKeywordsRule()) {
					sequence_SingleKeywords_SingleKeywords(context, (SingleKeywords) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_KEYWORDS_OR_ID:
				if(context == grammarAccess.getSingleKeywordsOrIDRule()) {
					sequence_SingleKeywordsOrID_SingleKeywordsOrID(context, (SingleKeywordsOrID) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_TERMINALS:
				if(context == grammarAccess.getSingleTerminalsRule()) {
					sequence_SingleTerminals_SingleTerminals(context, (SingleTerminals) semanticObject); 
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
	 *    val1[3, 3]
	 *    val2[1, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val3
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val4
	 *    val3[1, 1]
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
	protected void sequence_AltList1_AltList1(EObject context, AltList1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val1+=ID val2=ID) | (val1+=ID val1+=ID* val3=ID))
	 *
	 * Features:
	 *    val1[2, *]
	 *    val2[1, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val3
	 *    val3[1, 1]
	 *         EXCLUDE_IF_UNSET val1
	 *         MANDATORY_IF_SET val1
	 *         MANDATORY_IF_SET val1
	 *         EXCLUDE_IF_SET val1
	 *         EXCLUDE_IF_SET val2
	 */
	protected void sequence_AltList2_AltList2(EObject context, AltList2 semanticObject) {
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
	protected void sequence_AlternativeMultiplicities_AlternativeMultiplicities(EObject context, AlternativeMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val=ID | (val=ID flag?='kw1'))
	 *
	 * Features:
	 *    val[1, 2]
	 *    flag[1, 1]
	 *         EXCLUDE_IF_UNSET val
	 *         MANDATORY_IF_SET val
	 *         EXCLUDE_IF_SET val
	 */
	protected void sequence_DependentAlternative1_DependentAlternative1(EObject context, DependentAlternative1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val+=ID val+=ID+) | (val+=ID+ flag?='kw1'))
	 *
	 * Features:
	 *    val[3, *]
	 *    flag[1, 1]
	 *         EXCLUDE_IF_UNSET val
	 *         MANDATORY_IF_SET val
	 *         EXCLUDE_IF_SET val
	 *         EXCLUDE_IF_SET val
	 */
	protected void sequence_DependentAlternative2_DependentAlternative2(EObject context, DependentAlternative2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Float}
	 *
	 * Features:
	 */
	protected void sequence_Float_Float(EObject context, org.eclipse.xtext.serializer.sequencertest.Float semanticObject) {
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
	protected void sequence_GroupMultiplicities_GroupMultiplicities(EObject context, GroupMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1+=ID val1+=ID*)
	 *
	 * Features:
	 *    val1[1, *]
	 */
	protected void sequence_List1_List1(EObject context, List1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val1+=ID val1+=ID*)?)
	 *
	 * Features:
	 *    val1[0, *]
	 */
	protected void sequence_List2_List2(EObject context, List2 semanticObject) {
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
	 *         x6=List1 | 
	 *         x7=List2 | 
	 *         x8=AltList1 | 
	 *         x9=AltList2 | 
	 *         x10=SingleKeywords | 
	 *         x11=SingleKeywordsOrID | 
	 *         x12=SingleTerminals | 
	 *         x10=MultiKeywords | 
	 *         x11=MultiKeywordsOrID | 
	 *         x12=MultiTerminals | 
	 *         x13=SingleEnum | 
	 *         x14=SingleCrossReference | 
	 *         x15=SingleContainmentReference | 
	 *         x19=DependentAlternative1 | 
	 *         x20=DependentAlternative2 | 
	 *         x21=Optional | 
	 *         x22=Float
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *    x10[0, 2]
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
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *    x11[0, 2]
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
	 *    x12[0, 2]
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x21
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x22
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
	 *         EXCLUDE_IF_SET x10
	 *         EXCLUDE_IF_SET x11
	 *         EXCLUDE_IF_SET x12
	 *         EXCLUDE_IF_SET x13
	 *         EXCLUDE_IF_SET x14
	 *         EXCLUDE_IF_SET x15
	 *         EXCLUDE_IF_SET x19
	 *         EXCLUDE_IF_SET x20
	 *         EXCLUDE_IF_SET x21
	 */
	protected void sequence_Model_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val+='kw1' | val+='kw2' | val+='kw3' | val+=ID)
	 *
	 * Features:
	 *    val[0, 4]
	 */
	protected void sequence_MultiKeywordsOrID_MultiKeywordsOrID(EObject context, MultiKeywordsOrID semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val+='kw1' | val+='kw2' | val+='kw3')
	 *
	 * Features:
	 *    val[0, 3]
	 */
	protected void sequence_MultiKeywords_MultiKeywords(EObject context, MultiKeywords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val+=ID1 | val+=ID2)
	 *
	 * Features:
	 *    val[0, 2]
	 */
	protected void sequence_MultiTerminals_MultiTerminals(EObject context, MultiTerminals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (int0=INT (int1=INT int2=INT)?)
	 *
	 * Features:
	 *    int0[1, 1]
	 *    int1[0, 1]
	 *         EXCLUDE_IF_UNSET int2
	 *         MANDATORY_IF_SET int2
	 *    int2[0, 1]
	 *         EXCLUDE_IF_UNSET int1
	 *         MANDATORY_IF_SET int1
	 */
	protected void sequence_Optional_Optional(EObject context, Optional semanticObject) {
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
	protected void sequence_SimpleAlternative_SimpleAlternative(EObject context, SimpleAlternative semanticObject) {
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
	protected void sequence_SimpleGroup_SimpleGroup(EObject context, SimpleGroup semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SIMPLE_GROUP__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SIMPLE_GROUP__VAL1));
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SIMPLE_GROUP__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SIMPLE_GROUP__VAL2));
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
	protected void sequence_SimpleMultiplicities_SimpleMultiplicities(EObject context, SimpleMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val='kw1'
	 *
	 * Features:
	 *    val[1, 1]
	 */
	protected void sequence_SingleContainmentReferenceChild1_SingleContainmentReferenceChild1(EObject context, SingleContainmentReferenceChild1 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD1__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD1__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSingleContainmentReferenceChild1Access().getValKw1Keyword_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val='kw2'
	 *
	 * Features:
	 *    val[1, 1]
	 */
	protected void sequence_SingleContainmentReferenceChild2_SingleContainmentReferenceChild2(EObject context, SingleContainmentReferenceChild2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD2__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD2__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSingleContainmentReferenceChild2Access().getValKw2Keyword_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val='kw3'
	 *
	 * Features:
	 *    val[1, 1]
	 */
	protected void sequence_SingleContainmentReferenceChild3_SingleContainmentReferenceChild3(EObject context, SingleContainmentReferenceChild3 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD3__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD3__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSingleContainmentReferenceChild3Access().getValKw3Keyword_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (child=SingleContainmentReferenceChild1 | child=SingleContainmentReferenceChild2 | child=SingleContainmentReferenceChild3)
	 *
	 * Features:
	 *    child[0, 3]
	 */
	protected void sequence_SingleContainmentReference_SingleContainmentReference(EObject context, SingleContainmentReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ID1 | name=ID2 | name=ID3) (ref=[SingleCrossReference|ID1] | ref=[SingleCrossReference|ID2] | ref=[SingleCrossReference|ID3]))
	 *
	 * Features:
	 *    name[0, 3]
	 *    ref[0, 3]
	 */
	protected void sequence_SingleCrossReference_SingleCrossReference(EObject context, SingleCrossReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val=DefEnum1 | val=DefEnum2 | val=DefEnum3)
	 *
	 * Features:
	 *    val[0, 3]
	 */
	protected void sequence_SingleEnum_SingleEnum(EObject context, SingleEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val='kw1' | val='kw2' | val='kw3' | val=ID)
	 *
	 * Features:
	 *    val[0, 4]
	 */
	protected void sequence_SingleKeywordsOrID_SingleKeywordsOrID(EObject context, SingleKeywordsOrID semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val='kw1' | val='kw2' | val='kw3')
	 *
	 * Features:
	 *    val[0, 3]
	 */
	protected void sequence_SingleKeywords_SingleKeywords(EObject context, SingleKeywords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val=ID1 | val=ID2)
	 *
	 * Features:
	 *    val[0, 2]
	 */
	protected void sequence_SingleTerminals_SingleTerminals(EObject context, SingleTerminals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
