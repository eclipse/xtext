package org.eclipse.xtext.resource.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Bar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model;
import org.eclipse.xtext.resource.services.EObjectAtOffsetTestLanguageGrammarAccess;
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
public class AbstractEObjectAtOffsetTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected EObjectAtOffsetTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == EObjectAtOffsetTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EObjectAtOffsetTestLanguagePackage.BAR:
				if(context == grammarAccess.getAbstractBarAccess().getFooBarBarAction_3_0() ||
				   context == grammarAccess.getBarRule()) {
					sequence_Bar(context, (Bar) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractBarRule()) {
					sequence_Bar(context, (Bar) semanticObject); 
					return; 
				}
				else break;
			case EObjectAtOffsetTestLanguagePackage.FOO:
				if(context == grammarAccess.getFooRule()) {
					sequence_Foo(context, (Foo) semanticObject); 
					return; 
				}
				else break;
			case EObjectAtOffsetTestLanguagePackage.FOO_BAR:
				if(context == grammarAccess.getAbstractBarRule()) {
					sequence_AbstractBar(context, (FooBar) semanticObject); 
					return; 
				}
				else break;
			case EObjectAtOffsetTestLanguagePackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (bar=AbstractBar_FooBar_3_0 foo+=[Foo|QualifiedNameWithOtherDelim] foo+=[Foo|QualifiedNameWithOtherDelim]?)
	 */
	protected void sequence_AbstractBar(EObject context, FooBar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID foo+=[Foo|QualifiedNameWithOtherDelim] foo+=[Foo|QualifiedNameWithOtherDelim]* foo+=[Foo|QualifiedNameWithOtherDelim]?)
	 */
	protected void sequence_Bar(EObject context, Bar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=QualifiedNameWithOtherDelim
	 */
	protected void sequence_Foo(EObject context, Foo semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EObjectAtOffsetTestLanguagePackage.Literals.FOO__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EObjectAtOffsetTestLanguagePackage.Literals.FOO__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFooAccess().getNameQualifiedNameWithOtherDelimParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (foos+=Foo | bars+=AbstractBar)*
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
