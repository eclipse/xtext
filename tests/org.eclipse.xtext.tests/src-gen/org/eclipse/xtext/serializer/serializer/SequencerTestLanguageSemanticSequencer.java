package org.eclipse.xtext.serializer.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.AltList2;
import org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.Complex1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywords;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.MultiTerminals;
import org.eclipse.xtext.serializer.sequencertest.NullCrossRef;
import org.eclipse.xtext.serializer.sequencertest.NullValue;
import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.OptionalDouble;
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
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal2;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroup;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupBoolean;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupOptional;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal2;
import org.eclipse.xtext.serializer.services.SequencerTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class SequencerTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private SequencerTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == SequencertestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SequencertestPackage.ALT_LIST1:
				if(context == grammarAccess.getAltList1Rule()) {
					sequence_AltList1(context, (AltList1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.ALT_LIST2:
				if(context == grammarAccess.getAltList2Rule()) {
					sequence_AltList2(context, (AltList2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.ALTERNATIVE_MULTIPLICITIES:
				if(context == grammarAccess.getAlternativeMultiplicitiesRule()) {
					sequence_AlternativeMultiplicities(context, (AlternativeMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.COMPLEX1:
				if(context == grammarAccess.getComplex1Rule()) {
					sequence_Complex1(context, (Complex1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.DEPENDENT_ALTERNATIVE1:
				if(context == grammarAccess.getDependentAlternative1Rule()) {
					sequence_DependentAlternative1(context, (DependentAlternative1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.DEPENDENT_ALTERNATIVE2:
				if(context == grammarAccess.getDependentAlternative2Rule()) {
					sequence_DependentAlternative2(context, (DependentAlternative2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.FLOAT:
				if(context == grammarAccess.getFloatRule()) {
					sequence_Float(context, (org.eclipse.xtext.serializer.sequencertest.Float) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.GROUP_MULTIPLICITIES:
				if(context == grammarAccess.getGroupMultiplicitiesRule()) {
					sequence_GroupMultiplicities(context, (GroupMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.LIST1:
				if(context == grammarAccess.getList1Rule()) {
					sequence_List1(context, (List1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.LIST2:
				if(context == grammarAccess.getList2Rule()) {
					sequence_List2(context, (List2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.MULTI_KEYWORDS:
				if(context == grammarAccess.getMultiKeywordsRule()) {
					sequence_MultiKeywords(context, (MultiKeywords) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.MULTI_KEYWORDS_OR_ID:
				if(context == grammarAccess.getMultiKeywordsOrIDRule()) {
					sequence_MultiKeywordsOrID(context, (MultiKeywordsOrID) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.MULTI_TERMINALS:
				if(context == grammarAccess.getMultiTerminalsRule()) {
					sequence_MultiTerminals(context, (MultiTerminals) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.NULL_CROSS_REF:
				if(context == grammarAccess.getNullCrossRefGeneratedRule()) {
					sequence_NullCrossRefGenerated(context, (NullCrossRef) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNullCrossRefInterpretedRule()) {
					sequence_NullCrossRefInterpreted(context, (NullCrossRef) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.NULL_VALUE:
				if(context == grammarAccess.getNullValueGeneratedRule()) {
					sequence_NullValueGenerated(context, (NullValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNullValueInterpretedRule()) {
					sequence_NullValueInterpreted(context, (NullValue) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.OPTIONAL:
				if(context == grammarAccess.getOptionalRule()) {
					sequence_Optional(context, (Optional) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.OPTIONAL_DOUBLE:
				if(context == grammarAccess.getOptionalDoubleRule()) {
					sequence_OptionalDouble(context, (OptionalDouble) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SIMPLE_ALTERNATIVE:
				if(context == grammarAccess.getSimpleAlternativeRule()) {
					sequence_SimpleAlternative(context, (SimpleAlternative) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SIMPLE_GROUP:
				if(context == grammarAccess.getSimpleGroupRule()) {
					sequence_SimpleGroup(context, (SimpleGroup) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SIMPLE_MULTIPLICITIES:
				if(context == grammarAccess.getSimpleMultiplicitiesRule()) {
					sequence_SimpleMultiplicities(context, (SimpleMultiplicities) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE:
				if(context == grammarAccess.getSingleContainmentReferenceRule()) {
					sequence_SingleContainmentReference(context, (SingleContainmentReference) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD1:
				if(context == grammarAccess.getSingleContainmentReferenceChild1Rule()) {
					sequence_SingleContainmentReferenceChild1(context, (SingleContainmentReferenceChild1) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD2:
				if(context == grammarAccess.getSingleContainmentReferenceChild2Rule()) {
					sequence_SingleContainmentReferenceChild2(context, (SingleContainmentReferenceChild2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD3:
				if(context == grammarAccess.getSingleContainmentReferenceChild3Rule()) {
					sequence_SingleContainmentReferenceChild3(context, (SingleContainmentReferenceChild3) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_CROSS_REFERENCE:
				if(context == grammarAccess.getSingleCrossReferenceRule()) {
					sequence_SingleCrossReference(context, (SingleCrossReference) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_ENUM:
				if(context == grammarAccess.getSingleEnumRule()) {
					sequence_SingleEnum(context, (SingleEnum) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_KEYWORDS:
				if(context == grammarAccess.getSingleKeywordsRule()) {
					sequence_SingleKeywords(context, (SingleKeywords) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_KEYWORDS_OR_ID:
				if(context == grammarAccess.getSingleKeywordsOrIDRule()) {
					sequence_SingleKeywordsOrID(context, (SingleKeywordsOrID) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SINGLE_TERMINALS:
				if(context == grammarAccess.getSingleTerminalsRule()) {
					sequence_SingleTerminals(context, (SingleTerminals) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.UNORDERED_ALTERNATIVE:
				if(context == grammarAccess.getUnorderedAlternativeRule()) {
					sequence_UnorderedAlternative(context, (UnorderedAlternative) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL:
				if(context == grammarAccess.getUnorderedAlternativeValRule()) {
					sequence_UnorderedAlternativeVal(context, (UnorderedAlternativeVal) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL2:
				if(context == grammarAccess.getUnorderedAlternativeVal2Rule() ||
				   context == grammarAccess.getUnorderedAlternativeValDelegateRule()) {
					sequence_UnorderedAlternativeVal2(context, (UnorderedAlternativeVal2) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.UNORDERED_GROUP:
				if(context == grammarAccess.getUnorderedGroupRule()) {
					sequence_UnorderedGroup(context, (UnorderedGroup) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.UNORDERED_GROUP_BOOLEAN:
				if(context == grammarAccess.getUnorderedGroupBooleanRule()) {
					sequence_UnorderedGroupBoolean(context, (UnorderedGroupBoolean) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.UNORDERED_GROUP_OPTIONAL:
				if(context == grammarAccess.getUnorderedGroupOptionalRule()) {
					sequence_UnorderedGroupOptional(context, (UnorderedGroupOptional) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.UNORDERED_GROUP_VAL:
				if(context == grammarAccess.getUnorderedGroupValRule()) {
					sequence_UnorderedGroupVal(context, (UnorderedGroupVal) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.UNORDERED_GROUP_VAL2:
				if(context == grammarAccess.getUnorderedGroupVal2Rule() ||
				   context == grammarAccess.getUnorderedGroupValDelegateRule()) {
					sequence_UnorderedGroupVal2(context, (UnorderedGroupVal2) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     ((val1=ID val2=ID) | (val1=ID val3=ID) | (val1=ID val4=ID?))
	 */
	protected void sequence_AltList1(EObject context, AltList1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val1+=ID val2=ID) | (val1+=ID val1+=ID* val3=ID))
	 */
	protected void sequence_AltList2(EObject context, AltList2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val2=ID | val3=ID)? (val4+=ID | val5+=ID)+ (val6+=ID | val7+=ID)*)
	 */
	protected void sequence_AlternativeMultiplicities(EObject context, AlternativeMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID? val2=ID? (val3+=ID | val4+=ID | val5+=ID | val6+=ID)*)
	 */
	protected void sequence_Complex1(EObject context, Complex1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val=ID | (val=ID flag?='kw1'))
	 */
	protected void sequence_DependentAlternative1(EObject context, DependentAlternative1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val+=ID val+=ID+) | (val+=ID+ flag?='kw1'))
	 */
	protected void sequence_DependentAlternative2(EObject context, DependentAlternative2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Float}
	 */
	protected void sequence_Float(EObject context, org.eclipse.xtext.serializer.sequencertest.Float semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID (val2=ID val3=ID)? (val4+=ID val5+=ID)+ (val6+=ID val7+=ID)*)
	 */
	protected void sequence_GroupMultiplicities(EObject context, GroupMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1+=ID val1+=ID*)
	 */
	protected void sequence_List1(EObject context, List1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val1+=ID val1+=ID*)?)
	 */
	protected void sequence_List2(EObject context, List2 semanticObject) {
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
	 *         x22=Float | 
	 *         x23=UnorderedAlternative | 
	 *         x24=UnorderedGroup | 
	 *         x25=UnorderedGroupOptional | 
	 *         x26=UnorderedGroupBoolean | 
	 *         x27=Complex1 | 
	 *         x28=OptionalDouble | 
	 *         x29=NullValueGenerated | 
	 *         x30=NullValueInterpreted | 
	 *         x31=NullCrossRefGenerated | 
	 *         x32=NullCrossRefInterpreted
	 *     )
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val+='kw1' | val+='kw2' | val+='kw3' | val+=ID)
	 */
	protected void sequence_MultiKeywordsOrID(EObject context, MultiKeywordsOrID semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val+='kw1' | val+='kw2' | val+='kw3')
	 */
	protected void sequence_MultiKeywords(EObject context, MultiKeywords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val+=ID1 | val+=ID2)
	 */
	protected void sequence_MultiTerminals(EObject context, MultiTerminals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ref=[EObject|ID]
	 */
	protected void sequence_NullCrossRefGenerated(EObject context, NullCrossRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[EObject|ID] foo=ID?)
	 */
	protected void sequence_NullCrossRefInterpreted(EObject context, NullCrossRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=NULL_STRING
	 */
	protected void sequence_NullValueGenerated(EObject context, NullValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=NULL_STRING foo=ID?)
	 */
	protected void sequence_NullValueInterpreted(EObject context, NullValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (double0=DOUBLE (double1=DOUBLE double2=DOUBLE)?)
	 */
	protected void sequence_OptionalDouble(EObject context, OptionalDouble semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (int0=INT (int1=INT int2=INT)?)
	 */
	protected void sequence_Optional(EObject context, Optional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID | val2=ID)
	 */
	protected void sequence_SimpleAlternative(EObject context, SimpleAlternative semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID)
	 */
	protected void sequence_SimpleGroup(EObject context, SimpleGroup semanticObject) {
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
	 */
	protected void sequence_SimpleMultiplicities(EObject context, SimpleMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val='kw1'
	 */
	protected void sequence_SingleContainmentReferenceChild1(EObject context, SingleContainmentReferenceChild1 semanticObject) {
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
	 */
	protected void sequence_SingleContainmentReferenceChild2(EObject context, SingleContainmentReferenceChild2 semanticObject) {
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
	 */
	protected void sequence_SingleContainmentReferenceChild3(EObject context, SingleContainmentReferenceChild3 semanticObject) {
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
	 */
	protected void sequence_SingleContainmentReference(EObject context, SingleContainmentReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ID1 | name=ID2 | name=ID3) (ref=[SingleCrossReference|ID1] | ref=[SingleCrossReference|ID2] | ref=[SingleCrossReference|ID3]))
	 */
	protected void sequence_SingleCrossReference(EObject context, SingleCrossReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val=DefEnum1 | val=DefEnum2 | val=DefEnum3)
	 */
	protected void sequence_SingleEnum(EObject context, SingleEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val='kw1' | val='kw2' | val='kw3' | val=ID)
	 */
	protected void sequence_SingleKeywordsOrID(EObject context, SingleKeywordsOrID semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val='kw1' | val='kw2' | val='kw3')
	 */
	protected void sequence_SingleKeywords(EObject context, SingleKeywords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val=ID1 | val=ID2)
	 */
	protected void sequence_SingleTerminals(EObject context, SingleTerminals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_UnorderedAlternativeVal2(EObject context, UnorderedAlternativeVal2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.UNORDERED_ALTERNATIVE_VAL2__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.UNORDERED_ALTERNATIVE_VAL2__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnorderedAlternativeVal2Access().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_UnorderedAlternativeVal(EObject context, UnorderedAlternativeVal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.UNORDERED_ALTERNATIVE_VAL__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.UNORDERED_ALTERNATIVE_VAL__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnorderedAlternativeValAccess().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((val1+=ID | val2+=INT | val3+=UnorderedAlternativeVal | val4+=UnorderedAlternativeValDelegate)*)
	 */
	protected void sequence_UnorderedAlternative(EObject context, UnorderedAlternative semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1?='kw1'? val2?='kw2'? val3?='kw3'?)
	 */
	protected void sequence_UnorderedGroupBoolean(EObject context, UnorderedGroupBoolean semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID? va2=ID? val3=ID?)
	 */
	protected void sequence_UnorderedGroupOptional(EObject context, UnorderedGroupOptional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_UnorderedGroupVal2(EObject context, UnorderedGroupVal2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.UNORDERED_GROUP_VAL2__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.UNORDERED_GROUP_VAL2__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnorderedGroupVal2Access().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_UnorderedGroupVal(EObject context, UnorderedGroupVal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.UNORDERED_GROUP_VAL__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.UNORDERED_GROUP_VAL__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnorderedGroupValAccess().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=INT val3=UnorderedGroupVal val4=UnorderedGroupValDelegate)
	 */
	protected void sequence_UnorderedGroup(EObject context, UnorderedGroup semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
