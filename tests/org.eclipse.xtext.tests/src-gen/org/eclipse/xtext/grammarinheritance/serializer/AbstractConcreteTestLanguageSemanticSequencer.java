package org.eclipse.xtext.grammarinheritance.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammarinheritance.ametamodel.AModel;
import org.eclipse.xtext.grammarinheritance.ametamodel.AType;
import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;
import org.eclipse.xtext.grammarinheritance.foo.AType2;
import org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule;
import org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule;
import org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule;
import org.eclipse.xtext.grammarinheritance.foo.FooPackage;
import org.eclipse.xtext.grammarinheritance.foo.Subrule1;
import org.eclipse.xtext.grammarinheritance.foo.Subrule2;
import org.eclipse.xtext.grammarinheritance.foo.Subrule3;
import org.eclipse.xtext.grammarinheritance.serializer.AbstractTestLanguageSemanticSequencer;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;
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
public class AbstractConcreteTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected ConcreteTestLanguageGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	@Inject
	protected Provider<AbstractTestLanguageSemanticSequencer> superSequencerProvider;
	 
	protected AbstractTestLanguageSemanticSequencer superSequencer; 
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.superSequencer = superSequencerProvider.get();
		this.superSequencer.init(sequencer, sequenceAcceptor, errorAcceptor); 
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AmetamodelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AmetamodelPackage.AMODEL:
				if(context == grammarAccess.getAbstractCallExtendedParserRuleRule()) {
					sequence_AbstractCallExtendedParserRule(context, (AModel) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractCallOverridenParserRuleRule()) {
					sequence_AbstractCallOverridenParserRule(context, (AModel) semanticObject); 
					return; 
				}
				else break;
			case AmetamodelPackage.ATYPE:
				if(context == grammarAccess.getInheritedParserRuleRule()) {
					sequence_InheritedParserRule(context, (AType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOverridableParserRuleRule()) {
					sequence_OverridableParserRule(context, (AType) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == FooPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case FooPackage.ATYPE2:
				if(context == grammarAccess.getOverridableParserRule2Rule() ||
				   context == grammarAccess.getRootRuleRule()) {
					sequence_OverridableParserRule2(context, (AType2) semanticObject); 
					return; 
				}
				else break;
			case FooPackage.CALL_EXTENDED_PARSER_RULE:
				if(context == grammarAccess.getCallExtendedParserRuleRule() ||
				   context == grammarAccess.getRootRuleRule()) {
					sequence_CallExtendedParserRule(context, (CallExtendedParserRule) semanticObject); 
					return; 
				}
				else break;
			case FooPackage.CALL_OVERRIDEN_PARSER_RULE:
				if(context == grammarAccess.getCallOverridenParserRuleRule() ||
				   context == grammarAccess.getRootRuleRule()) {
					sequence_CallOverridenParserRule(context, (CallOverridenParserRule) semanticObject); 
					return; 
				}
				else break;
			case FooPackage.CONCRETE_PARSER_RULE:
				if(context == grammarAccess.getConcreteParserRuleRule() ||
				   context == grammarAccess.getRootRuleRule()) {
					sequence_ConcreteParserRule(context, (ConcreteParserRule) semanticObject); 
					return; 
				}
				else break;
			case FooPackage.SUBRULE1:
				if(context == grammarAccess.getExtendableParserRuleRule() ||
				   context == grammarAccess.getSubrule1Rule()) {
					sequence_Subrule1(context, (Subrule1) semanticObject); 
					return; 
				}
				else break;
			case FooPackage.SUBRULE2:
				if(context == grammarAccess.getExtendableParserRuleRule() ||
				   context == grammarAccess.getSubrule2Rule()) {
					sequence_Subrule2(context, (Subrule2) semanticObject); 
					return; 
				}
				else break;
			case FooPackage.SUBRULE3:
				if(context == grammarAccess.getExtendableParserRuleRule() ||
				   context == grammarAccess.getSubrule3Rule()) {
					sequence_Subrule3(context, (Subrule3) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     elements+=ExtendableParserRule*
	 */
	protected void sequence_AbstractCallExtendedParserRule(EObject context, AModel semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     elements+=OverridableParserRule*
	 */
	protected void sequence_AbstractCallOverridenParserRule(EObject context, AModel semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     call=AbstractCallExtendedParserRule
	 */
	protected void sequence_CallExtendedParserRule(EObject context, CallExtendedParserRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FooPackage.Literals.CALL_EXTENDED_PARSER_RULE__CALL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.CALL_EXTENDED_PARSER_RULE__CALL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCallExtendedParserRuleAccess().getCallAbstractCallExtendedParserRuleParserRuleCall_0(), semanticObject.getCall());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     call=AbstractCallOverridenParserRule
	 */
	protected void sequence_CallOverridenParserRule(EObject context, CallOverridenParserRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FooPackage.Literals.CALL_OVERRIDEN_PARSER_RULE__CALL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.CALL_OVERRIDEN_PARSER_RULE__CALL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCallOverridenParserRuleAccess().getCallAbstractCallOverridenParserRuleParserRuleCall_0(), semanticObject.getCall());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (magicNumber=REAL elements+=InheritedParserRule*)
	 */
	protected void sequence_ConcreteParserRule(EObject context, ConcreteParserRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_InheritedParserRule(EObject context, AType semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID age=INT)
	 */
	protected void sequence_OverridableParserRule2(EObject context, AType2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
			if(transientValues.isValueTransient(semanticObject, FooPackage.Literals.ATYPE2__AGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.ATYPE2__AGE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOverridableParserRule2Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getOverridableParserRule2Access().getAgeINTTerminalRuleCall_3_0(), semanticObject.getAge());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_OverridableParserRule(EObject context, AType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID sub1=ID)
	 */
	protected void sequence_Subrule1(EObject context, Subrule1 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
			if(transientValues.isValueTransient(semanticObject, FooPackage.Literals.SUBRULE1__SUB1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.SUBRULE1__SUB1));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSubrule1Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSubrule1Access().getSub1IDTerminalRuleCall_2_0(), semanticObject.getSub1());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID sub2=STRING)
	 */
	protected void sequence_Subrule2(EObject context, Subrule2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
			if(transientValues.isValueTransient(semanticObject, FooPackage.Literals.SUBRULE2__SUB2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.SUBRULE2__SUB2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSubrule2Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSubrule2Access().getSub2STRINGTerminalRuleCall_2_0(), semanticObject.getSub2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID sub1=INT)
	 */
	protected void sequence_Subrule3(EObject context, Subrule3 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
			if(transientValues.isValueTransient(semanticObject, FooPackage.Literals.SUBRULE3__SUB1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.SUBRULE3__SUB1));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSubrule3Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSubrule3Access().getSub1INTTerminalRuleCall_2_0(), semanticObject.getSub1());
		feeder.finish();
	}
}
