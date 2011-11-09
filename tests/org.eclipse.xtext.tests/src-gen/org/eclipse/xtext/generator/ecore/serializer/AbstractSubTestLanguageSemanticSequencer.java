package org.eclipse.xtext.generator.ecore.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.ecore.serializer.SuperTestLanguageSemanticSequencer;
import org.eclipse.xtext.generator.ecore.services.SubTestLanguageGrammarAccess;
import org.eclipse.xtext.generator.ecore.subPackage.AnotherSuperMain;
import org.eclipse.xtext.generator.ecore.subPackage.SubMain;
import org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage;
import org.eclipse.xtext.generator.ecore.superPackage.SuperMain;
import org.eclipse.xtext.generator.ecore.superPackage.SuperPackagePackage;
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
public class AbstractSubTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected SubTestLanguageGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	@Inject
	protected Provider<SuperTestLanguageSemanticSequencer> superSequencerProvider;
	 
	protected SuperTestLanguageSemanticSequencer superSequencer; 
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.superSequencer = superSequencerProvider.get();
		this.superSequencer.init(sequencer, sequenceAcceptor, errorAcceptor); 
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == SubPackagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SubPackagePackage.ANOTHER_SUPER_MAIN:
				if(context == grammarAccess.getAnotherSuperMainRule()) {
					sequence_AnotherSuperMain(context, (AnotherSuperMain) semanticObject); 
					return; 
				}
				else break;
			case SubPackagePackage.SUB_MAIN:
				if(context == grammarAccess.getSubMainRule()) {
					sequence_SubMain(context, (SubMain) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == SuperPackagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SuperPackagePackage.SUPER_MAIN:
				if(context == grammarAccess.getSuperMainRule()) {
					sequence_SuperMain(context, (SuperMain) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_AnotherSuperMain(EObject context, AnotherSuperMain semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SuperPackagePackage.Literals.ANOTHER_SUPER_MAIN__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SuperPackagePackage.Literals.ANOTHER_SUPER_MAIN__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAnotherSuperMainAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (superMains+=SuperMain another=AnotherSuperMain?)
	 */
	protected void sequence_SubMain(EObject context, SubMain semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_SuperMain(EObject context, SuperMain semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
}
