package org.eclipse.xtext.parsetree.formatter.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enumeration;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnObj;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnRef;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Space;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubID;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubSub;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.WrappingDataTypeTest;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
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

@SuppressWarnings("restriction")
public class AbstractFormatterTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected FormatterTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == FormattertestlanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case FormattertestlanguagePackage.ASSIGN:
				if(context == grammarAccess.getAssignRule() ||
				   context == grammarAccess.getLineRule()) {
					sequence_Assign(context, (Assign) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.DATATYPES:
				if(context == grammarAccess.getDatatypesRule() ||
				   context == grammarAccess.getLineRule()) {
					sequence_Datatypes(context, (Datatypes) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.DECL:
				if(context == grammarAccess.getDeclRule() ||
				   context == grammarAccess.getLineRule()) {
					sequence_Decl(context, (Decl) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.ENUMERATION:
				if(context == grammarAccess.getEnumerationRule() ||
				   context == grammarAccess.getLineRule()) {
					sequence_Enumeration(context, (Enumeration) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.FQN_OBJ:
				if(context == grammarAccess.getFqnObjRule() ||
				   context == grammarAccess.getLineRule()) {
					sequence_FqnObj(context, (FqnObj) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.FQN_REF:
				if(context == grammarAccess.getFqnRefRule() ||
				   context == grammarAccess.getLineRule()) {
					sequence_FqnRef(context, (FqnRef) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.METH:
				if(context == grammarAccess.getLineRule() ||
				   context == grammarAccess.getMethRule()) {
					sequence_Meth(context, (Meth) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.PARAM:
				if(context == grammarAccess.getParamRule()) {
					sequence_Param(context, (Param) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.SPACE:
				if(context == grammarAccess.getLineRule() ||
				   context == grammarAccess.getSpaceRule()) {
					sequence_Space(context, (Space) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.SUPPRESSED_HIDDEN:
				if(context == grammarAccess.getLineRule() ||
				   context == grammarAccess.getSuppressedHiddenRule()) {
					sequence_SuppressedHidden(context, (SuppressedHidden) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.SUPPRESSED_HIDDEN_SUB_ID:
				if(context == grammarAccess.getSuppressedHiddenSubRule() ||
				   context == grammarAccess.getSuppressedHiddenSubIDRule()) {
					sequence_SuppressedHiddenSubID(context, (SuppressedHiddenSubID) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.SUPPRESSED_HIDDEN_SUB_SUB:
				if(context == grammarAccess.getSuppressedHiddenSubRule() ||
				   context == grammarAccess.getSuppressedHiddenSubSubRule()) {
					sequence_SuppressedHiddenSubSub(context, (SuppressedHiddenSubSub) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.TEST_INDENTATION:
				if(context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getTestIndentationRule()) {
					sequence_TestIndentation(context, (TestIndentation) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.TEST_LINEWRAP:
				if(context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getTestLinewrapRule()) {
					sequence_TestLinewrap(context, (TestLinewrap) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.TEST_LINEWRAP_MIN_MAX:
				if(context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getTestLinewrapMinMaxRule()) {
					sequence_TestLinewrapMinMax(context, (TestLinewrapMinMax) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.WRAPPING_DATA_TYPE_TEST:
				if(context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getWrappingDataTypeTestRule()) {
					sequence_WrappingDataTypeTest(context, (WrappingDataTypeTest) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (var=ID (op='=' | op='+=') (val+=INT val+=INT*)?)
	 */
	protected void sequence_Assign(EObject context, Assign semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val1=Datatype1 val2=Datatype2 val3=Datatype3)
	 */
	protected void sequence_Datatypes(EObject context, Datatypes semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.DATATYPES__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.DATATYPES__VAL1));
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.DATATYPES__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.DATATYPES__VAL2));
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.DATATYPES__VAL3) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.DATATYPES__VAL3));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatatypesAccess().getVal1Datatype1ParserRuleCall_1_0(), semanticObject.getVal1());
		feeder.accept(grammarAccess.getDatatypesAccess().getVal2Datatype2ParserRuleCall_3_0(), semanticObject.getVal2());
		feeder.accept(grammarAccess.getDatatypesAccess().getVal3Datatype3ParserRuleCall_4_0(), semanticObject.getVal3());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type+=ID name+=ID)
	 */
	protected void sequence_Decl(EObject context, Decl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val+=Enum1+ val+=Enum1*)
	 */
	protected void sequence_Enumeration(EObject context, Enumeration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=FQN
	 */
	protected void sequence_FqnObj(EObject context, FqnObj semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.FQN_OBJ__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.FQN_OBJ__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFqnObjAccess().getNameFQNParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ref=[FqnObj|FQN]
	 */
	protected void sequence_FqnRef(EObject context, FqnRef semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.FQN_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.FQN_REF__REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFqnRefAccess().getRefFqnObjFQNParserRuleCall_1_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (param+=Param param+=Param*)?)
	 */
	protected void sequence_Meth(EObject context, Meth semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name+=ID type+=ID)
	 */
	protected void sequence_Param(EObject context, Param semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_Space(EObject context, Space semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.SPACE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.SPACE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSpaceAccess().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     idval=ID
	 */
	protected void sequence_SuppressedHiddenSubID(EObject context, SuppressedHiddenSubID semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.SUPPRESSED_HIDDEN_SUB__IDVAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.SUPPRESSED_HIDDEN_SUB__IDVAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSuppressedHiddenSubIDAccess().getIdvalIDTerminalRuleCall_0(), semanticObject.getIdval());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     idval=ID
	 */
	protected void sequence_SuppressedHiddenSubSub(EObject context, SuppressedHiddenSubSub semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.SUPPRESSED_HIDDEN_SUB__IDVAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.SUPPRESSED_HIDDEN_SUB__IDVAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSuppressedHiddenSubSubAccess().getIdvalIDTerminalRuleCall_1_0(), semanticObject.getIdval());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((vals+=SuppressedHiddenSub vals+=SuppressedHiddenSub*)?)
	 */
	protected void sequence_SuppressedHidden(EObject context, SuppressedHidden semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((items+=Line | items+=TestIndentation)* semi?=';'?)
	 */
	protected void sequence_TestIndentation(EObject context, TestIndentation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (items+=Line*)
	 */
	protected void sequence_TestLinewrapMinMax(EObject context, TestLinewrapMinMax semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (items+=Line*)
	 */
	protected void sequence_TestLinewrap(EObject context, TestLinewrap semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     datatype=WrappingDataType
	 */
	protected void sequence_WrappingDataTypeTest(EObject context, WrappingDataTypeTest semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.WRAPPING_DATA_TYPE_TEST__DATATYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.WRAPPING_DATA_TYPE_TEST__DATATYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getWrappingDataTypeTestAccess().getDatatypeWrappingDataTypeParserRuleCall_1_0(), semanticObject.getDatatype());
		feeder.finish();
	}
}
